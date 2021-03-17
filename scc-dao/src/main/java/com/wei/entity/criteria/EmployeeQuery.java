package com.wei.entity.criteria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeeQuery() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDrIdIsNull() {
            addCriterion("tc_dr_id is null");
            return (Criteria) this;
        }

        public Criteria andDrIdIsNotNull() {
            addCriterion("tc_dr_id is not null");
            return (Criteria) this;
        }

        public Criteria andDrIdEqualTo(Integer value) {
            addCriterion("tc_dr_id =", value, "drId");
            return (Criteria) this;
        }

        public Criteria andDrIdNotEqualTo(Integer value) {
            addCriterion("tc_dr_id <>", value, "drId");
            return (Criteria) this;
        }

        public Criteria andDrIdGreaterThan(Integer value) {
            addCriterion("tc_dr_id >", value, "drId");
            return (Criteria) this;
        }

        public Criteria andDrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tc_dr_id >=", value, "drId");
            return (Criteria) this;
        }

        public Criteria andDrIdLessThan(Integer value) {
            addCriterion("tc_dr_id <", value, "drId");
            return (Criteria) this;
        }

        public Criteria andDrIdLessThanOrEqualTo(Integer value) {
            addCriterion("tc_dr_id <=", value, "drId");
            return (Criteria) this;
        }

        public Criteria andDrIdIn(List<Integer> values) {
            addCriterion("tc_dr_id in", values, "drId");
            return (Criteria) this;
        }

        public Criteria andDrIdNotIn(List<Integer> values) {
            addCriterion("tc_dr_id not in", values, "drId");
            return (Criteria) this;
        }

        public Criteria andDrIdBetween(Integer value1, Integer value2) {
            addCriterion("tc_dr_id between", value1, value2, "drId");
            return (Criteria) this;
        }

        public Criteria andDrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tc_dr_id not between", value1, value2, "drId");
            return (Criteria) this;
        }

        public Criteria andDrCodeIsNull() {
            addCriterion("tc_dr_code is null");
            return (Criteria) this;
        }

        public Criteria andDrCodeIsNotNull() {
            addCriterion("tc_dr_code is not null");
            return (Criteria) this;
        }

        public Criteria andDrCodeEqualTo(String value) {
            addCriterion("tc_dr_code =", value, "drCode");
            return (Criteria) this;
        }

        public Criteria andDrCodeNotEqualTo(String value) {
            addCriterion("tc_dr_code <>", value, "drCode");
            return (Criteria) this;
        }

        public Criteria andDrCodeGreaterThan(String value) {
            addCriterion("tc_dr_code >", value, "drCode");
            return (Criteria) this;
        }

        public Criteria andDrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_code >=", value, "drCode");
            return (Criteria) this;
        }

        public Criteria andDrCodeLessThan(String value) {
            addCriterion("tc_dr_code <", value, "drCode");
            return (Criteria) this;
        }

        public Criteria andDrCodeLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_code <=", value, "drCode");
            return (Criteria) this;
        }

        public Criteria andDrCodeLike(String value) {
            addCriterion("tc_dr_code like", value, "drCode");
            return (Criteria) this;
        }

        public Criteria andDrCodeNotLike(String value) {
            addCriterion("tc_dr_code not like", value, "drCode");
            return (Criteria) this;
        }

        public Criteria andDrCodeIn(List<String> values) {
            addCriterion("tc_dr_code in", values, "drCode");
            return (Criteria) this;
        }

        public Criteria andDrCodeNotIn(List<String> values) {
            addCriterion("tc_dr_code not in", values, "drCode");
            return (Criteria) this;
        }

        public Criteria andDrCodeBetween(String value1, String value2) {
            addCriterion("tc_dr_code between", value1, value2, "drCode");
            return (Criteria) this;
        }

        public Criteria andDrCodeNotBetween(String value1, String value2) {
            addCriterion("tc_dr_code not between", value1, value2, "drCode");
            return (Criteria) this;
        }

        public Criteria andDrNameIsNull() {
            addCriterion("tc_dr_name is null");
            return (Criteria) this;
        }

        public Criteria andDrNameIsNotNull() {
            addCriterion("tc_dr_name is not null");
            return (Criteria) this;
        }

        public Criteria andDrNameEqualTo(String value) {
            addCriterion("tc_dr_name =", value, "drName");
            return (Criteria) this;
        }

        public Criteria andDrNameNotEqualTo(String value) {
            addCriterion("tc_dr_name <>", value, "drName");
            return (Criteria) this;
        }

        public Criteria andDrNameGreaterThan(String value) {
            addCriterion("tc_dr_name >", value, "drName");
            return (Criteria) this;
        }

        public Criteria andDrNameGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_name >=", value, "drName");
            return (Criteria) this;
        }

        public Criteria andDrNameLessThan(String value) {
            addCriterion("tc_dr_name <", value, "drName");
            return (Criteria) this;
        }

        public Criteria andDrNameLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_name <=", value, "drName");
            return (Criteria) this;
        }

        public Criteria andDrNameLike(String value) {
            addCriterion("tc_dr_name like", value, "drName");
            return (Criteria) this;
        }

        public Criteria andDrNameNotLike(String value) {
            addCriterion("tc_dr_name not like", value, "drName");
            return (Criteria) this;
        }

        public Criteria andDrNameIn(List<String> values) {
            addCriterion("tc_dr_name in", values, "drName");
            return (Criteria) this;
        }

        public Criteria andDrNameNotIn(List<String> values) {
            addCriterion("tc_dr_name not in", values, "drName");
            return (Criteria) this;
        }

        public Criteria andDrNameBetween(String value1, String value2) {
            addCriterion("tc_dr_name between", value1, value2, "drName");
            return (Criteria) this;
        }

        public Criteria andDrNameNotBetween(String value1, String value2) {
            addCriterion("tc_dr_name not between", value1, value2, "drName");
            return (Criteria) this;
        }

        public Criteria andDrPinyinIsNull() {
            addCriterion("tc_dr_pinyin is null");
            return (Criteria) this;
        }

        public Criteria andDrPinyinIsNotNull() {
            addCriterion("tc_dr_pinyin is not null");
            return (Criteria) this;
        }

        public Criteria andDrPinyinEqualTo(String value) {
            addCriterion("tc_dr_pinyin =", value, "drPinyin");
            return (Criteria) this;
        }

        public Criteria andDrPinyinNotEqualTo(String value) {
            addCriterion("tc_dr_pinyin <>", value, "drPinyin");
            return (Criteria) this;
        }

        public Criteria andDrPinyinGreaterThan(String value) {
            addCriterion("tc_dr_pinyin >", value, "drPinyin");
            return (Criteria) this;
        }

        public Criteria andDrPinyinGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_pinyin >=", value, "drPinyin");
            return (Criteria) this;
        }

        public Criteria andDrPinyinLessThan(String value) {
            addCriterion("tc_dr_pinyin <", value, "drPinyin");
            return (Criteria) this;
        }

        public Criteria andDrPinyinLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_pinyin <=", value, "drPinyin");
            return (Criteria) this;
        }

        public Criteria andDrPinyinLike(String value) {
            addCriterion("tc_dr_pinyin like", value, "drPinyin");
            return (Criteria) this;
        }

        public Criteria andDrPinyinNotLike(String value) {
            addCriterion("tc_dr_pinyin not like", value, "drPinyin");
            return (Criteria) this;
        }

        public Criteria andDrPinyinIn(List<String> values) {
            addCriterion("tc_dr_pinyin in", values, "drPinyin");
            return (Criteria) this;
        }

        public Criteria andDrPinyinNotIn(List<String> values) {
            addCriterion("tc_dr_pinyin not in", values, "drPinyin");
            return (Criteria) this;
        }

        public Criteria andDrPinyinBetween(String value1, String value2) {
            addCriterion("tc_dr_pinyin between", value1, value2, "drPinyin");
            return (Criteria) this;
        }

        public Criteria andDrPinyinNotBetween(String value1, String value2) {
            addCriterion("tc_dr_pinyin not between", value1, value2, "drPinyin");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("tc_password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("tc_password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("tc_password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("tc_password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("tc_password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("tc_password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("tc_password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("tc_password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("tc_password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("tc_password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("tc_password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("tc_password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("tc_password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("tc_password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andDrCardidIsNull() {
            addCriterion("tc_dr_cardid is null");
            return (Criteria) this;
        }

        public Criteria andDrCardidIsNotNull() {
            addCriterion("tc_dr_cardid is not null");
            return (Criteria) this;
        }

        public Criteria andDrCardidEqualTo(String value) {
            addCriterion("tc_dr_cardid =", value, "drCardid");
            return (Criteria) this;
        }

        public Criteria andDrCardidNotEqualTo(String value) {
            addCriterion("tc_dr_cardid <>", value, "drCardid");
            return (Criteria) this;
        }

        public Criteria andDrCardidGreaterThan(String value) {
            addCriterion("tc_dr_cardid >", value, "drCardid");
            return (Criteria) this;
        }

        public Criteria andDrCardidGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_cardid >=", value, "drCardid");
            return (Criteria) this;
        }

        public Criteria andDrCardidLessThan(String value) {
            addCriterion("tc_dr_cardid <", value, "drCardid");
            return (Criteria) this;
        }

        public Criteria andDrCardidLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_cardid <=", value, "drCardid");
            return (Criteria) this;
        }

        public Criteria andDrCardidLike(String value) {
            addCriterion("tc_dr_cardid like", value, "drCardid");
            return (Criteria) this;
        }

        public Criteria andDrCardidNotLike(String value) {
            addCriterion("tc_dr_cardid not like", value, "drCardid");
            return (Criteria) this;
        }

        public Criteria andDrCardidIn(List<String> values) {
            addCriterion("tc_dr_cardid in", values, "drCardid");
            return (Criteria) this;
        }

        public Criteria andDrCardidNotIn(List<String> values) {
            addCriterion("tc_dr_cardid not in", values, "drCardid");
            return (Criteria) this;
        }

        public Criteria andDrCardidBetween(String value1, String value2) {
            addCriterion("tc_dr_cardid between", value1, value2, "drCardid");
            return (Criteria) this;
        }

        public Criteria andDrCardidNotBetween(String value1, String value2) {
            addCriterion("tc_dr_cardid not between", value1, value2, "drCardid");
            return (Criteria) this;
        }

        public Criteria andDrDeptCodeIsNull() {
            addCriterion("tc_dr_dept_code is null");
            return (Criteria) this;
        }

        public Criteria andDrDeptCodeIsNotNull() {
            addCriterion("tc_dr_dept_code is not null");
            return (Criteria) this;
        }

        public Criteria andDrDeptCodeEqualTo(String value) {
            addCriterion("tc_dr_dept_code =", value, "drDeptCode");
            return (Criteria) this;
        }

        public Criteria andDrDeptCodeNotEqualTo(String value) {
            addCriterion("tc_dr_dept_code <>", value, "drDeptCode");
            return (Criteria) this;
        }

        public Criteria andDrDeptCodeGreaterThan(String value) {
            addCriterion("tc_dr_dept_code >", value, "drDeptCode");
            return (Criteria) this;
        }

        public Criteria andDrDeptCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_dept_code >=", value, "drDeptCode");
            return (Criteria) this;
        }

        public Criteria andDrDeptCodeLessThan(String value) {
            addCriterion("tc_dr_dept_code <", value, "drDeptCode");
            return (Criteria) this;
        }

        public Criteria andDrDeptCodeLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_dept_code <=", value, "drDeptCode");
            return (Criteria) this;
        }

        public Criteria andDrDeptCodeLike(String value) {
            addCriterion("tc_dr_dept_code like", value, "drDeptCode");
            return (Criteria) this;
        }

        public Criteria andDrDeptCodeNotLike(String value) {
            addCriterion("tc_dr_dept_code not like", value, "drDeptCode");
            return (Criteria) this;
        }

        public Criteria andDrDeptCodeIn(List<String> values) {
            addCriterion("tc_dr_dept_code in", values, "drDeptCode");
            return (Criteria) this;
        }

        public Criteria andDrDeptCodeNotIn(List<String> values) {
            addCriterion("tc_dr_dept_code not in", values, "drDeptCode");
            return (Criteria) this;
        }

        public Criteria andDrDeptCodeBetween(String value1, String value2) {
            addCriterion("tc_dr_dept_code between", value1, value2, "drDeptCode");
            return (Criteria) this;
        }

        public Criteria andDrDeptCodeNotBetween(String value1, String value2) {
            addCriterion("tc_dr_dept_code not between", value1, value2, "drDeptCode");
            return (Criteria) this;
        }

        public Criteria andDrDeptNameIsNull() {
            addCriterion("tc_dr_dept_name is null");
            return (Criteria) this;
        }

        public Criteria andDrDeptNameIsNotNull() {
            addCriterion("tc_dr_dept_name is not null");
            return (Criteria) this;
        }

        public Criteria andDrDeptNameEqualTo(String value) {
            addCriterion("tc_dr_dept_name =", value, "drDeptName");
            return (Criteria) this;
        }

        public Criteria andDrDeptNameNotEqualTo(String value) {
            addCriterion("tc_dr_dept_name <>", value, "drDeptName");
            return (Criteria) this;
        }

        public Criteria andDrDeptNameGreaterThan(String value) {
            addCriterion("tc_dr_dept_name >", value, "drDeptName");
            return (Criteria) this;
        }

        public Criteria andDrDeptNameGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_dept_name >=", value, "drDeptName");
            return (Criteria) this;
        }

        public Criteria andDrDeptNameLessThan(String value) {
            addCriterion("tc_dr_dept_name <", value, "drDeptName");
            return (Criteria) this;
        }

        public Criteria andDrDeptNameLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_dept_name <=", value, "drDeptName");
            return (Criteria) this;
        }

        public Criteria andDrDeptNameLike(String value) {
            addCriterion("tc_dr_dept_name like", value, "drDeptName");
            return (Criteria) this;
        }

        public Criteria andDrDeptNameNotLike(String value) {
            addCriterion("tc_dr_dept_name not like", value, "drDeptName");
            return (Criteria) this;
        }

        public Criteria andDrDeptNameIn(List<String> values) {
            addCriterion("tc_dr_dept_name in", values, "drDeptName");
            return (Criteria) this;
        }

        public Criteria andDrDeptNameNotIn(List<String> values) {
            addCriterion("tc_dr_dept_name not in", values, "drDeptName");
            return (Criteria) this;
        }

        public Criteria andDrDeptNameBetween(String value1, String value2) {
            addCriterion("tc_dr_dept_name between", value1, value2, "drDeptName");
            return (Criteria) this;
        }

        public Criteria andDrDeptNameNotBetween(String value1, String value2) {
            addCriterion("tc_dr_dept_name not between", value1, value2, "drDeptName");
            return (Criteria) this;
        }

        public Criteria andDrLevelCodeIsNull() {
            addCriterion("tc_dr_level_code is null");
            return (Criteria) this;
        }

        public Criteria andDrLevelCodeIsNotNull() {
            addCriterion("tc_dr_level_code is not null");
            return (Criteria) this;
        }

        public Criteria andDrLevelCodeEqualTo(String value) {
            addCriterion("tc_dr_level_code =", value, "drLevelCode");
            return (Criteria) this;
        }

        public Criteria andDrLevelCodeNotEqualTo(String value) {
            addCriterion("tc_dr_level_code <>", value, "drLevelCode");
            return (Criteria) this;
        }

        public Criteria andDrLevelCodeGreaterThan(String value) {
            addCriterion("tc_dr_level_code >", value, "drLevelCode");
            return (Criteria) this;
        }

        public Criteria andDrLevelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_level_code >=", value, "drLevelCode");
            return (Criteria) this;
        }

        public Criteria andDrLevelCodeLessThan(String value) {
            addCriterion("tc_dr_level_code <", value, "drLevelCode");
            return (Criteria) this;
        }

        public Criteria andDrLevelCodeLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_level_code <=", value, "drLevelCode");
            return (Criteria) this;
        }

        public Criteria andDrLevelCodeLike(String value) {
            addCriterion("tc_dr_level_code like", value, "drLevelCode");
            return (Criteria) this;
        }

        public Criteria andDrLevelCodeNotLike(String value) {
            addCriterion("tc_dr_level_code not like", value, "drLevelCode");
            return (Criteria) this;
        }

        public Criteria andDrLevelCodeIn(List<String> values) {
            addCriterion("tc_dr_level_code in", values, "drLevelCode");
            return (Criteria) this;
        }

        public Criteria andDrLevelCodeNotIn(List<String> values) {
            addCriterion("tc_dr_level_code not in", values, "drLevelCode");
            return (Criteria) this;
        }

        public Criteria andDrLevelCodeBetween(String value1, String value2) {
            addCriterion("tc_dr_level_code between", value1, value2, "drLevelCode");
            return (Criteria) this;
        }

        public Criteria andDrLevelCodeNotBetween(String value1, String value2) {
            addCriterion("tc_dr_level_code not between", value1, value2, "drLevelCode");
            return (Criteria) this;
        }

        public Criteria andDrLevelNameIsNull() {
            addCriterion("tc_dr_level_name is null");
            return (Criteria) this;
        }

        public Criteria andDrLevelNameIsNotNull() {
            addCriterion("tc_dr_level_name is not null");
            return (Criteria) this;
        }

        public Criteria andDrLevelNameEqualTo(String value) {
            addCriterion("tc_dr_level_name =", value, "drLevelName");
            return (Criteria) this;
        }

        public Criteria andDrLevelNameNotEqualTo(String value) {
            addCriterion("tc_dr_level_name <>", value, "drLevelName");
            return (Criteria) this;
        }

        public Criteria andDrLevelNameGreaterThan(String value) {
            addCriterion("tc_dr_level_name >", value, "drLevelName");
            return (Criteria) this;
        }

        public Criteria andDrLevelNameGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_level_name >=", value, "drLevelName");
            return (Criteria) this;
        }

        public Criteria andDrLevelNameLessThan(String value) {
            addCriterion("tc_dr_level_name <", value, "drLevelName");
            return (Criteria) this;
        }

        public Criteria andDrLevelNameLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_level_name <=", value, "drLevelName");
            return (Criteria) this;
        }

        public Criteria andDrLevelNameLike(String value) {
            addCriterion("tc_dr_level_name like", value, "drLevelName");
            return (Criteria) this;
        }

        public Criteria andDrLevelNameNotLike(String value) {
            addCriterion("tc_dr_level_name not like", value, "drLevelName");
            return (Criteria) this;
        }

        public Criteria andDrLevelNameIn(List<String> values) {
            addCriterion("tc_dr_level_name in", values, "drLevelName");
            return (Criteria) this;
        }

        public Criteria andDrLevelNameNotIn(List<String> values) {
            addCriterion("tc_dr_level_name not in", values, "drLevelName");
            return (Criteria) this;
        }

        public Criteria andDrLevelNameBetween(String value1, String value2) {
            addCriterion("tc_dr_level_name between", value1, value2, "drLevelName");
            return (Criteria) this;
        }

        public Criteria andDrLevelNameNotBetween(String value1, String value2) {
            addCriterion("tc_dr_level_name not between", value1, value2, "drLevelName");
            return (Criteria) this;
        }

        public Criteria andDrPositionCodeIsNull() {
            addCriterion("tc_dr_position_code is null");
            return (Criteria) this;
        }

        public Criteria andDrPositionCodeIsNotNull() {
            addCriterion("tc_dr_position_code is not null");
            return (Criteria) this;
        }

        public Criteria andDrPositionCodeEqualTo(String value) {
            addCriterion("tc_dr_position_code =", value, "drPositionCode");
            return (Criteria) this;
        }

        public Criteria andDrPositionCodeNotEqualTo(String value) {
            addCriterion("tc_dr_position_code <>", value, "drPositionCode");
            return (Criteria) this;
        }

        public Criteria andDrPositionCodeGreaterThan(String value) {
            addCriterion("tc_dr_position_code >", value, "drPositionCode");
            return (Criteria) this;
        }

        public Criteria andDrPositionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_position_code >=", value, "drPositionCode");
            return (Criteria) this;
        }

        public Criteria andDrPositionCodeLessThan(String value) {
            addCriterion("tc_dr_position_code <", value, "drPositionCode");
            return (Criteria) this;
        }

        public Criteria andDrPositionCodeLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_position_code <=", value, "drPositionCode");
            return (Criteria) this;
        }

        public Criteria andDrPositionCodeLike(String value) {
            addCriterion("tc_dr_position_code like", value, "drPositionCode");
            return (Criteria) this;
        }

        public Criteria andDrPositionCodeNotLike(String value) {
            addCriterion("tc_dr_position_code not like", value, "drPositionCode");
            return (Criteria) this;
        }

        public Criteria andDrPositionCodeIn(List<String> values) {
            addCriterion("tc_dr_position_code in", values, "drPositionCode");
            return (Criteria) this;
        }

        public Criteria andDrPositionCodeNotIn(List<String> values) {
            addCriterion("tc_dr_position_code not in", values, "drPositionCode");
            return (Criteria) this;
        }

        public Criteria andDrPositionCodeBetween(String value1, String value2) {
            addCriterion("tc_dr_position_code between", value1, value2, "drPositionCode");
            return (Criteria) this;
        }

        public Criteria andDrPositionCodeNotBetween(String value1, String value2) {
            addCriterion("tc_dr_position_code not between", value1, value2, "drPositionCode");
            return (Criteria) this;
        }

        public Criteria andDrPositionNameIsNull() {
            addCriterion("tc_dr_position_name is null");
            return (Criteria) this;
        }

        public Criteria andDrPositionNameIsNotNull() {
            addCriterion("tc_dr_position_name is not null");
            return (Criteria) this;
        }

        public Criteria andDrPositionNameEqualTo(String value) {
            addCriterion("tc_dr_position_name =", value, "drPositionName");
            return (Criteria) this;
        }

        public Criteria andDrPositionNameNotEqualTo(String value) {
            addCriterion("tc_dr_position_name <>", value, "drPositionName");
            return (Criteria) this;
        }

        public Criteria andDrPositionNameGreaterThan(String value) {
            addCriterion("tc_dr_position_name >", value, "drPositionName");
            return (Criteria) this;
        }

        public Criteria andDrPositionNameGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_position_name >=", value, "drPositionName");
            return (Criteria) this;
        }

        public Criteria andDrPositionNameLessThan(String value) {
            addCriterion("tc_dr_position_name <", value, "drPositionName");
            return (Criteria) this;
        }

        public Criteria andDrPositionNameLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_position_name <=", value, "drPositionName");
            return (Criteria) this;
        }

        public Criteria andDrPositionNameLike(String value) {
            addCriterion("tc_dr_position_name like", value, "drPositionName");
            return (Criteria) this;
        }

        public Criteria andDrPositionNameNotLike(String value) {
            addCriterion("tc_dr_position_name not like", value, "drPositionName");
            return (Criteria) this;
        }

        public Criteria andDrPositionNameIn(List<String> values) {
            addCriterion("tc_dr_position_name in", values, "drPositionName");
            return (Criteria) this;
        }

        public Criteria andDrPositionNameNotIn(List<String> values) {
            addCriterion("tc_dr_position_name not in", values, "drPositionName");
            return (Criteria) this;
        }

        public Criteria andDrPositionNameBetween(String value1, String value2) {
            addCriterion("tc_dr_position_name between", value1, value2, "drPositionName");
            return (Criteria) this;
        }

        public Criteria andDrPositionNameNotBetween(String value1, String value2) {
            addCriterion("tc_dr_position_name not between", value1, value2, "drPositionName");
            return (Criteria) this;
        }

        public Criteria andDrPhotoIsNull() {
            addCriterion("tc_dr_photo is null");
            return (Criteria) this;
        }

        public Criteria andDrPhotoIsNotNull() {
            addCriterion("tc_dr_photo is not null");
            return (Criteria) this;
        }

        public Criteria andDrPhotoEqualTo(String value) {
            addCriterion("tc_dr_photo =", value, "drPhoto");
            return (Criteria) this;
        }

        public Criteria andDrPhotoNotEqualTo(String value) {
            addCriterion("tc_dr_photo <>", value, "drPhoto");
            return (Criteria) this;
        }

        public Criteria andDrPhotoGreaterThan(String value) {
            addCriterion("tc_dr_photo >", value, "drPhoto");
            return (Criteria) this;
        }

        public Criteria andDrPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_photo >=", value, "drPhoto");
            return (Criteria) this;
        }

        public Criteria andDrPhotoLessThan(String value) {
            addCriterion("tc_dr_photo <", value, "drPhoto");
            return (Criteria) this;
        }

        public Criteria andDrPhotoLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_photo <=", value, "drPhoto");
            return (Criteria) this;
        }

        public Criteria andDrPhotoLike(String value) {
            addCriterion("tc_dr_photo like", value, "drPhoto");
            return (Criteria) this;
        }

        public Criteria andDrPhotoNotLike(String value) {
            addCriterion("tc_dr_photo not like", value, "drPhoto");
            return (Criteria) this;
        }

        public Criteria andDrPhotoIn(List<String> values) {
            addCriterion("tc_dr_photo in", values, "drPhoto");
            return (Criteria) this;
        }

        public Criteria andDrPhotoNotIn(List<String> values) {
            addCriterion("tc_dr_photo not in", values, "drPhoto");
            return (Criteria) this;
        }

        public Criteria andDrPhotoBetween(String value1, String value2) {
            addCriterion("tc_dr_photo between", value1, value2, "drPhoto");
            return (Criteria) this;
        }

        public Criteria andDrPhotoNotBetween(String value1, String value2) {
            addCriterion("tc_dr_photo not between", value1, value2, "drPhoto");
            return (Criteria) this;
        }

        public Criteria andDrPhoneIsNull() {
            addCriterion("tc_dr_phone is null");
            return (Criteria) this;
        }

        public Criteria andDrPhoneIsNotNull() {
            addCriterion("tc_dr_phone is not null");
            return (Criteria) this;
        }

        public Criteria andDrPhoneEqualTo(String value) {
            addCriterion("tc_dr_phone =", value, "drPhone");
            return (Criteria) this;
        }

        public Criteria andDrPhoneNotEqualTo(String value) {
            addCriterion("tc_dr_phone <>", value, "drPhone");
            return (Criteria) this;
        }

        public Criteria andDrPhoneGreaterThan(String value) {
            addCriterion("tc_dr_phone >", value, "drPhone");
            return (Criteria) this;
        }

        public Criteria andDrPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_phone >=", value, "drPhone");
            return (Criteria) this;
        }

        public Criteria andDrPhoneLessThan(String value) {
            addCriterion("tc_dr_phone <", value, "drPhone");
            return (Criteria) this;
        }

        public Criteria andDrPhoneLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_phone <=", value, "drPhone");
            return (Criteria) this;
        }

        public Criteria andDrPhoneLike(String value) {
            addCriterion("tc_dr_phone like", value, "drPhone");
            return (Criteria) this;
        }

        public Criteria andDrPhoneNotLike(String value) {
            addCriterion("tc_dr_phone not like", value, "drPhone");
            return (Criteria) this;
        }

        public Criteria andDrPhoneIn(List<String> values) {
            addCriterion("tc_dr_phone in", values, "drPhone");
            return (Criteria) this;
        }

        public Criteria andDrPhoneNotIn(List<String> values) {
            addCriterion("tc_dr_phone not in", values, "drPhone");
            return (Criteria) this;
        }

        public Criteria andDrPhoneBetween(String value1, String value2) {
            addCriterion("tc_dr_phone between", value1, value2, "drPhone");
            return (Criteria) this;
        }

        public Criteria andDrPhoneNotBetween(String value1, String value2) {
            addCriterion("tc_dr_phone not between", value1, value2, "drPhone");
            return (Criteria) this;
        }

        public Criteria andDrEmailIsNull() {
            addCriterion("tc_dr_email is null");
            return (Criteria) this;
        }

        public Criteria andDrEmailIsNotNull() {
            addCriterion("tc_dr_email is not null");
            return (Criteria) this;
        }

        public Criteria andDrEmailEqualTo(String value) {
            addCriterion("tc_dr_email =", value, "drEmail");
            return (Criteria) this;
        }

        public Criteria andDrEmailNotEqualTo(String value) {
            addCriterion("tc_dr_email <>", value, "drEmail");
            return (Criteria) this;
        }

        public Criteria andDrEmailGreaterThan(String value) {
            addCriterion("tc_dr_email >", value, "drEmail");
            return (Criteria) this;
        }

        public Criteria andDrEmailGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_email >=", value, "drEmail");
            return (Criteria) this;
        }

        public Criteria andDrEmailLessThan(String value) {
            addCriterion("tc_dr_email <", value, "drEmail");
            return (Criteria) this;
        }

        public Criteria andDrEmailLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_email <=", value, "drEmail");
            return (Criteria) this;
        }

        public Criteria andDrEmailLike(String value) {
            addCriterion("tc_dr_email like", value, "drEmail");
            return (Criteria) this;
        }

        public Criteria andDrEmailNotLike(String value) {
            addCriterion("tc_dr_email not like", value, "drEmail");
            return (Criteria) this;
        }

        public Criteria andDrEmailIn(List<String> values) {
            addCriterion("tc_dr_email in", values, "drEmail");
            return (Criteria) this;
        }

        public Criteria andDrEmailNotIn(List<String> values) {
            addCriterion("tc_dr_email not in", values, "drEmail");
            return (Criteria) this;
        }

        public Criteria andDrEmailBetween(String value1, String value2) {
            addCriterion("tc_dr_email between", value1, value2, "drEmail");
            return (Criteria) this;
        }

        public Criteria andDrEmailNotBetween(String value1, String value2) {
            addCriterion("tc_dr_email not between", value1, value2, "drEmail");
            return (Criteria) this;
        }

        public Criteria andDrSexIsNull() {
            addCriterion("tc_dr_sex is null");
            return (Criteria) this;
        }

        public Criteria andDrSexIsNotNull() {
            addCriterion("tc_dr_sex is not null");
            return (Criteria) this;
        }

        public Criteria andDrSexEqualTo(String value) {
            addCriterion("tc_dr_sex =", value, "drSex");
            return (Criteria) this;
        }

        public Criteria andDrSexNotEqualTo(String value) {
            addCriterion("tc_dr_sex <>", value, "drSex");
            return (Criteria) this;
        }

        public Criteria andDrSexGreaterThan(String value) {
            addCriterion("tc_dr_sex >", value, "drSex");
            return (Criteria) this;
        }

        public Criteria andDrSexGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_sex >=", value, "drSex");
            return (Criteria) this;
        }

        public Criteria andDrSexLessThan(String value) {
            addCriterion("tc_dr_sex <", value, "drSex");
            return (Criteria) this;
        }

        public Criteria andDrSexLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_sex <=", value, "drSex");
            return (Criteria) this;
        }

        public Criteria andDrSexLike(String value) {
            addCriterion("tc_dr_sex like", value, "drSex");
            return (Criteria) this;
        }

        public Criteria andDrSexNotLike(String value) {
            addCriterion("tc_dr_sex not like", value, "drSex");
            return (Criteria) this;
        }

        public Criteria andDrSexIn(List<String> values) {
            addCriterion("tc_dr_sex in", values, "drSex");
            return (Criteria) this;
        }

        public Criteria andDrSexNotIn(List<String> values) {
            addCriterion("tc_dr_sex not in", values, "drSex");
            return (Criteria) this;
        }

        public Criteria andDrSexBetween(String value1, String value2) {
            addCriterion("tc_dr_sex between", value1, value2, "drSex");
            return (Criteria) this;
        }

        public Criteria andDrSexNotBetween(String value1, String value2) {
            addCriterion("tc_dr_sex not between", value1, value2, "drSex");
            return (Criteria) this;
        }

        public Criteria andDrBirthdayIsNull() {
            addCriterion("tc_dr_birthday is null");
            return (Criteria) this;
        }

        public Criteria andDrBirthdayIsNotNull() {
            addCriterion("tc_dr_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andDrBirthdayEqualTo(Date value) {
            addCriterion("tc_dr_birthday =", value, "drBirthday");
            return (Criteria) this;
        }

        public Criteria andDrBirthdayNotEqualTo(Date value) {
            addCriterion("tc_dr_birthday <>", value, "drBirthday");
            return (Criteria) this;
        }

        public Criteria andDrBirthdayGreaterThan(Date value) {
            addCriterion("tc_dr_birthday >", value, "drBirthday");
            return (Criteria) this;
        }

        public Criteria andDrBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("tc_dr_birthday >=", value, "drBirthday");
            return (Criteria) this;
        }

        public Criteria andDrBirthdayLessThan(Date value) {
            addCriterion("tc_dr_birthday <", value, "drBirthday");
            return (Criteria) this;
        }

        public Criteria andDrBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("tc_dr_birthday <=", value, "drBirthday");
            return (Criteria) this;
        }

        public Criteria andDrBirthdayIn(List<Date> values) {
            addCriterion("tc_dr_birthday in", values, "drBirthday");
            return (Criteria) this;
        }

        public Criteria andDrBirthdayNotIn(List<Date> values) {
            addCriterion("tc_dr_birthday not in", values, "drBirthday");
            return (Criteria) this;
        }

        public Criteria andDrBirthdayBetween(Date value1, Date value2) {
            addCriterion("tc_dr_birthday between", value1, value2, "drBirthday");
            return (Criteria) this;
        }

        public Criteria andDrBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("tc_dr_birthday not between", value1, value2, "drBirthday");
            return (Criteria) this;
        }

        public Criteria andDrEduIsNull() {
            addCriterion("tc_dr_edu is null");
            return (Criteria) this;
        }

        public Criteria andDrEduIsNotNull() {
            addCriterion("tc_dr_edu is not null");
            return (Criteria) this;
        }

        public Criteria andDrEduEqualTo(String value) {
            addCriterion("tc_dr_edu =", value, "drEdu");
            return (Criteria) this;
        }

        public Criteria andDrEduNotEqualTo(String value) {
            addCriterion("tc_dr_edu <>", value, "drEdu");
            return (Criteria) this;
        }

        public Criteria andDrEduGreaterThan(String value) {
            addCriterion("tc_dr_edu >", value, "drEdu");
            return (Criteria) this;
        }

        public Criteria andDrEduGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_edu >=", value, "drEdu");
            return (Criteria) this;
        }

        public Criteria andDrEduLessThan(String value) {
            addCriterion("tc_dr_edu <", value, "drEdu");
            return (Criteria) this;
        }

        public Criteria andDrEduLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_edu <=", value, "drEdu");
            return (Criteria) this;
        }

        public Criteria andDrEduLike(String value) {
            addCriterion("tc_dr_edu like", value, "drEdu");
            return (Criteria) this;
        }

        public Criteria andDrEduNotLike(String value) {
            addCriterion("tc_dr_edu not like", value, "drEdu");
            return (Criteria) this;
        }

        public Criteria andDrEduIn(List<String> values) {
            addCriterion("tc_dr_edu in", values, "drEdu");
            return (Criteria) this;
        }

        public Criteria andDrEduNotIn(List<String> values) {
            addCriterion("tc_dr_edu not in", values, "drEdu");
            return (Criteria) this;
        }

        public Criteria andDrEduBetween(String value1, String value2) {
            addCriterion("tc_dr_edu between", value1, value2, "drEdu");
            return (Criteria) this;
        }

        public Criteria andDrEduNotBetween(String value1, String value2) {
            addCriterion("tc_dr_edu not between", value1, value2, "drEdu");
            return (Criteria) this;
        }

        public Criteria andDrCountryIsNull() {
            addCriterion("tc_dr_country is null");
            return (Criteria) this;
        }

        public Criteria andDrCountryIsNotNull() {
            addCriterion("tc_dr_country is not null");
            return (Criteria) this;
        }

        public Criteria andDrCountryEqualTo(String value) {
            addCriterion("tc_dr_country =", value, "drCountry");
            return (Criteria) this;
        }

        public Criteria andDrCountryNotEqualTo(String value) {
            addCriterion("tc_dr_country <>", value, "drCountry");
            return (Criteria) this;
        }

        public Criteria andDrCountryGreaterThan(String value) {
            addCriterion("tc_dr_country >", value, "drCountry");
            return (Criteria) this;
        }

        public Criteria andDrCountryGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_country >=", value, "drCountry");
            return (Criteria) this;
        }

        public Criteria andDrCountryLessThan(String value) {
            addCriterion("tc_dr_country <", value, "drCountry");
            return (Criteria) this;
        }

        public Criteria andDrCountryLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_country <=", value, "drCountry");
            return (Criteria) this;
        }

        public Criteria andDrCountryLike(String value) {
            addCriterion("tc_dr_country like", value, "drCountry");
            return (Criteria) this;
        }

        public Criteria andDrCountryNotLike(String value) {
            addCriterion("tc_dr_country not like", value, "drCountry");
            return (Criteria) this;
        }

        public Criteria andDrCountryIn(List<String> values) {
            addCriterion("tc_dr_country in", values, "drCountry");
            return (Criteria) this;
        }

        public Criteria andDrCountryNotIn(List<String> values) {
            addCriterion("tc_dr_country not in", values, "drCountry");
            return (Criteria) this;
        }

        public Criteria andDrCountryBetween(String value1, String value2) {
            addCriterion("tc_dr_country between", value1, value2, "drCountry");
            return (Criteria) this;
        }

        public Criteria andDrCountryNotBetween(String value1, String value2) {
            addCriterion("tc_dr_country not between", value1, value2, "drCountry");
            return (Criteria) this;
        }

        public Criteria andDrNationIsNull() {
            addCriterion("tc_dr_nation is null");
            return (Criteria) this;
        }

        public Criteria andDrNationIsNotNull() {
            addCriterion("tc_dr_nation is not null");
            return (Criteria) this;
        }

        public Criteria andDrNationEqualTo(String value) {
            addCriterion("tc_dr_nation =", value, "drNation");
            return (Criteria) this;
        }

        public Criteria andDrNationNotEqualTo(String value) {
            addCriterion("tc_dr_nation <>", value, "drNation");
            return (Criteria) this;
        }

        public Criteria andDrNationGreaterThan(String value) {
            addCriterion("tc_dr_nation >", value, "drNation");
            return (Criteria) this;
        }

        public Criteria andDrNationGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_nation >=", value, "drNation");
            return (Criteria) this;
        }

        public Criteria andDrNationLessThan(String value) {
            addCriterion("tc_dr_nation <", value, "drNation");
            return (Criteria) this;
        }

        public Criteria andDrNationLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_nation <=", value, "drNation");
            return (Criteria) this;
        }

        public Criteria andDrNationLike(String value) {
            addCriterion("tc_dr_nation like", value, "drNation");
            return (Criteria) this;
        }

        public Criteria andDrNationNotLike(String value) {
            addCriterion("tc_dr_nation not like", value, "drNation");
            return (Criteria) this;
        }

        public Criteria andDrNationIn(List<String> values) {
            addCriterion("tc_dr_nation in", values, "drNation");
            return (Criteria) this;
        }

        public Criteria andDrNationNotIn(List<String> values) {
            addCriterion("tc_dr_nation not in", values, "drNation");
            return (Criteria) this;
        }

        public Criteria andDrNationBetween(String value1, String value2) {
            addCriterion("tc_dr_nation between", value1, value2, "drNation");
            return (Criteria) this;
        }

        public Criteria andDrNationNotBetween(String value1, String value2) {
            addCriterion("tc_dr_nation not between", value1, value2, "drNation");
            return (Criteria) this;
        }

        public Criteria andDrNativePlaceIsNull() {
            addCriterion("tc_dr_native_place is null");
            return (Criteria) this;
        }

        public Criteria andDrNativePlaceIsNotNull() {
            addCriterion("tc_dr_native_place is not null");
            return (Criteria) this;
        }

        public Criteria andDrNativePlaceEqualTo(String value) {
            addCriterion("tc_dr_native_place =", value, "drNativePlace");
            return (Criteria) this;
        }

        public Criteria andDrNativePlaceNotEqualTo(String value) {
            addCriterion("tc_dr_native_place <>", value, "drNativePlace");
            return (Criteria) this;
        }

        public Criteria andDrNativePlaceGreaterThan(String value) {
            addCriterion("tc_dr_native_place >", value, "drNativePlace");
            return (Criteria) this;
        }

        public Criteria andDrNativePlaceGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_native_place >=", value, "drNativePlace");
            return (Criteria) this;
        }

        public Criteria andDrNativePlaceLessThan(String value) {
            addCriterion("tc_dr_native_place <", value, "drNativePlace");
            return (Criteria) this;
        }

        public Criteria andDrNativePlaceLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_native_place <=", value, "drNativePlace");
            return (Criteria) this;
        }

        public Criteria andDrNativePlaceLike(String value) {
            addCriterion("tc_dr_native_place like", value, "drNativePlace");
            return (Criteria) this;
        }

        public Criteria andDrNativePlaceNotLike(String value) {
            addCriterion("tc_dr_native_place not like", value, "drNativePlace");
            return (Criteria) this;
        }

        public Criteria andDrNativePlaceIn(List<String> values) {
            addCriterion("tc_dr_native_place in", values, "drNativePlace");
            return (Criteria) this;
        }

        public Criteria andDrNativePlaceNotIn(List<String> values) {
            addCriterion("tc_dr_native_place not in", values, "drNativePlace");
            return (Criteria) this;
        }

        public Criteria andDrNativePlaceBetween(String value1, String value2) {
            addCriterion("tc_dr_native_place between", value1, value2, "drNativePlace");
            return (Criteria) this;
        }

        public Criteria andDrNativePlaceNotBetween(String value1, String value2) {
            addCriterion("tc_dr_native_place not between", value1, value2, "drNativePlace");
            return (Criteria) this;
        }

        public Criteria andDrStateIsNull() {
            addCriterion("tc_dr_state is null");
            return (Criteria) this;
        }

        public Criteria andDrStateIsNotNull() {
            addCriterion("tc_dr_state is not null");
            return (Criteria) this;
        }

        public Criteria andDrStateEqualTo(String value) {
            addCriterion("tc_dr_state =", value, "drState");
            return (Criteria) this;
        }

        public Criteria andDrStateNotEqualTo(String value) {
            addCriterion("tc_dr_state <>", value, "drState");
            return (Criteria) this;
        }

        public Criteria andDrStateGreaterThan(String value) {
            addCriterion("tc_dr_state >", value, "drState");
            return (Criteria) this;
        }

        public Criteria andDrStateGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_state >=", value, "drState");
            return (Criteria) this;
        }

        public Criteria andDrStateLessThan(String value) {
            addCriterion("tc_dr_state <", value, "drState");
            return (Criteria) this;
        }

        public Criteria andDrStateLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_state <=", value, "drState");
            return (Criteria) this;
        }

        public Criteria andDrStateLike(String value) {
            addCriterion("tc_dr_state like", value, "drState");
            return (Criteria) this;
        }

        public Criteria andDrStateNotLike(String value) {
            addCriterion("tc_dr_state not like", value, "drState");
            return (Criteria) this;
        }

        public Criteria andDrStateIn(List<String> values) {
            addCriterion("tc_dr_state in", values, "drState");
            return (Criteria) this;
        }

        public Criteria andDrStateNotIn(List<String> values) {
            addCriterion("tc_dr_state not in", values, "drState");
            return (Criteria) this;
        }

        public Criteria andDrStateBetween(String value1, String value2) {
            addCriterion("tc_dr_state between", value1, value2, "drState");
            return (Criteria) this;
        }

        public Criteria andDrStateNotBetween(String value1, String value2) {
            addCriterion("tc_dr_state not between", value1, value2, "drState");
            return (Criteria) this;
        }

        public Criteria andDrIntroduceIsNull() {
            addCriterion("tc_dr_introduce is null");
            return (Criteria) this;
        }

        public Criteria andDrIntroduceIsNotNull() {
            addCriterion("tc_dr_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andDrIntroduceEqualTo(String value) {
            addCriterion("tc_dr_introduce =", value, "drIntroduce");
            return (Criteria) this;
        }

        public Criteria andDrIntroduceNotEqualTo(String value) {
            addCriterion("tc_dr_introduce <>", value, "drIntroduce");
            return (Criteria) this;
        }

        public Criteria andDrIntroduceGreaterThan(String value) {
            addCriterion("tc_dr_introduce >", value, "drIntroduce");
            return (Criteria) this;
        }

        public Criteria andDrIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_introduce >=", value, "drIntroduce");
            return (Criteria) this;
        }

        public Criteria andDrIntroduceLessThan(String value) {
            addCriterion("tc_dr_introduce <", value, "drIntroduce");
            return (Criteria) this;
        }

        public Criteria andDrIntroduceLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_introduce <=", value, "drIntroduce");
            return (Criteria) this;
        }

        public Criteria andDrIntroduceLike(String value) {
            addCriterion("tc_dr_introduce like", value, "drIntroduce");
            return (Criteria) this;
        }

        public Criteria andDrIntroduceNotLike(String value) {
            addCriterion("tc_dr_introduce not like", value, "drIntroduce");
            return (Criteria) this;
        }

        public Criteria andDrIntroduceIn(List<String> values) {
            addCriterion("tc_dr_introduce in", values, "drIntroduce");
            return (Criteria) this;
        }

        public Criteria andDrIntroduceNotIn(List<String> values) {
            addCriterion("tc_dr_introduce not in", values, "drIntroduce");
            return (Criteria) this;
        }

        public Criteria andDrIntroduceBetween(String value1, String value2) {
            addCriterion("tc_dr_introduce between", value1, value2, "drIntroduce");
            return (Criteria) this;
        }

        public Criteria andDrIntroduceNotBetween(String value1, String value2) {
            addCriterion("tc_dr_introduce not between", value1, value2, "drIntroduce");
            return (Criteria) this;
        }

        public Criteria andDrGoodIsNull() {
            addCriterion("tc_dr_good is null");
            return (Criteria) this;
        }

        public Criteria andDrGoodIsNotNull() {
            addCriterion("tc_dr_good is not null");
            return (Criteria) this;
        }

        public Criteria andDrGoodEqualTo(String value) {
            addCriterion("tc_dr_good =", value, "drGood");
            return (Criteria) this;
        }

        public Criteria andDrGoodNotEqualTo(String value) {
            addCriterion("tc_dr_good <>", value, "drGood");
            return (Criteria) this;
        }

        public Criteria andDrGoodGreaterThan(String value) {
            addCriterion("tc_dr_good >", value, "drGood");
            return (Criteria) this;
        }

        public Criteria andDrGoodGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_good >=", value, "drGood");
            return (Criteria) this;
        }

        public Criteria andDrGoodLessThan(String value) {
            addCriterion("tc_dr_good <", value, "drGood");
            return (Criteria) this;
        }

        public Criteria andDrGoodLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_good <=", value, "drGood");
            return (Criteria) this;
        }

        public Criteria andDrGoodLike(String value) {
            addCriterion("tc_dr_good like", value, "drGood");
            return (Criteria) this;
        }

        public Criteria andDrGoodNotLike(String value) {
            addCriterion("tc_dr_good not like", value, "drGood");
            return (Criteria) this;
        }

        public Criteria andDrGoodIn(List<String> values) {
            addCriterion("tc_dr_good in", values, "drGood");
            return (Criteria) this;
        }

        public Criteria andDrGoodNotIn(List<String> values) {
            addCriterion("tc_dr_good not in", values, "drGood");
            return (Criteria) this;
        }

        public Criteria andDrGoodBetween(String value1, String value2) {
            addCriterion("tc_dr_good between", value1, value2, "drGood");
            return (Criteria) this;
        }

        public Criteria andDrGoodNotBetween(String value1, String value2) {
            addCriterion("tc_dr_good not between", value1, value2, "drGood");
            return (Criteria) this;
        }

        public Criteria andDrExpertCodeIsNull() {
            addCriterion("tc_dr_expert_code is null");
            return (Criteria) this;
        }

        public Criteria andDrExpertCodeIsNotNull() {
            addCriterion("tc_dr_expert_code is not null");
            return (Criteria) this;
        }

        public Criteria andDrExpertCodeEqualTo(String value) {
            addCriterion("tc_dr_expert_code =", value, "drExpertCode");
            return (Criteria) this;
        }

        public Criteria andDrExpertCodeNotEqualTo(String value) {
            addCriterion("tc_dr_expert_code <>", value, "drExpertCode");
            return (Criteria) this;
        }

        public Criteria andDrExpertCodeGreaterThan(String value) {
            addCriterion("tc_dr_expert_code >", value, "drExpertCode");
            return (Criteria) this;
        }

        public Criteria andDrExpertCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_expert_code >=", value, "drExpertCode");
            return (Criteria) this;
        }

        public Criteria andDrExpertCodeLessThan(String value) {
            addCriterion("tc_dr_expert_code <", value, "drExpertCode");
            return (Criteria) this;
        }

        public Criteria andDrExpertCodeLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_expert_code <=", value, "drExpertCode");
            return (Criteria) this;
        }

        public Criteria andDrExpertCodeLike(String value) {
            addCriterion("tc_dr_expert_code like", value, "drExpertCode");
            return (Criteria) this;
        }

        public Criteria andDrExpertCodeNotLike(String value) {
            addCriterion("tc_dr_expert_code not like", value, "drExpertCode");
            return (Criteria) this;
        }

        public Criteria andDrExpertCodeIn(List<String> values) {
            addCriterion("tc_dr_expert_code in", values, "drExpertCode");
            return (Criteria) this;
        }

        public Criteria andDrExpertCodeNotIn(List<String> values) {
            addCriterion("tc_dr_expert_code not in", values, "drExpertCode");
            return (Criteria) this;
        }

        public Criteria andDrExpertCodeBetween(String value1, String value2) {
            addCriterion("tc_dr_expert_code between", value1, value2, "drExpertCode");
            return (Criteria) this;
        }

        public Criteria andDrExpertCodeNotBetween(String value1, String value2) {
            addCriterion("tc_dr_expert_code not between", value1, value2, "drExpertCode");
            return (Criteria) this;
        }

        public Criteria andDrExpertNameIsNull() {
            addCriterion("tc_dr_expert_name is null");
            return (Criteria) this;
        }

        public Criteria andDrExpertNameIsNotNull() {
            addCriterion("tc_dr_expert_name is not null");
            return (Criteria) this;
        }

        public Criteria andDrExpertNameEqualTo(String value) {
            addCriterion("tc_dr_expert_name =", value, "drExpertName");
            return (Criteria) this;
        }

        public Criteria andDrExpertNameNotEqualTo(String value) {
            addCriterion("tc_dr_expert_name <>", value, "drExpertName");
            return (Criteria) this;
        }

        public Criteria andDrExpertNameGreaterThan(String value) {
            addCriterion("tc_dr_expert_name >", value, "drExpertName");
            return (Criteria) this;
        }

        public Criteria andDrExpertNameGreaterThanOrEqualTo(String value) {
            addCriterion("tc_dr_expert_name >=", value, "drExpertName");
            return (Criteria) this;
        }

        public Criteria andDrExpertNameLessThan(String value) {
            addCriterion("tc_dr_expert_name <", value, "drExpertName");
            return (Criteria) this;
        }

        public Criteria andDrExpertNameLessThanOrEqualTo(String value) {
            addCriterion("tc_dr_expert_name <=", value, "drExpertName");
            return (Criteria) this;
        }

        public Criteria andDrExpertNameLike(String value) {
            addCriterion("tc_dr_expert_name like", value, "drExpertName");
            return (Criteria) this;
        }

        public Criteria andDrExpertNameNotLike(String value) {
            addCriterion("tc_dr_expert_name not like", value, "drExpertName");
            return (Criteria) this;
        }

        public Criteria andDrExpertNameIn(List<String> values) {
            addCriterion("tc_dr_expert_name in", values, "drExpertName");
            return (Criteria) this;
        }

        public Criteria andDrExpertNameNotIn(List<String> values) {
            addCriterion("tc_dr_expert_name not in", values, "drExpertName");
            return (Criteria) this;
        }

        public Criteria andDrExpertNameBetween(String value1, String value2) {
            addCriterion("tc_dr_expert_name between", value1, value2, "drExpertName");
            return (Criteria) this;
        }

        public Criteria andDrExpertNameNotBetween(String value1, String value2) {
            addCriterion("tc_dr_expert_name not between", value1, value2, "drExpertName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}