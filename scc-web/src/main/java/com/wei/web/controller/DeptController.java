package com.wei.web.controller;


import com.wei.dto.DeptDto;
import com.wei.entity.Dept;
import com.wei.service.IDeptService;
import com.wei.utils.constant.AppCode;
import com.wei.utils.constant.AppPermission;
import com.wei.utils.exception.ValidatorException;
import com.wei.web.domain.ResultVo;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.DeclareRoles;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wei
 * @since 2021-01-22
 */
@RestController
@RequestMapping("/api/dept")
@RequiresRoles({AppPermission.ADMIN})
@Api(tags = "医院科室相关接口")
public class DeptController {
    @Autowired
    private IDeptService deptService;

    @PostMapping("/getAll")
    public ResultVo getAll(){
        List<DeptDto> list = deptService.getDeptList(null);
        return new ResultVo(AppCode.SUCESS,"查询成功!",list);
    }
}
