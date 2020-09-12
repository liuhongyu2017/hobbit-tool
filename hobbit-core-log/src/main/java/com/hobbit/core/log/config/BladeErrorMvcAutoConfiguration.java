package com.hobbit.core.log.config;


import javax.servlet.Servlet;
import lombok.AllArgsConstructor;
import com.hobbit.core.log.error.BladeErrorAttributes;
import com.hobbit.core.log.error.BladeErrorController;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 统一异常处理
 *
 * @author Chill
 */
@Configuration
@AllArgsConstructor
@ConditionalOnWebApplication
@AutoConfigureBefore(ErrorMvcAutoConfiguration.class)
@ConditionalOnClass({Servlet.class, DispatcherServlet.class})
public class BladeErrorMvcAutoConfiguration {

  private final ServerProperties serverProperties;

  @Bean
  @ConditionalOnMissingBean(value = ErrorAttributes.class, search = SearchStrategy.CURRENT)
  public DefaultErrorAttributes errorAttributes() {
    return new BladeErrorAttributes();
  }

  @Bean
  @ConditionalOnMissingBean(value = ErrorController.class, search = SearchStrategy.CURRENT)
  public BasicErrorController basicErrorController(ErrorAttributes errorAttributes) {
    return new BladeErrorController(errorAttributes, serverProperties.getError());
  }

}
