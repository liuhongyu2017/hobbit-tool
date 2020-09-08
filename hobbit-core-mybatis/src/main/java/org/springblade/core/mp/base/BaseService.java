package com.hobbit.core.mp.base;

import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import javax.validation.constraints.NotEmpty;

/**
 * 基础业务接口
 *
 * @param <T>
 * @author Chill
 */
public interface BaseService<T> extends IService<T> {

  /**
   * 逻辑删除
   *
   * @param ids id集合(逗号分隔)
   * @return boolean
   */
  boolean deleteLogic(@NotEmpty List<Long> ids);

}
