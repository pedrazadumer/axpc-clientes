package axpc.micros.clientes.persistencia;

import axpc.micros.clientes.nucleo.datos.FuenteDatosCompradores;
import axpc.micros.clientes.nucleo.excepciones.EntidadNoExiste;
import axpc.micros.clientes.nucleo.excepciones.EntidadYaExiste;
import axpc.micros.clientes.nucleo.modelo.Comprador;
import axpc.micros.clientes.persistencia.mapeadores.MapeadorFilaComprador;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class BDFuenteDatosCompradores implements FuenteDatosCompradores {

    public static final String QUERY_OBTENER_COMPRADORES = "SELECT * FROM usuario WHERE usrUsTiId = 2";
    public static final String QUERY_OBTENER_COMPRADOR_POR_USUARIO = "SELECT * FROM usuario WHERE usrLogin = ? and usrUsTiId = 2";
    public static final String QUERY_INSERTAR_COMPRADOR = "INSERT INTO usuario (usrLogin, usrCorreo, usrUsTiId, usrPassHash, " +
            "usrUsTiIdAbrev, usrIdentificacion, usrMonid, usrPrimerNombre, usrSegundoNombre, usrPrimerApellido, " +
            "usrSegundoApellido, usrTelefono1, usrDireccion1, usrDepartamento1, usrCiudad1) " +
            "VALUES (?, ?, ?, SHA2(?, 256), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final int TIPO_USUARIO_COMPRADOR = 2;
    public static final int MONEDA_PESOS_COLOMBIANOS = 1;
    private JdbcTemplate jdbcTemplate;

    public BDFuenteDatosCompradores(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Comprador> obtenerCompradores() {
        return this.jdbcTemplate.query(QUERY_OBTENER_COMPRADORES, new MapeadorFilaComprador());
    }

    @Override
    public Optional<Comprador> obtenerComprador(String usuario) {
        try {
            Comprador comprador = this.jdbcTemplate.queryForObject(QUERY_OBTENER_COMPRADOR_POR_USUARIO,
                    new MapeadorFilaComprador(), usuario);
            return Optional.of(comprador);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadNoExiste(Comprador.class, usuario);
        }
    }

    @Override
    public Comprador registrarComprador(Comprador comprador) {
        try {
            this.jdbcTemplate.update(QUERY_INSERTAR_COMPRADOR, comprador.getUsuario(), comprador.getCorreo(),
                    TIPO_USUARIO_COMPRADOR, comprador.getClave(), comprador.getTipoIdentificacion(),
                    comprador.getIdentificacion(), MONEDA_PESOS_COLOMBIANOS, comprador.getPrimerNombre(),
                    comprador.getSegundoNombre(), comprador.getPrimerApellido(), comprador.getSegundoApellido(),
                    comprador.getTelefono(), comprador.getDireccion(), comprador.getDepartamento(), comprador.getCiudad()
            );
            return comprador;
        } catch (DuplicateKeyException e) {
            throw new EntidadYaExiste(Comprador.class, comprador.getUsuario());
        }
    }
}
