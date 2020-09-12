package com.hobbit.core.cloud.version;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * url版本号处理
 *
 * 参考：https://gitee.com/lianqu1990/spring-boot-starter-version-mapping
 *
 * @author L.cm
 */
@Configuration
@ConditionalOnWebApplication
public class VersionMappingAutoConfiguration {

  @Bean
  public WebMvcRegistrations bladeWebMvcRegistrations() {
    return new BladeWebMvcRegistrations();
  }
}
