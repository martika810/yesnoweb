package com.mrb.coding.service;

import com.mrb.coding.model.domain.Group;
import com.mrb.coding.model.domain.Snippet;

import java.util.List;

public interface GroupService extends BaseService<Group, String> {
    List<Group> selectAllOrderByCreated();

}