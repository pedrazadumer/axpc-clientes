package axpc.micros.clientes.rest.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class RegistrarProductorDto {

    @NotBlank
    private String identificacion;
    @NotBlank
    private String tipoIdentificacion;
    @NotBlank
    private String primerNombre;
    private String segundoNombre;
    @NotBlank
    private String primerApellido;
    private String segundoApellido;
    @NotBlank
    private String correo;
    private String usuario;
    @NotBlank
    private String clave;

}
