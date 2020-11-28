package axpc.micros.clientes.nucleo.excepciones;

public class EntidadYaExiste extends RuntimeException {

    private Class<?> tipoDeEntidad;
    private String identificadorEntidad;

    public EntidadYaExiste(Class<?> tipoDeEntidad, String identificadorEntidad) {
        super(String.format("La entidad de tipo [%s] con identificador [%s] ya existe.", tipoDeEntidad.getName(), identificadorEntidad));
        this.tipoDeEntidad = tipoDeEntidad;
        this.identificadorEntidad = identificadorEntidad;
    }

    public Class<?> getTipoDeEntidad() {
        return tipoDeEntidad;
    }

    public String getIdentificadorEntidad() {
        return identificadorEntidad;
    }
}
