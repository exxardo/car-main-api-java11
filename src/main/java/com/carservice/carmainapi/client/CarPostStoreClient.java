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

/**
 * Cliente para comunicação com os serviços externos de gerenciamento de carros à venda e proprietários.
 * Utiliza o RestTemplate para realizar requisições HTTP aos serviços REST.
 */
@Component
public class CarPostStoreClient {

    // URI base para o serviço de gerenciamento de usuários.
    private final String USER_STORE_SERVICE_URI = "http://localhost:8080/api/v1/user";

    // URI base para o serviço de gerenciamento de vendas de carros.
    private final String POST_STORE_SERVICE_URI = "http://localhost:8080/api/v1/sales";

    @Autowired
    RestTemplate restTemplate;

    /**
     * Obtém a lista de carros disponíveis para venda do serviço remoto.
     *
     * @return Lista de objetos CarPostDto representando os carros à venda.
     */
    public List<CarPostDto> carForSalesClient() {
        // Realiza uma requisição GET para obter todos os carros disponíveis para venda.
        ResponseEntity<CarPostDto[]> responseEntity =
                restTemplate.getForEntity(POST_STORE_SERVICE_URI + "/cars", CarPostDto[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

    /**
     * Adiciona um novo proprietário no serviço remoto.
     *
     * @param newUser Objeto OwnerPostDto contendo os dados do novo proprietário.
     */
    public void ownerPostsClient(OwnerPostDto newUser) {
        // Realiza uma requisição POST para adicionar um novo proprietário ao serviço.
        restTemplate.postForEntity(USER_STORE_SERVICE_URI, newUser, OwnerPostDto.class);
    }

    /**
     * Atualiza os dados de um carro à venda no serviço remoto.
     *
     * @param carPostDto Objeto CarPostDto contendo os novos dados do carro.
     * @param id ID do carro que será atualizado.
     */
    public void changeCarForSaleClient(CarPostDto carPostDto, String id) {
        // Realiza uma requisição PUT para atualizar os dados do carro especificado.
        restTemplate.put(POST_STORE_SERVICE_URI + "/sales/" + id, carPostDto);
    }

    /**
     * Remove um carro à venda do serviço remoto.
     *
     * @param id ID do carro que será removido.
     */
    public void deleteCarForSaleClient(String id) {
        // Realiza uma requisição DELETE para remover o carro especificado.
        restTemplate.delete(POST_STORE_SERVICE_URI + "/sales/" + id);
    }
}

