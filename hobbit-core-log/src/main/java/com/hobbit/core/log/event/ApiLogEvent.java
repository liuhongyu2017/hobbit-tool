package com.hobbit.core.log.event;

import java.util.Map;
import org.springframework.context.ApplicationEvent;

/**
 * 系统日志事件
 *
 * @author Chill
 */
public class ApiLogEvent extends ApplicationEvent {

  public ApiLogEvent(Map<String, Object> source) {
    super(source);
  }

}
