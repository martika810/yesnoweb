package com.mrb.coding.test;

import com.github.pagehelper.PageInfo;
import com.mrb.coding.model.domain.City;
import com.mrb.coding.service.CityService;
import com.mrb.coding.util.JsonUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationTests extends SpringBaseTest {

    @Autowired
    private CityService cityService;

    @Test
    public void selectPage() {
        cityService.selectPageAndCount(null, 1, 3).getList().stream()
                .map(JsonUtils::toJson)
                .forEach(log::info);
    }

}