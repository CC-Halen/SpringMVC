package com.cdw.dao;

import com.cdw.domain.Province;

import java.util.List;

/**
 * @author: cdw
 * @date: 2021/12/4 22:04
 * @description:
 */
public interface ProvinceDao {
    List<Province> selectProvinceList();
}
