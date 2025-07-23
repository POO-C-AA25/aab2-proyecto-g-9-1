package POO_Proyecto_B2;

public class Programacion extends Carrera {

    public Programacion() {
        super("Programación", "ADMISION", 60.0, 30);
    }

    @Override
    public void procesarAdmisiones() {
        if(tipoAdmision.equalsIgnoreCase("ADMISION")) {  
            for (int i = 0; i < postulantes.size(); i++)
                if (postulantes.get(i).puntTot > this.puntajeMinimo)
                    admitidos.add(postulantes.get(i));   
                else postulantes.remove(i);
        }
    }
}
