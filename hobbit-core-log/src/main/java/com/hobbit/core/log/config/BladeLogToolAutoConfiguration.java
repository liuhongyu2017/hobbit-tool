package com.hobbit.core.log.config;

import lombok.AllArgsConstructor;
import com.hobbit.core.launch.props.MyProperties;
import com.hobbit.core.launch.server.ServerInfo;
import com.hobbit.core.log.aspect.ApiLogAspect;
import com.hobbit.core.log.event.ApiLogListener;
import com.hobbit.core.log.event.ErrorLogListener;
import com.hobbit.core.log.event.UsualLogListener;
import com.hobbit.core.log.feign.ILogClient;
import com.hobbit.core.log.logger.BladeLogger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 日志工具自动配置
 *
 * @author Chill
 */
@Configuration
@AllArgsConstructor
@ConditionalOnWebApplication
public class BladeLogToolAutoConfiguration {

  private final ILogClient logService;
  private final ServerInfo serverInfo;
  private final MyProperties myProperties;

  @Bean
  public ApiLogAspect apiLogAspect() {
    return new ApiLogAspect();
  }

  @Bean
  public BladeLogger bladeLogger() {
    return new BladeLogger();
  }

  @Bean
  public ApiLogListener apiLogListener() {
    return new ApiLogListener(logService, serverInfo, myProperties);
  }

  @Bean
  public ErrorLogListener errorEventListener() {
    return new ErrorLogListener(logService, serverInfo, myProperties);
  }

  @Bean
  public UsualLogListener bladeEventListener() {
    return new UsualLogListener(logService, serverInfo, myProperties);
  }

}
