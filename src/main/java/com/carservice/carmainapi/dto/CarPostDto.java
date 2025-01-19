package com.carservice.carmainapi.dto;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonAppend
public class CarPostDto {

    private String model;
    private String brand;
    private String price;
    private String Description;
    private String engineVersion;
    private String city;
    private String createdDate;
    private String ownerId;
    private String ownerName;
    private String ownerType;
    private String contact;

}
