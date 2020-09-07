package org.springblade.core.tool.support.xss;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springblade.core.tool.utils.StringPool;

/**
 * XSS过滤
 *
 * @author Chill
 */
@AllArgsConstructor
public class XssFilter implements Filter {

  private XssProperties xssProperties;
  private XssUrlProperties xssUrlProperties;

  @Override
  public void init(FilterConfig config) {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    String path = ((HttpServletRequest) request).getServletPath();
    if (isSkip(path)) {
      chain.doFilter(request, response);
    } else {
      XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper(
          (HttpServletRequest) request);
      chain.doFilter(xssRequest, response);
    }
  }

  private boolean isSkip(String path) {
    return (xssUrlProperties.getExcludePatterns().stream().anyMatch(path::startsWith))
        || (xssProperties.getSkipUrl().stream().map(url -> url.replace("/**", StringPool.EMPTY))
        .anyMatch(path::startsWith));
  }

  @Override
  public void destroy() {

  }

}
