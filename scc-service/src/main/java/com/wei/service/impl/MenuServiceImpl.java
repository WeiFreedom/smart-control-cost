package com.wei.service.impl;

import com.wei.dto.MenuDto;
import com.wei.entity.Menu;
import com.wei.dao.MenuMapper;
import com.wei.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wei.utils.AssertUtils;
import com.wei.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* <p>
    *  服务实现类
    * </p>
*
* @author wei
* @since 2021-02-15
*/
@Service
@Transactional
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    public List<MenuDto> getMenuDtoListByCode(String code){
        AssertUtils.notEmpty(code, "code不能为空!");
        List<Menu> list = menuMapper.getMenuListByCode(code);
        List<MenuDto> result = new ArrayList<>();
        list.stream().forEach(m-> {
            if(!StringUtils.isEmpty(m.getMenuParentName())){
                if(result.stream().noneMatch(n->n.getName().equals(m.getMenuParentName()))){
                    MenuDto dto = new MenuDto();
                    dto.setName(m.getMenuParentName());
                    result.add(dto);
                }
            }
            MenuDto menuDto = result.stream().filter(k -> k.getName().equals(m.getMenuParentName())).findFirst().orElse(null);
            if(menuDto!=null){
                MenuDto child = new MenuDto();
                child.setName(m.getMenuName());
                List<MenuDto> children = menuDto.getChildren();
                if(children==null){
                    children = new ArrayList<>();
                }
                children.add(child);
                menuDto.setChildren(children);
            }
        });

        return result;
    }
}
