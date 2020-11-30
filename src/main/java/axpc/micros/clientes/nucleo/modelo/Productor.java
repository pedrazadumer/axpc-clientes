package axpc.micros.clientes.nucleo.modelo;

import lombok.Data;

import java.util.List;

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
    private String telefono;
    private String departamento;
    private String ciudad;
    private String direccion;
    private List<Producto> productos;

}
