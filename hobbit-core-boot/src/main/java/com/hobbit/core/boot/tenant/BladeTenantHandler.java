package com.hobbit.core.boot.tenant;

import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import com.hobbit.core.secure.utils.SecureUtil;
import com.hobbit.core.tool.utils.Func;
import com.hobbit.core.tool.utils.StringUtil;

/**
 * 租户信息处理器
 *
 * @author Chill
 */
@Slf4j
@AllArgsConstructor
public class BladeTenantHandler implements TenantHandler {

  private final BladeTenantProperties properties;

  /**
   * 获取租户ID
   *
   * @return 租户ID
   */
  @Override
  public Expression getTenantId(boolean where) {
    return new StringValue(Func.toStr(SecureUtil.getTenantId(), TenantConstant.DEFAULT_TENANT_ID));
  }

  /**
   * 获取租户字段名称
   *
   * @return 租户字段名称
   */
  @Override
  public String getTenantIdColumn() {
    return properties.getColumn();
  }

  /**
   * 过滤租户表
   *
   * @param tableName 表名
   * @return 是否进行过滤
   */
  @Override
  public boolean doTableFilter(String tableName) {
    return !(
        (
            (properties.getTables().size() > 0 && properties.getTables().contains(tableName))
                || properties.getBladeTables().contains(tableName)
        )
            && StringUtil.isNotBlank(SecureUtil.getTenantId())
    );
  }
}
