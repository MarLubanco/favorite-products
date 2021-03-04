package com.favoriteservice.repository;

import com.favoriteservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducRepository extends JpaRepository<Product, Integer> {
}
