package org.springblade.core.secure.props;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * secure放行额外配置
 *
 * @author Chill
 */
@Data
@ConfigurationProperties("blade.secure")
public class BladeSecureProperties {

  private final List<ClientSecure> client = new ArrayList<>();

  private final List<String> skipUrl = new ArrayList<>();

}
