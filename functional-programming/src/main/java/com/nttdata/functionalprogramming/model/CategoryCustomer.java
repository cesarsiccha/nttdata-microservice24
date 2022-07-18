package com.nttdata.functionalprogramming.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Table(name="CategoryCustomer")
@Data
@Entity
public class CategoryCustomer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoryCustomer;
    @NotEmpty(message = "La descripcion no puede ser vacío")
    private String description;
    private String state;
}
