package org.springblade.core.tool.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.jackson.MappingApiJackson2HttpMessageConverter;
import org.springblade.core.tool.utils.Charsets;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.ResourceRegionHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 消息配置类
 *
 * @author Chill
 */
@Configuration
@AllArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MessageConfiguration implements WebMvcConfigurer {

  private final ObjectMapper objectMapper;

  /**
   * 使用 JACKSON 作为JSON MessageConverter
   */
  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.removeIf(x -> x instanceof StringHttpMessageConverter
        || x instanceof AbstractJackson2HttpMessageConverter);
    converters.add(new StringHttpMessageConverter(Charsets.UTF_8));
    converters.add(new ByteArrayHttpMessageConverter());
    converters.add(new ResourceHttpMessageConverter());
    converters.add(new ResourceRegionHttpMessageConverter());
    converters.add(new MappingApiJackson2HttpMessageConverter(objectMapper));
  }

}
