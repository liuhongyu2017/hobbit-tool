package com.hobbit.core.secure.interceptor;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.hobbit.core.secure.BladeUser;
import com.hobbit.core.secure.utils.SecureUtil;
import com.hobbit.core.tool.api.R;
import com.hobbit.core.tool.api.ResultCode;
import com.hobbit.core.tool.constant.BladeConstant;
import com.hobbit.core.tool.jackson.JsonUtil;
import com.hobbit.core.tool.utils.StringUtil;
import com.hobbit.core.tool.utils.WebUtil;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 客户端校验
 *
 * @author Chill
 */
@Slf4j
@AllArgsConstructor
public class ClientInterceptor extends HandlerInterceptorAdapter {

  private final String clientId;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
      Object handler) {
    BladeUser user = SecureUtil.getUser();
    if (user != null && StringUtil.equals(clientId, SecureUtil.getClientIdFromHeader())
        && StringUtil.equals(clientId, user.getClientId())) {
      return true;
    } else {
      log.warn("客户端认证失败，请求接口：{}，请求IP：{}，请求参数：{}", request.getRequestURI(), WebUtil.getIP(request),
          JsonUtil.toJson(request.getParameterMap()));
      R result = R.fail(ResultCode.UN_AUTHORIZED);
      response.setHeader(BladeConstant.CONTENT_TYPE_NAME, MediaType.APPLICATION_JSON_VALUE);
      response.setCharacterEncoding(BladeConstant.UTF_8);
      response.setStatus(HttpServletResponse.SC_OK);
      try {
        response.getWriter().write(Objects.requireNonNull(JsonUtil.toJson(result)));
      } catch (IOException ex) {
        log.error(ex.getMessage());
      }
      return false;
    }
  }

}
