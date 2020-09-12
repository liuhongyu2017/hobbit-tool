package com.hobbit.core.secure.props;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * 客户端令牌认证信息
 *
 * @author Chill
 */
@Data
public class ClientSecure {

  private String clientId;

  private final List<String> pathPatterns = new ArrayList<>();

}
