package com.mrb.coding.mapper;

import com.mrb.coding.model.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface GroupRepository extends JpaRepository<Group,String> {
}
