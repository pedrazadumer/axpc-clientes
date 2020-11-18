package axpc.micros.clientes.nucleo.datos;

import axpc.micros.clientes.nucleo.modelo.Productor;

import java.util.List;
import java.util.Optional;

public interface FuenteDatosProductores {

    List<Productor> obtenerProductores();

    Optional<Productor> obtenerProductor(String usuario);

    Productor registrarProductor(Productor productor);
}
