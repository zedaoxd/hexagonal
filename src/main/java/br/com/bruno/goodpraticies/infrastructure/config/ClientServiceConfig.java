package br.com.bruno.goodpraticies.infrastructure.config;

import br.com.bruno.goodpraticies.core.port.ClientServicePort;
import br.com.bruno.goodpraticies.core.port.impl.ClientServiceImpl;
import br.com.bruno.goodpraticies.core.port.ClientRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientServiceConfig {

    @Bean
    ClientServicePort clientServicePort(ClientRepositoryPort clientRepository) {
        return new ClientServiceImpl(clientRepository);
    }
}
