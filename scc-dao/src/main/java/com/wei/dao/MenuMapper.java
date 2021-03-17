package com.wei.dao;

import com.wei.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wei
 * @since 2021-02-15
 */
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> getMenuListByCode(@Param("code") String code);
}
