package com.record.pojo;

import java.util.ArrayList;
import java.util.List;

public class ContactExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContactExample() {
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

        public Criteria andTeachernumberIsNull() {
            addCriterion("teacherNumber is null");
            return (Criteria) this;
        }

        public Criteria andTeachernumberIsNotNull() {
            addCriterion("teacherNumber is not null");
            return (Criteria) this;
        }

        public Criteria andTeachernumberEqualTo(String value) {
            addCriterion("teacherNumber =", value, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberNotEqualTo(String value) {
            addCriterion("teacherNumber <>", value, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberGreaterThan(String value) {
            addCriterion("teacherNumber >", value, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberGreaterThanOrEqualTo(String value) {
            addCriterion("teacherNumber >=", value, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberLessThan(String value) {
            addCriterion("teacherNumber <", value, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberLessThanOrEqualTo(String value) {
            addCriterion("teacherNumber <=", value, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberLike(String value) {
            addCriterion("teacherNumber like", value, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberNotLike(String value) {
            addCriterion("teacherNumber not like", value, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberIn(List<String> values) {
            addCriterion("teacherNumber in", values, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberNotIn(List<String> values) {
            addCriterion("teacherNumber not in", values, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberBetween(String value1, String value2) {
            addCriterion("teacherNumber between", value1, value2, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberNotBetween(String value1, String value2) {
            addCriterion("teacherNumber not between", value1, value2, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberIsNull() {
            addCriterion("studentNumber is null");
            return (Criteria) this;
        }

        public Criteria andStudentnumberIsNotNull() {
            addCriterion("studentNumber is not null");
            return (Criteria) this;
        }

        public Criteria andStudentnumberEqualTo(String value) {
            addCriterion("studentNumber =", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberNotEqualTo(String value) {
            addCriterion("studentNumber <>", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberGreaterThan(String value) {
            addCriterion("studentNumber >", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberGreaterThanOrEqualTo(String value) {
            addCriterion("studentNumber >=", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberLessThan(String value) {
            addCriterion("studentNumber <", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberLessThanOrEqualTo(String value) {
            addCriterion("studentNumber <=", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberLike(String value) {
            addCriterion("studentNumber like", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberNotLike(String value) {
            addCriterion("studentNumber not like", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberIn(List<String> values) {
            addCriterion("studentNumber in", values, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberNotIn(List<String> values) {
            addCriterion("studentNumber not in", values, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberBetween(String value1, String value2) {
            addCriterion("studentNumber between", value1, value2, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberNotBetween(String value1, String value2) {
            addCriterion("studentNumber not between", value1, value2, "studentnumber");
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