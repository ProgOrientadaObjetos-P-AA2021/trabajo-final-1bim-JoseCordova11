package paquetecinco;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Jose Cordova
 */
public class ArchivoEscrituraConstructora {
    private String nombreArchivo;
    private Constructora registro;
    private ObjectOutputStream salida;
    private ArrayList<Constructora> listaCons;
    
     public ArchivoEscrituraConstructora(String nArch) {
        nombreArchivo = nArch;
        setListaCons(); 
        try 
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            if (getListaCons().size() > 0) {
                for (int i = 0; i < getListaCons().size(); i++) {
                    setRegistro(getListaCons().get(i));
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
    public void setRegistro(Constructora co) {
        registro = co;
    }

    public void setSalida() {
        try {
            salida.writeObject(registro); 
        } catch (IOException ex) {
            System.err.println("No se uede escribir en el archivo.");
        }
    }
    public void setListaCons() {
        ArchivoLecturaConstructora co = new ArchivoLecturaConstructora(getNombreArchivo());
        co.setListaCons();
        listaCons = co.getListaCons();
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Constructora> getListaCons() {
        return listaCons;
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
