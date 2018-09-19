package com.mrb.coding.mapper;

import com.mrb.coding.model.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

