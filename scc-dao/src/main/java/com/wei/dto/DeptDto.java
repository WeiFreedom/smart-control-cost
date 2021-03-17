package com.wei.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptDto {
    private String code;
    private String name;
    private String pinyin;
    private String phone;
    private int sort;
    private String introduce;
    private String address;
    private String typeName;
}
