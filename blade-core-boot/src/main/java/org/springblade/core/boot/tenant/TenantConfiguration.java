package org.springblade.core.boot.tenant;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springblade.core.boot.config.MybatisPlusConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 多租户配置类
 *
 * @author Chill
 */
@Configuration
@AllArgsConstructor
@AutoConfigureBefore(MybatisPlusConfiguration.class)
@EnableConfigurationProperties(BladeTenantProperties.class)
public class TenantConfiguration {

  /**
   * 多租户配置类
   */
  private final BladeTenantProperties properties;

  /**
   * 自定义租户处理器
   *
   * @return TenantHandler
   */
  @Bean
  @ConditionalOnMissingBean(TenantHandler.class)
  public TenantHandler bladeTenantHandler() {
    return new BladeTenantHandler(properties);
  }

  /**
   * 自定义租户id生成器
   *
   * @return TenantId
   */
  @Bean
  @ConditionalOnMissingBean(TenantId.class)
  public TenantId tenantId() {
    return new BladeTenantId();
  }

  /**
   * 分页插件
   *
   * @param tenantHandler 自定义租户处理器
   * @return PaginationInterceptor
   */
  @Bean
  public PaginationInterceptor paginationInterceptor(TenantHandler tenantHandler) {
    PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
    List<ISqlParser> sqlParserList = new ArrayList<>();
    TenantSqlParser tenantSqlParser = new TenantSqlParser();
    tenantSqlParser.setTenantHandler(tenantHandler);
    sqlParserList.add(tenantSqlParser);
    paginationInterceptor.setSqlParserList(sqlParserList);
    return paginationInterceptor;
  }

}
