package com.carservice.carmainapi.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * Configuração do RestTemplate para realizar chamadas HTTP externas.
 * Define tempos de conexão e leitura, além de criar o bean que pode ser injetado em outras partes do sistema.
 */
@Configuration
public class RestTemplateConfig {

    /**
     * Configura e registra um bean RestTemplate com tempos de timeout personalizados.
     *
     * @param builder Um RestTemplateBuilder usado para construir o RestTemplate.
     * @return Uma instância de RestTemplate configurada.
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofMillis(300000)) // Configura o timeout de conexão para 300.000 ms (5 minutos).
                .setReadTimeout(Duration.ofMillis(300000))    // Configura o timeout de leitura para 300.000 ms (5 minutos).
                .build();
    }
}
