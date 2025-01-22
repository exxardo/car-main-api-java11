package com.carservice.carmainapi.controller;

import com.carservice.carmainapi.dto.CarPostDto;
import com.carservice.carmainapi.message.KafkaProducerMassage;
import com.carservice.carmainapi.service.CarPostStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST responsável por gerenciar operações relacionadas a carros à venda.
 * Disponibiliza endpoints para adicionar, consultar, atualizar e remover carros à venda.
 */
@RestController
@RequestMapping("/api/v1/car")
public class CarPostController {

    @Autowired
    private CarPostStoreService carPostStoreService;

    @Autowired
    private KafkaProducerMassage kafkaProducerMessage;

    /**
     * Endpoint para publicar um novo carro à venda.
     * Envia a mensagem para um tópico Kafka antes de persistir as informações.
     *
     * @param carPostDto Objeto contendo os dados do carro a ser publicado.
     * @return Retorna o status HTTP 200 (OK) caso a operação seja bem-sucedida.
     */
    @PostMapping("/post")
    public ResponseEntity postCarForSale(@RequestBody CarPostDto carPostDto) {
        kafkaProducerMessage.sendMessage(carPostDto); // Envia os dados para um tópico Kafka.
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Endpoint para obter a lista de carros à venda.
     *
     * @return Retorna uma lista de objetos CarPostDto com status HTTP 302 (FOUND).
     */
    @GetMapping("/posts")
    public ResponseEntity<List<CarPostDto>> getCarForSales() {
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostStoreService.getCarForSales());
    }

    /**
     * Endpoint para atualizar os dados de um carro à venda.
     *
     * @param carPostDto Objeto contendo os novos dados do carro.
     * @param id ID do carro que será atualizado.
     * @return Retorna o status HTTP 200 (OK) caso a operação seja bem-sucedida.
     */
    @PutMapping("/{id}")
    public ResponseEntity changeCarSale(@RequestBody CarPostDto carPostDto, @PathVariable("id") String id) {
        carPostStoreService.changeCarForSale(carPostDto, id); // Atualiza as informações do carro no serviço.
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Endpoint para remover um carro à venda.
     *
     * @param id ID do carro que será removido.
     * @return Retorna o status HTTP 200 (OK) caso a operação seja bem-sucedida.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarForSale(@PathVariable("id") String id) {
        carPostStoreService.removeCarForSale(id); // Remove o carro do serviço.
        return new ResponseEntity(HttpStatus.OK);
    }
}
