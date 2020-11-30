package axpc.micros.clientes.rest.dto;

import lombok.Data;

@Data
public class CompradorDto {
    private String usuario;
    private String identificacion;
    private String tipoIdentificacion;
    private String nombre;
    private String correo;
}
