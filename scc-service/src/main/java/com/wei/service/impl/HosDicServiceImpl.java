package com.wei.service.impl;

import com.wei.entity.HosDic;
import com.wei.dao.HosDicMapper;
import com.wei.service.IHosDicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wei
 * @since 2021-01-22
 */
@Service
@Transactional
public class HosDicServiceImpl extends ServiceImpl<HosDicMapper, HosDic> implements IHosDicService {

}
