package com.favoriteservice.client;

import com.favoriteservice.dto.PageResult;
import com.favoriteservice.dto.ProductRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "magalu", url = "http://challenge-api.luizalabs.com/api/product/")
public interface MagaluClient {


    /**
     * Get product in Luiza Labs API by ID
     * @param id
     * @return
     */
    @GetMapping("/{id}/")
    ProductRequest getProductsById(@PathVariable String id);

    /**
     * Get Luiza Labs products per page
     * @param page
     * @return
     */
    @GetMapping("/?page={page}")
    PageResult getProductByPage(@PathVariable Integer page);
}
