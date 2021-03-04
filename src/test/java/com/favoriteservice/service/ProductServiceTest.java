package com.favoriteservice.service;


import com.favoriteservice.FavoriteServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FavoriteServiceApplication.class)
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void findAllProductsByPage_findProductsByPagination_ok() {

    }

    @Test
    public void saveProductFavoriteById_persistNewProductInClient_ok() {

    }

    @Test
    public void saveProductFavoriteById_productDontExist_error() {

    }

    @Test
    public void saveProductFavoriteById_productAlreadyAddedByUser_error() {

    }

    @Test
    public void isProductExistInClient_isExist_ok() {

    }

    @Test
    public void isProductExistInClient_isDontExist_ok() {

    }



}
