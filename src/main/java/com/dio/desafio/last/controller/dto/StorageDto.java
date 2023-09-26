package com.dio.desafio.last.controller.dto;

import com.dio.desafio.last.domain.model.product.Storage;

public record StorageDto(Long id, String locationShelf, Integer levelShelf, Integer drawer, Double quantity, String meterUnity) {

    public StorageDto(Storage model){
        this(model.getId(), model.getLocationShelf(), model.getLevelShelf(), model.getDrawer(), model.getQuantity(), model.getMeterUnity());
    }

    public Storage toModel(){
        Storage model = new Storage();
        model.setId(this.id);
        model.setLocationShelf(this.locationShelf);
        model.setLevelShelf(this.levelShelf);
        model.setDrawer(this.drawer);
        model.setQuantity(this.quantity);
        model.setMeterUnity(this.meterUnity);
        return model;
    }
}
