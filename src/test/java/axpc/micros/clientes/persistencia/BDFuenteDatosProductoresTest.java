package axpc.micros.clientes.persistencia;

import axpc.micros.clientes.nucleo.modelo.Productor;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BDFuenteDatosProductoresTest {

    private BDFuenteDatosProductores bdFuenteDatosProductores;
    private JdbcTemplate jdbcTemplate;

    @Before
    public void hacerAntesDeCadaPrueba() {
        jdbcTemplate = mock(JdbcTemplate.class);
        bdFuenteDatosProductores = new BDFuenteDatosProductores(jdbcTemplate);
    }

    @Test
    public void obtenerProductoresDebeRetornarLaListaDeProductoresDeBaseDeDatos() {
        Productor productorFabiola = new Productor();
        productorFabiola.setUsuario("fabiola_posada");
        Productor productorRobinson = new Productor();
        productorRobinson.setUsuario("robinson_diaz");
        List<Productor> listaProductores = Arrays.asList(productorFabiola, productorRobinson);
        when(jdbcTemplate.query(anyString(), any(RowMapper.class)))
                .thenReturn(listaProductores);

        List<Productor> listaProductoresRespuesta = bdFuenteDatosProductores.obtenerProductores();

        assertEquals(listaProductores, listaProductoresRespuesta);
    }
}
