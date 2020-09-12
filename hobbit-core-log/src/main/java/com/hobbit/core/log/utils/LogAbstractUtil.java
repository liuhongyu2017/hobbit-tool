package com.hobbit.core.log.utils;

import javax.servlet.http.HttpServletRequest;
import com.hobbit.core.launch.props.MyProperties;
import com.hobbit.core.launch.server.ServerInfo;
import com.hobbit.core.log.model.LogAbstract;
import com.hobbit.core.secure.utils.SecureUtil;
import com.hobbit.core.tool.utils.DateUtil;
import com.hobbit.core.tool.utils.ObjectUtil;
import com.hobbit.core.tool.utils.StringPool;
import com.hobbit.core.tool.utils.UrlUtil;
import com.hobbit.core.tool.utils.WebUtil;

/**
 * Log 相关工具
 *
 * @author Chill
 */
public class LogAbstractUtil {

  /**
   * 向log中添加补齐request的信息
   *
   * @param request     请求
   * @param logAbstract 日志基础类
   */
  public static void addRequestInfoToLog(HttpServletRequest request, LogAbstract logAbstract) {
    if (ObjectUtil.isNotEmpty(request)) {
      logAbstract.setRemoteIp(WebUtil.getIP(request));
      logAbstract.setUserAgent(request.getHeader(WebUtil.USER_AGENT_HEADER));
      logAbstract.setRequestUri(UrlUtil.getPath(request.getRequestURI()));
      logAbstract.setMethod(request.getMethod());
      logAbstract.setParams(WebUtil.getRequestParamString(request));
      logAbstract.setCreateBy(SecureUtil.getUserAccount(request));
    }
  }

  /**
   * 向log中添加补齐其他的信息（eg：blade、server等）
   *
   * @param logAbstract     日志基础类
   * @param myProperties 配置信息
   * @param serverInfo      服务信息
   */
  public static void addOtherInfoToLog(LogAbstract logAbstract, MyProperties myProperties,
      ServerInfo serverInfo) {
    logAbstract.setServiceId(myProperties.getName());
    logAbstract.setServerHost(serverInfo.getHostName());
    logAbstract.setServerIp(serverInfo.getIpWithPort());
    logAbstract.setEnv(myProperties.getEnv());
    logAbstract.setCreateTime(DateUtil.now());

    //这里判断一下params为null的情况，否则blade-log服务在解析该字段的时候，可能会报出NPE
    if (logAbstract.getParams() == null) {
      logAbstract.setParams(StringPool.EMPTY);
    }
  }
}
