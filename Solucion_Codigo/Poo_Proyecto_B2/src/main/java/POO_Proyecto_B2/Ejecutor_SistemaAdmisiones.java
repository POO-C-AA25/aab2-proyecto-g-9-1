package POO_Proyecto_B2;

import java.util.*;
import java.util.List;

public class Ejecutor_SistemaAdmisiones {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        List<Carrera> carreras = new ArrayList<>();
        carreras.add(new Programacion());
        carreras.add(new Medicina());
        carreras.add(new Telecomunicaciones());

        List<Postulante> postulantes = new ArrayList<>();
        sistema.cargarPostulantesDesdeCSV("postulantes.csv", postulantes, carreras);

        for (Carrera carrera : carreras) {
            carrera.procesarAdmisiones();
            System.out.println("Admitidos en " + carrera.nombre + ": " + carrera.admitidos.size());
        }

        Estadistica estadistica = new Estadistica();
        estadistica.analizar(carreras);
        estadistica.mostrarEstadisticas();
    }
}
