package com.ai.portalhome.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TLoMainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TLoMainExample() {
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

        public Criteria andOlIdIsNull() {
            addCriterion("ol_id is null");
            return (Criteria) this;
        }

        public Criteria andOlIdIsNotNull() {
            addCriterion("ol_id is not null");
            return (Criteria) this;
        }

        public Criteria andOlIdEqualTo(Integer value) {
            addCriterion("ol_id =", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdNotEqualTo(Integer value) {
            addCriterion("ol_id <>", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdGreaterThan(Integer value) {
            addCriterion("ol_id >", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ol_id >=", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdLessThan(Integer value) {
            addCriterion("ol_id <", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdLessThanOrEqualTo(Integer value) {
            addCriterion("ol_id <=", value, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdIn(List<Integer> values) {
            addCriterion("ol_id in", values, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdNotIn(List<Integer> values) {
            addCriterion("ol_id not in", values, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdBetween(Integer value1, Integer value2) {
            addCriterion("ol_id between", value1, value2, "olId");
            return (Criteria) this;
        }

        public Criteria andOlIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ol_id not between", value1, value2, "olId");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNull() {
            addCriterion("model_id is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("model_id is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(Integer value) {
            addCriterion("model_id =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(Integer value) {
            addCriterion("model_id <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(Integer value) {
            addCriterion("model_id >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("model_id >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(Integer value) {
            addCriterion("model_id <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(Integer value) {
            addCriterion("model_id <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<Integer> values) {
            addCriterion("model_id in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<Integer> values) {
            addCriterion("model_id not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(Integer value1, Integer value2) {
            addCriterion("model_id between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("model_id not between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andOlNameIsNull() {
            addCriterion("ol_name is null");
            return (Criteria) this;
        }

        public Criteria andOlNameIsNotNull() {
            addCriterion("ol_name is not null");
            return (Criteria) this;
        }

        public Criteria andOlNameEqualTo(String value) {
            addCriterion("ol_name =", value, "olName");
            return (Criteria) this;
        }

        public Criteria andOlNameNotEqualTo(String value) {
            addCriterion("ol_name <>", value, "olName");
            return (Criteria) this;
        }

        public Criteria andOlNameGreaterThan(String value) {
            addCriterion("ol_name >", value, "olName");
            return (Criteria) this;
        }

        public Criteria andOlNameGreaterThanOrEqualTo(String value) {
            addCriterion("ol_name >=", value, "olName");
            return (Criteria) this;
        }

        public Criteria andOlNameLessThan(String value) {
            addCriterion("ol_name <", value, "olName");
            return (Criteria) this;
        }

        public Criteria andOlNameLessThanOrEqualTo(String value) {
            addCriterion("ol_name <=", value, "olName");
            return (Criteria) this;
        }

        public Criteria andOlNameLike(String value) {
            addCriterion("ol_name like", value, "olName");
            return (Criteria) this;
        }

        public Criteria andOlNameNotLike(String value) {
            addCriterion("ol_name not like", value, "olName");
            return (Criteria) this;
        }

        public Criteria andOlNameIn(List<String> values) {
            addCriterion("ol_name in", values, "olName");
            return (Criteria) this;
        }

        public Criteria andOlNameNotIn(List<String> values) {
            addCriterion("ol_name not in", values, "olName");
            return (Criteria) this;
        }

        public Criteria andOlNameBetween(String value1, String value2) {
            addCriterion("ol_name between", value1, value2, "olName");
            return (Criteria) this;
        }

        public Criteria andOlNameNotBetween(String value1, String value2) {
            addCriterion("ol_name not between", value1, value2, "olName");
            return (Criteria) this;
        }

        public Criteria andOlDescIsNull() {
            addCriterion("ol_desc is null");
            return (Criteria) this;
        }

        public Criteria andOlDescIsNotNull() {
            addCriterion("ol_desc is not null");
            return (Criteria) this;
        }

        public Criteria andOlDescEqualTo(String value) {
            addCriterion("ol_desc =", value, "olDesc");
            return (Criteria) this;
        }

        public Criteria andOlDescNotEqualTo(String value) {
            addCriterion("ol_desc <>", value, "olDesc");
            return (Criteria) this;
        }

        public Criteria andOlDescGreaterThan(String value) {
            addCriterion("ol_desc >", value, "olDesc");
            return (Criteria) this;
        }

        public Criteria andOlDescGreaterThanOrEqualTo(String value) {
            addCriterion("ol_desc >=", value, "olDesc");
            return (Criteria) this;
        }

        public Criteria andOlDescLessThan(String value) {
            addCriterion("ol_desc <", value, "olDesc");
            return (Criteria) this;
        }

        public Criteria andOlDescLessThanOrEqualTo(String value) {
            addCriterion("ol_desc <=", value, "olDesc");
            return (Criteria) this;
        }

        public Criteria andOlDescLike(String value) {
            addCriterion("ol_desc like", value, "olDesc");
            return (Criteria) this;
        }

        public Criteria andOlDescNotLike(String value) {
            addCriterion("ol_desc not like", value, "olDesc");
            return (Criteria) this;
        }

        public Criteria andOlDescIn(List<String> values) {
            addCriterion("ol_desc in", values, "olDesc");
            return (Criteria) this;
        }

        public Criteria andOlDescNotIn(List<String> values) {
            addCriterion("ol_desc not in", values, "olDesc");
            return (Criteria) this;
        }

        public Criteria andOlDescBetween(String value1, String value2) {
            addCriterion("ol_desc between", value1, value2, "olDesc");
            return (Criteria) this;
        }

        public Criteria andOlDescNotBetween(String value1, String value2) {
            addCriterion("ol_desc not between", value1, value2, "olDesc");
            return (Criteria) this;
        }

        public Criteria andOlTypeIsNull() {
            addCriterion("ol_type is null");
            return (Criteria) this;
        }

        public Criteria andOlTypeIsNotNull() {
            addCriterion("ol_type is not null");
            return (Criteria) this;
        }

        public Criteria andOlTypeEqualTo(String value) {
            addCriterion("ol_type =", value, "olType");
            return (Criteria) this;
        }

        public Criteria andOlTypeNotEqualTo(String value) {
            addCriterion("ol_type <>", value, "olType");
            return (Criteria) this;
        }

        public Criteria andOlTypeGreaterThan(String value) {
            addCriterion("ol_type >", value, "olType");
            return (Criteria) this;
        }

        public Criteria andOlTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ol_type >=", value, "olType");
            return (Criteria) this;
        }

        public Criteria andOlTypeLessThan(String value) {
            addCriterion("ol_type <", value, "olType");
            return (Criteria) this;
        }

        public Criteria andOlTypeLessThanOrEqualTo(String value) {
            addCriterion("ol_type <=", value, "olType");
            return (Criteria) this;
        }

        public Criteria andOlTypeLike(String value) {
            addCriterion("ol_type like", value, "olType");
            return (Criteria) this;
        }

        public Criteria andOlTypeNotLike(String value) {
            addCriterion("ol_type not like", value, "olType");
            return (Criteria) this;
        }

        public Criteria andOlTypeIn(List<String> values) {
            addCriterion("ol_type in", values, "olType");
            return (Criteria) this;
        }

        public Criteria andOlTypeNotIn(List<String> values) {
            addCriterion("ol_type not in", values, "olType");
            return (Criteria) this;
        }

        public Criteria andOlTypeBetween(String value1, String value2) {
            addCriterion("ol_type between", value1, value2, "olType");
            return (Criteria) this;
        }

        public Criteria andOlTypeNotBetween(String value1, String value2) {
            addCriterion("ol_type not between", value1, value2, "olType");
            return (Criteria) this;
        }

        public Criteria andIfEditIsNull() {
            addCriterion("if_edit is null");
            return (Criteria) this;
        }

        public Criteria andIfEditIsNotNull() {
            addCriterion("if_edit is not null");
            return (Criteria) this;
        }

        public Criteria andIfEditEqualTo(String value) {
            addCriterion("if_edit =", value, "ifEdit");
            return (Criteria) this;
        }

        public Criteria andIfEditNotEqualTo(String value) {
            addCriterion("if_edit <>", value, "ifEdit");
            return (Criteria) this;
        }

        public Criteria andIfEditGreaterThan(String value) {
            addCriterion("if_edit >", value, "ifEdit");
            return (Criteria) this;
        }

        public Criteria andIfEditGreaterThanOrEqualTo(String value) {
            addCriterion("if_edit >=", value, "ifEdit");
            return (Criteria) this;
        }

        public Criteria andIfEditLessThan(String value) {
            addCriterion("if_edit <", value, "ifEdit");
            return (Criteria) this;
        }

        public Criteria andIfEditLessThanOrEqualTo(String value) {
            addCriterion("if_edit <=", value, "ifEdit");
            return (Criteria) this;
        }

        public Criteria andIfEditLike(String value) {
            addCriterion("if_edit like", value, "ifEdit");
            return (Criteria) this;
        }

        public Criteria andIfEditNotLike(String value) {
            addCriterion("if_edit not like", value, "ifEdit");
            return (Criteria) this;
        }

        public Criteria andIfEditIn(List<String> values) {
            addCriterion("if_edit in", values, "ifEdit");
            return (Criteria) this;
        }

        public Criteria andIfEditNotIn(List<String> values) {
            addCriterion("if_edit not in", values, "ifEdit");
            return (Criteria) this;
        }

        public Criteria andIfEditBetween(String value1, String value2) {
            addCriterion("if_edit between", value1, value2, "ifEdit");
            return (Criteria) this;
        }

        public Criteria andIfEditNotBetween(String value1, String value2) {
            addCriterion("if_edit not between", value1, value2, "ifEdit");
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