package com.item.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemMainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemMainExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDocSubjectIsNull() {
            addCriterion("DOC_SUBJECT is null");
            return (Criteria) this;
        }

        public Criteria andDocSubjectIsNotNull() {
            addCriterion("DOC_SUBJECT is not null");
            return (Criteria) this;
        }

        public Criteria andDocSubjectEqualTo(String value) {
            addCriterion("DOC_SUBJECT =", value, "docSubject");
            return (Criteria) this;
        }

        public Criteria andDocSubjectNotEqualTo(String value) {
            addCriterion("DOC_SUBJECT <>", value, "docSubject");
            return (Criteria) this;
        }

        public Criteria andDocSubjectGreaterThan(String value) {
            addCriterion("DOC_SUBJECT >", value, "docSubject");
            return (Criteria) this;
        }

        public Criteria andDocSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_SUBJECT >=", value, "docSubject");
            return (Criteria) this;
        }

        public Criteria andDocSubjectLessThan(String value) {
            addCriterion("DOC_SUBJECT <", value, "docSubject");
            return (Criteria) this;
        }

        public Criteria andDocSubjectLessThanOrEqualTo(String value) {
            addCriterion("DOC_SUBJECT <=", value, "docSubject");
            return (Criteria) this;
        }

        public Criteria andDocSubjectLike(String value) {
            addCriterion("DOC_SUBJECT like", value, "docSubject");
            return (Criteria) this;
        }

        public Criteria andDocSubjectNotLike(String value) {
            addCriterion("DOC_SUBJECT not like", value, "docSubject");
            return (Criteria) this;
        }

        public Criteria andDocSubjectIn(List<String> values) {
            addCriterion("DOC_SUBJECT in", values, "docSubject");
            return (Criteria) this;
        }

        public Criteria andDocSubjectNotIn(List<String> values) {
            addCriterion("DOC_SUBJECT not in", values, "docSubject");
            return (Criteria) this;
        }

        public Criteria andDocSubjectBetween(String value1, String value2) {
            addCriterion("DOC_SUBJECT between", value1, value2, "docSubject");
            return (Criteria) this;
        }

        public Criteria andDocSubjectNotBetween(String value1, String value2) {
            addCriterion("DOC_SUBJECT not between", value1, value2, "docSubject");
            return (Criteria) this;
        }

        public Criteria andDocStatusIsNull() {
            addCriterion("DOC_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andDocStatusIsNotNull() {
            addCriterion("DOC_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andDocStatusEqualTo(String value) {
            addCriterion("DOC_STATUS =", value, "docStatus");
            return (Criteria) this;
        }

        public Criteria andDocStatusNotEqualTo(String value) {
            addCriterion("DOC_STATUS <>", value, "docStatus");
            return (Criteria) this;
        }

        public Criteria andDocStatusGreaterThan(String value) {
            addCriterion("DOC_STATUS >", value, "docStatus");
            return (Criteria) this;
        }

        public Criteria andDocStatusGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_STATUS >=", value, "docStatus");
            return (Criteria) this;
        }

        public Criteria andDocStatusLessThan(String value) {
            addCriterion("DOC_STATUS <", value, "docStatus");
            return (Criteria) this;
        }

        public Criteria andDocStatusLessThanOrEqualTo(String value) {
            addCriterion("DOC_STATUS <=", value, "docStatus");
            return (Criteria) this;
        }

        public Criteria andDocStatusLike(String value) {
            addCriterion("DOC_STATUS like", value, "docStatus");
            return (Criteria) this;
        }

        public Criteria andDocStatusNotLike(String value) {
            addCriterion("DOC_STATUS not like", value, "docStatus");
            return (Criteria) this;
        }

        public Criteria andDocStatusIn(List<String> values) {
            addCriterion("DOC_STATUS in", values, "docStatus");
            return (Criteria) this;
        }

        public Criteria andDocStatusNotIn(List<String> values) {
            addCriterion("DOC_STATUS not in", values, "docStatus");
            return (Criteria) this;
        }

        public Criteria andDocStatusBetween(String value1, String value2) {
            addCriterion("DOC_STATUS between", value1, value2, "docStatus");
            return (Criteria) this;
        }

        public Criteria andDocStatusNotBetween(String value1, String value2) {
            addCriterion("DOC_STATUS not between", value1, value2, "docStatus");
            return (Criteria) this;
        }

        public Criteria andDocCreateTimeIsNull() {
            addCriterion("DOC_CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDocCreateTimeIsNotNull() {
            addCriterion("DOC_CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDocCreateTimeEqualTo(Date value) {
            addCriterion("DOC_CREATE_TIME =", value, "docCreateTime");
            return (Criteria) this;
        }

        public Criteria andDocCreateTimeNotEqualTo(Date value) {
            addCriterion("DOC_CREATE_TIME <>", value, "docCreateTime");
            return (Criteria) this;
        }

        public Criteria andDocCreateTimeGreaterThan(Date value) {
            addCriterion("DOC_CREATE_TIME >", value, "docCreateTime");
            return (Criteria) this;
        }

        public Criteria andDocCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DOC_CREATE_TIME >=", value, "docCreateTime");
            return (Criteria) this;
        }

        public Criteria andDocCreateTimeLessThan(Date value) {
            addCriterion("DOC_CREATE_TIME <", value, "docCreateTime");
            return (Criteria) this;
        }

        public Criteria andDocCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("DOC_CREATE_TIME <=", value, "docCreateTime");
            return (Criteria) this;
        }

        public Criteria andDocCreateTimeIn(List<Date> values) {
            addCriterion("DOC_CREATE_TIME in", values, "docCreateTime");
            return (Criteria) this;
        }

        public Criteria andDocCreateTimeNotIn(List<Date> values) {
            addCriterion("DOC_CREATE_TIME not in", values, "docCreateTime");
            return (Criteria) this;
        }

        public Criteria andDocCreateTimeBetween(Date value1, Date value2) {
            addCriterion("DOC_CREATE_TIME between", value1, value2, "docCreateTime");
            return (Criteria) this;
        }

        public Criteria andDocCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("DOC_CREATE_TIME not between", value1, value2, "docCreateTime");
            return (Criteria) this;
        }

        public Criteria andDocCreatorIdIsNull() {
            addCriterion("DOC_CREATOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andDocCreatorIdIsNotNull() {
            addCriterion("DOC_CREATOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDocCreatorIdEqualTo(String value) {
            addCriterion("DOC_CREATOR_ID =", value, "docCreatorId");
            return (Criteria) this;
        }

        public Criteria andDocCreatorIdNotEqualTo(String value) {
            addCriterion("DOC_CREATOR_ID <>", value, "docCreatorId");
            return (Criteria) this;
        }

        public Criteria andDocCreatorIdGreaterThan(String value) {
            addCriterion("DOC_CREATOR_ID >", value, "docCreatorId");
            return (Criteria) this;
        }

        public Criteria andDocCreatorIdGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_CREATOR_ID >=", value, "docCreatorId");
            return (Criteria) this;
        }

        public Criteria andDocCreatorIdLessThan(String value) {
            addCriterion("DOC_CREATOR_ID <", value, "docCreatorId");
            return (Criteria) this;
        }

        public Criteria andDocCreatorIdLessThanOrEqualTo(String value) {
            addCriterion("DOC_CREATOR_ID <=", value, "docCreatorId");
            return (Criteria) this;
        }

        public Criteria andDocCreatorIdLike(String value) {
            addCriterion("DOC_CREATOR_ID like", value, "docCreatorId");
            return (Criteria) this;
        }

        public Criteria andDocCreatorIdNotLike(String value) {
            addCriterion("DOC_CREATOR_ID not like", value, "docCreatorId");
            return (Criteria) this;
        }

        public Criteria andDocCreatorIdIn(List<String> values) {
            addCriterion("DOC_CREATOR_ID in", values, "docCreatorId");
            return (Criteria) this;
        }

        public Criteria andDocCreatorIdNotIn(List<String> values) {
            addCriterion("DOC_CREATOR_ID not in", values, "docCreatorId");
            return (Criteria) this;
        }

        public Criteria andDocCreatorIdBetween(String value1, String value2) {
            addCriterion("DOC_CREATOR_ID between", value1, value2, "docCreatorId");
            return (Criteria) this;
        }

        public Criteria andDocCreatorIdNotBetween(String value1, String value2) {
            addCriterion("DOC_CREATOR_ID not between", value1, value2, "docCreatorId");
            return (Criteria) this;
        }

        public Criteria andDocCreateNameIsNull() {
            addCriterion("DOC_CREATE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDocCreateNameIsNotNull() {
            addCriterion("DOC_CREATE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDocCreateNameEqualTo(String value) {
            addCriterion("DOC_CREATE_NAME =", value, "docCreateName");
            return (Criteria) this;
        }

        public Criteria andDocCreateNameNotEqualTo(String value) {
            addCriterion("DOC_CREATE_NAME <>", value, "docCreateName");
            return (Criteria) this;
        }

        public Criteria andDocCreateNameGreaterThan(String value) {
            addCriterion("DOC_CREATE_NAME >", value, "docCreateName");
            return (Criteria) this;
        }

        public Criteria andDocCreateNameGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_CREATE_NAME >=", value, "docCreateName");
            return (Criteria) this;
        }

        public Criteria andDocCreateNameLessThan(String value) {
            addCriterion("DOC_CREATE_NAME <", value, "docCreateName");
            return (Criteria) this;
        }

        public Criteria andDocCreateNameLessThanOrEqualTo(String value) {
            addCriterion("DOC_CREATE_NAME <=", value, "docCreateName");
            return (Criteria) this;
        }

        public Criteria andDocCreateNameLike(String value) {
            addCriterion("DOC_CREATE_NAME like", value, "docCreateName");
            return (Criteria) this;
        }

        public Criteria andDocCreateNameNotLike(String value) {
            addCriterion("DOC_CREATE_NAME not like", value, "docCreateName");
            return (Criteria) this;
        }

        public Criteria andDocCreateNameIn(List<String> values) {
            addCriterion("DOC_CREATE_NAME in", values, "docCreateName");
            return (Criteria) this;
        }

        public Criteria andDocCreateNameNotIn(List<String> values) {
            addCriterion("DOC_CREATE_NAME not in", values, "docCreateName");
            return (Criteria) this;
        }

        public Criteria andDocCreateNameBetween(String value1, String value2) {
            addCriterion("DOC_CREATE_NAME between", value1, value2, "docCreateName");
            return (Criteria) this;
        }

        public Criteria andDocCreateNameNotBetween(String value1, String value2) {
            addCriterion("DOC_CREATE_NAME not between", value1, value2, "docCreateName");
            return (Criteria) this;
        }

        public Criteria andDocAlterTimeIsNull() {
            addCriterion("DOC_ALTER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDocAlterTimeIsNotNull() {
            addCriterion("DOC_ALTER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDocAlterTimeEqualTo(Date value) {
            addCriterion("DOC_ALTER_TIME =", value, "docAlterTime");
            return (Criteria) this;
        }

        public Criteria andDocAlterTimeNotEqualTo(Date value) {
            addCriterion("DOC_ALTER_TIME <>", value, "docAlterTime");
            return (Criteria) this;
        }

        public Criteria andDocAlterTimeGreaterThan(Date value) {
            addCriterion("DOC_ALTER_TIME >", value, "docAlterTime");
            return (Criteria) this;
        }

        public Criteria andDocAlterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DOC_ALTER_TIME >=", value, "docAlterTime");
            return (Criteria) this;
        }

        public Criteria andDocAlterTimeLessThan(Date value) {
            addCriterion("DOC_ALTER_TIME <", value, "docAlterTime");
            return (Criteria) this;
        }

        public Criteria andDocAlterTimeLessThanOrEqualTo(Date value) {
            addCriterion("DOC_ALTER_TIME <=", value, "docAlterTime");
            return (Criteria) this;
        }

        public Criteria andDocAlterTimeIn(List<Date> values) {
            addCriterion("DOC_ALTER_TIME in", values, "docAlterTime");
            return (Criteria) this;
        }

        public Criteria andDocAlterTimeNotIn(List<Date> values) {
            addCriterion("DOC_ALTER_TIME not in", values, "docAlterTime");
            return (Criteria) this;
        }

        public Criteria andDocAlterTimeBetween(Date value1, Date value2) {
            addCriterion("DOC_ALTER_TIME between", value1, value2, "docAlterTime");
            return (Criteria) this;
        }

        public Criteria andDocAlterTimeNotBetween(Date value1, Date value2) {
            addCriterion("DOC_ALTER_TIME not between", value1, value2, "docAlterTime");
            return (Criteria) this;
        }

        public Criteria andDocAlterIdIsNull() {
            addCriterion("DOC_ALTER_ID is null");
            return (Criteria) this;
        }

        public Criteria andDocAlterIdIsNotNull() {
            addCriterion("DOC_ALTER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDocAlterIdEqualTo(String value) {
            addCriterion("DOC_ALTER_ID =", value, "docAlterId");
            return (Criteria) this;
        }

        public Criteria andDocAlterIdNotEqualTo(String value) {
            addCriterion("DOC_ALTER_ID <>", value, "docAlterId");
            return (Criteria) this;
        }

        public Criteria andDocAlterIdGreaterThan(String value) {
            addCriterion("DOC_ALTER_ID >", value, "docAlterId");
            return (Criteria) this;
        }

        public Criteria andDocAlterIdGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_ALTER_ID >=", value, "docAlterId");
            return (Criteria) this;
        }

        public Criteria andDocAlterIdLessThan(String value) {
            addCriterion("DOC_ALTER_ID <", value, "docAlterId");
            return (Criteria) this;
        }

        public Criteria andDocAlterIdLessThanOrEqualTo(String value) {
            addCriterion("DOC_ALTER_ID <=", value, "docAlterId");
            return (Criteria) this;
        }

        public Criteria andDocAlterIdLike(String value) {
            addCriterion("DOC_ALTER_ID like", value, "docAlterId");
            return (Criteria) this;
        }

        public Criteria andDocAlterIdNotLike(String value) {
            addCriterion("DOC_ALTER_ID not like", value, "docAlterId");
            return (Criteria) this;
        }

        public Criteria andDocAlterIdIn(List<String> values) {
            addCriterion("DOC_ALTER_ID in", values, "docAlterId");
            return (Criteria) this;
        }

        public Criteria andDocAlterIdNotIn(List<String> values) {
            addCriterion("DOC_ALTER_ID not in", values, "docAlterId");
            return (Criteria) this;
        }

        public Criteria andDocAlterIdBetween(String value1, String value2) {
            addCriterion("DOC_ALTER_ID between", value1, value2, "docAlterId");
            return (Criteria) this;
        }

        public Criteria andDocAlterIdNotBetween(String value1, String value2) {
            addCriterion("DOC_ALTER_ID not between", value1, value2, "docAlterId");
            return (Criteria) this;
        }

        public Criteria andDocRemarkIsNull() {
            addCriterion("DOC_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andDocRemarkIsNotNull() {
            addCriterion("DOC_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andDocRemarkEqualTo(String value) {
            addCriterion("DOC_REMARK =", value, "docRemark");
            return (Criteria) this;
        }

        public Criteria andDocRemarkNotEqualTo(String value) {
            addCriterion("DOC_REMARK <>", value, "docRemark");
            return (Criteria) this;
        }

        public Criteria andDocRemarkGreaterThan(String value) {
            addCriterion("DOC_REMARK >", value, "docRemark");
            return (Criteria) this;
        }

        public Criteria andDocRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_REMARK >=", value, "docRemark");
            return (Criteria) this;
        }

        public Criteria andDocRemarkLessThan(String value) {
            addCriterion("DOC_REMARK <", value, "docRemark");
            return (Criteria) this;
        }

        public Criteria andDocRemarkLessThanOrEqualTo(String value) {
            addCriterion("DOC_REMARK <=", value, "docRemark");
            return (Criteria) this;
        }

        public Criteria andDocRemarkLike(String value) {
            addCriterion("DOC_REMARK like", value, "docRemark");
            return (Criteria) this;
        }

        public Criteria andDocRemarkNotLike(String value) {
            addCriterion("DOC_REMARK not like", value, "docRemark");
            return (Criteria) this;
        }

        public Criteria andDocRemarkIn(List<String> values) {
            addCriterion("DOC_REMARK in", values, "docRemark");
            return (Criteria) this;
        }

        public Criteria andDocRemarkNotIn(List<String> values) {
            addCriterion("DOC_REMARK not in", values, "docRemark");
            return (Criteria) this;
        }

        public Criteria andDocRemarkBetween(String value1, String value2) {
            addCriterion("DOC_REMARK between", value1, value2, "docRemark");
            return (Criteria) this;
        }

        public Criteria andDocRemarkNotBetween(String value1, String value2) {
            addCriterion("DOC_REMARK not between", value1, value2, "docRemark");
            return (Criteria) this;
        }

        public Criteria andDocAlterNameIsNull() {
            addCriterion("DOC_ALTER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDocAlterNameIsNotNull() {
            addCriterion("DOC_ALTER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDocAlterNameEqualTo(String value) {
            addCriterion("DOC_ALTER_NAME =", value, "docAlterName");
            return (Criteria) this;
        }

        public Criteria andDocAlterNameNotEqualTo(String value) {
            addCriterion("DOC_ALTER_NAME <>", value, "docAlterName");
            return (Criteria) this;
        }

        public Criteria andDocAlterNameGreaterThan(String value) {
            addCriterion("DOC_ALTER_NAME >", value, "docAlterName");
            return (Criteria) this;
        }

        public Criteria andDocAlterNameGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_ALTER_NAME >=", value, "docAlterName");
            return (Criteria) this;
        }

        public Criteria andDocAlterNameLessThan(String value) {
            addCriterion("DOC_ALTER_NAME <", value, "docAlterName");
            return (Criteria) this;
        }

        public Criteria andDocAlterNameLessThanOrEqualTo(String value) {
            addCriterion("DOC_ALTER_NAME <=", value, "docAlterName");
            return (Criteria) this;
        }

        public Criteria andDocAlterNameLike(String value) {
            addCriterion("DOC_ALTER_NAME like", value, "docAlterName");
            return (Criteria) this;
        }

        public Criteria andDocAlterNameNotLike(String value) {
            addCriterion("DOC_ALTER_NAME not like", value, "docAlterName");
            return (Criteria) this;
        }

        public Criteria andDocAlterNameIn(List<String> values) {
            addCriterion("DOC_ALTER_NAME in", values, "docAlterName");
            return (Criteria) this;
        }

        public Criteria andDocAlterNameNotIn(List<String> values) {
            addCriterion("DOC_ALTER_NAME not in", values, "docAlterName");
            return (Criteria) this;
        }

        public Criteria andDocAlterNameBetween(String value1, String value2) {
            addCriterion("DOC_ALTER_NAME between", value1, value2, "docAlterName");
            return (Criteria) this;
        }

        public Criteria andDocAlterNameNotBetween(String value1, String value2) {
            addCriterion("DOC_ALTER_NAME not between", value1, value2, "docAlterName");
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