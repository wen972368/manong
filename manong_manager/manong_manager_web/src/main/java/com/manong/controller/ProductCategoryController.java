package com.manong.controller;

import com.manong.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.EasyUITree;
import pojo.ResponseJsonResult;

import javax.naming.Name;
import java.util.List;

@Controller
@RequestMapping("/product_category")
public class ProductCategoryController {
   @Autowired
    private ProductCategoryService productCategoryService;
    /**
     * 根据parentId返回数据列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITree> getProductCategoryByParentId(@RequestParam(value = "id",defaultValue = "0")Short parentId){
        return productCategoryService.findProductCategoryListByParentId(parentId);
    }
    /**
     * 添加分类
     */
    @RequestMapping("/add")
    @ResponseBody
    public ResponseJsonResult addCategory(Short parentId,String name){
        ResponseJsonResult responseJsonResult = productCategoryService.addCategory(parentId, name);
        return  responseJsonResult;
    }
    /**
     * 删除分类
     */
    @RequestMapping("/del")
    @ResponseBody
    public ResponseJsonResult delCategory(Short parentId,Short id){
        ResponseJsonResult responseJsonResult=productCategoryService.deleteCategory(parentId,id);
        return  responseJsonResult;
    }
    /**
     * 修改分类
     */
    @RequestMapping("/modify")
    @ResponseBody
    public ResponseJsonResult modifyCategory(Short parentId,Short id, String name){
        ResponseJsonResult responseJsonResult=productCategoryService.modifyCategory(parentId,id,name);
        return  responseJsonResult;
    }
}
