package com.hobbit.core.mp.support;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Map;
import com.hobbit.core.launch.constant.TokenConstant;
import com.hobbit.core.tool.support.Kv;
import com.hobbit.core.tool.utils.BeanUtil;
import com.hobbit.core.tool.utils.Func;

/**
 * 分页工具
 *
 * @author Chill
 */
public class Condition {

  /**
   * 转化成mybatis plus中的Page
   *
   * @param query 查询条件
   * @return IPage
   */
  public static <T> IPage<T> getPage(Query query) {
    Page<T> page = new Page<>(Func.toInt(query.getCurrent(), 1), Func.toInt(query.getSize(), 10));
    page.setAsc(Func.toStrArray(SqlKeyword.filter(query.getAscs())));
    page.setDesc(Func.toStrArray(SqlKeyword.filter(query.getDescs())));
    return page;
  }

  /**
   * 获取mybatis plus中的QueryWrapper
   *
   * @param entity 实体
   * @param <T>    类型
   * @return QueryWrapper
   */
  public static <T> QueryWrapper<T> getQueryWrapper(T entity) {
    return new QueryWrapper<>(entity);
  }

  /**
   * 获取mybatis plus中的QueryWrapper
   *
   * @param query 查询条件
   * @param clazz 实体类
   * @param <T>   类型
   * @return QueryWrapper
   */
  public static <T> QueryWrapper<T> getQueryWrapper(Map<String, Object> query, Class<T> clazz) {
    Kv exclude = Kv.init().set(TokenConstant.HEADER, TokenConstant.HEADER)
        .set("current", "current").set("size", "size").set("ascs", "ascs").set("descs", "descs");
    return getQueryWrapper(query, exclude, clazz);
  }

  /**
   * 获取mybatis plus中的QueryWrapper
   *
   * @param query   查询条件
   * @param exclude 排除的查询条件
   * @param clazz   实体类
   * @param <T>     类型
   * @return QueryWrapper
   */
  public static <T> QueryWrapper<T> getQueryWrapper(Map<String, Object> query,
      Map<String, Object> exclude, Class<T> clazz) {
    exclude.forEach((k, v) -> query.remove(k));
    QueryWrapper<T> qw = new QueryWrapper<>();
    qw.setEntity(BeanUtil.newInstance(clazz));
    SqlKeyword.buildCondition(query, qw);
    return qw;
  }

}
