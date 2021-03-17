package com.wei.service.impl;

import com.wei.entity.Disease;
import com.wei.dao.DiseaseMapper;
import com.wei.service.IDiseaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* <p>
    * 诊断字典表 服务实现类
    * </p>
*
* @author wei
* @since 2021-03-16
*/
@Service
@Transactional
public class DiseaseServiceImpl extends ServiceImpl<DiseaseMapper, Disease> implements IDiseaseService {

}
