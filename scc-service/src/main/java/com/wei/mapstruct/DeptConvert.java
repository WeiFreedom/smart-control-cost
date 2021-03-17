package com.wei.mapstruct;

import com.wei.dto.DeptDto;
import com.wei.entity.Dept;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeptConvert {

    /**
     * 转换类的实例对象
     */
    DeptConvert INSTANCE = Mappers.getMapper(DeptConvert.class);

    @Mappings({
            @Mapping(source = "deptCode", target = "code"),
            @Mapping(source = "deptName", target = "name"),
            @Mapping(source = "deptPinyin", target = "pinyin"),
            @Mapping(source = "deptPhone", target = "phone"),
            @Mapping(source = "deptSort", target = "sort"),
            @Mapping(source = "deptIntroduce", target = "introduce"),
            @Mapping(source = "deptAddress", target = "address"),
            @Mapping(source = "deptTypeName", target = "typeName")
    })
    DeptDto deptToDeptDto(Dept dept);

    List<DeptDto> deptListToDeptDtoList(List<Dept> deptList);
}
