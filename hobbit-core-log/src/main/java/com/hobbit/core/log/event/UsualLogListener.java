package com.hobbit.core.log.event;


import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.hobbit.core.launch.props.MyProperties;
import com.hobbit.core.launch.server.ServerInfo;
import com.hobbit.core.log.constant.EventConstant;
import com.hobbit.core.log.feign.ILogClient;
import com.hobbit.core.log.model.LogUsual;
import com.hobbit.core.log.utils.LogAbstractUtil;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * 异步监听日志事件
 *
 * @author Chill
 */
@Slf4j
@AllArgsConstructor
public class UsualLogListener {

  private final ILogClient logService;
  private final ServerInfo serverInfo;
  private final MyProperties myProperties;

  @Async
  @Order
  @EventListener(UsualLogEvent.class)
  public void saveUsualLog(UsualLogEvent event) {
    Map<String, Object> source = (Map<String, Object>) event.getSource();
    LogUsual logUsual = (LogUsual) source.get(EventConstant.EVENT_LOG);
    LogAbstractUtil.addOtherInfoToLog(logUsual, myProperties, serverInfo);
    logService.saveUsualLog(logUsual);
  }

}
