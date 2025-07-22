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

    public void agregarPostulante(Postulante postulante) {
        postulantes.add(postulante);
    }

    public void validarAdmision() {
        if (tipoAdmision.equals(TipoAdmision.ADMISION)) {
            postulantes.removeIf(p -> p.calcularPuntajeTotal() < puntajeMinimo);
        }
        postulantes.sort((p1, p2) -> Double.compare(p2.calcularPuntajeTotal(), p1.calcularPuntajeTotal()));
        for (int i = 0; i < Math.min(cupos, postulantes.size()); i++) {
            admitidos.add(postulantes.get(i));
        }
    }

    public boolean mitadDeCupos() {
        return admitidos.size() >= (cupos / 2);
    }

    public abstract void procesarAdmisiones();
}
