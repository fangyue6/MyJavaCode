package com.record.pojo;

import java.util.ArrayList;
import java.util.List;

public class SchoolExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SchoolExample() {
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

        public Criteria andSchoolidIsNull() {
            addCriterion("schoolID is null");
            return (Criteria) this;
        }

        public Criteria andSchoolidIsNotNull() {
            addCriterion("schoolID is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolidEqualTo(String value) {
            addCriterion("schoolID =", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidNotEqualTo(String value) {
            addCriterion("schoolID <>", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidGreaterThan(String value) {
            addCriterion("schoolID >", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidGreaterThanOrEqualTo(String value) {
            addCriterion("schoolID >=", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidLessThan(String value) {
            addCriterion("schoolID <", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidLessThanOrEqualTo(String value) {
            addCriterion("schoolID <=", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidLike(String value) {
            addCriterion("schoolID like", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidNotLike(String value) {
            addCriterion("schoolID not like", value, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidIn(List<String> values) {
            addCriterion("schoolID in", values, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidNotIn(List<String> values) {
            addCriterion("schoolID not in", values, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidBetween(String value1, String value2) {
            addCriterion("schoolID between", value1, value2, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolidNotBetween(String value1, String value2) {
            addCriterion("schoolID not between", value1, value2, "schoolid");
            return (Criteria) this;
        }

        public Criteria andSchoolnameIsNull() {
            addCriterion("schoolName is null");
            return (Criteria) this;
        }

        public Criteria andSchoolnameIsNotNull() {
            addCriterion("schoolName is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolnameEqualTo(String value) {
            addCriterion("schoolName =", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameNotEqualTo(String value) {
            addCriterion("schoolName <>", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameGreaterThan(String value) {
            addCriterion("schoolName >", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameGreaterThanOrEqualTo(String value) {
            addCriterion("schoolName >=", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameLessThan(String value) {
            addCriterion("schoolName <", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameLessThanOrEqualTo(String value) {
            addCriterion("schoolName <=", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameLike(String value) {
            addCriterion("schoolName like", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameNotLike(String value) {
            addCriterion("schoolName not like", value, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameIn(List<String> values) {
            addCriterion("schoolName in", values, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameNotIn(List<String> values) {
            addCriterion("schoolName not in", values, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameBetween(String value1, String value2) {
            addCriterion("schoolName between", value1, value2, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolnameNotBetween(String value1, String value2) {
            addCriterion("schoolName not between", value1, value2, "schoolname");
            return (Criteria) this;
        }

        public Criteria andSchoolcollegeIsNull() {
            addCriterion("schoolCollege is null");
            return (Criteria) this;
        }

        public Criteria andSchoolcollegeIsNotNull() {
            addCriterion("schoolCollege is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolcollegeEqualTo(String value) {
            addCriterion("schoolCollege =", value, "schoolcollege");
            return (Criteria) this;
        }

        public Criteria andSchoolcollegeNotEqualTo(String value) {
            addCriterion("schoolCollege <>", value, "schoolcollege");
            return (Criteria) this;
        }

        public Criteria andSchoolcollegeGreaterThan(String value) {
            addCriterion("schoolCollege >", value, "schoolcollege");
            return (Criteria) this;
        }

        public Criteria andSchoolcollegeGreaterThanOrEqualTo(String value) {
            addCriterion("schoolCollege >=", value, "schoolcollege");
            return (Criteria) this;
        }

        public Criteria andSchoolcollegeLessThan(String value) {
            addCriterion("schoolCollege <", value, "schoolcollege");
            return (Criteria) this;
        }

        public Criteria andSchoolcollegeLessThanOrEqualTo(String value) {
            addCriterion("schoolCollege <=", value, "schoolcollege");
            return (Criteria) this;
        }

        public Criteria andSchoolcollegeLike(String value) {
            addCriterion("schoolCollege like", value, "schoolcollege");
            return (Criteria) this;
        }

        public Criteria andSchoolcollegeNotLike(String value) {
            addCriterion("schoolCollege not like", value, "schoolcollege");
            return (Criteria) this;
        }

        public Criteria andSchoolcollegeIn(List<String> values) {
            addCriterion("schoolCollege in", values, "schoolcollege");
            return (Criteria) this;
        }

        public Criteria andSchoolcollegeNotIn(List<String> values) {
            addCriterion("schoolCollege not in", values, "schoolcollege");
            return (Criteria) this;
        }

        public Criteria andSchoolcollegeBetween(String value1, String value2) {
            addCriterion("schoolCollege between", value1, value2, "schoolcollege");
            return (Criteria) this;
        }

        public Criteria andSchoolcollegeNotBetween(String value1, String value2) {
            addCriterion("schoolCollege not between", value1, value2, "schoolcollege");
            return (Criteria) this;
        }

        public Criteria andSchoolmajorIsNull() {
            addCriterion("schoolMajor is null");
            return (Criteria) this;
        }

        public Criteria andSchoolmajorIsNotNull() {
            addCriterion("schoolMajor is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolmajorEqualTo(String value) {
            addCriterion("schoolMajor =", value, "schoolmajor");
            return (Criteria) this;
        }

        public Criteria andSchoolmajorNotEqualTo(String value) {
            addCriterion("schoolMajor <>", value, "schoolmajor");
            return (Criteria) this;
        }

        public Criteria andSchoolmajorGreaterThan(String value) {
            addCriterion("schoolMajor >", value, "schoolmajor");
            return (Criteria) this;
        }

        public Criteria andSchoolmajorGreaterThanOrEqualTo(String value) {
            addCriterion("schoolMajor >=", value, "schoolmajor");
            return (Criteria) this;
        }

        public Criteria andSchoolmajorLessThan(String value) {
            addCriterion("schoolMajor <", value, "schoolmajor");
            return (Criteria) this;
        }

        public Criteria andSchoolmajorLessThanOrEqualTo(String value) {
            addCriterion("schoolMajor <=", value, "schoolmajor");
            return (Criteria) this;
        }

        public Criteria andSchoolmajorLike(String value) {
            addCriterion("schoolMajor like", value, "schoolmajor");
            return (Criteria) this;
        }

        public Criteria andSchoolmajorNotLike(String value) {
            addCriterion("schoolMajor not like", value, "schoolmajor");
            return (Criteria) this;
        }

        public Criteria andSchoolmajorIn(List<String> values) {
            addCriterion("schoolMajor in", values, "schoolmajor");
            return (Criteria) this;
        }

        public Criteria andSchoolmajorNotIn(List<String> values) {
            addCriterion("schoolMajor not in", values, "schoolmajor");
            return (Criteria) this;
        }

        public Criteria andSchoolmajorBetween(String value1, String value2) {
            addCriterion("schoolMajor between", value1, value2, "schoolmajor");
            return (Criteria) this;
        }

        public Criteria andSchoolmajorNotBetween(String value1, String value2) {
            addCriterion("schoolMajor not between", value1, value2, "schoolmajor");
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