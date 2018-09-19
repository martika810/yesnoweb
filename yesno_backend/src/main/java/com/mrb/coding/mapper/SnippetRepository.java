package com.mrb.coding.mapper;

import com.mrb.coding.model.domain.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SnippetRepository extends JpaRepository<Snippet,String> {

}
