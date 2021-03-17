package com.wei.web.controller;


import com.wei.service.IMenuService;
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

/**
* <p>
    *  前端控制器
    * </p>
*
* @author wei
* @since 2021-02-15
*/
@RestController
@RequiresRoles({AppPermission.ADMIN})
@Api(tags = "权限相关接口")
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    private IMenuService menuService;


    @PostMapping("/getMenuListByCode")
    @ApiOperation(value = "获取权限列表")
    public ResultVo getMenuListByCode(String code){
        return new ResultVo(AppCode.SUCESS,"查询成功",menuService.getMenuDtoListByCode(code));
    }
}
