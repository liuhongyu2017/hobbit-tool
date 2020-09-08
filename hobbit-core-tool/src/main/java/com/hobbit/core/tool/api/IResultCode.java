package com.hobbit.core.tool.api;

import java.io.Serializable;

/**
 * 业务代码接口
 *
 * @author lhy
 * @version 1.0.0 2020/09/07
 */
public interface IResultCode extends Serializable {

  /**
   * 消息
   *
   * @return String
   */
  String getMessage();

  /**
   * 状态码
   *
   * @return int
   */
  int getCode();

}
