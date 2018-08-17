package com.mrb.coding.service.impl;

import com.mrb.coding.model.domain.Group;
import com.mrb.coding.model.domain.Snippet;
import com.mrb.coding.service.GroupService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service("groupService")
public class GroupServiceImpl extends BaseServiceImpl<Group,String> implements GroupService {
    @Override
    public List<Group> selectAllOrderByCreated() {
        Example example = new Example(Group.class);
        example.setOrderByClause("createdtime desc");
        return selectByExample(example);
    }
}
