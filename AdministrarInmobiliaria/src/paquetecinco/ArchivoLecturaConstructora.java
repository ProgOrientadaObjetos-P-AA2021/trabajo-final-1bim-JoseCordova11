package paquetecinco;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Jose Cordova
 */
public class ArchivoLecturaConstructora {
    private Scanner entrada;
    private String nombreArchivo;
    private String rutaArchivo;
    private ArrayList<Constructora> lista;

    public ArchivoLecturaConstructora(String n) {
        nombreArchivo = n;
        rutaArchivo = String.format("data/%s",
                getNombreArchivo());

        File f = new File(rutaArchivo);
        if (f.exists()) {
            try {
                entrada = new Scanner(new File(rutaArchivo));              
            } 
            catch (FileNotFoundException e) {
                System.err.println("Error al leer del archivo: " + e);
            } 
        }
    }

    public void setNombreArchivo(String n) {
        nombreArchivo = n;
    }
    public void setRutaArchivo() {
        rutaArchivo = String.format("data/%s.txt",
                getNombreArchivo());;
    }
    public String getNombreArchivo() {
        return nombreArchivo;
    }
    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setLista() {
        lista = new ArrayList<>();
        File f = new File(rutaArchivo);

        if (f.exists()) {

            while (entrada.hasNext()) {
                String linea = entrada.nextLine();

                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split(";")));
                Constructora co = new Constructora();
 
                lista.add(co);

            } 
        }
    }

    public ArrayList<Constructora> getLista() {
        return lista;
    }

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close();
        } 

    }

    @Override
    public String toString() {
        String cadena = "Constructora.txt\n";
        for (int i = 0; i < getLista().size(); i++) {
            cadena = String.format("%sNombre: ;%sID empresa: \n", cadena, i + 1,
                    getLista().get(i).getNombre(),
                    getLista().get(i).getIdEmpresa());
        }
        return cadena;
    }
    
}
