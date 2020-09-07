package org.springblade.core.log.event;


import java.util.Map;
import org.springframework.context.ApplicationEvent;

/**
 * 错误日志事件
 *
 * @author Chill
 */
public class ErrorLogEvent extends ApplicationEvent {

  public ErrorLogEvent(Map<String, Object> source) {
    super(source);
  }

}
