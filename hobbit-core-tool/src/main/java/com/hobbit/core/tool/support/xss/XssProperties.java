package com.hobbit.core.tool.support.xss;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Xss配置类
 *
 * @author Chill
 */
@Data
@ConfigurationProperties("blade.xss")
public class XssProperties {

  /**
   * 开启xss
   */
  private Boolean enabled = true;

  /**
   * 放行url
   */
  private List<String> skipUrl = new ArrayList<>();

}
