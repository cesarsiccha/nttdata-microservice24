package com.microservicio.microservicio.repository;

import com.microservicio.microservicio.model.entity.Client;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ClientRepository extends ReactiveCrudRepository<Client,String> {
}
