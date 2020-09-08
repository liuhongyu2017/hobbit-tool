package com.hobbit.core.log.error;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hobbit.core.tool.jackson.JsonUtil;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * 更改html请求异常为ajax
 *
 * @author Chill
 */
public class BladeErrorController extends BasicErrorController {

  public BladeErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
    super(errorAttributes, errorProperties);
  }

  @Override
  public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
    Map<String, Object> body = getErrorAttributes(request,
        isIncludeStackTrace(request, MediaType.ALL));
    HttpStatus status = getStatus(request);
    response.setStatus(status.value());
    MappingJackson2JsonView view = new MappingJackson2JsonView();
    view.setObjectMapper(JsonUtil.getInstance());
    view.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
    return new ModelAndView(view, body);
  }

}
