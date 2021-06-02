package paquetedos;

import java.io.File;
import java.io.FileInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author Jose Cordova
 */
public class ArchivoLecturaPropietario {
    
    private ObjectInputStream entrada;
    private ArrayList<Propietario> propi;
    private String nombreArchivo;
    private Propietario buscarObjeto;
    private boolean booleanBuscado;
    
    public ArchivoLecturaPropietario(String nA) {
        nombreArchivo = nA;
        File f = new File(getNombreArchivo());
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(
                        new FileInputStream(nA));
            } catch (IOException ioException) {
                System.err.println("Error al abrir el archivo." + ioException);
            }
        }
    }
    
    public void setNombreArchivo(String n) {
        nombreArchivo = n;
    }
    
    public void setListaPro() {
        propi = new ArrayList<>();
        File f = new File(getNombreArchivo());
        if (f.exists()) {
            while (true) {
                try {
                    Propietario registro = (Propietario) entrada.readObject();
                    propi.add(registro);
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
        setListaPro();
        ArrayList<Propietario> listaPropietario = getListaPro();
        for (int i = 0; i < listaPropietario.size(); i++) {
            Propietario p = listaPropietario.get(i);
            if (p.getIdPro().equals(n)) {
                buscarObjeto = p;
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

    public ArrayList<Propietario> getListaPro() {
        return propi;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public Propietario getBuscarObjeto() {
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
        String cadena = "Lista Propietarios\n";
        for (int i = 0; i < getListaPro().size(); i++) {
            Propietario p = getListaPro().get(i);
            cadena = String.format("%sPropietario %d:\n"
                    + "Nombre: %s --- "
                    + "Apellido: %s --- "
                    + "Identificación: %s\n",
                    cadena, i + 1,
                    p.getNombrePro(),
                    p.getApellidoPro(),
                    p.getIdPro());
        }
        return cadena;
    }
    
}
