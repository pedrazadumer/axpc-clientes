package axpc.micros.clientes.configuracion;

import axpc.micros.clientes.nucleo.datos.FuenteDatosCompradores;
import axpc.micros.clientes.nucleo.datos.FuenteDatosProductores;
import axpc.micros.clientes.nucleo.servicios.ServicioCompradores;
import axpc.micros.clientes.nucleo.servicios.ServicioProductores;
import axpc.micros.clientes.nucleo.servicios.impl.ServicioCompradoresImpl;
import axpc.micros.clientes.nucleo.servicios.impl.ServicioProductoresImpl;
import axpc.micros.clientes.persistencia.BDFuenteDatosCompradores;
import axpc.micros.clientes.persistencia.BDFuenteDatosProductores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ConfiguracionContexto {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    public ServicioProductores servicioProductores() {
        return new ServicioProductoresImpl(bdFuenteDatosProductores());
    }

    @Bean
    public ServicioCompradores servicioCompradores() {
        return new ServicioCompradoresImpl(bdFuenteDatosCompradores());
    }

    @Bean
    public FuenteDatosProductores bdFuenteDatosProductores() {
        return new BDFuenteDatosProductores(jdbcTemplate);
    }

    @Bean
    public FuenteDatosCompradores bdFuenteDatosCompradores() {
        return new BDFuenteDatosCompradores(jdbcTemplate);
    }
}
