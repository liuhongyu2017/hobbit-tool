package com.hobbit.core.boot.resolver;

import com.hobbit.core.tool.utils.Func;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author lhy
 * @version 1.0 2020/9/11
 */
@Slf4j
public class SystemArgumentResolver implements HandlerMethodArgumentResolver {

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return Objects.equals(parameter.getParameterType(), Integer.class)
        && Objects.equals(parameter.getParameterName(), "sysId");
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
      NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    String sysId = webRequest.getHeader("sysId");
    return Func.isBlank(sysId) ? Integer.MAX_VALUE : Func.toInt(sysId);
  }
}
