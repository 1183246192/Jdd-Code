package yycg.business.pojo.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class YpxxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YpxxExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBmIsNull() {
            addCriterion("bm is null");
            return (Criteria) this;
        }

        public Criteria andBmIsNotNull() {
            addCriterion("bm is not null");
            return (Criteria) this;
        }

        public Criteria andBmEqualTo(String value) {
            addCriterion("bm =", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmNotEqualTo(String value) {
            addCriterion("bm <>", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmGreaterThan(String value) {
            addCriterion("bm >", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmGreaterThanOrEqualTo(String value) {
            addCriterion("bm >=", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmLessThan(String value) {
            addCriterion("bm <", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmLessThanOrEqualTo(String value) {
            addCriterion("bm <=", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmLike(String value) {
            addCriterion("bm like", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmNotLike(String value) {
            addCriterion("bm not like", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmIn(List<String> values) {
            addCriterion("bm in", values, "bm");
            return (Criteria) this;
        }

        public Criteria andBmNotIn(List<String> values) {
            addCriterion("bm not in", values, "bm");
            return (Criteria) this;
        }

        public Criteria andBmBetween(String value1, String value2) {
            addCriterion("bm between", value1, value2, "bm");
            return (Criteria) this;
        }

        public Criteria andBmNotBetween(String value1, String value2) {
            addCriterion("bm not between", value1, value2, "bm");
            return (Criteria) this;
        }

        public Criteria andScqymcIsNull() {
            addCriterion("scqymc is null");
            return (Criteria) this;
        }

        public Criteria andScqymcIsNotNull() {
            addCriterion("scqymc is not null");
            return (Criteria) this;
        }

        public Criteria andScqymcEqualTo(String value) {
            addCriterion("scqymc =", value, "scqymc");
            return (Criteria) this;
        }

        public Criteria andScqymcNotEqualTo(String value) {
            addCriterion("scqymc <>", value, "scqymc");
            return (Criteria) this;
        }

        public Criteria andScqymcGreaterThan(String value) {
            addCriterion("scqymc >", value, "scqymc");
            return (Criteria) this;
        }

        public Criteria andScqymcGreaterThanOrEqualTo(String value) {
            addCriterion("scqymc >=", value, "scqymc");
            return (Criteria) this;
        }

        public Criteria andScqymcLessThan(String value) {
            addCriterion("scqymc <", value, "scqymc");
            return (Criteria) this;
        }

        public Criteria andScqymcLessThanOrEqualTo(String value) {
            addCriterion("scqymc <=", value, "scqymc");
            return (Criteria) this;
        }

        public Criteria andScqymcLike(String value) {
            addCriterion("scqymc like", value, "scqymc");
            return (Criteria) this;
        }

        public Criteria andScqymcNotLike(String value) {
            addCriterion("scqymc not like", value, "scqymc");
            return (Criteria) this;
        }

        public Criteria andScqymcIn(List<String> values) {
            addCriterion("scqymc in", values, "scqymc");
            return (Criteria) this;
        }

        public Criteria andScqymcNotIn(List<String> values) {
            addCriterion("scqymc not in", values, "scqymc");
            return (Criteria) this;
        }

        public Criteria andScqymcBetween(String value1, String value2) {
            addCriterion("scqymc between", value1, value2, "scqymc");
            return (Criteria) this;
        }

        public Criteria andScqymcNotBetween(String value1, String value2) {
            addCriterion("scqymc not between", value1, value2, "scqymc");
            return (Criteria) this;
        }

        public Criteria andSpmcIsNull() {
            addCriterion("spmc is null");
            return (Criteria) this;
        }

        public Criteria andSpmcIsNotNull() {
            addCriterion("spmc is not null");
            return (Criteria) this;
        }

        public Criteria andSpmcEqualTo(String value) {
            addCriterion("spmc =", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcNotEqualTo(String value) {
            addCriterion("spmc <>", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcGreaterThan(String value) {
            addCriterion("spmc >", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcGreaterThanOrEqualTo(String value) {
            addCriterion("spmc >=", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcLessThan(String value) {
            addCriterion("spmc <", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcLessThanOrEqualTo(String value) {
            addCriterion("spmc <=", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcLike(String value) {
            addCriterion("spmc like", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcNotLike(String value) {
            addCriterion("spmc not like", value, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcIn(List<String> values) {
            addCriterion("spmc in", values, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcNotIn(List<String> values) {
            addCriterion("spmc not in", values, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcBetween(String value1, String value2) {
            addCriterion("spmc between", value1, value2, "spmc");
            return (Criteria) this;
        }

        public Criteria andSpmcNotBetween(String value1, String value2) {
            addCriterion("spmc not between", value1, value2, "spmc");
            return (Criteria) this;
        }

        public Criteria andZbjgIsNull() {
            addCriterion("zbjg is null");
            return (Criteria) this;
        }

        public Criteria andZbjgIsNotNull() {
            addCriterion("zbjg is not null");
            return (Criteria) this;
        }

        public Criteria andZbjgEqualTo(Float value) {
            addCriterion("zbjg =", value, "zbjg");
            return (Criteria) this;
        }

        public Criteria andZbjgNotEqualTo(Float value) {
            addCriterion("zbjg <>", value, "zbjg");
            return (Criteria) this;
        }

        public Criteria andZbjgGreaterThan(Float value) {
            addCriterion("zbjg >", value, "zbjg");
            return (Criteria) this;
        }

        public Criteria andZbjgGreaterThanOrEqualTo(Float value) {
            addCriterion("zbjg >=", value, "zbjg");
            return (Criteria) this;
        }

        public Criteria andZbjgLessThan(Float value) {
            addCriterion("zbjg <", value, "zbjg");
            return (Criteria) this;
        }

        public Criteria andZbjgLessThanOrEqualTo(Float value) {
            addCriterion("zbjg <=", value, "zbjg");
            return (Criteria) this;
        }

        public Criteria andZbjgIn(List<Float> values) {
            addCriterion("zbjg in", values, "zbjg");
            return (Criteria) this;
        }

        public Criteria andZbjgNotIn(List<Float> values) {
            addCriterion("zbjg not in", values, "zbjg");
            return (Criteria) this;
        }

        public Criteria andZbjgBetween(Float value1, Float value2) {
            addCriterion("zbjg between", value1, value2, "zbjg");
            return (Criteria) this;
        }

        public Criteria andZbjgNotBetween(Float value1, Float value2) {
            addCriterion("zbjg not between", value1, value2, "zbjg");
            return (Criteria) this;
        }

        public Criteria andZpdzIsNull() {
            addCriterion("zpdz is null");
            return (Criteria) this;
        }

        public Criteria andZpdzIsNotNull() {
            addCriterion("zpdz is not null");
            return (Criteria) this;
        }

        public Criteria andZpdzEqualTo(String value) {
            addCriterion("zpdz =", value, "zpdz");
            return (Criteria) this;
        }

        public Criteria andZpdzNotEqualTo(String value) {
            addCriterion("zpdz <>", value, "zpdz");
            return (Criteria) this;
        }

        public Criteria andZpdzGreaterThan(String value) {
            addCriterion("zpdz >", value, "zpdz");
            return (Criteria) this;
        }

        public Criteria andZpdzGreaterThanOrEqualTo(String value) {
            addCriterion("zpdz >=", value, "zpdz");
            return (Criteria) this;
        }

        public Criteria andZpdzLessThan(String value) {
            addCriterion("zpdz <", value, "zpdz");
            return (Criteria) this;
        }

        public Criteria andZpdzLessThanOrEqualTo(String value) {
            addCriterion("zpdz <=", value, "zpdz");
            return (Criteria) this;
        }

        public Criteria andZpdzLike(String value) {
            addCriterion("zpdz like", value, "zpdz");
            return (Criteria) this;
        }

        public Criteria andZpdzNotLike(String value) {
            addCriterion("zpdz not like", value, "zpdz");
            return (Criteria) this;
        }

        public Criteria andZpdzIn(List<String> values) {
            addCriterion("zpdz in", values, "zpdz");
            return (Criteria) this;
        }

        public Criteria andZpdzNotIn(List<String> values) {
            addCriterion("zpdz not in", values, "zpdz");
            return (Criteria) this;
        }

        public Criteria andZpdzBetween(String value1, String value2) {
            addCriterion("zpdz between", value1, value2, "zpdz");
            return (Criteria) this;
        }

        public Criteria andZpdzNotBetween(String value1, String value2) {
            addCriterion("zpdz not between", value1, value2, "zpdz");
            return (Criteria) this;
        }

        public Criteria andPzwhIsNull() {
            addCriterion("pzwh is null");
            return (Criteria) this;
        }

        public Criteria andPzwhIsNotNull() {
            addCriterion("pzwh is not null");
            return (Criteria) this;
        }

        public Criteria andPzwhEqualTo(String value) {
            addCriterion("pzwh =", value, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhNotEqualTo(String value) {
            addCriterion("pzwh <>", value, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhGreaterThan(String value) {
            addCriterion("pzwh >", value, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhGreaterThanOrEqualTo(String value) {
            addCriterion("pzwh >=", value, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhLessThan(String value) {
            addCriterion("pzwh <", value, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhLessThanOrEqualTo(String value) {
            addCriterion("pzwh <=", value, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhLike(String value) {
            addCriterion("pzwh like", value, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhNotLike(String value) {
            addCriterion("pzwh not like", value, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhIn(List<String> values) {
            addCriterion("pzwh in", values, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhNotIn(List<String> values) {
            addCriterion("pzwh not in", values, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhBetween(String value1, String value2) {
            addCriterion("pzwh between", value1, value2, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhNotBetween(String value1, String value2) {
            addCriterion("pzwh not between", value1, value2, "pzwh");
            return (Criteria) this;
        }

        public Criteria andPzwhyxqIsNull() {
            addCriterion("pzwhyxq is null");
            return (Criteria) this;
        }

        public Criteria andPzwhyxqIsNotNull() {
            addCriterion("pzwhyxq is not null");
            return (Criteria) this;
        }

        public Criteria andPzwhyxqEqualTo(Date value) {
            addCriterionForJDBCDate("pzwhyxq =", value, "pzwhyxq");
            return (Criteria) this;
        }

        public Criteria andPzwhyxqNotEqualTo(Date value) {
            addCriterionForJDBCDate("pzwhyxq <>", value, "pzwhyxq");
            return (Criteria) this;
        }

        public Criteria andPzwhyxqGreaterThan(Date value) {
            addCriterionForJDBCDate("pzwhyxq >", value, "pzwhyxq");
            return (Criteria) this;
        }

        public Criteria andPzwhyxqGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pzwhyxq >=", value, "pzwhyxq");
            return (Criteria) this;
        }

        public Criteria andPzwhyxqLessThan(Date value) {
            addCriterionForJDBCDate("pzwhyxq <", value, "pzwhyxq");
            return (Criteria) this;
        }

        public Criteria andPzwhyxqLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pzwhyxq <=", value, "pzwhyxq");
            return (Criteria) this;
        }

        public Criteria andPzwhyxqIn(List<Date> values) {
            addCriterionForJDBCDate("pzwhyxq in", values, "pzwhyxq");
            return (Criteria) this;
        }

        public Criteria andPzwhyxqNotIn(List<Date> values) {
            addCriterionForJDBCDate("pzwhyxq not in", values, "pzwhyxq");
            return (Criteria) this;
        }

        public Criteria andPzwhyxqBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pzwhyxq between", value1, value2, "pzwhyxq");
            return (Criteria) this;
        }

        public Criteria andPzwhyxqNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pzwhyxq not between", value1, value2, "pzwhyxq");
            return (Criteria) this;
        }

        public Criteria andJkyIsNull() {
            addCriterion("jky is null");
            return (Criteria) this;
        }

        public Criteria andJkyIsNotNull() {
            addCriterion("jky is not null");
            return (Criteria) this;
        }

        public Criteria andJkyEqualTo(String value) {
            addCriterion("jky =", value, "jky");
            return (Criteria) this;
        }

        public Criteria andJkyNotEqualTo(String value) {
            addCriterion("jky <>", value, "jky");
            return (Criteria) this;
        }

        public Criteria andJkyGreaterThan(String value) {
            addCriterion("jky >", value, "jky");
            return (Criteria) this;
        }

        public Criteria andJkyGreaterThanOrEqualTo(String value) {
            addCriterion("jky >=", value, "jky");
            return (Criteria) this;
        }

        public Criteria andJkyLessThan(String value) {
            addCriterion("jky <", value, "jky");
            return (Criteria) this;
        }

        public Criteria andJkyLessThanOrEqualTo(String value) {
            addCriterion("jky <=", value, "jky");
            return (Criteria) this;
        }

        public Criteria andJkyLike(String value) {
            addCriterion("jky like", value, "jky");
            return (Criteria) this;
        }

        public Criteria andJkyNotLike(String value) {
            addCriterion("jky not like", value, "jky");
            return (Criteria) this;
        }

        public Criteria andJkyIn(List<String> values) {
            addCriterion("jky in", values, "jky");
            return (Criteria) this;
        }

        public Criteria andJkyNotIn(List<String> values) {
            addCriterion("jky not in", values, "jky");
            return (Criteria) this;
        }

        public Criteria andJkyBetween(String value1, String value2) {
            addCriterion("jky between", value1, value2, "jky");
            return (Criteria) this;
        }

        public Criteria andJkyNotBetween(String value1, String value2) {
            addCriterion("jky not between", value1, value2, "jky");
            return (Criteria) this;
        }

        public Criteria andBzczIsNull() {
            addCriterion("bzcz is null");
            return (Criteria) this;
        }

        public Criteria andBzczIsNotNull() {
            addCriterion("bzcz is not null");
            return (Criteria) this;
        }

        public Criteria andBzczEqualTo(String value) {
            addCriterion("bzcz =", value, "bzcz");
            return (Criteria) this;
        }

        public Criteria andBzczNotEqualTo(String value) {
            addCriterion("bzcz <>", value, "bzcz");
            return (Criteria) this;
        }

        public Criteria andBzczGreaterThan(String value) {
            addCriterion("bzcz >", value, "bzcz");
            return (Criteria) this;
        }

        public Criteria andBzczGreaterThanOrEqualTo(String value) {
            addCriterion("bzcz >=", value, "bzcz");
            return (Criteria) this;
        }

        public Criteria andBzczLessThan(String value) {
            addCriterion("bzcz <", value, "bzcz");
            return (Criteria) this;
        }

        public Criteria andBzczLessThanOrEqualTo(String value) {
            addCriterion("bzcz <=", value, "bzcz");
            return (Criteria) this;
        }

        public Criteria andBzczLike(String value) {
            addCriterion("bzcz like", value, "bzcz");
            return (Criteria) this;
        }

        public Criteria andBzczNotLike(String value) {
            addCriterion("bzcz not like", value, "bzcz");
            return (Criteria) this;
        }

        public Criteria andBzczIn(List<String> values) {
            addCriterion("bzcz in", values, "bzcz");
            return (Criteria) this;
        }

        public Criteria andBzczNotIn(List<String> values) {
            addCriterion("bzcz not in", values, "bzcz");
            return (Criteria) this;
        }

        public Criteria andBzczBetween(String value1, String value2) {
            addCriterion("bzcz between", value1, value2, "bzcz");
            return (Criteria) this;
        }

        public Criteria andBzczNotBetween(String value1, String value2) {
            addCriterion("bzcz not between", value1, value2, "bzcz");
            return (Criteria) this;
        }

        public Criteria andBzdwIsNull() {
            addCriterion("bzdw is null");
            return (Criteria) this;
        }

        public Criteria andBzdwIsNotNull() {
            addCriterion("bzdw is not null");
            return (Criteria) this;
        }

        public Criteria andBzdwEqualTo(String value) {
            addCriterion("bzdw =", value, "bzdw");
            return (Criteria) this;
        }

        public Criteria andBzdwNotEqualTo(String value) {
            addCriterion("bzdw <>", value, "bzdw");
            return (Criteria) this;
        }

        public Criteria andBzdwGreaterThan(String value) {
            addCriterion("bzdw >", value, "bzdw");
            return (Criteria) this;
        }

        public Criteria andBzdwGreaterThanOrEqualTo(String value) {
            addCriterion("bzdw >=", value, "bzdw");
            return (Criteria) this;
        }

        public Criteria andBzdwLessThan(String value) {
            addCriterion("bzdw <", value, "bzdw");
            return (Criteria) this;
        }

        public Criteria andBzdwLessThanOrEqualTo(String value) {
            addCriterion("bzdw <=", value, "bzdw");
            return (Criteria) this;
        }

        public Criteria andBzdwLike(String value) {
            addCriterion("bzdw like", value, "bzdw");
            return (Criteria) this;
        }

        public Criteria andBzdwNotLike(String value) {
            addCriterion("bzdw not like", value, "bzdw");
            return (Criteria) this;
        }

        public Criteria andBzdwIn(List<String> values) {
            addCriterion("bzdw in", values, "bzdw");
            return (Criteria) this;
        }

        public Criteria andBzdwNotIn(List<String> values) {
            addCriterion("bzdw not in", values, "bzdw");
            return (Criteria) this;
        }

        public Criteria andBzdwBetween(String value1, String value2) {
            addCriterion("bzdw between", value1, value2, "bzdw");
            return (Criteria) this;
        }

        public Criteria andBzdwNotBetween(String value1, String value2) {
            addCriterion("bzdw not between", value1, value2, "bzdw");
            return (Criteria) this;
        }

        public Criteria andLsjgIsNull() {
            addCriterion("lsjg is null");
            return (Criteria) this;
        }

        public Criteria andLsjgIsNotNull() {
            addCriterion("lsjg is not null");
            return (Criteria) this;
        }

        public Criteria andLsjgEqualTo(Float value) {
            addCriterion("lsjg =", value, "lsjg");
            return (Criteria) this;
        }

        public Criteria andLsjgNotEqualTo(Float value) {
            addCriterion("lsjg <>", value, "lsjg");
            return (Criteria) this;
        }

        public Criteria andLsjgGreaterThan(Float value) {
            addCriterion("lsjg >", value, "lsjg");
            return (Criteria) this;
        }

        public Criteria andLsjgGreaterThanOrEqualTo(Float value) {
            addCriterion("lsjg >=", value, "lsjg");
            return (Criteria) this;
        }

        public Criteria andLsjgLessThan(Float value) {
            addCriterion("lsjg <", value, "lsjg");
            return (Criteria) this;
        }

        public Criteria andLsjgLessThanOrEqualTo(Float value) {
            addCriterion("lsjg <=", value, "lsjg");
            return (Criteria) this;
        }

        public Criteria andLsjgIn(List<Float> values) {
            addCriterion("lsjg in", values, "lsjg");
            return (Criteria) this;
        }

        public Criteria andLsjgNotIn(List<Float> values) {
            addCriterion("lsjg not in", values, "lsjg");
            return (Criteria) this;
        }

        public Criteria andLsjgBetween(Float value1, Float value2) {
            addCriterion("lsjg between", value1, value2, "lsjg");
            return (Criteria) this;
        }

        public Criteria andLsjgNotBetween(Float value1, Float value2) {
            addCriterion("lsjg not between", value1, value2, "lsjg");
            return (Criteria) this;
        }

        public Criteria andLsjgccIsNull() {
            addCriterion("lsjgcc is null");
            return (Criteria) this;
        }

        public Criteria andLsjgccIsNotNull() {
            addCriterion("lsjgcc is not null");
            return (Criteria) this;
        }

        public Criteria andLsjgccEqualTo(String value) {
            addCriterion("lsjgcc =", value, "lsjgcc");
            return (Criteria) this;
        }

        public Criteria andLsjgccNotEqualTo(String value) {
            addCriterion("lsjgcc <>", value, "lsjgcc");
            return (Criteria) this;
        }

        public Criteria andLsjgccGreaterThan(String value) {
            addCriterion("lsjgcc >", value, "lsjgcc");
            return (Criteria) this;
        }

        public Criteria andLsjgccGreaterThanOrEqualTo(String value) {
            addCriterion("lsjgcc >=", value, "lsjgcc");
            return (Criteria) this;
        }

        public Criteria andLsjgccLessThan(String value) {
            addCriterion("lsjgcc <", value, "lsjgcc");
            return (Criteria) this;
        }

        public Criteria andLsjgccLessThanOrEqualTo(String value) {
            addCriterion("lsjgcc <=", value, "lsjgcc");
            return (Criteria) this;
        }

        public Criteria andLsjgccLike(String value) {
            addCriterion("lsjgcc like", value, "lsjgcc");
            return (Criteria) this;
        }

        public Criteria andLsjgccNotLike(String value) {
            addCriterion("lsjgcc not like", value, "lsjgcc");
            return (Criteria) this;
        }

        public Criteria andLsjgccIn(List<String> values) {
            addCriterion("lsjgcc in", values, "lsjgcc");
            return (Criteria) this;
        }

        public Criteria andLsjgccNotIn(List<String> values) {
            addCriterion("lsjgcc not in", values, "lsjgcc");
            return (Criteria) this;
        }

        public Criteria andLsjgccBetween(String value1, String value2) {
            addCriterion("lsjgcc between", value1, value2, "lsjgcc");
            return (Criteria) this;
        }

        public Criteria andLsjgccNotBetween(String value1, String value2) {
            addCriterion("lsjgcc not between", value1, value2, "lsjgcc");
            return (Criteria) this;
        }

        public Criteria andZlccIsNull() {
            addCriterion("zlcc is null");
            return (Criteria) this;
        }

        public Criteria andZlccIsNotNull() {
            addCriterion("zlcc is not null");
            return (Criteria) this;
        }

        public Criteria andZlccEqualTo(String value) {
            addCriterion("zlcc =", value, "zlcc");
            return (Criteria) this;
        }

        public Criteria andZlccNotEqualTo(String value) {
            addCriterion("zlcc <>", value, "zlcc");
            return (Criteria) this;
        }

        public Criteria andZlccGreaterThan(String value) {
            addCriterion("zlcc >", value, "zlcc");
            return (Criteria) this;
        }

        public Criteria andZlccGreaterThanOrEqualTo(String value) {
            addCriterion("zlcc >=", value, "zlcc");
            return (Criteria) this;
        }

        public Criteria andZlccLessThan(String value) {
            addCriterion("zlcc <", value, "zlcc");
            return (Criteria) this;
        }

        public Criteria andZlccLessThanOrEqualTo(String value) {
            addCriterion("zlcc <=", value, "zlcc");
            return (Criteria) this;
        }

        public Criteria andZlccLike(String value) {
            addCriterion("zlcc like", value, "zlcc");
            return (Criteria) this;
        }

        public Criteria andZlccNotLike(String value) {
            addCriterion("zlcc not like", value, "zlcc");
            return (Criteria) this;
        }

        public Criteria andZlccIn(List<String> values) {
            addCriterion("zlcc in", values, "zlcc");
            return (Criteria) this;
        }

        public Criteria andZlccNotIn(List<String> values) {
            addCriterion("zlcc not in", values, "zlcc");
            return (Criteria) this;
        }

        public Criteria andZlccBetween(String value1, String value2) {
            addCriterion("zlcc between", value1, value2, "zlcc");
            return (Criteria) this;
        }

        public Criteria andZlccNotBetween(String value1, String value2) {
            addCriterion("zlcc not between", value1, value2, "zlcc");
            return (Criteria) this;
        }

        public Criteria andZlccsmIsNull() {
            addCriterion("zlccsm is null");
            return (Criteria) this;
        }

        public Criteria andZlccsmIsNotNull() {
            addCriterion("zlccsm is not null");
            return (Criteria) this;
        }

        public Criteria andZlccsmEqualTo(String value) {
            addCriterion("zlccsm =", value, "zlccsm");
            return (Criteria) this;
        }

        public Criteria andZlccsmNotEqualTo(String value) {
            addCriterion("zlccsm <>", value, "zlccsm");
            return (Criteria) this;
        }

        public Criteria andZlccsmGreaterThan(String value) {
            addCriterion("zlccsm >", value, "zlccsm");
            return (Criteria) this;
        }

        public Criteria andZlccsmGreaterThanOrEqualTo(String value) {
            addCriterion("zlccsm >=", value, "zlccsm");
            return (Criteria) this;
        }

        public Criteria andZlccsmLessThan(String value) {
            addCriterion("zlccsm <", value, "zlccsm");
            return (Criteria) this;
        }

        public Criteria andZlccsmLessThanOrEqualTo(String value) {
            addCriterion("zlccsm <=", value, "zlccsm");
            return (Criteria) this;
        }

        public Criteria andZlccsmLike(String value) {
            addCriterion("zlccsm like", value, "zlccsm");
            return (Criteria) this;
        }

        public Criteria andZlccsmNotLike(String value) {
            addCriterion("zlccsm not like", value, "zlccsm");
            return (Criteria) this;
        }

        public Criteria andZlccsmIn(List<String> values) {
            addCriterion("zlccsm in", values, "zlccsm");
            return (Criteria) this;
        }

        public Criteria andZlccsmNotIn(List<String> values) {
            addCriterion("zlccsm not in", values, "zlccsm");
            return (Criteria) this;
        }

        public Criteria andZlccsmBetween(String value1, String value2) {
            addCriterion("zlccsm between", value1, value2, "zlccsm");
            return (Criteria) this;
        }

        public Criteria andZlccsmNotBetween(String value1, String value2) {
            addCriterion("zlccsm not between", value1, value2, "zlccsm");
            return (Criteria) this;
        }

        public Criteria andYpjybgIsNull() {
            addCriterion("ypjybg is null");
            return (Criteria) this;
        }

        public Criteria andYpjybgIsNotNull() {
            addCriterion("ypjybg is not null");
            return (Criteria) this;
        }

        public Criteria andYpjybgEqualTo(String value) {
            addCriterion("ypjybg =", value, "ypjybg");
            return (Criteria) this;
        }

        public Criteria andYpjybgNotEqualTo(String value) {
            addCriterion("ypjybg <>", value, "ypjybg");
            return (Criteria) this;
        }

        public Criteria andYpjybgGreaterThan(String value) {
            addCriterion("ypjybg >", value, "ypjybg");
            return (Criteria) this;
        }

        public Criteria andYpjybgGreaterThanOrEqualTo(String value) {
            addCriterion("ypjybg >=", value, "ypjybg");
            return (Criteria) this;
        }

        public Criteria andYpjybgLessThan(String value) {
            addCriterion("ypjybg <", value, "ypjybg");
            return (Criteria) this;
        }

        public Criteria andYpjybgLessThanOrEqualTo(String value) {
            addCriterion("ypjybg <=", value, "ypjybg");
            return (Criteria) this;
        }

        public Criteria andYpjybgLike(String value) {
            addCriterion("ypjybg like", value, "ypjybg");
            return (Criteria) this;
        }

        public Criteria andYpjybgNotLike(String value) {
            addCriterion("ypjybg not like", value, "ypjybg");
            return (Criteria) this;
        }

        public Criteria andYpjybgIn(List<String> values) {
            addCriterion("ypjybg in", values, "ypjybg");
            return (Criteria) this;
        }

        public Criteria andYpjybgNotIn(List<String> values) {
            addCriterion("ypjybg not in", values, "ypjybg");
            return (Criteria) this;
        }

        public Criteria andYpjybgBetween(String value1, String value2) {
            addCriterion("ypjybg between", value1, value2, "ypjybg");
            return (Criteria) this;
        }

        public Criteria andYpjybgNotBetween(String value1, String value2) {
            addCriterion("ypjybg not between", value1, value2, "ypjybg");
            return (Criteria) this;
        }

        public Criteria andYpjybgbmIsNull() {
            addCriterion("ypjybgbm is null");
            return (Criteria) this;
        }

        public Criteria andYpjybgbmIsNotNull() {
            addCriterion("ypjybgbm is not null");
            return (Criteria) this;
        }

        public Criteria andYpjybgbmEqualTo(String value) {
            addCriterion("ypjybgbm =", value, "ypjybgbm");
            return (Criteria) this;
        }

        public Criteria andYpjybgbmNotEqualTo(String value) {
            addCriterion("ypjybgbm <>", value, "ypjybgbm");
            return (Criteria) this;
        }

        public Criteria andYpjybgbmGreaterThan(String value) {
            addCriterion("ypjybgbm >", value, "ypjybgbm");
            return (Criteria) this;
        }

        public Criteria andYpjybgbmGreaterThanOrEqualTo(String value) {
            addCriterion("ypjybgbm >=", value, "ypjybgbm");
            return (Criteria) this;
        }

        public Criteria andYpjybgbmLessThan(String value) {
            addCriterion("ypjybgbm <", value, "ypjybgbm");
            return (Criteria) this;
        }

        public Criteria andYpjybgbmLessThanOrEqualTo(String value) {
            addCriterion("ypjybgbm <=", value, "ypjybgbm");
            return (Criteria) this;
        }

        public Criteria andYpjybgbmLike(String value) {
            addCriterion("ypjybgbm like", value, "ypjybgbm");
            return (Criteria) this;
        }

        public Criteria andYpjybgbmNotLike(String value) {
            addCriterion("ypjybgbm not like", value, "ypjybgbm");
            return (Criteria) this;
        }

        public Criteria andYpjybgbmIn(List<String> values) {
            addCriterion("ypjybgbm in", values, "ypjybgbm");
            return (Criteria) this;
        }

        public Criteria andYpjybgbmNotIn(List<String> values) {
            addCriterion("ypjybgbm not in", values, "ypjybgbm");
            return (Criteria) this;
        }

        public Criteria andYpjybgbmBetween(String value1, String value2) {
            addCriterion("ypjybgbm between", value1, value2, "ypjybgbm");
            return (Criteria) this;
        }

        public Criteria andYpjybgbmNotBetween(String value1, String value2) {
            addCriterion("ypjybgbm not between", value1, value2, "ypjybgbm");
            return (Criteria) this;
        }

        public Criteria andYpjybgyxqIsNull() {
            addCriterion("ypjybgyxq is null");
            return (Criteria) this;
        }

        public Criteria andYpjybgyxqIsNotNull() {
            addCriterion("ypjybgyxq is not null");
            return (Criteria) this;
        }

        public Criteria andYpjybgyxqEqualTo(Date value) {
            addCriterionForJDBCDate("ypjybgyxq =", value, "ypjybgyxq");
            return (Criteria) this;
        }

        public Criteria andYpjybgyxqNotEqualTo(Date value) {
            addCriterionForJDBCDate("ypjybgyxq <>", value, "ypjybgyxq");
            return (Criteria) this;
        }

        public Criteria andYpjybgyxqGreaterThan(Date value) {
            addCriterionForJDBCDate("ypjybgyxq >", value, "ypjybgyxq");
            return (Criteria) this;
        }

        public Criteria andYpjybgyxqGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ypjybgyxq >=", value, "ypjybgyxq");
            return (Criteria) this;
        }

        public Criteria andYpjybgyxqLessThan(Date value) {
            addCriterionForJDBCDate("ypjybgyxq <", value, "ypjybgyxq");
            return (Criteria) this;
        }

        public Criteria andYpjybgyxqLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ypjybgyxq <=", value, "ypjybgyxq");
            return (Criteria) this;
        }

        public Criteria andYpjybgyxqIn(List<Date> values) {
            addCriterionForJDBCDate("ypjybgyxq in", values, "ypjybgyxq");
            return (Criteria) this;
        }

        public Criteria andYpjybgyxqNotIn(List<Date> values) {
            addCriterionForJDBCDate("ypjybgyxq not in", values, "ypjybgyxq");
            return (Criteria) this;
        }

        public Criteria andYpjybgyxqBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ypjybgyxq between", value1, value2, "ypjybgyxq");
            return (Criteria) this;
        }

        public Criteria andYpjybgyxqNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ypjybgyxq not between", value1, value2, "ypjybgyxq");
            return (Criteria) this;
        }

        public Criteria andJyztIsNull() {
            addCriterion("jyzt is null");
            return (Criteria) this;
        }

        public Criteria andJyztIsNotNull() {
            addCriterion("jyzt is not null");
            return (Criteria) this;
        }

        public Criteria andJyztEqualTo(String value) {
            addCriterion("jyzt =", value, "jyzt");
            return (Criteria) this;
        }

        public Criteria andJyztNotEqualTo(String value) {
            addCriterion("jyzt <>", value, "jyzt");
            return (Criteria) this;
        }

        public Criteria andJyztGreaterThan(String value) {
            addCriterion("jyzt >", value, "jyzt");
            return (Criteria) this;
        }

        public Criteria andJyztGreaterThanOrEqualTo(String value) {
            addCriterion("jyzt >=", value, "jyzt");
            return (Criteria) this;
        }

        public Criteria andJyztLessThan(String value) {
            addCriterion("jyzt <", value, "jyzt");
            return (Criteria) this;
        }

        public Criteria andJyztLessThanOrEqualTo(String value) {
            addCriterion("jyzt <=", value, "jyzt");
            return (Criteria) this;
        }

        public Criteria andJyztLike(String value) {
            addCriterion("jyzt like", value, "jyzt");
            return (Criteria) this;
        }

        public Criteria andJyztNotLike(String value) {
            addCriterion("jyzt not like", value, "jyzt");
            return (Criteria) this;
        }

        public Criteria andJyztIn(List<String> values) {
            addCriterion("jyzt in", values, "jyzt");
            return (Criteria) this;
        }

        public Criteria andJyztNotIn(List<String> values) {
            addCriterion("jyzt not in", values, "jyzt");
            return (Criteria) this;
        }

        public Criteria andJyztBetween(String value1, String value2) {
            addCriterion("jyzt between", value1, value2, "jyzt");
            return (Criteria) this;
        }

        public Criteria andJyztNotBetween(String value1, String value2) {
            addCriterion("jyzt not between", value1, value2, "jyzt");
            return (Criteria) this;
        }

        public Criteria andVchar1IsNull() {
            addCriterion("vchar1 is null");
            return (Criteria) this;
        }

        public Criteria andVchar1IsNotNull() {
            addCriterion("vchar1 is not null");
            return (Criteria) this;
        }

        public Criteria andVchar1EqualTo(String value) {
            addCriterion("vchar1 =", value, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar1NotEqualTo(String value) {
            addCriterion("vchar1 <>", value, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar1GreaterThan(String value) {
            addCriterion("vchar1 >", value, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar1GreaterThanOrEqualTo(String value) {
            addCriterion("vchar1 >=", value, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar1LessThan(String value) {
            addCriterion("vchar1 <", value, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar1LessThanOrEqualTo(String value) {
            addCriterion("vchar1 <=", value, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar1Like(String value) {
            addCriterion("vchar1 like", value, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar1NotLike(String value) {
            addCriterion("vchar1 not like", value, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar1In(List<String> values) {
            addCriterion("vchar1 in", values, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar1NotIn(List<String> values) {
            addCriterion("vchar1 not in", values, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar1Between(String value1, String value2) {
            addCriterion("vchar1 between", value1, value2, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar1NotBetween(String value1, String value2) {
            addCriterion("vchar1 not between", value1, value2, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar2IsNull() {
            addCriterion("vchar2 is null");
            return (Criteria) this;
        }

        public Criteria andVchar2IsNotNull() {
            addCriterion("vchar2 is not null");
            return (Criteria) this;
        }

        public Criteria andVchar2EqualTo(String value) {
            addCriterion("vchar2 =", value, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar2NotEqualTo(String value) {
            addCriterion("vchar2 <>", value, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar2GreaterThan(String value) {
            addCriterion("vchar2 >", value, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar2GreaterThanOrEqualTo(String value) {
            addCriterion("vchar2 >=", value, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar2LessThan(String value) {
            addCriterion("vchar2 <", value, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar2LessThanOrEqualTo(String value) {
            addCriterion("vchar2 <=", value, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar2Like(String value) {
            addCriterion("vchar2 like", value, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar2NotLike(String value) {
            addCriterion("vchar2 not like", value, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar2In(List<String> values) {
            addCriterion("vchar2 in", values, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar2NotIn(List<String> values) {
            addCriterion("vchar2 not in", values, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar2Between(String value1, String value2) {
            addCriterion("vchar2 between", value1, value2, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar2NotBetween(String value1, String value2) {
            addCriterion("vchar2 not between", value1, value2, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar3IsNull() {
            addCriterion("vchar3 is null");
            return (Criteria) this;
        }

        public Criteria andVchar3IsNotNull() {
            addCriterion("vchar3 is not null");
            return (Criteria) this;
        }

        public Criteria andVchar3EqualTo(String value) {
            addCriterion("vchar3 =", value, "vchar3");
            return (Criteria) this;
        }

        public Criteria andVchar3NotEqualTo(String value) {
            addCriterion("vchar3 <>", value, "vchar3");
            return (Criteria) this;
        }

        public Criteria andVchar3GreaterThan(String value) {
            addCriterion("vchar3 >", value, "vchar3");
            return (Criteria) this;
        }

        public Criteria andVchar3GreaterThanOrEqualTo(String value) {
            addCriterion("vchar3 >=", value, "vchar3");
            return (Criteria) this;
        }

        public Criteria andVchar3LessThan(String value) {
            addCriterion("vchar3 <", value, "vchar3");
            return (Criteria) this;
        }

        public Criteria andVchar3LessThanOrEqualTo(String value) {
            addCriterion("vchar3 <=", value, "vchar3");
            return (Criteria) this;
        }

        public Criteria andVchar3Like(String value) {
            addCriterion("vchar3 like", value, "vchar3");
            return (Criteria) this;
        }

        public Criteria andVchar3NotLike(String value) {
            addCriterion("vchar3 not like", value, "vchar3");
            return (Criteria) this;
        }

        public Criteria andVchar3In(List<String> values) {
            addCriterion("vchar3 in", values, "vchar3");
            return (Criteria) this;
        }

        public Criteria andVchar3NotIn(List<String> values) {
            addCriterion("vchar3 not in", values, "vchar3");
            return (Criteria) this;
        }

        public Criteria andVchar3Between(String value1, String value2) {
            addCriterion("vchar3 between", value1, value2, "vchar3");
            return (Criteria) this;
        }

        public Criteria andVchar3NotBetween(String value1, String value2) {
            addCriterion("vchar3 not between", value1, value2, "vchar3");
            return (Criteria) this;
        }

        public Criteria andDwIsNull() {
            addCriterion("dw is null");
            return (Criteria) this;
        }

        public Criteria andDwIsNotNull() {
            addCriterion("dw is not null");
            return (Criteria) this;
        }

        public Criteria andDwEqualTo(String value) {
            addCriterion("dw =", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwNotEqualTo(String value) {
            addCriterion("dw <>", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwGreaterThan(String value) {
            addCriterion("dw >", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwGreaterThanOrEqualTo(String value) {
            addCriterion("dw >=", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwLessThan(String value) {
            addCriterion("dw <", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwLessThanOrEqualTo(String value) {
            addCriterion("dw <=", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwLike(String value) {
            addCriterion("dw like", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwNotLike(String value) {
            addCriterion("dw not like", value, "dw");
            return (Criteria) this;
        }

        public Criteria andDwIn(List<String> values) {
            addCriterion("dw in", values, "dw");
            return (Criteria) this;
        }

        public Criteria andDwNotIn(List<String> values) {
            addCriterion("dw not in", values, "dw");
            return (Criteria) this;
        }

        public Criteria andDwBetween(String value1, String value2) {
            addCriterion("dw between", value1, value2, "dw");
            return (Criteria) this;
        }

        public Criteria andDwNotBetween(String value1, String value2) {
            addCriterion("dw not between", value1, value2, "dw");
            return (Criteria) this;
        }

        public Criteria andMcIsNull() {
            addCriterion("mc is null");
            return (Criteria) this;
        }

        public Criteria andMcIsNotNull() {
            addCriterion("mc is not null");
            return (Criteria) this;
        }

        public Criteria andMcEqualTo(String value) {
            addCriterion("mc =", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotEqualTo(String value) {
            addCriterion("mc <>", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcGreaterThan(String value) {
            addCriterion("mc >", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcGreaterThanOrEqualTo(String value) {
            addCriterion("mc >=", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcLessThan(String value) {
            addCriterion("mc <", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcLessThanOrEqualTo(String value) {
            addCriterion("mc <=", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcLike(String value) {
            addCriterion("mc like", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotLike(String value) {
            addCriterion("mc not like", value, "mc");
            return (Criteria) this;
        }

        public Criteria andMcIn(List<String> values) {
            addCriterion("mc in", values, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotIn(List<String> values) {
            addCriterion("mc not in", values, "mc");
            return (Criteria) this;
        }

        public Criteria andMcBetween(String value1, String value2) {
            addCriterion("mc between", value1, value2, "mc");
            return (Criteria) this;
        }

        public Criteria andMcNotBetween(String value1, String value2) {
            addCriterion("mc not between", value1, value2, "mc");
            return (Criteria) this;
        }

        public Criteria andJxIsNull() {
            addCriterion("jx is null");
            return (Criteria) this;
        }

        public Criteria andJxIsNotNull() {
            addCriterion("jx is not null");
            return (Criteria) this;
        }

        public Criteria andJxEqualTo(String value) {
            addCriterion("jx =", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxNotEqualTo(String value) {
            addCriterion("jx <>", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxGreaterThan(String value) {
            addCriterion("jx >", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxGreaterThanOrEqualTo(String value) {
            addCriterion("jx >=", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxLessThan(String value) {
            addCriterion("jx <", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxLessThanOrEqualTo(String value) {
            addCriterion("jx <=", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxLike(String value) {
            addCriterion("jx like", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxNotLike(String value) {
            addCriterion("jx not like", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxIn(List<String> values) {
            addCriterion("jx in", values, "jx");
            return (Criteria) this;
        }

        public Criteria andJxNotIn(List<String> values) {
            addCriterion("jx not in", values, "jx");
            return (Criteria) this;
        }

        public Criteria andJxBetween(String value1, String value2) {
            addCriterion("jx between", value1, value2, "jx");
            return (Criteria) this;
        }

        public Criteria andJxNotBetween(String value1, String value2) {
            addCriterion("jx not between", value1, value2, "jx");
            return (Criteria) this;
        }

        public Criteria andGgIsNull() {
            addCriterion("gg is null");
            return (Criteria) this;
        }

        public Criteria andGgIsNotNull() {
            addCriterion("gg is not null");
            return (Criteria) this;
        }

        public Criteria andGgEqualTo(String value) {
            addCriterion("gg =", value, "gg");
            return (Criteria) this;
        }

        public Criteria andGgNotEqualTo(String value) {
            addCriterion("gg <>", value, "gg");
            return (Criteria) this;
        }

        public Criteria andGgGreaterThan(String value) {
            addCriterion("gg >", value, "gg");
            return (Criteria) this;
        }

        public Criteria andGgGreaterThanOrEqualTo(String value) {
            addCriterion("gg >=", value, "gg");
            return (Criteria) this;
        }

        public Criteria andGgLessThan(String value) {
            addCriterion("gg <", value, "gg");
            return (Criteria) this;
        }

        public Criteria andGgLessThanOrEqualTo(String value) {
            addCriterion("gg <=", value, "gg");
            return (Criteria) this;
        }

        public Criteria andGgLike(String value) {
            addCriterion("gg like", value, "gg");
            return (Criteria) this;
        }

        public Criteria andGgNotLike(String value) {
            addCriterion("gg not like", value, "gg");
            return (Criteria) this;
        }

        public Criteria andGgIn(List<String> values) {
            addCriterion("gg in", values, "gg");
            return (Criteria) this;
        }

        public Criteria andGgNotIn(List<String> values) {
            addCriterion("gg not in", values, "gg");
            return (Criteria) this;
        }

        public Criteria andGgBetween(String value1, String value2) {
            addCriterion("gg between", value1, value2, "gg");
            return (Criteria) this;
        }

        public Criteria andGgNotBetween(String value1, String value2) {
            addCriterion("gg not between", value1, value2, "gg");
            return (Criteria) this;
        }

        public Criteria andZhxsIsNull() {
            addCriterion("zhxs is null");
            return (Criteria) this;
        }

        public Criteria andZhxsIsNotNull() {
            addCriterion("zhxs is not null");
            return (Criteria) this;
        }

        public Criteria andZhxsEqualTo(String value) {
            addCriterion("zhxs =", value, "zhxs");
            return (Criteria) this;
        }

        public Criteria andZhxsNotEqualTo(String value) {
            addCriterion("zhxs <>", value, "zhxs");
            return (Criteria) this;
        }

        public Criteria andZhxsGreaterThan(String value) {
            addCriterion("zhxs >", value, "zhxs");
            return (Criteria) this;
        }

        public Criteria andZhxsGreaterThanOrEqualTo(String value) {
            addCriterion("zhxs >=", value, "zhxs");
            return (Criteria) this;
        }

        public Criteria andZhxsLessThan(String value) {
            addCriterion("zhxs <", value, "zhxs");
            return (Criteria) this;
        }

        public Criteria andZhxsLessThanOrEqualTo(String value) {
            addCriterion("zhxs <=", value, "zhxs");
            return (Criteria) this;
        }

        public Criteria andZhxsLike(String value) {
            addCriterion("zhxs like", value, "zhxs");
            return (Criteria) this;
        }

        public Criteria andZhxsNotLike(String value) {
            addCriterion("zhxs not like", value, "zhxs");
            return (Criteria) this;
        }

        public Criteria andZhxsIn(List<String> values) {
            addCriterion("zhxs in", values, "zhxs");
            return (Criteria) this;
        }

        public Criteria andZhxsNotIn(List<String> values) {
            addCriterion("zhxs not in", values, "zhxs");
            return (Criteria) this;
        }

        public Criteria andZhxsBetween(String value1, String value2) {
            addCriterion("zhxs between", value1, value2, "zhxs");
            return (Criteria) this;
        }

        public Criteria andZhxsNotBetween(String value1, String value2) {
            addCriterion("zhxs not between", value1, value2, "zhxs");
            return (Criteria) this;
        }

        public Criteria andPinyinIsNull() {
            addCriterion("pinyin is null");
            return (Criteria) this;
        }

        public Criteria andPinyinIsNotNull() {
            addCriterion("pinyin is not null");
            return (Criteria) this;
        }

        public Criteria andPinyinEqualTo(String value) {
            addCriterion("pinyin =", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotEqualTo(String value) {
            addCriterion("pinyin <>", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinGreaterThan(String value) {
            addCriterion("pinyin >", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinGreaterThanOrEqualTo(String value) {
            addCriterion("pinyin >=", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLessThan(String value) {
            addCriterion("pinyin <", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLessThanOrEqualTo(String value) {
            addCriterion("pinyin <=", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLike(String value) {
            addCriterion("pinyin like", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotLike(String value) {
            addCriterion("pinyin not like", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinIn(List<String> values) {
            addCriterion("pinyin in", values, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotIn(List<String> values) {
            addCriterion("pinyin not in", values, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinBetween(String value1, String value2) {
            addCriterion("pinyin between", value1, value2, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotBetween(String value1, String value2) {
            addCriterion("pinyin not between", value1, value2, "pinyin");
            return (Criteria) this;
        }

        public Criteria andLbIsNull() {
            addCriterion("lb is null");
            return (Criteria) this;
        }

        public Criteria andLbIsNotNull() {
            addCriterion("lb is not null");
            return (Criteria) this;
        }

        public Criteria andLbEqualTo(String value) {
            addCriterion("lb =", value, "lb");
            return (Criteria) this;
        }

        public Criteria andLbNotEqualTo(String value) {
            addCriterion("lb <>", value, "lb");
            return (Criteria) this;
        }

        public Criteria andLbGreaterThan(String value) {
            addCriterion("lb >", value, "lb");
            return (Criteria) this;
        }

        public Criteria andLbGreaterThanOrEqualTo(String value) {
            addCriterion("lb >=", value, "lb");
            return (Criteria) this;
        }

        public Criteria andLbLessThan(String value) {
            addCriterion("lb <", value, "lb");
            return (Criteria) this;
        }

        public Criteria andLbLessThanOrEqualTo(String value) {
            addCriterion("lb <=", value, "lb");
            return (Criteria) this;
        }

        public Criteria andLbLike(String value) {
            addCriterion("lb like", value, "lb");
            return (Criteria) this;
        }

        public Criteria andLbNotLike(String value) {
            addCriterion("lb not like", value, "lb");
            return (Criteria) this;
        }

        public Criteria andLbIn(List<String> values) {
            addCriterion("lb in", values, "lb");
            return (Criteria) this;
        }

        public Criteria andLbNotIn(List<String> values) {
            addCriterion("lb not in", values, "lb");
            return (Criteria) this;
        }

        public Criteria andLbBetween(String value1, String value2) {
            addCriterion("lb between", value1, value2, "lb");
            return (Criteria) this;
        }

        public Criteria andLbNotBetween(String value1, String value2) {
            addCriterion("lb not between", value1, value2, "lb");
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