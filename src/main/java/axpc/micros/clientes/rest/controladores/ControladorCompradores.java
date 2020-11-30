package axpc.micros.clientes.rest.controladores;

import axpc.micros.clientes.nucleo.servicios.ServicioCompradores;
import axpc.micros.clientes.rest.dto.CompradorDto;
import axpc.micros.clientes.rest.dto.RegistrarCompradorDto;
import axpc.micros.clientes.rest.dto.RespuestaObtenerCompradoresDto;
import axpc.micros.clientes.rest.dto.mapeadores.MapeadorComprador;
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
@RequestMapping("/api/v1/compradores")
public class ControladorCompradores {

    @Autowired
    private ServicioCompradores servicioCompradores;

    @GetMapping
    public RespuestaObtenerCompradoresDto obtenerCompradores() {
        final RespuestaObtenerCompradoresDto respuestaObtenerCompradoresDto = new RespuestaObtenerCompradoresDto();
        this.servicioCompradores.obtenerCompradores()
                .stream()
                .map(MapeadorComprador::mapearADto)
                .forEach(respuestaObtenerCompradoresDto::agregarCompradorDto);
        return respuestaObtenerCompradoresDto;
    }

    @GetMapping("/{usuario}")
    public CompradorDto obtenerComprador(@PathVariable("usuario") String usuario) {
        return MapeadorComprador.mapearADto(servicioCompradores.obtenerComprador(usuario));
    }

    @PutMapping("/{usuario}")
    @ResponseStatus(HttpStatus.CREATED)
    public CompradorDto registrarComprador(@PathVariable("usuario") String usuario,
                                           @RequestBody @Valid @NotNull RegistrarCompradorDto registrarCompradorDto) {
        registrarCompradorDto.setUsuario(usuario);
        return MapeadorComprador.mapearADto(this.servicioCompradores
                .registrarComprador(MapeadorComprador.mapearAModelo(registrarCompradorDto)));
    }
}
