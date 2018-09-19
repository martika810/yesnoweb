package com.mrb.coding.mapper;

import com.mrb.coding.model.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface RoleRepository extends CrudRepository<Role,String> {
}
