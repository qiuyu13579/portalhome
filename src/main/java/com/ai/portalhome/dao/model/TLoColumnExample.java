package com.ai.portalhome.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TLoColumnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TLoColumnExample() {
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

        public Criteria andColIdIsNull() {
            addCriterion("col_id is null");
            return (Criteria) this;
        }

        public Criteria andColIdIsNotNull() {
            addCriterion("col_id is not null");
            return (Criteria) this;
        }

        public Criteria andColIdEqualTo(Integer value) {
            addCriterion("col_id =", value, "colId");
            return (Criteria) this;
        }

        public Criteria andColIdNotEqualTo(Integer value) {
            addCriterion("col_id <>", value, "colId");
            return (Criteria) this;
        }

        public Criteria andColIdGreaterThan(Integer value) {
            addCriterion("col_id >", value, "colId");
            return (Criteria) this;
        }

        public Criteria andColIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("col_id >=", value, "colId");
            return (Criteria) this;
        }

        public Criteria andColIdLessThan(Integer value) {
            addCriterion("col_id <", value, "colId");
            return (Criteria) this;
        }

        public Criteria andColIdLessThanOrEqualTo(Integer value) {
            addCriterion("col_id <=", value, "colId");
            return (Criteria) this;
        }

        public Criteria andColIdIn(List<Integer> values) {
            addCriterion("col_id in", values, "colId");
            return (Criteria) this;
        }

        public Criteria andColIdNotIn(List<Integer> values) {
            addCriterion("col_id not in", values, "colId");
            return (Criteria) this;
        }

        public Criteria andColIdBetween(Integer value1, Integer value2) {
            addCriterion("col_id between", value1, value2, "colId");
            return (Criteria) this;
        }

        public Criteria andColIdNotBetween(Integer value1, Integer value2) {
            addCriterion("col_id not between", value1, value2, "colId");
            return (Criteria) this;
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

        public Criteria andColTitleIsNull() {
            addCriterion("col_title is null");
            return (Criteria) this;
        }

        public Criteria andColTitleIsNotNull() {
            addCriterion("col_title is not null");
            return (Criteria) this;
        }

        public Criteria andColTitleEqualTo(String value) {
            addCriterion("col_title =", value, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTitleNotEqualTo(String value) {
            addCriterion("col_title <>", value, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTitleGreaterThan(String value) {
            addCriterion("col_title >", value, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTitleGreaterThanOrEqualTo(String value) {
            addCriterion("col_title >=", value, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTitleLessThan(String value) {
            addCriterion("col_title <", value, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTitleLessThanOrEqualTo(String value) {
            addCriterion("col_title <=", value, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTitleLike(String value) {
            addCriterion("col_title like", value, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTitleNotLike(String value) {
            addCriterion("col_title not like", value, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTitleIn(List<String> values) {
            addCriterion("col_title in", values, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTitleNotIn(List<String> values) {
            addCriterion("col_title not in", values, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTitleBetween(String value1, String value2) {
            addCriterion("col_title between", value1, value2, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColTitleNotBetween(String value1, String value2) {
            addCriterion("col_title not between", value1, value2, "colTitle");
            return (Criteria) this;
        }

        public Criteria andColDescIsNull() {
            addCriterion("col_desc is null");
            return (Criteria) this;
        }

        public Criteria andColDescIsNotNull() {
            addCriterion("col_desc is not null");
            return (Criteria) this;
        }

        public Criteria andColDescEqualTo(String value) {
            addCriterion("col_desc =", value, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColDescNotEqualTo(String value) {
            addCriterion("col_desc <>", value, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColDescGreaterThan(String value) {
            addCriterion("col_desc >", value, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColDescGreaterThanOrEqualTo(String value) {
            addCriterion("col_desc >=", value, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColDescLessThan(String value) {
            addCriterion("col_desc <", value, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColDescLessThanOrEqualTo(String value) {
            addCriterion("col_desc <=", value, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColDescLike(String value) {
            addCriterion("col_desc like", value, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColDescNotLike(String value) {
            addCriterion("col_desc not like", value, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColDescIn(List<String> values) {
            addCriterion("col_desc in", values, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColDescNotIn(List<String> values) {
            addCriterion("col_desc not in", values, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColDescBetween(String value1, String value2) {
            addCriterion("col_desc between", value1, value2, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColDescNotBetween(String value1, String value2) {
            addCriterion("col_desc not between", value1, value2, "colDesc");
            return (Criteria) this;
        }

        public Criteria andColTypeIsNull() {
            addCriterion("col_type is null");
            return (Criteria) this;
        }

        public Criteria andColTypeIsNotNull() {
            addCriterion("col_type is not null");
            return (Criteria) this;
        }

        public Criteria andColTypeEqualTo(String value) {
            addCriterion("col_type =", value, "colType");
            return (Criteria) this;
        }

        public Criteria andColTypeNotEqualTo(String value) {
            addCriterion("col_type <>", value, "colType");
            return (Criteria) this;
        }

        public Criteria andColTypeGreaterThan(String value) {
            addCriterion("col_type >", value, "colType");
            return (Criteria) this;
        }

        public Criteria andColTypeGreaterThanOrEqualTo(String value) {
            addCriterion("col_type >=", value, "colType");
            return (Criteria) this;
        }

        public Criteria andColTypeLessThan(String value) {
            addCriterion("col_type <", value, "colType");
            return (Criteria) this;
        }

        public Criteria andColTypeLessThanOrEqualTo(String value) {
            addCriterion("col_type <=", value, "colType");
            return (Criteria) this;
        }

        public Criteria andColTypeLike(String value) {
            addCriterion("col_type like", value, "colType");
            return (Criteria) this;
        }

        public Criteria andColTypeNotLike(String value) {
            addCriterion("col_type not like", value, "colType");
            return (Criteria) this;
        }

        public Criteria andColTypeIn(List<String> values) {
            addCriterion("col_type in", values, "colType");
            return (Criteria) this;
        }

        public Criteria andColTypeNotIn(List<String> values) {
            addCriterion("col_type not in", values, "colType");
            return (Criteria) this;
        }

        public Criteria andColTypeBetween(String value1, String value2) {
            addCriterion("col_type between", value1, value2, "colType");
            return (Criteria) this;
        }

        public Criteria andColTypeNotBetween(String value1, String value2) {
            addCriterion("col_type not between", value1, value2, "colType");
            return (Criteria) this;
        }

        public Criteria andColXIsNull() {
            addCriterion("col_x is null");
            return (Criteria) this;
        }

        public Criteria andColXIsNotNull() {
            addCriterion("col_x is not null");
            return (Criteria) this;
        }

        public Criteria andColXEqualTo(Integer value) {
            addCriterion("col_x =", value, "colX");
            return (Criteria) this;
        }

        public Criteria andColXNotEqualTo(Integer value) {
            addCriterion("col_x <>", value, "colX");
            return (Criteria) this;
        }

        public Criteria andColXGreaterThan(Integer value) {
            addCriterion("col_x >", value, "colX");
            return (Criteria) this;
        }

        public Criteria andColXGreaterThanOrEqualTo(Integer value) {
            addCriterion("col_x >=", value, "colX");
            return (Criteria) this;
        }

        public Criteria andColXLessThan(Integer value) {
            addCriterion("col_x <", value, "colX");
            return (Criteria) this;
        }

        public Criteria andColXLessThanOrEqualTo(Integer value) {
            addCriterion("col_x <=", value, "colX");
            return (Criteria) this;
        }

        public Criteria andColXIn(List<Integer> values) {
            addCriterion("col_x in", values, "colX");
            return (Criteria) this;
        }

        public Criteria andColXNotIn(List<Integer> values) {
            addCriterion("col_x not in", values, "colX");
            return (Criteria) this;
        }

        public Criteria andColXBetween(Integer value1, Integer value2) {
            addCriterion("col_x between", value1, value2, "colX");
            return (Criteria) this;
        }

        public Criteria andColXNotBetween(Integer value1, Integer value2) {
            addCriterion("col_x not between", value1, value2, "colX");
            return (Criteria) this;
        }

        public Criteria andColYIsNull() {
            addCriterion("col_y is null");
            return (Criteria) this;
        }

        public Criteria andColYIsNotNull() {
            addCriterion("col_y is not null");
            return (Criteria) this;
        }

        public Criteria andColYEqualTo(Integer value) {
            addCriterion("col_y =", value, "colY");
            return (Criteria) this;
        }

        public Criteria andColYNotEqualTo(Integer value) {
            addCriterion("col_y <>", value, "colY");
            return (Criteria) this;
        }

        public Criteria andColYGreaterThan(Integer value) {
            addCriterion("col_y >", value, "colY");
            return (Criteria) this;
        }

        public Criteria andColYGreaterThanOrEqualTo(Integer value) {
            addCriterion("col_y >=", value, "colY");
            return (Criteria) this;
        }

        public Criteria andColYLessThan(Integer value) {
            addCriterion("col_y <", value, "colY");
            return (Criteria) this;
        }

        public Criteria andColYLessThanOrEqualTo(Integer value) {
            addCriterion("col_y <=", value, "colY");
            return (Criteria) this;
        }

        public Criteria andColYIn(List<Integer> values) {
            addCriterion("col_y in", values, "colY");
            return (Criteria) this;
        }

        public Criteria andColYNotIn(List<Integer> values) {
            addCriterion("col_y not in", values, "colY");
            return (Criteria) this;
        }

        public Criteria andColYBetween(Integer value1, Integer value2) {
            addCriterion("col_y between", value1, value2, "colY");
            return (Criteria) this;
        }

        public Criteria andColYNotBetween(Integer value1, Integer value2) {
            addCriterion("col_y not between", value1, value2, "colY");
            return (Criteria) this;
        }

        public Criteria andColWidthIsNull() {
            addCriterion("col_width is null");
            return (Criteria) this;
        }

        public Criteria andColWidthIsNotNull() {
            addCriterion("col_width is not null");
            return (Criteria) this;
        }

        public Criteria andColWidthEqualTo(Integer value) {
            addCriterion("col_width =", value, "colWidth");
            return (Criteria) this;
        }

        public Criteria andColWidthNotEqualTo(Integer value) {
            addCriterion("col_width <>", value, "colWidth");
            return (Criteria) this;
        }

        public Criteria andColWidthGreaterThan(Integer value) {
            addCriterion("col_width >", value, "colWidth");
            return (Criteria) this;
        }

        public Criteria andColWidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("col_width >=", value, "colWidth");
            return (Criteria) this;
        }

        public Criteria andColWidthLessThan(Integer value) {
            addCriterion("col_width <", value, "colWidth");
            return (Criteria) this;
        }

        public Criteria andColWidthLessThanOrEqualTo(Integer value) {
            addCriterion("col_width <=", value, "colWidth");
            return (Criteria) this;
        }

        public Criteria andColWidthIn(List<Integer> values) {
            addCriterion("col_width in", values, "colWidth");
            return (Criteria) this;
        }

        public Criteria andColWidthNotIn(List<Integer> values) {
            addCriterion("col_width not in", values, "colWidth");
            return (Criteria) this;
        }

        public Criteria andColWidthBetween(Integer value1, Integer value2) {
            addCriterion("col_width between", value1, value2, "colWidth");
            return (Criteria) this;
        }

        public Criteria andColWidthNotBetween(Integer value1, Integer value2) {
            addCriterion("col_width not between", value1, value2, "colWidth");
            return (Criteria) this;
        }

        public Criteria andColHeighIsNull() {
            addCriterion("col_heigh is null");
            return (Criteria) this;
        }

        public Criteria andColHeighIsNotNull() {
            addCriterion("col_heigh is not null");
            return (Criteria) this;
        }

        public Criteria andColHeighEqualTo(Integer value) {
            addCriterion("col_heigh =", value, "colHeigh");
            return (Criteria) this;
        }

        public Criteria andColHeighNotEqualTo(Integer value) {
            addCriterion("col_heigh <>", value, "colHeigh");
            return (Criteria) this;
        }

        public Criteria andColHeighGreaterThan(Integer value) {
            addCriterion("col_heigh >", value, "colHeigh");
            return (Criteria) this;
        }

        public Criteria andColHeighGreaterThanOrEqualTo(Integer value) {
            addCriterion("col_heigh >=", value, "colHeigh");
            return (Criteria) this;
        }

        public Criteria andColHeighLessThan(Integer value) {
            addCriterion("col_heigh <", value, "colHeigh");
            return (Criteria) this;
        }

        public Criteria andColHeighLessThanOrEqualTo(Integer value) {
            addCriterion("col_heigh <=", value, "colHeigh");
            return (Criteria) this;
        }

        public Criteria andColHeighIn(List<Integer> values) {
            addCriterion("col_heigh in", values, "colHeigh");
            return (Criteria) this;
        }

        public Criteria andColHeighNotIn(List<Integer> values) {
            addCriterion("col_heigh not in", values, "colHeigh");
            return (Criteria) this;
        }

        public Criteria andColHeighBetween(Integer value1, Integer value2) {
            addCriterion("col_heigh between", value1, value2, "colHeigh");
            return (Criteria) this;
        }

        public Criteria andColHeighNotBetween(Integer value1, Integer value2) {
            addCriterion("col_heigh not between", value1, value2, "colHeigh");
            return (Criteria) this;
        }

        public Criteria andColOrderIsNull() {
            addCriterion("col_order is null");
            return (Criteria) this;
        }

        public Criteria andColOrderIsNotNull() {
            addCriterion("col_order is not null");
            return (Criteria) this;
        }

        public Criteria andColOrderEqualTo(Integer value) {
            addCriterion("col_order =", value, "colOrder");
            return (Criteria) this;
        }

        public Criteria andColOrderNotEqualTo(Integer value) {
            addCriterion("col_order <>", value, "colOrder");
            return (Criteria) this;
        }

        public Criteria andColOrderGreaterThan(Integer value) {
            addCriterion("col_order >", value, "colOrder");
            return (Criteria) this;
        }

        public Criteria andColOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("col_order >=", value, "colOrder");
            return (Criteria) this;
        }

        public Criteria andColOrderLessThan(Integer value) {
            addCriterion("col_order <", value, "colOrder");
            return (Criteria) this;
        }

        public Criteria andColOrderLessThanOrEqualTo(Integer value) {
            addCriterion("col_order <=", value, "colOrder");
            return (Criteria) this;
        }

        public Criteria andColOrderIn(List<Integer> values) {
            addCriterion("col_order in", values, "colOrder");
            return (Criteria) this;
        }

        public Criteria andColOrderNotIn(List<Integer> values) {
            addCriterion("col_order not in", values, "colOrder");
            return (Criteria) this;
        }

        public Criteria andColOrderBetween(Integer value1, Integer value2) {
            addCriterion("col_order between", value1, value2, "colOrder");
            return (Criteria) this;
        }

        public Criteria andColOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("col_order not between", value1, value2, "colOrder");
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