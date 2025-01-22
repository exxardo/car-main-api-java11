package com.carservice.carmainapi.dto;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) para representar informações de um carro à venda.
 * Este objeto é utilizado para transferir dados entre as camadas da aplicação
 * e também para serialização/deserialização em APIs REST.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonAppend
public class CarPostDto {

    private String model;
    private String brand;
    private Double price;
    private String description;
    private String engineVersion;
    private String city;
    private String createdDate;
    private String ownerId;
    private String ownerName;
    private String ownerType;
    private String contact;
}

