package com.wei.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.wei.dto.DeptDto;
import com.wei.entity.Dept;
import com.wei.dao.DeptMapper;
import com.wei.mapstruct.DeptConvert;
import com.wei.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wei
 * @since 2021-01-22
 */
@Service
@Transactional
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    public List<DeptDto> getDeptList(Wrapper<Dept> wrapper) {
        List<Dept> deptList = baseMapper.selectList(wrapper);
        return DeptConvert.INSTANCE.deptListToDeptDtoList(deptList);
    }
}
