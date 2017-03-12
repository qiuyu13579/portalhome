package com.ai.portalhome.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TCarouselInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCarouselInfoExample() {
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

        public Criteria andCarIdIsNull() {
            addCriterion("car_id is null");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNotNull() {
            addCriterion("car_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdEqualTo(Integer value) {
            addCriterion("car_id =", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotEqualTo(Integer value) {
            addCriterion("car_id <>", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThan(Integer value) {
            addCriterion("car_id >", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_id >=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThan(Integer value) {
            addCriterion("car_id <", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThanOrEqualTo(Integer value) {
            addCriterion("car_id <=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdIn(List<Integer> values) {
            addCriterion("car_id in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotIn(List<Integer> values) {
            addCriterion("car_id not in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdBetween(Integer value1, Integer value2) {
            addCriterion("car_id between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotBetween(Integer value1, Integer value2) {
            addCriterion("car_id not between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarNameIsNull() {
            addCriterion("car_name is null");
            return (Criteria) this;
        }

        public Criteria andCarNameIsNotNull() {
            addCriterion("car_name is not null");
            return (Criteria) this;
        }

        public Criteria andCarNameEqualTo(String value) {
            addCriterion("car_name =", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameNotEqualTo(String value) {
            addCriterion("car_name <>", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameGreaterThan(String value) {
            addCriterion("car_name >", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameGreaterThanOrEqualTo(String value) {
            addCriterion("car_name >=", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameLessThan(String value) {
            addCriterion("car_name <", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameLessThanOrEqualTo(String value) {
            addCriterion("car_name <=", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameLike(String value) {
            addCriterion("car_name like", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameNotLike(String value) {
            addCriterion("car_name not like", value, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameIn(List<String> values) {
            addCriterion("car_name in", values, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameNotIn(List<String> values) {
            addCriterion("car_name not in", values, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameBetween(String value1, String value2) {
            addCriterion("car_name between", value1, value2, "carName");
            return (Criteria) this;
        }

        public Criteria andCarNameNotBetween(String value1, String value2) {
            addCriterion("car_name not between", value1, value2, "carName");
            return (Criteria) this;
        }

        public Criteria andCarDescIsNull() {
            addCriterion("car_desc is null");
            return (Criteria) this;
        }

        public Criteria andCarDescIsNotNull() {
            addCriterion("car_desc is not null");
            return (Criteria) this;
        }

        public Criteria andCarDescEqualTo(String value) {
            addCriterion("car_desc =", value, "carDesc");
            return (Criteria) this;
        }

        public Criteria andCarDescNotEqualTo(String value) {
            addCriterion("car_desc <>", value, "carDesc");
            return (Criteria) this;
        }

        public Criteria andCarDescGreaterThan(String value) {
            addCriterion("car_desc >", value, "carDesc");
            return (Criteria) this;
        }

        public Criteria andCarDescGreaterThanOrEqualTo(String value) {
            addCriterion("car_desc >=", value, "carDesc");
            return (Criteria) this;
        }

        public Criteria andCarDescLessThan(String value) {
            addCriterion("car_desc <", value, "carDesc");
            return (Criteria) this;
        }

        public Criteria andCarDescLessThanOrEqualTo(String value) {
            addCriterion("car_desc <=", value, "carDesc");
            return (Criteria) this;
        }

        public Criteria andCarDescLike(String value) {
            addCriterion("car_desc like", value, "carDesc");
            return (Criteria) this;
        }

        public Criteria andCarDescNotLike(String value) {
            addCriterion("car_desc not like", value, "carDesc");
            return (Criteria) this;
        }

        public Criteria andCarDescIn(List<String> values) {
            addCriterion("car_desc in", values, "carDesc");
            return (Criteria) this;
        }

        public Criteria andCarDescNotIn(List<String> values) {
            addCriterion("car_desc not in", values, "carDesc");
            return (Criteria) this;
        }

        public Criteria andCarDescBetween(String value1, String value2) {
            addCriterion("car_desc between", value1, value2, "carDesc");
            return (Criteria) this;
        }

        public Criteria andCarDescNotBetween(String value1, String value2) {
            addCriterion("car_desc not between", value1, value2, "carDesc");
            return (Criteria) this;
        }

        public Criteria andCarWidthIsNull() {
            addCriterion("car_width is null");
            return (Criteria) this;
        }

        public Criteria andCarWidthIsNotNull() {
            addCriterion("car_width is not null");
            return (Criteria) this;
        }

        public Criteria andCarWidthEqualTo(String value) {
            addCriterion("car_width =", value, "carWidth");
            return (Criteria) this;
        }

        public Criteria andCarWidthNotEqualTo(String value) {
            addCriterion("car_width <>", value, "carWidth");
            return (Criteria) this;
        }

        public Criteria andCarWidthGreaterThan(String value) {
            addCriterion("car_width >", value, "carWidth");
            return (Criteria) this;
        }

        public Criteria andCarWidthGreaterThanOrEqualTo(String value) {
            addCriterion("car_width >=", value, "carWidth");
            return (Criteria) this;
        }

        public Criteria andCarWidthLessThan(String value) {
            addCriterion("car_width <", value, "carWidth");
            return (Criteria) this;
        }

        public Criteria andCarWidthLessThanOrEqualTo(String value) {
            addCriterion("car_width <=", value, "carWidth");
            return (Criteria) this;
        }

        public Criteria andCarWidthLike(String value) {
            addCriterion("car_width like", value, "carWidth");
            return (Criteria) this;
        }

        public Criteria andCarWidthNotLike(String value) {
            addCriterion("car_width not like", value, "carWidth");
            return (Criteria) this;
        }

        public Criteria andCarWidthIn(List<String> values) {
            addCriterion("car_width in", values, "carWidth");
            return (Criteria) this;
        }

        public Criteria andCarWidthNotIn(List<String> values) {
            addCriterion("car_width not in", values, "carWidth");
            return (Criteria) this;
        }

        public Criteria andCarWidthBetween(String value1, String value2) {
            addCriterion("car_width between", value1, value2, "carWidth");
            return (Criteria) this;
        }

        public Criteria andCarWidthNotBetween(String value1, String value2) {
            addCriterion("car_width not between", value1, value2, "carWidth");
            return (Criteria) this;
        }

        public Criteria andCarHightIsNull() {
            addCriterion("car_hight is null");
            return (Criteria) this;
        }

        public Criteria andCarHightIsNotNull() {
            addCriterion("car_hight is not null");
            return (Criteria) this;
        }

        public Criteria andCarHightEqualTo(String value) {
            addCriterion("car_hight =", value, "carHight");
            return (Criteria) this;
        }

        public Criteria andCarHightNotEqualTo(String value) {
            addCriterion("car_hight <>", value, "carHight");
            return (Criteria) this;
        }

        public Criteria andCarHightGreaterThan(String value) {
            addCriterion("car_hight >", value, "carHight");
            return (Criteria) this;
        }

        public Criteria andCarHightGreaterThanOrEqualTo(String value) {
            addCriterion("car_hight >=", value, "carHight");
            return (Criteria) this;
        }

        public Criteria andCarHightLessThan(String value) {
            addCriterion("car_hight <", value, "carHight");
            return (Criteria) this;
        }

        public Criteria andCarHightLessThanOrEqualTo(String value) {
            addCriterion("car_hight <=", value, "carHight");
            return (Criteria) this;
        }

        public Criteria andCarHightLike(String value) {
            addCriterion("car_hight like", value, "carHight");
            return (Criteria) this;
        }

        public Criteria andCarHightNotLike(String value) {
            addCriterion("car_hight not like", value, "carHight");
            return (Criteria) this;
        }

        public Criteria andCarHightIn(List<String> values) {
            addCriterion("car_hight in", values, "carHight");
            return (Criteria) this;
        }

        public Criteria andCarHightNotIn(List<String> values) {
            addCriterion("car_hight not in", values, "carHight");
            return (Criteria) this;
        }

        public Criteria andCarHightBetween(String value1, String value2) {
            addCriterion("car_hight between", value1, value2, "carHight");
            return (Criteria) this;
        }

        public Criteria andCarHightNotBetween(String value1, String value2) {
            addCriterion("car_hight not between", value1, value2, "carHight");
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