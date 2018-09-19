package com.mrb.coding.service.impl;

import com.google.common.collect.Lists;
import com.mrb.coding.mapper.GroupRepository;
import com.mrb.coding.model.domain.Group;
import com.mrb.coding.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("groupService")
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository repository;

    @Override
    public List<Group> selectAllOrderByCreated() {
        return repository.findAll(new Sort(Sort.Direction.DESC, "updatedTime"));
    }
}
