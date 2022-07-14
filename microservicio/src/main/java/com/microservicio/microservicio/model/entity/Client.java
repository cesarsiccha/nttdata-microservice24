package com.microservicio.microservicio.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document("Cliente")
@Data
@NoArgsConstructor
public class Client {
    @Id
    private String idClient;
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message = "La categoria no puede ser vacia")
    private CategoryClient idCategoryClient;
    @NotEmpty(message = "el titular no puede ser vacio")
    private HolderPerson holderPerson;
    private String estado;
}
