package test;

import entidades.Equipo;
import entidades.Jugador;
import manejo_archivos.Archivo;

/**
 * @author Nicolás
 */
public class TestPrincipal {
    public static void main(String[] args) {
        Jugador jugador1 = new Jugador("Nicolas", 12, "Tigres", "Juvenil");
        
        Jugador jugadoresEquipo1[] = new Jugador[8];
        jugadoresEquipo1[0] = jugador1;
        Equipo equipo1;
        equipo1 = new Equipo("Tigres", 8, "Juvenil", jugadoresEquipo1, "imagen1.jpg", 12, 2, 1);
        
        Archivo archivo = new Archivo();
        archivo.guardarEnArchivo(equipo1, "BaseDeDatosLocal\\Equipos.txt");
        archivo.leerArchivo("BaseDeDatosLocal\\Equipos.txt");
    }
}
