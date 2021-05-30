package paqueteseis;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

/**
 *
 * @author Jose Cordova
 */
public class ArchivoEscrituraDepar {
    private String nombreArchivo;
    private String rutaArchivo;
    private Departamento registro;
    private Formatter salidaArchivo;
    
    public ArchivoEscrituraDepar(String n) {
        nombreArchivo = n;
        rutaArchivo = String.format("data/%s",
                getNombreArchivo());
        setInformacionAnterior();

    }

    public void setInformacionAnterior() {
        ArchivoLecturaDepar lectura = new ArchivoLecturaDepar(nombreArchivo);
        lectura.setLista();
        ArrayList<Departamento> lista = lectura.getLista();

        try {
            salidaArchivo = new Formatter(rutaArchivo);
            if (lista != null) {

                if (lista.size() > 0) {
                    for (int i = 0; i < lista.size(); i++) {
                        Departamento d = lista.get(i);
                        setRegistro(d);
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
    public void setRegistro(Departamento n) {
        registro = n;
    }
    public String getNombreArchivo() {
        return nombreArchivo;
    }
    public String getRutaArchivo() {
        return rutaArchivo;
    }
    public Departamento getRegistro() {
        return registro;
    }
    
    public void setSalida() {
        try {
            Departamento d = getRegistro();
            String cadenaRegistro = String.format("%.2f;%.2f;%.2f;%.2f;%.2f;%s;%s",
                    d.getPrecioMC(),
                    d.getNumeroMC(),
                    d.getValorMensual(),
                    d.getCostoFinal(),
                    d.getPrecio(),
                    d.getNombreEdifico(),
                    d.getUbiDepar());
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


