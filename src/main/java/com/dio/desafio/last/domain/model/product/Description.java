package com.dio.desafio.last.domain.model.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity(name = "tb_description")
@Getter
@Setter
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String manufacturer;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Features> features;

    private String ncmCode;

    @Column(unique = true)
    private String barcode;

    @Column(precision = 13, scale = 2)
    private BigDecimal salePrice;

}
