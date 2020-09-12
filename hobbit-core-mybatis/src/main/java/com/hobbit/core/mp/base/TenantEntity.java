package com.hobbit.core.mp.base;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 租户基础实体类
 *
 * @author Chill
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TenantEntity extends BaseEntity {

  /**
   * 租户ID
   */
  @ApiModelProperty(value = "租户ID")
  private String tenantId;

}
