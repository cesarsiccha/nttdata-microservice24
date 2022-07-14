package com.nttdata.functionalprogramming.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Document("CategoryClient")
@Data
@NoArgsConstructor
public class CategoryCustomer {

    @Id
    private String idCategoryClient;
    @NotEmpty(message = "La descripcion no puede ser vacío")
    @Column(name="descripcion", nullable=false)
    private String description;
    private String state;
}
