package com.mrb.coding.service.impl;

import com.mrb.coding.model.domain.City;
import com.mrb.coding.service.CityService;
import org.springframework.stereotype.Service;

@Service("cityService")
public class CityServiceImpl extends BaseServiceImpl<City, Integer> implements CityService {
}