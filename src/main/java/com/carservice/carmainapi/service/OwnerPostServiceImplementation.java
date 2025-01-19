package com.carservice.carmainapi.service;

import com.carservice.carmainapi.client.CarPostStoreClient;
import com.carservice.carmainapi.dto.OwnerPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImplementation implements OwnerPostService {

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    @Override
    public void createOwnerCar(OwnerPostDto ownerPostDto) {
        carPostStoreClient.ownerPostsClient(ownerPostDto);
    }
}
