package com.carservice.carmainapi.service;

import com.carservice.carmainapi.client.CarPostStoreClient;
import com.carservice.carmainapi.dto.OwnerPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementação do serviço {@link OwnerPostService} que lida com a criação de proprietários de carros.
 * A comunicação com a API externa para realizar a criação do proprietário é feita através do {@link CarPostStoreClient}.
 */
@Service
public class OwnerPostServiceImplementation implements OwnerPostService {

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    /**
     * Cria um novo proprietário de carro, utilizando o cliente {@link CarPostStoreClient}
     * para enviar os dados do proprietário para o serviço externo.
     *
     * @param ownerPostDto Objeto {@link OwnerPostDto} contendo as informações do proprietário do carro.
     */
    @Override
    public void createOwnerCar(OwnerPostDto ownerPostDto) {
        carPostStoreClient.ownerPostsClient(ownerPostDto);
    }
}
