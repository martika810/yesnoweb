package com.mrb.coding.mapper;

import com.mrb.coding.model.domain.Snippet;
import org.springframework.data.repository.CrudRepository;

public interface SnippetRepository extends CrudRepository<Snippet,String> {
}
