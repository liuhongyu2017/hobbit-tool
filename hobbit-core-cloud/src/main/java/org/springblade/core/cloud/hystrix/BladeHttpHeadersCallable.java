package com.hobbit.core.cloud.hystrix;

import java.util.concurrent.Callable;
import com.hobbit.core.cloud.props.BladeHystrixHeadersProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.Nullable;

/**
 * HttpHeaders hystrix Callable
 *
 * @param <V> 泛型标记
 * @author L.cm
 */
public class BladeHttpHeadersCallable<V> implements Callable<V> {

  private final Callable<V> delegate;
  @Nullable
  private HttpHeaders httpHeaders;

  public BladeHttpHeadersCallable(Callable<V> delegate,
      @Nullable BladeHystrixAccountGetter accountGetter,
      BladeHystrixHeadersProperties properties) {
    this.delegate = delegate;
    this.httpHeaders = BladeHttpHeadersContextHolder.toHeaders(accountGetter, properties);
  }

  @Override
  public V call() throws Exception {
    if (httpHeaders == null) {
      return delegate.call();
    }
    try {
      BladeHttpHeadersContextHolder.set(httpHeaders);
      return delegate.call();
    } finally {
      BladeHttpHeadersContextHolder.remove();
      httpHeaders.clear();
      httpHeaders = null;
    }
  }
}
