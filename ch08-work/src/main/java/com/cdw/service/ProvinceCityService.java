package com.cdw.service;

import com.cdw.domain.City;
import com.cdw.domain.Province;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: cdw
 * @date: 2021/12/5 12:37
 * @description:
 */
@Service
public interface ProvinceCityService {
    List<Province> queryAllProvince();

    List<City> queryCityByProvinceId(Integer provinceId);

    int addCity(City city);
}
