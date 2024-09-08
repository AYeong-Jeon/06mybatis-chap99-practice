package com.management.product.controller;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;
import com.management.product.model.service.ProductService;
import com.management.product.view.ProductPrint;

import java.util.List;
import java.util.Map;

public class ProductController {

    ProductService productService = new ProductService();
    ProductPrint productPrint = new ProductPrint();

    public void selectAllProductList() {
        List<ProductDTO> allProductList =  productService.selectAllProductList();
        if(allProductList != null && !allProductList.isEmpty()) {
            productPrint.printAllProductList(allProductList);
        } else {
            productPrint.printErrorMessage("select");
        }
    }

    public void selectProductByCondition(SearchCondition searchCondition) {
        List<ProductDTO> productListByCondition = productService.selectProductByCondition(searchCondition);

        if(productListByCondition != null && !productListByCondition.isEmpty()) {
            productPrint.printProductList(productListByCondition);
        } else {
            productPrint.printErrorMessage("select");
        }

    }

    public void registNewProduct(ProductDTO product) {
        boolean result = productService.registNewProduct(product);

        if(result) {
            productPrint.printSuccessMessage("regist");
        } else {
            productPrint.printErrorMessage("regist");
        }
    }

    public void modifyProductInfo(ProductDTO product) {
        boolean result = productService.modifyProductInfo(product);

        if(result) {
            productPrint.printSuccessMessage("modify");
        } else {
            productPrint.printErrorMessage("modify");
        }
    }

    public void deleteProduct(int productCode) {
        boolean result = productService.deleteProduct(productCode);

        if(result) {
            productPrint.printSuccessMessage("delete");
        } else {
            productPrint.printErrorMessage("delete");
        }
    }
}
