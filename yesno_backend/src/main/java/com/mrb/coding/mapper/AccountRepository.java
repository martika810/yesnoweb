package com.mrb.coding.mapper;

import com.mrb.coding.model.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface AccountRepository extends CrudRepository<Account,Long> {
}
