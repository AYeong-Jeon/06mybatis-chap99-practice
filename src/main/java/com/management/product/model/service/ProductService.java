package com.management.product.model.service;

import com.common.SearchCondition;
import com.management.product.model.dao.ProductDAO;
import com.management.product.model.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.common.Template.getSqlSessionFactory;

public class ProductService {

    ProductDAO productDAO;

    public List<ProductDTO> selectAllProductList() {
        SqlSession sqlSession = getSqlSessionFactory();

        ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
        List<ProductDTO> menuList = mapper.selectAllProductList();

        sqlSession.close();

        return menuList;
    }

    public List<ProductDTO> selectProductByCondition(SearchCondition searchCondition) {
        SqlSession sqlSession = getSqlSessionFactory();
        ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);

        List<ProductDTO> productList = mapper.selectProductByCondition(searchCondition);

        sqlSession.close();

        return productList;

    }

    public boolean registNewProduct(ProductDTO product) {
        SqlSession sqlSession = getSqlSessionFactory();
        ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);

        int result = mapper.registNewProduct(product);

        sqlSession.close();

        return result > 0;

    }

    public boolean modifyProductInfo(ProductDTO product) {
        SqlSession sqlSession = getSqlSessionFactory();
        ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);

        int result = mapper.modifyProductInfo(product);

        sqlSession.close();

        return result > 0;
    }

    public boolean deleteProduct(int productCode) {
        SqlSession sqlSession = getSqlSessionFactory();
        ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);

        int result = mapper.deleteProduct(productCode);

        sqlSession.close();

        return result > 0;
    }
}
