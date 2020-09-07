package org.springblade.core.log.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * LogError视图实体类
 *
 * @author Chill
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LogErrorVo extends LogError {

  private static final long serialVersionUID = 1L;

  private String strId;

}
