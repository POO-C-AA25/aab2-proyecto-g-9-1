package POO_Proyecto_B2;

import java.util.*;
import java.util.List;

public class Ejecutor_SistemaAdmisiones {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner in = new Scanner(System.in);
        
        System.out.println("Ingrese la cantidad de estudiantes: ");
        int limite = in.nextInt();
        List<Carrera> carreras = new ArrayList<>();
        carreras.add(new Programacion());
        carreras.add(new Medicina());
        carreras.add(new Telecomunicaciones());
        List<Postulante> postulantes = new ArrayList<>();
        
        for (int i = 0; i < limite; i++) {
            System.out.println("ingrese el nombre del estudiante ");
            String nombre = in.next();
            System.out.println("ingrese su cedula: ");
            String cedula = in.next();
            Carrera carreraDeseada;
            System.out.println("ingrese la carrera a la que desea ingresar: ");
            if ("Medicina".equalsIgnoreCase(in.next())) {
                carreraDeseada = new Medicina();
            }
            else 
                if("Programacion".equalsIgnoreCase(in.next())) {
                carreraDeseada = new Programacion();
                }
                else
                carreraDeseada = new Telecomunicaciones();
            System.out.println("Ingrese su puntaje del examen: ");
            double puntajeExamen = in.nextDouble();
            System.out.println("Ingrese su tipo de merito: ");
            String tipoMerito = in.next();
            Postulante e = new Postulante(nombre, cedula, carreraDeseada, puntajeExamen, tipoMerito);
            postulantes.add(e);
        }
        
        System.out.println("--Menu--");
        System.out.println("[1] Crear archivo postulantes.csv y enviar informacion");
        System.out.println("[2] Cargar desde archivo");
        System.out.println("[0] Finalizar");
        int sel = in.nextInt();
        while (sel != 0) {
            switch (sel) {
                case 1 -> {
                    sistema.crearTablaPostulantesCSV("postulantes.csv", postulantes, carreras);
                }

                case 2 -> sistema.cargarPostulantesDesdeCSV("postulantes.csv", postulantes, carreras);
            }
        }

        for (Carrera carrera : carreras) {
            carrera.procesarAdmisiones();
            System.out.println("Admitidos en " + carrera.nombre + ": " + carrera.admitidos.size());
        }

        Estadistica estadistica = new Estadistica();
        estadistica.analizar(carreras);
        estadistica.mostrarEstadisticas();
    }
}
