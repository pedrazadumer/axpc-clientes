package axpc.micros.clientes.rest.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RespuestaObtenerCompradoresDto {

    private List<CompradorDto> compradores = new ArrayList<>();

    public boolean agregarCompradorDto(CompradorDto compradorDto) {
        return this.compradores.add(compradorDto);
    }

}
