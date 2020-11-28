package axpc.micros.clientes.rest.controladores;

import axpc.micros.clientes.nucleo.servicios.ServicioProductores;
import axpc.micros.clientes.rest.dto.ProductorDto;
import axpc.micros.clientes.rest.dto.RegistrarProductorDto;
import axpc.micros.clientes.rest.dto.RespuestaObtenerProductoresDto;
import axpc.micros.clientes.rest.dto.mapeadores.MapeadorProductor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
                .map(MapeadorProductor::mapearADto)
                .forEach(respuestaObtenerProductoresDto::agregarProductorDto);
        return respuestaObtenerProductoresDto;
    }

    @GetMapping("/{usuario}")
    public ProductorDto obtenerProductor(@PathVariable("usuario") String usuario) {
        return MapeadorProductor.mapearADto(servicioProductores.obtenerProductor(usuario));
    }

    @PutMapping("/{usuario}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductorDto registrarProductor(@PathVariable("usuario") String usuario,
                                           @RequestBody @Valid @NotNull RegistrarProductorDto registrarProductorDto) {
        registrarProductorDto.setUsuario(usuario);
        return MapeadorProductor.mapearADto(this.servicioProductores
                .registrarProductor(MapeadorProductor.mapearAModelo(registrarProductorDto)));
    }
}
