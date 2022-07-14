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

@Document("Titular")
@Data
@NoArgsConstructor
public class HolderPerson {
    @Id
    private String idHolderPerson;
    @NotEmpty(message = "el nombre no puede ser vacio")
    private String nombresHolderPerson;
    @NotEmpty(message = "el apellido no puede ser vacio")
    private String apellidosHolderPerson;
    @Size( min = 8 , max = 8, message = "El dni debe tener 8 digitos")
    private String dniHolderPerson;
    private String estado;
}
