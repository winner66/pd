package com.chk.pd.pd_material.domain;

import java.util.ArrayList;
import java.util.List;

public class PdInfoMaterialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PdInfoMaterialExample() {
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

        public Criteria andPdModelIdIsNull() {
            addCriterion("pd_model_id is null");
            return (Criteria) this;
        }

        public Criteria andPdModelIdIsNotNull() {
            addCriterion("pd_model_id is not null");
            return (Criteria) this;
        }

        public Criteria andPdModelIdEqualTo(Integer value) {
            addCriterion("pd_model_id =", value, "pdModelId");
            return (Criteria) this;
        }

        public Criteria andPdModelIdNotEqualTo(Integer value) {
            addCriterion("pd_model_id <>", value, "pdModelId");
            return (Criteria) this;
        }

        public Criteria andPdModelIdGreaterThan(Integer value) {
            addCriterion("pd_model_id >", value, "pdModelId");
            return (Criteria) this;
        }

        public Criteria andPdModelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pd_model_id >=", value, "pdModelId");
            return (Criteria) this;
        }

        public Criteria andPdModelIdLessThan(Integer value) {
            addCriterion("pd_model_id <", value, "pdModelId");
            return (Criteria) this;
        }

        public Criteria andPdModelIdLessThanOrEqualTo(Integer value) {
            addCriterion("pd_model_id <=", value, "pdModelId");
            return (Criteria) this;
        }

        public Criteria andPdModelIdIn(List<Integer> values) {
            addCriterion("pd_model_id in", values, "pdModelId");
            return (Criteria) this;
        }

        public Criteria andPdModelIdNotIn(List<Integer> values) {
            addCriterion("pd_model_id not in", values, "pdModelId");
            return (Criteria) this;
        }

        public Criteria andPdModelIdBetween(Integer value1, Integer value2) {
            addCriterion("pd_model_id between", value1, value2, "pdModelId");
            return (Criteria) this;
        }

        public Criteria andPdModelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pd_model_id not between", value1, value2, "pdModelId");
            return (Criteria) this;
        }

        public Criteria andStdIsNull() {
            addCriterion("std is null");
            return (Criteria) this;
        }

        public Criteria andStdIsNotNull() {
            addCriterion("std is not null");
            return (Criteria) this;
        }

        public Criteria andStdEqualTo(String value) {
            addCriterion("std =", value, "std");
            return (Criteria) this;
        }

        public Criteria andStdNotEqualTo(String value) {
            addCriterion("std <>", value, "std");
            return (Criteria) this;
        }

        public Criteria andStdGreaterThan(String value) {
            addCriterion("std >", value, "std");
            return (Criteria) this;
        }

        public Criteria andStdGreaterThanOrEqualTo(String value) {
            addCriterion("std >=", value, "std");
            return (Criteria) this;
        }

        public Criteria andStdLessThan(String value) {
            addCriterion("std <", value, "std");
            return (Criteria) this;
        }

        public Criteria andStdLessThanOrEqualTo(String value) {
            addCriterion("std <=", value, "std");
            return (Criteria) this;
        }

        public Criteria andStdLike(String value) {
            addCriterion("std like", value, "std");
            return (Criteria) this;
        }

        public Criteria andStdNotLike(String value) {
            addCriterion("std not like", value, "std");
            return (Criteria) this;
        }

        public Criteria andStdIn(List<String> values) {
            addCriterion("std in", values, "std");
            return (Criteria) this;
        }

        public Criteria andStdNotIn(List<String> values) {
            addCriterion("std not in", values, "std");
            return (Criteria) this;
        }

        public Criteria andStdBetween(String value1, String value2) {
            addCriterion("std between", value1, value2, "std");
            return (Criteria) this;
        }

        public Criteria andStdNotBetween(String value1, String value2) {
            addCriterion("std not between", value1, value2, "std");
            return (Criteria) this;
        }

        public Criteria andQualityIsNull() {
            addCriterion("quality is null");
            return (Criteria) this;
        }

        public Criteria andQualityIsNotNull() {
            addCriterion("quality is not null");
            return (Criteria) this;
        }

        public Criteria andQualityEqualTo(String value) {
            addCriterion("quality =", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotEqualTo(String value) {
            addCriterion("quality <>", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThan(String value) {
            addCriterion("quality >", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThanOrEqualTo(String value) {
            addCriterion("quality >=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThan(String value) {
            addCriterion("quality <", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThanOrEqualTo(String value) {
            addCriterion("quality <=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLike(String value) {
            addCriterion("quality like", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotLike(String value) {
            addCriterion("quality not like", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityIn(List<String> values) {
            addCriterion("quality in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotIn(List<String> values) {
            addCriterion("quality not in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityBetween(String value1, String value2) {
            addCriterion("quality between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotBetween(String value1, String value2) {
            addCriterion("quality not between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(Double value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(Double value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(Double value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(Double value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(Double value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(Double value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<Double> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<Double> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(Double value1, Double value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(Double value1, Double value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSearchKeyIsNull() {
            addCriterion("search_key is null");
            return (Criteria) this;
        }

        public Criteria andSearchKeyIsNotNull() {
            addCriterion("search_key is not null");
            return (Criteria) this;
        }

        public Criteria andSearchKeyEqualTo(String value) {
            addCriterion("search_key =", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyNotEqualTo(String value) {
            addCriterion("search_key <>", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyGreaterThan(String value) {
            addCriterion("search_key >", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyGreaterThanOrEqualTo(String value) {
            addCriterion("search_key >=", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyLessThan(String value) {
            addCriterion("search_key <", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyLessThanOrEqualTo(String value) {
            addCriterion("search_key <=", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyLike(String value) {
            addCriterion("search_key like", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyNotLike(String value) {
            addCriterion("search_key not like", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyIn(List<String> values) {
            addCriterion("search_key in", values, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyNotIn(List<String> values) {
            addCriterion("search_key not in", values, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyBetween(String value1, String value2) {
            addCriterion("search_key between", value1, value2, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyNotBetween(String value1, String value2) {
            addCriterion("search_key not between", value1, value2, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSurfaceCodeIsNull() {
            addCriterion("surface_code is null");
            return (Criteria) this;
        }

        public Criteria andSurfaceCodeIsNotNull() {
            addCriterion("surface_code is not null");
            return (Criteria) this;
        }

        public Criteria andSurfaceCodeEqualTo(String value) {
            addCriterion("surface_code =", value, "surfaceCode");
            return (Criteria) this;
        }

        public Criteria andSurfaceCodeNotEqualTo(String value) {
            addCriterion("surface_code <>", value, "surfaceCode");
            return (Criteria) this;
        }

        public Criteria andSurfaceCodeGreaterThan(String value) {
            addCriterion("surface_code >", value, "surfaceCode");
            return (Criteria) this;
        }

        public Criteria andSurfaceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("surface_code >=", value, "surfaceCode");
            return (Criteria) this;
        }

        public Criteria andSurfaceCodeLessThan(String value) {
            addCriterion("surface_code <", value, "surfaceCode");
            return (Criteria) this;
        }

        public Criteria andSurfaceCodeLessThanOrEqualTo(String value) {
            addCriterion("surface_code <=", value, "surfaceCode");
            return (Criteria) this;
        }

        public Criteria andSurfaceCodeLike(String value) {
            addCriterion("surface_code like", value, "surfaceCode");
            return (Criteria) this;
        }

        public Criteria andSurfaceCodeNotLike(String value) {
            addCriterion("surface_code not like", value, "surfaceCode");
            return (Criteria) this;
        }

        public Criteria andSurfaceCodeIn(List<String> values) {
            addCriterion("surface_code in", values, "surfaceCode");
            return (Criteria) this;
        }

        public Criteria andSurfaceCodeNotIn(List<String> values) {
            addCriterion("surface_code not in", values, "surfaceCode");
            return (Criteria) this;
        }

        public Criteria andSurfaceCodeBetween(String value1, String value2) {
            addCriterion("surface_code between", value1, value2, "surfaceCode");
            return (Criteria) this;
        }

        public Criteria andSurfaceCodeNotBetween(String value1, String value2) {
            addCriterion("surface_code not between", value1, value2, "surfaceCode");
            return (Criteria) this;
        }

        public Criteria andThicknessCodeIsNull() {
            addCriterion("thickness_code is null");
            return (Criteria) this;
        }

        public Criteria andThicknessCodeIsNotNull() {
            addCriterion("thickness_code is not null");
            return (Criteria) this;
        }

        public Criteria andThicknessCodeEqualTo(String value) {
            addCriterion("thickness_code =", value, "thicknessCode");
            return (Criteria) this;
        }

        public Criteria andThicknessCodeNotEqualTo(String value) {
            addCriterion("thickness_code <>", value, "thicknessCode");
            return (Criteria) this;
        }

        public Criteria andThicknessCodeGreaterThan(String value) {
            addCriterion("thickness_code >", value, "thicknessCode");
            return (Criteria) this;
        }

        public Criteria andThicknessCodeGreaterThanOrEqualTo(String value) {
            addCriterion("thickness_code >=", value, "thicknessCode");
            return (Criteria) this;
        }

        public Criteria andThicknessCodeLessThan(String value) {
            addCriterion("thickness_code <", value, "thicknessCode");
            return (Criteria) this;
        }

        public Criteria andThicknessCodeLessThanOrEqualTo(String value) {
            addCriterion("thickness_code <=", value, "thicknessCode");
            return (Criteria) this;
        }

        public Criteria andThicknessCodeLike(String value) {
            addCriterion("thickness_code like", value, "thicknessCode");
            return (Criteria) this;
        }

        public Criteria andThicknessCodeNotLike(String value) {
            addCriterion("thickness_code not like", value, "thicknessCode");
            return (Criteria) this;
        }

        public Criteria andThicknessCodeIn(List<String> values) {
            addCriterion("thickness_code in", values, "thicknessCode");
            return (Criteria) this;
        }

        public Criteria andThicknessCodeNotIn(List<String> values) {
            addCriterion("thickness_code not in", values, "thicknessCode");
            return (Criteria) this;
        }

        public Criteria andThicknessCodeBetween(String value1, String value2) {
            addCriterion("thickness_code between", value1, value2, "thicknessCode");
            return (Criteria) this;
        }

        public Criteria andThicknessCodeNotBetween(String value1, String value2) {
            addCriterion("thickness_code not between", value1, value2, "thicknessCode");
            return (Criteria) this;
        }

        public Criteria andLengthWidthCodeIsNull() {
            addCriterion("length_width_code is null");
            return (Criteria) this;
        }

        public Criteria andLengthWidthCodeIsNotNull() {
            addCriterion("length_width_code is not null");
            return (Criteria) this;
        }

        public Criteria andLengthWidthCodeEqualTo(String value) {
            addCriterion("length_width_code =", value, "lengthWidthCode");
            return (Criteria) this;
        }

        public Criteria andLengthWidthCodeNotEqualTo(String value) {
            addCriterion("length_width_code <>", value, "lengthWidthCode");
            return (Criteria) this;
        }

        public Criteria andLengthWidthCodeGreaterThan(String value) {
            addCriterion("length_width_code >", value, "lengthWidthCode");
            return (Criteria) this;
        }

        public Criteria andLengthWidthCodeGreaterThanOrEqualTo(String value) {
            addCriterion("length_width_code >=", value, "lengthWidthCode");
            return (Criteria) this;
        }

        public Criteria andLengthWidthCodeLessThan(String value) {
            addCriterion("length_width_code <", value, "lengthWidthCode");
            return (Criteria) this;
        }

        public Criteria andLengthWidthCodeLessThanOrEqualTo(String value) {
            addCriterion("length_width_code <=", value, "lengthWidthCode");
            return (Criteria) this;
        }

        public Criteria andLengthWidthCodeLike(String value) {
            addCriterion("length_width_code like", value, "lengthWidthCode");
            return (Criteria) this;
        }

        public Criteria andLengthWidthCodeNotLike(String value) {
            addCriterion("length_width_code not like", value, "lengthWidthCode");
            return (Criteria) this;
        }

        public Criteria andLengthWidthCodeIn(List<String> values) {
            addCriterion("length_width_code in", values, "lengthWidthCode");
            return (Criteria) this;
        }

        public Criteria andLengthWidthCodeNotIn(List<String> values) {
            addCriterion("length_width_code not in", values, "lengthWidthCode");
            return (Criteria) this;
        }

        public Criteria andLengthWidthCodeBetween(String value1, String value2) {
            addCriterion("length_width_code between", value1, value2, "lengthWidthCode");
            return (Criteria) this;
        }

        public Criteria andLengthWidthCodeNotBetween(String value1, String value2) {
            addCriterion("length_width_code not between", value1, value2, "lengthWidthCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeIsNull() {
            addCriterion("material_code is null");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeIsNotNull() {
            addCriterion("material_code is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeEqualTo(String value) {
            addCriterion("material_code =", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotEqualTo(String value) {
            addCriterion("material_code <>", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeGreaterThan(String value) {
            addCriterion("material_code >", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeGreaterThanOrEqualTo(String value) {
            addCriterion("material_code >=", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLessThan(String value) {
            addCriterion("material_code <", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLessThanOrEqualTo(String value) {
            addCriterion("material_code <=", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLike(String value) {
            addCriterion("material_code like", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotLike(String value) {
            addCriterion("material_code not like", value, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeIn(List<String> values) {
            addCriterion("material_code in", values, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotIn(List<String> values) {
            addCriterion("material_code not in", values, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeBetween(String value1, String value2) {
            addCriterion("material_code between", value1, value2, "materialCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeNotBetween(String value1, String value2) {
            addCriterion("material_code not between", value1, value2, "materialCode");
            return (Criteria) this;
        }

        public Criteria andCenterFrequencyIsNull() {
            addCriterion("center_frequency is null");
            return (Criteria) this;
        }

        public Criteria andCenterFrequencyIsNotNull() {
            addCriterion("center_frequency is not null");
            return (Criteria) this;
        }

        public Criteria andCenterFrequencyEqualTo(String value) {
            addCriterion("center_frequency =", value, "centerFrequency");
            return (Criteria) this;
        }

        public Criteria andCenterFrequencyNotEqualTo(String value) {
            addCriterion("center_frequency <>", value, "centerFrequency");
            return (Criteria) this;
        }

        public Criteria andCenterFrequencyGreaterThan(String value) {
            addCriterion("center_frequency >", value, "centerFrequency");
            return (Criteria) this;
        }

        public Criteria andCenterFrequencyGreaterThanOrEqualTo(String value) {
            addCriterion("center_frequency >=", value, "centerFrequency");
            return (Criteria) this;
        }

        public Criteria andCenterFrequencyLessThan(String value) {
            addCriterion("center_frequency <", value, "centerFrequency");
            return (Criteria) this;
        }

        public Criteria andCenterFrequencyLessThanOrEqualTo(String value) {
            addCriterion("center_frequency <=", value, "centerFrequency");
            return (Criteria) this;
        }

        public Criteria andCenterFrequencyLike(String value) {
            addCriterion("center_frequency like", value, "centerFrequency");
            return (Criteria) this;
        }

        public Criteria andCenterFrequencyNotLike(String value) {
            addCriterion("center_frequency not like", value, "centerFrequency");
            return (Criteria) this;
        }

        public Criteria andCenterFrequencyIn(List<String> values) {
            addCriterion("center_frequency in", values, "centerFrequency");
            return (Criteria) this;
        }

        public Criteria andCenterFrequencyNotIn(List<String> values) {
            addCriterion("center_frequency not in", values, "centerFrequency");
            return (Criteria) this;
        }

        public Criteria andCenterFrequencyBetween(String value1, String value2) {
            addCriterion("center_frequency between", value1, value2, "centerFrequency");
            return (Criteria) this;
        }

        public Criteria andCenterFrequencyNotBetween(String value1, String value2) {
            addCriterion("center_frequency not between", value1, value2, "centerFrequency");
            return (Criteria) this;
        }

        public Criteria andPassBandRangeIsNull() {
            addCriterion("pass_band_range is null");
            return (Criteria) this;
        }

        public Criteria andPassBandRangeIsNotNull() {
            addCriterion("pass_band_range is not null");
            return (Criteria) this;
        }

        public Criteria andPassBandRangeEqualTo(String value) {
            addCriterion("pass_band_range =", value, "passBandRange");
            return (Criteria) this;
        }

        public Criteria andPassBandRangeNotEqualTo(String value) {
            addCriterion("pass_band_range <>", value, "passBandRange");
            return (Criteria) this;
        }

        public Criteria andPassBandRangeGreaterThan(String value) {
            addCriterion("pass_band_range >", value, "passBandRange");
            return (Criteria) this;
        }

        public Criteria andPassBandRangeGreaterThanOrEqualTo(String value) {
            addCriterion("pass_band_range >=", value, "passBandRange");
            return (Criteria) this;
        }

        public Criteria andPassBandRangeLessThan(String value) {
            addCriterion("pass_band_range <", value, "passBandRange");
            return (Criteria) this;
        }

        public Criteria andPassBandRangeLessThanOrEqualTo(String value) {
            addCriterion("pass_band_range <=", value, "passBandRange");
            return (Criteria) this;
        }

        public Criteria andPassBandRangeLike(String value) {
            addCriterion("pass_band_range like", value, "passBandRange");
            return (Criteria) this;
        }

        public Criteria andPassBandRangeNotLike(String value) {
            addCriterion("pass_band_range not like", value, "passBandRange");
            return (Criteria) this;
        }

        public Criteria andPassBandRangeIn(List<String> values) {
            addCriterion("pass_band_range in", values, "passBandRange");
            return (Criteria) this;
        }

        public Criteria andPassBandRangeNotIn(List<String> values) {
            addCriterion("pass_band_range not in", values, "passBandRange");
            return (Criteria) this;
        }

        public Criteria andPassBandRangeBetween(String value1, String value2) {
            addCriterion("pass_band_range between", value1, value2, "passBandRange");
            return (Criteria) this;
        }

        public Criteria andPassBandRangeNotBetween(String value1, String value2) {
            addCriterion("pass_band_range not between", value1, value2, "passBandRange");
            return (Criteria) this;
        }

        public Criteria andOtherIsNull() {
            addCriterion("other is null");
            return (Criteria) this;
        }

        public Criteria andOtherIsNotNull() {
            addCriterion("other is not null");
            return (Criteria) this;
        }

        public Criteria andOtherEqualTo(String value) {
            addCriterion("other =", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotEqualTo(String value) {
            addCriterion("other <>", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThan(String value) {
            addCriterion("other >", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThanOrEqualTo(String value) {
            addCriterion("other >=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThan(String value) {
            addCriterion("other <", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThanOrEqualTo(String value) {
            addCriterion("other <=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLike(String value) {
            addCriterion("other like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotLike(String value) {
            addCriterion("other not like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherIn(List<String> values) {
            addCriterion("other in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotIn(List<String> values) {
            addCriterion("other not in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherBetween(String value1, String value2) {
            addCriterion("other between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotBetween(String value1, String value2) {
            addCriterion("other not between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andRippleIsNull() {
            addCriterion("ripple is null");
            return (Criteria) this;
        }

        public Criteria andRippleIsNotNull() {
            addCriterion("ripple is not null");
            return (Criteria) this;
        }

        public Criteria andRippleEqualTo(String value) {
            addCriterion("ripple =", value, "ripple");
            return (Criteria) this;
        }

        public Criteria andRippleNotEqualTo(String value) {
            addCriterion("ripple <>", value, "ripple");
            return (Criteria) this;
        }

        public Criteria andRippleGreaterThan(String value) {
            addCriterion("ripple >", value, "ripple");
            return (Criteria) this;
        }

        public Criteria andRippleGreaterThanOrEqualTo(String value) {
            addCriterion("ripple >=", value, "ripple");
            return (Criteria) this;
        }

        public Criteria andRippleLessThan(String value) {
            addCriterion("ripple <", value, "ripple");
            return (Criteria) this;
        }

        public Criteria andRippleLessThanOrEqualTo(String value) {
            addCriterion("ripple <=", value, "ripple");
            return (Criteria) this;
        }

        public Criteria andRippleLike(String value) {
            addCriterion("ripple like", value, "ripple");
            return (Criteria) this;
        }

        public Criteria andRippleNotLike(String value) {
            addCriterion("ripple not like", value, "ripple");
            return (Criteria) this;
        }

        public Criteria andRippleIn(List<String> values) {
            addCriterion("ripple in", values, "ripple");
            return (Criteria) this;
        }

        public Criteria andRippleNotIn(List<String> values) {
            addCriterion("ripple not in", values, "ripple");
            return (Criteria) this;
        }

        public Criteria andRippleBetween(String value1, String value2) {
            addCriterion("ripple between", value1, value2, "ripple");
            return (Criteria) this;
        }

        public Criteria andRippleNotBetween(String value1, String value2) {
            addCriterion("ripple not between", value1, value2, "ripple");
            return (Criteria) this;
        }

        public Criteria andPowerCapacityIsNull() {
            addCriterion("power_capacity is null");
            return (Criteria) this;
        }

        public Criteria andPowerCapacityIsNotNull() {
            addCriterion("power_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andPowerCapacityEqualTo(String value) {
            addCriterion("power_capacity =", value, "powerCapacity");
            return (Criteria) this;
        }

        public Criteria andPowerCapacityNotEqualTo(String value) {
            addCriterion("power_capacity <>", value, "powerCapacity");
            return (Criteria) this;
        }

        public Criteria andPowerCapacityGreaterThan(String value) {
            addCriterion("power_capacity >", value, "powerCapacity");
            return (Criteria) this;
        }

        public Criteria andPowerCapacityGreaterThanOrEqualTo(String value) {
            addCriterion("power_capacity >=", value, "powerCapacity");
            return (Criteria) this;
        }

        public Criteria andPowerCapacityLessThan(String value) {
            addCriterion("power_capacity <", value, "powerCapacity");
            return (Criteria) this;
        }

        public Criteria andPowerCapacityLessThanOrEqualTo(String value) {
            addCriterion("power_capacity <=", value, "powerCapacity");
            return (Criteria) this;
        }

        public Criteria andPowerCapacityLike(String value) {
            addCriterion("power_capacity like", value, "powerCapacity");
            return (Criteria) this;
        }

        public Criteria andPowerCapacityNotLike(String value) {
            addCriterion("power_capacity not like", value, "powerCapacity");
            return (Criteria) this;
        }

        public Criteria andPowerCapacityIn(List<String> values) {
            addCriterion("power_capacity in", values, "powerCapacity");
            return (Criteria) this;
        }

        public Criteria andPowerCapacityNotIn(List<String> values) {
            addCriterion("power_capacity not in", values, "powerCapacity");
            return (Criteria) this;
        }

        public Criteria andPowerCapacityBetween(String value1, String value2) {
            addCriterion("power_capacity between", value1, value2, "powerCapacity");
            return (Criteria) this;
        }

        public Criteria andPowerCapacityNotBetween(String value1, String value2) {
            addCriterion("power_capacity not between", value1, value2, "powerCapacity");
            return (Criteria) this;
        }

        public Criteria andVswrIsNull() {
            addCriterion("vswr is null");
            return (Criteria) this;
        }

        public Criteria andVswrIsNotNull() {
            addCriterion("vswr is not null");
            return (Criteria) this;
        }

        public Criteria andVswrEqualTo(String value) {
            addCriterion("vswr =", value, "vswr");
            return (Criteria) this;
        }

        public Criteria andVswrNotEqualTo(String value) {
            addCriterion("vswr <>", value, "vswr");
            return (Criteria) this;
        }

        public Criteria andVswrGreaterThan(String value) {
            addCriterion("vswr >", value, "vswr");
            return (Criteria) this;
        }

        public Criteria andVswrGreaterThanOrEqualTo(String value) {
            addCriterion("vswr >=", value, "vswr");
            return (Criteria) this;
        }

        public Criteria andVswrLessThan(String value) {
            addCriterion("vswr <", value, "vswr");
            return (Criteria) this;
        }

        public Criteria andVswrLessThanOrEqualTo(String value) {
            addCriterion("vswr <=", value, "vswr");
            return (Criteria) this;
        }

        public Criteria andVswrLike(String value) {
            addCriterion("vswr like", value, "vswr");
            return (Criteria) this;
        }

        public Criteria andVswrNotLike(String value) {
            addCriterion("vswr not like", value, "vswr");
            return (Criteria) this;
        }

        public Criteria andVswrIn(List<String> values) {
            addCriterion("vswr in", values, "vswr");
            return (Criteria) this;
        }

        public Criteria andVswrNotIn(List<String> values) {
            addCriterion("vswr not in", values, "vswr");
            return (Criteria) this;
        }

        public Criteria andVswrBetween(String value1, String value2) {
            addCriterion("vswr between", value1, value2, "vswr");
            return (Criteria) this;
        }

        public Criteria andVswrNotBetween(String value1, String value2) {
            addCriterion("vswr not between", value1, value2, "vswr");
            return (Criteria) this;
        }

        public Criteria andAmplitudeBalanceIsNull() {
            addCriterion("amplitude_balance is null");
            return (Criteria) this;
        }

        public Criteria andAmplitudeBalanceIsNotNull() {
            addCriterion("amplitude_balance is not null");
            return (Criteria) this;
        }

        public Criteria andAmplitudeBalanceEqualTo(String value) {
            addCriterion("amplitude_balance =", value, "amplitudeBalance");
            return (Criteria) this;
        }

        public Criteria andAmplitudeBalanceNotEqualTo(String value) {
            addCriterion("amplitude_balance <>", value, "amplitudeBalance");
            return (Criteria) this;
        }

        public Criteria andAmplitudeBalanceGreaterThan(String value) {
            addCriterion("amplitude_balance >", value, "amplitudeBalance");
            return (Criteria) this;
        }

        public Criteria andAmplitudeBalanceGreaterThanOrEqualTo(String value) {
            addCriterion("amplitude_balance >=", value, "amplitudeBalance");
            return (Criteria) this;
        }

        public Criteria andAmplitudeBalanceLessThan(String value) {
            addCriterion("amplitude_balance <", value, "amplitudeBalance");
            return (Criteria) this;
        }

        public Criteria andAmplitudeBalanceLessThanOrEqualTo(String value) {
            addCriterion("amplitude_balance <=", value, "amplitudeBalance");
            return (Criteria) this;
        }

        public Criteria andAmplitudeBalanceLike(String value) {
            addCriterion("amplitude_balance like", value, "amplitudeBalance");
            return (Criteria) this;
        }

        public Criteria andAmplitudeBalanceNotLike(String value) {
            addCriterion("amplitude_balance not like", value, "amplitudeBalance");
            return (Criteria) this;
        }

        public Criteria andAmplitudeBalanceIn(List<String> values) {
            addCriterion("amplitude_balance in", values, "amplitudeBalance");
            return (Criteria) this;
        }

        public Criteria andAmplitudeBalanceNotIn(List<String> values) {
            addCriterion("amplitude_balance not in", values, "amplitudeBalance");
            return (Criteria) this;
        }

        public Criteria andAmplitudeBalanceBetween(String value1, String value2) {
            addCriterion("amplitude_balance between", value1, value2, "amplitudeBalance");
            return (Criteria) this;
        }

        public Criteria andAmplitudeBalanceNotBetween(String value1, String value2) {
            addCriterion("amplitude_balance not between", value1, value2, "amplitudeBalance");
            return (Criteria) this;
        }

        public Criteria andPhaseBalanceIsNull() {
            addCriterion("phase_balance is null");
            return (Criteria) this;
        }

        public Criteria andPhaseBalanceIsNotNull() {
            addCriterion("phase_balance is not null");
            return (Criteria) this;
        }

        public Criteria andPhaseBalanceEqualTo(String value) {
            addCriterion("phase_balance =", value, "phaseBalance");
            return (Criteria) this;
        }

        public Criteria andPhaseBalanceNotEqualTo(String value) {
            addCriterion("phase_balance <>", value, "phaseBalance");
            return (Criteria) this;
        }

        public Criteria andPhaseBalanceGreaterThan(String value) {
            addCriterion("phase_balance >", value, "phaseBalance");
            return (Criteria) this;
        }

        public Criteria andPhaseBalanceGreaterThanOrEqualTo(String value) {
            addCriterion("phase_balance >=", value, "phaseBalance");
            return (Criteria) this;
        }

        public Criteria andPhaseBalanceLessThan(String value) {
            addCriterion("phase_balance <", value, "phaseBalance");
            return (Criteria) this;
        }

        public Criteria andPhaseBalanceLessThanOrEqualTo(String value) {
            addCriterion("phase_balance <=", value, "phaseBalance");
            return (Criteria) this;
        }

        public Criteria andPhaseBalanceLike(String value) {
            addCriterion("phase_balance like", value, "phaseBalance");
            return (Criteria) this;
        }

        public Criteria andPhaseBalanceNotLike(String value) {
            addCriterion("phase_balance not like", value, "phaseBalance");
            return (Criteria) this;
        }

        public Criteria andPhaseBalanceIn(List<String> values) {
            addCriterion("phase_balance in", values, "phaseBalance");
            return (Criteria) this;
        }

        public Criteria andPhaseBalanceNotIn(List<String> values) {
            addCriterion("phase_balance not in", values, "phaseBalance");
            return (Criteria) this;
        }

        public Criteria andPhaseBalanceBetween(String value1, String value2) {
            addCriterion("phase_balance between", value1, value2, "phaseBalance");
            return (Criteria) this;
        }

        public Criteria andPhaseBalanceNotBetween(String value1, String value2) {
            addCriterion("phase_balance not between", value1, value2, "phaseBalance");
            return (Criteria) this;
        }

        public Criteria andInsertionLossIsNull() {
            addCriterion("insertion_loss is null");
            return (Criteria) this;
        }

        public Criteria andInsertionLossIsNotNull() {
            addCriterion("insertion_loss is not null");
            return (Criteria) this;
        }

        public Criteria andInsertionLossEqualTo(String value) {
            addCriterion("insertion_loss =", value, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andInsertionLossNotEqualTo(String value) {
            addCriterion("insertion_loss <>", value, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andInsertionLossGreaterThan(String value) {
            addCriterion("insertion_loss >", value, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andInsertionLossGreaterThanOrEqualTo(String value) {
            addCriterion("insertion_loss >=", value, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andInsertionLossLessThan(String value) {
            addCriterion("insertion_loss <", value, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andInsertionLossLessThanOrEqualTo(String value) {
            addCriterion("insertion_loss <=", value, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andInsertionLossLike(String value) {
            addCriterion("insertion_loss like", value, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andInsertionLossNotLike(String value) {
            addCriterion("insertion_loss not like", value, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andInsertionLossIn(List<String> values) {
            addCriterion("insertion_loss in", values, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andInsertionLossNotIn(List<String> values) {
            addCriterion("insertion_loss not in", values, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andInsertionLossBetween(String value1, String value2) {
            addCriterion("insertion_loss between", value1, value2, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andInsertionLossNotBetween(String value1, String value2) {
            addCriterion("insertion_loss not between", value1, value2, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andIsolationIsNull() {
            addCriterion("isolation is null");
            return (Criteria) this;
        }

        public Criteria andIsolationIsNotNull() {
            addCriterion("isolation is not null");
            return (Criteria) this;
        }

        public Criteria andIsolationEqualTo(String value) {
            addCriterion("isolation =", value, "isolation");
            return (Criteria) this;
        }

        public Criteria andIsolationNotEqualTo(String value) {
            addCriterion("isolation <>", value, "isolation");
            return (Criteria) this;
        }

        public Criteria andIsolationGreaterThan(String value) {
            addCriterion("isolation >", value, "isolation");
            return (Criteria) this;
        }

        public Criteria andIsolationGreaterThanOrEqualTo(String value) {
            addCriterion("isolation >=", value, "isolation");
            return (Criteria) this;
        }

        public Criteria andIsolationLessThan(String value) {
            addCriterion("isolation <", value, "isolation");
            return (Criteria) this;
        }

        public Criteria andIsolationLessThanOrEqualTo(String value) {
            addCriterion("isolation <=", value, "isolation");
            return (Criteria) this;
        }

        public Criteria andIsolationLike(String value) {
            addCriterion("isolation like", value, "isolation");
            return (Criteria) this;
        }

        public Criteria andIsolationNotLike(String value) {
            addCriterion("isolation not like", value, "isolation");
            return (Criteria) this;
        }

        public Criteria andIsolationIn(List<String> values) {
            addCriterion("isolation in", values, "isolation");
            return (Criteria) this;
        }

        public Criteria andIsolationNotIn(List<String> values) {
            addCriterion("isolation not in", values, "isolation");
            return (Criteria) this;
        }

        public Criteria andIsolationBetween(String value1, String value2) {
            addCriterion("isolation between", value1, value2, "isolation");
            return (Criteria) this;
        }

        public Criteria andIsolationNotBetween(String value1, String value2) {
            addCriterion("isolation not between", value1, value2, "isolation");
            return (Criteria) this;
        }

        public Criteria andFrequencyRangeIsNull() {
            addCriterion("frequency_range is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyRangeIsNotNull() {
            addCriterion("frequency_range is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyRangeEqualTo(String value) {
            addCriterion("frequency_range =", value, "frequencyRange");
            return (Criteria) this;
        }

        public Criteria andFrequencyRangeNotEqualTo(String value) {
            addCriterion("frequency_range <>", value, "frequencyRange");
            return (Criteria) this;
        }

        public Criteria andFrequencyRangeGreaterThan(String value) {
            addCriterion("frequency_range >", value, "frequencyRange");
            return (Criteria) this;
        }

        public Criteria andFrequencyRangeGreaterThanOrEqualTo(String value) {
            addCriterion("frequency_range >=", value, "frequencyRange");
            return (Criteria) this;
        }

        public Criteria andFrequencyRangeLessThan(String value) {
            addCriterion("frequency_range <", value, "frequencyRange");
            return (Criteria) this;
        }

        public Criteria andFrequencyRangeLessThanOrEqualTo(String value) {
            addCriterion("frequency_range <=", value, "frequencyRange");
            return (Criteria) this;
        }

        public Criteria andFrequencyRangeLike(String value) {
            addCriterion("frequency_range like", value, "frequencyRange");
            return (Criteria) this;
        }

        public Criteria andFrequencyRangeNotLike(String value) {
            addCriterion("frequency_range not like", value, "frequencyRange");
            return (Criteria) this;
        }

        public Criteria andFrequencyRangeIn(List<String> values) {
            addCriterion("frequency_range in", values, "frequencyRange");
            return (Criteria) this;
        }

        public Criteria andFrequencyRangeNotIn(List<String> values) {
            addCriterion("frequency_range not in", values, "frequencyRange");
            return (Criteria) this;
        }

        public Criteria andFrequencyRangeBetween(String value1, String value2) {
            addCriterion("frequency_range between", value1, value2, "frequencyRange");
            return (Criteria) this;
        }

        public Criteria andFrequencyRangeNotBetween(String value1, String value2) {
            addCriterion("frequency_range not between", value1, value2, "frequencyRange");
            return (Criteria) this;
        }

        public Criteria andVswrStopBandIsNull() {
            addCriterion("vswr_stop_band is null");
            return (Criteria) this;
        }

        public Criteria andVswrStopBandIsNotNull() {
            addCriterion("vswr_stop_band is not null");
            return (Criteria) this;
        }

        public Criteria andVswrStopBandEqualTo(String value) {
            addCriterion("vswr_stop_band =", value, "vswrStopBand");
            return (Criteria) this;
        }

        public Criteria andVswrStopBandNotEqualTo(String value) {
            addCriterion("vswr_stop_band <>", value, "vswrStopBand");
            return (Criteria) this;
        }

        public Criteria andVswrStopBandGreaterThan(String value) {
            addCriterion("vswr_stop_band >", value, "vswrStopBand");
            return (Criteria) this;
        }

        public Criteria andVswrStopBandGreaterThanOrEqualTo(String value) {
            addCriterion("vswr_stop_band >=", value, "vswrStopBand");
            return (Criteria) this;
        }

        public Criteria andVswrStopBandLessThan(String value) {
            addCriterion("vswr_stop_band <", value, "vswrStopBand");
            return (Criteria) this;
        }

        public Criteria andVswrStopBandLessThanOrEqualTo(String value) {
            addCriterion("vswr_stop_band <=", value, "vswrStopBand");
            return (Criteria) this;
        }

        public Criteria andVswrStopBandLike(String value) {
            addCriterion("vswr_stop_band like", value, "vswrStopBand");
            return (Criteria) this;
        }

        public Criteria andVswrStopBandNotLike(String value) {
            addCriterion("vswr_stop_band not like", value, "vswrStopBand");
            return (Criteria) this;
        }

        public Criteria andVswrStopBandIn(List<String> values) {
            addCriterion("vswr_stop_band in", values, "vswrStopBand");
            return (Criteria) this;
        }

        public Criteria andVswrStopBandNotIn(List<String> values) {
            addCriterion("vswr_stop_band not in", values, "vswrStopBand");
            return (Criteria) this;
        }

        public Criteria andVswrStopBandBetween(String value1, String value2) {
            addCriterion("vswr_stop_band between", value1, value2, "vswrStopBand");
            return (Criteria) this;
        }

        public Criteria andVswrStopBandNotBetween(String value1, String value2) {
            addCriterion("vswr_stop_band not between", value1, value2, "vswrStopBand");
            return (Criteria) this;
        }

        public Criteria andVswrPassBandIsNull() {
            addCriterion("vswr_pass_Band is null");
            return (Criteria) this;
        }

        public Criteria andVswrPassBandIsNotNull() {
            addCriterion("vswr_pass_Band is not null");
            return (Criteria) this;
        }

        public Criteria andVswrPassBandEqualTo(String value) {
            addCriterion("vswr_pass_Band =", value, "vswrPassBand");
            return (Criteria) this;
        }

        public Criteria andVswrPassBandNotEqualTo(String value) {
            addCriterion("vswr_pass_Band <>", value, "vswrPassBand");
            return (Criteria) this;
        }

        public Criteria andVswrPassBandGreaterThan(String value) {
            addCriterion("vswr_pass_Band >", value, "vswrPassBand");
            return (Criteria) this;
        }

        public Criteria andVswrPassBandGreaterThanOrEqualTo(String value) {
            addCriterion("vswr_pass_Band >=", value, "vswrPassBand");
            return (Criteria) this;
        }

        public Criteria andVswrPassBandLessThan(String value) {
            addCriterion("vswr_pass_Band <", value, "vswrPassBand");
            return (Criteria) this;
        }

        public Criteria andVswrPassBandLessThanOrEqualTo(String value) {
            addCriterion("vswr_pass_Band <=", value, "vswrPassBand");
            return (Criteria) this;
        }

        public Criteria andVswrPassBandLike(String value) {
            addCriterion("vswr_pass_Band like", value, "vswrPassBand");
            return (Criteria) this;
        }

        public Criteria andVswrPassBandNotLike(String value) {
            addCriterion("vswr_pass_Band not like", value, "vswrPassBand");
            return (Criteria) this;
        }

        public Criteria andVswrPassBandIn(List<String> values) {
            addCriterion("vswr_pass_Band in", values, "vswrPassBand");
            return (Criteria) this;
        }

        public Criteria andVswrPassBandNotIn(List<String> values) {
            addCriterion("vswr_pass_Band not in", values, "vswrPassBand");
            return (Criteria) this;
        }

        public Criteria andVswrPassBandBetween(String value1, String value2) {
            addCriterion("vswr_pass_Band between", value1, value2, "vswrPassBand");
            return (Criteria) this;
        }

        public Criteria andVswrPassBandNotBetween(String value1, String value2) {
            addCriterion("vswr_pass_Band not between", value1, value2, "vswrPassBand");
            return (Criteria) this;
        }

        public Criteria andStopBandIsNull() {
            addCriterion("stop_band is null");
            return (Criteria) this;
        }

        public Criteria andStopBandIsNotNull() {
            addCriterion("stop_band is not null");
            return (Criteria) this;
        }

        public Criteria andStopBandEqualTo(String value) {
            addCriterion("stop_band =", value, "stopBand");
            return (Criteria) this;
        }

        public Criteria andStopBandNotEqualTo(String value) {
            addCriterion("stop_band <>", value, "stopBand");
            return (Criteria) this;
        }

        public Criteria andStopBandGreaterThan(String value) {
            addCriterion("stop_band >", value, "stopBand");
            return (Criteria) this;
        }

        public Criteria andStopBandGreaterThanOrEqualTo(String value) {
            addCriterion("stop_band >=", value, "stopBand");
            return (Criteria) this;
        }

        public Criteria andStopBandLessThan(String value) {
            addCriterion("stop_band <", value, "stopBand");
            return (Criteria) this;
        }

        public Criteria andStopBandLessThanOrEqualTo(String value) {
            addCriterion("stop_band <=", value, "stopBand");
            return (Criteria) this;
        }

        public Criteria andStopBandLike(String value) {
            addCriterion("stop_band like", value, "stopBand");
            return (Criteria) this;
        }

        public Criteria andStopBandNotLike(String value) {
            addCriterion("stop_band not like", value, "stopBand");
            return (Criteria) this;
        }

        public Criteria andStopBandIn(List<String> values) {
            addCriterion("stop_band in", values, "stopBand");
            return (Criteria) this;
        }

        public Criteria andStopBandNotIn(List<String> values) {
            addCriterion("stop_band not in", values, "stopBand");
            return (Criteria) this;
        }

        public Criteria andStopBandBetween(String value1, String value2) {
            addCriterion("stop_band between", value1, value2, "stopBand");
            return (Criteria) this;
        }

        public Criteria andStopBandNotBetween(String value1, String value2) {
            addCriterion("stop_band not between", value1, value2, "stopBand");
            return (Criteria) this;
        }

        public Criteria andCutOffFrequencyIsNull() {
            addCriterion("cut_off_frequency is null");
            return (Criteria) this;
        }

        public Criteria andCutOffFrequencyIsNotNull() {
            addCriterion("cut_off_frequency is not null");
            return (Criteria) this;
        }

        public Criteria andCutOffFrequencyEqualTo(String value) {
            addCriterion("cut_off_frequency =", value, "cutOffFrequency");
            return (Criteria) this;
        }

        public Criteria andCutOffFrequencyNotEqualTo(String value) {
            addCriterion("cut_off_frequency <>", value, "cutOffFrequency");
            return (Criteria) this;
        }

        public Criteria andCutOffFrequencyGreaterThan(String value) {
            addCriterion("cut_off_frequency >", value, "cutOffFrequency");
            return (Criteria) this;
        }

        public Criteria andCutOffFrequencyGreaterThanOrEqualTo(String value) {
            addCriterion("cut_off_frequency >=", value, "cutOffFrequency");
            return (Criteria) this;
        }

        public Criteria andCutOffFrequencyLessThan(String value) {
            addCriterion("cut_off_frequency <", value, "cutOffFrequency");
            return (Criteria) this;
        }

        public Criteria andCutOffFrequencyLessThanOrEqualTo(String value) {
            addCriterion("cut_off_frequency <=", value, "cutOffFrequency");
            return (Criteria) this;
        }

        public Criteria andCutOffFrequencyLike(String value) {
            addCriterion("cut_off_frequency like", value, "cutOffFrequency");
            return (Criteria) this;
        }

        public Criteria andCutOffFrequencyNotLike(String value) {
            addCriterion("cut_off_frequency not like", value, "cutOffFrequency");
            return (Criteria) this;
        }

        public Criteria andCutOffFrequencyIn(List<String> values) {
            addCriterion("cut_off_frequency in", values, "cutOffFrequency");
            return (Criteria) this;
        }

        public Criteria andCutOffFrequencyNotIn(List<String> values) {
            addCriterion("cut_off_frequency not in", values, "cutOffFrequency");
            return (Criteria) this;
        }

        public Criteria andCutOffFrequencyBetween(String value1, String value2) {
            addCriterion("cut_off_frequency between", value1, value2, "cutOffFrequency");
            return (Criteria) this;
        }

        public Criteria andCutOffFrequencyNotBetween(String value1, String value2) {
            addCriterion("cut_off_frequency not between", value1, value2, "cutOffFrequency");
            return (Criteria) this;
        }

        public Criteria andPassBandInsertionLossIsNull() {
            addCriterion("pass_band_insertion_loss is null");
            return (Criteria) this;
        }

        public Criteria andPassBandInsertionLossIsNotNull() {
            addCriterion("pass_band_insertion_loss is not null");
            return (Criteria) this;
        }

        public Criteria andPassBandInsertionLossEqualTo(String value) {
            addCriterion("pass_band_insertion_loss =", value, "passBandInsertionLoss");
            return (Criteria) this;
        }

        public Criteria andPassBandInsertionLossNotEqualTo(String value) {
            addCriterion("pass_band_insertion_loss <>", value, "passBandInsertionLoss");
            return (Criteria) this;
        }

        public Criteria andPassBandInsertionLossGreaterThan(String value) {
            addCriterion("pass_band_insertion_loss >", value, "passBandInsertionLoss");
            return (Criteria) this;
        }

        public Criteria andPassBandInsertionLossGreaterThanOrEqualTo(String value) {
            addCriterion("pass_band_insertion_loss >=", value, "passBandInsertionLoss");
            return (Criteria) this;
        }

        public Criteria andPassBandInsertionLossLessThan(String value) {
            addCriterion("pass_band_insertion_loss <", value, "passBandInsertionLoss");
            return (Criteria) this;
        }

        public Criteria andPassBandInsertionLossLessThanOrEqualTo(String value) {
            addCriterion("pass_band_insertion_loss <=", value, "passBandInsertionLoss");
            return (Criteria) this;
        }

        public Criteria andPassBandInsertionLossLike(String value) {
            addCriterion("pass_band_insertion_loss like", value, "passBandInsertionLoss");
            return (Criteria) this;
        }

        public Criteria andPassBandInsertionLossNotLike(String value) {
            addCriterion("pass_band_insertion_loss not like", value, "passBandInsertionLoss");
            return (Criteria) this;
        }

        public Criteria andPassBandInsertionLossIn(List<String> values) {
            addCriterion("pass_band_insertion_loss in", values, "passBandInsertionLoss");
            return (Criteria) this;
        }

        public Criteria andPassBandInsertionLossNotIn(List<String> values) {
            addCriterion("pass_band_insertion_loss not in", values, "passBandInsertionLoss");
            return (Criteria) this;
        }

        public Criteria andPassBandInsertionLossBetween(String value1, String value2) {
            addCriterion("pass_band_insertion_loss between", value1, value2, "passBandInsertionLoss");
            return (Criteria) this;
        }

        public Criteria andPassBandInsertionLossNotBetween(String value1, String value2) {
            addCriterion("pass_band_insertion_loss not between", value1, value2, "passBandInsertionLoss");
            return (Criteria) this;
        }

        public Criteria andBreakdownVoltageIsNull() {
            addCriterion("breakdown_voltage is null");
            return (Criteria) this;
        }

        public Criteria andBreakdownVoltageIsNotNull() {
            addCriterion("breakdown_voltage is not null");
            return (Criteria) this;
        }

        public Criteria andBreakdownVoltageEqualTo(String value) {
            addCriterion("breakdown_voltage =", value, "breakdownVoltage");
            return (Criteria) this;
        }

        public Criteria andBreakdownVoltageNotEqualTo(String value) {
            addCriterion("breakdown_voltage <>", value, "breakdownVoltage");
            return (Criteria) this;
        }

        public Criteria andBreakdownVoltageGreaterThan(String value) {
            addCriterion("breakdown_voltage >", value, "breakdownVoltage");
            return (Criteria) this;
        }

        public Criteria andBreakdownVoltageGreaterThanOrEqualTo(String value) {
            addCriterion("breakdown_voltage >=", value, "breakdownVoltage");
            return (Criteria) this;
        }

        public Criteria andBreakdownVoltageLessThan(String value) {
            addCriterion("breakdown_voltage <", value, "breakdownVoltage");
            return (Criteria) this;
        }

        public Criteria andBreakdownVoltageLessThanOrEqualTo(String value) {
            addCriterion("breakdown_voltage <=", value, "breakdownVoltage");
            return (Criteria) this;
        }

        public Criteria andBreakdownVoltageLike(String value) {
            addCriterion("breakdown_voltage like", value, "breakdownVoltage");
            return (Criteria) this;
        }

        public Criteria andBreakdownVoltageNotLike(String value) {
            addCriterion("breakdown_voltage not like", value, "breakdownVoltage");
            return (Criteria) this;
        }

        public Criteria andBreakdownVoltageIn(List<String> values) {
            addCriterion("breakdown_voltage in", values, "breakdownVoltage");
            return (Criteria) this;
        }

        public Criteria andBreakdownVoltageNotIn(List<String> values) {
            addCriterion("breakdown_voltage not in", values, "breakdownVoltage");
            return (Criteria) this;
        }

        public Criteria andBreakdownVoltageBetween(String value1, String value2) {
            addCriterion("breakdown_voltage between", value1, value2, "breakdownVoltage");
            return (Criteria) this;
        }

        public Criteria andBreakdownVoltageNotBetween(String value1, String value2) {
            addCriterion("breakdown_voltage not between", value1, value2, "breakdownVoltage");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceIsNull() {
            addCriterion("insulation_resistance is null");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceIsNotNull() {
            addCriterion("insulation_resistance is not null");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceEqualTo(String value) {
            addCriterion("insulation_resistance =", value, "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceNotEqualTo(String value) {
            addCriterion("insulation_resistance <>", value, "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceGreaterThan(String value) {
            addCriterion("insulation_resistance >", value, "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceGreaterThanOrEqualTo(String value) {
            addCriterion("insulation_resistance >=", value, "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceLessThan(String value) {
            addCriterion("insulation_resistance <", value, "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceLessThanOrEqualTo(String value) {
            addCriterion("insulation_resistance <=", value, "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceLike(String value) {
            addCriterion("insulation_resistance like", value, "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceNotLike(String value) {
            addCriterion("insulation_resistance not like", value, "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceIn(List<String> values) {
            addCriterion("insulation_resistance in", values, "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceNotIn(List<String> values) {
            addCriterion("insulation_resistance not in", values, "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBetween(String value1, String value2) {
            addCriterion("insulation_resistance between", value1, value2, "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceNotBetween(String value1, String value2) {
            addCriterion("insulation_resistance not between", value1, value2, "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andFlexureStrengthIsNull() {
            addCriterion("flexure_strength is null");
            return (Criteria) this;
        }

        public Criteria andFlexureStrengthIsNotNull() {
            addCriterion("flexure_strength is not null");
            return (Criteria) this;
        }

        public Criteria andFlexureStrengthEqualTo(String value) {
            addCriterion("flexure_strength =", value, "flexureStrength");
            return (Criteria) this;
        }

        public Criteria andFlexureStrengthNotEqualTo(String value) {
            addCriterion("flexure_strength <>", value, "flexureStrength");
            return (Criteria) this;
        }

        public Criteria andFlexureStrengthGreaterThan(String value) {
            addCriterion("flexure_strength >", value, "flexureStrength");
            return (Criteria) this;
        }

        public Criteria andFlexureStrengthGreaterThanOrEqualTo(String value) {
            addCriterion("flexure_strength >=", value, "flexureStrength");
            return (Criteria) this;
        }

        public Criteria andFlexureStrengthLessThan(String value) {
            addCriterion("flexure_strength <", value, "flexureStrength");
            return (Criteria) this;
        }

        public Criteria andFlexureStrengthLessThanOrEqualTo(String value) {
            addCriterion("flexure_strength <=", value, "flexureStrength");
            return (Criteria) this;
        }

        public Criteria andFlexureStrengthLike(String value) {
            addCriterion("flexure_strength like", value, "flexureStrength");
            return (Criteria) this;
        }

        public Criteria andFlexureStrengthNotLike(String value) {
            addCriterion("flexure_strength not like", value, "flexureStrength");
            return (Criteria) this;
        }

        public Criteria andFlexureStrengthIn(List<String> values) {
            addCriterion("flexure_strength in", values, "flexureStrength");
            return (Criteria) this;
        }

        public Criteria andFlexureStrengthNotIn(List<String> values) {
            addCriterion("flexure_strength not in", values, "flexureStrength");
            return (Criteria) this;
        }

        public Criteria andFlexureStrengthBetween(String value1, String value2) {
            addCriterion("flexure_strength between", value1, value2, "flexureStrength");
            return (Criteria) this;
        }

        public Criteria andFlexureStrengthNotBetween(String value1, String value2) {
            addCriterion("flexure_strength not between", value1, value2, "flexureStrength");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy20gIsNull() {
            addCriterion("dielectric_loss_by20G is null");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy20gIsNotNull() {
            addCriterion("dielectric_loss_by20G is not null");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy20gEqualTo(String value) {
            addCriterion("dielectric_loss_by20G =", value, "dielectricLossBy20g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy20gNotEqualTo(String value) {
            addCriterion("dielectric_loss_by20G <>", value, "dielectricLossBy20g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy20gGreaterThan(String value) {
            addCriterion("dielectric_loss_by20G >", value, "dielectricLossBy20g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy20gGreaterThanOrEqualTo(String value) {
            addCriterion("dielectric_loss_by20G >=", value, "dielectricLossBy20g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy20gLessThan(String value) {
            addCriterion("dielectric_loss_by20G <", value, "dielectricLossBy20g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy20gLessThanOrEqualTo(String value) {
            addCriterion("dielectric_loss_by20G <=", value, "dielectricLossBy20g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy20gLike(String value) {
            addCriterion("dielectric_loss_by20G like", value, "dielectricLossBy20g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy20gNotLike(String value) {
            addCriterion("dielectric_loss_by20G not like", value, "dielectricLossBy20g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy20gIn(List<String> values) {
            addCriterion("dielectric_loss_by20G in", values, "dielectricLossBy20g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy20gNotIn(List<String> values) {
            addCriterion("dielectric_loss_by20G not in", values, "dielectricLossBy20g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy20gBetween(String value1, String value2) {
            addCriterion("dielectric_loss_by20G between", value1, value2, "dielectricLossBy20g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy20gNotBetween(String value1, String value2) {
            addCriterion("dielectric_loss_by20G not between", value1, value2, "dielectricLossBy20g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy19gIsNull() {
            addCriterion("dielectric_loss_by1_9G is null");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy19gIsNotNull() {
            addCriterion("dielectric_loss_by1_9G is not null");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy19gEqualTo(String value) {
            addCriterion("dielectric_loss_by1_9G =", value, "dielectricLossBy19g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy19gNotEqualTo(String value) {
            addCriterion("dielectric_loss_by1_9G <>", value, "dielectricLossBy19g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy19gGreaterThan(String value) {
            addCriterion("dielectric_loss_by1_9G >", value, "dielectricLossBy19g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy19gGreaterThanOrEqualTo(String value) {
            addCriterion("dielectric_loss_by1_9G >=", value, "dielectricLossBy19g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy19gLessThan(String value) {
            addCriterion("dielectric_loss_by1_9G <", value, "dielectricLossBy19g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy19gLessThanOrEqualTo(String value) {
            addCriterion("dielectric_loss_by1_9G <=", value, "dielectricLossBy19g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy19gLike(String value) {
            addCriterion("dielectric_loss_by1_9G like", value, "dielectricLossBy19g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy19gNotLike(String value) {
            addCriterion("dielectric_loss_by1_9G not like", value, "dielectricLossBy19g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy19gIn(List<String> values) {
            addCriterion("dielectric_loss_by1_9G in", values, "dielectricLossBy19g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy19gNotIn(List<String> values) {
            addCriterion("dielectric_loss_by1_9G not in", values, "dielectricLossBy19g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy19gBetween(String value1, String value2) {
            addCriterion("dielectric_loss_by1_9G between", value1, value2, "dielectricLossBy19g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy19gNotBetween(String value1, String value2) {
            addCriterion("dielectric_loss_by1_9G not between", value1, value2, "dielectricLossBy19g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy15gIsNull() {
            addCriterion("permittivity_by15G is null");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy15gIsNotNull() {
            addCriterion("permittivity_by15G is not null");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy15gEqualTo(String value) {
            addCriterion("permittivity_by15G =", value, "permittivityBy15g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy15gNotEqualTo(String value) {
            addCriterion("permittivity_by15G <>", value, "permittivityBy15g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy15gGreaterThan(String value) {
            addCriterion("permittivity_by15G >", value, "permittivityBy15g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy15gGreaterThanOrEqualTo(String value) {
            addCriterion("permittivity_by15G >=", value, "permittivityBy15g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy15gLessThan(String value) {
            addCriterion("permittivity_by15G <", value, "permittivityBy15g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy15gLessThanOrEqualTo(String value) {
            addCriterion("permittivity_by15G <=", value, "permittivityBy15g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy15gLike(String value) {
            addCriterion("permittivity_by15G like", value, "permittivityBy15g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy15gNotLike(String value) {
            addCriterion("permittivity_by15G not like", value, "permittivityBy15g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy15gIn(List<String> values) {
            addCriterion("permittivity_by15G in", values, "permittivityBy15g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy15gNotIn(List<String> values) {
            addCriterion("permittivity_by15G not in", values, "permittivityBy15g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy15gBetween(String value1, String value2) {
            addCriterion("permittivity_by15G between", value1, value2, "permittivityBy15g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy15gNotBetween(String value1, String value2) {
            addCriterion("permittivity_by15G not between", value1, value2, "permittivityBy15g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy19gIsNull() {
            addCriterion("permittivity_by1_9G is null");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy19gIsNotNull() {
            addCriterion("permittivity_by1_9G is not null");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy19gEqualTo(String value) {
            addCriterion("permittivity_by1_9G =", value, "permittivityBy19g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy19gNotEqualTo(String value) {
            addCriterion("permittivity_by1_9G <>", value, "permittivityBy19g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy19gGreaterThan(String value) {
            addCriterion("permittivity_by1_9G >", value, "permittivityBy19g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy19gGreaterThanOrEqualTo(String value) {
            addCriterion("permittivity_by1_9G >=", value, "permittivityBy19g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy19gLessThan(String value) {
            addCriterion("permittivity_by1_9G <", value, "permittivityBy19g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy19gLessThanOrEqualTo(String value) {
            addCriterion("permittivity_by1_9G <=", value, "permittivityBy19g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy19gLike(String value) {
            addCriterion("permittivity_by1_9G like", value, "permittivityBy19g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy19gNotLike(String value) {
            addCriterion("permittivity_by1_9G not like", value, "permittivityBy19g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy19gIn(List<String> values) {
            addCriterion("permittivity_by1_9G in", values, "permittivityBy19g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy19gNotIn(List<String> values) {
            addCriterion("permittivity_by1_9G not in", values, "permittivityBy19g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy19gBetween(String value1, String value2) {
            addCriterion("permittivity_by1_9G between", value1, value2, "permittivityBy19g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy19gNotBetween(String value1, String value2) {
            addCriterion("permittivity_by1_9G not between", value1, value2, "permittivityBy19g");
            return (Criteria) this;
        }

        public Criteria andDielectricStrengthIsNull() {
            addCriterion("dielectric_strength is null");
            return (Criteria) this;
        }

        public Criteria andDielectricStrengthIsNotNull() {
            addCriterion("dielectric_strength is not null");
            return (Criteria) this;
        }

        public Criteria andDielectricStrengthEqualTo(String value) {
            addCriterion("dielectric_strength =", value, "dielectricStrength");
            return (Criteria) this;
        }

        public Criteria andDielectricStrengthNotEqualTo(String value) {
            addCriterion("dielectric_strength <>", value, "dielectricStrength");
            return (Criteria) this;
        }

        public Criteria andDielectricStrengthGreaterThan(String value) {
            addCriterion("dielectric_strength >", value, "dielectricStrength");
            return (Criteria) this;
        }

        public Criteria andDielectricStrengthGreaterThanOrEqualTo(String value) {
            addCriterion("dielectric_strength >=", value, "dielectricStrength");
            return (Criteria) this;
        }

        public Criteria andDielectricStrengthLessThan(String value) {
            addCriterion("dielectric_strength <", value, "dielectricStrength");
            return (Criteria) this;
        }

        public Criteria andDielectricStrengthLessThanOrEqualTo(String value) {
            addCriterion("dielectric_strength <=", value, "dielectricStrength");
            return (Criteria) this;
        }

        public Criteria andDielectricStrengthLike(String value) {
            addCriterion("dielectric_strength like", value, "dielectricStrength");
            return (Criteria) this;
        }

        public Criteria andDielectricStrengthNotLike(String value) {
            addCriterion("dielectric_strength not like", value, "dielectricStrength");
            return (Criteria) this;
        }

        public Criteria andDielectricStrengthIn(List<String> values) {
            addCriterion("dielectric_strength in", values, "dielectricStrength");
            return (Criteria) this;
        }

        public Criteria andDielectricStrengthNotIn(List<String> values) {
            addCriterion("dielectric_strength not in", values, "dielectricStrength");
            return (Criteria) this;
        }

        public Criteria andDielectricStrengthBetween(String value1, String value2) {
            addCriterion("dielectric_strength between", value1, value2, "dielectricStrength");
            return (Criteria) this;
        }

        public Criteria andDielectricStrengthNotBetween(String value1, String value2) {
            addCriterion("dielectric_strength not between", value1, value2, "dielectricStrength");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy125IsNull() {
            addCriterion("insulation_resistance_by125 is null");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy125IsNotNull() {
            addCriterion("insulation_resistance_by125 is not null");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy125EqualTo(String value) {
            addCriterion("insulation_resistance_by125 =", value, "insulationResistanceBy125");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy125NotEqualTo(String value) {
            addCriterion("insulation_resistance_by125 <>", value, "insulationResistanceBy125");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy125GreaterThan(String value) {
            addCriterion("insulation_resistance_by125 >", value, "insulationResistanceBy125");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy125GreaterThanOrEqualTo(String value) {
            addCriterion("insulation_resistance_by125 >=", value, "insulationResistanceBy125");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy125LessThan(String value) {
            addCriterion("insulation_resistance_by125 <", value, "insulationResistanceBy125");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy125LessThanOrEqualTo(String value) {
            addCriterion("insulation_resistance_by125 <=", value, "insulationResistanceBy125");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy125Like(String value) {
            addCriterion("insulation_resistance_by125 like", value, "insulationResistanceBy125");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy125NotLike(String value) {
            addCriterion("insulation_resistance_by125 not like", value, "insulationResistanceBy125");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy125In(List<String> values) {
            addCriterion("insulation_resistance_by125 in", values, "insulationResistanceBy125");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy125NotIn(List<String> values) {
            addCriterion("insulation_resistance_by125 not in", values, "insulationResistanceBy125");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy125Between(String value1, String value2) {
            addCriterion("insulation_resistance_by125 between", value1, value2, "insulationResistanceBy125");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy125NotBetween(String value1, String value2) {
            addCriterion("insulation_resistance_by125 not between", value1, value2, "insulationResistanceBy125");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy25IsNull() {
            addCriterion("insulation_resistance_by25 is null");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy25IsNotNull() {
            addCriterion("insulation_resistance_by25 is not null");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy25EqualTo(String value) {
            addCriterion("insulation_resistance_by25 =", value, "insulationResistanceBy25");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy25NotEqualTo(String value) {
            addCriterion("insulation_resistance_by25 <>", value, "insulationResistanceBy25");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy25GreaterThan(String value) {
            addCriterion("insulation_resistance_by25 >", value, "insulationResistanceBy25");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy25GreaterThanOrEqualTo(String value) {
            addCriterion("insulation_resistance_by25 >=", value, "insulationResistanceBy25");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy25LessThan(String value) {
            addCriterion("insulation_resistance_by25 <", value, "insulationResistanceBy25");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy25LessThanOrEqualTo(String value) {
            addCriterion("insulation_resistance_by25 <=", value, "insulationResistanceBy25");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy25Like(String value) {
            addCriterion("insulation_resistance_by25 like", value, "insulationResistanceBy25");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy25NotLike(String value) {
            addCriterion("insulation_resistance_by25 not like", value, "insulationResistanceBy25");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy25In(List<String> values) {
            addCriterion("insulation_resistance_by25 in", values, "insulationResistanceBy25");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy25NotIn(List<String> values) {
            addCriterion("insulation_resistance_by25 not in", values, "insulationResistanceBy25");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy25Between(String value1, String value2) {
            addCriterion("insulation_resistance_by25 between", value1, value2, "insulationResistanceBy25");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy25NotBetween(String value1, String value2) {
            addCriterion("insulation_resistance_by25 not between", value1, value2, "insulationResistanceBy25");
            return (Criteria) this;
        }

        public Criteria andTemperatureAlterationRatioIsNull() {
            addCriterion("temperature_alteration_ratio is null");
            return (Criteria) this;
        }

        public Criteria andTemperatureAlterationRatioIsNotNull() {
            addCriterion("temperature_alteration_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andTemperatureAlterationRatioEqualTo(String value) {
            addCriterion("temperature_alteration_ratio =", value, "temperatureAlterationRatio");
            return (Criteria) this;
        }

        public Criteria andTemperatureAlterationRatioNotEqualTo(String value) {
            addCriterion("temperature_alteration_ratio <>", value, "temperatureAlterationRatio");
            return (Criteria) this;
        }

        public Criteria andTemperatureAlterationRatioGreaterThan(String value) {
            addCriterion("temperature_alteration_ratio >", value, "temperatureAlterationRatio");
            return (Criteria) this;
        }

        public Criteria andTemperatureAlterationRatioGreaterThanOrEqualTo(String value) {
            addCriterion("temperature_alteration_ratio >=", value, "temperatureAlterationRatio");
            return (Criteria) this;
        }

        public Criteria andTemperatureAlterationRatioLessThan(String value) {
            addCriterion("temperature_alteration_ratio <", value, "temperatureAlterationRatio");
            return (Criteria) this;
        }

        public Criteria andTemperatureAlterationRatioLessThanOrEqualTo(String value) {
            addCriterion("temperature_alteration_ratio <=", value, "temperatureAlterationRatio");
            return (Criteria) this;
        }

        public Criteria andTemperatureAlterationRatioLike(String value) {
            addCriterion("temperature_alteration_ratio like", value, "temperatureAlterationRatio");
            return (Criteria) this;
        }

        public Criteria andTemperatureAlterationRatioNotLike(String value) {
            addCriterion("temperature_alteration_ratio not like", value, "temperatureAlterationRatio");
            return (Criteria) this;
        }

        public Criteria andTemperatureAlterationRatioIn(List<String> values) {
            addCriterion("temperature_alteration_ratio in", values, "temperatureAlterationRatio");
            return (Criteria) this;
        }

        public Criteria andTemperatureAlterationRatioNotIn(List<String> values) {
            addCriterion("temperature_alteration_ratio not in", values, "temperatureAlterationRatio");
            return (Criteria) this;
        }

        public Criteria andTemperatureAlterationRatioBetween(String value1, String value2) {
            addCriterion("temperature_alteration_ratio between", value1, value2, "temperatureAlterationRatio");
            return (Criteria) this;
        }

        public Criteria andTemperatureAlterationRatioNotBetween(String value1, String value2) {
            addCriterion("temperature_alteration_ratio not between", value1, value2, "temperatureAlterationRatio");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy1mhzIsNull() {
            addCriterion("dielectric_loss_by1MHz is null");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy1mhzIsNotNull() {
            addCriterion("dielectric_loss_by1MHz is not null");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy1mhzEqualTo(String value) {
            addCriterion("dielectric_loss_by1MHz =", value, "dielectricLossBy1mhz");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy1mhzNotEqualTo(String value) {
            addCriterion("dielectric_loss_by1MHz <>", value, "dielectricLossBy1mhz");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy1mhzGreaterThan(String value) {
            addCriterion("dielectric_loss_by1MHz >", value, "dielectricLossBy1mhz");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy1mhzGreaterThanOrEqualTo(String value) {
            addCriterion("dielectric_loss_by1MHz >=", value, "dielectricLossBy1mhz");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy1mhzLessThan(String value) {
            addCriterion("dielectric_loss_by1MHz <", value, "dielectricLossBy1mhz");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy1mhzLessThanOrEqualTo(String value) {
            addCriterion("dielectric_loss_by1MHz <=", value, "dielectricLossBy1mhz");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy1mhzLike(String value) {
            addCriterion("dielectric_loss_by1MHz like", value, "dielectricLossBy1mhz");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy1mhzNotLike(String value) {
            addCriterion("dielectric_loss_by1MHz not like", value, "dielectricLossBy1mhz");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy1mhzIn(List<String> values) {
            addCriterion("dielectric_loss_by1MHz in", values, "dielectricLossBy1mhz");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy1mhzNotIn(List<String> values) {
            addCriterion("dielectric_loss_by1MHz not in", values, "dielectricLossBy1mhz");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy1mhzBetween(String value1, String value2) {
            addCriterion("dielectric_loss_by1MHz between", value1, value2, "dielectricLossBy1mhz");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy1mhzNotBetween(String value1, String value2) {
            addCriterion("dielectric_loss_by1MHz not between", value1, value2, "dielectricLossBy1mhz");
            return (Criteria) this;
        }

        public Criteria andPermittivityIsNull() {
            addCriterion("permittivity is null");
            return (Criteria) this;
        }

        public Criteria andPermittivityIsNotNull() {
            addCriterion("permittivity is not null");
            return (Criteria) this;
        }

        public Criteria andPermittivityEqualTo(String value) {
            addCriterion("permittivity =", value, "permittivity");
            return (Criteria) this;
        }

        public Criteria andPermittivityNotEqualTo(String value) {
            addCriterion("permittivity <>", value, "permittivity");
            return (Criteria) this;
        }

        public Criteria andPermittivityGreaterThan(String value) {
            addCriterion("permittivity >", value, "permittivity");
            return (Criteria) this;
        }

        public Criteria andPermittivityGreaterThanOrEqualTo(String value) {
            addCriterion("permittivity >=", value, "permittivity");
            return (Criteria) this;
        }

        public Criteria andPermittivityLessThan(String value) {
            addCriterion("permittivity <", value, "permittivity");
            return (Criteria) this;
        }

        public Criteria andPermittivityLessThanOrEqualTo(String value) {
            addCriterion("permittivity <=", value, "permittivity");
            return (Criteria) this;
        }

        public Criteria andPermittivityLike(String value) {
            addCriterion("permittivity like", value, "permittivity");
            return (Criteria) this;
        }

        public Criteria andPermittivityNotLike(String value) {
            addCriterion("permittivity not like", value, "permittivity");
            return (Criteria) this;
        }

        public Criteria andPermittivityIn(List<String> values) {
            addCriterion("permittivity in", values, "permittivity");
            return (Criteria) this;
        }

        public Criteria andPermittivityNotIn(List<String> values) {
            addCriterion("permittivity not in", values, "permittivity");
            return (Criteria) this;
        }

        public Criteria andPermittivityBetween(String value1, String value2) {
            addCriterion("permittivity between", value1, value2, "permittivity");
            return (Criteria) this;
        }

        public Criteria andPermittivityNotBetween(String value1, String value2) {
            addCriterion("permittivity not between", value1, value2, "permittivity");
            return (Criteria) this;
        }

        public Criteria andPowderDensityIsNull() {
            addCriterion("powder_density is null");
            return (Criteria) this;
        }

        public Criteria andPowderDensityIsNotNull() {
            addCriterion("powder_density is not null");
            return (Criteria) this;
        }

        public Criteria andPowderDensityEqualTo(String value) {
            addCriterion("powder_density =", value, "powderDensity");
            return (Criteria) this;
        }

        public Criteria andPowderDensityNotEqualTo(String value) {
            addCriterion("powder_density <>", value, "powderDensity");
            return (Criteria) this;
        }

        public Criteria andPowderDensityGreaterThan(String value) {
            addCriterion("powder_density >", value, "powderDensity");
            return (Criteria) this;
        }

        public Criteria andPowderDensityGreaterThanOrEqualTo(String value) {
            addCriterion("powder_density >=", value, "powderDensity");
            return (Criteria) this;
        }

        public Criteria andPowderDensityLessThan(String value) {
            addCriterion("powder_density <", value, "powderDensity");
            return (Criteria) this;
        }

        public Criteria andPowderDensityLessThanOrEqualTo(String value) {
            addCriterion("powder_density <=", value, "powderDensity");
            return (Criteria) this;
        }

        public Criteria andPowderDensityLike(String value) {
            addCriterion("powder_density like", value, "powderDensity");
            return (Criteria) this;
        }

        public Criteria andPowderDensityNotLike(String value) {
            addCriterion("powder_density not like", value, "powderDensity");
            return (Criteria) this;
        }

        public Criteria andPowderDensityIn(List<String> values) {
            addCriterion("powder_density in", values, "powderDensity");
            return (Criteria) this;
        }

        public Criteria andPowderDensityNotIn(List<String> values) {
            addCriterion("powder_density not in", values, "powderDensity");
            return (Criteria) this;
        }

        public Criteria andPowderDensityBetween(String value1, String value2) {
            addCriterion("powder_density between", value1, value2, "powderDensity");
            return (Criteria) this;
        }

        public Criteria andPowderDensityNotBetween(String value1, String value2) {
            addCriterion("powder_density not between", value1, value2, "powderDensity");
            return (Criteria) this;
        }

        public Criteria andSpecificSurfaceareaIsNull() {
            addCriterion("specific_surfaceArea is null");
            return (Criteria) this;
        }

        public Criteria andSpecificSurfaceareaIsNotNull() {
            addCriterion("specific_surfaceArea is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificSurfaceareaEqualTo(String value) {
            addCriterion("specific_surfaceArea =", value, "specificSurfacearea");
            return (Criteria) this;
        }

        public Criteria andSpecificSurfaceareaNotEqualTo(String value) {
            addCriterion("specific_surfaceArea <>", value, "specificSurfacearea");
            return (Criteria) this;
        }

        public Criteria andSpecificSurfaceareaGreaterThan(String value) {
            addCriterion("specific_surfaceArea >", value, "specificSurfacearea");
            return (Criteria) this;
        }

        public Criteria andSpecificSurfaceareaGreaterThanOrEqualTo(String value) {
            addCriterion("specific_surfaceArea >=", value, "specificSurfacearea");
            return (Criteria) this;
        }

        public Criteria andSpecificSurfaceareaLessThan(String value) {
            addCriterion("specific_surfaceArea <", value, "specificSurfacearea");
            return (Criteria) this;
        }

        public Criteria andSpecificSurfaceareaLessThanOrEqualTo(String value) {
            addCriterion("specific_surfaceArea <=", value, "specificSurfacearea");
            return (Criteria) this;
        }

        public Criteria andSpecificSurfaceareaLike(String value) {
            addCriterion("specific_surfaceArea like", value, "specificSurfacearea");
            return (Criteria) this;
        }

        public Criteria andSpecificSurfaceareaNotLike(String value) {
            addCriterion("specific_surfaceArea not like", value, "specificSurfacearea");
            return (Criteria) this;
        }

        public Criteria andSpecificSurfaceareaIn(List<String> values) {
            addCriterion("specific_surfaceArea in", values, "specificSurfacearea");
            return (Criteria) this;
        }

        public Criteria andSpecificSurfaceareaNotIn(List<String> values) {
            addCriterion("specific_surfaceArea not in", values, "specificSurfacearea");
            return (Criteria) this;
        }

        public Criteria andSpecificSurfaceareaBetween(String value1, String value2) {
            addCriterion("specific_surfaceArea between", value1, value2, "specificSurfacearea");
            return (Criteria) this;
        }

        public Criteria andSpecificSurfaceareaNotBetween(String value1, String value2) {
            addCriterion("specific_surfaceArea not between", value1, value2, "specificSurfacearea");
            return (Criteria) this;
        }

        public Criteria andD90IsNull() {
            addCriterion("d90 is null");
            return (Criteria) this;
        }

        public Criteria andD90IsNotNull() {
            addCriterion("d90 is not null");
            return (Criteria) this;
        }

        public Criteria andD90EqualTo(String value) {
            addCriterion("d90 =", value, "d90");
            return (Criteria) this;
        }

        public Criteria andD90NotEqualTo(String value) {
            addCriterion("d90 <>", value, "d90");
            return (Criteria) this;
        }

        public Criteria andD90GreaterThan(String value) {
            addCriterion("d90 >", value, "d90");
            return (Criteria) this;
        }

        public Criteria andD90GreaterThanOrEqualTo(String value) {
            addCriterion("d90 >=", value, "d90");
            return (Criteria) this;
        }

        public Criteria andD90LessThan(String value) {
            addCriterion("d90 <", value, "d90");
            return (Criteria) this;
        }

        public Criteria andD90LessThanOrEqualTo(String value) {
            addCriterion("d90 <=", value, "d90");
            return (Criteria) this;
        }

        public Criteria andD90Like(String value) {
            addCriterion("d90 like", value, "d90");
            return (Criteria) this;
        }

        public Criteria andD90NotLike(String value) {
            addCriterion("d90 not like", value, "d90");
            return (Criteria) this;
        }

        public Criteria andD90In(List<String> values) {
            addCriterion("d90 in", values, "d90");
            return (Criteria) this;
        }

        public Criteria andD90NotIn(List<String> values) {
            addCriterion("d90 not in", values, "d90");
            return (Criteria) this;
        }

        public Criteria andD90Between(String value1, String value2) {
            addCriterion("d90 between", value1, value2, "d90");
            return (Criteria) this;
        }

        public Criteria andD90NotBetween(String value1, String value2) {
            addCriterion("d90 not between", value1, value2, "d90");
            return (Criteria) this;
        }

        public Criteria andD50IsNull() {
            addCriterion("d50 is null");
            return (Criteria) this;
        }

        public Criteria andD50IsNotNull() {
            addCriterion("d50 is not null");
            return (Criteria) this;
        }

        public Criteria andD50EqualTo(String value) {
            addCriterion("d50 =", value, "d50");
            return (Criteria) this;
        }

        public Criteria andD50NotEqualTo(String value) {
            addCriterion("d50 <>", value, "d50");
            return (Criteria) this;
        }

        public Criteria andD50GreaterThan(String value) {
            addCriterion("d50 >", value, "d50");
            return (Criteria) this;
        }

        public Criteria andD50GreaterThanOrEqualTo(String value) {
            addCriterion("d50 >=", value, "d50");
            return (Criteria) this;
        }

        public Criteria andD50LessThan(String value) {
            addCriterion("d50 <", value, "d50");
            return (Criteria) this;
        }

        public Criteria andD50LessThanOrEqualTo(String value) {
            addCriterion("d50 <=", value, "d50");
            return (Criteria) this;
        }

        public Criteria andD50Like(String value) {
            addCriterion("d50 like", value, "d50");
            return (Criteria) this;
        }

        public Criteria andD50NotLike(String value) {
            addCriterion("d50 not like", value, "d50");
            return (Criteria) this;
        }

        public Criteria andD50In(List<String> values) {
            addCriterion("d50 in", values, "d50");
            return (Criteria) this;
        }

        public Criteria andD50NotIn(List<String> values) {
            addCriterion("d50 not in", values, "d50");
            return (Criteria) this;
        }

        public Criteria andD50Between(String value1, String value2) {
            addCriterion("d50 between", value1, value2, "d50");
            return (Criteria) this;
        }

        public Criteria andD50NotBetween(String value1, String value2) {
            addCriterion("d50 not between", value1, value2, "d50");
            return (Criteria) this;
        }

        public Criteria andD10IsNull() {
            addCriterion("d10 is null");
            return (Criteria) this;
        }

        public Criteria andD10IsNotNull() {
            addCriterion("d10 is not null");
            return (Criteria) this;
        }

        public Criteria andD10EqualTo(String value) {
            addCriterion("d10 =", value, "d10");
            return (Criteria) this;
        }

        public Criteria andD10NotEqualTo(String value) {
            addCriterion("d10 <>", value, "d10");
            return (Criteria) this;
        }

        public Criteria andD10GreaterThan(String value) {
            addCriterion("d10 >", value, "d10");
            return (Criteria) this;
        }

        public Criteria andD10GreaterThanOrEqualTo(String value) {
            addCriterion("d10 >=", value, "d10");
            return (Criteria) this;
        }

        public Criteria andD10LessThan(String value) {
            addCriterion("d10 <", value, "d10");
            return (Criteria) this;
        }

        public Criteria andD10LessThanOrEqualTo(String value) {
            addCriterion("d10 <=", value, "d10");
            return (Criteria) this;
        }

        public Criteria andD10Like(String value) {
            addCriterion("d10 like", value, "d10");
            return (Criteria) this;
        }

        public Criteria andD10NotLike(String value) {
            addCriterion("d10 not like", value, "d10");
            return (Criteria) this;
        }

        public Criteria andD10In(List<String> values) {
            addCriterion("d10 in", values, "d10");
            return (Criteria) this;
        }

        public Criteria andD10NotIn(List<String> values) {
            addCriterion("d10 not in", values, "d10");
            return (Criteria) this;
        }

        public Criteria andD10Between(String value1, String value2) {
            addCriterion("d10 between", value1, value2, "d10");
            return (Criteria) this;
        }

        public Criteria andD10NotBetween(String value1, String value2) {
            addCriterion("d10 not between", value1, value2, "d10");
            return (Criteria) this;
        }

        public Criteria andSinteringTemperatureIsNull() {
            addCriterion("sintering_temperature is null");
            return (Criteria) this;
        }

        public Criteria andSinteringTemperatureIsNotNull() {
            addCriterion("sintering_temperature is not null");
            return (Criteria) this;
        }

        public Criteria andSinteringTemperatureEqualTo(String value) {
            addCriterion("sintering_temperature =", value, "sinteringTemperature");
            return (Criteria) this;
        }

        public Criteria andSinteringTemperatureNotEqualTo(String value) {
            addCriterion("sintering_temperature <>", value, "sinteringTemperature");
            return (Criteria) this;
        }

        public Criteria andSinteringTemperatureGreaterThan(String value) {
            addCriterion("sintering_temperature >", value, "sinteringTemperature");
            return (Criteria) this;
        }

        public Criteria andSinteringTemperatureGreaterThanOrEqualTo(String value) {
            addCriterion("sintering_temperature >=", value, "sinteringTemperature");
            return (Criteria) this;
        }

        public Criteria andSinteringTemperatureLessThan(String value) {
            addCriterion("sintering_temperature <", value, "sinteringTemperature");
            return (Criteria) this;
        }

        public Criteria andSinteringTemperatureLessThanOrEqualTo(String value) {
            addCriterion("sintering_temperature <=", value, "sinteringTemperature");
            return (Criteria) this;
        }

        public Criteria andSinteringTemperatureLike(String value) {
            addCriterion("sintering_temperature like", value, "sinteringTemperature");
            return (Criteria) this;
        }

        public Criteria andSinteringTemperatureNotLike(String value) {
            addCriterion("sintering_temperature not like", value, "sinteringTemperature");
            return (Criteria) this;
        }

        public Criteria andSinteringTemperatureIn(List<String> values) {
            addCriterion("sintering_temperature in", values, "sinteringTemperature");
            return (Criteria) this;
        }

        public Criteria andSinteringTemperatureNotIn(List<String> values) {
            addCriterion("sintering_temperature not in", values, "sinteringTemperature");
            return (Criteria) this;
        }

        public Criteria andSinteringTemperatureBetween(String value1, String value2) {
            addCriterion("sintering_temperature between", value1, value2, "sinteringTemperature");
            return (Criteria) this;
        }

        public Criteria andSinteringTemperatureNotBetween(String value1, String value2) {
            addCriterion("sintering_temperature not between", value1, value2, "sinteringTemperature");
            return (Criteria) this;
        }

        public Criteria andSoakingTimeIsNull() {
            addCriterion("soaking_time is null");
            return (Criteria) this;
        }

        public Criteria andSoakingTimeIsNotNull() {
            addCriterion("soaking_time is not null");
            return (Criteria) this;
        }

        public Criteria andSoakingTimeEqualTo(String value) {
            addCriterion("soaking_time =", value, "soakingTime");
            return (Criteria) this;
        }

        public Criteria andSoakingTimeNotEqualTo(String value) {
            addCriterion("soaking_time <>", value, "soakingTime");
            return (Criteria) this;
        }

        public Criteria andSoakingTimeGreaterThan(String value) {
            addCriterion("soaking_time >", value, "soakingTime");
            return (Criteria) this;
        }

        public Criteria andSoakingTimeGreaterThanOrEqualTo(String value) {
            addCriterion("soaking_time >=", value, "soakingTime");
            return (Criteria) this;
        }

        public Criteria andSoakingTimeLessThan(String value) {
            addCriterion("soaking_time <", value, "soakingTime");
            return (Criteria) this;
        }

        public Criteria andSoakingTimeLessThanOrEqualTo(String value) {
            addCriterion("soaking_time <=", value, "soakingTime");
            return (Criteria) this;
        }

        public Criteria andSoakingTimeLike(String value) {
            addCriterion("soaking_time like", value, "soakingTime");
            return (Criteria) this;
        }

        public Criteria andSoakingTimeNotLike(String value) {
            addCriterion("soaking_time not like", value, "soakingTime");
            return (Criteria) this;
        }

        public Criteria andSoakingTimeIn(List<String> values) {
            addCriterion("soaking_time in", values, "soakingTime");
            return (Criteria) this;
        }

        public Criteria andSoakingTimeNotIn(List<String> values) {
            addCriterion("soaking_time not in", values, "soakingTime");
            return (Criteria) this;
        }

        public Criteria andSoakingTimeBetween(String value1, String value2) {
            addCriterion("soaking_time between", value1, value2, "soakingTime");
            return (Criteria) this;
        }

        public Criteria andSoakingTimeNotBetween(String value1, String value2) {
            addCriterion("soaking_time not between", value1, value2, "soakingTime");
            return (Criteria) this;
        }

        public Criteria andPerformanceIsNull() {
            addCriterion("performance is null");
            return (Criteria) this;
        }

        public Criteria andPerformanceIsNotNull() {
            addCriterion("performance is not null");
            return (Criteria) this;
        }

        public Criteria andPerformanceEqualTo(String value) {
            addCriterion("performance =", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceNotEqualTo(String value) {
            addCriterion("performance <>", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceGreaterThan(String value) {
            addCriterion("performance >", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceGreaterThanOrEqualTo(String value) {
            addCriterion("performance >=", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceLessThan(String value) {
            addCriterion("performance <", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceLessThanOrEqualTo(String value) {
            addCriterion("performance <=", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceLike(String value) {
            addCriterion("performance like", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceNotLike(String value) {
            addCriterion("performance not like", value, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceIn(List<String> values) {
            addCriterion("performance in", values, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceNotIn(List<String> values) {
            addCriterion("performance not in", values, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceBetween(String value1, String value2) {
            addCriterion("performance between", value1, value2, "performance");
            return (Criteria) this;
        }

        public Criteria andPerformanceNotBetween(String value1, String value2) {
            addCriterion("performance not between", value1, value2, "performance");
            return (Criteria) this;
        }

        public Criteria andPadMetallurgyIsNull() {
            addCriterion("pad_metallurgy is null");
            return (Criteria) this;
        }

        public Criteria andPadMetallurgyIsNotNull() {
            addCriterion("pad_metallurgy is not null");
            return (Criteria) this;
        }

        public Criteria andPadMetallurgyEqualTo(String value) {
            addCriterion("pad_metallurgy =", value, "padMetallurgy");
            return (Criteria) this;
        }

        public Criteria andPadMetallurgyNotEqualTo(String value) {
            addCriterion("pad_metallurgy <>", value, "padMetallurgy");
            return (Criteria) this;
        }

        public Criteria andPadMetallurgyGreaterThan(String value) {
            addCriterion("pad_metallurgy >", value, "padMetallurgy");
            return (Criteria) this;
        }

        public Criteria andPadMetallurgyGreaterThanOrEqualTo(String value) {
            addCriterion("pad_metallurgy >=", value, "padMetallurgy");
            return (Criteria) this;
        }

        public Criteria andPadMetallurgyLessThan(String value) {
            addCriterion("pad_metallurgy <", value, "padMetallurgy");
            return (Criteria) this;
        }

        public Criteria andPadMetallurgyLessThanOrEqualTo(String value) {
            addCriterion("pad_metallurgy <=", value, "padMetallurgy");
            return (Criteria) this;
        }

        public Criteria andPadMetallurgyLike(String value) {
            addCriterion("pad_metallurgy like", value, "padMetallurgy");
            return (Criteria) this;
        }

        public Criteria andPadMetallurgyNotLike(String value) {
            addCriterion("pad_metallurgy not like", value, "padMetallurgy");
            return (Criteria) this;
        }

        public Criteria andPadMetallurgyIn(List<String> values) {
            addCriterion("pad_metallurgy in", values, "padMetallurgy");
            return (Criteria) this;
        }

        public Criteria andPadMetallurgyNotIn(List<String> values) {
            addCriterion("pad_metallurgy not in", values, "padMetallurgy");
            return (Criteria) this;
        }

        public Criteria andPadMetallurgyBetween(String value1, String value2) {
            addCriterion("pad_metallurgy between", value1, value2, "padMetallurgy");
            return (Criteria) this;
        }

        public Criteria andPadMetallurgyNotBetween(String value1, String value2) {
            addCriterion("pad_metallurgy not between", value1, value2, "padMetallurgy");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection1IsNull() {
            addCriterion("out_of_band_rejection1 is null");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection1IsNotNull() {
            addCriterion("out_of_band_rejection1 is not null");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection1EqualTo(String value) {
            addCriterion("out_of_band_rejection1 =", value, "outOfBandRejection1");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection1NotEqualTo(String value) {
            addCriterion("out_of_band_rejection1 <>", value, "outOfBandRejection1");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection1GreaterThan(String value) {
            addCriterion("out_of_band_rejection1 >", value, "outOfBandRejection1");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection1GreaterThanOrEqualTo(String value) {
            addCriterion("out_of_band_rejection1 >=", value, "outOfBandRejection1");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection1LessThan(String value) {
            addCriterion("out_of_band_rejection1 <", value, "outOfBandRejection1");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection1LessThanOrEqualTo(String value) {
            addCriterion("out_of_band_rejection1 <=", value, "outOfBandRejection1");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection1Like(String value) {
            addCriterion("out_of_band_rejection1 like", value, "outOfBandRejection1");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection1NotLike(String value) {
            addCriterion("out_of_band_rejection1 not like", value, "outOfBandRejection1");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection1In(List<String> values) {
            addCriterion("out_of_band_rejection1 in", values, "outOfBandRejection1");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection1NotIn(List<String> values) {
            addCriterion("out_of_band_rejection1 not in", values, "outOfBandRejection1");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection1Between(String value1, String value2) {
            addCriterion("out_of_band_rejection1 between", value1, value2, "outOfBandRejection1");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection1NotBetween(String value1, String value2) {
            addCriterion("out_of_band_rejection1 not between", value1, value2, "outOfBandRejection1");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection2IsNull() {
            addCriterion("out_of_band_rejection2 is null");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection2IsNotNull() {
            addCriterion("out_of_band_rejection2 is not null");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection2EqualTo(String value) {
            addCriterion("out_of_band_rejection2 =", value, "outOfBandRejection2");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection2NotEqualTo(String value) {
            addCriterion("out_of_band_rejection2 <>", value, "outOfBandRejection2");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection2GreaterThan(String value) {
            addCriterion("out_of_band_rejection2 >", value, "outOfBandRejection2");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection2GreaterThanOrEqualTo(String value) {
            addCriterion("out_of_band_rejection2 >=", value, "outOfBandRejection2");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection2LessThan(String value) {
            addCriterion("out_of_band_rejection2 <", value, "outOfBandRejection2");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection2LessThanOrEqualTo(String value) {
            addCriterion("out_of_band_rejection2 <=", value, "outOfBandRejection2");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection2Like(String value) {
            addCriterion("out_of_band_rejection2 like", value, "outOfBandRejection2");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection2NotLike(String value) {
            addCriterion("out_of_band_rejection2 not like", value, "outOfBandRejection2");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection2In(List<String> values) {
            addCriterion("out_of_band_rejection2 in", values, "outOfBandRejection2");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection2NotIn(List<String> values) {
            addCriterion("out_of_band_rejection2 not in", values, "outOfBandRejection2");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection2Between(String value1, String value2) {
            addCriterion("out_of_band_rejection2 between", value1, value2, "outOfBandRejection2");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection2NotBetween(String value1, String value2) {
            addCriterion("out_of_band_rejection2 not between", value1, value2, "outOfBandRejection2");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection3IsNull() {
            addCriterion("out_of_band_rejection3 is null");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection3IsNotNull() {
            addCriterion("out_of_band_rejection3 is not null");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection3EqualTo(String value) {
            addCriterion("out_of_band_rejection3 =", value, "outOfBandRejection3");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection3NotEqualTo(String value) {
            addCriterion("out_of_band_rejection3 <>", value, "outOfBandRejection3");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection3GreaterThan(String value) {
            addCriterion("out_of_band_rejection3 >", value, "outOfBandRejection3");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection3GreaterThanOrEqualTo(String value) {
            addCriterion("out_of_band_rejection3 >=", value, "outOfBandRejection3");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection3LessThan(String value) {
            addCriterion("out_of_band_rejection3 <", value, "outOfBandRejection3");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection3LessThanOrEqualTo(String value) {
            addCriterion("out_of_band_rejection3 <=", value, "outOfBandRejection3");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection3Like(String value) {
            addCriterion("out_of_band_rejection3 like", value, "outOfBandRejection3");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection3NotLike(String value) {
            addCriterion("out_of_band_rejection3 not like", value, "outOfBandRejection3");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection3In(List<String> values) {
            addCriterion("out_of_band_rejection3 in", values, "outOfBandRejection3");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection3NotIn(List<String> values) {
            addCriterion("out_of_band_rejection3 not in", values, "outOfBandRejection3");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection3Between(String value1, String value2) {
            addCriterion("out_of_band_rejection3 between", value1, value2, "outOfBandRejection3");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection3NotBetween(String value1, String value2) {
            addCriterion("out_of_band_rejection3 not between", value1, value2, "outOfBandRejection3");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection4IsNull() {
            addCriterion("out_of_band_rejection4 is null");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection4IsNotNull() {
            addCriterion("out_of_band_rejection4 is not null");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection4EqualTo(String value) {
            addCriterion("out_of_band_rejection4 =", value, "outOfBandRejection4");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection4NotEqualTo(String value) {
            addCriterion("out_of_band_rejection4 <>", value, "outOfBandRejection4");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection4GreaterThan(String value) {
            addCriterion("out_of_band_rejection4 >", value, "outOfBandRejection4");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection4GreaterThanOrEqualTo(String value) {
            addCriterion("out_of_band_rejection4 >=", value, "outOfBandRejection4");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection4LessThan(String value) {
            addCriterion("out_of_band_rejection4 <", value, "outOfBandRejection4");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection4LessThanOrEqualTo(String value) {
            addCriterion("out_of_band_rejection4 <=", value, "outOfBandRejection4");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection4Like(String value) {
            addCriterion("out_of_band_rejection4 like", value, "outOfBandRejection4");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection4NotLike(String value) {
            addCriterion("out_of_band_rejection4 not like", value, "outOfBandRejection4");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection4In(List<String> values) {
            addCriterion("out_of_band_rejection4 in", values, "outOfBandRejection4");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection4NotIn(List<String> values) {
            addCriterion("out_of_band_rejection4 not in", values, "outOfBandRejection4");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection4Between(String value1, String value2) {
            addCriterion("out_of_band_rejection4 between", value1, value2, "outOfBandRejection4");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection4NotBetween(String value1, String value2) {
            addCriterion("out_of_band_rejection4 not between", value1, value2, "outOfBandRejection4");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection5IsNull() {
            addCriterion("out_of_band_rejection5 is null");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection5IsNotNull() {
            addCriterion("out_of_band_rejection5 is not null");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection5EqualTo(String value) {
            addCriterion("out_of_band_rejection5 =", value, "outOfBandRejection5");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection5NotEqualTo(String value) {
            addCriterion("out_of_band_rejection5 <>", value, "outOfBandRejection5");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection5GreaterThan(String value) {
            addCriterion("out_of_band_rejection5 >", value, "outOfBandRejection5");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection5GreaterThanOrEqualTo(String value) {
            addCriterion("out_of_band_rejection5 >=", value, "outOfBandRejection5");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection5LessThan(String value) {
            addCriterion("out_of_band_rejection5 <", value, "outOfBandRejection5");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection5LessThanOrEqualTo(String value) {
            addCriterion("out_of_band_rejection5 <=", value, "outOfBandRejection5");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection5Like(String value) {
            addCriterion("out_of_band_rejection5 like", value, "outOfBandRejection5");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection5NotLike(String value) {
            addCriterion("out_of_band_rejection5 not like", value, "outOfBandRejection5");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection5In(List<String> values) {
            addCriterion("out_of_band_rejection5 in", values, "outOfBandRejection5");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection5NotIn(List<String> values) {
            addCriterion("out_of_band_rejection5 not in", values, "outOfBandRejection5");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection5Between(String value1, String value2) {
            addCriterion("out_of_band_rejection5 between", value1, value2, "outOfBandRejection5");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection5NotBetween(String value1, String value2) {
            addCriterion("out_of_band_rejection5 not between", value1, value2, "outOfBandRejection5");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNull() {
            addCriterion("material is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNotNull() {
            addCriterion("material is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialEqualTo(Integer value) {
            addCriterion("material =", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotEqualTo(Integer value) {
            addCriterion("material <>", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThan(Integer value) {
            addCriterion("material >", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThanOrEqualTo(Integer value) {
            addCriterion("material >=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThan(Integer value) {
            addCriterion("material <", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThanOrEqualTo(Integer value) {
            addCriterion("material <=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialIn(List<Integer> values) {
            addCriterion("material in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotIn(List<Integer> values) {
            addCriterion("material not in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialBetween(Integer value1, Integer value2) {
            addCriterion("material between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotBetween(Integer value1, Integer value2) {
            addCriterion("material not between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andPdNameIsNull() {
            addCriterion("pd_name is null");
            return (Criteria) this;
        }

        public Criteria andPdNameIsNotNull() {
            addCriterion("pd_name is not null");
            return (Criteria) this;
        }

        public Criteria andPdNameEqualTo(String value) {
            addCriterion("pd_name =", value, "pdName");
            return (Criteria) this;
        }

        public Criteria andPdNameNotEqualTo(String value) {
            addCriterion("pd_name <>", value, "pdName");
            return (Criteria) this;
        }

        public Criteria andPdNameGreaterThan(String value) {
            addCriterion("pd_name >", value, "pdName");
            return (Criteria) this;
        }

        public Criteria andPdNameGreaterThanOrEqualTo(String value) {
            addCriterion("pd_name >=", value, "pdName");
            return (Criteria) this;
        }

        public Criteria andPdNameLessThan(String value) {
            addCriterion("pd_name <", value, "pdName");
            return (Criteria) this;
        }

        public Criteria andPdNameLessThanOrEqualTo(String value) {
            addCriterion("pd_name <=", value, "pdName");
            return (Criteria) this;
        }

        public Criteria andPdNameLike(String value) {
            addCriterion("pd_name like", value, "pdName");
            return (Criteria) this;
        }

        public Criteria andPdNameNotLike(String value) {
            addCriterion("pd_name not like", value, "pdName");
            return (Criteria) this;
        }

        public Criteria andPdNameIn(List<String> values) {
            addCriterion("pd_name in", values, "pdName");
            return (Criteria) this;
        }

        public Criteria andPdNameNotIn(List<String> values) {
            addCriterion("pd_name not in", values, "pdName");
            return (Criteria) this;
        }

        public Criteria andPdNameBetween(String value1, String value2) {
            addCriterion("pd_name between", value1, value2, "pdName");
            return (Criteria) this;
        }

        public Criteria andPdNameNotBetween(String value1, String value2) {
            addCriterion("pd_name not between", value1, value2, "pdName");
            return (Criteria) this;
        }

        public Criteria andStdLikeInsensitive(String value) {
            addCriterion("upper(std) like", value.toUpperCase(), "std");
            return (Criteria) this;
        }

        public Criteria andQualityLikeInsensitive(String value) {
            addCriterion("upper(quality) like", value.toUpperCase(), "quality");
            return (Criteria) this;
        }

        public Criteria andModelLikeInsensitive(String value) {
            addCriterion("upper(model) like", value.toUpperCase(), "model");
            return (Criteria) this;
        }

        public Criteria andSearchKeyLikeInsensitive(String value) {
            addCriterion("upper(search_key) like", value.toUpperCase(), "searchKey");
            return (Criteria) this;
        }

        public Criteria andSurfaceCodeLikeInsensitive(String value) {
            addCriterion("upper(surface_code) like", value.toUpperCase(), "surfaceCode");
            return (Criteria) this;
        }

        public Criteria andThicknessCodeLikeInsensitive(String value) {
            addCriterion("upper(thickness_code) like", value.toUpperCase(), "thicknessCode");
            return (Criteria) this;
        }

        public Criteria andLengthWidthCodeLikeInsensitive(String value) {
            addCriterion("upper(length_width_code) like", value.toUpperCase(), "lengthWidthCode");
            return (Criteria) this;
        }

        public Criteria andMaterialCodeLikeInsensitive(String value) {
            addCriterion("upper(material_code) like", value.toUpperCase(), "materialCode");
            return (Criteria) this;
        }

        public Criteria andCenterFrequencyLikeInsensitive(String value) {
            addCriterion("upper(center_frequency) like", value.toUpperCase(), "centerFrequency");
            return (Criteria) this;
        }

        public Criteria andPassBandRangeLikeInsensitive(String value) {
            addCriterion("upper(pass_band_range) like", value.toUpperCase(), "passBandRange");
            return (Criteria) this;
        }

        public Criteria andOtherLikeInsensitive(String value) {
            addCriterion("upper(other) like", value.toUpperCase(), "other");
            return (Criteria) this;
        }

        public Criteria andRippleLikeInsensitive(String value) {
            addCriterion("upper(ripple) like", value.toUpperCase(), "ripple");
            return (Criteria) this;
        }

        public Criteria andPowerCapacityLikeInsensitive(String value) {
            addCriterion("upper(power_capacity) like", value.toUpperCase(), "powerCapacity");
            return (Criteria) this;
        }

        public Criteria andVswrLikeInsensitive(String value) {
            addCriterion("upper(vswr) like", value.toUpperCase(), "vswr");
            return (Criteria) this;
        }

        public Criteria andAmplitudeBalanceLikeInsensitive(String value) {
            addCriterion("upper(amplitude_balance) like", value.toUpperCase(), "amplitudeBalance");
            return (Criteria) this;
        }

        public Criteria andPhaseBalanceLikeInsensitive(String value) {
            addCriterion("upper(phase_balance) like", value.toUpperCase(), "phaseBalance");
            return (Criteria) this;
        }

        public Criteria andInsertionLossLikeInsensitive(String value) {
            addCriterion("upper(insertion_loss) like", value.toUpperCase(), "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andIsolationLikeInsensitive(String value) {
            addCriterion("upper(isolation) like", value.toUpperCase(), "isolation");
            return (Criteria) this;
        }

        public Criteria andFrequencyRangeLikeInsensitive(String value) {
            addCriterion("upper(frequency_range) like", value.toUpperCase(), "frequencyRange");
            return (Criteria) this;
        }

        public Criteria andVswrStopBandLikeInsensitive(String value) {
            addCriterion("upper(vswr_stop_band) like", value.toUpperCase(), "vswrStopBand");
            return (Criteria) this;
        }

        public Criteria andVswrPassBandLikeInsensitive(String value) {
            addCriterion("upper(vswr_pass_Band) like", value.toUpperCase(), "vswrPassBand");
            return (Criteria) this;
        }

        public Criteria andStopBandLikeInsensitive(String value) {
            addCriterion("upper(stop_band) like", value.toUpperCase(), "stopBand");
            return (Criteria) this;
        }

        public Criteria andCutOffFrequencyLikeInsensitive(String value) {
            addCriterion("upper(cut_off_frequency) like", value.toUpperCase(), "cutOffFrequency");
            return (Criteria) this;
        }

        public Criteria andPassBandInsertionLossLikeInsensitive(String value) {
            addCriterion("upper(pass_band_insertion_loss) like", value.toUpperCase(), "passBandInsertionLoss");
            return (Criteria) this;
        }

        public Criteria andBreakdownVoltageLikeInsensitive(String value) {
            addCriterion("upper(breakdown_voltage) like", value.toUpperCase(), "breakdownVoltage");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceLikeInsensitive(String value) {
            addCriterion("upper(insulation_resistance) like", value.toUpperCase(), "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andFlexureStrengthLikeInsensitive(String value) {
            addCriterion("upper(flexure_strength) like", value.toUpperCase(), "flexureStrength");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy20gLikeInsensitive(String value) {
            addCriterion("upper(dielectric_loss_by20G) like", value.toUpperCase(), "dielectricLossBy20g");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy19gLikeInsensitive(String value) {
            addCriterion("upper(dielectric_loss_by1_9G) like", value.toUpperCase(), "dielectricLossBy19g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy15gLikeInsensitive(String value) {
            addCriterion("upper(permittivity_by15G) like", value.toUpperCase(), "permittivityBy15g");
            return (Criteria) this;
        }

        public Criteria andPermittivityBy19gLikeInsensitive(String value) {
            addCriterion("upper(permittivity_by1_9G) like", value.toUpperCase(), "permittivityBy19g");
            return (Criteria) this;
        }

        public Criteria andDielectricStrengthLikeInsensitive(String value) {
            addCriterion("upper(dielectric_strength) like", value.toUpperCase(), "dielectricStrength");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy125LikeInsensitive(String value) {
            addCriterion("upper(insulation_resistance_by125) like", value.toUpperCase(), "insulationResistanceBy125");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBy25LikeInsensitive(String value) {
            addCriterion("upper(insulation_resistance_by25) like", value.toUpperCase(), "insulationResistanceBy25");
            return (Criteria) this;
        }

        public Criteria andTemperatureAlterationRatioLikeInsensitive(String value) {
            addCriterion("upper(temperature_alteration_ratio) like", value.toUpperCase(), "temperatureAlterationRatio");
            return (Criteria) this;
        }

        public Criteria andDielectricLossBy1mhzLikeInsensitive(String value) {
            addCriterion("upper(dielectric_loss_by1MHz) like", value.toUpperCase(), "dielectricLossBy1mhz");
            return (Criteria) this;
        }

        public Criteria andPermittivityLikeInsensitive(String value) {
            addCriterion("upper(permittivity) like", value.toUpperCase(), "permittivity");
            return (Criteria) this;
        }

        public Criteria andPowderDensityLikeInsensitive(String value) {
            addCriterion("upper(powder_density) like", value.toUpperCase(), "powderDensity");
            return (Criteria) this;
        }

        public Criteria andSpecificSurfaceareaLikeInsensitive(String value) {
            addCriterion("upper(specific_surfaceArea) like", value.toUpperCase(), "specificSurfacearea");
            return (Criteria) this;
        }

        public Criteria andD90LikeInsensitive(String value) {
            addCriterion("upper(d90) like", value.toUpperCase(), "d90");
            return (Criteria) this;
        }

        public Criteria andD50LikeInsensitive(String value) {
            addCriterion("upper(d50) like", value.toUpperCase(), "d50");
            return (Criteria) this;
        }

        public Criteria andD10LikeInsensitive(String value) {
            addCriterion("upper(d10) like", value.toUpperCase(), "d10");
            return (Criteria) this;
        }

        public Criteria andSinteringTemperatureLikeInsensitive(String value) {
            addCriterion("upper(sintering_temperature) like", value.toUpperCase(), "sinteringTemperature");
            return (Criteria) this;
        }

        public Criteria andSoakingTimeLikeInsensitive(String value) {
            addCriterion("upper(soaking_time) like", value.toUpperCase(), "soakingTime");
            return (Criteria) this;
        }

        public Criteria andPerformanceLikeInsensitive(String value) {
            addCriterion("upper(performance) like", value.toUpperCase(), "performance");
            return (Criteria) this;
        }

        public Criteria andPadMetallurgyLikeInsensitive(String value) {
            addCriterion("upper(pad_metallurgy) like", value.toUpperCase(), "padMetallurgy");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection1LikeInsensitive(String value) {
            addCriterion("upper(out_of_band_rejection1) like", value.toUpperCase(), "outOfBandRejection1");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection2LikeInsensitive(String value) {
            addCriterion("upper(out_of_band_rejection2) like", value.toUpperCase(), "outOfBandRejection2");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection3LikeInsensitive(String value) {
            addCriterion("upper(out_of_band_rejection3) like", value.toUpperCase(), "outOfBandRejection3");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection4LikeInsensitive(String value) {
            addCriterion("upper(out_of_band_rejection4) like", value.toUpperCase(), "outOfBandRejection4");
            return (Criteria) this;
        }

        public Criteria andOutOfBandRejection5LikeInsensitive(String value) {
            addCriterion("upper(out_of_band_rejection5) like", value.toUpperCase(), "outOfBandRejection5");
            return (Criteria) this;
        }

        public Criteria andPdNameLikeInsensitive(String value) {
            addCriterion("upper(pd_name) like", value.toUpperCase(), "pdName");
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