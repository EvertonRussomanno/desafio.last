package com.dio.desafio.last.domain.model.product;

import jakarta.persistence.*;
import lombok.Getter;


import java.math.BigDecimal;

@Entity(name = "tb_price_composition")
@Getter
public class PriceComposition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision = 13, scale = 2)
    private BigDecimal costPrice;

    private Double profitInPercent;

    private Double tax;

    public void setId(Long id) {this.id = id;}

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public void setProfitInPercent(Double profitInPercent) {
        this.profitInPercent = (profitInPercent/100);
    }

    public void setTax(Double tax) {
        this.tax = (tax/100);
    }
}
