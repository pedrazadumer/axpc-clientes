package axpc.micros.clientes.persistencia.mapeadores;

import axpc.micros.clientes.nucleo.modelo.Productor;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MapeadorFilaProductorTest {

    private static final String COLUMNA_USUARIO = "usrLogin";
    private static final String COLUMNA_CORREO = "usrCorreo";
    private static final String COLUMNA_HASH_CLAVE = "usrPassHash";
    private static final String COLUMNA_TIPO_IDENTIFICACION = "usrUsTiIdAbrev";
    private static final String COLUMNA_IDENTIFICACION = "usrIdentificacion";
    private static final String COLUMNA_PRIMER_NOMBRE = "usrPrimerNombre";
    private static final String COLUMNA_SEGUNDO_NOMBRE = "usrSegundoNombre";
    private static final String COLUMNA_PRIMER_APELLIDO = "usrPrimerApellido";
    private static final String COLUMNA_SEGUNDO_APELLIDO = "usrSegundoApellido";
    private static final String USUARIO_PRUEBA = "fabiola_posada";
    private static final String CORREO_PRUEBA = "fabiola_posada@tucorreo.com";
    private static final String HASH_CLAVE_PRUEBA = "eae8251d6b77516965a85e9860935ba4f8aaf4e8f5ceb862903bf361c4ff82c8";
    private static final String IDENTIFICACION_PRUEBA = "111111111";
    private static final String TIPO_IDENTIFICACION_PRUEBA = "C";
    private static final String PRIMER_NOMBRE_PRUEBA = "Fabiola";
    private static final String SEGUNDO_NOMBRE_PRUEBA = "Emilia";
    private static final String PRIMER_APELLIDO_PRUEBA = "Posada";
    private static final String SEGUNDO_APELLLIDO_PRUEBA = "Pinedo";

    private MapeadorFilaProductor mapeadorFilaProductor;
    private ResultSet respuestaBaseDatos;

    @Before
    public void hacerAntesDeCadaPrueba() {
        mapeadorFilaProductor = new MapeadorFilaProductor();
        respuestaBaseDatos = mock(ResultSet.class);
    }

    @Test
    public void debeMapearElProductorDesdeLaBaseDeDatos() throws SQLException {
        when(respuestaBaseDatos.getString(COLUMNA_USUARIO)).thenReturn(USUARIO_PRUEBA);
        when(respuestaBaseDatos.getString(COLUMNA_CORREO)).thenReturn(CORREO_PRUEBA);
        when(respuestaBaseDatos.getString(COLUMNA_HASH_CLAVE)).thenReturn(HASH_CLAVE_PRUEBA);
        when(respuestaBaseDatos.getString(COLUMNA_TIPO_IDENTIFICACION)).thenReturn(TIPO_IDENTIFICACION_PRUEBA);
        when(respuestaBaseDatos.getString(COLUMNA_IDENTIFICACION)).thenReturn(IDENTIFICACION_PRUEBA);
        when(respuestaBaseDatos.getString(COLUMNA_PRIMER_NOMBRE)).thenReturn(PRIMER_NOMBRE_PRUEBA);
        when(respuestaBaseDatos.getString(COLUMNA_SEGUNDO_NOMBRE)).thenReturn(SEGUNDO_NOMBRE_PRUEBA);
        when(respuestaBaseDatos.getString(COLUMNA_PRIMER_APELLIDO)).thenReturn(PRIMER_APELLIDO_PRUEBA);
        when(respuestaBaseDatos.getString(COLUMNA_SEGUNDO_APELLIDO)).thenReturn(SEGUNDO_APELLLIDO_PRUEBA);

        Productor productor = this.mapeadorFilaProductor.mapRow(respuestaBaseDatos, 0);

        assertEquals(USUARIO_PRUEBA, productor.getUsuario());
        assertEquals(CORREO_PRUEBA, productor.getCorreo());
        assertEquals(HASH_CLAVE_PRUEBA, productor.getClave());
        assertEquals(TIPO_IDENTIFICACION_PRUEBA, productor.getTipoIdentificacion());
        assertEquals(IDENTIFICACION_PRUEBA, productor.getIdentificacion());
        assertEquals(PRIMER_NOMBRE_PRUEBA, productor.getPrimerNombre());
        assertEquals(SEGUNDO_NOMBRE_PRUEBA, productor.getSegundoNombre());
        assertEquals(PRIMER_APELLIDO_PRUEBA, productor.getPrimerApellido());
        assertEquals(SEGUNDO_APELLLIDO_PRUEBA, productor.getSegundoApellido());
    }
}
