package com.dio.desafio.last.domain.model.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity(name = "tb_product")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String productName;

    @OneToOne(cascade = CascadeType.ALL)
    private Description description;

    @OneToOne(cascade = CascadeType.ALL)
    private PriceComposition priceComposition;

    @OneToOne(cascade = CascadeType.ALL)
    private Storage storage;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Image> images;
}
