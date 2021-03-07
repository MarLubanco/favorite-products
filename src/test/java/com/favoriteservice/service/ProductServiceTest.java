package com.favoriteservice.service;


import com.favoriteservice.FavoriteServiceApplication;
import com.favoriteservice.dto.PageResult;
import com.favoriteservice.exception.NotExistProductException;
import com.favoriteservice.exception.ProductUniqueException;
import com.favoriteservice.model.Client;
import com.favoriteservice.model.Product;
import javassist.NotFoundException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FavoriteServiceApplication.class)
public class ProductServiceTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private ClienteService clienteService;
    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void findAllProductsByPage_findProductsByPagination_ok() {
        PageResult allProductsByPage = productService.findAllProductsByPage(1);
        Assert.assertTrue(allProductsByPage.getProducts().size() > 0);
    }

    @Test
    public void saveProductFavoriteById_persistNewProductInClient_ok() throws NotFoundException {
        Client client = Client.builder().name("Viniciues").email("vini2@gmail.com").build();
        Client clientSave = clienteService.save(client);
        Product product = productService.saveProductFavoriteById("1bf0f365-fbdd-4e21-9786-da459d78dd1f", clientSave.getId());
        Assert.assertEquals("1bf0f365-fbdd-4e21-9786-da459d78dd1f", product.getIdMagalu());
    }

    @Test
    public void saveProductFavoriteById_clientNotExist_error() throws NotFoundException {
        thrown.expect(NotFoundException.class);
        productService.saveProductFavoriteById("1bf0f365-fbdd-4e21-9786-da459d78dd1f", 331);
    }

    @Test
    public void saveProductFavoriteById_productDontExist_error() throws NotFoundException {
        thrown.expect(NotExistProductException.class);
        Client client = Client.builder().name("Luiz").email("luiz2@gmail.com").build();
        clienteService.save(client);
        productService.saveProductFavoriteById("131231231443434sdfsdfe", 1);
    }

    @Test
    public void saveProductFavoriteById_productAlreadyAddedByUser_error() throws NotFoundException {
        thrown.expect(ProductUniqueException.class);
        Client client = Client.builder().name("Luiz").email("luiz@gmail.com").build();
        Client clientSave = clienteService.save(client);
        productService.saveProductFavoriteById("1bf0f365-fbdd-4e21-9786-da459d78dd1f", clientSave.getId());
        productService.saveProductFavoriteById("1bf0f365-fbdd-4e21-9786-da459d78dd1f", clientSave.getId());

    }

    @Test
    public void isProductExistInClient_isExist_ok() throws NotFoundException {
        thrown.expect(NotFoundException.class);
        productService.isProductExistInClient(1,"1bf0f365-fbdd-4e21-9786-da459d78dd1f");
    }

    @Test
    public void isProductExistInClient_isDontExist_error() throws NotFoundException {
        Client client = Client.builder().name("Mar").email("mar@gmail.com").build();
        Client clientSave = clienteService.save(client);
        boolean productExistInClient = productService.isProductExistInClient(clientSave.getId(), "131231231443434sdfsdfe");
        Assert.assertFalse(productExistInClient);
    }

}
