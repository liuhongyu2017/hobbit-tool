package com.hobbit.core.test;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.AliasFor;

/**
 * 简化 测试
 *
 * @author L.cm
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootTest
public @interface BladeBootTest {

  /**
   * 服务名：appName
   * @return appName
   */
  @AliasFor("appName")
  String value() default "blade-test";

  /**
   * 服务名：appName
   * @return appName
   */
  @AliasFor("value")
  String appName() default "blade-test";

  /**
   * profile
   * @return profile
   */
  String profile() default "dev";

  /**
   * 启用 ServiceLoader 加载 launcherService
   * @return 是否启用
   */
  boolean enableLoader() default false;
}
