package com.xiaoshu.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EmpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmpExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andTbEmpIdIsNull() {
            addCriterion("tb_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andTbEmpIdIsNotNull() {
            addCriterion("tb_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andTbEmpIdEqualTo(Integer value) {
            addCriterion("tb_emp_id =", value, "tbEmpId");
            return (Criteria) this;
        }

        public Criteria andTbEmpIdNotEqualTo(Integer value) {
            addCriterion("tb_emp_id <>", value, "tbEmpId");
            return (Criteria) this;
        }

        public Criteria andTbEmpIdGreaterThan(Integer value) {
            addCriterion("tb_emp_id >", value, "tbEmpId");
            return (Criteria) this;
        }

        public Criteria andTbEmpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tb_emp_id >=", value, "tbEmpId");
            return (Criteria) this;
        }

        public Criteria andTbEmpIdLessThan(Integer value) {
            addCriterion("tb_emp_id <", value, "tbEmpId");
            return (Criteria) this;
        }

        public Criteria andTbEmpIdLessThanOrEqualTo(Integer value) {
            addCriterion("tb_emp_id <=", value, "tbEmpId");
            return (Criteria) this;
        }

        public Criteria andTbEmpIdIn(List<Integer> values) {
            addCriterion("tb_emp_id in", values, "tbEmpId");
            return (Criteria) this;
        }

        public Criteria andTbEmpIdNotIn(List<Integer> values) {
            addCriterion("tb_emp_id not in", values, "tbEmpId");
            return (Criteria) this;
        }

        public Criteria andTbEmpIdBetween(Integer value1, Integer value2) {
            addCriterion("tb_emp_id between", value1, value2, "tbEmpId");
            return (Criteria) this;
        }

        public Criteria andTbEmpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tb_emp_id not between", value1, value2, "tbEmpId");
            return (Criteria) this;
        }

        public Criteria andTbEmpNameIsNull() {
            addCriterion("tb_emp_name is null");
            return (Criteria) this;
        }

        public Criteria andTbEmpNameIsNotNull() {
            addCriterion("tb_emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andTbEmpNameEqualTo(String value) {
            addCriterion("tb_emp_name =", value, "tbEmpName");
            return (Criteria) this;
        }

        public Criteria andTbEmpNameNotEqualTo(String value) {
            addCriterion("tb_emp_name <>", value, "tbEmpName");
            return (Criteria) this;
        }

        public Criteria andTbEmpNameGreaterThan(String value) {
            addCriterion("tb_emp_name >", value, "tbEmpName");
            return (Criteria) this;
        }

        public Criteria andTbEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("tb_emp_name >=", value, "tbEmpName");
            return (Criteria) this;
        }

        public Criteria andTbEmpNameLessThan(String value) {
            addCriterion("tb_emp_name <", value, "tbEmpName");
            return (Criteria) this;
        }

        public Criteria andTbEmpNameLessThanOrEqualTo(String value) {
            addCriterion("tb_emp_name <=", value, "tbEmpName");
            return (Criteria) this;
        }

        public Criteria andTbEmpNameLike(String value) {
            addCriterion("tb_emp_name like", value, "tbEmpName");
            return (Criteria) this;
        }

        public Criteria andTbEmpNameNotLike(String value) {
            addCriterion("tb_emp_name not like", value, "tbEmpName");
            return (Criteria) this;
        }

        public Criteria andTbEmpNameIn(List<String> values) {
            addCriterion("tb_emp_name in", values, "tbEmpName");
            return (Criteria) this;
        }

        public Criteria andTbEmpNameNotIn(List<String> values) {
            addCriterion("tb_emp_name not in", values, "tbEmpName");
            return (Criteria) this;
        }

        public Criteria andTbEmpNameBetween(String value1, String value2) {
            addCriterion("tb_emp_name between", value1, value2, "tbEmpName");
            return (Criteria) this;
        }

        public Criteria andTbEmpNameNotBetween(String value1, String value2) {
            addCriterion("tb_emp_name not between", value1, value2, "tbEmpName");
            return (Criteria) this;
        }

        public Criteria andTbEmpSexIsNull() {
            addCriterion("tb_emp_sex is null");
            return (Criteria) this;
        }

        public Criteria andTbEmpSexIsNotNull() {
            addCriterion("tb_emp_sex is not null");
            return (Criteria) this;
        }

        public Criteria andTbEmpSexEqualTo(String value) {
            addCriterion("tb_emp_sex =", value, "tbEmpSex");
            return (Criteria) this;
        }

        public Criteria andTbEmpSexNotEqualTo(String value) {
            addCriterion("tb_emp_sex <>", value, "tbEmpSex");
            return (Criteria) this;
        }

        public Criteria andTbEmpSexGreaterThan(String value) {
            addCriterion("tb_emp_sex >", value, "tbEmpSex");
            return (Criteria) this;
        }

        public Criteria andTbEmpSexGreaterThanOrEqualTo(String value) {
            addCriterion("tb_emp_sex >=", value, "tbEmpSex");
            return (Criteria) this;
        }

        public Criteria andTbEmpSexLessThan(String value) {
            addCriterion("tb_emp_sex <", value, "tbEmpSex");
            return (Criteria) this;
        }

        public Criteria andTbEmpSexLessThanOrEqualTo(String value) {
            addCriterion("tb_emp_sex <=", value, "tbEmpSex");
            return (Criteria) this;
        }

        public Criteria andTbEmpSexLike(String value) {
            addCriterion("tb_emp_sex like", value, "tbEmpSex");
            return (Criteria) this;
        }

        public Criteria andTbEmpSexNotLike(String value) {
            addCriterion("tb_emp_sex not like", value, "tbEmpSex");
            return (Criteria) this;
        }

        public Criteria andTbEmpSexIn(List<String> values) {
            addCriterion("tb_emp_sex in", values, "tbEmpSex");
            return (Criteria) this;
        }

        public Criteria andTbEmpSexNotIn(List<String> values) {
            addCriterion("tb_emp_sex not in", values, "tbEmpSex");
            return (Criteria) this;
        }

        public Criteria andTbEmpSexBetween(String value1, String value2) {
            addCriterion("tb_emp_sex between", value1, value2, "tbEmpSex");
            return (Criteria) this;
        }

        public Criteria andTbEmpSexNotBetween(String value1, String value2) {
            addCriterion("tb_emp_sex not between", value1, value2, "tbEmpSex");
            return (Criteria) this;
        }

        public Criteria andTbEmpAgeIsNull() {
            addCriterion("tb_emp_age is null");
            return (Criteria) this;
        }

        public Criteria andTbEmpAgeIsNotNull() {
            addCriterion("tb_emp_age is not null");
            return (Criteria) this;
        }

        public Criteria andTbEmpAgeEqualTo(Integer value) {
            addCriterion("tb_emp_age =", value, "tbEmpAge");
            return (Criteria) this;
        }

        public Criteria andTbEmpAgeNotEqualTo(Integer value) {
            addCriterion("tb_emp_age <>", value, "tbEmpAge");
            return (Criteria) this;
        }

        public Criteria andTbEmpAgeGreaterThan(Integer value) {
            addCriterion("tb_emp_age >", value, "tbEmpAge");
            return (Criteria) this;
        }

        public Criteria andTbEmpAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("tb_emp_age >=", value, "tbEmpAge");
            return (Criteria) this;
        }

        public Criteria andTbEmpAgeLessThan(Integer value) {
            addCriterion("tb_emp_age <", value, "tbEmpAge");
            return (Criteria) this;
        }

        public Criteria andTbEmpAgeLessThanOrEqualTo(Integer value) {
            addCriterion("tb_emp_age <=", value, "tbEmpAge");
            return (Criteria) this;
        }

        public Criteria andTbEmpAgeIn(List<Integer> values) {
            addCriterion("tb_emp_age in", values, "tbEmpAge");
            return (Criteria) this;
        }

        public Criteria andTbEmpAgeNotIn(List<Integer> values) {
            addCriterion("tb_emp_age not in", values, "tbEmpAge");
            return (Criteria) this;
        }

        public Criteria andTbEmpAgeBetween(Integer value1, Integer value2) {
            addCriterion("tb_emp_age between", value1, value2, "tbEmpAge");
            return (Criteria) this;
        }

        public Criteria andTbEmpAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("tb_emp_age not between", value1, value2, "tbEmpAge");
            return (Criteria) this;
        }

        public Criteria andTbEmpAddressIsNull() {
            addCriterion("tb_emp_address is null");
            return (Criteria) this;
        }

        public Criteria andTbEmpAddressIsNotNull() {
            addCriterion("tb_emp_address is not null");
            return (Criteria) this;
        }

        public Criteria andTbEmpAddressEqualTo(String value) {
            addCriterion("tb_emp_address =", value, "tbEmpAddress");
            return (Criteria) this;
        }

        public Criteria andTbEmpAddressNotEqualTo(String value) {
            addCriterion("tb_emp_address <>", value, "tbEmpAddress");
            return (Criteria) this;
        }

        public Criteria andTbEmpAddressGreaterThan(String value) {
            addCriterion("tb_emp_address >", value, "tbEmpAddress");
            return (Criteria) this;
        }

        public Criteria andTbEmpAddressGreaterThanOrEqualTo(String value) {
            addCriterion("tb_emp_address >=", value, "tbEmpAddress");
            return (Criteria) this;
        }

        public Criteria andTbEmpAddressLessThan(String value) {
            addCriterion("tb_emp_address <", value, "tbEmpAddress");
            return (Criteria) this;
        }

        public Criteria andTbEmpAddressLessThanOrEqualTo(String value) {
            addCriterion("tb_emp_address <=", value, "tbEmpAddress");
            return (Criteria) this;
        }

        public Criteria andTbEmpAddressLike(String value) {
            addCriterion("tb_emp_address like", value, "tbEmpAddress");
            return (Criteria) this;
        }

        public Criteria andTbEmpAddressNotLike(String value) {
            addCriterion("tb_emp_address not like", value, "tbEmpAddress");
            return (Criteria) this;
        }

        public Criteria andTbEmpAddressIn(List<String> values) {
            addCriterion("tb_emp_address in", values, "tbEmpAddress");
            return (Criteria) this;
        }

        public Criteria andTbEmpAddressNotIn(List<String> values) {
            addCriterion("tb_emp_address not in", values, "tbEmpAddress");
            return (Criteria) this;
        }

        public Criteria andTbEmpAddressBetween(String value1, String value2) {
            addCriterion("tb_emp_address between", value1, value2, "tbEmpAddress");
            return (Criteria) this;
        }

        public Criteria andTbEmpAddressNotBetween(String value1, String value2) {
            addCriterion("tb_emp_address not between", value1, value2, "tbEmpAddress");
            return (Criteria) this;
        }

        public Criteria andTbEmpImgIsNull() {
            addCriterion("tb_emp_img is null");
            return (Criteria) this;
        }

        public Criteria andTbEmpImgIsNotNull() {
            addCriterion("tb_emp_img is not null");
            return (Criteria) this;
        }

        public Criteria andTbEmpImgEqualTo(String value) {
            addCriterion("tb_emp_img =", value, "tbEmpImg");
            return (Criteria) this;
        }

        public Criteria andTbEmpImgNotEqualTo(String value) {
            addCriterion("tb_emp_img <>", value, "tbEmpImg");
            return (Criteria) this;
        }

        public Criteria andTbEmpImgGreaterThan(String value) {
            addCriterion("tb_emp_img >", value, "tbEmpImg");
            return (Criteria) this;
        }

        public Criteria andTbEmpImgGreaterThanOrEqualTo(String value) {
            addCriterion("tb_emp_img >=", value, "tbEmpImg");
            return (Criteria) this;
        }

        public Criteria andTbEmpImgLessThan(String value) {
            addCriterion("tb_emp_img <", value, "tbEmpImg");
            return (Criteria) this;
        }

        public Criteria andTbEmpImgLessThanOrEqualTo(String value) {
            addCriterion("tb_emp_img <=", value, "tbEmpImg");
            return (Criteria) this;
        }

        public Criteria andTbEmpImgLike(String value) {
            addCriterion("tb_emp_img like", value, "tbEmpImg");
            return (Criteria) this;
        }

        public Criteria andTbEmpImgNotLike(String value) {
            addCriterion("tb_emp_img not like", value, "tbEmpImg");
            return (Criteria) this;
        }

        public Criteria andTbEmpImgIn(List<String> values) {
            addCriterion("tb_emp_img in", values, "tbEmpImg");
            return (Criteria) this;
        }

        public Criteria andTbEmpImgNotIn(List<String> values) {
            addCriterion("tb_emp_img not in", values, "tbEmpImg");
            return (Criteria) this;
        }

        public Criteria andTbEmpImgBetween(String value1, String value2) {
            addCriterion("tb_emp_img between", value1, value2, "tbEmpImg");
            return (Criteria) this;
        }

        public Criteria andTbEmpImgNotBetween(String value1, String value2) {
            addCriterion("tb_emp_img not between", value1, value2, "tbEmpImg");
            return (Criteria) this;
        }

        public Criteria andTbEmpBirthdayIsNull() {
            addCriterion("tb_emp_birthday is null");
            return (Criteria) this;
        }

        public Criteria andTbEmpBirthdayIsNotNull() {
            addCriterion("tb_emp_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andTbEmpBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("tb_emp_birthday =", value, "tbEmpBirthday");
            return (Criteria) this;
        }

        public Criteria andTbEmpBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("tb_emp_birthday <>", value, "tbEmpBirthday");
            return (Criteria) this;
        }

        public Criteria andTbEmpBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("tb_emp_birthday >", value, "tbEmpBirthday");
            return (Criteria) this;
        }

        public Criteria andTbEmpBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("tb_emp_birthday >=", value, "tbEmpBirthday");
            return (Criteria) this;
        }

        public Criteria andTbEmpBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("tb_emp_birthday <", value, "tbEmpBirthday");
            return (Criteria) this;
        }

        public Criteria andTbEmpBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("tb_emp_birthday <=", value, "tbEmpBirthday");
            return (Criteria) this;
        }

        public Criteria andTbEmpBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("tb_emp_birthday in", values, "tbEmpBirthday");
            return (Criteria) this;
        }

        public Criteria andTbEmpBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("tb_emp_birthday not in", values, "tbEmpBirthday");
            return (Criteria) this;
        }

        public Criteria andTbEmpBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("tb_emp_birthday between", value1, value2, "tbEmpBirthday");
            return (Criteria) this;
        }

        public Criteria andTbEmpBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("tb_emp_birthday not between", value1, value2, "tbEmpBirthday");
            return (Criteria) this;
        }

        public Criteria andTbEmpShengidIsNull() {
            addCriterion("tb_emp_shengid is null");
            return (Criteria) this;
        }

        public Criteria andTbEmpShengidIsNotNull() {
            addCriterion("tb_emp_shengid is not null");
            return (Criteria) this;
        }

        public Criteria andTbEmpShengidEqualTo(Integer value) {
            addCriterion("tb_emp_shengid =", value, "tbEmpShengid");
            return (Criteria) this;
        }

        public Criteria andTbEmpShengidNotEqualTo(Integer value) {
            addCriterion("tb_emp_shengid <>", value, "tbEmpShengid");
            return (Criteria) this;
        }

        public Criteria andTbEmpShengidGreaterThan(Integer value) {
            addCriterion("tb_emp_shengid >", value, "tbEmpShengid");
            return (Criteria) this;
        }

        public Criteria andTbEmpShengidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tb_emp_shengid >=", value, "tbEmpShengid");
            return (Criteria) this;
        }

        public Criteria andTbEmpShengidLessThan(Integer value) {
            addCriterion("tb_emp_shengid <", value, "tbEmpShengid");
            return (Criteria) this;
        }

        public Criteria andTbEmpShengidLessThanOrEqualTo(Integer value) {
            addCriterion("tb_emp_shengid <=", value, "tbEmpShengid");
            return (Criteria) this;
        }

        public Criteria andTbEmpShengidIn(List<Integer> values) {
            addCriterion("tb_emp_shengid in", values, "tbEmpShengid");
            return (Criteria) this;
        }

        public Criteria andTbEmpShengidNotIn(List<Integer> values) {
            addCriterion("tb_emp_shengid not in", values, "tbEmpShengid");
            return (Criteria) this;
        }

        public Criteria andTbEmpShengidBetween(Integer value1, Integer value2) {
            addCriterion("tb_emp_shengid between", value1, value2, "tbEmpShengid");
            return (Criteria) this;
        }

        public Criteria andTbEmpShengidNotBetween(Integer value1, Integer value2) {
            addCriterion("tb_emp_shengid not between", value1, value2, "tbEmpShengid");
            return (Criteria) this;
        }

        public Criteria andTbEmpSidIsNull() {
            addCriterion("tb_emp_sid is null");
            return (Criteria) this;
        }

        public Criteria andTbEmpSidIsNotNull() {
            addCriterion("tb_emp_sid is not null");
            return (Criteria) this;
        }

        public Criteria andTbEmpSidEqualTo(Integer value) {
            addCriterion("tb_emp_sid =", value, "tbEmpSid");
            return (Criteria) this;
        }

        public Criteria andTbEmpSidNotEqualTo(Integer value) {
            addCriterion("tb_emp_sid <>", value, "tbEmpSid");
            return (Criteria) this;
        }

        public Criteria andTbEmpSidGreaterThan(Integer value) {
            addCriterion("tb_emp_sid >", value, "tbEmpSid");
            return (Criteria) this;
        }

        public Criteria andTbEmpSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tb_emp_sid >=", value, "tbEmpSid");
            return (Criteria) this;
        }

        public Criteria andTbEmpSidLessThan(Integer value) {
            addCriterion("tb_emp_sid <", value, "tbEmpSid");
            return (Criteria) this;
        }

        public Criteria andTbEmpSidLessThanOrEqualTo(Integer value) {
            addCriterion("tb_emp_sid <=", value, "tbEmpSid");
            return (Criteria) this;
        }

        public Criteria andTbEmpSidIn(List<Integer> values) {
            addCriterion("tb_emp_sid in", values, "tbEmpSid");
            return (Criteria) this;
        }

        public Criteria andTbEmpSidNotIn(List<Integer> values) {
            addCriterion("tb_emp_sid not in", values, "tbEmpSid");
            return (Criteria) this;
        }

        public Criteria andTbEmpSidBetween(Integer value1, Integer value2) {
            addCriterion("tb_emp_sid between", value1, value2, "tbEmpSid");
            return (Criteria) this;
        }

        public Criteria andTbEmpSidNotBetween(Integer value1, Integer value2) {
            addCriterion("tb_emp_sid not between", value1, value2, "tbEmpSid");
            return (Criteria) this;
        }

        public Criteria andTbEmpXidIsNull() {
            addCriterion("tb_emp_xid is null");
            return (Criteria) this;
        }

        public Criteria andTbEmpXidIsNotNull() {
            addCriterion("tb_emp_xid is not null");
            return (Criteria) this;
        }

        public Criteria andTbEmpXidEqualTo(Integer value) {
            addCriterion("tb_emp_xid =", value, "tbEmpXid");
            return (Criteria) this;
        }

        public Criteria andTbEmpXidNotEqualTo(Integer value) {
            addCriterion("tb_emp_xid <>", value, "tbEmpXid");
            return (Criteria) this;
        }

        public Criteria andTbEmpXidGreaterThan(Integer value) {
            addCriterion("tb_emp_xid >", value, "tbEmpXid");
            return (Criteria) this;
        }

        public Criteria andTbEmpXidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tb_emp_xid >=", value, "tbEmpXid");
            return (Criteria) this;
        }

        public Criteria andTbEmpXidLessThan(Integer value) {
            addCriterion("tb_emp_xid <", value, "tbEmpXid");
            return (Criteria) this;
        }

        public Criteria andTbEmpXidLessThanOrEqualTo(Integer value) {
            addCriterion("tb_emp_xid <=", value, "tbEmpXid");
            return (Criteria) this;
        }

        public Criteria andTbEmpXidIn(List<Integer> values) {
            addCriterion("tb_emp_xid in", values, "tbEmpXid");
            return (Criteria) this;
        }

        public Criteria andTbEmpXidNotIn(List<Integer> values) {
            addCriterion("tb_emp_xid not in", values, "tbEmpXid");
            return (Criteria) this;
        }

        public Criteria andTbEmpXidBetween(Integer value1, Integer value2) {
            addCriterion("tb_emp_xid between", value1, value2, "tbEmpXid");
            return (Criteria) this;
        }

        public Criteria andTbEmpXidNotBetween(Integer value1, Integer value2) {
            addCriterion("tb_emp_xid not between", value1, value2, "tbEmpXid");
            return (Criteria) this;
        }

        public Criteria andTbEmpDidIsNull() {
            addCriterion("tb_emp_did is null");
            return (Criteria) this;
        }

        public Criteria andTbEmpDidIsNotNull() {
            addCriterion("tb_emp_did is not null");
            return (Criteria) this;
        }

        public Criteria andTbEmpDidEqualTo(Integer value) {
            addCriterion("tb_emp_did =", value, "tbEmpDid");
            return (Criteria) this;
        }

        public Criteria andTbEmpDidNotEqualTo(Integer value) {
            addCriterion("tb_emp_did <>", value, "tbEmpDid");
            return (Criteria) this;
        }

        public Criteria andTbEmpDidGreaterThan(Integer value) {
            addCriterion("tb_emp_did >", value, "tbEmpDid");
            return (Criteria) this;
        }

        public Criteria andTbEmpDidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tb_emp_did >=", value, "tbEmpDid");
            return (Criteria) this;
        }

        public Criteria andTbEmpDidLessThan(Integer value) {
            addCriterion("tb_emp_did <", value, "tbEmpDid");
            return (Criteria) this;
        }

        public Criteria andTbEmpDidLessThanOrEqualTo(Integer value) {
            addCriterion("tb_emp_did <=", value, "tbEmpDid");
            return (Criteria) this;
        }

        public Criteria andTbEmpDidIn(List<Integer> values) {
            addCriterion("tb_emp_did in", values, "tbEmpDid");
            return (Criteria) this;
        }

        public Criteria andTbEmpDidNotIn(List<Integer> values) {
            addCriterion("tb_emp_did not in", values, "tbEmpDid");
            return (Criteria) this;
        }

        public Criteria andTbEmpDidBetween(Integer value1, Integer value2) {
            addCriterion("tb_emp_did between", value1, value2, "tbEmpDid");
            return (Criteria) this;
        }

        public Criteria andTbEmpDidNotBetween(Integer value1, Integer value2) {
            addCriterion("tb_emp_did not between", value1, value2, "tbEmpDid");
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