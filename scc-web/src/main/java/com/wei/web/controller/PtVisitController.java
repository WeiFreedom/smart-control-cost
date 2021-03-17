package com.wei.web.controller;


import com.wei.service.IPtVisitService;
import com.wei.utils.constant.AppCode;
import com.wei.web.domain.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authz.annotation.RequiresRoles;
import io.swagger.annotations.Api;
import com.wei.utils.constant.AppPermission;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
    *  前端控制器
    * </p>
*
* @author wei
* @since 2021-02-18
*/
@RestController
@RequiresRoles({AppPermission.ADMIN})
@Api(tags = "病人就诊信息相关接口")
@RequestMapping("/api/ptVisit")
public class PtVisitController {

    @Autowired
    private IPtVisitService ptVisitService;

    /**
     * 获取医保病人数仪表板
     * @param month 默认几个月的数据
     * @return
     */
    @PostMapping("/medicarePatientsNumber")
    @ApiOperation(value = "获取医保病人数仪表板")
    public ResultVo medicarePatientsNumber(int month){
        return new ResultVo(AppCode.SUCESS,"查询成功", ptVisitService.medicarePatientsNumber(month));
    }
}
