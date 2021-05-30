package paqueteseis;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

/**
 *
 * @author Jose Cordova
 */
public class ArchivoEscrituraCasa {
    private String nombreArchivo;
    private String rutaArchivo;
    private Casa registro;
    private Formatter salidaArchivo;
    
    public ArchivoEscrituraCasa(String n) {
        nombreArchivo = n;
        rutaArchivo = String.format("data/%s",
                getNombreArchivo());
        setInformacionAnterior();

    }

    public void setInformacionAnterior() {
        ArchivoLecturaCasa lectura = new ArchivoLecturaCasa(nombreArchivo);
        lectura.setLista();
        ArrayList<Casa> lista = lectura.getLista();

        try {
            salidaArchivo = new Formatter(rutaArchivo);
            if (lista != null) {

                if (lista.size() > 0) {
                    for (int i = 0; i < lista.size(); i++) {
                        Casa c = lista.get(i);
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
    public void setRegistro(Casa n) {
        registro = n;
    }
    public String getNombreArchivo() {
        return nombreArchivo;
    }
    public String getRutaArchivo() {
        return rutaArchivo;
    }
    public Casa getRegistro() {
        return registro;
    }
    
    public void setSalida() {
        try {
            Casa ca = getRegistro();
            String cadenaRegistro = String.format("%.2f;%d;%d;%.2f",
                    ca.getPrecioMC(),
                    ca.getNumeroMC(),
                    ca.getNumeroCuartos(),
                    ca.getCostoFinal());
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


