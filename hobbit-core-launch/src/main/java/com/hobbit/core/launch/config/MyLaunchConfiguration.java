package com.hobbit.core.launch.config;

import lombok.AllArgsConstructor;
import com.hobbit.core.launch.props.MyProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * 配置类
 *
 * @author lhy
 * @version 1.0.0 2020/09/07
 */
@Configuration
@AllArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
@EnableConfigurationProperties({
    MyProperties.class
})
public class MyLaunchConfiguration {

}
