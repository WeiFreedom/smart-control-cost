package com.wei.mapstruct;

import com.wei.dto.EmployeeDto;
import com.wei.entity.Employee;
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
public class EmployeeConvertImpl implements EmployeeConvert {

    @Override
    public EmployeeDto employeeToEmployeeDto(Employee dept) {
        if ( dept == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setDrCode( dept.getDrCode() );
        employeeDto.setDrName( dept.getDrName() );
        employeeDto.setDrDeptCode( dept.getDrDeptCode() );
        employeeDto.setDrDeptName( dept.getDrDeptName() );
        employeeDto.setDrPhoto( dept.getDrPhoto() );
        employeeDto.setDrSex( dept.getDrSex() );

        return employeeDto;
    }

    @Override
    public List<EmployeeDto> employeeListToEmployeeDtoList(List<Employee> deptList) {
        if ( deptList == null ) {
            return null;
        }

        List<EmployeeDto> list = new ArrayList<EmployeeDto>( deptList.size() );
        for ( Employee employee : deptList ) {
            list.add( employeeToEmployeeDto( employee ) );
        }

        return list;
    }
}
