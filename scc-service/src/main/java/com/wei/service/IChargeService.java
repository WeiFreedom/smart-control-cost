package com.wei.service;

import com.wei.dto.InpatientMiChargeDto;
import com.wei.dto.OutpatientMiChargeDto;
import com.wei.entity.Charge;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wei
 * @since 2021-02-22
 */
public interface IChargeService extends IService<Charge> {
    List<InpatientMiChargeDto> getInpatientMiChargeDtoList(Map<String,String> map);
    List<OutpatientMiChargeDto>  getOutpatientMiChargeDtoList(Map<String, String> map);
}
