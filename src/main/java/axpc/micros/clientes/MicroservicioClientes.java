package axpc.micros.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class MicroservicioClientes extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(MicroservicioClientes.class, args);
    }
}
