package com.wei.dao;

import com.wei.dto.VerifyPageMedicalRecordDto;
import com.wei.entity.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 病案首页的表 Mapper 接口
 * </p>
 *
 * @author wei
 * @since 2021-03-04
 */
public interface PageMedicalRecordMapper extends BaseMapper<PageMedicalRecord> {
    List<VerifyPageMedicalRecordDto> verifyPageMedicalRecordList(@Param("startDt") String startDt, @Param("endDt") String endDt);

    List<MdcAdrgDiag> getMdcAdrgDiagList();

    List<MdcAdrg> getMdcAdrgList();

    List<DrgMcc> getDrgMccList();
    List<DrgCc> getDrgCcList();
    List<McExc> getMcExcList();
}