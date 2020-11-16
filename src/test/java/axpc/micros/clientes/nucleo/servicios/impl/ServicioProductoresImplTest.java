package axpc.micros.clientes.nucleo.servicios.impl;

import axpc.micros.clientes.nucleo.datos.FuenteDatosProductores;
import axpc.micros.clientes.nucleo.excepciones.EntidadNoExiste;
import axpc.micros.clientes.nucleo.modelo.Productor;
import axpc.micros.clientes.nucleo.servicios.ServicioProductores;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioProductoresImplTest {

    private static final String USUARIO_INEXISTENTE = "usuario_inexistente";
    private static final String USUARIO_EXISTENTE = "usuario_existente";

    private ServicioProductores servicioProductores;
    private FuenteDatosProductores fuenteDatosProductores;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void hacerAntesDeCadaPrueba() {
        fuenteDatosProductores = mock(FuenteDatosProductores.class);
        servicioProductores = new ServicioProductoresImpl(fuenteDatosProductores);
    }

    @Test
    public void obtenerProductoresDebeRetornarUnaListaVaciaConNull() {
        when(fuenteDatosProductores.obtenerProductores()).thenReturn(null);

        List<Productor> listaProductores = servicioProductores.obtenerProductores();

        assertNotNull(listaProductores);
        assertTrue(listaProductores.isEmpty());
    }

    @Test
    public void obtenerProductoresDebeRetornarUnaListaVaciaConListaVacia() {
        when(fuenteDatosProductores.obtenerProductores()).thenReturn(new ArrayList<>());

        List<Productor> listaProductores = servicioProductores.obtenerProductores();

        assertNotNull(listaProductores);
        assertTrue(listaProductores.isEmpty());
    }

    @Test
    public void obtenerProductoresDebeRetornarLaListaDeLaFuenteDeDatos() {
        List<Productor> listaProductoresFuenteDatos = Arrays.asList(crearProductorConUsuario("usr.1"),
                crearProductorConUsuario("usr.2"), crearProductorConUsuario("usr.3"));
        when(fuenteDatosProductores.obtenerProductores()).thenReturn(listaProductoresFuenteDatos);

        List<Productor> listaProductores = servicioProductores.obtenerProductores();

        assertNotNull(listaProductores);
        assertEquals(listaProductoresFuenteDatos.size(), listaProductores.size());
        assertEquals(listaProductoresFuenteDatos, listaProductores);
    }

    @Test
    public void obtenerProductorDebeLanzarExcepcionSiNoExiste() {
        expectedException.expect(EntidadNoExiste.class);
        expectedException.expectMessage(Productor.class.getName());
        expectedException.expectMessage(USUARIO_INEXISTENTE);

        when(fuenteDatosProductores.obtenerProductor(USUARIO_INEXISTENTE)).thenReturn(Optional.empty());
        servicioProductores.obtenerProductor(USUARIO_INEXISTENTE);
    }

    @Test
    public void obtenerProductorDebeRetornarProductorSiExiste() {
        Optional<Productor> usuario_existente = Optional.of(crearProductorConUsuario(USUARIO_EXISTENTE));
        when(fuenteDatosProductores.obtenerProductor(USUARIO_EXISTENTE)).thenReturn(usuario_existente);
        Productor productor = servicioProductores.obtenerProductor(USUARIO_EXISTENTE);

        assertEquals(usuario_existente.get(), productor);
    }

    private static Productor crearProductorConUsuario(String usuario) {
        Productor productor = new Productor();
        productor.setUsuario(usuario);
        return productor;
    }
}