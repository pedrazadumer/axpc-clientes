package axpc.micros.clientes.rest.dto;

import lombok.Data;

@Data
public class RespuestaErrorDto {

    private String error;
    private String descripcionError;

}
