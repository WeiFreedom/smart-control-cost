package com.wei.service.event.entity;

import com.wei.entity.*;
import lombok.Data;

import java.util.List;

@Data
public class EventArgs {
    /**
     * 当前事件
     */
    private int index;
    /**
     * 获取所有的MdcAdrg列表
     */
    private List<MdcAdrg> mdcAdrgList;
    /**
     * 获取所有的MdcAdrgDiag列表
     */
    private List<MdcAdrgDiag> mdcAdrgDiagList;
    /**
     * 所有的医保端诊断列表
     */
    private List<Disease> diseases;
    /**
     * 所有MCC列表
     */
    private List<DrgMcc> drgMccs;
    /**
     * 所有CC列表
     */
    private List<DrgCc> drgCcs;
    /**
     * 所有排除诊断列表
     */
    private List<McExc> mcExcs;
    /**
     * 请求入参
     */
    private InParam inParam;
    /**
     * 请求出参
     */
    private List<OutParam> outParams;
}
