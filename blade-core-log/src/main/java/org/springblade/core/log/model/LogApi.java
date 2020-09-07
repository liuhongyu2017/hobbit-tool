package org.springblade.core.log.model;


import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 实体类
 *
 * @author Chill
 */
@Data
@TableName("blade_log_api")
public class LogApi extends LogAbstract implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 日志类型
   */
  private String type;
  /**
   * 日志标题
   */
  private String title;

}
