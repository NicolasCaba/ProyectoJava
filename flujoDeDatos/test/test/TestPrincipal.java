package test;

import entidades.Equipo;
import entidades.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
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
        
        ArrayList<Object> arrlist;
        
        Archivo archivo = new Archivo();
        archivo.guardarEnArchivo(equipo1, "BaseDeDatosLocal\\Equipos.txt");
        arrlist = archivo.leerArchivo("BaseDeDatosLocal\\Equipos.txt");
        Equipo equipoEntrada;
        
        for(Object o: arrlist){
            equipoEntrada = (Equipo)o;
            System.out.println(Arrays.toString(equipoEntrada.getJugadores()));
        }
       
    }
}
