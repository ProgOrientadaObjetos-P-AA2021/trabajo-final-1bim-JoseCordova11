package paquetecuatro;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.ObjectOutputStream;

/**
 *
 * @author Jose Cordova
 */
public class ArchivoEscrituraCiudad {
    private String nombreArchivo;
    private Ciudad registro;
    private ObjectOutputStream salida;
    private ArrayList<Ciudad> listaCiu;
    
    public ArchivoEscrituraCiudad(String nArch) {
        nombreArchivo = nArch;
        setListaCiu(); 
        try 
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            if (getListaCiu().size() > 0) {
                for (int i = 0; i < getListaCiu().size(); i++) {
                    setRegistro(getListaCiu().get(i));
                    setSalida();
                }
            }
        } 
        catch (IOException ioException) {
            System.err.println("No se puede abrir el archivo.");
        } 
    }

    public void setNombreArchivo(String n) {
        nombreArchivo = n;
    }
    public void setRegistro(Ciudad ci) {
        registro = ci;
    }

    public void setSalida() {
        try {
            salida.writeObject(registro); 
        } catch (IOException ex) {
            System.err.println("No se uede escribir en el archivo.");
        }
    }
    public void setListaCiu() {
        ArchivoLecturaCiudad ci = new ArchivoLecturaCiudad(getNombreArchivo());
        ci.setListaCiu();
        listaCiu = ci.getListaCiu();
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Ciudad> getListaCiu() {
        return listaCiu;
    }

    public ObjectOutputStream getSalida() {
        return salida;
    }

    public void cerrarArchivo() {
        try 
        {
            if (salida != null) {
                salida.close();
            }
        } 
        catch (IOException ioException) {
            System.err.println("ERROR no se puede cerrar el archivo.");

        }
    }
    
    
}

