package paquetecuatro;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

/**
 *
 * @author Jose Cordova
 */
public class ArchivoEscrituraCiudad {
    private String nombreArchivo;
    private String rutaArchivo;
    private Ciudad registro;
    private Formatter salidaArchivo;
    
    public ArchivoEscrituraCiudad(String n) {
        nombreArchivo = n;
        rutaArchivo = String.format("data/%s",
                getNombreArchivo());
        setInformacionAnterior();

    }

    public void setInformacionAnterior() {
        ArchivoLecturaCiudad lectura = new ArchivoLecturaCiudad(nombreArchivo);
        lectura.setLista();
        ArrayList<Ciudad> lista = lectura.getLista();

        try {
            salidaArchivo = new Formatter(rutaArchivo);
            if (lista != null) {

                if (lista.size() > 0) {
                    for (int i = 0; i < lista.size(); i++) {
                        Ciudad c = lista.get(i);
                        setRegistro(c);
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
    public void setRegistro(Ciudad n) {
        registro = n;
    }
    public String getNombreArchivo() {
        return nombreArchivo;
    }
    public String getRutaArchivo() {
        return rutaArchivo;
    }
    public Ciudad getRegistro() {
        return registro;
    }
    
    public void setSalida() {
        try {
            Ciudad c = getRegistro();
            String cadenaRegistro = String.format("%s;%s;",
                    c.getNombreCiudad(),                    
                    c.getNombreProvin());
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

