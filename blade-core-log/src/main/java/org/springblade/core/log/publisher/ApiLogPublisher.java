package org.springblade.core.log.publisher;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.log.constant.EventConstant;
import org.springblade.core.log.event.ApiLogEvent;
import org.springblade.core.log.model.LogApi;
import org.springblade.core.log.utils.LogAbstractUtil;
import org.springblade.core.tool.constant.BladeConstant;
import org.springblade.core.tool.utils.SpringUtil;
import org.springblade.core.tool.utils.WebUtil;

/**
 * API日志信息事件发送
 *
 * @author Chill
 */
public class ApiLogPublisher {

  public static void publishEvent(String methodName, String methodClass, ApiLog apiLog, long time) {
    HttpServletRequest request = WebUtil.getRequest();
    LogApi logApi = new LogApi();
    logApi.setType(BladeConstant.LOG_NORMAL_TYPE);
    logApi.setTitle(apiLog.value());
    logApi.setTime(String.valueOf(time));
    logApi.setMethodClass(methodClass);
    logApi.setMethodName(methodName);

    LogAbstractUtil.addRequestInfoToLog(request, logApi);
    Map<String, Object> event = new HashMap<>(16);
    event.put(EventConstant.EVENT_LOG, logApi);
    SpringUtil.publishEvent(new ApiLogEvent(event));
  }

}
