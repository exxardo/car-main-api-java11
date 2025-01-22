package com.carservice.carmainapi.service;

import com.carservice.carmainapi.client.CarPostStoreClient;
import com.carservice.carmainapi.dto.CarPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementação da interface {@link CarPostStoreService} que define os serviços relacionados à gestão de carros à venda.
 * Esta classe faz a comunicação com o {@link CarPostStoreClient}, que é responsável pelas interações com a API externa
 * para realizar operações como obtenção, alteração e remoção de carros à venda.
 */
@Service
public class CarPostStoreServiceImplementation implements CarPostStoreService {

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    /**
     * Obtém a lista de carros disponíveis para venda.
     * A comunicação com o serviço externo é feita por meio do {@link CarPostStoreClient}.
     *
     * @return Lista de objetos {@link CarPostDto} contendo as informações dos carros à venda.
     */
    @Override
    public List<CarPostDto> getCarForSales() {
        return carPostStoreClient.carForSalesClient();
    }

    /**
     * Altera as informações de um carro à venda.
     * A comunicação com o serviço externo é feita por meio do {@link CarPostStoreClient}.
     *
     * @param carPost Objeto {@link CarPostDto} contendo os dados atualizados do carro.
     * @param id Identificador único do carro.
     */
    @Override
    public void changeCarForSale(CarPostDto carPost, String id) {
        carPostStoreClient.changeCarForSaleClient(carPost, id);
    }

    /**
     * Remove um carro da venda utilizando seu identificador.
     * A comunicação com o serviço externo é feita por meio do {@link CarPostStoreClient}.
     *
     * @param id Identificador único do carro a ser removido.
     */
    @Override
    public void removeCarForSale(String id) {
        carPostStoreClient.deleteCarForSaleClient(id);
    }
}
