package axpc.micros.clientes.configuracion;

import axpc.micros.clientes.nucleo.datos.FuenteDatosProductores;
import axpc.micros.clientes.nucleo.servicios.ServicioProductores;
import axpc.micros.clientes.nucleo.servicios.impl.ServicioProductoresImpl;
import axpc.micros.clientes.persistencia.BDFuenteDatosProductores;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionContexto {
    @Bean
    public ServicioProductores servicioProductores() {
        return new ServicioProductoresImpl(bdFuenteDatosProductores());
    }

    @Bean
    public FuenteDatosProductores bdFuenteDatosProductores() {
        return new BDFuenteDatosProductores();
    }
}
