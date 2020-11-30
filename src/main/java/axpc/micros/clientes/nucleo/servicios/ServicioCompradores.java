package axpc.micros.clientes.nucleo.servicios;

import axpc.micros.clientes.nucleo.modelo.Comprador;

import java.util.List;

public interface ServicioCompradores {

    List<Comprador> obtenerCompradores();

    Comprador obtenerComprador(String usuario);

    Comprador registrarComprador(Comprador comprador);

}
