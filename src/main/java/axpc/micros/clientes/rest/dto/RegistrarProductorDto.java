package axpc.micros.clientes.rest.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

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

    private String telefono;
    private String departamento;
    private String ciudad;
    private String direccion;
    @Valid
    private List<ProductoDto> productos = Collections.emptyList();
}
