package paquetedos;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

/**
 *
 * @author Jose Cordova
 */
public class ArchivoEscrituraPropietario {
    private String nombreArchivo;
    private String rutaArchivo;
    private Propietario registro;
    private Formatter salidaArchivo;
    
    public ArchivoEscrituraPropietario(String n) {
        nombreArchivo = n;
        rutaArchivo = String.format("data/%s",
                getNombreArchivo());
        setInformacionAnterior();

    }

    public void setInformacionAnterior() {
        ArchivoLecturaPropietario lectura = new ArchivoLecturaPropietario(nombreArchivo);
        lectura.setLista();
        ArrayList<Propietario> lista = lectura.getLista();

        try {
            salidaArchivo = new Formatter(rutaArchivo);
            if (lista != null) {

                if (lista.size() > 0) {
                    for (int i = 0; i < lista.size(); i++) {
                        Propietario p = lista.get(i);
                        setRegistro(p);
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
    public void setRegistro(Propietario n) {
        registro = n;
    }
    public String getNombreArchivo() {
        return nombreArchivo;
    }
    public String getRutaArchivo() {
        return rutaArchivo;
    }
    public Propietario getRegistro() {
        return registro;
    }
    
    public void setSalida() {
        try {
            Propietario pro = getRegistro();
            String cadenaRegistro = String.format("%s;%s;%s",
                    pro.getNombrePro(),
                    pro.getApellidoPro(),
                    pro.getIdPro());
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
