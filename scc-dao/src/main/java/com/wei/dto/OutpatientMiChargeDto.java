package com.wei.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OutpatientMiChargeDto {
    private String ptName;
    private String ptIoNo;
    private String visitDeptName;
    private Date visitTime;
    private String diagnoseName;
    private BigDecimal contrastSum;
    private BigDecimal feeSum;
}
