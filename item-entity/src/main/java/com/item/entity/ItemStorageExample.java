package com.item.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemStorageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemStorageExample() {
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

        public Criteria andItemNameIsNull() {
            addCriterion("ITEM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("ITEM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("ITEM_NAME =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("ITEM_NAME <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("ITEM_NAME >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_NAME >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("ITEM_NAME <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("ITEM_NAME <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("ITEM_NAME like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("ITEM_NAME not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("ITEM_NAME in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("ITEM_NAME not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("ITEM_NAME between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("ITEM_NAME not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemStorageIsNull() {
            addCriterion("ITEM_STORAGE is null");
            return (Criteria) this;
        }

        public Criteria andItemStorageIsNotNull() {
            addCriterion("ITEM_STORAGE is not null");
            return (Criteria) this;
        }

        public Criteria andItemStorageEqualTo(Integer value) {
            addCriterion("ITEM_STORAGE =", value, "itemStorage");
            return (Criteria) this;
        }

        public Criteria andItemStorageNotEqualTo(Integer value) {
            addCriterion("ITEM_STORAGE <>", value, "itemStorage");
            return (Criteria) this;
        }

        public Criteria andItemStorageGreaterThan(Integer value) {
            addCriterion("ITEM_STORAGE >", value, "itemStorage");
            return (Criteria) this;
        }

        public Criteria andItemStorageGreaterThanOrEqualTo(Integer value) {
            addCriterion("ITEM_STORAGE >=", value, "itemStorage");
            return (Criteria) this;
        }

        public Criteria andItemStorageLessThan(Integer value) {
            addCriterion("ITEM_STORAGE <", value, "itemStorage");
            return (Criteria) this;
        }

        public Criteria andItemStorageLessThanOrEqualTo(Integer value) {
            addCriterion("ITEM_STORAGE <=", value, "itemStorage");
            return (Criteria) this;
        }

        public Criteria andItemStorageIn(List<Integer> values) {
            addCriterion("ITEM_STORAGE in", values, "itemStorage");
            return (Criteria) this;
        }

        public Criteria andItemStorageNotIn(List<Integer> values) {
            addCriterion("ITEM_STORAGE not in", values, "itemStorage");
            return (Criteria) this;
        }

        public Criteria andItemStorageBetween(Integer value1, Integer value2) {
            addCriterion("ITEM_STORAGE between", value1, value2, "itemStorage");
            return (Criteria) this;
        }

        public Criteria andItemStorageNotBetween(Integer value1, Integer value2) {
            addCriterion("ITEM_STORAGE not between", value1, value2, "itemStorage");
            return (Criteria) this;
        }

        public Criteria andItemStausIsNull() {
            addCriterion("ITEM_STAUS is null");
            return (Criteria) this;
        }

        public Criteria andItemStausIsNotNull() {
            addCriterion("ITEM_STAUS is not null");
            return (Criteria) this;
        }

        public Criteria andItemStausEqualTo(String value) {
            addCriterion("ITEM_STAUS =", value, "itemStaus");
            return (Criteria) this;
        }

        public Criteria andItemStausNotEqualTo(String value) {
            addCriterion("ITEM_STAUS <>", value, "itemStaus");
            return (Criteria) this;
        }

        public Criteria andItemStausGreaterThan(String value) {
            addCriterion("ITEM_STAUS >", value, "itemStaus");
            return (Criteria) this;
        }

        public Criteria andItemStausGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_STAUS >=", value, "itemStaus");
            return (Criteria) this;
        }

        public Criteria andItemStausLessThan(String value) {
            addCriterion("ITEM_STAUS <", value, "itemStaus");
            return (Criteria) this;
        }

        public Criteria andItemStausLessThanOrEqualTo(String value) {
            addCriterion("ITEM_STAUS <=", value, "itemStaus");
            return (Criteria) this;
        }

        public Criteria andItemStausLike(String value) {
            addCriterion("ITEM_STAUS like", value, "itemStaus");
            return (Criteria) this;
        }

        public Criteria andItemStausNotLike(String value) {
            addCriterion("ITEM_STAUS not like", value, "itemStaus");
            return (Criteria) this;
        }

        public Criteria andItemStausIn(List<String> values) {
            addCriterion("ITEM_STAUS in", values, "itemStaus");
            return (Criteria) this;
        }

        public Criteria andItemStausNotIn(List<String> values) {
            addCriterion("ITEM_STAUS not in", values, "itemStaus");
            return (Criteria) this;
        }

        public Criteria andItemStausBetween(String value1, String value2) {
            addCriterion("ITEM_STAUS between", value1, value2, "itemStaus");
            return (Criteria) this;
        }

        public Criteria andItemStausNotBetween(String value1, String value2) {
            addCriterion("ITEM_STAUS not between", value1, value2, "itemStaus");
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

        public Criteria andDocCreateIdIsNull() {
            addCriterion("DOC_CREATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andDocCreateIdIsNotNull() {
            addCriterion("DOC_CREATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDocCreateIdEqualTo(String value) {
            addCriterion("DOC_CREATE_ID =", value, "docCreateId");
            return (Criteria) this;
        }

        public Criteria andDocCreateIdNotEqualTo(String value) {
            addCriterion("DOC_CREATE_ID <>", value, "docCreateId");
            return (Criteria) this;
        }

        public Criteria andDocCreateIdGreaterThan(String value) {
            addCriterion("DOC_CREATE_ID >", value, "docCreateId");
            return (Criteria) this;
        }

        public Criteria andDocCreateIdGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_CREATE_ID >=", value, "docCreateId");
            return (Criteria) this;
        }

        public Criteria andDocCreateIdLessThan(String value) {
            addCriterion("DOC_CREATE_ID <", value, "docCreateId");
            return (Criteria) this;
        }

        public Criteria andDocCreateIdLessThanOrEqualTo(String value) {
            addCriterion("DOC_CREATE_ID <=", value, "docCreateId");
            return (Criteria) this;
        }

        public Criteria andDocCreateIdLike(String value) {
            addCriterion("DOC_CREATE_ID like", value, "docCreateId");
            return (Criteria) this;
        }

        public Criteria andDocCreateIdNotLike(String value) {
            addCriterion("DOC_CREATE_ID not like", value, "docCreateId");
            return (Criteria) this;
        }

        public Criteria andDocCreateIdIn(List<String> values) {
            addCriterion("DOC_CREATE_ID in", values, "docCreateId");
            return (Criteria) this;
        }

        public Criteria andDocCreateIdNotIn(List<String> values) {
            addCriterion("DOC_CREATE_ID not in", values, "docCreateId");
            return (Criteria) this;
        }

        public Criteria andDocCreateIdBetween(String value1, String value2) {
            addCriterion("DOC_CREATE_ID between", value1, value2, "docCreateId");
            return (Criteria) this;
        }

        public Criteria andDocCreateIdNotBetween(String value1, String value2) {
            addCriterion("DOC_CREATE_ID not between", value1, value2, "docCreateId");
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