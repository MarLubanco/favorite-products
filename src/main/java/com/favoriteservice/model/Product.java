package com.favoriteservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.favoriteservice.dto.ProductRequest;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String image;

    private Double price;

    private String idMagalu;

    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    @JsonBackReference
    private Client client;

    public static Product of(ProductRequest product) {
        Product productNew = new Product();
        productNew.setPrice(product.getPrice());
        productNew.setImage(product.getImage());
        productNew.setTitle(product.getTitle());
        productNew.setIdMagalu(product.getId());
        return productNew;
    }
}
