package com.wei.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wei
 * @since 2021-02-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单id
     */
    @TableId(value = "tc_menu_id", type = IdType.AUTO)
    private Integer menuId;

    /**
     * 菜单路径
     */
    private String menuPath;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单显示名称
     */
    private String menuCaption;

    /**
     * Y 再用 N 停用
     */
    private String menuState;

    /**
     * 图标
     */
    private String menuIcon;

    /**
     * Y 需要权限 N 不需要权限
     */
    private String menuAuthFlag;

    /**
     * 上级id
     */
    private Integer menuParentId;
    /**
     * 上级name
     */
    private String menuParentName;


}
