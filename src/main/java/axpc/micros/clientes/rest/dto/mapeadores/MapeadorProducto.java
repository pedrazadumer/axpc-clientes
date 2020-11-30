package axpc.micros.clientes.rest.dto.mapeadores;

import axpc.micros.clientes.nucleo.modelo.Producto;
import axpc.micros.clientes.rest.dto.ProductoDto;

public class MapeadorProducto {

    private MapeadorProducto() {
    }

    public static Producto mapearAModelo(ProductoDto productoDto) {
        Producto producto = new Producto();
        producto.setCodigo(productoDto.getCodigo());
        producto.setNombre(productoDto.getNombre());
        return producto;
    }

}
