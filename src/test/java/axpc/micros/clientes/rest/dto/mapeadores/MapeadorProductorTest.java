package axpc.micros.clientes.rest.dto.mapeadores;

import axpc.micros.clientes.nucleo.modelo.Productor;
import axpc.micros.clientes.rest.dto.ProductorDto;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class MapeadorProductorTest {

    private static final String NOMBRE_COMPLETO_DE_PRUEBA = "Fabiola Emilia Posada Pineda";
    private static final String NOMBRE_PRUEBA_SIN_SEGUNDOS = "Jaime Bayly";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void mapearADtoDebeRechazarProductorNulo() {
        this.expectedException.expect(IllegalArgumentException.class);

        MapeadorProductor.mapearADto(null);
    }

    @Test
    public void mapearADtoNoDebeFallarSiElProductorTieneAtributosNulos() {
        Productor productor = new Productor();

        ProductorDto productorDto = MapeadorProductor.mapearADto(productor);

        assertNull(productorDto.getCorreo());
        assertNull(productorDto.getTipoIdentificacion());
        assertNull(productorDto.getIdentificacion());
        assertNull(productorDto.getNombre());
        assertNull(productorDto.getUsuario());
    }

    @Test
    public void mapearADtoDebeConcatenarPrimerNombreYApellidoSiNoHaySegundos() {
        Productor productor = new Productor();
        productor.setPrimerNombre("Jaime");
        productor.setPrimerApellido("Bayly");

        ProductorDto productorDto = MapeadorProductor.mapearADto(productor);

        assertEquals(NOMBRE_PRUEBA_SIN_SEGUNDOS, productorDto.getNombre());
    }

    @Test
    public void mapearADtoDebeConcatenarPrimerNombreYApellidoSiLosSegundosEstanEnBlanco() {
        Productor productor = new Productor();
        productor.setPrimerNombre("Jaime");
        productor.setSegundoNombre(" ");
        productor.setPrimerApellido("Bayly");
        productor.setSegundoApellido(" ");

        ProductorDto productorDto = MapeadorProductor.mapearADto(productor);

        assertEquals(NOMBRE_PRUEBA_SIN_SEGUNDOS, productorDto.getNombre());
    }

    @Test
    public void mapearADtoDebeMapearTodosLosAtributosDelProductorDisponibles() {
        Productor productor = new Productor();
        productor.setPrimerNombre("Fabiola");
        productor.setSegundoNombre("Emilia");
        productor.setPrimerApellido("Posada");
        productor.setSegundoApellido("Pineda");
        productor.setUsuario("fabiola_posada");
        productor.setCorreo("fabiola_posada@tucorreo.com");
        productor.setClave("L4sUp3rCl4v3");
        productor.setTipoIdentificacion("C");
        productor.setIdentificacion("111111111");

        ProductorDto productorDto = MapeadorProductor.mapearADto(productor);
        assertEquals(NOMBRE_COMPLETO_DE_PRUEBA, productorDto.getNombre());
        assertEquals(productor.getUsuario(), productorDto.getUsuario());
        assertEquals(productor.getCorreo(), productorDto.getCorreo());
        assertEquals(productor.getIdentificacion(), productorDto.getIdentificacion());
        assertEquals(productor.getTipoIdentificacion(), productorDto.getTipoIdentificacion());
    }
}
