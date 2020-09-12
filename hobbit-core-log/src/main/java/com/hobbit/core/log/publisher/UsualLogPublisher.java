package com.hobbit.core.log.publisher;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.hobbit.core.log.constant.EventConstant;
import com.hobbit.core.log.event.UsualLogEvent;
import com.hobbit.core.log.model.LogUsual;
import com.hobbit.core.log.utils.LogAbstractUtil;
import com.hobbit.core.tool.utils.SpringUtil;
import com.hobbit.core.tool.utils.WebUtil;

/**
 * BLADE日志信息事件发送
 *
 * @author Chill
 */
public class UsualLogPublisher {

  public static void publishEvent(String level, String id, String data) {
    HttpServletRequest request = WebUtil.getRequest();
    LogUsual logUsual = new LogUsual();
    logUsual.setLogLevel(level);
    logUsual.setLogId(id);
    logUsual.setLogData(data);

    LogAbstractUtil.addRequestInfoToLog(request, logUsual);
    Map<String, Object> event = new HashMap<>(16);
    event.put(EventConstant.EVENT_LOG, logUsual);
    event.put(EventConstant.EVENT_REQUEST, request);
    SpringUtil.publishEvent(new UsualLogEvent(event));
  }

}
