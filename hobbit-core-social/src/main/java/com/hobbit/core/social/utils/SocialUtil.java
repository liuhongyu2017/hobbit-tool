package com.hobbit.core.social.utils;

import java.util.Objects;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.config.AuthDefaultSource;
import me.zhyd.oauth.exception.AuthException;
import me.zhyd.oauth.request.AuthAlipayRequest;
import me.zhyd.oauth.request.AuthBaiduRequest;
import me.zhyd.oauth.request.AuthCodingRequest;
import me.zhyd.oauth.request.AuthCsdnRequest;
import me.zhyd.oauth.request.AuthDingTalkRequest;
import me.zhyd.oauth.request.AuthDouyinRequest;
import me.zhyd.oauth.request.AuthElemeRequest;
import me.zhyd.oauth.request.AuthFacebookRequest;
import me.zhyd.oauth.request.AuthGiteeRequest;
import me.zhyd.oauth.request.AuthGithubRequest;
import me.zhyd.oauth.request.AuthGitlabRequest;
import me.zhyd.oauth.request.AuthGoogleRequest;
import me.zhyd.oauth.request.AuthHuaweiRequest;
import me.zhyd.oauth.request.AuthKujialeRequest;
import me.zhyd.oauth.request.AuthLinkedinRequest;
import me.zhyd.oauth.request.AuthMeituanRequest;
import me.zhyd.oauth.request.AuthMiRequest;
import me.zhyd.oauth.request.AuthMicrosoftRequest;
import me.zhyd.oauth.request.AuthOschinaRequest;
import me.zhyd.oauth.request.AuthPinterestRequest;
import me.zhyd.oauth.request.AuthQqRequest;
import me.zhyd.oauth.request.AuthRenrenRequest;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.request.AuthStackOverflowRequest;
import me.zhyd.oauth.request.AuthTaobaoRequest;
import me.zhyd.oauth.request.AuthTeambitionRequest;
import me.zhyd.oauth.request.AuthToutiaoRequest;
import me.zhyd.oauth.request.AuthTwitterRequest;
import me.zhyd.oauth.request.AuthWeChatEnterpriseRequest;
import me.zhyd.oauth.request.AuthWeChatMpRequest;
import me.zhyd.oauth.request.AuthWeChatOpenRequest;
import me.zhyd.oauth.request.AuthWeiboRequest;
import com.hobbit.core.social.props.SocialProperties;

/**
 * SocialUtil
 *
 * @author Chill
 */
public class SocialUtil {

  /**
   * 根据具体的授权来源，获取授权请求工具类
   *
   * @param source 授权来源
   * @return AuthRequest
   */
  public static AuthRequest getAuthRequest(String source, SocialProperties socialProperties) {
    AuthDefaultSource authSource = Objects
        .requireNonNull(AuthDefaultSource.valueOf(source.toUpperCase()));
    AuthConfig authConfig = socialProperties.getOauth().get(authSource);
    if (authConfig == null) {
      throw new AuthException("未获取到有效的Auth配置");
    }
    AuthRequest authRequest = null;
    switch (authSource) {
      case GITHUB:
        authRequest = new AuthGithubRequest(authConfig);
        break;
      case GITEE:
        authRequest = new AuthGiteeRequest(authConfig);
        break;
      case OSCHINA:
        authRequest = new AuthOschinaRequest(authConfig);
        break;
      case QQ:
        authRequest = new AuthQqRequest(authConfig);
        break;
      case WECHAT_OPEN:
        authRequest = new AuthWeChatOpenRequest(authConfig);
        break;
      case WECHAT_ENTERPRISE:
        authRequest = new AuthWeChatEnterpriseRequest(authConfig);
        break;
      case WECHAT_MP:
        authRequest = new AuthWeChatMpRequest(authConfig);
        break;
      case DINGTALK:
        authRequest = new AuthDingTalkRequest(authConfig);
        break;
      case ALIPAY:
        // 支付宝在创建回调地址时，不允许使用localhost或者127.0.0.1，所以这儿的回调地址使用的局域网内的ip
        authRequest = new AuthAlipayRequest(authConfig);
        break;
      case BAIDU:
        authRequest = new AuthBaiduRequest(authConfig);
        break;
      case WEIBO:
        authRequest = new AuthWeiboRequest(authConfig);
        break;
      case CODING:
        authRequest = new AuthCodingRequest(authConfig);
        break;
      case CSDN:
        authRequest = new AuthCsdnRequest(authConfig);
        break;
      case TAOBAO:
        authRequest = new AuthTaobaoRequest(authConfig);
        break;
      case GOOGLE:
        authRequest = new AuthGoogleRequest(authConfig);
        break;
      case FACEBOOK:
        authRequest = new AuthFacebookRequest(authConfig);
        break;
      case DOUYIN:
        authRequest = new AuthDouyinRequest(authConfig);
        break;
      case LINKEDIN:
        authRequest = new AuthLinkedinRequest(authConfig);
        break;
      case MICROSOFT:
        authRequest = new AuthMicrosoftRequest(authConfig);
        break;
      case MI:
        authRequest = new AuthMiRequest(authConfig);
        break;
      case TOUTIAO:
        authRequest = new AuthToutiaoRequest(authConfig);
        break;
      case TEAMBITION:
        authRequest = new AuthTeambitionRequest(authConfig);
        break;
      case PINTEREST:
        authRequest = new AuthPinterestRequest(authConfig);
        break;
      case RENREN:
        authRequest = new AuthRenrenRequest(authConfig);
        break;
      case STACK_OVERFLOW:
        authRequest = new AuthStackOverflowRequest(authConfig);
        break;
      case HUAWEI:
        authRequest = new AuthHuaweiRequest(authConfig);
        break;
      case KUJIALE:
        authRequest = new AuthKujialeRequest(authConfig);
        break;
      case GITLAB:
        authRequest = new AuthGitlabRequest(authConfig);
        break;
      case MEITUAN:
        authRequest = new AuthMeituanRequest(authConfig);
        break;
      case ELEME:
        authRequest = new AuthElemeRequest(authConfig);
        break;
      case TWITTER:
        authRequest = new AuthTwitterRequest(authConfig);
        break;
      default:
        break;
    }
    if (null == authRequest) {
      throw new AuthException("未获取到有效的Auth配置");
    }
    return authRequest;
  }

}
