package com.wei.web.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authz.annotation.RequiresRoles;
import io.swagger.annotations.Api;
import com.wei.utils.constant.AppPermission;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
    * 诊断字典表 前端控制器
    * </p>
*
* @author wei
* @since 2021-03-16
*/
@RestController
@RequiresRoles({AppPermission.ADMIN})
@Api(tags = "诊断字典表相关接口")
@RequestMapping("/api/disease")
public class DiseaseController {

}
