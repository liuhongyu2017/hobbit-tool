package com.hobbit.core.boot.tenant;

import com.hobbit.core.tool.utils.RandomType;
import com.hobbit.core.tool.utils.StringUtil;

/**
 * blade租户id生成器
 *
 * @author Chill
 */
public class BladeTenantId implements TenantId {

  @Override
  public String generate() {
    return StringUtil.random(6, RandomType.INT);
  }
}
