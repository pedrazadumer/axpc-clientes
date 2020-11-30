package axpc.micros.clientes.rest.dto.mapeadores;

import axpc.micros.clientes.nucleo.modelo.Comprador;
import axpc.micros.clientes.rest.dto.CompradorDto;
import axpc.micros.clientes.rest.dto.RegistrarCompradorDto;
import org.apache.commons.lang3.StringUtils;

public class MapeadorComprador {

    private static final String ESPACIO = " ";

    public static CompradorDto mapearADto(Comprador comprador) {
        if (comprador == null) throw new IllegalArgumentException("No se puede mapear un Comprador nulo.");

        CompradorDto compradorDto = new CompradorDto();

        compradorDto.setCorreo(comprador.getCorreo());
        compradorDto.setIdentificacion(comprador.getIdentificacion());
        compradorDto.setTipoIdentificacion(comprador.getTipoIdentificacion());
        compradorDto.setUsuario(comprador.getUsuario());

        StringBuilder concatenadorNombre = new StringBuilder();

        if (StringUtils.isNotBlank(comprador.getPrimerNombre())) concatenadorNombre.append(comprador.getPrimerNombre());
        if (StringUtils.isNotBlank(comprador.getSegundoNombre())) concatenadorNombre.append(ESPACIO).append(comprador.getSegundoNombre());
        if (StringUtils.isNotBlank(comprador.getPrimerApellido())) concatenadorNombre.append(ESPACIO).append(comprador.getPrimerApellido());
        if (StringUtils.isNotBlank(comprador.getSegundoApellido())) concatenadorNombre.append(ESPACIO).append(comprador.getSegundoApellido());
        if (concatenadorNombre.length() != 0) compradorDto.setNombre(concatenadorNombre.toString());

        return compradorDto;
    }

    public static Comprador mapearAModelo(RegistrarCompradorDto registrarCompradorDto) {
        if (registrarCompradorDto == null) throw new IllegalArgumentException("No se puede mapear un Comprador nulo.");

        Comprador comprador = new Comprador();

        comprador.setCorreo(registrarCompradorDto.getCorreo());
        comprador.setIdentificacion(registrarCompradorDto.getIdentificacion());
        comprador.setTipoIdentificacion(registrarCompradorDto.getTipoIdentificacion());
        comprador.setUsuario(registrarCompradorDto.getUsuario());
        comprador.setPrimerNombre(registrarCompradorDto.getPrimerNombre());
        comprador.setSegundoNombre(registrarCompradorDto.getSegundoNombre());
        comprador.setPrimerApellido(registrarCompradorDto.getPrimerApellido());
        comprador.setSegundoApellido(registrarCompradorDto.getSegundoApellido());
        comprador.setClave(registrarCompradorDto.getClave());
        comprador.setTelefono(registrarCompradorDto.getTelefono());
        comprador.setDireccion(registrarCompradorDto.getDireccion());
        comprador.setDepartamento(registrarCompradorDto.getDepartamento());
        comprador.setCiudad(registrarCompradorDto.getCiudad());

        return comprador;
    }
}
