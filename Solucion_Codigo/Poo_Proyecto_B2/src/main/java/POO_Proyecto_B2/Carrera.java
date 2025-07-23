package POO_Proyecto_B2;

import java.util.ArrayList;
import java.util.List;

public abstract class Carrera {

    String nombre;
    String tipoAdmision;
    double puntajeMinimo;
    double puntajeNivelacion;
    int cupos;
    List<Postulante> postulantes = new ArrayList<>();
    List<Postulante> admitidos = new ArrayList<>();

    public Carrera(String nombre, String tipoAdmision, double puntajeMinimo, int cupos) {
        this.nombre = nombre;
        this.tipoAdmision = tipoAdmision;
        this.puntajeMinimo = puntajeMinimo;
        this.cupos = cupos;
        this.puntajeNivelacion = puntajeMinimo * 0.3;
    }

    public abstract void procesarAdmisiones();
}
