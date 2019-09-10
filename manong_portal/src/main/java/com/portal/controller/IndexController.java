package com.portal.controller;

import com.portal.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Res_Categories;

@Controller
public class IndexController {
    @Autowired
    private CategoriesService categoriesService;

    @RequestMapping("/home.html")
    public String index(ModelMap modelMap) {
        Res_Categories categories=categoriesService.getCategories();
        modelMap.addAttribute("categories",categories);
        return "index";
    }
}
