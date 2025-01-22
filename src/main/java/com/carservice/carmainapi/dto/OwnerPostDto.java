package com.carservice.carmainapi.dto;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) para representar informações de um proprietário de carro.
 * Este objeto é utilizado para transferir dados entre as camadas da aplicação
 * e também para serialização/deserialização em APIs REST.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonAppend
public class OwnerPostDto {

    private String name;
    private String type;
    private String contactNumber;
}
