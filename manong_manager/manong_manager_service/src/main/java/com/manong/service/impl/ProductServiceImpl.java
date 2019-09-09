package com.manong.service.impl;

import com.manong.mapper.ProductMapper;
import com.manong.pojo.Product;
import com.manong.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.ResponseJsonResult;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public ResponseJsonResult saveProcuct(Product product) {
        product.setStatus((byte) 1);
        productMapper.insert(product);
        ResponseJsonResult responseJsonResult=new ResponseJsonResult();
        responseJsonResult.setStatus(200);
        return responseJsonResult;
    }
}
