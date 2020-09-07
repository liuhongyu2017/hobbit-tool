package org.springblade.core.boot.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springblade.core.mp.plugins.SqlLogInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatisplus 配置
 *
 * @author Chill
 */
@Configuration
@MapperScan("org.springblade.**.mapper.**")
public class MybatisPlusConfiguration {

  @Bean
  @ConditionalOnMissingBean(PaginationInterceptor.class)
  public PaginationInterceptor paginationInterceptor() {
    return new PaginationInterceptor();
  }

  /**
   * sql 日志
   *
   * @return SqlLogInterceptor
   */
  @Bean
  @ConditionalOnProperty(value = "blade.mybatis-plus.sql-log", matchIfMissing = true)
  public SqlLogInterceptor sqlLogInterceptor() {
    return new SqlLogInterceptor();
  }

}

