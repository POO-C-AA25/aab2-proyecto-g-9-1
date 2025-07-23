package POO_Proyecto_B2;

public class Telecomunicaciones extends Carrera {

    public Telecomunicaciones() {
        super("Telecomunicaciones", "DIAGNOSTICO", 70.0, 25);
    }

    @Override
    public void procesarAdmisiones() {
        for (int i = 0; i < postulantes.size(); i++)
                if (postulantes.get(i).puntTot > this.puntajeMinimo) {
                    admitidos.add(postulantes.get(i));
                    admitidos.get(i).requiereNivelacion();
                            }
        } 
}
