package axpc.micros.clientes.rest.dto.mapeadores;

import axpc.micros.clientes.nucleo.modelo.Producto;
import axpc.micros.clientes.nucleo.modelo.Productor;
import axpc.micros.clientes.rest.dto.ProductorDto;
import axpc.micros.clientes.rest.dto.RegistrarProductorDto;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class MapeadorProductor {

    private static final String ESPACIO = " ";

    private MapeadorProductor() {
    }

    public static ProductorDto mapearADto(Productor productor) {
        if (productor == null) throw new IllegalArgumentException("No se puede mapear un Productor nulo.");

        ProductorDto productorDto = new ProductorDto();

        productorDto.setCorreo(productor.getCorreo());
        productorDto.setIdentificacion(productor.getIdentificacion());
        productorDto.setTipoIdentificacion(productor.getTipoIdentificacion());
        productorDto.setUsuario(productor.getUsuario());

        StringBuilder concatenadorNombre = new StringBuilder();

        if (StringUtils.isNotBlank(productor.getPrimerNombre())) concatenadorNombre.append(productor.getPrimerNombre());
        if (StringUtils.isNotBlank(productor.getSegundoNombre())) concatenadorNombre.append(ESPACIO).append(productor.getSegundoNombre());
        if (StringUtils.isNotBlank(productor.getPrimerApellido())) concatenadorNombre.append(ESPACIO).append(productor.getPrimerApellido());
        if (StringUtils.isNotBlank(productor.getSegundoApellido())) concatenadorNombre.append(ESPACIO).append(productor.getSegundoApellido());
        if (concatenadorNombre.length() != 0) productorDto.setNombre(concatenadorNombre.toString());

        return productorDto;
    }

    public static Productor mapearAModelo(RegistrarProductorDto registrarProductorDto) {
        if (registrarProductorDto == null) throw new IllegalArgumentException("No se puede mapear un Productor nulo.");

        Productor productor = new Productor();

        productor.setCorreo(registrarProductorDto.getCorreo());
        productor.setIdentificacion(registrarProductorDto.getIdentificacion());
        productor.setTipoIdentificacion(registrarProductorDto.getTipoIdentificacion());
        productor.setUsuario(registrarProductorDto.getUsuario());
        productor.setPrimerNombre(registrarProductorDto.getPrimerNombre());
        productor.setSegundoNombre(registrarProductorDto.getSegundoNombre());
        productor.setPrimerApellido(registrarProductorDto.getPrimerApellido());
        productor.setSegundoApellido(registrarProductorDto.getSegundoApellido());
        productor.setTelefono(registrarProductorDto.getTelefono());
        productor.setDireccion(registrarProductorDto.getDireccion());
        productor.setDepartamento(registrarProductorDto.getDepartamento());
        productor.setCiudad(registrarProductorDto.getCiudad());

        productor.setProductos(registrarProductorDto.getProductos().stream()
                .map(MapeadorProducto::mapearAModelo)
                .collect(Collectors.toList()));

        return productor;
    }
}
