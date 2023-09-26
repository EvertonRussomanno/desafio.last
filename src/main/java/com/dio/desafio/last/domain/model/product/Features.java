package com.dio.desafio.last.domain.model.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//@MappedSuperclass
@Entity(name = "tb_features")
@Getter
@Setter
public class Features {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameFeature;

    private String descriptionFeature;

}
