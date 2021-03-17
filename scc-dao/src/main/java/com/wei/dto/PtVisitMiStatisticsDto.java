package com.wei.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PtVisitMiStatisticsDto {
    /**
     * 月份
     */
    private String month;
    /**
     * 门诊0 住院1 急诊2 体检 3
     */
    private String type;
    /**
     * 医保数量
     */
    private Integer miNumber;
    /**
     * 总数量
     */
    private Integer total;
}
