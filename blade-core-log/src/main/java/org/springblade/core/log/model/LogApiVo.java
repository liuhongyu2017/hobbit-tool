package org.springblade.core.log.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * LogApi视图实体类
 *
 * @author Chill
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LogApiVo extends LogApi {

  private static final long serialVersionUID = 1L;

  private String strId;

}
