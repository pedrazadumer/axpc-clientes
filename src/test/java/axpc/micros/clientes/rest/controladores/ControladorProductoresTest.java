package axpc.micros.clientes.rest.controladores;

import axpc.micros.clientes.nucleo.excepciones.EntidadNoExiste;
import axpc.micros.clientes.nucleo.modelo.Productor;
import axpc.micros.clientes.nucleo.servicios.ServicioProductores;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.MimeTypeUtils;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ControladorProductores.class)
public class ControladorProductoresTest {

    private static final String RESPUESTA_OBTENER_PRODUCTORES_2_RESULTADOS = "{\"productores\":[{\"usuario\":\"fabiola_posada\"," +
            "\"identificacion\":\"111111111\",\"tipoIdentificacion\":\"C\",\"nombre\":\"Fabiola Emilia Posada Pineda\",\"correo\":" +
            "\"fabiola_posada@tucorreo.com\"},{\"usuario\":\"jaime_bayly\",\"identificacion\":\"000000000\",\"tipoIdentificacion\"" +
            ":\"C\",\"nombre\":\"Jaime Bayly\",\"correo\":\"jaime_bayly@tucorreo.com\"}]}";
    private static final String URI_API_PRODUCTORES = "/api/v1/productores";
    private static final String USUARIO_INEXISTENTE = "usuario_inexistente";
    private static final String USUARIO_FABIOLA_POSADA = "fabiola_posada";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServicioProductores servicioProductores;

    @Test
    public void obtenerProductoresDebeRetornarHTTP200CuandoNoHayProductores() throws Exception {
        when(servicioProductores.obtenerProductores()).thenReturn(new ArrayList<>());

        ResultActions resultadoEsperado = mockMvc.perform(
                get(URI_API_PRODUCTORES).contentType(MimeTypeUtils.APPLICATION_JSON_VALUE));

        resultadoEsperado.andExpect(status().isOk());
        resultadoEsperado.andExpect(content().json("{\"productores\":[]}"));
    }

    @Test
    public void obtenerProductoresDebeRetornarHTTP200CuandoSiHayProductores() throws Exception {
        Productor productorFabiola = crearProductorPrueba("Fabiola", "Emilia",
                "Posada", "Pineda", "111111111");

        Productor productorJaime = crearProductorPrueba("Jaime", null,
                "Bayly", null, "000000000");

        when(servicioProductores.obtenerProductores()).thenReturn(Arrays.asList(productorFabiola, productorJaime));

        ResultActions resultadoEsperado = mockMvc.perform(
                get(URI_API_PRODUCTORES).contentType(MimeTypeUtils.APPLICATION_JSON_VALUE));

        resultadoEsperado.andExpect(status().isOk());
        resultadoEsperado.andExpect(content().json(RESPUESTA_OBTENER_PRODUCTORES_2_RESULTADOS));
    }

    @Test
    public void obtenerProductoresDebeRetornarHTTP500CuandoOcurreUnErrorNoManejado() throws Exception {
        when(servicioProductores.obtenerProductores()).thenThrow(new RuntimeException("Un error no manejado."));

        ResultActions resultadoEsperado = mockMvc.perform(
                get(URI_API_PRODUCTORES).contentType(MimeTypeUtils.APPLICATION_JSON_VALUE));

        resultadoEsperado.andExpect(status().isInternalServerError());
        resultadoEsperado.andExpect(content().json("{\"error\":\"Ha ocurrido un error no esperado.\", \"descripcionError\":\"Un error no manejado.\"}"));
    }

    @Test
    public void obtenerProductorDebeRetornarHTTP404CuandoNoExiste() throws Exception {
        when(servicioProductores.obtenerProductor(USUARIO_INEXISTENTE)).thenThrow(new EntidadNoExiste(Productor.class, USUARIO_INEXISTENTE));

        ResultActions resultadoEsperado = mockMvc.perform(
                get(URI_API_PRODUCTORES + "/" + USUARIO_INEXISTENTE).contentType(MimeTypeUtils.APPLICATION_JSON_VALUE));

        resultadoEsperado.andExpect(status().isNotFound());
        resultadoEsperado.andExpect(content().json("{\"error\":\"Recurso no encontrado.\",\"descripcionError\":\"El recurso de tipo [Productor] con identificador [" + USUARIO_INEXISTENTE + "] no existe.\"}"));
    }

    @Test
    public void obtenerProductorDebeRetornarHTTP200YElProductor() throws Exception {
        Productor productorFabiola = crearProductorPrueba("Fabiola", "Emilia",
                "Posada", "Pineda", "111111111");
        when(servicioProductores.obtenerProductor(USUARIO_FABIOLA_POSADA)).thenReturn(productorFabiola);

        ResultActions resultadoEsperado = mockMvc.perform(
                get(URI_API_PRODUCTORES + "/" + USUARIO_FABIOLA_POSADA).contentType(MimeTypeUtils.APPLICATION_JSON_VALUE));

        resultadoEsperado.andExpect(status().isOk());
        resultadoEsperado.andExpect(content().json("{\"usuario\":\"fabiola_posada\"," +
                "\"identificacion\":\"111111111\",\"tipoIdentificacion\":\"C\",\"nombre\":\"Fabiola Emilia Posada Pineda\",\"correo\":" +
                "\"fabiola_posada@tucorreo.com\"}"));
    }

    private Productor crearProductorPrueba(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String identificacion) {
        String usuario = primerNombre.toLowerCase() + "_" + primerApellido.toLowerCase();
        Productor productor = new Productor();
        productor.setPrimerNombre(primerNombre);
        productor.setSegundoNombre(segundoNombre);
        productor.setPrimerApellido(primerApellido);
        productor.setSegundoApellido(segundoApellido);
        productor.setTipoIdentificacion("C");
        productor.setIdentificacion(identificacion);
        productor.setUsuario(usuario);
        productor.setCorreo(usuario + "@tucorreo.com");
        productor.setClave("L4sUp3rCl4v3");
        return productor;
    }
}