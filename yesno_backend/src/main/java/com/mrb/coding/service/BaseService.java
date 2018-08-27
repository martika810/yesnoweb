package com.mrb.coding.service;

import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.util.List;

/**
 * BaseService，包含常用的单表操作
 *
 * @author trang
 */
public interface BaseService<T, PK extends Serializable> {

    int insert(T record);
    int insertUnchecked(T record);
    int insertBatch(List<T> records);
    int update(T record);
    int updateUnchecked(T record);
    int updateByExample(T record, Example example);
    int updateUncheckedByExample(T record, Example example);
    int deleteByPk(PK pk);
    int deleteByPks(Iterable<? extends PK> pks);
    int delete(T param);
    int deleteAll();
    int deleteByExample(Example example);
    T selectByPk(PK pk);
    List<T> selectByPks(Iterable<? extends PK> pks);
    List<T> select(T param);
    T selectOne(T param);
    List<T> selectAll();
    int selectCount(T param);
    PageInfo<T> selectPage(T param, int pageNum, int pageSize);
    PageInfo<T> selectPageAndCount(T param, int pageNum, int pageSize);
    List<T> selectByExample(Example example);
    int selectCountByExample(Example example);
    PageInfo<T> selectPageByExample(Example example, int pageNum, int pageSize);
    PageInfo<T> selectPageAndCountByExample(Example example, int pageNum, int pageSize);

}