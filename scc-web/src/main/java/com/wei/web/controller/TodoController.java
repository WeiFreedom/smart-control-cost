package com.wei.web.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.wei.entity.Todo;
import com.wei.service.ITodoService;
import com.wei.utils.AssertUtils;
import com.wei.utils.DateTimeUtils;
import com.wei.utils.constant.AppCode;
import com.wei.utils.constant.AppConstant;
import com.wei.web.domain.ResultVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.shiro.authz.annotation.RequiresRoles;
import io.swagger.annotations.Api;
import com.wei.utils.constant.AppPermission;

import java.util.List;

/**
* <p>
    *  前端控制器
    * </p>
*
* @author wei
* @since 2021-02-20
*/
@RestController
@RequiresRoles({AppPermission.ADMIN})
@Api(tags = "TODO相关接口")
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    private ITodoService todoService;
    @PostMapping("/addTodo")
    @ApiOperation(value = "添加Todo")
    public ResultVo addTodo(@RequestBody Todo todo){
        todo.setTodoFlag(AppConstant.N);
        todo.setTodoState(AppConstant.N);
        todo.setTodoTime(DateTimeUtils.now());
        todoService.save(todo);
        return new ResultVo(AppCode.SUCESS,"保存成功", true);
    }

    @PostMapping("/delTodo")
    @ApiOperation(value = "删除Todo")
    public ResultVo delTodo(@RequestParam("todoId") Integer todoId){
        QueryWrapper query = new QueryWrapper<>();
        query.eq("tc_todo_id", todoId);
        Todo todo = todoService.getOne(query);
        AssertUtils.notNull(todo, "传入的id查无数据");
        UpdateWrapper wrapper = new UpdateWrapper();
        wrapper.set("tc_todo_flag", AppConstant.Y);
        wrapper.eq("tc_todo_id",todo.getTodoId());
        todoService.update(wrapper);
        return new ResultVo(AppCode.SUCESS,"删除成功", true);
    }

    @PostMapping("/getListByCode")
    @ApiOperation(value = "获取Todo列表")
    public ResultVo getListByCode(@RequestParam("code") String code){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("tc_dr_code",code);
        wrapper.eq("tc_todo_flag", AppConstant.N);
        List<Todo> list = todoService.list(wrapper);
        return new ResultVo(AppCode.SUCESS,"查询成功", list);
    }

    @PostMapping("/updateTodo")
    @ApiOperation(value = "更新Todo列表")
    public ResultVo updateTodo(@RequestBody Todo todo){
        UpdateWrapper wrapper = new UpdateWrapper();
        wrapper.set("tc_todo_state", todo.getTodoState());
        wrapper.eq("tc_todo_id",todo.getTodoId());
        todoService.update(wrapper);
        return new ResultVo(AppCode.SUCESS,"更新成功", true);
    }
}
