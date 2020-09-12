package com.hobbit.core.cloud.http;

import java.io.IOException;
import lombok.AllArgsConstructor;
import com.hobbit.core.cloud.hystrix.BladeHttpHeadersContextHolder;
import com.hobbit.core.cloud.hystrix.BladeHystrixAccountGetter;
import com.hobbit.core.cloud.props.BladeHystrixHeadersProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.Nullable;

/**
 * RestTemplateHeaderInterceptor 传递Request header
 *
 * @author L.cm
 */
@AllArgsConstructor
public class RestTemplateHeaderInterceptor implements ClientHttpRequestInterceptor {

  @Nullable
  private final BladeHystrixAccountGetter accountGetter;
  private final BladeHystrixHeadersProperties properties;

  @Override
  public ClientHttpResponse intercept(
      HttpRequest request, byte[] bytes,
      ClientHttpRequestExecution execution) throws IOException {
    HttpHeaders headers = BladeHttpHeadersContextHolder.get();
    // 考虑2中情况 1. RestTemplate 不是用 hystrix 2. 使用 hystrix
    if (headers == null) {
      headers = BladeHttpHeadersContextHolder.toHeaders(accountGetter, properties);
    }
    if (headers != null && !headers.isEmpty()) {
      HttpHeaders httpHeaders = request.getHeaders();
      headers.forEach((key, values) -> {
        values.forEach(value -> httpHeaders.add(key, value));
      });
    }
    return execution.execute(request, bytes);
  }
}
