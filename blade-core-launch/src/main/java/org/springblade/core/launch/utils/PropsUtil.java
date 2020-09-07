package org.springblade.core.launch.utils;

import java.util.Properties;
import org.springframework.util.StringUtils;

/**
 * 配置工具类
 *
 * @author Chill
 */
public class PropsUtil {

  /**
   * 设置配置值，已存在则跳过
   *
   * @param props property
   * @param key   key
   * @param value value
   */
  public static void setProperty(Properties props, String key, String value) {
    if (StringUtils.isEmpty(props.getProperty(key))) {
      props.setProperty(key, value);
    }
  }

}
