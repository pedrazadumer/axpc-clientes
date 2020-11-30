package axpc.micros.clientes.persistencia;

import axpc.micros.clientes.nucleo.datos.FuenteDatosProductores;
import axpc.micros.clientes.nucleo.excepciones.EntidadNoExiste;
import axpc.micros.clientes.nucleo.excepciones.EntidadYaExiste;
import axpc.micros.clientes.nucleo.modelo.Productor;
import axpc.micros.clientes.persistencia.mapeadores.MapeadorFilaProductor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class BDFuenteDatosProductores implements FuenteDatosProductores {

    public static final String QUERY_OBTENER_PRODUCTORES = "SELECT * FROM usuario WHERE usrUsTiId = 1";
    public static final String QUERY_OBTENER_PRODUCTOR_POR_USUARIO = "SELECT * FROM usuario WHERE usrLogin = ?";
    public static final String QUERY_INSERTAR_PRODUCTOR = "INSERT INTO usuario (usrLogin, usrCorreo, usrUsTiId, usrPassHash, " +
            "usrUsTiIdAbrev, usrIdentificacion, usrMonid, usrPrimerNombre, usrSegundoNombre, usrPrimerApellido, " +
            "usrSegundoApellido, usrTelefono1, usrDireccion1, usrDepartamento1, usrCiudad1) " +
            "VALUES (?, ?, ?, SHA2(?, 256), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final int TIPO_USUARIO_PRODUCTOR = 1;
    public static final int MONEDA_PESOS_COLOMBIANOS = 1;
    private JdbcTemplate jdbcTemplate;

    public BDFuenteDatosProductores(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Productor> obtenerProductores() {
        return this.jdbcTemplate.query(QUERY_OBTENER_PRODUCTORES, new MapeadorFilaProductor());
    }

    @Override
    public Optional<Productor> obtenerProductor(String usuario) {
        try {
            Productor productor = this.jdbcTemplate.queryForObject(QUERY_OBTENER_PRODUCTOR_POR_USUARIO,
                    new MapeadorFilaProductor(), usuario);
            return Optional.of(productor);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadNoExiste(Productor.class, usuario);
        }
    }

    @Override
    public Productor registrarProductor(Productor productor) {
        try {
            this.jdbcTemplate.update(QUERY_INSERTAR_PRODUCTOR, productor.getUsuario(), productor.getCorreo(),
                    TIPO_USUARIO_PRODUCTOR, productor.getClave(), productor.getTipoIdentificacion(),
                    productor.getIdentificacion(), MONEDA_PESOS_COLOMBIANOS, productor.getPrimerNombre(),
                    productor.getSegundoNombre(), productor.getPrimerApellido(), productor.getSegundoApellido(),
                    productor.getTelefono(), productor.getDireccion(), productor.getDepartamento(), productor.getCiudad()
            );
            return productor;
        } catch (DuplicateKeyException e) {
            throw new EntidadYaExiste(Productor.class, productor.getUsuario());
        }
    }
}
