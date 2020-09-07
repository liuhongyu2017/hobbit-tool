package org.springblade.core.cloud.version;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * url版本号处理
 *
 * @author L.cm
 */
public class BladeWebMvcRegistrations implements WebMvcRegistrations {

  @Override
  public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
    return new BladeRequestMappingHandlerMapping();
  }

  @Override
  public RequestMappingHandlerAdapter getRequestMappingHandlerAdapter() {
    return null;
  }

  @Override
  public ExceptionHandlerExceptionResolver getExceptionHandlerExceptionResolver() {
    return null;
  }
}
