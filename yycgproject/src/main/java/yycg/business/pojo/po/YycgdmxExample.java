package yycg.business.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class YycgdmxExample extends BusinessBasePo {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YycgdmxExample() {
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

        public Criteria andYycgdidIsNull() {
            addCriterion("yycgdid is null");
            return (Criteria) this;
        }

        public Criteria andYycgdidIsNotNull() {
            addCriterion("yycgdid is not null");
            return (Criteria) this;
        }

        public Criteria andYycgdidEqualTo(String value) {
            addCriterion("yycgdid =", value, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYycgdidNotEqualTo(String value) {
            addCriterion("yycgdid <>", value, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYycgdidGreaterThan(String value) {
            addCriterion("yycgdid >", value, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYycgdidGreaterThanOrEqualTo(String value) {
            addCriterion("yycgdid >=", value, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYycgdidLessThan(String value) {
            addCriterion("yycgdid <", value, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYycgdidLessThanOrEqualTo(String value) {
            addCriterion("yycgdid <=", value, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYycgdidLike(String value) {
            addCriterion("yycgdid like", value, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYycgdidNotLike(String value) {
            addCriterion("yycgdid not like", value, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYycgdidIn(List<String> values) {
            addCriterion("yycgdid in", values, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYycgdidNotIn(List<String> values) {
            addCriterion("yycgdid not in", values, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYycgdidBetween(String value1, String value2) {
            addCriterion("yycgdid between", value1, value2, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYycgdidNotBetween(String value1, String value2) {
            addCriterion("yycgdid not between", value1, value2, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYpxxidIsNull() {
            addCriterion("ypxxid is null");
            return (Criteria) this;
        }

        public Criteria andYpxxidIsNotNull() {
            addCriterion("ypxxid is not null");
            return (Criteria) this;
        }

        public Criteria andYpxxidEqualTo(String value) {
            addCriterion("ypxxid =", value, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andYpxxidNotEqualTo(String value) {
            addCriterion("ypxxid <>", value, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andYpxxidGreaterThan(String value) {
            addCriterion("ypxxid >", value, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andYpxxidGreaterThanOrEqualTo(String value) {
            addCriterion("ypxxid >=", value, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andYpxxidLessThan(String value) {
            addCriterion("ypxxid <", value, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andYpxxidLessThanOrEqualTo(String value) {
            addCriterion("ypxxid <=", value, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andYpxxidLike(String value) {
            addCriterion("ypxxid like", value, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andYpxxidNotLike(String value) {
            addCriterion("ypxxid not like", value, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andYpxxidIn(List<String> values) {
            addCriterion("ypxxid in", values, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andYpxxidNotIn(List<String> values) {
            addCriterion("ypxxid not in", values, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andYpxxidBetween(String value1, String value2) {
            addCriterion("ypxxid between", value1, value2, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andYpxxidNotBetween(String value1, String value2) {
            addCriterion("ypxxid not between", value1, value2, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andUsergysidIsNull() {
            addCriterion("usergysid is null");
            return (Criteria) this;
        }

        public Criteria andUsergysidIsNotNull() {
            addCriterion("usergysid is not null");
            return (Criteria) this;
        }

        public Criteria andUsergysidEqualTo(String value) {
            addCriterion("usergysid =", value, "usergysid");
            return (Criteria) this;
        }

        public Criteria andUsergysidNotEqualTo(String value) {
            addCriterion("usergysid <>", value, "usergysid");
            return (Criteria) this;
        }

        public Criteria andUsergysidGreaterThan(String value) {
            addCriterion("usergysid >", value, "usergysid");
            return (Criteria) this;
        }

        public Criteria andUsergysidGreaterThanOrEqualTo(String value) {
            addCriterion("usergysid >=", value, "usergysid");
            return (Criteria) this;
        }

        public Criteria andUsergysidLessThan(String value) {
            addCriterion("usergysid <", value, "usergysid");
            return (Criteria) this;
        }

        public Criteria andUsergysidLessThanOrEqualTo(String value) {
            addCriterion("usergysid <=", value, "usergysid");
            return (Criteria) this;
        }

        public Criteria andUsergysidLike(String value) {
            addCriterion("usergysid like", value, "usergysid");
            return (Criteria) this;
        }

        public Criteria andUsergysidNotLike(String value) {
            addCriterion("usergysid not like", value, "usergysid");
            return (Criteria) this;
        }

        public Criteria andUsergysidIn(List<String> values) {
            addCriterion("usergysid in", values, "usergysid");
            return (Criteria) this;
        }

        public Criteria andUsergysidNotIn(List<String> values) {
            addCriterion("usergysid not in", values, "usergysid");
            return (Criteria) this;
        }

        public Criteria andUsergysidBetween(String value1, String value2) {
            addCriterion("usergysid between", value1, value2, "usergysid");
            return (Criteria) this;
        }

        public Criteria andUsergysidNotBetween(String value1, String value2) {
            addCriterion("usergysid not between", value1, value2, "usergysid");
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

        public Criteria andJyjgIsNull() {
            addCriterion("jyjg is null");
            return (Criteria) this;
        }

        public Criteria andJyjgIsNotNull() {
            addCriterion("jyjg is not null");
            return (Criteria) this;
        }

        public Criteria andJyjgEqualTo(Float value) {
            addCriterion("jyjg =", value, "jyjg");
            return (Criteria) this;
        }

        public Criteria andJyjgNotEqualTo(Float value) {
            addCriterion("jyjg <>", value, "jyjg");
            return (Criteria) this;
        }

        public Criteria andJyjgGreaterThan(Float value) {
            addCriterion("jyjg >", value, "jyjg");
            return (Criteria) this;
        }

        public Criteria andJyjgGreaterThanOrEqualTo(Float value) {
            addCriterion("jyjg >=", value, "jyjg");
            return (Criteria) this;
        }

        public Criteria andJyjgLessThan(Float value) {
            addCriterion("jyjg <", value, "jyjg");
            return (Criteria) this;
        }

        public Criteria andJyjgLessThanOrEqualTo(Float value) {
            addCriterion("jyjg <=", value, "jyjg");
            return (Criteria) this;
        }

        public Criteria andJyjgIn(List<Float> values) {
            addCriterion("jyjg in", values, "jyjg");
            return (Criteria) this;
        }

        public Criteria andJyjgNotIn(List<Float> values) {
            addCriterion("jyjg not in", values, "jyjg");
            return (Criteria) this;
        }

        public Criteria andJyjgBetween(Float value1, Float value2) {
            addCriterion("jyjg between", value1, value2, "jyjg");
            return (Criteria) this;
        }

        public Criteria andJyjgNotBetween(Float value1, Float value2) {
            addCriterion("jyjg not between", value1, value2, "jyjg");
            return (Criteria) this;
        }

        public Criteria andCglIsNull() {
            addCriterion("cgl is null");
            return (Criteria) this;
        }

        public Criteria andCglIsNotNull() {
            addCriterion("cgl is not null");
            return (Criteria) this;
        }

        public Criteria andCglEqualTo(Integer value) {
            addCriterion("cgl =", value, "cgl");
            return (Criteria) this;
        }

        public Criteria andCglNotEqualTo(Integer value) {
            addCriterion("cgl <>", value, "cgl");
            return (Criteria) this;
        }

        public Criteria andCglGreaterThan(Integer value) {
            addCriterion("cgl >", value, "cgl");
            return (Criteria) this;
        }

        public Criteria andCglGreaterThanOrEqualTo(Integer value) {
            addCriterion("cgl >=", value, "cgl");
            return (Criteria) this;
        }

        public Criteria andCglLessThan(Integer value) {
            addCriterion("cgl <", value, "cgl");
            return (Criteria) this;
        }

        public Criteria andCglLessThanOrEqualTo(Integer value) {
            addCriterion("cgl <=", value, "cgl");
            return (Criteria) this;
        }

        public Criteria andCglIn(List<Integer> values) {
            addCriterion("cgl in", values, "cgl");
            return (Criteria) this;
        }

        public Criteria andCglNotIn(List<Integer> values) {
            addCriterion("cgl not in", values, "cgl");
            return (Criteria) this;
        }

        public Criteria andCglBetween(Integer value1, Integer value2) {
            addCriterion("cgl between", value1, value2, "cgl");
            return (Criteria) this;
        }

        public Criteria andCglNotBetween(Integer value1, Integer value2) {
            addCriterion("cgl not between", value1, value2, "cgl");
            return (Criteria) this;
        }

        public Criteria andCgjeIsNull() {
            addCriterion("cgje is null");
            return (Criteria) this;
        }

        public Criteria andCgjeIsNotNull() {
            addCriterion("cgje is not null");
            return (Criteria) this;
        }

        public Criteria andCgjeEqualTo(Float value) {
            addCriterion("cgje =", value, "cgje");
            return (Criteria) this;
        }

        public Criteria andCgjeNotEqualTo(Float value) {
            addCriterion("cgje <>", value, "cgje");
            return (Criteria) this;
        }

        public Criteria andCgjeGreaterThan(Float value) {
            addCriterion("cgje >", value, "cgje");
            return (Criteria) this;
        }

        public Criteria andCgjeGreaterThanOrEqualTo(Float value) {
            addCriterion("cgje >=", value, "cgje");
            return (Criteria) this;
        }

        public Criteria andCgjeLessThan(Float value) {
            addCriterion("cgje <", value, "cgje");
            return (Criteria) this;
        }

        public Criteria andCgjeLessThanOrEqualTo(Float value) {
            addCriterion("cgje <=", value, "cgje");
            return (Criteria) this;
        }

        public Criteria andCgjeIn(List<Float> values) {
            addCriterion("cgje in", values, "cgje");
            return (Criteria) this;
        }

        public Criteria andCgjeNotIn(List<Float> values) {
            addCriterion("cgje not in", values, "cgje");
            return (Criteria) this;
        }

        public Criteria andCgjeBetween(Float value1, Float value2) {
            addCriterion("cgje between", value1, value2, "cgje");
            return (Criteria) this;
        }

        public Criteria andCgjeNotBetween(Float value1, Float value2) {
            addCriterion("cgje not between", value1, value2, "cgje");
            return (Criteria) this;
        }

        public Criteria andCgztIsNull() {
            addCriterion("cgzt is null");
            return (Criteria) this;
        }

        public Criteria andCgztIsNotNull() {
            addCriterion("cgzt is not null");
            return (Criteria) this;
        }

        public Criteria andCgztEqualTo(String value) {
            addCriterion("cgzt =", value, "cgzt");
            return (Criteria) this;
        }

        public Criteria andCgztNotEqualTo(String value) {
            addCriterion("cgzt <>", value, "cgzt");
            return (Criteria) this;
        }

        public Criteria andCgztGreaterThan(String value) {
            addCriterion("cgzt >", value, "cgzt");
            return (Criteria) this;
        }

        public Criteria andCgztGreaterThanOrEqualTo(String value) {
            addCriterion("cgzt >=", value, "cgzt");
            return (Criteria) this;
        }

        public Criteria andCgztLessThan(String value) {
            addCriterion("cgzt <", value, "cgzt");
            return (Criteria) this;
        }

        public Criteria andCgztLessThanOrEqualTo(String value) {
            addCriterion("cgzt <=", value, "cgzt");
            return (Criteria) this;
        }

        public Criteria andCgztLike(String value) {
            addCriterion("cgzt like", value, "cgzt");
            return (Criteria) this;
        }

        public Criteria andCgztNotLike(String value) {
            addCriterion("cgzt not like", value, "cgzt");
            return (Criteria) this;
        }

        public Criteria andCgztIn(List<String> values) {
            addCriterion("cgzt in", values, "cgzt");
            return (Criteria) this;
        }

        public Criteria andCgztNotIn(List<String> values) {
            addCriterion("cgzt not in", values, "cgzt");
            return (Criteria) this;
        }

        public Criteria andCgztBetween(String value1, String value2) {
            addCriterion("cgzt between", value1, value2, "cgzt");
            return (Criteria) this;
        }

        public Criteria andCgztNotBetween(String value1, String value2) {
            addCriterion("cgzt not between", value1, value2, "cgzt");
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

        public Criteria andVchar4IsNull() {
            addCriterion("vchar4 is null");
            return (Criteria) this;
        }

        public Criteria andVchar4IsNotNull() {
            addCriterion("vchar4 is not null");
            return (Criteria) this;
        }

        public Criteria andVchar4EqualTo(String value) {
            addCriterion("vchar4 =", value, "vchar4");
            return (Criteria) this;
        }

        public Criteria andVchar4NotEqualTo(String value) {
            addCriterion("vchar4 <>", value, "vchar4");
            return (Criteria) this;
        }

        public Criteria andVchar4GreaterThan(String value) {
            addCriterion("vchar4 >", value, "vchar4");
            return (Criteria) this;
        }

        public Criteria andVchar4GreaterThanOrEqualTo(String value) {
            addCriterion("vchar4 >=", value, "vchar4");
            return (Criteria) this;
        }

        public Criteria andVchar4LessThan(String value) {
            addCriterion("vchar4 <", value, "vchar4");
            return (Criteria) this;
        }

        public Criteria andVchar4LessThanOrEqualTo(String value) {
            addCriterion("vchar4 <=", value, "vchar4");
            return (Criteria) this;
        }

        public Criteria andVchar4Like(String value) {
            addCriterion("vchar4 like", value, "vchar4");
            return (Criteria) this;
        }

        public Criteria andVchar4NotLike(String value) {
            addCriterion("vchar4 not like", value, "vchar4");
            return (Criteria) this;
        }

        public Criteria andVchar4In(List<String> values) {
            addCriterion("vchar4 in", values, "vchar4");
            return (Criteria) this;
        }

        public Criteria andVchar4NotIn(List<String> values) {
            addCriterion("vchar4 not in", values, "vchar4");
            return (Criteria) this;
        }

        public Criteria andVchar4Between(String value1, String value2) {
            addCriterion("vchar4 between", value1, value2, "vchar4");
            return (Criteria) this;
        }

        public Criteria andVchar4NotBetween(String value1, String value2) {
            addCriterion("vchar4 not between", value1, value2, "vchar4");
            return (Criteria) this;
        }

        public Criteria andVchar5IsNull() {
            addCriterion("vchar5 is null");
            return (Criteria) this;
        }

        public Criteria andVchar5IsNotNull() {
            addCriterion("vchar5 is not null");
            return (Criteria) this;
        }

        public Criteria andVchar5EqualTo(String value) {
            addCriterion("vchar5 =", value, "vchar5");
            return (Criteria) this;
        }

        public Criteria andVchar5NotEqualTo(String value) {
            addCriterion("vchar5 <>", value, "vchar5");
            return (Criteria) this;
        }

        public Criteria andVchar5GreaterThan(String value) {
            addCriterion("vchar5 >", value, "vchar5");
            return (Criteria) this;
        }

        public Criteria andVchar5GreaterThanOrEqualTo(String value) {
            addCriterion("vchar5 >=", value, "vchar5");
            return (Criteria) this;
        }

        public Criteria andVchar5LessThan(String value) {
            addCriterion("vchar5 <", value, "vchar5");
            return (Criteria) this;
        }

        public Criteria andVchar5LessThanOrEqualTo(String value) {
            addCriterion("vchar5 <=", value, "vchar5");
            return (Criteria) this;
        }

        public Criteria andVchar5Like(String value) {
            addCriterion("vchar5 like", value, "vchar5");
            return (Criteria) this;
        }

        public Criteria andVchar5NotLike(String value) {
            addCriterion("vchar5 not like", value, "vchar5");
            return (Criteria) this;
        }

        public Criteria andVchar5In(List<String> values) {
            addCriterion("vchar5 in", values, "vchar5");
            return (Criteria) this;
        }

        public Criteria andVchar5NotIn(List<String> values) {
            addCriterion("vchar5 not in", values, "vchar5");
            return (Criteria) this;
        }

        public Criteria andVchar5Between(String value1, String value2) {
            addCriterion("vchar5 between", value1, value2, "vchar5");
            return (Criteria) this;
        }

        public Criteria andVchar5NotBetween(String value1, String value2) {
            addCriterion("vchar5 not between", value1, value2, "vchar5");
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