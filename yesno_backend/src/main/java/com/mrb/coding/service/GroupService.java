package com.mrb.coding.service;

import com.mrb.coding.model.domain.Group;

import java.util.List;

public interface GroupService{
    List<Group> selectAllOrderByCreated();

}
