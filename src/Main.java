import excepciones.InexistentLineNumberException;
import modelo.Diario;

import java.util.List;

import static presentacion.IOManager.*;

public class Main {

    public static void main(String[] args) {

        final Diario diario = Diario.getInstance();
        boolean salir = false;

        while (!salir) {

            final String comando = leerLinea("\nIngresar comando (use /help para listarlos)");

            if (comando.equals("/add")) {
                final String entrada = leerLinea("Ingresar entrada");
                diario.escribirEntrada(entrada);
            }

            else if (comando.startsWith("/delete #")) {
                final String[] split = comando.split("#");
                try {
                    diario.borrarEntrada(Integer.valueOf(split[1]));
                } catch (InexistentLineNumberException | NumberFormatException e) {
                    print("Entrada inexistente");
                }
            }

            else if (comando.equals("/entries")) {
                final List<String> entradas = diario.leerEntradasConNumero();
                for (String entrada : entradas) {
                    print(entrada);
                }
            }

            else if (comando.equals("/help")) {
                print("Lista de comandos:" +
                        "\n/add: Ingresar una nueva entrada" +
                        "\n/delete #n: Borrar la entrada numero #n" +
                        "\n/entries: Mostrar todas las entradas del diario" +
                        "\n/exit: Salir");
            }

            else if (comando.equals("/exit")) {
                salir = true;
            }
        }
    }
}
