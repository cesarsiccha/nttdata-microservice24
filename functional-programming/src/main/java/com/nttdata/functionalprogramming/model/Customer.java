package com.nttdata.functionalprogramming.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Table(name="customers")
@Data
@Entity

public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCustomer;

    @NotEmpty(message = "El nombre no puede ser vacío")
    private String firstNameCustomer;

    @NotEmpty(message = "El apellido no puede ser vacío")
    private String lastNameCustomer;

    @NotEmpty(message = "El número de documento no puede ser vacío")
    @Size( min = 8 , max = 8, message = "El tamaño del número de documento es 8")
    private String dniCustomer;

    @NotEmpty(message = "el correo no puede estar vacío")
    @Email(message = "no es un dirección de correo bien formada")
    private String emailCustomer;

    private CategoryCustomer categoryCustomer;

    private String state;
}
