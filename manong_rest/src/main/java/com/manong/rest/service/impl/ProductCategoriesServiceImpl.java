package com.manong.rest.service.impl;

import com.manong.mapper.ProductCategoryMapper;
import com.manong.pojo.ProductCategory;
import com.manong.pojo.ProductCategoryExample;
import com.manong.rest.service.ProductCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Res_Categories;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoriesServiceImpl implements ProductCategoriesService{
    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Override
    public Res_Categories getCategories() {
        Res_Categories res_categories = new Res_Categories();
        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();
        criteria.andParentIdEqualTo((short) 0);
        List<ProductCategory> productCategoryList = productCategoryMapper.selectByExample(productCategoryExample);
        List<Res_Categories.CategoriesBean> categoriesBeans = new ArrayList<>();
        for (int i = 0; i < productCategoryList.size(); i++) {
            Res_Categories.CategoriesBean categoriesBean = new Res_Categories.CategoriesBean();
            ProductCategory productCategory = productCategoryList.get(i);
            categoriesBean.setCat_id(productCategory.getId().toString());
            categoriesBean.setName(productCategory.getName());
            List<Res_Categories.CategoriesBean.SubCetegoriesBean> subCetegoriesBeans = getSubCategories(productCategory.getId());
            categoriesBean.setSub_cetegories(subCetegoriesBeans);
            categoriesBeans.add(categoriesBean);
        }
        res_categories.setCategories(categoriesBeans);
        return res_categories;
    }
    //获取二级分类
    private List<Res_Categories.CategoriesBean.SubCetegoriesBean> getSubCategories(Short id) {
        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria=productCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(id);
        List<ProductCategory> productCategoryList = productCategoryMapper.selectByExample(productCategoryExample);
        List<Res_Categories.CategoriesBean.SubCetegoriesBean> subCetegoriesBeans=new ArrayList<>();
        for (int i=0;i<productCategoryList.size();i++){
            Res_Categories.CategoriesBean.SubCetegoriesBean subCetegoriesBean=new Res_Categories.CategoriesBean.SubCetegoriesBean();
            ProductCategory productCategory = productCategoryList.get(i);
            subCetegoriesBean.setCat_id(productCategory.getId().toString());
            subCetegoriesBean.setName(productCategory.getName());
            subCetegoriesBeans.add(subCetegoriesBean);
        }
        return subCetegoriesBeans;
    }
}
