package test;

import entidades.CategoriaJuvenil;
import entidades.CategoriaMayores;
import entidades.Equipo;
import entidades.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import main.IntroduccionDatosBD;
import manejo_archivos.Archivo;

/**
 * @author Nicolás
 */
public class TestPrincipal {
    public static void main(String[] args) {
        // Número de jugadores
        int numeroTotalDeEquipos = 0;
        int numeroDeEquiposCatgJuv = 0;
        int numeroDeEquiposCatgMay = 0;
        
        // ArrayList de equipos
        ArrayList<Equipo> equiposJuveniles = new ArrayList<Equipo>();
        ArrayList<Equipo> equiposMayores = new ArrayList<Equipo>();
        
        // Número total de jugadores
        int numeroTotalJugadoresCatgJuv = equiposJuveniles.size() * 8;
        int numeroTotalJugadoresCatgMay = equiposMayores.size() * 8;
        int numeroTotalJugadores = equiposMayores.size() * 8  + equiposJuveniles.size() * 8;
        
        
        //Instancia Categorias
        CategoriaJuvenil categoriaJuvenil = new CategoriaJuvenil("Categoria juvenil", numeroDeEquiposCatgJuv, numeroTotalJugadoresCatgJuv, "18 - 30", equiposJuveniles);
        CategoriaMayores categoriaMayores = new CategoriaMayores("Categoria mayores", numeroDeEquiposCatgMay, numeroTotalJugadoresCatgMay, "31 - 60", equiposMayores);
        
        
        Jugador jugador1 = new Jugador("Nicolas", 12, "Tigres", "Juvenil");
        
        Jugador jugadoresEquipo1[] = new Jugador[8];
        jugadoresEquipo1[0] = jugador1;
        Equipo equipo1;
        equipo1 = new Equipo("Tigres", 8, "Juvenil", jugadoresEquipo1, "imagen1.jpg", 12, 2, 1);
        
        ArrayList<Object> arrlist;
        
       // Archivo archivo = new Archivo();
        //archivo.guardarEnArchivo(equipo1, "BaseDeDatosLocal\\Equipos.txt");
        //arrlist = archivo.leerArchivo("BaseDeDatosLocal\\Equipos.txt");
        //Equipo equipoEntrada;
        
        /*for(Object o: arrlist){
            equipoEntrada = (Equipo)o;
            System.out.println(equipoEntrada);
        }*/
        
        IntroduccionDatosBD.introduccionDatos();
       
    }
}
