package axpc.micros.clientes.persistencia.mapeadores;

import axpc.micros.clientes.nucleo.modelo.Comprador;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeadorFilaComprador implements RowMapper<Comprador> {

    private static final String COLUMNA_USUARIO = "usrLogin";
    private static final String COLUMNA_CORREO = "usrCorreo";
    private static final String COLUMNA_HASH_CLAVE = "usrPassHash";
    private static final String COLUMNA_TIPO_IDENTIFICACION = "usrUsTiIdAbrev";
    private static final String COLUMNA_IDENTIFICACION = "usrIdentificacion";
    private static final String COLUMNA_PRIMER_NOMBRE = "usrPrimerNombre";
    private static final String COLUMNA_SEGUNDO_NOMBRE = "usrSegundoNombre";
    private static final String COLUMNA_PRIMER_APELLIDO = "usrPrimerApellido";
    private static final String COLUMNA_SEGUNDO_APELLIDO = "usrSegundoApellido";

    @Override
    public Comprador mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Comprador comprador = new Comprador();
        comprador.setUsuario(resultSet.getString(COLUMNA_USUARIO));
        comprador.setCorreo(resultSet.getString(COLUMNA_CORREO));
        comprador.setClave(resultSet.getString(COLUMNA_HASH_CLAVE));
        comprador.setTipoIdentificacion(resultSet.getString(COLUMNA_TIPO_IDENTIFICACION));
        comprador.setIdentificacion(resultSet.getString(COLUMNA_IDENTIFICACION));
        comprador.setPrimerNombre(resultSet.getString(COLUMNA_PRIMER_NOMBRE));
        comprador.setSegundoNombre(resultSet.getString(COLUMNA_SEGUNDO_NOMBRE));
        comprador.setPrimerApellido(resultSet.getString(COLUMNA_PRIMER_APELLIDO));
        comprador.setSegundoApellido(resultSet.getString(COLUMNA_SEGUNDO_APELLIDO));
        return comprador;
    }
}
