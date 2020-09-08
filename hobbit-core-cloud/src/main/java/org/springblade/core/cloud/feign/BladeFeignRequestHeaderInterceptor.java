package com.hobbit.core.cloud.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import com.hobbit.core.cloud.hystrix.BladeHttpHeadersContextHolder;
import org.springframework.http.HttpHeaders;

/**
 * feign 传递Request header
 *
 * <p>
 *     https://blog.csdn.net/u014519194/article/details/77160958
 *     http://tietang.wang/2016/02/25/hystrix/Hystrix%E5%8F%82%E6%95%B0%E8%AF%A6%E8%A7%A3/
 *     https://github.com/Netflix/Hystrix/issues/92#issuecomment-260548068
 * </p>
 *
 * @author L.cm
 */
public class BladeFeignRequestHeaderInterceptor implements RequestInterceptor {

  @Override
  public void apply(RequestTemplate requestTemplate) {
    HttpHeaders headers = BladeHttpHeadersContextHolder.get();
    if (headers != null && !headers.isEmpty()) {
      headers.forEach((key, values) -> {
        values.forEach(value -> requestTemplate.header(key, value));
      });
    }
  }

}
