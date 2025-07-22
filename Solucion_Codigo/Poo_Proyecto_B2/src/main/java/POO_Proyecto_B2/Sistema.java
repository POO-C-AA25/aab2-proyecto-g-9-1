package POO_Proyecto_B2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public class Sistema {

    public Carrera buscarCarreraPorNombre(String nombre) {
        switch (nombre) {
            case "Programación":
                return new Programacion();
            case "Medicina":
                return new Medicina();
            case "Telecomunicaciones":
                return new Telecomunicaciones();
            default:
                return null;
        }
    }
 
    public void crearTablaPostulantesCSV(String nombre, List<Postulante> postulantes, List<Carrera> carreras) {
        try(FileWriter archivo = new FileWriter(new File(nombre))) {
                for(Postulante postulante : postulantes) {
                    archivo.write(postulante.nombre + "\n");
                    archivo.write(postulante.cedula + "\n");
                    archivo.write(postulante.carreraDeseada.nombre + "\n");
                    archivo.write((int)postulante.puntajeExamen + "\n");
                    archivo.write(postulante.tipoMerito + "\n");
                }
                archivo.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public void cargarPostulantesDesdeCSV(String ruta, List<Postulante> postulantes, List<Carrera> carreras) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length < 5) {
                    continue;
                }
                String nombre = datos[0];
                String cedula = datos[1];
                String carreraNombre = datos[2];
                double puntajeExamen = Double.parseDouble(datos[3]);
                String tipoMerito = datos[4];

                Carrera carrera = null;
                for (Carrera c : carreras) {
                    if (c.nombre.equals(carreraNombre)) {
                        carrera = c;
                        break;
                    }
                }

                if (carrera != null) {
                    Postulante postulante = new Postulante(nombre, cedula, carrera, puntajeExamen, tipoMerito);
                    postulantes.add(postulante);
                    carrera.agregarPostulante(postulante);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
