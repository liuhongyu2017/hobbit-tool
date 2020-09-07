package org.springblade.core.log.publisher;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springblade.core.log.constant.EventConstant;
import org.springblade.core.log.event.ErrorLogEvent;
import org.springblade.core.log.model.LogError;
import org.springblade.core.log.utils.LogAbstractUtil;
import org.springblade.core.tool.utils.Exceptions;
import org.springblade.core.tool.utils.Func;
import org.springblade.core.tool.utils.SpringUtil;
import org.springblade.core.tool.utils.WebUtil;

/**
 * 异常信息事件发送
 *
 * @author Chill
 */
public class ErrorLogPublisher {

  public static void publishEvent(Throwable error, String requestUri) {
    HttpServletRequest request = WebUtil.getRequest();
    LogError logError = new LogError();
    logError.setRequestUri(requestUri);
    if (Func.isNotEmpty(error)) {
      logError.setStackTrace(Exceptions.getStackTraceAsString(error));
      logError.setExceptionName(error.getClass().getName());
      logError.setMessage(error.getMessage());
      StackTraceElement[] elements = error.getStackTrace();
      if (Func.isNotEmpty(elements)) {
        StackTraceElement element = elements[0];
        logError.setMethodName(element.getMethodName());
        logError.setMethodClass(element.getClassName());
        logError.setFileName(element.getFileName());
        logError.setLineNumber(element.getLineNumber());
      }
    }
    LogAbstractUtil.addRequestInfoToLog(request, logError);

    Map<String, Object> event = new HashMap<>(16);
    event.put(EventConstant.EVENT_LOG, logError);
    event.put(EventConstant.EVENT_REQUEST, request);
    SpringUtil.publishEvent(new ErrorLogEvent(event));
  }

}
