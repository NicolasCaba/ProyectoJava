package main;

import entidades.CategoriaJuvenil;
import entidades.CategoriaMayores;
import entidades.Equipo;
import entidades.Torneo;
import java.util.ArrayList;
import manejo_archivos.Archivo;
import vista.Vista;

/**
 *
 * @author Nicolás
 */
public class Main {
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
        
        //Instancia Torneo
        Torneo torneo = new Torneo("Torneo CUN", numeroTotalDeEquipos, numeroTotalJugadores, categoriaJuvenil, categoriaMayores);
        
        //Creacion archivo Torneo
        //Archivo.guardarEnArchivo(torneo, "BaseDeDatosLocal\\Torneo.txt");
        
        
        Vista vista = new Vista();
        vista.setVisible(true);
        System.out.println("hola");
    }
}
