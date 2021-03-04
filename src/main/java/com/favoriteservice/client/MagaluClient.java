package com.favoriteservice.client;

import com.favoriteservice.dto.PageResult;
import com.favoriteservice.dto.ProductRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "magalu", url = "http://challenge-api.luizalabs.com/api/product/")
public interface MagaluClient {

    @GetMapping("/{id}/")
    ProductRequest getProductsById(@PathVariable String id);

    @GetMapping("/?page={page}")
    PageResult getProductByPage(@PathVariable Integer page);
}
