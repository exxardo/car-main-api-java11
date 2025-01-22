package com.carservice.carmainapi.service;

import com.carservice.carmainapi.dto.CarPostDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interface que define os serviços relacionados à gestão de carros à venda.
 * Esta interface é implementada por uma classe de serviço para lidar com
 * operações de negócios envolvendo carros à venda, como obter, alterar e remover.
 */
@Service
public interface CarPostStoreService {

    /**
     * Obtém a lista de carros disponíveis para venda.
     *
     * @return Lista de objetos {@link CarPostDto} contendo informações sobre os carros à venda.
     */
    List<CarPostDto> getCarForSales();

    /**
     * Altera as informações de um carro à venda.
     *
     * @param carPost Objeto {@link CarPostDto} contendo os dados atualizados do carro.
     * @param id Identificador único do carro.
     */
    void changeCarForSale(CarPostDto carPost, String id);

    /**
     * Remove um carro da venda utilizando seu identificador.
     *
     * @param id Identificador único do carro a ser removido.
     */
    void removeCarForSale(String id);
}
