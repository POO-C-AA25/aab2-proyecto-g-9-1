package POO_Proyecto_B2;

public class Telecomunicaciones extends Carrera {

    public Telecomunicaciones() {
        super("Telecomunicaciones", "DIAGNOSTICO", 70.0, 25);
    }

    @Override
    public void procesarAdmisiones() {
        validarAdmision();
    }
}
