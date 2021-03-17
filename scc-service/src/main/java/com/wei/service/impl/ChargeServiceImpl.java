package com.wei.service.impl;

import com.wei.dto.InpatientMiChargeDto;
import com.wei.dto.OutpatientMiChargeDto;
import com.wei.entity.Charge;
import com.wei.dao.ChargeMapper;
import com.wei.service.IChargeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wei
 * @since 2021-02-22
 */
@Service
@Transactional
public class ChargeServiceImpl extends ServiceImpl<ChargeMapper, Charge> implements IChargeService {
    @Autowired
    private ChargeMapper chargeMapper;

    public List<InpatientMiChargeDto>  getInpatientMiChargeDtoList(Map<String, String> map) {
        List<InpatientMiChargeDto> list = chargeMapper.getInpatientMiChargeDtoList(map);
        list.forEach(m -> {
            if(new BigDecimal(0) == m.getFeeSum()){
                m.setRate( "0.00%" );
            }else{
                m.setRate( m.getMiSum().divide(m.getFeeSum()).setScale(4, RoundingMode.HALF_UP).multiply(new BigDecimal(100)) + "%" );
            }
        });
        return list;
    }

    public List<OutpatientMiChargeDto>  getOutpatientMiChargeDtoList(Map<String, String> map){
        return chargeMapper.getOutpatientMiChargeDtoList(map);
    }
}
