package axpc.micros.clientes.persistencia;

import axpc.micros.clientes.nucleo.datos.FuenteDatosProductores;
import axpc.micros.clientes.nucleo.modelo.Productor;

import java.util.List;
import java.util.Optional;

public class BDFuenteDatosProductores implements FuenteDatosProductores {
    @Override
    public List<Productor> obtenerProductores() {
        return null;
    }

    @Override
    public Optional<Productor> obtenerProductor(String usuario) {
        return Optional.empty();
    }
}
