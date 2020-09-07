package org.springblade.core.mp.base;


import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springblade.core.tool.utils.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 基础实体类
 *
 * @author Chill
 */
@Data
public class BaseEntity implements Serializable {

  /**
   * 创建人
   */
  @JsonSerialize(using = ToStringSerializer.class)
  @ApiModelProperty(value = "创建人")
  private Long createUser;

  /**
   * 创建时间
   */
  @DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
  @JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
  @ApiModelProperty(value = "创建时间")
  private Date createTime;

  /**
   * 更新人
   */
  @JsonSerialize(using = ToStringSerializer.class)
  @ApiModelProperty(value = "更新人")
  private Long updateUser;

  /**
   * 更新时间
   */
  @DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
  @JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
  @ApiModelProperty(value = "更新时间")
  private Date updateTime;

  /**
   * 状态[1:正常]
   */
  @ApiModelProperty(value = "业务状态")
  private Integer status;

  /**
   * 状态[0:未删除,1:删除]
   */
  @TableLogic
  @ApiModelProperty(value = "是否已删除")
  private Integer isDeleted;
}
