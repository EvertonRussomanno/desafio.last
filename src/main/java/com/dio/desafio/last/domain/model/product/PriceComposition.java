package com.dio.desafio.last.domain.model.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;

@Entity(name = "tb_price_composition")
@Getter
@Setter
public class PriceComposition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision = 13, scale = 2)
    private BigDecimal costPrice;

    private Double profitInPercent;

    private Double tax;

}
