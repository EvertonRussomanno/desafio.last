package com.dio.desafio.last.controller.dto;

import com.dio.desafio.last.domain.model.product.Description;
import com.dio.desafio.last.domain.model.product.Features;
import static java.util.Optional.ofNullable;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;


import java.math.BigDecimal;
import java.util.List;

public record DescriptionDto(
        Long id,
        String manufacturer,
        List<FeaturesDto> features,
        String ncmCode,
        String barcode,
        BigDecimal salePrice) {

    public DescriptionDto(Description model){
        this(
                model.getId(),
                model.getManufacturer(),
                ofNullable(model.getFeatures()).orElse(emptyList()).stream().map(FeaturesDto::new).collect(toList()),
                model.getNcmCode(),
                model.getBarcode(),
                model.getSalePrice());
    }

    public Description toModel() {
        Description model = new Description();
        model.setId(this.id);
        model.setManufacturer(this.manufacturer);
        model.setFeatures(ofNullable(this.features).orElse(emptyList()).stream().map(FeaturesDto::toModel).collect(toList()));
        model.setNcmCode(this.ncmCode);
        model.setBarcode(this.barcode);
        model.setSalePrice(this.salePrice);
        return model;
    }
}
