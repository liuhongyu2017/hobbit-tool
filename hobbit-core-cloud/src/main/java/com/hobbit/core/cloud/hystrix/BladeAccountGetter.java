package com.hobbit.core.cloud.hystrix;

import javax.servlet.http.HttpServletRequest;
import com.hobbit.core.secure.BladeUser;
import com.hobbit.core.secure.utils.SecureUtil;
import com.hobbit.core.tool.utils.Charsets;
import com.hobbit.core.tool.utils.UrlUtil;

/**
 * 用户信息获取器
 *
 * @author Chill
 */
public class BladeAccountGetter implements BladeHystrixAccountGetter {

  @Override
  public String get(HttpServletRequest request) {
    BladeUser account = SecureUtil.getUser();
    if (account == null) {
      return null;
    }
    // 增加用户头, 123[admin]
    String xAccount = String.format("%s[%s]", account.getUserId(), account.getUserName());
    return UrlUtil.encodeURL(xAccount, Charsets.UTF_8);
  }

}
