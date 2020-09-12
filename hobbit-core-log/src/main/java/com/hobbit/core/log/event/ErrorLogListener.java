package com.hobbit.core.log.event;


import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.hobbit.core.launch.props.MyProperties;
import com.hobbit.core.launch.server.ServerInfo;
import com.hobbit.core.log.constant.EventConstant;
import com.hobbit.core.log.feign.ILogClient;
import com.hobbit.core.log.model.LogError;
import com.hobbit.core.log.utils.LogAbstractUtil;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * 异步监听错误日志事件
 *
 * @author Chill
 */
@Slf4j
@AllArgsConstructor
public class ErrorLogListener {

  private final ILogClient logService;
  private final ServerInfo serverInfo;
  private final MyProperties myProperties;

  @Async
  @Order
  @EventListener(ErrorLogEvent.class)
  public void saveErrorLog(ErrorLogEvent event) {
    Map<String, Object> source = (Map<String, Object>) event.getSource();
    LogError logError = (LogError) source.get(EventConstant.EVENT_LOG);
    LogAbstractUtil.addOtherInfoToLog(logError, myProperties, serverInfo);
    logService.saveErrorLog(logError);
  }

}
