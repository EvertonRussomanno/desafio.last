package com.dio.desafio.last.controller.dto;

import com.dio.desafio.last.domain.model.product.PriceComposition;

import java.math.BigDecimal;

public record PriceCompositionDto(Long id, BigDecimal costPrice, Double profitInPercent, Double tax) {

    public PriceCompositionDto(PriceComposition model){
        this(model.getId(), model.getCostPrice(), model.getProfitInPercent(), model.getTax());
    }

    public PriceComposition toModel(){
        PriceComposition model = new PriceComposition();
        model.setId(this.id);
        model.setCostPrice(this.costPrice);
        model.setProfitInPercent(this.profitInPercent);
        model.setTax(this.tax);
        return model;
    }
}
