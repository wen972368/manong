package com.manong.controller;

import com.manong.pojo.Product;
import com.manong.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.ResponseJsonResult;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("product_list")
    public String listProduct(){
        return "product_list";
    }
    @RequestMapping("/product_save")
    @ResponseBody
    public ResponseJsonResult saveProduct(Product product){
        return productService.saveProcuct(product) ;
    }
}
