package com.wei.code.domain;

import lombok.Data;

@Data
public class Disease {
    private String tc_diag_code;
    private String tc_diag_name;
    private String tc_diag_type;
    private String tc_diag_parent_code;
    private String tc_diag_pinyin;
    private String tc_sex;

}
