package com.hobbit.core.cloud.hystrix;

import com.netflix.hystrix.Hystrix;
import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisher;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesStrategy;
import javax.annotation.PostConstruct;
import com.hobbit.core.cloud.props.BladeHystrixHeadersProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

/**
 * Hystrix 配置
 *
 * @author L.cm
 */
@Configuration
@ConditionalOnClass(Hystrix.class)
@EnableConfigurationProperties(BladeHystrixHeadersProperties.class)
public class BladeHystrixAutoConfiguration {

  @Nullable
  @Autowired(required = false)
  private HystrixConcurrencyStrategy existingConcurrencyStrategy;
  @Nullable
  @Autowired(required = false)
  private BladeHystrixAccountGetter accountGetter;
  @Autowired
  private BladeHystrixHeadersProperties properties;

  @PostConstruct
  public void init() {
    // Keeps references of existing Hystrix plugins.
    HystrixEventNotifier eventNotifier = HystrixPlugins.getInstance().getEventNotifier();
    HystrixMetricsPublisher metricsPublisher = HystrixPlugins.getInstance().getMetricsPublisher();
    HystrixPropertiesStrategy propertiesStrategy = HystrixPlugins.getInstance()
        .getPropertiesStrategy();
    HystrixCommandExecutionHook commandExecutionHook = HystrixPlugins.getInstance()
        .getCommandExecutionHook();

    HystrixPlugins.reset();

    // Registers existing plugins excepts the Concurrent Strategy plugin.
    HystrixConcurrencyStrategy strategy = new BladeHystrixConcurrencyStrategy(
        existingConcurrencyStrategy, accountGetter, properties);
    HystrixPlugins.getInstance().registerConcurrencyStrategy(strategy);
    HystrixPlugins.getInstance().registerEventNotifier(eventNotifier);
    HystrixPlugins.getInstance().registerMetricsPublisher(metricsPublisher);
    HystrixPlugins.getInstance().registerPropertiesStrategy(propertiesStrategy);
    HystrixPlugins.getInstance().registerCommandExecutionHook(commandExecutionHook);
  }

}
