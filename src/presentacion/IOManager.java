package presentacion;

import java.util.Scanner;

public class IOManager {

    public static void print(String s){
        System.out.println(s);
    }

    public static String leerLinea(String mensajeInicio){
        IOManager.print(mensajeInicio);
        Scanner scan = new Scanner(System.in);
        final String line;
        if (scan.hasNextLine()) line = scan.nextLine();
        else line = "";
        //scan.close();
        return line;
    }

}
