package com.wei.service.impl;

import com.wei.entity.Todo;
import com.wei.dao.TodoMapper;
import com.wei.service.ITodoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* <p>
    *  服务实现类
    * </p>
*
* @author wei
* @since 2021-02-20
*/
@Service
@Transactional
public class TodoServiceImpl extends ServiceImpl<TodoMapper, Todo> implements ITodoService {

}
