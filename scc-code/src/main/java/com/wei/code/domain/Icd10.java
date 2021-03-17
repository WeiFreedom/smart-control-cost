package com.wei.code.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Icd10 implements Serializable {
public Icd10(){}

    private String icdId;
    private String icdPid;
    private String icdCode;
    private String icdName;
    private String partnum;
    private String codelength;
    private String isclinical;
    private String isusing;
    private String remark;
    private String initializationState;
    private String addUserId;
    private String addUserName;
    private String addTime;
    private String lastUpdateUserId;
    private String lastUpdateUserName;
    private String lastUpdateTime;
    private String level;
    private String children;
    private String applyExplain;
    private String icdAttachment;
    private String classCode;
    private String className;
    private String diagnoseCode;
    private String diagnoseName;
    private String open;
    private String isParent;
    private String mid;
    private String subflag;
    private String confirmStatus;
    private String verCode;
    private String verName;
    private String resourceAttachment;
    private String refDefine;
    private String diagnosticBasis;
    private String version;
    private String comfirmUserId;
    private String comfirmUserName;
    private String comfirmTime;
    private String mcode;
}
