package axpc.micros.clientes.nucleo.datos;

import axpc.micros.clientes.nucleo.modelo.Comprador;

import java.util.List;
import java.util.Optional;

public interface FuenteDatosCompradores {

    List<Comprador> obtenerCompradores();

    Optional<Comprador> obtenerComprador(String usuario);

    Comprador registrarComprador(Comprador comprador);

}
