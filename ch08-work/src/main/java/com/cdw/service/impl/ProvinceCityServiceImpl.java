package com.cdw.service.impl;

import com.cdw.dao.CityDao;
import com.cdw.dao.ProvinceDao;
import com.cdw.domain.City;
import com.cdw.domain.Province;
import com.cdw.service.ProvinceCityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: cdw
 * @date: 2021/12/5 12:41
 * @description:
 */
@Service
public class ProvinceCityServiceImpl implements ProvinceCityService {
    @Resource
    private ProvinceDao provinceDao;
    @Resource
    private CityDao cityDao;

    @Override
    public List<Province> queryAllProvince() {
        return provinceDao.selectProvinceList();
    }

    @Override
    public List<City> queryCityByProvinceId(Integer provinceId) {
        return cityDao.selectCityByProvinceId(provinceId);
    }

    @Override
    public int addCity(City city) {
        return cityDao.insertCity(city);
    }
}
