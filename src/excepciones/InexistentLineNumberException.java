package excepciones;

public class InexistentLineNumberException extends Exception {

    public InexistentLineNumberException() {
        super("Entrada inexistente");
    }
}
