package paquetedos;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.ObjectOutputStream;

/**
 *
 * @author Jose Cordova
 */
public class ArchivoEscrituraPropietario {
    private String nombreArchivo;
    private Propietario registro;
    private ObjectOutputStream salida;
    private ArrayList<Propietario> lista;
    
    public ArchivoEscrituraPropietario(String nArch) {
        nombreArchivo = nArch;
        setListaPro(); 
        try 
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            if (getListaPro().size() > 0) {
                for (int i = 0; i < getListaPro().size(); i++) {
                    setRegistro(getListaPro().get(i));
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
    public void setRegistro(Propietario p) {
        registro = p;
    }

    public void setSalida() {
        try {
            salida.writeObject(registro); 
        } catch (IOException ex) {
            System.err.println("No se uede escribir en el archivo.");
        }
    }
    public void setListaPro() {
        ArchivoLecturaPropietario p = new ArchivoLecturaPropietario(getNombreArchivo());
        p.setListaPro();
        lista = p.getListaPro();
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Propietario> getListaPro() {
        return lista;
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
