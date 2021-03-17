package com.wei.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wei.dto.DeptDto;
import com.wei.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wei
 * @since 2021-01-24
 */
public interface IDeptService extends IService<Dept> {
    List<DeptDto> getDeptList(Wrapper<Dept> wrapper);
}
