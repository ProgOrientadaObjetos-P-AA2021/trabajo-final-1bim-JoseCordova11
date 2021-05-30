package paqueteuno;

import java.util.ArrayList;
import java.util.Scanner;
import paquetedos.ArchivoEscrituraPropietario;
import paquetedos.ArchivoLecturaPropietario;
import paquetedos.Propietario;
import paquetetres.ArchivoEscrituraUbicacion;
import paquetetres.ArchivoLecturaUbicacion;
import paquetetres.Ubicacion;
import paquetecuatro.ArchivoEscrituraCiudad;
import paquetecuatro.ArchivoLecturaCiudad;
import paquetecuatro.Ciudad;
import paquetecinco.ArchivoEscrituraConstructora;
import paquetecinco.ArchivoLecturaConstructora;
import paquetecinco.Constructora;
import paqueteseis.ArchivoEscrituraCasa;
import paqueteseis.ArchivoLecturaCasa;
import paqueteseis.Casa;
import paqueteseis.ArchivoEscrituraDepar;
import paqueteseis.ArchivoLecturaDepar;
import paqueteseis.Departamento;

/**
 *
 * @author Jose Cordova
 */
public class Ejecutor {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int opcion;
        String sn;
        String idPro;
        String nCasa;
        String ciudad;
        String idEmpresa;

