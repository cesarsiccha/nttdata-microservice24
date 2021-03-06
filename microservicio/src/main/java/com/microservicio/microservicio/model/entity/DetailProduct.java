package com.microservicio.microservicio.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Document("DetalleProductoCliente")
@Data
@NoArgsConstructor
public class DetailProduct {

    @Id
    private String idDetalleProducto;
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message = "La categoria no puede ser vacia")
    private Client idClient;
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull(message = "La categoria no puede ser vacia")
    private Product idProduct;
    @NotEmpty(message = "el numero de cuenta no puede ser vacio")
    private String numeroCuenta;
    @Positive(message = "El monto debe ser mayor o igual que cero")
    private Double monto;
    @Transient
    private Long movimiento;
    @Transient
    private Double mantenimiento;

    private String estado;
}
