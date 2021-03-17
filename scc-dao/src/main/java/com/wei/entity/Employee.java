package com.wei.entity;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    private static final long serialVersionUID = 5822053265381623188L;
    private Integer drId;

    private String drCode;

    private String drName;

    private String drPinyin;

    private String password;

    private String drCardid;

    private String drDeptCode;

    private String drDeptName;

    private String drLevelCode;

    private String drLevelName;

    private String drPositionCode;

    private String drPositionName;

    private String drPhoto;

    private String drPhone;

    private String drEmail;

    private String drSex;

    private Date drBirthday;

    private String drEdu;

    private String drCountry;

    private String drNation;

    private String drNativePlace;

    private String drState;

    private String drIntroduce;

    private String drGood;

    private String drExpertCode;

    private String drExpertName;

    public Integer getDrId() {
        return drId;
    }

    public void setDrId(Integer drId) {
        this.drId = drId;
    }

    public String getDrCode() {
        return drCode;
    }

    public void setDrCode(String drCode) {
        this.drCode = drCode == null ? null : drCode.trim();
    }

    public String getDrName() {
        return drName;
    }

    public void setDrName(String drName) {
        this.drName = drName == null ? null : drName.trim();
    }

    public String getDrPinyin() {
        return drPinyin;
    }

    public void setDrPinyin(String drPinyin) {
        this.drPinyin = drPinyin == null ? null : drPinyin.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getDrCardid() {
        return drCardid;
    }

    public void setDrCardid(String drCardid) {
        this.drCardid = drCardid == null ? null : drCardid.trim();
    }

    public String getDrDeptCode() {
        return drDeptCode;
    }

    public void setDrDeptCode(String drDeptCode) {
        this.drDeptCode = drDeptCode == null ? null : drDeptCode.trim();
    }

    public String getDrDeptName() {
        return drDeptName;
    }

    public void setDrDeptName(String drDeptName) {
        this.drDeptName = drDeptName == null ? null : drDeptName.trim();
    }

    public String getDrLevelCode() {
        return drLevelCode;
    }

    public void setDrLevelCode(String drLevelCode) {
        this.drLevelCode = drLevelCode == null ? null : drLevelCode.trim();
    }

    public String getDrLevelName() {
        return drLevelName;
    }

    public void setDrLevelName(String drLevelName) {
        this.drLevelName = drLevelName == null ? null : drLevelName.trim();
    }

    public String getDrPositionCode() {
        return drPositionCode;
    }

    public void setDrPositionCode(String drPositionCode) {
        this.drPositionCode = drPositionCode == null ? null : drPositionCode.trim();
    }

    public String getDrPositionName() {
        return drPositionName;
    }

    public void setDrPositionName(String drPositionName) {
        this.drPositionName = drPositionName == null ? null : drPositionName.trim();
    }

    public String getDrPhoto() {
        return drPhoto;
    }

    public void setDrPhoto(String drPhoto) {
        this.drPhoto = drPhoto == null ? null : drPhoto.trim();
    }

    public String getDrPhone() {
        return drPhone;
    }

    public void setDrPhone(String drPhone) {
        this.drPhone = drPhone == null ? null : drPhone.trim();
    }

    public String getDrEmail() {
        return drEmail;
    }

    public void setDrEmail(String drEmail) {
        this.drEmail = drEmail == null ? null : drEmail.trim();
    }

    public String getDrSex() {
        return drSex;
    }

    public void setDrSex(String drSex) {
        this.drSex = drSex == null ? null : drSex.trim();
    }

    public Date getDrBirthday() {
        return drBirthday;
    }

    public void setDrBirthday(Date drBirthday) {
        this.drBirthday = drBirthday;
    }

    public String getDrEdu() {
        return drEdu;
    }

    public void setDrEdu(String drEdu) {
        this.drEdu = drEdu == null ? null : drEdu.trim();
    }

    public String getDrCountry() {
        return drCountry;
    }

    public void setDrCountry(String drCountry) {
        this.drCountry = drCountry == null ? null : drCountry.trim();
    }

    public String getDrNation() {
        return drNation;
    }

    public void setDrNation(String drNation) {
        this.drNation = drNation == null ? null : drNation.trim();
    }

    public String getDrNativePlace() {
        return drNativePlace;
    }

    public void setDrNativePlace(String drNativePlace) {
        this.drNativePlace = drNativePlace == null ? null : drNativePlace.trim();
    }

    public String getDrState() {
        return drState;
    }

    public void setDrState(String drState) {
        this.drState = drState == null ? null : drState.trim();
    }

    public String getDrIntroduce() {
        return drIntroduce;
    }

    public void setDrIntroduce(String drIntroduce) {
        this.drIntroduce = drIntroduce == null ? null : drIntroduce.trim();
    }

    public String getDrGood() {
        return drGood;
    }

    public void setDrGood(String drGood) {
        this.drGood = drGood == null ? null : drGood.trim();
    }

    public String getDrExpertCode() {
        return drExpertCode;
    }

    public void setDrExpertCode(String drExpertCode) {
        this.drExpertCode = drExpertCode == null ? null : drExpertCode.trim();
    }

    public String getDrExpertName() {
        return drExpertName;
    }

    public void setDrExpertName(String drExpertName) {
        this.drExpertName = drExpertName == null ? null : drExpertName.trim();
    }
}