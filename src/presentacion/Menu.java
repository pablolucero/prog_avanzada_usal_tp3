package presentacion;

public class Menu extends IOManager {

    public void mostrarMenu() {
        IOManager.print("\nMENU PRINCIPAL");
        IOManager.print("1. Prueba de sonido para equipo basico");
        IOManager.print("2. Prueba de sonido para equipo full");
        IOManager.print("3. Armar equipo para banda");
        IOManager.print("4. Salir");
    }

    public int getOpcion() {
        return IOManager.leerEntero("\nSeleccione la opcion", "Debe seleccionar un numero");
    }

    public String leerCadena(String queLeer) {
        return IOManager.leerLinea("Ingrese el " + queLeer);
    }

    public void printOpcionInvalida() {
        IOManager.print("Ha seleccionado una opcion invalida");
    }

    public void printCrearBandaOpciones() {
        IOManager.print("\nCREACION DE BANDA PERSONALIZADA");
        IOManager.print("1. Agregar guitarra electrica");
        IOManager.print("2. Agregar bajo");
        IOManager.print("3. Agregar bateria");
        IOManager.print("4. Prueba de sonido para el nuevo equipo");
        IOManager.print("5. Volver al menu principal");
    }

    public void printFinDelPrograma() {
        IOManager.print("Fin del programa");
    }
}