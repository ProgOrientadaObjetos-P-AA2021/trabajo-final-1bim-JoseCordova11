package paquetetres;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author Jose Cordova
 */
public class ArchivoLecturaUbicacion {
    private ObjectInputStream entrada;
    private ArrayList<Ubicacion> ubica;
    private String nombreArchivo;
    private Ubicacion buscarObjeto;
    private boolean booleanBuscado;

    public ArchivoLecturaUbicacion(String n) {
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
    
    public void setListaUbi() {
        ubica = new ArrayList<>();
        File f = new File(getNombreArchivo());
        if (f.exists()) {
            while (true) {
                try {
                    Ubicacion registro = (Ubicacion) entrada.readObject();
                    ubica.add(registro);
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
        setListaUbi();
        ArrayList<Ubicacion> listaUbi = getListaUbi();
        for (int i = 0; i < listaUbi.size(); i++) {
            Ubicacion u = listaUbi.get(i);
            if (u.getNumeroCasa().equals(n)) {
                buscarObjeto = u;
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

    public ArrayList<Ubicacion> getListaUbi() {
        return ubica;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public Ubicacion getBuscarObjeto() {
        return buscarObjeto;
    }

    public boolean getBooleanBuscado() {
        return booleanBuscado;
    }

    
 
    public void cerrarArchivo() throws IOException {
        if (entrada != null) {
            entrada.close();
        } 
    }

    @Override
    public String toString() {
        String cadena = "Lista Ubicaciones\n";
        for (int i = 0; i < getListaUbi().size(); i++) {
            Ubicacion u = getListaUbi().get(i);
            cadena = String.format("%sUbicacion %d:\n"
                    + "Nombre Barrio: %s --- "
                    + "Numero de casa: %s --- "
                    + "Referncia: %s\n",
                    cadena, i + 1,
                    u.getNombreBarrio(),
                    u.getNumeroCasa(),
                    u.getReferencia());
        }
        return cadena;
    }
        
}
