package com.ai.portalhome.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TCellInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCellInfoExample() {
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

        public Criteria andCelIdIsNull() {
            addCriterion("cel_id is null");
            return (Criteria) this;
        }

        public Criteria andCelIdIsNotNull() {
            addCriterion("cel_id is not null");
            return (Criteria) this;
        }

        public Criteria andCelIdEqualTo(Integer value) {
            addCriterion("cel_id =", value, "celId");
            return (Criteria) this;
        }

        public Criteria andCelIdNotEqualTo(Integer value) {
            addCriterion("cel_id <>", value, "celId");
            return (Criteria) this;
        }

        public Criteria andCelIdGreaterThan(Integer value) {
            addCriterion("cel_id >", value, "celId");
            return (Criteria) this;
        }

        public Criteria andCelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cel_id >=", value, "celId");
            return (Criteria) this;
        }

        public Criteria andCelIdLessThan(Integer value) {
            addCriterion("cel_id <", value, "celId");
            return (Criteria) this;
        }

        public Criteria andCelIdLessThanOrEqualTo(Integer value) {
            addCriterion("cel_id <=", value, "celId");
            return (Criteria) this;
        }

        public Criteria andCelIdIn(List<Integer> values) {
            addCriterion("cel_id in", values, "celId");
            return (Criteria) this;
        }

        public Criteria andCelIdNotIn(List<Integer> values) {
            addCriterion("cel_id not in", values, "celId");
            return (Criteria) this;
        }

        public Criteria andCelIdBetween(Integer value1, Integer value2) {
            addCriterion("cel_id between", value1, value2, "celId");
            return (Criteria) this;
        }

        public Criteria andCelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cel_id not between", value1, value2, "celId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Integer value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Integer value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Integer value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Integer value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Integer> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Integer> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andCelNameIsNull() {
            addCriterion("cel_name is null");
            return (Criteria) this;
        }

        public Criteria andCelNameIsNotNull() {
            addCriterion("cel_name is not null");
            return (Criteria) this;
        }

        public Criteria andCelNameEqualTo(String value) {
            addCriterion("cel_name =", value, "celName");
            return (Criteria) this;
        }

        public Criteria andCelNameNotEqualTo(String value) {
            addCriterion("cel_name <>", value, "celName");
            return (Criteria) this;
        }

        public Criteria andCelNameGreaterThan(String value) {
            addCriterion("cel_name >", value, "celName");
            return (Criteria) this;
        }

        public Criteria andCelNameGreaterThanOrEqualTo(String value) {
            addCriterion("cel_name >=", value, "celName");
            return (Criteria) this;
        }

        public Criteria andCelNameLessThan(String value) {
            addCriterion("cel_name <", value, "celName");
            return (Criteria) this;
        }

        public Criteria andCelNameLessThanOrEqualTo(String value) {
            addCriterion("cel_name <=", value, "celName");
            return (Criteria) this;
        }

        public Criteria andCelNameLike(String value) {
            addCriterion("cel_name like", value, "celName");
            return (Criteria) this;
        }

        public Criteria andCelNameNotLike(String value) {
            addCriterion("cel_name not like", value, "celName");
            return (Criteria) this;
        }

        public Criteria andCelNameIn(List<String> values) {
            addCriterion("cel_name in", values, "celName");
            return (Criteria) this;
        }

        public Criteria andCelNameNotIn(List<String> values) {
            addCriterion("cel_name not in", values, "celName");
            return (Criteria) this;
        }

        public Criteria andCelNameBetween(String value1, String value2) {
            addCriterion("cel_name between", value1, value2, "celName");
            return (Criteria) this;
        }

        public Criteria andCelNameNotBetween(String value1, String value2) {
            addCriterion("cel_name not between", value1, value2, "celName");
            return (Criteria) this;
        }

        public Criteria andCelUrlIsNull() {
            addCriterion("cel_url is null");
            return (Criteria) this;
        }

        public Criteria andCelUrlIsNotNull() {
            addCriterion("cel_url is not null");
            return (Criteria) this;
        }

        public Criteria andCelUrlEqualTo(String value) {
            addCriterion("cel_url =", value, "celUrl");
            return (Criteria) this;
        }

        public Criteria andCelUrlNotEqualTo(String value) {
            addCriterion("cel_url <>", value, "celUrl");
            return (Criteria) this;
        }

        public Criteria andCelUrlGreaterThan(String value) {
            addCriterion("cel_url >", value, "celUrl");
            return (Criteria) this;
        }

        public Criteria andCelUrlGreaterThanOrEqualTo(String value) {
            addCriterion("cel_url >=", value, "celUrl");
            return (Criteria) this;
        }

        public Criteria andCelUrlLessThan(String value) {
            addCriterion("cel_url <", value, "celUrl");
            return (Criteria) this;
        }

        public Criteria andCelUrlLessThanOrEqualTo(String value) {
            addCriterion("cel_url <=", value, "celUrl");
            return (Criteria) this;
        }

        public Criteria andCelUrlLike(String value) {
            addCriterion("cel_url like", value, "celUrl");
            return (Criteria) this;
        }

        public Criteria andCelUrlNotLike(String value) {
            addCriterion("cel_url not like", value, "celUrl");
            return (Criteria) this;
        }

        public Criteria andCelUrlIn(List<String> values) {
            addCriterion("cel_url in", values, "celUrl");
            return (Criteria) this;
        }

        public Criteria andCelUrlNotIn(List<String> values) {
            addCriterion("cel_url not in", values, "celUrl");
            return (Criteria) this;
        }

        public Criteria andCelUrlBetween(String value1, String value2) {
            addCriterion("cel_url between", value1, value2, "celUrl");
            return (Criteria) this;
        }

        public Criteria andCelUrlNotBetween(String value1, String value2) {
            addCriterion("cel_url not between", value1, value2, "celUrl");
            return (Criteria) this;
        }

        public Criteria andCelImageIsNull() {
            addCriterion("cel_image is null");
            return (Criteria) this;
        }

        public Criteria andCelImageIsNotNull() {
            addCriterion("cel_image is not null");
            return (Criteria) this;
        }

        public Criteria andCelImageEqualTo(String value) {
            addCriterion("cel_image =", value, "celImage");
            return (Criteria) this;
        }

        public Criteria andCelImageNotEqualTo(String value) {
            addCriterion("cel_image <>", value, "celImage");
            return (Criteria) this;
        }

        public Criteria andCelImageGreaterThan(String value) {
            addCriterion("cel_image >", value, "celImage");
            return (Criteria) this;
        }

        public Criteria andCelImageGreaterThanOrEqualTo(String value) {
            addCriterion("cel_image >=", value, "celImage");
            return (Criteria) this;
        }

        public Criteria andCelImageLessThan(String value) {
            addCriterion("cel_image <", value, "celImage");
            return (Criteria) this;
        }

        public Criteria andCelImageLessThanOrEqualTo(String value) {
            addCriterion("cel_image <=", value, "celImage");
            return (Criteria) this;
        }

        public Criteria andCelImageLike(String value) {
            addCriterion("cel_image like", value, "celImage");
            return (Criteria) this;
        }

        public Criteria andCelImageNotLike(String value) {
            addCriterion("cel_image not like", value, "celImage");
            return (Criteria) this;
        }

        public Criteria andCelImageIn(List<String> values) {
            addCriterion("cel_image in", values, "celImage");
            return (Criteria) this;
        }

        public Criteria andCelImageNotIn(List<String> values) {
            addCriterion("cel_image not in", values, "celImage");
            return (Criteria) this;
        }

        public Criteria andCelImageBetween(String value1, String value2) {
            addCriterion("cel_image between", value1, value2, "celImage");
            return (Criteria) this;
        }

        public Criteria andCelImageNotBetween(String value1, String value2) {
            addCriterion("cel_image not between", value1, value2, "celImage");
            return (Criteria) this;
        }

        public Criteria andCelOrderIsNull() {
            addCriterion("cel_order is null");
            return (Criteria) this;
        }

        public Criteria andCelOrderIsNotNull() {
            addCriterion("cel_order is not null");
            return (Criteria) this;
        }

        public Criteria andCelOrderEqualTo(Integer value) {
            addCriterion("cel_order =", value, "celOrder");
            return (Criteria) this;
        }

        public Criteria andCelOrderNotEqualTo(Integer value) {
            addCriterion("cel_order <>", value, "celOrder");
            return (Criteria) this;
        }

        public Criteria andCelOrderGreaterThan(Integer value) {
            addCriterion("cel_order >", value, "celOrder");
            return (Criteria) this;
        }

        public Criteria andCelOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("cel_order >=", value, "celOrder");
            return (Criteria) this;
        }

        public Criteria andCelOrderLessThan(Integer value) {
            addCriterion("cel_order <", value, "celOrder");
            return (Criteria) this;
        }

        public Criteria andCelOrderLessThanOrEqualTo(Integer value) {
            addCriterion("cel_order <=", value, "celOrder");
            return (Criteria) this;
        }

        public Criteria andCelOrderIn(List<Integer> values) {
            addCriterion("cel_order in", values, "celOrder");
            return (Criteria) this;
        }

        public Criteria andCelOrderNotIn(List<Integer> values) {
            addCriterion("cel_order not in", values, "celOrder");
            return (Criteria) this;
        }

        public Criteria andCelOrderBetween(Integer value1, Integer value2) {
            addCriterion("cel_order between", value1, value2, "celOrder");
            return (Criteria) this;
        }

        public Criteria andCelOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("cel_order not between", value1, value2, "celOrder");
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