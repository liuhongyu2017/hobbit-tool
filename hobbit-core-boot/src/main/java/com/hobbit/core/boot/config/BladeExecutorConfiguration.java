package com.hobbit.core.boot.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import lombok.AllArgsConstructor;
import com.hobbit.core.boot.props.BladeAsyncProperties;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 异步处理
 *
 * @author Chill
 */
@Configuration
@EnableAsync
@EnableScheduling
@AllArgsConstructor
@EnableConfigurationProperties({
    BladeAsyncProperties.class
})
public class BladeExecutorConfiguration extends AsyncConfigurerSupport {

  private final BladeAsyncProperties bladeAsyncProperties;

  @Override
  @Bean(name = "taskExecutor")
  public Executor getAsyncExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(bladeAsyncProperties.getCorePoolSize());
    executor.setMaxPoolSize(bladeAsyncProperties.getMaxPoolSize());
    executor.setQueueCapacity(bladeAsyncProperties.getQueueCapacity());
    executor.setKeepAliveSeconds(bladeAsyncProperties.getKeepAliveSeconds());
    executor.setThreadNamePrefix("async-executor-");
    executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    return executor;
  }

  @Override
  public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
    return new SimpleAsyncUncaughtExceptionHandler();
  }

}
