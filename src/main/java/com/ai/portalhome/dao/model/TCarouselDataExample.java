package com.ai.portalhome.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TCarouselDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCarouselDataExample() {
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

        public Criteria andDataIdIsNull() {
            addCriterion("data_id is null");
            return (Criteria) this;
        }

        public Criteria andDataIdIsNotNull() {
            addCriterion("data_id is not null");
            return (Criteria) this;
        }

        public Criteria andDataIdEqualTo(Integer value) {
            addCriterion("data_id =", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotEqualTo(Integer value) {
            addCriterion("data_id <>", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThan(Integer value) {
            addCriterion("data_id >", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_id >=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThan(Integer value) {
            addCriterion("data_id <", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThanOrEqualTo(Integer value) {
            addCriterion("data_id <=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdIn(List<Integer> values) {
            addCriterion("data_id in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotIn(List<Integer> values) {
            addCriterion("data_id not in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdBetween(Integer value1, Integer value2) {
            addCriterion("data_id between", value1, value2, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotBetween(Integer value1, Integer value2) {
            addCriterion("data_id not between", value1, value2, "dataId");
            return (Criteria) this;
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

        public Criteria andCarImageIsNull() {
            addCriterion("car_image is null");
            return (Criteria) this;
        }

        public Criteria andCarImageIsNotNull() {
            addCriterion("car_image is not null");
            return (Criteria) this;
        }

        public Criteria andCarImageEqualTo(String value) {
            addCriterion("car_image =", value, "carImage");
            return (Criteria) this;
        }

        public Criteria andCarImageNotEqualTo(String value) {
            addCriterion("car_image <>", value, "carImage");
            return (Criteria) this;
        }

        public Criteria andCarImageGreaterThan(String value) {
            addCriterion("car_image >", value, "carImage");
            return (Criteria) this;
        }

        public Criteria andCarImageGreaterThanOrEqualTo(String value) {
            addCriterion("car_image >=", value, "carImage");
            return (Criteria) this;
        }

        public Criteria andCarImageLessThan(String value) {
            addCriterion("car_image <", value, "carImage");
            return (Criteria) this;
        }

        public Criteria andCarImageLessThanOrEqualTo(String value) {
            addCriterion("car_image <=", value, "carImage");
            return (Criteria) this;
        }

        public Criteria andCarImageLike(String value) {
            addCriterion("car_image like", value, "carImage");
            return (Criteria) this;
        }

        public Criteria andCarImageNotLike(String value) {
            addCriterion("car_image not like", value, "carImage");
            return (Criteria) this;
        }

        public Criteria andCarImageIn(List<String> values) {
            addCriterion("car_image in", values, "carImage");
            return (Criteria) this;
        }

        public Criteria andCarImageNotIn(List<String> values) {
            addCriterion("car_image not in", values, "carImage");
            return (Criteria) this;
        }

        public Criteria andCarImageBetween(String value1, String value2) {
            addCriterion("car_image between", value1, value2, "carImage");
            return (Criteria) this;
        }

        public Criteria andCarImageNotBetween(String value1, String value2) {
            addCriterion("car_image not between", value1, value2, "carImage");
            return (Criteria) this;
        }

        public Criteria andCarTitleIsNull() {
            addCriterion("car_title is null");
            return (Criteria) this;
        }

        public Criteria andCarTitleIsNotNull() {
            addCriterion("car_title is not null");
            return (Criteria) this;
        }

        public Criteria andCarTitleEqualTo(String value) {
            addCriterion("car_title =", value, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarTitleNotEqualTo(String value) {
            addCriterion("car_title <>", value, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarTitleGreaterThan(String value) {
            addCriterion("car_title >", value, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarTitleGreaterThanOrEqualTo(String value) {
            addCriterion("car_title >=", value, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarTitleLessThan(String value) {
            addCriterion("car_title <", value, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarTitleLessThanOrEqualTo(String value) {
            addCriterion("car_title <=", value, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarTitleLike(String value) {
            addCriterion("car_title like", value, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarTitleNotLike(String value) {
            addCriterion("car_title not like", value, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarTitleIn(List<String> values) {
            addCriterion("car_title in", values, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarTitleNotIn(List<String> values) {
            addCriterion("car_title not in", values, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarTitleBetween(String value1, String value2) {
            addCriterion("car_title between", value1, value2, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarTitleNotBetween(String value1, String value2) {
            addCriterion("car_title not between", value1, value2, "carTitle");
            return (Criteria) this;
        }

        public Criteria andCarUrlIsNull() {
            addCriterion("car_url is null");
            return (Criteria) this;
        }

        public Criteria andCarUrlIsNotNull() {
            addCriterion("car_url is not null");
            return (Criteria) this;
        }

        public Criteria andCarUrlEqualTo(String value) {
            addCriterion("car_url =", value, "carUrl");
            return (Criteria) this;
        }

        public Criteria andCarUrlNotEqualTo(String value) {
            addCriterion("car_url <>", value, "carUrl");
            return (Criteria) this;
        }

        public Criteria andCarUrlGreaterThan(String value) {
            addCriterion("car_url >", value, "carUrl");
            return (Criteria) this;
        }

        public Criteria andCarUrlGreaterThanOrEqualTo(String value) {
            addCriterion("car_url >=", value, "carUrl");
            return (Criteria) this;
        }

        public Criteria andCarUrlLessThan(String value) {
            addCriterion("car_url <", value, "carUrl");
            return (Criteria) this;
        }

        public Criteria andCarUrlLessThanOrEqualTo(String value) {
            addCriterion("car_url <=", value, "carUrl");
            return (Criteria) this;
        }

        public Criteria andCarUrlLike(String value) {
            addCriterion("car_url like", value, "carUrl");
            return (Criteria) this;
        }

        public Criteria andCarUrlNotLike(String value) {
            addCriterion("car_url not like", value, "carUrl");
            return (Criteria) this;
        }

        public Criteria andCarUrlIn(List<String> values) {
            addCriterion("car_url in", values, "carUrl");
            return (Criteria) this;
        }

        public Criteria andCarUrlNotIn(List<String> values) {
            addCriterion("car_url not in", values, "carUrl");
            return (Criteria) this;
        }

        public Criteria andCarUrlBetween(String value1, String value2) {
            addCriterion("car_url between", value1, value2, "carUrl");
            return (Criteria) this;
        }

        public Criteria andCarUrlNotBetween(String value1, String value2) {
            addCriterion("car_url not between", value1, value2, "carUrl");
            return (Criteria) this;
        }

        public Criteria andCarOrderIsNull() {
            addCriterion("car_order is null");
            return (Criteria) this;
        }

        public Criteria andCarOrderIsNotNull() {
            addCriterion("car_order is not null");
            return (Criteria) this;
        }

        public Criteria andCarOrderEqualTo(Integer value) {
            addCriterion("car_order =", value, "carOrder");
            return (Criteria) this;
        }

        public Criteria andCarOrderNotEqualTo(Integer value) {
            addCriterion("car_order <>", value, "carOrder");
            return (Criteria) this;
        }

        public Criteria andCarOrderGreaterThan(Integer value) {
            addCriterion("car_order >", value, "carOrder");
            return (Criteria) this;
        }

        public Criteria andCarOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_order >=", value, "carOrder");
            return (Criteria) this;
        }

        public Criteria andCarOrderLessThan(Integer value) {
            addCriterion("car_order <", value, "carOrder");
            return (Criteria) this;
        }

        public Criteria andCarOrderLessThanOrEqualTo(Integer value) {
            addCriterion("car_order <=", value, "carOrder");
            return (Criteria) this;
        }

        public Criteria andCarOrderIn(List<Integer> values) {
            addCriterion("car_order in", values, "carOrder");
            return (Criteria) this;
        }

        public Criteria andCarOrderNotIn(List<Integer> values) {
            addCriterion("car_order not in", values, "carOrder");
            return (Criteria) this;
        }

        public Criteria andCarOrderBetween(Integer value1, Integer value2) {
            addCriterion("car_order between", value1, value2, "carOrder");
            return (Criteria) this;
        }

        public Criteria andCarOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("car_order not between", value1, value2, "carOrder");
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