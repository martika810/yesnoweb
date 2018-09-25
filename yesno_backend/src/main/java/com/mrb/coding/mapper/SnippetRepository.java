package com.mrb.coding.mapper;

import com.mrb.coding.model.domain.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SnippetRepository extends JpaRepository<Snippet,String> {

    @Query("SELECT s FROM Snippet s WHERE s.accountId = :accountId order by s.updatedTime desc")
    public List<Snippet> findByAccountId(@Param("accountId") String accountId);

}
