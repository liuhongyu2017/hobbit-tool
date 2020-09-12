package com.hobbit.core.cloud.props;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.lang.Nullable;

/**
 * Hystrix Headers 配置
 *
 * @author L.cm
 */
@Getter
@Setter
@RefreshScope
@ConfigurationProperties("blade.hystrix.headers")
public class BladeHystrixHeadersProperties {

  /**
   * 用于 聚合层 向调用层传递用户信息 的请求头，默认：x-blade-account
   */
  private String account = "X-Blade-Account";

  /**
   * RestTemplate 和 Fegin 透传到下层的 Headers 名称表达式
   */
  @Nullable
  private String pattern = "Blade*";

  /**
   * RestTemplate 和 Fegin 透传到下层的 Headers 名称列表
   */
  private List<String> allowed = Arrays
      .asList("X-Real-IP", "x-forwarded-for", "authorization", "blade-auth", "Authorization",
          "Blade-Auth");

}
