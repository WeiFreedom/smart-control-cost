package com.wei.dto;

import lombok.Data;

import java.util.List;

@Data
public class MenuDto {
    private String name;
    private List<MenuDto> children;
}
