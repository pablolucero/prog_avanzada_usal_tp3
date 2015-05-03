package modelo;

import excepciones.InexistentLineNumberException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Diario {

    private static final Diario DIARIO = new Diario();
    private final String FILE_NAME = "diario.txt";

    private Diario() {
        File diarioFile = new File(FILE_NAME);

        if (!diarioFile.exists()) {
            try {
                diarioFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Diario getInstance() {
        return DIARIO;
    }

    public List<String> leerEntradasConNumero() {
        final List<String> lineas = new ArrayList<>();
        String line;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(FILE_NAME)));

            while ((line = bufferedReader.readLine()) != null) {
                lineas.add(line);
            }

            bufferedReader.close();
            return lineas;

        } catch (IOException e) {
            System.err.println("Error leyendo las entradas del diario");
            e.printStackTrace();
        }

        return lineas;
    }

    public void escribirEntrada(String entrada) {

        int newEntryNumber = countCantidadDeLineas() + 1;
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(new File(FILE_NAME), true));
            String entradaFormateada = "#" + newEntryNumber + " " + entrada;
            printWriter.println(entradaFormateada);
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int countCantidadDeLineas() {

        int numberOfLines = 0;

        try {
            final BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(FILE_NAME)));
            while (bufferedReader.readLine() != null) numberOfLines++;
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return numberOfLines;
    }

    public void borrarEntrada(int numDeEntradaABorrar) throws InexistentLineNumberException {

        if (numDeEntradaABorrar < 1 || numDeEntradaABorrar > countCantidadDeLineas()) {
            throw new InexistentLineNumberException();
        }

        final File file = new File("diario.txt");
        final File tempFile = new File(file.getAbsolutePath() + ".tmp");

        try {

            final BufferedReader diarioFileReader = new BufferedReader(new FileReader(file));
            final PrintWriter tempFileWriter = new PrintWriter(new FileWriter(tempFile));

            String line;
            int cont = 1;

            while ((line = diarioFileReader.readLine()) != null) {

                if (cont != numDeEntradaABorrar) {
                    if (cont < numDeEntradaABorrar) {
                        tempFileWriter.println(line);
                    }

                    if (cont > numDeEntradaABorrar) {
                        final String entradaSinNumero = line.substring(line.indexOf(' ') + 1);
                        final int newLineNumber = cont - 1;
                        tempFileWriter.println("#" + newLineNumber + " " + entradaSinNumero);
                    }

                }
                cont++;
            }

            tempFileWriter.flush();

            diarioFileReader.close();
            tempFileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        file.delete();
        tempFile.renameTo(file);
    }
}
