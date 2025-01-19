package com.carservice.carmainapi.service;

import com.carservice.carmainapi.dto.CarPostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostStoreService {

    List<CarPostDto> getCarForSales();

    void changeCarForSale(CarPostDto carPost, String id);

    void removeCarForSale(String id);
}
