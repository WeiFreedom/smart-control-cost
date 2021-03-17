package com.wei.web.controller;


import com.wei.service.IChargeService;
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
    *  前端控制器
    * </p>
*
* @author wei
* @since 2021-02-22
*/
@RestController
@RequiresRoles({AppPermission.ADMIN})
@Api(tags = "费用相关接口")
@RequestMapping("/api/charge")
public class ChargeController {
    @Autowired
    private IChargeService chargeService;

    @PostMapping("/getInpatientMiChargeDtoList")
    @ApiOperation(value = "获取住院医保统计信息")
    public ResultVo getInpatientMiChargeDtoList(@RequestBody Map<String,String> map){
        return new ResultVo(AppCode.SUCESS,"查询成功", chargeService.getInpatientMiChargeDtoList(map));
    }
    @PostMapping("/getOutpatientMiChargeDtoList")
    @ApiOperation(value = "获取门诊医保统计信息")
    public ResultVo getOutpatientMiChargeDtoList(@RequestBody Map<String,String> map){
        return new ResultVo(AppCode.SUCESS,"查询成功", chargeService.getOutpatientMiChargeDtoList(map));
    }
}
