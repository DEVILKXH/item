package com.item.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemDetailExample() {
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

        public Criteria andItemNumberIsNull() {
            addCriterion("ITEM_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andItemNumberIsNotNull() {
            addCriterion("ITEM_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andItemNumberEqualTo(Integer value) {
            addCriterion("ITEM_NUMBER =", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberNotEqualTo(Integer value) {
            addCriterion("ITEM_NUMBER <>", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberGreaterThan(Integer value) {
            addCriterion("ITEM_NUMBER >", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("ITEM_NUMBER >=", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberLessThan(Integer value) {
            addCriterion("ITEM_NUMBER <", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberLessThanOrEqualTo(Integer value) {
            addCriterion("ITEM_NUMBER <=", value, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberIn(List<Integer> values) {
            addCriterion("ITEM_NUMBER in", values, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberNotIn(List<Integer> values) {
            addCriterion("ITEM_NUMBER not in", values, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberBetween(Integer value1, Integer value2) {
            addCriterion("ITEM_NUMBER between", value1, value2, "itemNumber");
            return (Criteria) this;
        }

        public Criteria andItemNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("ITEM_NUMBER not between", value1, value2, "itemNumber");
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

        public Criteria andItemStorageEqualTo(String value) {
            addCriterion("ITEM_STORAGE =", value, "itemStorage");
            return (Criteria) this;
        }

        public Criteria andItemStorageNotEqualTo(String value) {
            addCriterion("ITEM_STORAGE <>", value, "itemStorage");
            return (Criteria) this;
        }

        public Criteria andItemStorageGreaterThan(String value) {
            addCriterion("ITEM_STORAGE >", value, "itemStorage");
            return (Criteria) this;
        }

        public Criteria andItemStorageGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_STORAGE >=", value, "itemStorage");
            return (Criteria) this;
        }

        public Criteria andItemStorageLessThan(String value) {
            addCriterion("ITEM_STORAGE <", value, "itemStorage");
            return (Criteria) this;
        }

        public Criteria andItemStorageLessThanOrEqualTo(String value) {
            addCriterion("ITEM_STORAGE <=", value, "itemStorage");
            return (Criteria) this;
        }

        public Criteria andItemStorageLike(String value) {
            addCriterion("ITEM_STORAGE like", value, "itemStorage");
            return (Criteria) this;
        }

        public Criteria andItemStorageNotLike(String value) {
            addCriterion("ITEM_STORAGE not like", value, "itemStorage");
            return (Criteria) this;
        }

        public Criteria andItemStorageIn(List<String> values) {
            addCriterion("ITEM_STORAGE in", values, "itemStorage");
            return (Criteria) this;
        }

        public Criteria andItemStorageNotIn(List<String> values) {
            addCriterion("ITEM_STORAGE not in", values, "itemStorage");
            return (Criteria) this;
        }

        public Criteria andItemStorageBetween(String value1, String value2) {
            addCriterion("ITEM_STORAGE between", value1, value2, "itemStorage");
            return (Criteria) this;
        }

        public Criteria andItemStorageNotBetween(String value1, String value2) {
            addCriterion("ITEM_STORAGE not between", value1, value2, "itemStorage");
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

        public Criteria andDocMainIdIsNull() {
            addCriterion("DOC_MAIN_ID is null");
            return (Criteria) this;
        }

        public Criteria andDocMainIdIsNotNull() {
            addCriterion("DOC_MAIN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDocMainIdEqualTo(String value) {
            addCriterion("DOC_MAIN_ID =", value, "docMainId");
            return (Criteria) this;
        }

        public Criteria andDocMainIdNotEqualTo(String value) {
            addCriterion("DOC_MAIN_ID <>", value, "docMainId");
            return (Criteria) this;
        }

        public Criteria andDocMainIdGreaterThan(String value) {
            addCriterion("DOC_MAIN_ID >", value, "docMainId");
            return (Criteria) this;
        }

        public Criteria andDocMainIdGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_MAIN_ID >=", value, "docMainId");
            return (Criteria) this;
        }

        public Criteria andDocMainIdLessThan(String value) {
            addCriterion("DOC_MAIN_ID <", value, "docMainId");
            return (Criteria) this;
        }

        public Criteria andDocMainIdLessThanOrEqualTo(String value) {
            addCriterion("DOC_MAIN_ID <=", value, "docMainId");
            return (Criteria) this;
        }

        public Criteria andDocMainIdLike(String value) {
            addCriterion("DOC_MAIN_ID like", value, "docMainId");
            return (Criteria) this;
        }

        public Criteria andDocMainIdNotLike(String value) {
            addCriterion("DOC_MAIN_ID not like", value, "docMainId");
            return (Criteria) this;
        }

        public Criteria andDocMainIdIn(List<String> values) {
            addCriterion("DOC_MAIN_ID in", values, "docMainId");
            return (Criteria) this;
        }

        public Criteria andDocMainIdNotIn(List<String> values) {
            addCriterion("DOC_MAIN_ID not in", values, "docMainId");
            return (Criteria) this;
        }

        public Criteria andDocMainIdBetween(String value1, String value2) {
            addCriterion("DOC_MAIN_ID between", value1, value2, "docMainId");
            return (Criteria) this;
        }

        public Criteria andDocMainIdNotBetween(String value1, String value2) {
            addCriterion("DOC_MAIN_ID not between", value1, value2, "docMainId");
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