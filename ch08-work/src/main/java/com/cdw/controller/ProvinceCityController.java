package com.cdw.controller;

import com.cdw.domain.City;
import com.cdw.domain.Province;
import com.cdw.service.ProvinceCityService;
import com.cdw.vo.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: cdw
 * @date: 2021/12/5 12:44
 * @description:
 */
@Controller
public class ProvinceCityController {
    @Resource
    private ProvinceCityService service;

    @RequestMapping("/queryProvince.do")
    @ResponseBody
    public CommonResult queryProvinces() {
        List<Province> provinces = service.queryAllProvince();
        CommonResult result = new CommonResult(0, "查询没有结果", null);
        if (provinces != null && provinces.size() > 0)
            result = new CommonResult(1, "查询成功", provinces);
        return result;
    }


    @RequestMapping("/city/addCity.do")
    @ResponseBody
    public CommonResult addCity(City city) {
        int res = service.addCity(city);
        CommonResult result = new CommonResult();
        if (res > 0) {
            result.setCode(1);
            result.setMsg("添加"+city.getName()+"成功");
            result.setData(city);
        }else {
            result.setCode(0);
            result.setMsg("添加失败");
            result.setData("");
        }
        return result;
    }

    @RequestMapping("/city/queryCity.do")
    @ResponseBody
    public CommonResult queryCity(Integer pid) {
        List<City> cities = service.queryCityByProvinceId(pid);
        CommonResult result = new CommonResult(0, "查询没有结果", null);
        if (cities != null && cities.size() > 0)
            result = new CommonResult(1, "查询成功", cities);
        return result;
    }



}
