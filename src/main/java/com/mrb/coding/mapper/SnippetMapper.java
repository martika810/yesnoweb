package com.mrb.coding.mapper;

import com.mrb.coding.model.domain.Snippet;
import com.mrb.coding.util.BaseMapper;
import org.apache.ibatis.session.SqlSession;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface SnippetMapper extends BaseMapper<Snippet> {
}
