package com.wei.web.controller;


import com.wei.service.IPageMedicalRecordService;
import com.wei.utils.constant.AppCode;
import com.wei.web.domain.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authz.annotation.RequiresRoles;
import io.swagger.annotations.Api;
import com.wei.utils.constant.AppPermission;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
* <p>
    * 病案首页的表 前端控制器
    * </p>
*
* @author wei
* @since 2021-03-04
*/
@RestController
@RequiresRoles({AppPermission.ADMIN})
@Api(tags = "病案首页的表相关接口")
@RequestMapping("/api/pageMedicalRecord")
public class PageMedicalRecordController {
    @Autowired
    private IPageMedicalRecordService pageMedicalRecordService;

    @PostMapping("/verifyPageMedicalRecordList")
    @ApiOperation(value = "获取医保病人数仪表板")
    public ResultVo verifyPageMedicalRecordList(@RequestBody Map<String, String> map){
        return new ResultVo(AppCode.SUCESS,"查询成功",pageMedicalRecordService.verifyPageMedicalRecordList(map));
    }

    @PostMapping("/drgs")
    @ApiOperation(value = "获取医保病人数仪表板")
    public ResultVo drgs(@RequestBody Map<String, Object> map){
        return new ResultVo(AppCode.SUCESS,"查询成功",pageMedicalRecordService.drgs(map));
    }
}
