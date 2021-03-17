package com.wei.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 病案首页的表
 * </p>
 *
 * @author wei
 * @since 2021-03-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_page_medical_record")
public class PageMedicalRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 病人id
     */
    private Integer visitId;

    /**
     *  医疗机构代码 
     */
    @TableField("P900")
    private String p900;

    /**
     *  机构名称 
     */
    @TableField("P6891")
    private String p6891;

    /**
     *  医疗保险手册(卡)号 
     */
    @TableField("P686")
    private String p686;

    /**
     * 健康卡号
     */
    @TableField("P800")
    private String p800;

    /**
     *   医疗付款方式
     */
    @TableField("P1")
    private String p1;

    /**
     *   住院次数
     */
    @TableField("P2")
    private Integer p2;

    /**
     *   病案号
     */
    @TableField("P3")
    private String p3;

    /**
     *   姓名
     */
    @TableField("P4")
    private String p4;

    /**
     *   性别
     */
    @TableField("P5")
    private String p5;

    /**
     *   出生日期
     */
    @TableField("P6")
    private LocalDateTime p6;

    /**
     *   年龄
     */
    @TableField("P7")
    private Integer p7;

    /**
     *   婚姻状况
     */
    @TableField("P8")
    private String p8;

    /**
     *   职业
     */
    @TableField("P9")
    private String p9;

    /**
     *   出生省份
     */
    @TableField("P101")
    private String p101;

    /**
     *   出生地市
     */
    @TableField("P102")
    private String p102;

    /**
     *   出生地县
     */
    @TableField("P103")
    private String p103;

    /**
     *   民族
     */
    @TableField("P11")
    private String p11;

    /**
     *   国籍
     */
    @TableField("P12")
    private String p12;

    /**
     *   身份证号
     */
    @TableField("P13")
    private String p13;

    /**
     *   现住址
     */
    @TableField("P801")
    private String p801;

    /**
     *   住宅电话
     */
    @TableField("P802")
    private String p802;

    /**
     *   现住址邮政编码
     */
    @TableField("P803")
    private String p803;

    /**
     *   工作单位及地址
     */
    @TableField("P14")
    private String p14;

    /**
     *   电话
     */
    @TableField("P15")
    private String p15;

    /**
     * 工作单位邮政编码
     */
    @TableField("P16")
    private String p16;

    /**
     *   户口地址
     */
    @TableField("P17")
    private String p17;

    /**
     *   户口所在地邮政编码
     */
    @TableField("P171")
    private String p171;

    /**
     *   联系人姓名
     */
    @TableField("P18")
    private String p18;

    /**
     *   关系
     */
    @TableField("P19")
    private String p19;

    /**
     *   联系人地址
     */
    @TableField("P20")
    private String p20;

    /**
     *   入院途径
     */
    @TableField("P804")
    private String p804;

    /**
     *   联系人电话
     */
    @TableField("P21")
    private String p21;

    /**
     *   入院日期
     */
    @TableField("P22")
    private LocalDateTime p22;

    /**
     *   入院科别
     */
    @TableField("P23")
    private String p23;

    /**
     *   入院病室
     */
    @TableField("P231")
    private String p231;

    /**
     *   转科科别
     */
    @TableField("P24")
    private String p24;

    /**
     *   出院日期
     */
    @TableField("P25")
    private LocalDateTime p25;

    /**
     *   出院科别
     */
    @TableField("P26")
    private String p26;

    /**
     *   出院病室
     */
    @TableField("P261")
    private String p261;

    /**
     *   实际住院天数
     */
    @TableField("P27")
    private Integer p27;

    /**
     *   门(急)诊诊断编码
     */
    @TableField("P28")
    private String p28;

    /**
     *   门(急)诊诊断描述
     */
    @TableField("P281")
    private String p281;

    /**
     *   入院时情况
     */
    @TableField("P29")
    private String p29;

    /**
     *   入院诊断编码
     */
    @TableField("P30")
    private String p30;

    /**
     *   入院诊断描述
     */
    @TableField("P301")
    private String p301;

    /**
     *   入院后确诊日期
     */
    @TableField("P31")
    private LocalDateTime p31;

    /**
     *   主要诊断编码
     */
    @TableField("P321")
    private String p321;

    /**
     *   主要诊断疾病描述
     */
    @TableField("P322")
    private String p322;

    /**
     *   主要诊断入院病情
     */
    @TableField("P805")
    private String p805;

    /**
     *   主要诊断出院情况
     */
    @TableField("P323")
    private String p323;

    /**
     *   其他诊断编码1
     */
    @TableField("P324")
    private String p324;

    /**
     *   其他诊断疾病描述1
     */
    @TableField("P325")
    private String p325;

    /**
     *   其他诊断入院病情1
     */
    @TableField("P806")
    private String p806;

    /**
     *   其他诊断出院情况1
     */
    @TableField("P326")
    private String p326;

    /**
     *   其他诊断编码2
     */
    @TableField("P327")
    private String p327;

    /**
     *   其他诊断疾病描述2
     */
    @TableField("P328")
    private String p328;

    /**
     *   其他诊断入院病情2
     */
    @TableField("P807")
    private String p807;

    /**
     *   其他诊断出院情况2
     */
    @TableField("P329")
    private String p329;

    /**
     *   其他诊断编码3
     */
    @TableField("P3291")
    private String p3291;

    /**
     *   其他诊断疾病描述3
     */
    @TableField("P3292")
    private String p3292;

    /**
     *   其他诊断入院病情3
     */
    @TableField("P808")
    private String p808;

    /**
     *   其他诊断出院情况3
     */
    @TableField("P3293")
    private String p3293;

    /**
     *   其他诊断编码4
     */
    @TableField("P3294")
    private String p3294;

    /**
     *   其他诊断疾病描述4
     */
    @TableField("P3295")
    private String p3295;

    /**
     *   其他诊断入院病情4
     */
    @TableField("P809")
    private String p809;

    /**
     *   其他诊断出院情况4
     */
    @TableField("P3296")
    private String p3296;

    /**
     *   其他诊断编码5
     */
    @TableField("P3297")
    private String p3297;

    /**
     *   其他诊断疾病描述5
     */
    @TableField("P3298")
    private String p3298;

    /**
     *   其他诊断入院病情5
     */
    @TableField("P810")
    private String p810;

    /**
     *   其他诊断出院情况5
     */
    @TableField("P3299")
    private String p3299;

    /**
     *   其他诊断编码6
     */
    @TableField("P3281")
    private String p3281;

    /**
     *   其他诊断疾病描述6
     */
    @TableField("P3282")
    private String p3282;

    /**
     *   其他诊断入院病情6
     */
    @TableField("P811")
    private String p811;

    /**
     *   其他诊断出院情况6
     */
    @TableField("P3283")
    private String p3283;

    /**
     *   其他诊断编码7
     */
    @TableField("P3284")
    private String p3284;

    /**
     *   其他诊断疾病描述7
     */
    @TableField("P3285")
    private String p3285;

    /**
     *   其他诊断入院病情7
     */
    @TableField("P812")
    private String p812;

    /**
     *   其他诊断出院情况7
     */
    @TableField("P3286")
    private String p3286;

    /**
     *   其他诊断编码8
     */
    @TableField("P3287")
    private String p3287;

    /**
     *   其他诊断疾病描述8
     */
    @TableField("P3288")
    private String p3288;

    /**
     *   其他诊断入院病情8
     */
    @TableField("P813")
    private String p813;

    /**
     *   其他诊断出院情况8
     */
    @TableField("P3289")
    private String p3289;

    /**
     *   其他诊断编码9
     */
    @TableField("P3271")
    private String p3271;

    /**
     *   其他诊断疾病描述9
     */
    @TableField("P3272")
    private String p3272;

    /**
     *   其他诊断入院病情9
     */
    @TableField("P814")
    private String p814;

    /**
     *   其他诊断出院情况9
     */
    @TableField("P3273")
    private String p3273;

    /**
     *   其他诊断编码10
     */
    @TableField("P3274")
    private String p3274;

    /**
     * 其他诊断疾病描述10
     */
    @TableField("P3275")
    private String p3275;

    /**
     * 其他诊断入院病情10
     */
    @TableField("P815")
    private String p815;

    /**
     * 其他诊断出院情况10
     */
    @TableField("P3276")
    private String p3276;

    /**
     * 医院感染总次数
     */
    @TableField("P689")
    private Integer p689;

    /**
     * 病理诊断编码1
     */
    @TableField("P351")
    private String p351;

    /**
     * 病理诊断名称1
     */
    @TableField("P352")
    private String p352;

    /**
     * 病理号1
     */
    @TableField("P816")
    private String p816;

    /**
     * 病理诊断编码2
     */
    @TableField("P353")
    private String p353;

    /**
     * 病理诊断名称2
     */
    @TableField("P354")
    private String p354;

    /**
     * 病理号2
     */
    @TableField("P817")
    private Integer p817;

    /**
     * 病理诊断编码3
     */
    @TableField("P355")
    private String p355;

    /**
     * 病理诊断名称3
     */
    @TableField("P356")
    private String p356;

    /**
     * 病理号3
     */
    @TableField("P818")
    private String p818;

    /**
     * 损伤、中毒的外部因素编码1
     */
    @TableField("P361")
    private String p361;

    /**
     * 损伤、中毒的外部因素名称1
     */
    @TableField("P362")
    private String p362;

    /**
     * 损伤、中毒的外部因素编码2
     */
    @TableField("P363")
    private String p363;

    /**
     * 损伤、中毒的外部因素名称2
     */
    @TableField("P364")
    private String p364;

    /**
     * 损伤、中毒的外部因素编码3
     */
    @TableField("P365")
    private String p365;

    /**
     * 损伤、中毒的外部因素名称3
     */
    @TableField("P366")
    private String p366;

    /**
     * 过敏源
     */
    @TableField("P371")
    private String p371;

    /**
     * 过敏药物名称
     */
    @TableField("P372")
    private String p372;

    /**
     * HBsAg
     */
    @TableField("P38")
    private String p38;

    /**
     * HCV-Ab
     */
    @TableField("P39")
    private String p39;

    /**
     * HIV-Ab
     */
    @TableField("P40")
    private String p40;

    /**
     * 门诊与出院诊断符合情况
     */
    @TableField("P411")
    private String p411;

    /**
     * 入院与出院诊断符合情况
     */
    @TableField("P412")
    private String p412;

    /**
     * 术前与术后诊断符合情况
     */
    @TableField("P413")
    private String p413;

    /**
     * 临床与病理诊断符合情况
     */
    @TableField("P414")
    private String p414;

    /**
     * 放射与病理诊断符合情况
     */
    @TableField("P415")
    private String p415;

    /**
     * 抢救次数
     */
    @TableField("P421")
    private Integer p421;

    /**
     * 抢救成功次数
     */
    @TableField("P422")
    private Integer p422;

    /**
     * 最高诊断依据
     */
    @TableField("P687")
    private String p687;

    /**
     * 分化程度
     */
    @TableField("P688")
    private String p688;

    /**
     * 科主任
     */
    @TableField("P431")
    private String p431;

    /**
     * 主(副主)任医师
     */
    @TableField("P432")
    private String p432;

    /**
     * 主治医师
     */
    @TableField("P433")
    private String p433;

    /**
     * 住院医师
     */
    @TableField("P434")
    private String p434;

    /**
     * 责任护士
     */
    @TableField("P819")
    private String p819;

    /**
     * 进修医师
     */
    @TableField("P435")
    private String p435;

    /**
     * 研究生实习医师
     */
    @TableField("P436")
    private String p436;

    /**
     * 实习医师
     */
    @TableField("P437")
    private String p437;

    /**
     * 编码员  
     */
    @TableField("P438")
    private String p438;

    /**
     * 病案质量  
     */
    @TableField("P44")
    private String p44;

    /**
     * 质控医师  
     */
    @TableField("P45")
    private String p45;

    /**
     * 质控护师  
     */
    @TableField("P46")
    private String p46;

    /**
     * 质控日期  
     */
    @TableField("P47")
    private LocalDateTime p47;

    /**
     * 手术操作编码1  
     */
    @TableField("P490")
    private String p490;

    /**
     * 手术操作日期1  
     */
    @TableField("P491")
    private LocalDateTime p491;

    /**
     * 手术级别1  
     */
    @TableField("P820")
    private String p820;

    /**
     * 手术操作名称1
     */
    @TableField("P492")
    private String p492;

    /**
     * 手术操作部位1  
     */
    @TableField("P493")
    private String p493;

    /**
     * 手术持续时间1  
     */
    @TableField("P494")
    private BigDecimal p494;

    /**
     * 术者1  
     */
    @TableField("P495")
    private String p495;

    /**
     * Ⅰ助1  
     */
    @TableField("P496")
    private String p496;

    /**
     * Ⅱ助1  
     */
    @TableField("P497")
    private String p497;

    /**
     * 麻醉方式1  
     */
    @TableField("P498")
    private String p498;

    /**
     * 麻醉分级1
     */
    @TableField("P4981")
    private String p4981;

    /**
     * 切口愈合等级1
     */
    @TableField("P499")
    private String p499;

    /**
     * 麻醉医师1  
     */
    @TableField("P4910")
    private String p4910;

    /**
     * 手术操作编码2  
     */
    @TableField("P4911")
    private String p4911;

    /**
     * 手术操作日期2  
     */
    @TableField("P4912")
    private LocalDateTime p4912;

    /**
     * 手术级别2  
     */
    @TableField("P821")
    private String p821;

    /**
     * 手术操作名称2  
     */
    @TableField("P4913")
    private String p4913;

    /**
     * 手术操作部位2  
     */
    @TableField("P4914")
    private String p4914;

    /**
     * 手术持续时间2  
     */
    @TableField("P4915")
    private BigDecimal p4915;

    /**
     * 术者2  
     */
    @TableField("P4916")
    private String p4916;

    /**
     * Ⅰ助2  
     */
    @TableField("P4917")
    private String p4917;

    /**
     * Ⅱ助2  
     */
    @TableField("P4918")
    private String p4918;

    /**
     * 麻醉方式2  
     */
    @TableField("P4919")
    private String p4919;

    /**
     * 麻醉分级2  
     */
    @TableField("P4982")
    private String p4982;

    /**
     * 切口愈合等级2  
     */
    @TableField("P4920")
    private String p4920;

    /**
     * 麻醉医师2  
     */
    @TableField("P4921")
    private String p4921;

    /**
     * 手术操作编码3  
     */
    @TableField("P4922")
    private String p4922;

    /**
     * 手术操作日期3  
     */
    @TableField("P4923")
    private LocalDateTime p4923;

    /**
     * 手术级别3  
     */
    @TableField("P822")
    private String p822;

    /**
     * 手术操作名称3  
     */
    @TableField("P4924")
    private String p4924;

    /**
     * 手术操作部位3  
     */
    @TableField("P4925")
    private String p4925;

    /**
     * 手术持续时间3  
     */
    @TableField("P4526")
    private BigDecimal p4526;

    /**
     * 术者3  
     */
    @TableField("P4527")
    private String p4527;

    /**
     * Ⅰ助3  
     */
    @TableField("P4528")
    private String p4528;

    /**
     * Ⅱ助3  
     */
    @TableField("P4529")
    private String p4529;

    /**
     * 麻醉方式3  
     */
    @TableField("P4530")
    private String p4530;

    /**
     * 麻醉分级3  
     */
    @TableField("P4983")
    private String p4983;

    /**
     * 切口愈合等级3  
     */
    @TableField("P4531")
    private String p4531;

    /**
     * 麻醉医师3  
     */
    @TableField("P4532")
    private String p4532;

    /**
     * 手术操作编码4  
     */
    @TableField("P4533")
    private String p4533;

    /**
     * 手术操作日期4  
     */
    @TableField("P4534")
    private LocalDateTime p4534;

    /**
     * 手术级别4  
     */
    @TableField("P823")
    private String p823;

    /**
     * 手术操作名称4  
     */
    @TableField("P4535")
    private String p4535;

    /**
     * 手术操作部位4  
     */
    @TableField("P4536")
    private String p4536;

    /**
     * 手术持续时间4  
     */
    @TableField("P4537")
    private BigDecimal p4537;

    /**
     * 术者4  
     */
    @TableField("P4538")
    private String p4538;

    /**
     * Ⅰ助4  
     */
    @TableField("P4539")
    private String p4539;

    /**
     * Ⅱ助4  
     */
    @TableField("P4540")
    private String p4540;

    /**
     * 麻醉方式4  
     */
    @TableField("P4541")
    private String p4541;

    /**
     * 麻醉分级4  
     */
    @TableField("P4984")
    private String p4984;

    /**
     * 切口愈合等级4  
     */
    @TableField("P4542")
    private String p4542;

    /**
     * 麻醉医师4  
     */
    @TableField("P4543")
    private String p4543;

    /**
     * 手术操作编码5  
     */
    @TableField("P4544")
    private String p4544;

    /**
     * 手术操作日期5  
     */
    @TableField("P4545")
    private LocalDateTime p4545;

    /**
     * 手术级别5  
     */
    @TableField("P824")
    private String p824;

    /**
     * 手术操作名称5  
     */
    @TableField("P4546")
    private String p4546;

    /**
     * 手术操作部位5  
     */
    @TableField("P4547")
    private String p4547;

    /**
     * 手术持续时间5  
     */
    @TableField("P4548")
    private BigDecimal p4548;

    /**
     * 术者5  
     */
    @TableField("P4549")
    private String p4549;

    /**
     * Ⅰ助5  
     */
    @TableField("P4550")
    private String p4550;

    /**
     * Ⅱ助5  
     */
    @TableField("P4551")
    private String p4551;

    /**
     * 麻醉方式5  
     */
    @TableField("P4552")
    private String p4552;

    /**
     * 麻醉分级5
     */
    @TableField("P4985")
    private String p4985;

    /**
     * 切口愈合等级5
     */
    @TableField("P4553")
    private String p4553;

    /**
     * 麻醉医师5
     */
    @TableField("P4554")
    private String p4554;

    /**
     * 手术操作编码6
     */
    @TableField("P45002")
    private String p45002;

    /**
     * 手术操作日期6
     */
    @TableField("P45003")
    private LocalDateTime p45003;

    /**
     * 手术级别6
     */
    @TableField("P825")
    private String p825;

    /**
     * 手术操作名称6
     */
    private String p45004;

    /**
     * 手术操作部位6
     */
    private String p45005;

    /**
     * 手术持续时间6
     */
    private BigDecimal p45006;

    /**
     * 术者6
     */
    private String p45007;

    /**
     * Ⅰ助6
     */
    private String p45008;

    /**
     * Ⅱ助6
     */
    private String p45009;

    /**
     * 麻醉方式6
     */
    private String p45010;

    /**
     * 麻醉分级6
     */
    private String p45011;

    /**
     * 切口愈合等级6
     */
    private String p45012;

    /**
     * 麻醉医师6
     */
    private String p45013;

    /**
     * 手术操作编码7
     */
    private String p45014;

    /**
     * 手术操作日期7
     */
    private LocalDateTime p45015;

    /**
     * 手术级别7
     */
    @TableField("P826")
    private String p826;

    /**
     * 手术操作名称7
     */
    private String p45016;

    /**
     * 手术操作部位7
     */
    private String p45017;

    /**
     * 手术持续时间7
     */
    private BigDecimal p45018;

    /**
     * 术者7
     */
    private String p45019;

    /**
     * Ⅰ助7
     */
    private String p45020;

    /**
     * Ⅱ助7
     */
    private String p45021;

    /**
     * 麻醉方式7
     */
    private String p45022;

    /**
     * 麻醉分级7
     */
    private String p45023;

    /**
     * 切口愈合等级7
     */
    private String p45024;

    /**
     * 麻醉医师7
     */
    private String p45025;

    /**
     * 手术操作编码8
     */
    private String p45026;

    /**
     * 手术操作日期8
     */
    private LocalDateTime p45027;

    /**
     * 手术级别8
     */
    @TableField("P827")
    private String p827;

    /**
     * 手术操作名称8
     */
    private String p45028;

    /**
     * 手术操作部位8
     */
    private String p45029;

    /**
     * 手术持续时间8
     */
    private BigDecimal p45030;

    /**
     * 术者8
     */
    private String p45031;

    /**
     * Ⅰ助8
     */
    private String p45032;

    /**
     * Ⅱ助8
     */
    private String p45033;

    /**
     * 麻醉方式8
     */
    private String p45034;

    /**
     * 麻醉分级8
     */
    private String p45035;

    /**
     * 切口愈合等级8
     */
    private String p45036;

    /**
     * 麻醉医师8
     */
    private String p45037;

    /**
     * 手术操作编码9
     */
    private String p45038;

    /**
     * 手术操作日期9
     */
    private LocalDateTime p45039;

    /**
     * 手术级别9
     */
    @TableField("P828")
    private String p828;

    /**
     * 手术操作名称9
     */
    private String p45040;

    /**
     * 手术操作部位9
     */
    private String p45041;

    /**
     * 手术持续时间9
     */
    private BigDecimal p45042;

    /**
     * 术者9
     */
    private String p45043;

    /**
     * Ⅰ助9
     */
    private String p45044;

    /**
     * Ⅱ助9 
     */
    private String p45045;

    /**
     * 麻醉方式9
     */
    private String p45046;

    /**
     * 麻醉分级9 
     */
    private String p45047;

    /**
     * 切口合等级9
     */
    private String p45048;

    /**
     * 麻醉医师9
     */
    private String p45049;

    /**
     * 手术操作编码10
     */
    private String p45050;

    /**
     * 手术操作日期10 
     */
    private LocalDateTime p45051;

    /**
     * 手术级别10 
     */
    @TableField("P829")
    private String p829;

    /**
     * 手术操作名称10 
     */
    private String p45052;

    /**
     * 手术操作部位10
     */
    private String p45053;

    /**
     * 手术持续时间10
     */
    private LocalDateTime p45054;

    /**
     * 术者10
     */
    private String p45055;

    /**
     * Ⅰ助10
     */
    private String p45056;

    /**
     * Ⅱ助10
     */
    private String p45057;

    /**
     * 麻醉方式10
     */
    private String p45058;

    /**
     * 麻醉分级10
     */
    private String p45059;

    /**
     * 切口合等级10
     */
    private String p45060;

    /**
     * 麻醉医师10
     */
    private String p45061;

    /**
     * 特级护理天数
     */
    @TableField("P561")
    private Integer p561;

    /**
     * 一级护理天数
     */
    @TableField("P562")
    private Integer p562;

    /**
     * 二级护理天数
     */
    @TableField("P563")
    private Integer p563;

    /**
     * 三级护理天数
     */
    @TableField("P564")
    private Integer p564;

    /**
     * 重症监护室名称1
     */
    @TableField("P6911")
    private String p6911;

    /**
     * 进入时间1
     */
    @TableField("P6912")
    private LocalDateTime p6912;

    /**
     * 退出时间1
     */
    @TableField("P6913")
    private LocalDateTime p6913;

    /**
     * 重症监护室名称2
     */
    @TableField("P6914")
    private String p6914;

    /**
     * 进入时间2 
     */
    @TableField("P6915")
    private LocalDateTime p6915;

    /**
     * 退出时间2 
     */
    @TableField("P6916")
    private LocalDateTime p6916;

    /**
     * 重症监护室名称3
     */
    @TableField("P6917")
    private String p6917;

    /**
     * 进入时间3
     */
    @TableField("P6918")
    private LocalDateTime p6918;

    /**
     * 退出时间3 
     */
    @TableField("P6919")
    private LocalDateTime p6919;

    /**
     * 重症监护室名称4
     */
    @TableField("P6920")
    private String p6920;

    /**
     * 进入时间4 
     */
    @TableField("P6921")
    private LocalDateTime p6921;

    /**
     * 退出时间4 
     */
    @TableField("P6922")
    private LocalDateTime p6922;

    /**
     * 重症监护室名称5
     */
    @TableField("P6923")
    private String p6923;

    /**
     * 进入时间5 
     */
    @TableField("P6924")
    private LocalDateTime p6924;

    /**
     * 退出时间5 
     */
    @TableField("P6925")
    private LocalDateTime p6925;

    /**
     * 死亡患者尸检 
     */
    @TableField("P57")
    private String p57;

    /**
     * 手术、治疗、检查、诊断为本院第一例 
     */
    @TableField("P58")
    private String p58;

    /**
     * 手术患者类型 
     */
    @TableField("P581")
    private String p581;

    /**
     * 随诊 
     */
    @TableField("P60")
    private String p60;

    /**
     * 随诊周数 
     */
    @TableField("P611")
    private BigDecimal p611;

    /**
     * 随诊月数
     */
    @TableField("P612")
    private BigDecimal p612;

    /**
     * 随诊年数
     */
    @TableField("P613")
    private BigDecimal p613;

    /**
     * 示教病例 
     */
    @TableField("P59")
    private String p59;

    /**
     * ABO血型 
     */
    @TableField("P62")
    private String p62;

    /**
     * Rh血型 
     */
    @TableField("P63")
    private String p63;

    /**
     * 输血反应 
     */
    @TableField("P64")
    private String p64;

    /**
     * 红细胞 
     */
    @TableField("P651")
    private BigDecimal p651;

    /**
     * 血小板 
     */
    @TableField("P652")
    private BigDecimal p652;

    /**
     * 血浆 
     */
    @TableField("P653")
    private Integer p653;

    /**
     * 全血 
     */
    @TableField("P654")
    private Integer p654;

    /**
     * 自体回收 
     */
    @TableField("P655")
    private Integer p655;

    /**
     * 其它 
     */
    @TableField("P656")
    private Integer p656;

    /**
     * (年龄不足1周岁的)年龄 
     */
    @TableField("P66")
    private BigDecimal p66;

    /**
     * 新生儿出生体重1
     */
    @TableField("P681")
    private Integer p681;

    /**
     * 新生儿出生体重2
     */
    @TableField("P682")
    private Integer p682;

    /**
     * 新生儿出生体重3
     */
    @TableField("P683")
    private Integer p683;

    /**
     * 新生儿出生体重4
     */
    @TableField("P684")
    private Integer p684;

    /**
     * 新生儿出生体重5
     */
    @TableField("P685")
    private Integer p685;

    /**
     * 入院前多少小时(颅脑损伤患者昏迷时间)
     */
    @TableField("P731")
    private Integer p731;

    /**
     * 入院前多少分钟(颅脑损伤患者昏迷时间)
     */
    @TableField("P732")
    private Integer p732;

    /**
     * 入院后多少小时(颅脑损伤患者昏迷时间)
     */
    @TableField("P733")
    private Integer p733;

    /**
     * 入院后多少分钟(颅脑损伤患者昏迷时间)
     */
    @TableField("P734")
    private Integer p734;

    /**
     * 呼吸机使用时间 
     */
    @TableField("P72")
    private Integer p72;

    /**
     * 是否有出院31天内
     */
    @TableField("P830")
    private String p830;

    /**
     * 出院31天再住院计划目的 
     */
    @TableField("P831")
    private String p831;

    /**
     * 离院方式 
     */
    @TableField("P741")
    private String p741;

    /**
     * 转入医院名称 
     */
    @TableField("P742")
    private String p742;

    /**
     * 转入社区服务机构/乡镇卫生院名称 
     */
    @TableField("P743")
    private String p743;

    /**
     * 住院总费用 
     */
    @TableField("P782")
    private BigDecimal p782;

    /**
     * 住院总费用其中自付金额 
     */
    @TableField("P751")
    private BigDecimal p751;

    /**
     * 一般医疗服务费 
     */
    @TableField("P752")
    private BigDecimal p752;

    /**
     * 一般治疗操作费 
     */
    @TableField("P754")
    private BigDecimal p754;

    /**
     * 护理费 
     */
    @TableField("P755")
    private BigDecimal p755;

    /**
     * 综合医疗服务类其他费用 
     */
    @TableField("P756")
    private BigDecimal p756;

    /**
     * 病理诊断费 
     */
    @TableField("P757")
    private BigDecimal p757;

    /**
     * 实验室诊断费 
     */
    @TableField("P758")
    private BigDecimal p758;

    /**
     * 影像学诊断费 
     */
    @TableField("P759")
    private BigDecimal p759;

    /**
     * 临床诊断项目费 
     */
    @TableField("P760")
    private BigDecimal p760;

    /**
     * 非手术治疗项目费 
     */
    @TableField("P761")
    private BigDecimal p761;

    /**
     * 临床物理治疗费 
     */
    @TableField("P762")
    private BigDecimal p762;

    /**
     * 手术治疗费 
     */
    @TableField("P763")
    private BigDecimal p763;

    /**
     * 麻醉费 
     */
    @TableField("P764")
    private BigDecimal p764;

    /**
     * 手术费 
     */
    @TableField("P765")
    private BigDecimal p765;

    /**
     * 康复费 
     */
    @TableField("P767")
    private BigDecimal p767;

    /**
     * 中医治疗费 
     */
    @TableField("P768")
    private BigDecimal p768;

    /**
     * 西药费 
     */
    @TableField("P769")
    private BigDecimal p769;

    /**
     * 抗菌药物费用 
     */
    @TableField("P770")
    private BigDecimal p770;

    /**
     * 中成药费 
     */
    @TableField("P771")
    private BigDecimal p771;

    /**
     * 中草药费 
     */
    @TableField("P772")
    private BigDecimal p772;

    /**
     * 血费 
     */
    @TableField("P773")
    private BigDecimal p773;

    /**
     * 白蛋白类制品费 
     */
    @TableField("P774")
    private BigDecimal p774;

    /**
     * 球蛋白类制品费 
     */
    @TableField("P775")
    private BigDecimal p775;

    /**
     * 凝血因子类制品费 
     */
    @TableField("P776")
    private BigDecimal p776;

    /**
     * 细胞因子类制品费 
     */
    @TableField("P777")
    private BigDecimal p777;

    /**
     * 检查用一次性医用材料费 
     */
    @TableField("P778")
    private BigDecimal p778;

    /**
     * 治疗用一次性医用
     */
    @TableField("P779")
    private BigDecimal p779;

    /**
     * 手术用一次性医用材料费 
     */
    @TableField("P780")
    private BigDecimal p780;

    /**
     * 其他费 
     */
    @TableField("P781")
    private BigDecimal p781;


}
