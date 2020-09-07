package org.springblade.core.cloud.hystrix;


import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;

/**
 * Blade 用户信息获取器，用于请求头传递
 *
 * @author L.cm
 */
public interface BladeHystrixAccountGetter {

  /**
   * 账号信息获取器
   *
   * @param request HttpServletRequest
   * @return account 信息
   */
  @Nullable
  String get(HttpServletRequest request);
}
