package com.oa.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserpermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserpermissionExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andIsadminIsNull() {
            addCriterion("isadmin is null");
            return (Criteria) this;
        }

        public Criteria andIsadminIsNotNull() {
            addCriterion("isadmin is not null");
            return (Criteria) this;
        }

        public Criteria andIsadminEqualTo(Integer value) {
            addCriterion("isadmin =", value, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminNotEqualTo(Integer value) {
            addCriterion("isadmin <>", value, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminGreaterThan(Integer value) {
            addCriterion("isadmin >", value, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminGreaterThanOrEqualTo(Integer value) {
            addCriterion("isadmin >=", value, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminLessThan(Integer value) {
            addCriterion("isadmin <", value, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminLessThanOrEqualTo(Integer value) {
            addCriterion("isadmin <=", value, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminIn(List<Integer> values) {
            addCriterion("isadmin in", values, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminNotIn(List<Integer> values) {
            addCriterion("isadmin not in", values, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminBetween(Integer value1, Integer value2) {
            addCriterion("isadmin between", value1, value2, "isadmin");
            return (Criteria) this;
        }

        public Criteria andIsadminNotBetween(Integer value1, Integer value2) {
            addCriterion("isadmin not between", value1, value2, "isadmin");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(String value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(String value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(String value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(String value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLike(String value) {
            addCriterion("updatetime like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotLike(String value) {
            addCriterion("updatetime not like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<String> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<String> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(String value1, String value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andGroup1IsNull() {
            addCriterion("group1 is null");
            return (Criteria) this;
        }

        public Criteria andGroup1IsNotNull() {
            addCriterion("group1 is not null");
            return (Criteria) this;
        }

        public Criteria andGroup1EqualTo(String value) {
            addCriterion("group1 =", value, "group1");
            return (Criteria) this;
        }

        public Criteria andGroup1NotEqualTo(String value) {
            addCriterion("group1 <>", value, "group1");
            return (Criteria) this;
        }

        public Criteria andGroup1GreaterThan(String value) {
            addCriterion("group1 >", value, "group1");
            return (Criteria) this;
        }

        public Criteria andGroup1GreaterThanOrEqualTo(String value) {
            addCriterion("group1 >=", value, "group1");
            return (Criteria) this;
        }

        public Criteria andGroup1LessThan(String value) {
            addCriterion("group1 <", value, "group1");
            return (Criteria) this;
        }

        public Criteria andGroup1LessThanOrEqualTo(String value) {
            addCriterion("group1 <=", value, "group1");
            return (Criteria) this;
        }

        public Criteria andGroup1Like(String value) {
            addCriterion("group1 like", value, "group1");
            return (Criteria) this;
        }

        public Criteria andGroup1NotLike(String value) {
            addCriterion("group1 not like", value, "group1");
            return (Criteria) this;
        }

        public Criteria andGroup1In(List<String> values) {
            addCriterion("group1 in", values, "group1");
            return (Criteria) this;
        }

        public Criteria andGroup1NotIn(List<String> values) {
            addCriterion("group1 not in", values, "group1");
            return (Criteria) this;
        }

        public Criteria andGroup1Between(String value1, String value2) {
            addCriterion("group1 between", value1, value2, "group1");
            return (Criteria) this;
        }

        public Criteria andGroup1NotBetween(String value1, String value2) {
            addCriterion("group1 not between", value1, value2, "group1");
            return (Criteria) this;
        }

        public Criteria andGroup2IsNull() {
            addCriterion("group2 is null");
            return (Criteria) this;
        }

        public Criteria andGroup2IsNotNull() {
            addCriterion("group2 is not null");
            return (Criteria) this;
        }

        public Criteria andGroup2EqualTo(String value) {
            addCriterion("group2 =", value, "group2");
            return (Criteria) this;
        }

        public Criteria andGroup2NotEqualTo(String value) {
            addCriterion("group2 <>", value, "group2");
            return (Criteria) this;
        }

        public Criteria andGroup2GreaterThan(String value) {
            addCriterion("group2 >", value, "group2");
            return (Criteria) this;
        }

        public Criteria andGroup2GreaterThanOrEqualTo(String value) {
            addCriterion("group2 >=", value, "group2");
            return (Criteria) this;
        }

        public Criteria andGroup2LessThan(String value) {
            addCriterion("group2 <", value, "group2");
            return (Criteria) this;
        }

        public Criteria andGroup2LessThanOrEqualTo(String value) {
            addCriterion("group2 <=", value, "group2");
            return (Criteria) this;
        }

        public Criteria andGroup2Like(String value) {
            addCriterion("group2 like", value, "group2");
            return (Criteria) this;
        }

        public Criteria andGroup2NotLike(String value) {
            addCriterion("group2 not like", value, "group2");
            return (Criteria) this;
        }

        public Criteria andGroup2In(List<String> values) {
            addCriterion("group2 in", values, "group2");
            return (Criteria) this;
        }

        public Criteria andGroup2NotIn(List<String> values) {
            addCriterion("group2 not in", values, "group2");
            return (Criteria) this;
        }

        public Criteria andGroup2Between(String value1, String value2) {
            addCriterion("group2 between", value1, value2, "group2");
            return (Criteria) this;
        }

        public Criteria andGroup2NotBetween(String value1, String value2) {
            addCriterion("group2 not between", value1, value2, "group2");
            return (Criteria) this;
        }

        public Criteria andGroup3IsNull() {
            addCriterion("group3 is null");
            return (Criteria) this;
        }

        public Criteria andGroup3IsNotNull() {
            addCriterion("group3 is not null");
            return (Criteria) this;
        }

        public Criteria andGroup3EqualTo(String value) {
            addCriterion("group3 =", value, "group3");
            return (Criteria) this;
        }

        public Criteria andGroup3NotEqualTo(String value) {
            addCriterion("group3 <>", value, "group3");
            return (Criteria) this;
        }

        public Criteria andGroup3GreaterThan(String value) {
            addCriterion("group3 >", value, "group3");
            return (Criteria) this;
        }

        public Criteria andGroup3GreaterThanOrEqualTo(String value) {
            addCriterion("group3 >=", value, "group3");
            return (Criteria) this;
        }

        public Criteria andGroup3LessThan(String value) {
            addCriterion("group3 <", value, "group3");
            return (Criteria) this;
        }

        public Criteria andGroup3LessThanOrEqualTo(String value) {
            addCriterion("group3 <=", value, "group3");
            return (Criteria) this;
        }

        public Criteria andGroup3Like(String value) {
            addCriterion("group3 like", value, "group3");
            return (Criteria) this;
        }

        public Criteria andGroup3NotLike(String value) {
            addCriterion("group3 not like", value, "group3");
            return (Criteria) this;
        }

        public Criteria andGroup3In(List<String> values) {
            addCriterion("group3 in", values, "group3");
            return (Criteria) this;
        }

        public Criteria andGroup3NotIn(List<String> values) {
            addCriterion("group3 not in", values, "group3");
            return (Criteria) this;
        }

        public Criteria andGroup3Between(String value1, String value2) {
            addCriterion("group3 between", value1, value2, "group3");
            return (Criteria) this;
        }

        public Criteria andGroup3NotBetween(String value1, String value2) {
            addCriterion("group3 not between", value1, value2, "group3");
            return (Criteria) this;
        }

        public Criteria andGroup4IsNull() {
            addCriterion("group4 is null");
            return (Criteria) this;
        }

        public Criteria andGroup4IsNotNull() {
            addCriterion("group4 is not null");
            return (Criteria) this;
        }

        public Criteria andGroup4EqualTo(String value) {
            addCriterion("group4 =", value, "group4");
            return (Criteria) this;
        }

        public Criteria andGroup4NotEqualTo(String value) {
            addCriterion("group4 <>", value, "group4");
            return (Criteria) this;
        }

        public Criteria andGroup4GreaterThan(String value) {
            addCriterion("group4 >", value, "group4");
            return (Criteria) this;
        }

        public Criteria andGroup4GreaterThanOrEqualTo(String value) {
            addCriterion("group4 >=", value, "group4");
            return (Criteria) this;
        }

        public Criteria andGroup4LessThan(String value) {
            addCriterion("group4 <", value, "group4");
            return (Criteria) this;
        }

        public Criteria andGroup4LessThanOrEqualTo(String value) {
            addCriterion("group4 <=", value, "group4");
            return (Criteria) this;
        }

        public Criteria andGroup4Like(String value) {
            addCriterion("group4 like", value, "group4");
            return (Criteria) this;
        }

        public Criteria andGroup4NotLike(String value) {
            addCriterion("group4 not like", value, "group4");
            return (Criteria) this;
        }

        public Criteria andGroup4In(List<String> values) {
            addCriterion("group4 in", values, "group4");
            return (Criteria) this;
        }

        public Criteria andGroup4NotIn(List<String> values) {
            addCriterion("group4 not in", values, "group4");
            return (Criteria) this;
        }

        public Criteria andGroup4Between(String value1, String value2) {
            addCriterion("group4 between", value1, value2, "group4");
            return (Criteria) this;
        }

        public Criteria andGroup4NotBetween(String value1, String value2) {
            addCriterion("group4 not between", value1, value2, "group4");
            return (Criteria) this;
        }

        public Criteria andGroup5IsNull() {
            addCriterion("group5 is null");
            return (Criteria) this;
        }

        public Criteria andGroup5IsNotNull() {
            addCriterion("group5 is not null");
            return (Criteria) this;
        }

        public Criteria andGroup5EqualTo(String value) {
            addCriterion("group5 =", value, "group5");
            return (Criteria) this;
        }

        public Criteria andGroup5NotEqualTo(String value) {
            addCriterion("group5 <>", value, "group5");
            return (Criteria) this;
        }

        public Criteria andGroup5GreaterThan(String value) {
            addCriterion("group5 >", value, "group5");
            return (Criteria) this;
        }

        public Criteria andGroup5GreaterThanOrEqualTo(String value) {
            addCriterion("group5 >=", value, "group5");
            return (Criteria) this;
        }

        public Criteria andGroup5LessThan(String value) {
            addCriterion("group5 <", value, "group5");
            return (Criteria) this;
        }

        public Criteria andGroup5LessThanOrEqualTo(String value) {
            addCriterion("group5 <=", value, "group5");
            return (Criteria) this;
        }

        public Criteria andGroup5Like(String value) {
            addCriterion("group5 like", value, "group5");
            return (Criteria) this;
        }

        public Criteria andGroup5NotLike(String value) {
            addCriterion("group5 not like", value, "group5");
            return (Criteria) this;
        }

        public Criteria andGroup5In(List<String> values) {
            addCriterion("group5 in", values, "group5");
            return (Criteria) this;
        }

        public Criteria andGroup5NotIn(List<String> values) {
            addCriterion("group5 not in", values, "group5");
            return (Criteria) this;
        }

        public Criteria andGroup5Between(String value1, String value2) {
            addCriterion("group5 between", value1, value2, "group5");
            return (Criteria) this;
        }

        public Criteria andGroup5NotBetween(String value1, String value2) {
            addCriterion("group5 not between", value1, value2, "group5");
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