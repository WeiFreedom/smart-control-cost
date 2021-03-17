package com.wei.dao;

import com.wei.dto.InpatientMiChargeDto;
import com.wei.dto.OutpatientMiChargeDto;
import com.wei.entity.Charge;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wei
 * @since 2021-02-22
 */
public interface ChargeMapper extends BaseMapper<Charge> {
    /**
     * 获取住院的费用信息
     * @param map
     * @return
     */
    List<InpatientMiChargeDto> getInpatientMiChargeDtoList(Map<String,String> map);

    /**
     * 获取门诊的费用信息
     * @param map
     * @return
     */
    List<OutpatientMiChargeDto> getOutpatientMiChargeDtoList(Map<String,String> map);
}
