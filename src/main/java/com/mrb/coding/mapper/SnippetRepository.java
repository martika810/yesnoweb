package com.mrb.coding.mapper;

import com.mrb.coding.model.domain.Snippet;
import com.mrb.coding.util.BaseMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface SnippetRepository extends CrudRepository<Snippet,String> {
}
