package axpc.micros.clientes.rest.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RespuestaObtenerProductoresDto {

    private List<ProductorDto> productores = new ArrayList<>();

    public boolean agregarProductorDto(ProductorDto productorDto) {
        return this.productores.add(productorDto);
    }
}
