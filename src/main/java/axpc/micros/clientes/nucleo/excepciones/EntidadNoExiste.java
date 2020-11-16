package axpc.micros.clientes.nucleo.excepciones;

public class EntidadNoExiste extends RuntimeException {

    private Class<?> tipoDeEntidad;
    private String identificadorEntidad;

    public EntidadNoExiste(Class<?> tipoDeEntidad, String identificadorEntidad) {
        super(String.format("La entidad de tipo [%s] con identificador [%s] no existe.", tipoDeEntidad.getName(), identificadorEntidad));
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
