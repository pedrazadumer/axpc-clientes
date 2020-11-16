package axpc.micros.clientes.nucleo.servicios.impl;

import axpc.micros.clientes.nucleo.datos.FuenteDatosProductores;
import axpc.micros.clientes.nucleo.excepciones.EntidadNoExiste;
import axpc.micros.clientes.nucleo.modelo.Productor;
import axpc.micros.clientes.nucleo.servicios.ServicioProductores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServicioProductoresImpl implements ServicioProductores {

    private FuenteDatosProductores fuenteDatosProductores;

    public ServicioProductoresImpl(FuenteDatosProductores fuenteDatosProductores) {
        this.fuenteDatosProductores = fuenteDatosProductores;
    }

    @Override
    public List<Productor> obtenerProductores() {
        List<Productor> listaProductores = this.fuenteDatosProductores.obtenerProductores();
        if (listaProductores == null) listaProductores = new ArrayList<>();
        return listaProductores;
    }

    @Override
    public Productor obtenerProductor(String usuario) {
        Optional<Productor> productor = this.fuenteDatosProductores.obtenerProductor(usuario);
        if (!productor.isPresent()) throw new EntidadNoExiste(Productor.class, usuario);
        return productor.get();
    }
}
