package com.wei.service;

import com.wei.entity.PtVisit;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wei
 * @since 2021-02-18
 */
public interface IPtVisitService extends IService<PtVisit> {
    Map<String, Object> medicarePatientsNumber(int month);
}
