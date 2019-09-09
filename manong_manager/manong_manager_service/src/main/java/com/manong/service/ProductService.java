package com.manong.service;

import com.manong.pojo.Product;
import pojo.EasyGrid;
import pojo.ResponseJsonResult;

public interface ProductService {
    ResponseJsonResult saveProcuct(Product product);
    EasyGrid listProduct(int page,int rows);
}
