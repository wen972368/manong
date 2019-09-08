package com.manong.service;

import pojo.EasyUITree;
import pojo.ResponseJsonResult;

import java.util.List;

public interface ProductCategoryService {
    List<EasyUITree> findProductCategoryListByParentId(Short parentId);
    ResponseJsonResult addCategory(Short paentId,String name);
    ResponseJsonResult deleteCategory(Short parentId,Short id);
    ResponseJsonResult modifyCategory(Short parentId,Short id,String name);
}
