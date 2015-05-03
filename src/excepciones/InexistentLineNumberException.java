package excepciones;

public class InexistentLineNumberException extends Exception {

    private static final long serialVersionUID = 1L;

    public InexistentLineNumberException() {
        super("Entrada inexistente");
    }
}
