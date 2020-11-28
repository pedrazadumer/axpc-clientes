package axpc.micros.clientes.nucleo.servicios;

import axpc.micros.clientes.nucleo.modelo.Productor;

import java.util.List;

public interface ServicioProductores {

    List<Productor> obtenerProductores();

    Productor obtenerProductor(String usuario);

    Productor registrarProductor(Productor productor);
}
