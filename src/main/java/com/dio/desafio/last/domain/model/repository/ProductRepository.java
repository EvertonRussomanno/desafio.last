package com.dio.desafio.last.domain.model.repository;

import com.dio.desafio.last.domain.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
