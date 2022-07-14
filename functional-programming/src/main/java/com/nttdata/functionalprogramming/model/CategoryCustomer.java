package com.nttdata.functionalprogramming.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Table(name="CategoryCustomer")
@Data
@NoArgsConstructor
public class CategoryCustomer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoryClient;
    @NotEmpty(message = "La descripcion no puede ser vacío")
    @Column(name="descripcion", nullable=false)
    private String description;
    private String state;
}
