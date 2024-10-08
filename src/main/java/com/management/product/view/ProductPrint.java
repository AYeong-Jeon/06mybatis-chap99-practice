package com.management.product.view;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;

import java.util.List;

public class ProductPrint {

    public void printAllProductList(List<ProductDTO> allProductList) {
        if(allProductList != null && !allProductList.isEmpty()){
            allProductList.forEach(System.out::println);
        } else {
            System.out.println("조회할 상품이 없습니다.");
        }

    }

    public void printProductList(List<ProductDTO> productList) {
        if(productList != null && !productList.isEmpty()) {
            productList.forEach(System.out::println);
        } else {
            System.out.println("조회할 상품이 없습니다.");
        }
    }

    public void printSuccessMessage(String successCode) {
        switch (successCode) {
            case "select":
                System.out.println("제품 조회 완료");
            case "regist":
                System.out.println("제품 등록 완료");
            case "modify":
                System.out.println("제품 수정 완료");
            case "delete":
                System.out.println("제품 삭제 완료");
        }
    }

    public void printErrorMessage(String errorCode) {
        switch (errorCode) {
            case "select":
                System.out.println("제품 조회 실패");
            case "regist":
                System.out.println("제품 등록 실패");
            case "modify":
                System.out.println("제품 수정 실패");
            case "delete":
                System.out.println("제품 삭제 실패");
        }

    }

}
