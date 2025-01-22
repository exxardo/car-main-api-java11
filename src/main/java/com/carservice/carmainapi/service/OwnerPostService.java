package com.carservice.carmainapi.service;

import com.carservice.carmainapi.dto.OwnerPostDto;
import org.springframework.stereotype.Service;

/**
 * Interface que define os serviços relacionados à criação de proprietários de carros.
 * Esta interface será implementada por uma classe de serviço para lidar com a criação
 * de informações sobre o proprietário de um carro.
 */
@Service
public interface OwnerPostService {

    /**
     * Cria um novo proprietário de carro com base nas informações fornecidas.
     *
     * @param ownerPostDto Objeto {@link OwnerPostDto} contendo os dados do proprietário a ser criado.
     */
    void createOwnerCar(OwnerPostDto ownerPostDto);
}
