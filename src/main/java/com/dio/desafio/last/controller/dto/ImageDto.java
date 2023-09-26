package com.dio.desafio.last.controller.dto;

import com.dio.desafio.last.domain.model.product.Image;

public record ImageDto(Long id, String iconUrl, String iconDescription) {

    public ImageDto(Image model){
        this(model.getId(), model.getIconUrl(), model.getIconDescription());
    }

    public Image toModel(){
        Image model = new Image();
        model.setId(this.id);
        model.setIconUrl(this.iconUrl);
        model.setIconDescription(this.iconDescription);
        return model;
    }
}
