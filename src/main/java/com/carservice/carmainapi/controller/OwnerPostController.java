package com.carservice.carmainapi.controller;

import com.carservice.carmainapi.dto.OwnerPostDto;
import com.carservice.carmainapi.service.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST responsável por gerenciar operações relacionadas aos proprietários de carros.
 * Fornece um endpoint para criar registros de proprietários.
 */
@RestController
@RequestMapping("/api/v1/owner")
public class OwnerPostController {

    @Autowired
    private OwnerPostService ownerPostService;

    /**
     * Endpoint para criar um novo registro de proprietário de carro.
     *
     * @param ownerPostDto Objeto contendo os dados do proprietário.
     * @return Retorna o status HTTP 201 (CREATED) se a operação for bem-sucedida.
     */
    @PostMapping
    public ResponseEntity createOwnerCar(@RequestBody OwnerPostDto ownerPostDto) {
        ownerPostService.createOwnerCar(ownerPostDto); // Chama o serviço para criar o proprietário.
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
