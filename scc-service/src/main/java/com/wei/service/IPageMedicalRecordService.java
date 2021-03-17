package com.wei.service;

import com.wei.dto.VerifyPageMedicalRecordDto;
import com.wei.entity.PageMedicalRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.service.event.entity.OutParam;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 病案首页的表 服务类
 * </p>
 *
 * @author wei
 * @since 2021-03-04
 */
public interface IPageMedicalRecordService extends IService<PageMedicalRecord> {
    List<VerifyPageMedicalRecordDto> verifyPageMedicalRecordList(Map<String, String> map);
    List<OutParam> drgs(Map<String, Object> map);
}
