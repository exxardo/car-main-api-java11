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
public class OwnerPostDto {

    private String name;
    private String type;
    private String contactNumber;

}
