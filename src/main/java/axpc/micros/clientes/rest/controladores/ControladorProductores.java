package axpc.micros.clientes.rest.controladores;

import axpc.micros.clientes.nucleo.servicios.ServicioProductores;
import axpc.micros.clientes.rest.dto.ProductorDto;
import axpc.micros.clientes.rest.dto.RespuestaObtenerProductoresDto;
import axpc.micros.clientes.rest.dto.mapeadores.MapeadorProductorAProductorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/productores")
public class ControladorProductores {

    @Autowired
    private ServicioProductores servicioProductores;

    @GetMapping
    public RespuestaObtenerProductoresDto obtenerProductores() {
        final RespuestaObtenerProductoresDto respuestaObtenerProductoresDto = new RespuestaObtenerProductoresDto();
        this.servicioProductores.obtenerProductores()
                .stream()
                .map(MapeadorProductorAProductorDto::mapear)
                .forEach(respuestaObtenerProductoresDto::agregarProductorDto);
        return respuestaObtenerProductoresDto;
    }

    @GetMapping("/{usuario}")
    public ProductorDto obtenerProductor(@PathVariable("usuario") String usuario) {
        return MapeadorProductorAProductorDto.mapear(servicioProductores.obtenerProductor(usuario));
    }
}
