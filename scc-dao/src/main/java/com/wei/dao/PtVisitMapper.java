package com.wei.dao;

import com.wei.dto.PtVisitMiStatisticsDto;
import com.wei.entity.PtVisit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wei
 * @since 2021-02-18
 */
public interface PtVisitMapper extends BaseMapper<PtVisit> {
    List<PtVisitMiStatisticsDto> medicarePatientsNumber(int month);
}
