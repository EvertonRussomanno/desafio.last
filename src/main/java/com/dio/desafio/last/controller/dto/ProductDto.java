package com.dio.desafio.last.controller.dto;

import com.dio.desafio.last.domain.model.product.*;

import static java.util.Optional.ofNullable;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;

public record ProductDto(
        Long id,
        String productName,
        DescriptionDto description,
        PriceCompositionDto priceComposition,
        StorageDto storage,
        List<ImageDto> images) {

    public ProductDto(Product model){
        this(
                model.getId(),
                model.getProductName(),
                ofNullable(model.getDescription()).map(DescriptionDto::new).orElse(null),
                ofNullable(model.getPriceComposition()).map(PriceCompositionDto::new).orElse(null),
                ofNullable(model.getStorage()).map(StorageDto::new).orElse(null),
                ofNullable(model.getImages()).orElse(emptyList()).stream().map(ImageDto::new).collect(toList())
        );
    }

    public Product toModel(){
        Product model = new Product();
        model.setId(this.id);
        model.setProductName(this.productName);
        model.setDescription(ofNullable(this.description).map(DescriptionDto::toModel).orElse(null));
        model.setPriceComposition(ofNullable(this.priceComposition).map(PriceCompositionDto::toModel).orElse(null));
        model.setStorage(ofNullable(this.storage).map(StorageDto::toModel).orElse(null));
        model.setImages(ofNullable(this.images).orElse(emptyList()).stream().map(ImageDto::toModel).collect(toList()));
        return model;
    }
}
