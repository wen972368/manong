package com.manong.rest.controller;

import com.manong.mapper.ProductCategoryMapper;
import com.manong.pojo.ProductCategory;
import com.manong.pojo.ProductCategoryExample;
import com.manong.rest.service.ProductCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Res_Categories;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rest")
public class ProductCategoriesController {
    @Autowired
    private ProductCategoriesService productCategoriesService;
    @RequestMapping("/productCategories/list")
    @ResponseBody
    public Res_Categories getCategories() {
        Res_Categories categories = productCategoriesService.getCategories();
        return categories;
    }
}
