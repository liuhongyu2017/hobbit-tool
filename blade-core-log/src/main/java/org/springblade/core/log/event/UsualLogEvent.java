package org.springblade.core.log.event;

import java.util.Map;
import org.springframework.context.ApplicationEvent;

/**
 * 系统日志事件
 *
 * @author Chill
 */
public class UsualLogEvent extends ApplicationEvent {

  public UsualLogEvent(Map<String, Object> source) {
    super(source);
  }

}
