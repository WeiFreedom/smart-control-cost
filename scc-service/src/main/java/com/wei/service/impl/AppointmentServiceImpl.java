package com.wei.service.impl;

import com.wei.entity.Appointment;
import com.wei.dao.AppointmentMapper;
import com.wei.service.IAppointmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* <p>
    * 预约 服务实现类
    * </p>
*
* @author wei
* @since 2021-01-24
*/
@Service
@Transactional
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment> implements IAppointmentService {

}
