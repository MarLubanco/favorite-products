package com.favoriteservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    private Double price;
    private String image;
    private String brand;
    private String id;
    private String title;
}
