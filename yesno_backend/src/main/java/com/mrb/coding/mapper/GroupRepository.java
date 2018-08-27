package com.mrb.coding.mapper;

import com.mrb.coding.model.domain.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface GroupRepository extends CrudRepository<Group,String> {
}
