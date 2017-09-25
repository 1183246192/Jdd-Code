package com.oa.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AnnualvacationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnnualvacationExample() {
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

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(String value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(String value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(String value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(String value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(String value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(String value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLike(String value) {
            addCriterion("year like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotLike(String value) {
            addCriterion("year not like", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<String> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<String> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(String value1, String value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(String value1, String value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andHaveIsNull() {
            addCriterion("have is null");
            return (Criteria) this;
        }

        public Criteria andHaveIsNotNull() {
            addCriterion("have is not null");
            return (Criteria) this;
        }

        public Criteria andHaveEqualTo(Integer value) {
            addCriterion("have =", value, "have");
            return (Criteria) this;
        }

        public Criteria andHaveNotEqualTo(Integer value) {
            addCriterion("have <>", value, "have");
            return (Criteria) this;
        }

        public Criteria andHaveGreaterThan(Integer value) {
            addCriterion("have >", value, "have");
            return (Criteria) this;
        }

        public Criteria andHaveGreaterThanOrEqualTo(Integer value) {
            addCriterion("have >=", value, "have");
            return (Criteria) this;
        }

        public Criteria andHaveLessThan(Integer value) {
            addCriterion("have <", value, "have");
            return (Criteria) this;
        }

        public Criteria andHaveLessThanOrEqualTo(Integer value) {
            addCriterion("have <=", value, "have");
            return (Criteria) this;
        }

        public Criteria andHaveIn(List<Integer> values) {
            addCriterion("have in", values, "have");
            return (Criteria) this;
        }

        public Criteria andHaveNotIn(List<Integer> values) {
            addCriterion("have not in", values, "have");
            return (Criteria) this;
        }

        public Criteria andHaveBetween(Integer value1, Integer value2) {
            addCriterion("have between", value1, value2, "have");
            return (Criteria) this;
        }

        public Criteria andHaveNotBetween(Integer value1, Integer value2) {
            addCriterion("have not between", value1, value2, "have");
            return (Criteria) this;
        }

        public Criteria andUsedIsNull() {
            addCriterion("used is null");
            return (Criteria) this;
        }

        public Criteria andUsedIsNotNull() {
            addCriterion("used is not null");
            return (Criteria) this;
        }

        public Criteria andUsedEqualTo(Integer value) {
            addCriterion("used =", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotEqualTo(Integer value) {
            addCriterion("used <>", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedGreaterThan(Integer value) {
            addCriterion("used >", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedGreaterThanOrEqualTo(Integer value) {
            addCriterion("used >=", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedLessThan(Integer value) {
            addCriterion("used <", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedLessThanOrEqualTo(Integer value) {
            addCriterion("used <=", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedIn(List<Integer> values) {
            addCriterion("used in", values, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotIn(List<Integer> values) {
            addCriterion("used not in", values, "used");
            return (Criteria) this;
        }

        public Criteria andUsedBetween(Integer value1, Integer value2) {
            addCriterion("used between", value1, value2, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotBetween(Integer value1, Integer value2) {
            addCriterion("used not between", value1, value2, "used");
            return (Criteria) this;
        }

        public Criteria andRemainIsNull() {
            addCriterion("remain is null");
            return (Criteria) this;
        }

        public Criteria andRemainIsNotNull() {
            addCriterion("remain is not null");
            return (Criteria) this;
        }

        public Criteria andRemainEqualTo(Integer value) {
            addCriterion("remain =", value, "remain");
            return (Criteria) this;
        }

        public Criteria andRemainNotEqualTo(Integer value) {
            addCriterion("remain <>", value, "remain");
            return (Criteria) this;
        }

        public Criteria andRemainGreaterThan(Integer value) {
            addCriterion("remain >", value, "remain");
            return (Criteria) this;
        }

        public Criteria andRemainGreaterThanOrEqualTo(Integer value) {
            addCriterion("remain >=", value, "remain");
            return (Criteria) this;
        }

        public Criteria andRemainLessThan(Integer value) {
            addCriterion("remain <", value, "remain");
            return (Criteria) this;
        }

        public Criteria andRemainLessThanOrEqualTo(Integer value) {
            addCriterion("remain <=", value, "remain");
            return (Criteria) this;
        }

        public Criteria andRemainIn(List<Integer> values) {
            addCriterion("remain in", values, "remain");
            return (Criteria) this;
        }

        public Criteria andRemainNotIn(List<Integer> values) {
            addCriterion("remain not in", values, "remain");
            return (Criteria) this;
        }

        public Criteria andRemainBetween(Integer value1, Integer value2) {
            addCriterion("remain between", value1, value2, "remain");
            return (Criteria) this;
        }

        public Criteria andRemainNotBetween(Integer value1, Integer value2) {
            addCriterion("remain not between", value1, value2, "remain");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterionForJDBCDate("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterionForJDBCDate("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterionForJDBCDate("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterionForJDBCDate("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStoptimeIsNull() {
            addCriterion("stoptime is null");
            return (Criteria) this;
        }

        public Criteria andStoptimeIsNotNull() {
            addCriterion("stoptime is not null");
            return (Criteria) this;
        }

        public Criteria andStoptimeEqualTo(Date value) {
            addCriterionForJDBCDate("stoptime =", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("stoptime <>", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeGreaterThan(Date value) {
            addCriterionForJDBCDate("stoptime >", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stoptime >=", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeLessThan(Date value) {
            addCriterionForJDBCDate("stoptime <", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stoptime <=", value, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeIn(List<Date> values) {
            addCriterionForJDBCDate("stoptime in", values, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("stoptime not in", values, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stoptime between", value1, value2, "stoptime");
            return (Criteria) this;
        }

        public Criteria andStoptimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stoptime not between", value1, value2, "stoptime");
            return (Criteria) this;
        }

        public Criteria andPreviousremainIsNull() {
            addCriterion("previousremain is null");
            return (Criteria) this;
        }

        public Criteria andPreviousremainIsNotNull() {
            addCriterion("previousremain is not null");
            return (Criteria) this;
        }

        public Criteria andPreviousremainEqualTo(Integer value) {
            addCriterion("previousremain =", value, "previousremain");
            return (Criteria) this;
        }

        public Criteria andPreviousremainNotEqualTo(Integer value) {
            addCriterion("previousremain <>", value, "previousremain");
            return (Criteria) this;
        }

        public Criteria andPreviousremainGreaterThan(Integer value) {
            addCriterion("previousremain >", value, "previousremain");
            return (Criteria) this;
        }

        public Criteria andPreviousremainGreaterThanOrEqualTo(Integer value) {
            addCriterion("previousremain >=", value, "previousremain");
            return (Criteria) this;
        }

        public Criteria andPreviousremainLessThan(Integer value) {
            addCriterion("previousremain <", value, "previousremain");
            return (Criteria) this;
        }

        public Criteria andPreviousremainLessThanOrEqualTo(Integer value) {
            addCriterion("previousremain <=", value, "previousremain");
            return (Criteria) this;
        }

        public Criteria andPreviousremainIn(List<Integer> values) {
            addCriterion("previousremain in", values, "previousremain");
            return (Criteria) this;
        }

        public Criteria andPreviousremainNotIn(List<Integer> values) {
            addCriterion("previousremain not in", values, "previousremain");
            return (Criteria) this;
        }

        public Criteria andPreviousremainBetween(Integer value1, Integer value2) {
            addCriterion("previousremain between", value1, value2, "previousremain");
            return (Criteria) this;
        }

        public Criteria andPreviousremainNotBetween(Integer value1, Integer value2) {
            addCriterion("previousremain not between", value1, value2, "previousremain");
            return (Criteria) this;
        }

        public Criteria andPreviousstoptimeIsNull() {
            addCriterion("previousstoptime is null");
            return (Criteria) this;
        }

        public Criteria andPreviousstoptimeIsNotNull() {
            addCriterion("previousstoptime is not null");
            return (Criteria) this;
        }

        public Criteria andPreviousstoptimeEqualTo(Date value) {
            addCriterionForJDBCDate("previousstoptime =", value, "previousstoptime");
            return (Criteria) this;
        }

        public Criteria andPreviousstoptimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("previousstoptime <>", value, "previousstoptime");
            return (Criteria) this;
        }

        public Criteria andPreviousstoptimeGreaterThan(Date value) {
            addCriterionForJDBCDate("previousstoptime >", value, "previousstoptime");
            return (Criteria) this;
        }

        public Criteria andPreviousstoptimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("previousstoptime >=", value, "previousstoptime");
            return (Criteria) this;
        }

        public Criteria andPreviousstoptimeLessThan(Date value) {
            addCriterionForJDBCDate("previousstoptime <", value, "previousstoptime");
            return (Criteria) this;
        }

        public Criteria andPreviousstoptimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("previousstoptime <=", value, "previousstoptime");
            return (Criteria) this;
        }

        public Criteria andPreviousstoptimeIn(List<Date> values) {
            addCriterionForJDBCDate("previousstoptime in", values, "previousstoptime");
            return (Criteria) this;
        }

        public Criteria andPreviousstoptimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("previousstoptime not in", values, "previousstoptime");
            return (Criteria) this;
        }

        public Criteria andPreviousstoptimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("previousstoptime between", value1, value2, "previousstoptime");
            return (Criteria) this;
        }

        public Criteria andPreviousstoptimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("previousstoptime not between", value1, value2, "previousstoptime");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Integer value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Integer value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Integer value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Integer value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Integer value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Integer> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Integer> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Integer value1, Integer value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("total not between", value1, value2, "total");
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