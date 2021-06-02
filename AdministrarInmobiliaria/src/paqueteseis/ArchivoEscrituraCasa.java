package paqueteseis;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Jose Cordova
 */
public class ArchivoEscrituraCasa {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Casa registro;
    private ArrayList<Casa> listaCasa;

    public ArchivoEscrituraCasa(String n) {
        nombreArchivo = n;
        establecerListaCasa();

        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));

            if (obtenerListaCasa().size() > 0) {
                for (int i = 0; i < obtenerListaCasa().size(); i++) {
                    establecerRegistroCasa(obtenerListaCasa().get(i));
                    establecerSalida();
                }
            }
        } catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerRegistroCasa(Casa c) {
        registro = c;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registro);

        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerListaCasa() {
        ArchivoEscrituraCasa casa = new ArchivoEscrituraCasa(obtenerNombreArchivo());
        casa.establecerListaCasa();
        listaCasa = casa.obtenerListaCasa();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Casa> obtenerListaCasa() {
        return listaCasa;
    }

    public ObjectOutputStream obtenerSalida() {
        return salida;
    }

    public void cerrarArchivo() {
        try {
            if (salida != null) {
                salida.close();
            }
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");

        }
    }
   
    
}


