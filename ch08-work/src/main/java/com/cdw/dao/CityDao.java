package com.cdw.dao;

import com.cdw.domain.City;

import java.util.List;

/**
 * @author: cdw
 * @date: 2021/12/5 12:29
 * @description:
 */
public interface CityDao {
    int insertCity(City city);

    List<City> selectCityByProvinceId(Integer provinceId);
}
