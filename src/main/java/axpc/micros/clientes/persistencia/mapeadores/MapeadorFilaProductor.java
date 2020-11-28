package axpc.micros.clientes.persistencia.mapeadores;

import axpc.micros.clientes.nucleo.modelo.Productor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeadorFilaProductor implements RowMapper<Productor> {

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
    public Productor mapRow(ResultSet resultSet, int i) throws SQLException {
        Productor productor = new Productor();
        productor.setUsuario(resultSet.getString(COLUMNA_USUARIO));
        productor.setCorreo(resultSet.getString(COLUMNA_CORREO));
        productor.setClave(resultSet.getString(COLUMNA_HASH_CLAVE));
        productor.setTipoIdentificacion(resultSet.getString(COLUMNA_TIPO_IDENTIFICACION));
        productor.setIdentificacion(resultSet.getString(COLUMNA_IDENTIFICACION));
        productor.setPrimerNombre(resultSet.getString(COLUMNA_PRIMER_NOMBRE));
        productor.setSegundoNombre(resultSet.getString(COLUMNA_SEGUNDO_NOMBRE));
        productor.setPrimerApellido(resultSet.getString(COLUMNA_PRIMER_APELLIDO));
        productor.setSegundoApellido(resultSet.getString(COLUMNA_SEGUNDO_APELLIDO));
        return productor;
    }
}
