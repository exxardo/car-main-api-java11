package com.carservice.carmainapi.client;

import com.carservice.carmainapi.dto.CarPostDto;
import com.carservice.carmainapi.dto.OwnerPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CarPostStoreClient {

    private final String USER_STORE_SERVICE_URI = "http://localhost:8080/api/v1/user";
    private final String POST_STORE_SERVICE_URI = "http://localhost:8080/api/v1/sales";

    @Autowired
    RestTemplate restTemplate;

    public List<CarPostDto> carForSalesClient() {
        ResponseEntity<CarPostDto[]> responseEntity = restTemplate.getForEntity(POST_STORE_SERVICE_URI + "/cars", CarPostDto[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

    public void ownerPostsClient(OwnerPostDto newUser) {
        restTemplate.postForEntity(USER_STORE_SERVICE_URI, newUser, OwnerPostDto.class);
    }

    public void changeCarForSaleClient(CarPostDto carPostDto, String id) {
        restTemplate.put(POST_STORE_SERVICE_URI + "/sales/" + id, carPostDto);
    }

    public void deleteCarForSaleClient(String id) {
        restTemplate.delete(POST_STORE_SERVICE_URI + "/sales/" + id);
    }
}
