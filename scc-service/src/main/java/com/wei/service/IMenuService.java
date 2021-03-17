package com.wei.service;

import com.wei.dto.MenuDto;
import com.wei.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wei
 * @since 2021-02-15
 */
public interface IMenuService extends IService<Menu> {
    List<MenuDto> getMenuDtoListByCode(String code);
}
