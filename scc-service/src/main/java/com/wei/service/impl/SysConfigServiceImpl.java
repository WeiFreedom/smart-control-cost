package com.wei.service.impl;

import com.wei.entity.SysConfig;
import com.wei.dao.SysConfigMapper;
import com.wei.service.ISysConfigService;
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
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements ISysConfigService {

}
