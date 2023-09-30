package com.dio.desafio.last.service.impl;

import com.dio.desafio.last.domain.model.product.Description;
import com.dio.desafio.last.domain.model.product.PriceComposition;
import com.dio.desafio.last.domain.model.product.Product;

import java.math.BigDecimal;

public class SalePriceServiceImpl {

    protected static Product calculateSalePrice(Product productToCreateSalePrice){

        BigDecimal costPrice = productToCreateSalePrice.getPriceComposition().getCostPrice();
        double profitInPercent = 1 + (productToCreateSalePrice.getPriceComposition().getProfitInPercent() / 100);
        double tax = 1 + (productToCreateSalePrice.getPriceComposition().getTax() / 100);

        BigDecimal salePrice = costPrice.multiply(BigDecimal.valueOf(tax));

        salePrice = salePrice.multiply(BigDecimal.valueOf(profitInPercent));

        productToCreateSalePrice.getDescription().setSalePrice(salePrice);

        return productToCreateSalePrice;
    }
}
