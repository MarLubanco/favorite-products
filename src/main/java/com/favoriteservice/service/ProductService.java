package com.favoriteservice.service;

import com.favoriteservice.client.MagaluClient;
import com.favoriteservice.dto.PageResult;
import com.favoriteservice.dto.ProductRequest;
import com.favoriteservice.exception.NotExistProductException;
import com.favoriteservice.exception.ProductUniqueException;
import com.favoriteservice.model.Client;
import com.favoriteservice.model.Product;
import com.favoriteservice.repository.ProducRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductService {

    @Autowired
    private ProducRepository producRepository;
    @Autowired
    private MagaluClient magaluClient;
    @Autowired
    private ClienteService clienteService;

    public PageResult findAllProductsByPage(Integer page) {
        return magaluClient.getProductByPage(page);
    }

    public Product saveProductFavoriteById(String productId, Integer clientId) throws NotFoundException {
        if(!isProductExistInClient(clientId, productId)) {
            ProductRequest product = magaluClient.getProductsById(productId);
            if(!Objects.isNull(product)) {
                Client client = clienteService.findById(clientId);
                Product productNew = Product.of(product);
                productNew.setClient(client);
                return producRepository.save(productNew);
            } else {
                throw new NotExistProductException("This product does not exist.");
            }
        } else {
            throw new ProductUniqueException("This customer has already added this product");
        }
    }

    public boolean isProductExistInClient(Integer idClient, String idProduct) throws NotFoundException {
        return clienteService.findById(idClient).getProductList().stream()
                .anyMatch(product -> product.getIdMagalu().equals(idProduct));
    }
}
