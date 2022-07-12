package com.microservicio.microservicio.repository;

import com.microservicio.microservicio.model.entity.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ClienteRepository extends ReactiveCrudRepository<Cliente,String> {
}
