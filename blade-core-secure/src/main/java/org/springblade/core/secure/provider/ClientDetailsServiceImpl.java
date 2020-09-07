package org.springblade.core.secure.provider;

import lombok.AllArgsConstructor;
import org.springblade.core.secure.constant.SecureConstant;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 获取客户端详情
 *
 * @author Chill
 */
@AllArgsConstructor
public class ClientDetailsServiceImpl implements IClientDetailsService {

  private final JdbcTemplate jdbcTemplate;

  @Override
  public IClientDetails loadClientByClientId(String clientId) {
    try {
      return jdbcTemplate
          .queryForObject(SecureConstant.DEFAULT_SELECT_STATEMENT, new String[]{clientId},
              new BeanPropertyRowMapper<>(ClientDetails.class));
    } catch (Exception ex) {
      return null;
    }
  }

}
