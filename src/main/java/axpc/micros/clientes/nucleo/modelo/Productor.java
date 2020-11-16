package axpc.micros.clientes.nucleo.modelo;

import lombok.Data;

@Data
public class Productor {

    private String identificacion;
    private String tipoIdentificacion;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String correo;
    private String usuario;
    private String clave;

}
