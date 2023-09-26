package com.dio.desafio.last.controller.dto;

import com.dio.desafio.last.domain.model.product.Description;
import com.dio.desafio.last.domain.model.product.Features;

public record FeaturesDto(Long id, String nameFeature, String descriptionFeature) {

    public FeaturesDto(Features model){
        this(model.getId(), model.getNameFeature(), model.getDescriptionFeature());
    }

    public Features toModel() {
        Features model = new Features();
        model.setId(this.id);
        model.setNameFeature(this.nameFeature);
        model.setDescriptionFeature(this.descriptionFeature);
        return model;
    }
}
