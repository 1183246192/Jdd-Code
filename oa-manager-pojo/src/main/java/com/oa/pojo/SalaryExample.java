package com.oa.pojo;

import java.util.ArrayList;
import java.util.List;

public class SalaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalaryExample() {
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

        public Criteria andMonthIsNull() {
            addCriterion("month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(String value) {
            addCriterion("month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(String value) {
            addCriterion("month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(String value) {
            addCriterion("month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(String value) {
            addCriterion("month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(String value) {
            addCriterion("month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(String value) {
            addCriterion("month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLike(String value) {
            addCriterion("month like", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotLike(String value) {
            addCriterion("month not like", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<String> values) {
            addCriterion("month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<String> values) {
            addCriterion("month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(String value1, String value2) {
            addCriterion("month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(String value1, String value2) {
            addCriterion("month not between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryIsNull() {
            addCriterion("basicsalary is null");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryIsNotNull() {
            addCriterion("basicsalary is not null");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryEqualTo(Float value) {
            addCriterion("basicsalary =", value, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryNotEqualTo(Float value) {
            addCriterion("basicsalary <>", value, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryGreaterThan(Float value) {
            addCriterion("basicsalary >", value, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryGreaterThanOrEqualTo(Float value) {
            addCriterion("basicsalary >=", value, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryLessThan(Float value) {
            addCriterion("basicsalary <", value, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryLessThanOrEqualTo(Float value) {
            addCriterion("basicsalary <=", value, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryIn(List<Float> values) {
            addCriterion("basicsalary in", values, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryNotIn(List<Float> values) {
            addCriterion("basicsalary not in", values, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryBetween(Float value1, Float value2) {
            addCriterion("basicsalary between", value1, value2, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andBasicsalaryNotBetween(Float value1, Float value2) {
            addCriterion("basicsalary not between", value1, value2, "basicsalary");
            return (Criteria) this;
        }

        public Criteria andFsalaryIsNull() {
            addCriterion("Fsalary is null");
            return (Criteria) this;
        }

        public Criteria andFsalaryIsNotNull() {
            addCriterion("Fsalary is not null");
            return (Criteria) this;
        }

        public Criteria andFsalaryEqualTo(Float value) {
            addCriterion("Fsalary =", value, "fsalary");
            return (Criteria) this;
        }

        public Criteria andFsalaryNotEqualTo(Float value) {
            addCriterion("Fsalary <>", value, "fsalary");
            return (Criteria) this;
        }

        public Criteria andFsalaryGreaterThan(Float value) {
            addCriterion("Fsalary >", value, "fsalary");
            return (Criteria) this;
        }

        public Criteria andFsalaryGreaterThanOrEqualTo(Float value) {
            addCriterion("Fsalary >=", value, "fsalary");
            return (Criteria) this;
        }

        public Criteria andFsalaryLessThan(Float value) {
            addCriterion("Fsalary <", value, "fsalary");
            return (Criteria) this;
        }

        public Criteria andFsalaryLessThanOrEqualTo(Float value) {
            addCriterion("Fsalary <=", value, "fsalary");
            return (Criteria) this;
        }

        public Criteria andFsalaryIn(List<Float> values) {
            addCriterion("Fsalary in", values, "fsalary");
            return (Criteria) this;
        }

        public Criteria andFsalaryNotIn(List<Float> values) {
            addCriterion("Fsalary not in", values, "fsalary");
            return (Criteria) this;
        }

        public Criteria andFsalaryBetween(Float value1, Float value2) {
            addCriterion("Fsalary between", value1, value2, "fsalary");
            return (Criteria) this;
        }

        public Criteria andFsalaryNotBetween(Float value1, Float value2) {
            addCriterion("Fsalary not between", value1, value2, "fsalary");
            return (Criteria) this;
        }

        public Criteria andCheckingdaysIsNull() {
            addCriterion("checkingdays is null");
            return (Criteria) this;
        }

        public Criteria andCheckingdaysIsNotNull() {
            addCriterion("checkingdays is not null");
            return (Criteria) this;
        }

        public Criteria andCheckingdaysEqualTo(Integer value) {
            addCriterion("checkingdays =", value, "checkingdays");
            return (Criteria) this;
        }

        public Criteria andCheckingdaysNotEqualTo(Integer value) {
            addCriterion("checkingdays <>", value, "checkingdays");
            return (Criteria) this;
        }

        public Criteria andCheckingdaysGreaterThan(Integer value) {
            addCriterion("checkingdays >", value, "checkingdays");
            return (Criteria) this;
        }

        public Criteria andCheckingdaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("checkingdays >=", value, "checkingdays");
            return (Criteria) this;
        }

        public Criteria andCheckingdaysLessThan(Integer value) {
            addCriterion("checkingdays <", value, "checkingdays");
            return (Criteria) this;
        }

        public Criteria andCheckingdaysLessThanOrEqualTo(Integer value) {
            addCriterion("checkingdays <=", value, "checkingdays");
            return (Criteria) this;
        }

        public Criteria andCheckingdaysIn(List<Integer> values) {
            addCriterion("checkingdays in", values, "checkingdays");
            return (Criteria) this;
        }

        public Criteria andCheckingdaysNotIn(List<Integer> values) {
            addCriterion("checkingdays not in", values, "checkingdays");
            return (Criteria) this;
        }

        public Criteria andCheckingdaysBetween(Integer value1, Integer value2) {
            addCriterion("checkingdays between", value1, value2, "checkingdays");
            return (Criteria) this;
        }

        public Criteria andCheckingdaysNotBetween(Integer value1, Integer value2) {
            addCriterion("checkingdays not between", value1, value2, "checkingdays");
            return (Criteria) this;
        }

        public Criteria andTrafficallowanceIsNull() {
            addCriterion("trafficallowance is null");
            return (Criteria) this;
        }

        public Criteria andTrafficallowanceIsNotNull() {
            addCriterion("trafficallowance is not null");
            return (Criteria) this;
        }

        public Criteria andTrafficallowanceEqualTo(Float value) {
            addCriterion("trafficallowance =", value, "trafficallowance");
            return (Criteria) this;
        }

        public Criteria andTrafficallowanceNotEqualTo(Float value) {
            addCriterion("trafficallowance <>", value, "trafficallowance");
            return (Criteria) this;
        }

        public Criteria andTrafficallowanceGreaterThan(Float value) {
            addCriterion("trafficallowance >", value, "trafficallowance");
            return (Criteria) this;
        }

        public Criteria andTrafficallowanceGreaterThanOrEqualTo(Float value) {
            addCriterion("trafficallowance >=", value, "trafficallowance");
            return (Criteria) this;
        }

        public Criteria andTrafficallowanceLessThan(Float value) {
            addCriterion("trafficallowance <", value, "trafficallowance");
            return (Criteria) this;
        }

        public Criteria andTrafficallowanceLessThanOrEqualTo(Float value) {
            addCriterion("trafficallowance <=", value, "trafficallowance");
            return (Criteria) this;
        }

        public Criteria andTrafficallowanceIn(List<Float> values) {
            addCriterion("trafficallowance in", values, "trafficallowance");
            return (Criteria) this;
        }

        public Criteria andTrafficallowanceNotIn(List<Float> values) {
            addCriterion("trafficallowance not in", values, "trafficallowance");
            return (Criteria) this;
        }

        public Criteria andTrafficallowanceBetween(Float value1, Float value2) {
            addCriterion("trafficallowance between", value1, value2, "trafficallowance");
            return (Criteria) this;
        }

        public Criteria andTrafficallowanceNotBetween(Float value1, Float value2) {
            addCriterion("trafficallowance not between", value1, value2, "trafficallowance");
            return (Criteria) this;
        }

        public Criteria andOtherallowanceIsNull() {
            addCriterion("otherallowance is null");
            return (Criteria) this;
        }

        public Criteria andOtherallowanceIsNotNull() {
            addCriterion("otherallowance is not null");
            return (Criteria) this;
        }

        public Criteria andOtherallowanceEqualTo(Float value) {
            addCriterion("otherallowance =", value, "otherallowance");
            return (Criteria) this;
        }

        public Criteria andOtherallowanceNotEqualTo(Float value) {
            addCriterion("otherallowance <>", value, "otherallowance");
            return (Criteria) this;
        }

        public Criteria andOtherallowanceGreaterThan(Float value) {
            addCriterion("otherallowance >", value, "otherallowance");
            return (Criteria) this;
        }

        public Criteria andOtherallowanceGreaterThanOrEqualTo(Float value) {
            addCriterion("otherallowance >=", value, "otherallowance");
            return (Criteria) this;
        }

        public Criteria andOtherallowanceLessThan(Float value) {
            addCriterion("otherallowance <", value, "otherallowance");
            return (Criteria) this;
        }

        public Criteria andOtherallowanceLessThanOrEqualTo(Float value) {
            addCriterion("otherallowance <=", value, "otherallowance");
            return (Criteria) this;
        }

        public Criteria andOtherallowanceIn(List<Float> values) {
            addCriterion("otherallowance in", values, "otherallowance");
            return (Criteria) this;
        }

        public Criteria andOtherallowanceNotIn(List<Float> values) {
            addCriterion("otherallowance not in", values, "otherallowance");
            return (Criteria) this;
        }

        public Criteria andOtherallowanceBetween(Float value1, Float value2) {
            addCriterion("otherallowance between", value1, value2, "otherallowance");
            return (Criteria) this;
        }

        public Criteria andOtherallowanceNotBetween(Float value1, Float value2) {
            addCriterion("otherallowance not between", value1, value2, "otherallowance");
            return (Criteria) this;
        }

        public Criteria andTotalallowanceIsNull() {
            addCriterion("totalallowance is null");
            return (Criteria) this;
        }

        public Criteria andTotalallowanceIsNotNull() {
            addCriterion("totalallowance is not null");
            return (Criteria) this;
        }

        public Criteria andTotalallowanceEqualTo(Float value) {
            addCriterion("totalallowance =", value, "totalallowance");
            return (Criteria) this;
        }

        public Criteria andTotalallowanceNotEqualTo(Float value) {
            addCriterion("totalallowance <>", value, "totalallowance");
            return (Criteria) this;
        }

        public Criteria andTotalallowanceGreaterThan(Float value) {
            addCriterion("totalallowance >", value, "totalallowance");
            return (Criteria) this;
        }

        public Criteria andTotalallowanceGreaterThanOrEqualTo(Float value) {
            addCriterion("totalallowance >=", value, "totalallowance");
            return (Criteria) this;
        }

        public Criteria andTotalallowanceLessThan(Float value) {
            addCriterion("totalallowance <", value, "totalallowance");
            return (Criteria) this;
        }

        public Criteria andTotalallowanceLessThanOrEqualTo(Float value) {
            addCriterion("totalallowance <=", value, "totalallowance");
            return (Criteria) this;
        }

        public Criteria andTotalallowanceIn(List<Float> values) {
            addCriterion("totalallowance in", values, "totalallowance");
            return (Criteria) this;
        }

        public Criteria andTotalallowanceNotIn(List<Float> values) {
            addCriterion("totalallowance not in", values, "totalallowance");
            return (Criteria) this;
        }

        public Criteria andTotalallowanceBetween(Float value1, Float value2) {
            addCriterion("totalallowance between", value1, value2, "totalallowance");
            return (Criteria) this;
        }

        public Criteria andTotalallowanceNotBetween(Float value1, Float value2) {
            addCriterion("totalallowance not between", value1, value2, "totalallowance");
            return (Criteria) this;
        }

        public Criteria andEndowmentinsuranceIsNull() {
            addCriterion("endowmentinsurance is null");
            return (Criteria) this;
        }

        public Criteria andEndowmentinsuranceIsNotNull() {
            addCriterion("endowmentinsurance is not null");
            return (Criteria) this;
        }

        public Criteria andEndowmentinsuranceEqualTo(Float value) {
            addCriterion("endowmentinsurance =", value, "endowmentinsurance");
            return (Criteria) this;
        }

        public Criteria andEndowmentinsuranceNotEqualTo(Float value) {
            addCriterion("endowmentinsurance <>", value, "endowmentinsurance");
            return (Criteria) this;
        }

        public Criteria andEndowmentinsuranceGreaterThan(Float value) {
            addCriterion("endowmentinsurance >", value, "endowmentinsurance");
            return (Criteria) this;
        }

        public Criteria andEndowmentinsuranceGreaterThanOrEqualTo(Float value) {
            addCriterion("endowmentinsurance >=", value, "endowmentinsurance");
            return (Criteria) this;
        }

        public Criteria andEndowmentinsuranceLessThan(Float value) {
            addCriterion("endowmentinsurance <", value, "endowmentinsurance");
            return (Criteria) this;
        }

        public Criteria andEndowmentinsuranceLessThanOrEqualTo(Float value) {
            addCriterion("endowmentinsurance <=", value, "endowmentinsurance");
            return (Criteria) this;
        }

        public Criteria andEndowmentinsuranceIn(List<Float> values) {
            addCriterion("endowmentinsurance in", values, "endowmentinsurance");
            return (Criteria) this;
        }

        public Criteria andEndowmentinsuranceNotIn(List<Float> values) {
            addCriterion("endowmentinsurance not in", values, "endowmentinsurance");
            return (Criteria) this;
        }

        public Criteria andEndowmentinsuranceBetween(Float value1, Float value2) {
            addCriterion("endowmentinsurance between", value1, value2, "endowmentinsurance");
            return (Criteria) this;
        }

        public Criteria andEndowmentinsuranceNotBetween(Float value1, Float value2) {
            addCriterion("endowmentinsurance not between", value1, value2, "endowmentinsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalinsuranceIsNull() {
            addCriterion("medicalinsurance is null");
            return (Criteria) this;
        }

        public Criteria andMedicalinsuranceIsNotNull() {
            addCriterion("medicalinsurance is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalinsuranceEqualTo(Float value) {
            addCriterion("medicalinsurance =", value, "medicalinsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalinsuranceNotEqualTo(Float value) {
            addCriterion("medicalinsurance <>", value, "medicalinsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalinsuranceGreaterThan(Float value) {
            addCriterion("medicalinsurance >", value, "medicalinsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalinsuranceGreaterThanOrEqualTo(Float value) {
            addCriterion("medicalinsurance >=", value, "medicalinsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalinsuranceLessThan(Float value) {
            addCriterion("medicalinsurance <", value, "medicalinsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalinsuranceLessThanOrEqualTo(Float value) {
            addCriterion("medicalinsurance <=", value, "medicalinsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalinsuranceIn(List<Float> values) {
            addCriterion("medicalinsurance in", values, "medicalinsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalinsuranceNotIn(List<Float> values) {
            addCriterion("medicalinsurance not in", values, "medicalinsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalinsuranceBetween(Float value1, Float value2) {
            addCriterion("medicalinsurance between", value1, value2, "medicalinsurance");
            return (Criteria) this;
        }

        public Criteria andMedicalinsuranceNotBetween(Float value1, Float value2) {
            addCriterion("medicalinsurance not between", value1, value2, "medicalinsurance");
            return (Criteria) this;
        }

        public Criteria andUnemploymentinsuranceIsNull() {
            addCriterion("unemploymentinsurance is null");
            return (Criteria) this;
        }

        public Criteria andUnemploymentinsuranceIsNotNull() {
            addCriterion("unemploymentinsurance is not null");
            return (Criteria) this;
        }

        public Criteria andUnemploymentinsuranceEqualTo(Float value) {
            addCriterion("unemploymentinsurance =", value, "unemploymentinsurance");
            return (Criteria) this;
        }

        public Criteria andUnemploymentinsuranceNotEqualTo(Float value) {
            addCriterion("unemploymentinsurance <>", value, "unemploymentinsurance");
            return (Criteria) this;
        }

        public Criteria andUnemploymentinsuranceGreaterThan(Float value) {
            addCriterion("unemploymentinsurance >", value, "unemploymentinsurance");
            return (Criteria) this;
        }

        public Criteria andUnemploymentinsuranceGreaterThanOrEqualTo(Float value) {
            addCriterion("unemploymentinsurance >=", value, "unemploymentinsurance");
            return (Criteria) this;
        }

        public Criteria andUnemploymentinsuranceLessThan(Float value) {
            addCriterion("unemploymentinsurance <", value, "unemploymentinsurance");
            return (Criteria) this;
        }

        public Criteria andUnemploymentinsuranceLessThanOrEqualTo(Float value) {
            addCriterion("unemploymentinsurance <=", value, "unemploymentinsurance");
            return (Criteria) this;
        }

        public Criteria andUnemploymentinsuranceIn(List<Float> values) {
            addCriterion("unemploymentinsurance in", values, "unemploymentinsurance");
            return (Criteria) this;
        }

        public Criteria andUnemploymentinsuranceNotIn(List<Float> values) {
            addCriterion("unemploymentinsurance not in", values, "unemploymentinsurance");
            return (Criteria) this;
        }

        public Criteria andUnemploymentinsuranceBetween(Float value1, Float value2) {
            addCriterion("unemploymentinsurance between", value1, value2, "unemploymentinsurance");
            return (Criteria) this;
        }

        public Criteria andUnemploymentinsuranceNotBetween(Float value1, Float value2) {
            addCriterion("unemploymentinsurance not between", value1, value2, "unemploymentinsurance");
            return (Criteria) this;
        }

        public Criteria andEmploymentinjuryinsuranceIsNull() {
            addCriterion("employmentinjuryinsurance is null");
            return (Criteria) this;
        }

        public Criteria andEmploymentinjuryinsuranceIsNotNull() {
            addCriterion("employmentinjuryinsurance is not null");
            return (Criteria) this;
        }

        public Criteria andEmploymentinjuryinsuranceEqualTo(Float value) {
            addCriterion("employmentinjuryinsurance =", value, "employmentinjuryinsurance");
            return (Criteria) this;
        }

        public Criteria andEmploymentinjuryinsuranceNotEqualTo(Float value) {
            addCriterion("employmentinjuryinsurance <>", value, "employmentinjuryinsurance");
            return (Criteria) this;
        }

        public Criteria andEmploymentinjuryinsuranceGreaterThan(Float value) {
            addCriterion("employmentinjuryinsurance >", value, "employmentinjuryinsurance");
            return (Criteria) this;
        }

        public Criteria andEmploymentinjuryinsuranceGreaterThanOrEqualTo(Float value) {
            addCriterion("employmentinjuryinsurance >=", value, "employmentinjuryinsurance");
            return (Criteria) this;
        }

        public Criteria andEmploymentinjuryinsuranceLessThan(Float value) {
            addCriterion("employmentinjuryinsurance <", value, "employmentinjuryinsurance");
            return (Criteria) this;
        }

        public Criteria andEmploymentinjuryinsuranceLessThanOrEqualTo(Float value) {
            addCriterion("employmentinjuryinsurance <=", value, "employmentinjuryinsurance");
            return (Criteria) this;
        }

        public Criteria andEmploymentinjuryinsuranceIn(List<Float> values) {
            addCriterion("employmentinjuryinsurance in", values, "employmentinjuryinsurance");
            return (Criteria) this;
        }

        public Criteria andEmploymentinjuryinsuranceNotIn(List<Float> values) {
            addCriterion("employmentinjuryinsurance not in", values, "employmentinjuryinsurance");
            return (Criteria) this;
        }

        public Criteria andEmploymentinjuryinsuranceBetween(Float value1, Float value2) {
            addCriterion("employmentinjuryinsurance between", value1, value2, "employmentinjuryinsurance");
            return (Criteria) this;
        }

        public Criteria andEmploymentinjuryinsuranceNotBetween(Float value1, Float value2) {
            addCriterion("employmentinjuryinsurance not between", value1, value2, "employmentinjuryinsurance");
            return (Criteria) this;
        }

        public Criteria andMaternityinsuranceIsNull() {
            addCriterion("maternityinsurance is null");
            return (Criteria) this;
        }

        public Criteria andMaternityinsuranceIsNotNull() {
            addCriterion("maternityinsurance is not null");
            return (Criteria) this;
        }

        public Criteria andMaternityinsuranceEqualTo(Float value) {
            addCriterion("maternityinsurance =", value, "maternityinsurance");
            return (Criteria) this;
        }

        public Criteria andMaternityinsuranceNotEqualTo(Float value) {
            addCriterion("maternityinsurance <>", value, "maternityinsurance");
            return (Criteria) this;
        }

        public Criteria andMaternityinsuranceGreaterThan(Float value) {
            addCriterion("maternityinsurance >", value, "maternityinsurance");
            return (Criteria) this;
        }

        public Criteria andMaternityinsuranceGreaterThanOrEqualTo(Float value) {
            addCriterion("maternityinsurance >=", value, "maternityinsurance");
            return (Criteria) this;
        }

        public Criteria andMaternityinsuranceLessThan(Float value) {
            addCriterion("maternityinsurance <", value, "maternityinsurance");
            return (Criteria) this;
        }

        public Criteria andMaternityinsuranceLessThanOrEqualTo(Float value) {
            addCriterion("maternityinsurance <=", value, "maternityinsurance");
            return (Criteria) this;
        }

        public Criteria andMaternityinsuranceIn(List<Float> values) {
            addCriterion("maternityinsurance in", values, "maternityinsurance");
            return (Criteria) this;
        }

        public Criteria andMaternityinsuranceNotIn(List<Float> values) {
            addCriterion("maternityinsurance not in", values, "maternityinsurance");
            return (Criteria) this;
        }

        public Criteria andMaternityinsuranceBetween(Float value1, Float value2) {
            addCriterion("maternityinsurance between", value1, value2, "maternityinsurance");
            return (Criteria) this;
        }

        public Criteria andMaternityinsuranceNotBetween(Float value1, Float value2) {
            addCriterion("maternityinsurance not between", value1, value2, "maternityinsurance");
            return (Criteria) this;
        }

        public Criteria andHousingfundIsNull() {
            addCriterion("housingfund is null");
            return (Criteria) this;
        }

        public Criteria andHousingfundIsNotNull() {
            addCriterion("housingfund is not null");
            return (Criteria) this;
        }

        public Criteria andHousingfundEqualTo(Float value) {
            addCriterion("housingfund =", value, "housingfund");
            return (Criteria) this;
        }

        public Criteria andHousingfundNotEqualTo(Float value) {
            addCriterion("housingfund <>", value, "housingfund");
            return (Criteria) this;
        }

        public Criteria andHousingfundGreaterThan(Float value) {
            addCriterion("housingfund >", value, "housingfund");
            return (Criteria) this;
        }

        public Criteria andHousingfundGreaterThanOrEqualTo(Float value) {
            addCriterion("housingfund >=", value, "housingfund");
            return (Criteria) this;
        }

        public Criteria andHousingfundLessThan(Float value) {
            addCriterion("housingfund <", value, "housingfund");
            return (Criteria) this;
        }

        public Criteria andHousingfundLessThanOrEqualTo(Float value) {
            addCriterion("housingfund <=", value, "housingfund");
            return (Criteria) this;
        }

        public Criteria andHousingfundIn(List<Float> values) {
            addCriterion("housingfund in", values, "housingfund");
            return (Criteria) this;
        }

        public Criteria andHousingfundNotIn(List<Float> values) {
            addCriterion("housingfund not in", values, "housingfund");
            return (Criteria) this;
        }

        public Criteria andHousingfundBetween(Float value1, Float value2) {
            addCriterion("housingfund between", value1, value2, "housingfund");
            return (Criteria) this;
        }

        public Criteria andHousingfundNotBetween(Float value1, Float value2) {
            addCriterion("housingfund not between", value1, value2, "housingfund");
            return (Criteria) this;
        }

        public Criteria andOthersdeductIsNull() {
            addCriterion("othersdeduct is null");
            return (Criteria) this;
        }

        public Criteria andOthersdeductIsNotNull() {
            addCriterion("othersdeduct is not null");
            return (Criteria) this;
        }

        public Criteria andOthersdeductEqualTo(Float value) {
            addCriterion("othersdeduct =", value, "othersdeduct");
            return (Criteria) this;
        }

        public Criteria andOthersdeductNotEqualTo(Float value) {
            addCriterion("othersdeduct <>", value, "othersdeduct");
            return (Criteria) this;
        }

        public Criteria andOthersdeductGreaterThan(Float value) {
            addCriterion("othersdeduct >", value, "othersdeduct");
            return (Criteria) this;
        }

        public Criteria andOthersdeductGreaterThanOrEqualTo(Float value) {
            addCriterion("othersdeduct >=", value, "othersdeduct");
            return (Criteria) this;
        }

        public Criteria andOthersdeductLessThan(Float value) {
            addCriterion("othersdeduct <", value, "othersdeduct");
            return (Criteria) this;
        }

        public Criteria andOthersdeductLessThanOrEqualTo(Float value) {
            addCriterion("othersdeduct <=", value, "othersdeduct");
            return (Criteria) this;
        }

        public Criteria andOthersdeductIn(List<Float> values) {
            addCriterion("othersdeduct in", values, "othersdeduct");
            return (Criteria) this;
        }

        public Criteria andOthersdeductNotIn(List<Float> values) {
            addCriterion("othersdeduct not in", values, "othersdeduct");
            return (Criteria) this;
        }

        public Criteria andOthersdeductBetween(Float value1, Float value2) {
            addCriterion("othersdeduct between", value1, value2, "othersdeduct");
            return (Criteria) this;
        }

        public Criteria andOthersdeductNotBetween(Float value1, Float value2) {
            addCriterion("othersdeduct not between", value1, value2, "othersdeduct");
            return (Criteria) this;
        }

        public Criteria andTotaldeductIsNull() {
            addCriterion("totaldeduct is null");
            return (Criteria) this;
        }

        public Criteria andTotaldeductIsNotNull() {
            addCriterion("totaldeduct is not null");
            return (Criteria) this;
        }

        public Criteria andTotaldeductEqualTo(Float value) {
            addCriterion("totaldeduct =", value, "totaldeduct");
            return (Criteria) this;
        }

        public Criteria andTotaldeductNotEqualTo(Float value) {
            addCriterion("totaldeduct <>", value, "totaldeduct");
            return (Criteria) this;
        }

        public Criteria andTotaldeductGreaterThan(Float value) {
            addCriterion("totaldeduct >", value, "totaldeduct");
            return (Criteria) this;
        }

        public Criteria andTotaldeductGreaterThanOrEqualTo(Float value) {
            addCriterion("totaldeduct >=", value, "totaldeduct");
            return (Criteria) this;
        }

        public Criteria andTotaldeductLessThan(Float value) {
            addCriterion("totaldeduct <", value, "totaldeduct");
            return (Criteria) this;
        }

        public Criteria andTotaldeductLessThanOrEqualTo(Float value) {
            addCriterion("totaldeduct <=", value, "totaldeduct");
            return (Criteria) this;
        }

        public Criteria andTotaldeductIn(List<Float> values) {
            addCriterion("totaldeduct in", values, "totaldeduct");
            return (Criteria) this;
        }

        public Criteria andTotaldeductNotIn(List<Float> values) {
            addCriterion("totaldeduct not in", values, "totaldeduct");
            return (Criteria) this;
        }

        public Criteria andTotaldeductBetween(Float value1, Float value2) {
            addCriterion("totaldeduct between", value1, value2, "totaldeduct");
            return (Criteria) this;
        }

        public Criteria andTotaldeductNotBetween(Float value1, Float value2) {
            addCriterion("totaldeduct not between", value1, value2, "totaldeduct");
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