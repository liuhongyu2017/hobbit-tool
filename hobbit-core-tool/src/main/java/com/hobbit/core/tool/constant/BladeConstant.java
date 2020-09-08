package com.hobbit.core.tool.constant;

/**
 * 系统常量
 *
 * @author Chill
 */
public final class BladeConstant {

  /**
   * 编码
   */
  public static final String UTF_8 = "UTF-8";

  /**
   * contentType
   */
  public static final String CONTENT_TYPE_NAME = "Content-type";

  /**
   * JSON 资源
   */
  public static final String CONTENT_TYPE = "application/json;charset=utf-8";

  /**
   * 角色前缀
   */
  public static final String SECURITY_ROLE_PREFIX = "ROLE_";

  /**
   * 主键字段名
   */
  public static final String DB_PRIMARY_KEY = "id";

  /**
   * 业务状态[1:正常]
   */
  public static final int DB_STATUS_NORMAL = 1;


  /**
   * 删除状态[0:正常,1:删除]
   */
  public static final int DB_NOT_DELETED = 0;
  public static final int DB_IS_DELETED = 1;

  /**
   * 用户锁定状态
   */
  public static final int DB_ADMIN_NON_LOCKED = 0;
  public static final int DB_ADMIN_LOCKED = 1;

  /**
   * 管理员对应的租户ID
   */
  public static final String ADMIN_TENANT_ID = "000000";

  /**
   * 日志默认状态
   */
  public static final String LOG_NORMAL_TYPE = "1";

  /**
   * 默认为空消息
   */
  public static final String DEFAULT_NULL_MESSAGE = "暂无承载数据";
  /**
   * 默认成功消息
   */
  public static final String DEFAULT_SUCCESS_MESSAGE = "操作成功";
  /**
   * 默认失败消息
   */
  public static final String DEFAULT_FAILURE_MESSAGE = "操作失败";
  /**
   * 默认未授权消息
   */
  public static final String DEFAULT_UNAUTHORIZED_MESSAGE = "签名认证失败";

}
