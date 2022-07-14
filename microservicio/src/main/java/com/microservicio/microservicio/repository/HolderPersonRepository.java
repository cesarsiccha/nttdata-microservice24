package com.microservicio.microservicio.repository;

import com.microservicio.microservicio.model.entity.HolderPerson;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface HolderPersonRepository extends ReactiveCrudRepository<HolderPerson,String> {
}
