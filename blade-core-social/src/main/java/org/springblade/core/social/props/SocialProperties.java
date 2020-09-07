package org.springblade.core.social.props;

import com.google.common.collect.Maps;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.config.AuthDefaultSource;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * SocialProperties
 *
 * @author Chill
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "social")
public class SocialProperties {

  /**
   * 启用
   */
  private Boolean enabled = false;

  /**
   * 域名地址
   */
  private String domain;

  /**
   * 类型
   */
  private Map<AuthDefaultSource, AuthConfig> oauth = Maps.newHashMap();

  /**
   * 别名
   */
  private Map<String, String> alias = Maps.newHashMap();

}
