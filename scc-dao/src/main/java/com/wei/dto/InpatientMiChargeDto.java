package com.wei.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class InpatientMiChargeDto {
    private String ptName;
    private String ptIoNo;
    private String visitBedName;
    private String visitDeptName;
    private Date medicalTime;
    private int days;
    private int nurse;
    private int bed;
    private int consult;
    private BigDecimal miSum;
    private BigDecimal feeSum;
    private String rate;
}
