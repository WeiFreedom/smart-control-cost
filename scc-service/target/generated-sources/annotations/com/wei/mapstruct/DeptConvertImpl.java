package com.wei.mapstruct;

import com.wei.dto.DeptDto;
import com.wei.entity.Dept;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-17T21:35:38+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_251 (Oracle Corporation)"
)
@Component
public class DeptConvertImpl implements DeptConvert {

    @Override
    public DeptDto deptToDeptDto(Dept dept) {
        if ( dept == null ) {
            return null;
        }

        DeptDto deptDto = new DeptDto();

        deptDto.setCode( dept.getDeptCode() );
        deptDto.setPinyin( dept.getDeptPinyin() );
        deptDto.setAddress( dept.getDeptAddress() );
        deptDto.setPhone( dept.getDeptPhone() );
        deptDto.setIntroduce( dept.getDeptIntroduce() );
        deptDto.setName( dept.getDeptName() );
        deptDto.setTypeName( dept.getDeptTypeName() );
        if ( dept.getDeptSort() != null ) {
            deptDto.setSort( dept.getDeptSort() );
        }

        return deptDto;
    }

    @Override
    public List<DeptDto> deptListToDeptDtoList(List<Dept> deptList) {
        if ( deptList == null ) {
            return null;
        }

        List<DeptDto> list = new ArrayList<DeptDto>( deptList.size() );
        for ( Dept dept : deptList ) {
            list.add( deptToDeptDto( dept ) );
        }

        return list;
    }
}
