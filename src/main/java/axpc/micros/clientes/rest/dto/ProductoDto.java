package axpc.micros.clientes.rest.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProductoDto {

    @NotNull
    private Integer codigo;
    private String nombre;

}
