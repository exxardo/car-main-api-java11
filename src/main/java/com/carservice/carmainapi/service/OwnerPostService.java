package com.carservice.carmainapi.service;

import com.carservice.carmainapi.dto.OwnerPostDto;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {
    void createOwnerCar(OwnerPostDto ownerPostDto);
}
