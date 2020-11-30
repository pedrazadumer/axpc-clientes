package axpc.micros.clientes.nucleo.servicios.impl;

import axpc.micros.clientes.nucleo.datos.FuenteDatosCompradores;
import axpc.micros.clientes.nucleo.excepciones.EntidadNoExiste;
import axpc.micros.clientes.nucleo.modelo.Comprador;
import axpc.micros.clientes.nucleo.servicios.ServicioCompradores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServicioCompradoresImpl implements ServicioCompradores {

    private FuenteDatosCompradores fuenteDatosCompradores;

    public ServicioCompradoresImpl(FuenteDatosCompradores fuenteDatosCompradores) {
        this.fuenteDatosCompradores = fuenteDatosCompradores;
    }

    @Override
    public List<Comprador> obtenerCompradores() {
        List<Comprador> listaCompradores = this.fuenteDatosCompradores.obtenerCompradores();
        if (listaCompradores == null) listaCompradores = new ArrayList<>();
        return listaCompradores;
    }

    @Override
    public Comprador obtenerComprador(String usuario) {
        Optional<Comprador> comprador = this.fuenteDatosCompradores.obtenerComprador(usuario);
        if (!comprador.isPresent()) throw new EntidadNoExiste(Comprador.class, usuario);
        return comprador.get();
    }

    @Override
    public Comprador registrarComprador(Comprador comprador) {
        return this.fuenteDatosCompradores.registrarComprador(comprador);
    }
}
