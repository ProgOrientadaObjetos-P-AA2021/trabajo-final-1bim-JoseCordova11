package paquetetres;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Jose Cordova
 */
public class ArchivoEscrituraUbicacion {

    private String nombreArchivo;
    private ObjectOutputStream salida; 
    private Ubicacion registro;
    private ArrayList<Ubicacion> listaUbi;
    private String buscarArchivo;

    public ArchivoEscrituraUbicacion(String nArch) {
        nombreArchivo = nArch;
        setListaUbi(); 
        try 
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            if (getListaUbi().size() > 0) {
                for (int i = 0; i < getListaUbi().size(); i++) {
                    setRegistro(getListaUbi().get(i));
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
    public void setRegistro(Ubicacion p) {
        registro = p;
    }

    public void setSalida() {
        try {
            salida.writeObject(registro); 
        } catch (IOException ex) {
            System.err.println("No se uede escribir en el archivo.");
        }
    }
    public void setListaUbi() {
        ArchivoLecturaUbicacion u = new ArchivoLecturaUbicacion(getNombreArchivo());
        u.setListaUbi();
        listaUbi = u.getListaUbi();
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Ubicacion> getListaUbi() {
        return listaUbi;
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


