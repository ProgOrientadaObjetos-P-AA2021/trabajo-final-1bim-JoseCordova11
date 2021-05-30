package paquetetres;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

/**
 *
 * @author Jose Cordova
 */
public class ArchivoEscrituraUbicacion {
    private String nombreArchivo;
    private String rutaArchivo;
    private Ubicacion registro;
    private Formatter salidaArchivo;
    
    public ArchivoEscrituraUbicacion(String n) {
        nombreArchivo = n;
        rutaArchivo = String.format("data/%s",
                getNombreArchivo());
        setInformacionAnterior();

    }

    public void setInformacionAnterior() {
        ArchivoLecturaUbicacion lectura = new ArchivoLecturaUbicacion(nombreArchivo);
        lectura.setLista();
        ArrayList<Ubicacion> lista = lectura.getLista();

        try {
            salidaArchivo = new Formatter(rutaArchivo);
            if (lista != null) {

                if (lista.size() > 0) {
                    for (int i = 0; i < lista.size(); i++) {
                        Ubicacion u = lista.get(i);
                        setRegistro(u);
                        setSalida();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error al leer del archivo: " + e);

        } // fin de catch
    }

    public void setNombreArchivo(String n) {
        nombreArchivo = n;
    }
    public void setRutaArchivo() {
        rutaArchivo = String.format("data/%s.txt", getNombreArchivo());
    }
    public void setRegistro(Ubicacion n) {
        registro = n;
    }
    public String getNombreArchivo() {
        return nombreArchivo;
    }
    public String getRutaArchivo() {
        return rutaArchivo;
    }
    public Ubicacion getRegistro() {
        return registro;
    }
    
    public void setSalida() {
        try {
            Ubicacion u = getRegistro();
            String cadenaRegistro = String.format("%s;%s;%s",
                    u.getNombreBarrio(),
                    u.getNumeroCasa(),
                    u.getReferencia());
            salidaArchivo.format("%s\n", cadenaRegistro);

        } catch (Exception e) {
            System.err.println("Error al crear el archivo.");
            System.err.println(e);
        }
    }

    public void cerrarArchivo() {
        if (salidaArchivo != null) {
            salidaArchivo.close();
        } 
    }
    
}