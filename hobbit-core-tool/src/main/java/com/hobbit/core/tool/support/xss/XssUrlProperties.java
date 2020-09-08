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
@ConfigurationProperties("blade.xss.url")
public class XssUrlProperties {

  private final List<String> excludePatterns = new ArrayList<>();

}
