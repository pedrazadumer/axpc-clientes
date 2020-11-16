package axpc.micros.clientes.rest.controladores;

import axpc.micros.clientes.nucleo.excepciones.EntidadNoExiste;
import axpc.micros.clientes.rest.dto.RespuestaErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControladorErrores {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RespuestaErrorDto manejarExcepcionGeneral(Exception excepcionGeneral) {
        RespuestaErrorDto respuestaErrorDto = new RespuestaErrorDto();
        respuestaErrorDto.setError("Ha ocurrido un error no esperado.");
        respuestaErrorDto.setDescripcionError(excepcionGeneral.getMessage());
        return respuestaErrorDto;
    }

    @ExceptionHandler(EntidadNoExiste.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public RespuestaErrorDto manejarEntidadNoExiste(EntidadNoExiste entidadNoExiste) {
        RespuestaErrorDto respuestaErrorDto = new RespuestaErrorDto();
        respuestaErrorDto.setError("Recurso no encontrado.");
        String descripcionError = String.format("El recurso de tipo [%s] con identificador [%s] no existe.",
                entidadNoExiste.getTipoDeEntidad().getSimpleName(), entidadNoExiste.getIdentificadorEntidad());
        respuestaErrorDto.setDescripcionError(descripcionError);
        return respuestaErrorDto;
    }
}
