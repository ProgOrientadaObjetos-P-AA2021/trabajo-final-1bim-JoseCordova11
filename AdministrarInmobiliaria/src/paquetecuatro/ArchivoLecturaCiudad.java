package paquetecuatro;

import java.io.File;
import java.io.FileInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paquetecuatro.Ciudad;

/**
 *
 * @author Jose Cordova
 */
public class ArchivoLecturaCiudad {
    private ObjectInputStream entrada;
    private ArrayList<Ciudad> ciud;
    private String nombreArchivo;
    private Ciudad buscarObjeto;
    private boolean booleanBuscado;
    
    public ArchivoLecturaCiudad(String n) {
        nombreArchivo = n;
        File f = new File(getNombreArchivo());
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } catch (IOException ioException) {
                System.err.println("Error al abrir el archivo." + ioException);
            }
        }
    }
    
    public void setNombreArchivo(String n) {
        nombreArchivo = n;
    }
    
    public void setListaCiu() {
        ciud = new ArrayList<>();
        File f = new File(getNombreArchivo());
        if (f.exists()) {
            while (true) {
                try {
                    Ciudad registro = (Ciudad) entrada.readObject();
                    ciud.add(registro);
                } catch (EOFException endOfFileException) {
                    return;

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No hay datos en el archivo: " + ex);
                    break;
                }
            }
        }
    }
    
      public void setBuscarObjeto(String n) {
        setListaCiu();
        ArrayList<Ciudad> listaCiu = getListaCiu();
        for (int i = 0; i < listaCiu.size(); i++) {
            Ciudad ci = listaCiu.get(i);
            if (ci.getNombreCiudad().equals(n)) {
                buscarObjeto = ci;
            }
        }
    }

    public void setBooleanBuscado() {
        boolean bandera = true;
        if (buscarObjeto != null) {
            bandera = false;
        }
        booleanBuscado = bandera;
    }

    public ArrayList<Ciudad> getListaCiu() {
        return ciud;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public Ciudad getBuscarObjeto() {
        return buscarObjeto;
    }

    public boolean getBooleanBuscado() {
        return booleanBuscado;
    }

    @Override
    public String toString() {
        String cadena = "Lista Ciudades\n";
        for (int i = 0; i < getListaCiu().size(); i++) {
            Ciudad ci = getListaCiu().get(i);
            cadena = String.format("%sCiudad %d:\n"
                    + "Nombre Ciudad: %s --- "
                    + "Nombre Provincia: %s\n",
                    cadena,
                    i + 1,
                    ci.getNombreCiudad(),
                    ci.getNombreProvin());
        }
        return cadena;
    }
    
    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    }
    
    
}
