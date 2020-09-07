package org.springblade.core.boot.tenant;

import org.springblade.core.tool.utils.RandomType;
import org.springblade.core.tool.utils.StringUtil;

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
