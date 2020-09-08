package com.hobbit.core.boot.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.my.core.launch.props.MyProperties;
import com.hobbit.core.tool.constant.SystemConstant;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 配置类
 *
 * @author Chill
 */
@Slf4j
@Configuration
@EnableConfigurationProperties({
    MyProperties.class
})
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@AllArgsConstructor
public class BladeBootAutoConfiguration {

  private MyProperties myProperties;

  /**
   * 全局变量定义
   *
   * @return SystemConstant
   */
  @Bean
  public SystemConstant fileConst() {
    SystemConstant me = SystemConstant.me();

    //设定开发模式
    me.setDevMode(("dev".equals(myProperties.getEnv())));

    //设定文件上传远程地址
    me.setDomain(myProperties.get("upload-domain", "http://localhost:8888"));

    //设定文件上传是否为远程模式
    me.setRemoteMode(myProperties.getBoolean("remote-mode", true));

    //远程上传地址
    me.setRemotePath(
        myProperties.get("remote-path", System.getProperty("user.dir") + "/work/blade"));

    //设定文件上传头文件夹
    me.setUploadPath(myProperties.get("upload-path", "/upload"));

    //设定文件下载头文件夹
    me.setDownloadPath(myProperties.get("download-path", "/download"));

    //设定上传图片是否压缩
    me.setCompress(myProperties.getBoolean("compress", false));

    //设定上传图片压缩比例
    me.setCompressScale(myProperties.getDouble("compress-scale", 2.00));

    //设定上传图片缩放选择:true放大;false缩小
    me.setCompressFlag(myProperties.getBoolean("compress-flag", false));

    return me;
  }

}
