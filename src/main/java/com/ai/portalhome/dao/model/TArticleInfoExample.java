package com.ai.portalhome.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TArticleInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TArticleInfoExample() {
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

        public Criteria andArtIdIsNull() {
            addCriterion("art_id is null");
            return (Criteria) this;
        }

        public Criteria andArtIdIsNotNull() {
            addCriterion("art_id is not null");
            return (Criteria) this;
        }

        public Criteria andArtIdEqualTo(Integer value) {
            addCriterion("art_id =", value, "artId");
            return (Criteria) this;
        }

        public Criteria andArtIdNotEqualTo(Integer value) {
            addCriterion("art_id <>", value, "artId");
            return (Criteria) this;
        }

        public Criteria andArtIdGreaterThan(Integer value) {
            addCriterion("art_id >", value, "artId");
            return (Criteria) this;
        }

        public Criteria andArtIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("art_id >=", value, "artId");
            return (Criteria) this;
        }

        public Criteria andArtIdLessThan(Integer value) {
            addCriterion("art_id <", value, "artId");
            return (Criteria) this;
        }

        public Criteria andArtIdLessThanOrEqualTo(Integer value) {
            addCriterion("art_id <=", value, "artId");
            return (Criteria) this;
        }

        public Criteria andArtIdIn(List<Integer> values) {
            addCriterion("art_id in", values, "artId");
            return (Criteria) this;
        }

        public Criteria andArtIdNotIn(List<Integer> values) {
            addCriterion("art_id not in", values, "artId");
            return (Criteria) this;
        }

        public Criteria andArtIdBetween(Integer value1, Integer value2) {
            addCriterion("art_id between", value1, value2, "artId");
            return (Criteria) this;
        }

        public Criteria andArtIdNotBetween(Integer value1, Integer value2) {
            addCriterion("art_id not between", value1, value2, "artId");
            return (Criteria) this;
        }

        public Criteria andArtNameIsNull() {
            addCriterion("art_name is null");
            return (Criteria) this;
        }

        public Criteria andArtNameIsNotNull() {
            addCriterion("art_name is not null");
            return (Criteria) this;
        }

        public Criteria andArtNameEqualTo(String value) {
            addCriterion("art_name =", value, "artName");
            return (Criteria) this;
        }

        public Criteria andArtNameNotEqualTo(String value) {
            addCriterion("art_name <>", value, "artName");
            return (Criteria) this;
        }

        public Criteria andArtNameGreaterThan(String value) {
            addCriterion("art_name >", value, "artName");
            return (Criteria) this;
        }

        public Criteria andArtNameGreaterThanOrEqualTo(String value) {
            addCriterion("art_name >=", value, "artName");
            return (Criteria) this;
        }

        public Criteria andArtNameLessThan(String value) {
            addCriterion("art_name <", value, "artName");
            return (Criteria) this;
        }

        public Criteria andArtNameLessThanOrEqualTo(String value) {
            addCriterion("art_name <=", value, "artName");
            return (Criteria) this;
        }

        public Criteria andArtNameLike(String value) {
            addCriterion("art_name like", value, "artName");
            return (Criteria) this;
        }

        public Criteria andArtNameNotLike(String value) {
            addCriterion("art_name not like", value, "artName");
            return (Criteria) this;
        }

        public Criteria andArtNameIn(List<String> values) {
            addCriterion("art_name in", values, "artName");
            return (Criteria) this;
        }

        public Criteria andArtNameNotIn(List<String> values) {
            addCriterion("art_name not in", values, "artName");
            return (Criteria) this;
        }

        public Criteria andArtNameBetween(String value1, String value2) {
            addCriterion("art_name between", value1, value2, "artName");
            return (Criteria) this;
        }

        public Criteria andArtNameNotBetween(String value1, String value2) {
            addCriterion("art_name not between", value1, value2, "artName");
            return (Criteria) this;
        }

        public Criteria andArtDescIsNull() {
            addCriterion("art_desc is null");
            return (Criteria) this;
        }

        public Criteria andArtDescIsNotNull() {
            addCriterion("art_desc is not null");
            return (Criteria) this;
        }

        public Criteria andArtDescEqualTo(String value) {
            addCriterion("art_desc =", value, "artDesc");
            return (Criteria) this;
        }

        public Criteria andArtDescNotEqualTo(String value) {
            addCriterion("art_desc <>", value, "artDesc");
            return (Criteria) this;
        }

        public Criteria andArtDescGreaterThan(String value) {
            addCriterion("art_desc >", value, "artDesc");
            return (Criteria) this;
        }

        public Criteria andArtDescGreaterThanOrEqualTo(String value) {
            addCriterion("art_desc >=", value, "artDesc");
            return (Criteria) this;
        }

        public Criteria andArtDescLessThan(String value) {
            addCriterion("art_desc <", value, "artDesc");
            return (Criteria) this;
        }

        public Criteria andArtDescLessThanOrEqualTo(String value) {
            addCriterion("art_desc <=", value, "artDesc");
            return (Criteria) this;
        }

        public Criteria andArtDescLike(String value) {
            addCriterion("art_desc like", value, "artDesc");
            return (Criteria) this;
        }

        public Criteria andArtDescNotLike(String value) {
            addCriterion("art_desc not like", value, "artDesc");
            return (Criteria) this;
        }

        public Criteria andArtDescIn(List<String> values) {
            addCriterion("art_desc in", values, "artDesc");
            return (Criteria) this;
        }

        public Criteria andArtDescNotIn(List<String> values) {
            addCriterion("art_desc not in", values, "artDesc");
            return (Criteria) this;
        }

        public Criteria andArtDescBetween(String value1, String value2) {
            addCriterion("art_desc between", value1, value2, "artDesc");
            return (Criteria) this;
        }

        public Criteria andArtDescNotBetween(String value1, String value2) {
            addCriterion("art_desc not between", value1, value2, "artDesc");
            return (Criteria) this;
        }

        public Criteria andArtUrlIsNull() {
            addCriterion("art_url is null");
            return (Criteria) this;
        }

        public Criteria andArtUrlIsNotNull() {
            addCriterion("art_url is not null");
            return (Criteria) this;
        }

        public Criteria andArtUrlEqualTo(String value) {
            addCriterion("art_url =", value, "artUrl");
            return (Criteria) this;
        }

        public Criteria andArtUrlNotEqualTo(String value) {
            addCriterion("art_url <>", value, "artUrl");
            return (Criteria) this;
        }

        public Criteria andArtUrlGreaterThan(String value) {
            addCriterion("art_url >", value, "artUrl");
            return (Criteria) this;
        }

        public Criteria andArtUrlGreaterThanOrEqualTo(String value) {
            addCriterion("art_url >=", value, "artUrl");
            return (Criteria) this;
        }

        public Criteria andArtUrlLessThan(String value) {
            addCriterion("art_url <", value, "artUrl");
            return (Criteria) this;
        }

        public Criteria andArtUrlLessThanOrEqualTo(String value) {
            addCriterion("art_url <=", value, "artUrl");
            return (Criteria) this;
        }

        public Criteria andArtUrlLike(String value) {
            addCriterion("art_url like", value, "artUrl");
            return (Criteria) this;
        }

        public Criteria andArtUrlNotLike(String value) {
            addCriterion("art_url not like", value, "artUrl");
            return (Criteria) this;
        }

        public Criteria andArtUrlIn(List<String> values) {
            addCriterion("art_url in", values, "artUrl");
            return (Criteria) this;
        }

        public Criteria andArtUrlNotIn(List<String> values) {
            addCriterion("art_url not in", values, "artUrl");
            return (Criteria) this;
        }

        public Criteria andArtUrlBetween(String value1, String value2) {
            addCriterion("art_url between", value1, value2, "artUrl");
            return (Criteria) this;
        }

        public Criteria andArtUrlNotBetween(String value1, String value2) {
            addCriterion("art_url not between", value1, value2, "artUrl");
            return (Criteria) this;
        }

        public Criteria andArtClassIsNull() {
            addCriterion("art_class is null");
            return (Criteria) this;
        }

        public Criteria andArtClassIsNotNull() {
            addCriterion("art_class is not null");
            return (Criteria) this;
        }

        public Criteria andArtClassEqualTo(String value) {
            addCriterion("art_class =", value, "artClass");
            return (Criteria) this;
        }

        public Criteria andArtClassNotEqualTo(String value) {
            addCriterion("art_class <>", value, "artClass");
            return (Criteria) this;
        }

        public Criteria andArtClassGreaterThan(String value) {
            addCriterion("art_class >", value, "artClass");
            return (Criteria) this;
        }

        public Criteria andArtClassGreaterThanOrEqualTo(String value) {
            addCriterion("art_class >=", value, "artClass");
            return (Criteria) this;
        }

        public Criteria andArtClassLessThan(String value) {
            addCriterion("art_class <", value, "artClass");
            return (Criteria) this;
        }

        public Criteria andArtClassLessThanOrEqualTo(String value) {
            addCriterion("art_class <=", value, "artClass");
            return (Criteria) this;
        }

        public Criteria andArtClassLike(String value) {
            addCriterion("art_class like", value, "artClass");
            return (Criteria) this;
        }

        public Criteria andArtClassNotLike(String value) {
            addCriterion("art_class not like", value, "artClass");
            return (Criteria) this;
        }

        public Criteria andArtClassIn(List<String> values) {
            addCriterion("art_class in", values, "artClass");
            return (Criteria) this;
        }

        public Criteria andArtClassNotIn(List<String> values) {
            addCriterion("art_class not in", values, "artClass");
            return (Criteria) this;
        }

        public Criteria andArtClassBetween(String value1, String value2) {
            addCriterion("art_class between", value1, value2, "artClass");
            return (Criteria) this;
        }

        public Criteria andArtClassNotBetween(String value1, String value2) {
            addCriterion("art_class not between", value1, value2, "artClass");
            return (Criteria) this;
        }

        public Criteria andArtSourceIsNull() {
            addCriterion("art_source is null");
            return (Criteria) this;
        }

        public Criteria andArtSourceIsNotNull() {
            addCriterion("art_source is not null");
            return (Criteria) this;
        }

        public Criteria andArtSourceEqualTo(String value) {
            addCriterion("art_source =", value, "artSource");
            return (Criteria) this;
        }

        public Criteria andArtSourceNotEqualTo(String value) {
            addCriterion("art_source <>", value, "artSource");
            return (Criteria) this;
        }

        public Criteria andArtSourceGreaterThan(String value) {
            addCriterion("art_source >", value, "artSource");
            return (Criteria) this;
        }

        public Criteria andArtSourceGreaterThanOrEqualTo(String value) {
            addCriterion("art_source >=", value, "artSource");
            return (Criteria) this;
        }

        public Criteria andArtSourceLessThan(String value) {
            addCriterion("art_source <", value, "artSource");
            return (Criteria) this;
        }

        public Criteria andArtSourceLessThanOrEqualTo(String value) {
            addCriterion("art_source <=", value, "artSource");
            return (Criteria) this;
        }

        public Criteria andArtSourceLike(String value) {
            addCriterion("art_source like", value, "artSource");
            return (Criteria) this;
        }

        public Criteria andArtSourceNotLike(String value) {
            addCriterion("art_source not like", value, "artSource");
            return (Criteria) this;
        }

        public Criteria andArtSourceIn(List<String> values) {
            addCriterion("art_source in", values, "artSource");
            return (Criteria) this;
        }

        public Criteria andArtSourceNotIn(List<String> values) {
            addCriterion("art_source not in", values, "artSource");
            return (Criteria) this;
        }

        public Criteria andArtSourceBetween(String value1, String value2) {
            addCriterion("art_source between", value1, value2, "artSource");
            return (Criteria) this;
        }

        public Criteria andArtSourceNotBetween(String value1, String value2) {
            addCriterion("art_source not between", value1, value2, "artSource");
            return (Criteria) this;
        }

        public Criteria andArtLabelIsNull() {
            addCriterion("art_label is null");
            return (Criteria) this;
        }

        public Criteria andArtLabelIsNotNull() {
            addCriterion("art_label is not null");
            return (Criteria) this;
        }

        public Criteria andArtLabelEqualTo(String value) {
            addCriterion("art_label =", value, "artLabel");
            return (Criteria) this;
        }

        public Criteria andArtLabelNotEqualTo(String value) {
            addCriterion("art_label <>", value, "artLabel");
            return (Criteria) this;
        }

        public Criteria andArtLabelGreaterThan(String value) {
            addCriterion("art_label >", value, "artLabel");
            return (Criteria) this;
        }

        public Criteria andArtLabelGreaterThanOrEqualTo(String value) {
            addCriterion("art_label >=", value, "artLabel");
            return (Criteria) this;
        }

        public Criteria andArtLabelLessThan(String value) {
            addCriterion("art_label <", value, "artLabel");
            return (Criteria) this;
        }

        public Criteria andArtLabelLessThanOrEqualTo(String value) {
            addCriterion("art_label <=", value, "artLabel");
            return (Criteria) this;
        }

        public Criteria andArtLabelLike(String value) {
            addCriterion("art_label like", value, "artLabel");
            return (Criteria) this;
        }

        public Criteria andArtLabelNotLike(String value) {
            addCriterion("art_label not like", value, "artLabel");
            return (Criteria) this;
        }

        public Criteria andArtLabelIn(List<String> values) {
            addCriterion("art_label in", values, "artLabel");
            return (Criteria) this;
        }

        public Criteria andArtLabelNotIn(List<String> values) {
            addCriterion("art_label not in", values, "artLabel");
            return (Criteria) this;
        }

        public Criteria andArtLabelBetween(String value1, String value2) {
            addCriterion("art_label between", value1, value2, "artLabel");
            return (Criteria) this;
        }

        public Criteria andArtLabelNotBetween(String value1, String value2) {
            addCriterion("art_label not between", value1, value2, "artLabel");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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