package paqueteseis;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Jose Cordova
 */
public class ArchivoEscrituraDepar {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Departamento registro;
    private ArrayList<Departamento> listaDepar;

    public ArchivoEscrituraDepar(String nA) {
        nombreArchivo = nA;
        establecerListaDepar();

        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));

            if (obtenerListaDepar().size() > 0) {
                for (int i = 0; i < obtenerListaDepar().size(); i++) {
                    establecerRegistro(obtenerListaDepar().get(i));
                    establecerSalida();
                }
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        } // fin de catch
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerRegistro(Departamento depar) {
        registro = depar;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registro);

        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerListaDepar() {
        ArchivoEscrituraDepar dep = new ArchivoEscrituraDepar(obtenerNombreArchivo());
        dep.establecerListaDepar();
        listaDepar = dep.obtenerListaDepar();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Departamento> obtenerListaDepar() {
        return listaDepar;
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


