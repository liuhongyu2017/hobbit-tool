package com.hobbit.core.launch.constant;

/**
 * 系统常量
 *
 * @author lhy
 * @version 1.0.0 2020/09/07
 */
public final class AppConstant {

  /**
   * 应用版本
   */
  public static final String APPLICATION_VERSION = "2.7.2";

  /**
   * 基础包
   */
  public static final String BASE_PACKAGES = "com.my";

  /**
   * 应用名前缀
   */
  private static final String APPLICATION_NAME_PREFIX = "my-";
  /**
   * 网关模块名称
   */
  public static final String APPLICATION_GATEWAY_NAME = APPLICATION_NAME_PREFIX + "gateway";
  /**
   * 授权模块名称
   */
  public static final String APPLICATION_AUTH_NAME = APPLICATION_NAME_PREFIX + "auth";
  /**
   * 监控模块名称
   */
  public static final String APPLICATION_ADMIN_NAME = APPLICATION_NAME_PREFIX + "admin";
  /**
   * 首页模块名称
   */
  public static final String APPLICATION_DESK_NAME = APPLICATION_NAME_PREFIX + "desk";
  /**
   * 系统模块名称
   */
  public static final String APPLICATION_SYSTEM_NAME = APPLICATION_NAME_PREFIX + "system";
  /**
   * 用户模块名称
   */
  public static final String APPLICATION_USER_NAME = APPLICATION_NAME_PREFIX + "user";
  /**
   * 日志模块名称
   */
  public static final String APPLICATION_LOG_NAME = APPLICATION_NAME_PREFIX + "log";
  /**
   * 开发模块名称
   */
  public static final String APPLICATION_DEVELOP_NAME = APPLICATION_NAME_PREFIX + "develop";
  /**
   * 资源模块名称
   */
  public static final String APPLICATION_RESOURCE_NAME = APPLICATION_NAME_PREFIX + "resource";
  /**
   * 链路追踪模块名称
   */
  public static final String APPLICATION_ZIPKIN_NAME = APPLICATION_NAME_PREFIX + "zipkin";
  /**
   * 测试模块名称
   */
  public static final String APPLICATION_TEST_NAME = APPLICATION_NAME_PREFIX + "test";

  /**
   * 开发环境
   */
  public static final String DEV_CODE = "dev";
  /**
   * 生产环境
   */
  public static final String PROD_CODE = "prod";
  /**
   * 测试环境
   */
  public static final String TEST_CODE = "test";

  /**
   * 代码部署于 linux 上，工作默认为 mac 和 Windows
   */
  public static final String OS_NAME_LINUX = "LINUX";

}