        do {
            System.out.println("Ingrese uma opcion 1-6 o ingrese 0 para salir:\n"
                    + "1. Ingresar Propietario\n"
                    + "2. Ingresar una Ubicación\n"
                    + "3. Ingresar una Ciudad\n"
                    + "4. Ingresar una Constructora\n"
                    + "5. Ingresar una Casa\n"
                    + "6. Ingresar un Departamento\n"
                    + "0. Salir");
            opcion = read.nextInt();
            if ((opcion > 0) && (opcion < 7)) {
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese la identificación del Propietario: ");
                        idPro = read.nextLine();
                        ingresarPropietario(idPro);
                        break;

                    case 2:
                        System.out.println("Ingrese el número de Casa: ");
                        nCasa = read.nextLine();
                        ingresarUbicacion(nCasa);
                        break;

                    case 3:
                        System.out.println("Ingrese el nombre de la Ciudad: ");
                        ciudad = read.nextLine();
                        ingresarCiudad(ciudad);
                        break;

                    case 4:
                        System.out.println("Ingrese el ID de la empresa: ");
                        idEmpresa = read.nextLine();
                        ingresarConstructora(idEmpresa);
                        break;

                    case 5:
                        ingresarCasa();
                        break;

                    case 6:
                        ingresarDepartamento();
                        break;
                }
            }
        } while (opcion == 0);
    }

    public static void ingresarPropietario(String idPro) {
        Scanner read = new Scanner(System.in);
        String nArchivo = "Propietarios.data";
        String nombrePro;
        String apePro;
        String identificacion;
        System.out.println("Ingrese el nombre");
        nombrePro = read.nextLine();
        System.out.println("Ingrese el apellido");
        apePro = read.nextLine();
        System.out.println("Ingrese identificaion");
        identificacion = read.nextLine();

        Propietario p = new Propietario();

        ArchivoEscrituraPropietario archivo = new ArchivoEscrituraPropietario(nArchivo);
        archivo.setRegistro(p);
        archivo.setSalida();
        archivo.cerrarArchivo();

        ArchivoLecturaPropietario lectura = new ArchivoLecturaPropietario(nArchivo);
        lectura.setLista();
        ArrayList<Propietario> lista = lectura.getLista();
        System.out.println(lectura);

    }

    public static void ingresarUbicacion(String nCasa) {
        Scanner read = new Scanner(System.in);
        String nArchivo = "Ubicacion.data";
        int numeroCasa;
        String nombreBarrio;
        String referencia;
        System.out.println("Ingrese el numero de casa");
        numeroCasa = read.nextInt();
        System.out.println("Ingrese nombre del barrio");
        nombreBarrio = read.nextLine();
        System.out.println("Ingrese una Referencia");
        referencia = read.nextLine();

        Ubicacion u = new Ubicacion();

        ArchivoEscrituraUbicacion archivo = new ArchivoEscrituraUbicacion(nArchivo);
        archivo.setRegistro(u);
        archivo.setSalida();
        archivo.cerrarArchivo();

        ArchivoLecturaUbicacion lectura = new ArchivoLecturaUbicacion(nArchivo);
        lectura.setLista();
        ArrayList<Ubicacion> lista = lectura.getLista();
        System.out.println(lectura);
    }

    public static void ingresarCiudad(String ciudad) {
        Scanner read = new Scanner(System.in);
        String nArchivo = "Ciudad.data";
        String nCiudad;
        String nProvi;
        System.out.println("Ingrese nombre de la ciudad");
        nCiudad = read.nextLine();
        System.out.println("Ingrese el nombre de la provincia");
        nProvi = read.nextLine();

        Ciudad c = new Ciudad();

        ArchivoEscrituraCiudad archivo = new ArchivoEscrituraCiudad(nArchivo);
        archivo.setRegistro(c);
        archivo.setSalida();
        archivo.cerrarArchivo();

        ArchivoLecturaCiudad lectura = new ArchivoLecturaCiudad(nArchivo);
        lectura.setLista();
        ArrayList<Ciudad> lista = lectura.getLista();
        System.out.println(lectura);

    }

    public static void ingresarConstructora(String idEmpresa) {
        Scanner read = new Scanner(System.in);
        String nArchivo = "Constructora.data";
        String nConstructora;
        int idEm;
        System.out.println("Ingrese el nomnre de la constructora");
        nConstructora = read.nextLine();
        System.out.println("Ingrese la id de la empresa");
        idEm = read.nextInt();

        Constructora co = new Constructora();

        ArchivoEscrituraConstructora archivo = new ArchivoEscrituraConstructora(nArchivo);
        archivo.setRegistro(co);
        archivo.setSalida();
        archivo.cerrarArchivo();

        ArchivoLecturaConstructora lectura = new ArchivoLecturaConstructora(nArchivo);
        lectura.setLista();
        ArrayList<Constructora> lista = lectura.getLista();
        System.out.println(lectura);
    }

    public static void ingresarCasa() {
        Scanner read = new Scanner(System.in);
        String nArchivo = "casas.txt";
        String nArchivo1 = "propietarios.txt";
        String nArchivo2 = "ubicaciones.txt";
        String nArchivo3 = "ciudades.txt";
        String nArchivo4 = "constructoras.txt";
        String nombreProp = "";
        String apellidoProp = "";
        String idPro;
        double precioMC;
        int numeroMC;
        String nombreB = "";
        String referencia = "";
        String numeroCasa;
        String ciudad;
        String provincia = "";
        int nCuartos;
        String nombreEmp = "";
        String idEmp;
        boolean buscar;
        System.out.println("Ingrese la identificación del Propietario: ");
        idPro = read.nextLine();

        ArchivoLecturaPropietario lectura = new ArchivoLecturaPropietario(nArchivo1);
        lectura.setLista();
        ArrayList<Propietario> lista = lectura.getLista();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getIdPro().equals(idPro)) {
                nombreProp = lista.get(i).getNombrePro();
                apellidoProp = lista.get(i).getApellidoPro();
            }
        }
        Propietario pro = new Propietario();
        System.out.println("Ingrese el precio por metro cuadrado: ");
        precioMC = read.nextDouble();
        System.out.println("Ingrese el número de metros cuadrados: ");
        numeroMC = read.nextInt();

        System.out.println("Ingrese el número de Casa: ");
        numeroCasa = read.nextLine();

        ArchivoLecturaUbicacion lectura2 = new ArchivoLecturaUbicacion(nArchivo2);
        lectura2.setLista();
        ArrayList<Ubicacion> lista2 = lectura2.getLista();
        for (int i = 0; i < lista2.size(); i++) {
            if (numeroCasa.equals(lista2.get(i).getNumeroCasa())) {
            } else {
                nombreB = lista2.get(i).getNombreBarrio();
                referencia = lista2.get(i).getReferencia();
            }
        }
        Ubicacion ubi = new Ubicacion();

        System.out.println("Ingrese el nombre de la ciudad: ");
        ciudad = read.nextLine();

        ArchivoLecturaCiudad lectura3 = new ArchivoLecturaCiudad(nArchivo3);
        lectura3.setLista();
        ArrayList<Ciudad> lista3 = lectura3.getLista();
        for (int i = 0; i < lista3.size(); i++) {
            if (lista3.get(i).getNombreCiudad().equals(ciudad)) {
                provincia = lista3.get(i).getNombreProvin();
            }
        }
        Ciudad ci = new Ciudad();
        System.out.println("Ingrese el número de cuartos: ");
        nCuartos = read.nextInt();

        System.out.println("Ingrese el nID de la constructora: ");
        idEmp = read.nextLine();

        ArchivoLecturaConstructora lectura4 = new ArchivoLecturaConstructora(nArchivo4);
        lectura4.setLista();
        ArrayList<Constructora> lista4 = lectura4.getLista();
        for (int i = 0; i < lista4.size(); i++) {
            if (lista4.get(i).getIdEmpresa().equals(idEmp)) {
                nombreEmp = lista4.get(i).getNombre();
            }
        }
        Constructora con = new Constructora();
        Casa casa1 = new Casa(pro, precioMC, numeroMC, ubi,
                ci, nCuartos, con);
        casa1.setCostoFinal();
        ArchivoEscrituraCasa archivo = new ArchivoEscrituraCasa(nArchivo);
        archivo.setRegistro(casa1);
        archivo.setSalida();
        archivo.cerrarArchivo();

    }

    public static void ingresarDepartamento() {
        Scanner entrada = new Scanner(System.in);
        String nArchivo = "casas.txt";
        String nArchivo1 = "propietarios.txt";
        String nArchivo2 = "ubicaciones.txt";
        String nArchivo3 = "ciudades.txt";
        String nArchivo4 = "constructoras.txt";
        String nombreProp = "";
        String apellidoProp = "";
        String idPro;
        double precioMC;
        int numeroMC;
        String nombreB = "";
        String referencia = "";
        String numeroCasa;
        String ciudad;
        String provincia = "";
        String nombreEmp = "";
        String idEmp;
        boolean buscar;
        double valorMensual;
        String nomEdi;
        String ubiDepEdi;
        System.out.println("Ingrese la identificación del Propietario: ");
        idPro = entrada.nextLine();

        ArchivoLecturaPropietario lectura = new ArchivoLecturaPropietario(nArchivo1);
        lectura.setLista();
        ArrayList<Propietario> lista = lectura.getLista();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getIdPro().equals(idPro)) {
                nombreProp = lista.get(i).getNombrePro();
                apellidoProp = lista.get(i).getApellidoPro();
            }
        }
        Propietario pro = new Propietario();
        System.out.println("Ingrese el precio por metro cuadrado: ");
        precioMC = entrada.nextDouble();
        System.out.println("Ingrese el número de metros cuadrados: ");
        numeroMC = entrada.nextInt();
        System.out.println("Ingrese el valor mensual: ");
        valorMensual = entrada.nextDouble();

        System.out.println("Ingrese el número de Casa: ");
        numeroCasa = entrada.nextLine();

        ArchivoLecturaUbicacion lectura2 = new ArchivoLecturaUbicacion(nArchivo2);
        lectura2.setLista();
        ArrayList<Ubicacion> lista2 = lectura2.getLista();
        for (int i = 0; i < lista2.size(); i++) {
            if (numeroCasa.equals(lista2.get(i).getNumeroCasa())) {
            } else {
                nombreB = lista2.get(i).getNombreBarrio();
                referencia = lista2.get(i).getReferencia();
            }
        }
        Ubicacion ubi = new Ubicacion();

        System.out.println("Ingrese el nombre de la ciudad: ");
        ciudad = entrada.nextLine();

        ArchivoLecturaCiudad lectura3 = new ArchivoLecturaCiudad(nArchivo3);
        lectura3.setLista();
        ArrayList<Ciudad> lista3 = lectura3.getLista();
        for (int i = 0; i < lista3.size(); i++) {
            if (lista3.get(i).getNombreCiudad().equals(ciudad)) {
                provincia = lista3.get(i).getNombreProvin();
            }
        }
        Ciudad ciu = new Ciudad();
        System.out.println("Ingrese el nombre del edificio: ");
        nomEdi = entrada.nextLine();
        System.out.println("Ingrese la ubicacion del departamento en el "
                + "edificio: ");
        ubiDepEdi = entrada.nextLine();

        System.out.println("Ingrese el nID de la constructora: ");
        idEmp = entrada.nextLine();

        ArchivoLecturaConstructora lectura4 = new ArchivoLecturaConstructora(nArchivo4);
        lectura4.setLista();
        ArrayList<Constructora> lista4 = lectura4.getLista();
        for (int i = 0; i < lista4.size(); i++) {
            if (lista4.get(i).getIdEmpresa().equals(idEmp)) {
                nombreEmp = lista4.get(i).getNombre();
            }
        }
        Constructora con = new Constructora();
        Departamento dep1 = new Departamento(pro, precioMC, numeroMC,
                valorMensual, ubi, ciu, nomEdi, ubiDepEdi, con);
        dep1.setCostoFinal();
        ArchivoEscrituraDepar archivo = new ArchivoEscrituraDepar(nArchivo);
        archivo.setRegistro(dep1);
        archivo.setSalida();
        archivo.cerrarArchivo();
    }

}
