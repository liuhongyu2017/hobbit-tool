package com.hobbit.core.log.model;


import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 实体类
 *
 * @author Chill
 * @since 2018-10-12
 */
@Data
@TableName("blade_log_usual")
public class LogUsual extends LogAbstract implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 日志级别
   */
  private String logLevel;
  /**
   * 日志业务id
   */
  private String logId;
  /**
   * 日志数据
   */
  private String logData;


}
