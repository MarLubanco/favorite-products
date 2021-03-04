package com.favoriteservice.controller;

import com.favoriteservice.dto.PageResult;
import com.favoriteservice.exception.ProductUniqueException;
import com.favoriteservice.model.Product;
import com.favoriteservice.service.ProductService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService producService;

    @GetMapping("{page}")
    public PageResult findAllProductsByPage(@PathVariable Integer page) {
        return producService.findAllProductsByPage(page);
    }

    @PostMapping("/{productId}/client/{clientId}")
    @ExceptionHandler({ ProductUniqueException.class, NotFoundException.class })
    public Product saveFavoriteProduct(@PathVariable String productId,
                                       @PathVariable Integer clientId) throws ProductUniqueException, NotFoundException {
        return producService.saveProductFavoriteById(productId, clientId);
    }

}
