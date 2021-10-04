package main;

import conexion.ConexionBD;
import entidades.CategoriaJuvenil;
import entidades.CategoriaMayores;
import entidades.Equipo;
import entidades.Jugador;
import entidades.Torneo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolás
 */
public class IntroduccionDatosBD {
    
    
    public static void introduccionDatos(){
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
        
        //Intancia Torneo
        Torneo torneo = new Torneo("Torneo CUN", numeroTotalDeEquipos, numeroTotalJugadores, categoriaJuvenil, categoriaMayores);
        
        //Instancia Jugadores
        Jugador jugador1Equipo1CatgJuv = new Jugador("Andres Perez", 22, "Tigres", "Categoria Juvenil");
        Jugador jugador2Equipo1CatgJuv = new Jugador("Karen Gomez", 19, "Tigres", "Categoria Juvenil");
        Jugador jugador3Equipo1CatgJuv = new Jugador("Andrea Cardona", 27, "Tigres", "Categoria Juvenil");
        Jugador jugador4Equipo1CatgJuv = new Jugador("Nicolas Gonzales", 29, "Tigres", "Categoria Juvenil");
        Jugador jugador5Equipo1CatgJuv = new Jugador("Julio Bonilla", 18, "Tigres", "Categoria Juvenil");
        Jugador jugador6Equipo1CatgJuv = new Jugador("Camila Parra", 17, "Tigres", "Categoria Juvenil");
        Jugador jugador7Equipo1CatgJuv = new Jugador("Claudia Hernandez", 24, "Tigres", "Categoria Juvenil");
        Jugador jugador8Equipo1CatgJuv = new Jugador("Felipe Lopez", 20, "Tigres", "Categoria Juvenil");
        
        Jugador jugador1Equipo2CatgJuv = new Jugador("Hernan Fernandez", 23, "Bulls", "Categoria Juvenil");
        Jugador jugador2Equipo2CatgJuv = new Jugador("Carolina Ramirez", 17, "Bulls", "Categoria Juvenil");
        Jugador jugador3Equipo2CatgJuv = new Jugador("Ramiro Quijano", 21, "Bulls", "Categoria Juvenil");
        Jugador jugador4Equipo2CatgJuv = new Jugador("Santiago Espinoza", 27, "Bulls", "Categoria Juvenil");
        Jugador jugador5Equipo2CatgJuv = new Jugador("Hecotor Romero", 25, "Bulls", "Categoria Juvenil");
        Jugador jugador6Equipo2CatgJuv = new Jugador("Andrea Rozo", 22, "Bulls", "Categoria Juvenil");
        Jugador jugador7Equipo2CatgJuv = new Jugador("Natalia Garcia", 26, "Bulls", "Categoria Juvenil");
        Jugador jugador8Equipo2CatgJuv = new Jugador("Gabriela Lopez", 20, "Bulls", "Categoria Juvenil");
        
        Jugador jugador1Equipo1CatgMay = new Jugador("Andres Sanchez", 19, "Dueños del campo", "Categoria Mayores");
        Jugador jugador2Equipo1CatgMay = new Jugador("Catalina Diaz", 24, "Dueños del campo", "Categoria Mayores");
        Jugador jugador3Equipo1CatgMay = new Jugador("Alejandra Moreno", 26, "Dueños del campo", "Categoria Mayores");
        Jugador jugador4Equipo1CatgMay = new Jugador("Juliana Castro", 28, "Dueños del campo", "Categoria Mayores");
        Jugador jugador5Equipo1CatgMay = new Jugador("Esperanza Ruiz", 20, "Dueños del campo", "Categoria Mayores");
        Jugador jugador6Equipo1CatgMay = new Jugador("Camilo Suarez", 18, "Dueños del campo", "Categoria Mayores");
        Jugador jugador7Equipo1CatgMay = new Jugador("Felipe Ortiz", 29, "Dueños del campo", "Categoria Mayores");
        Jugador jugador8Equipo1CatgMay = new Jugador("Jhon Herrera", 21, "Dueños del campo", "Categoria Mayores");
        
        Jugador jugador1Equipo2CatgMay = new Jugador("Cristian Giraldo", 29, "Equipo CUN", "Categoria Mayores");
        Jugador jugador2Equipo2CatgMay = new Jugador("Esteban Leiva", 22, "Equipo CUN", "Categoria Mayores");
        Jugador jugador3Equipo2CatgMay = new Jugador("Lorena Jaramillo", 27, "Equipo CUN", "Categoria Mayores");
        Jugador jugador4Equipo2CatgMay = new Jugador("Gabriel Morales", 19, "Equipo CUN", "Categoria Mayores");
        Jugador jugador5Equipo2CatgMay = new Jugador("Javier Salazar", 20, "Equipo CUN", "Categoria Mayores");
        Jugador jugador6Equipo2CatgMay = new Jugador("Maria Medina", 18, "Equipo CUN", "Categoria Mayores");
        Jugador jugador7Equipo2CatgMay = new Jugador("Ana Rivera", 29, "Equipo CUN", "Categoria Mayores");
        Jugador jugador8Equipo2CatgMay = new Jugador("Veronica Zapata", 17, "Equipo CUN", "Categoria Mayores");
        
        //Instancia Equipos
        Jugador[] jugadoresEquipo1CatgJuv = new Jugador[8];
        jugadoresEquipo1CatgJuv[0] = jugador1Equipo1CatgJuv;
        jugadoresEquipo1CatgJuv[1] = jugador2Equipo1CatgJuv;
        jugadoresEquipo1CatgJuv[2] = jugador3Equipo1CatgJuv;
        jugadoresEquipo1CatgJuv[3] = jugador4Equipo1CatgJuv;
        jugadoresEquipo1CatgJuv[4] = jugador5Equipo1CatgJuv;
        jugadoresEquipo1CatgJuv[5] = jugador6Equipo1CatgJuv;
        jugadoresEquipo1CatgJuv[6] = jugador7Equipo1CatgJuv;
        jugadoresEquipo1CatgJuv[7] = jugador8Equipo1CatgJuv;
        Equipo equipo1CatgJuv = new Equipo("Tigres", 8, "Categoria Juvenil", jugadoresEquipo1CatgJuv, "imgs\\equipo1CatgJuv.jpg", 13, 3, 2);
        
        Jugador[] jugadoresEquipo2CatgJuv = new Jugador[8];
        jugadoresEquipo2CatgJuv[0] = jugador1Equipo2CatgJuv;
        jugadoresEquipo2CatgJuv[1] = jugador2Equipo2CatgJuv;
        jugadoresEquipo2CatgJuv[2] = jugador3Equipo2CatgJuv;
        jugadoresEquipo2CatgJuv[3] = jugador4Equipo2CatgJuv;
        jugadoresEquipo2CatgJuv[4] = jugador5Equipo2CatgJuv;
        jugadoresEquipo2CatgJuv[5] = jugador6Equipo2CatgJuv;
        jugadoresEquipo2CatgJuv[6] = jugador7Equipo2CatgJuv;
        jugadoresEquipo2CatgJuv[7] = jugador8Equipo2CatgJuv;
        Equipo equipo2CatgJuv = new Equipo("Bulls", 8, "Categoria Juvenil", jugadoresEquipo2CatgJuv, "imgs\\equipo2CatgJuv.jpg", 28, 2, 3);
        
        Jugador[] jugadoresEquipo1CatgMay = new Jugador[8];
        jugadoresEquipo1CatgMay[0] = jugador1Equipo1CatgMay;
        jugadoresEquipo1CatgMay[1] = jugador2Equipo1CatgMay;
        jugadoresEquipo1CatgMay[2] = jugador3Equipo1CatgMay;
        jugadoresEquipo1CatgMay[3] = jugador4Equipo1CatgMay;
        jugadoresEquipo1CatgMay[4] = jugador5Equipo1CatgMay;
        jugadoresEquipo1CatgMay[5] = jugador6Equipo1CatgMay;
        jugadoresEquipo1CatgMay[6] = jugador7Equipo1CatgMay;
        jugadoresEquipo1CatgMay[7] = jugador8Equipo1CatgMay;
        Equipo equipo1CatgMay = new Equipo("Dueños del campo", 8, "Categoria Mayores", jugadoresEquipo1CatgMay, "imgs\\equipo1CatgMay.jpg", 19, 4, 1);
        
        Jugador[] jugadoresEquipo2CatgMay = new Jugador[8];
        jugadoresEquipo2CatgMay[0] = jugador1Equipo2CatgMay;
        jugadoresEquipo2CatgMay[1] = jugador2Equipo2CatgMay;
        jugadoresEquipo2CatgMay[2] = jugador3Equipo2CatgMay;
        jugadoresEquipo2CatgMay[3] = jugador4Equipo2CatgMay;
        jugadoresEquipo2CatgMay[4] = jugador5Equipo2CatgMay;
        jugadoresEquipo2CatgMay[5] = jugador6Equipo2CatgMay;
        jugadoresEquipo2CatgMay[6] = jugador7Equipo2CatgMay;
        jugadoresEquipo2CatgMay[7] = jugador8Equipo2CatgMay;
        Equipo equipo2CatgMay = new Equipo("Equipo CUN", 8, "Categoria Mayores", jugadoresEquipo2CatgMay, "imgs\\equipo2CatgMay.jpg", 45, 1, 4);
        
        ConexionBD cbd = new ConexionBD();
        Connection conBD = cbd.conexionBD();
        
        
        Statement st;
        try {
            
            st = conBD.createStatement();
            //st.executeUpdate("INSERT INTO categoriaJuvenil (nombre, rangoEdad) VALUES (" + categoriaJuvenil.getNombre() + ", " + categoriaJuvenil.getRangoEdad() + ");");
            //st.executeUpdate("INSERT INTO categoriaMayores (nombre, rangoEdad) VALUES (" + categoriaMayores.getNombre() + ", " + categoriaMayores.getRangoEdad() + ");");
            
            //st.executeUpdate("INSERT INTO torneo (nombre, categoriaJuvenilId, categoriaMayoresId) VALUES (" + torneo.getNombre() + ", 1, 1);");
            
            //st.executeUpdate("INSERT INTO equipos (nombre, rutaImg, numeroAficionados, victorias, derrotas) VALUES ('" + equipo1CatgJuv.getNombre() + "','" + equipo1CatgJuv.getRutaDeImagen() + "','" + equipo1CatgJuv.getNumeroAficionados() + "','" + equipo1CatgJuv.getVictorias() + "','" + equipo1CatgJuv.getDerrotas() + "');");
            //st.executeUpdate("INSERT INTO equipos (nombre, rutaImg, numeroAficionados, victorias, derrotas) VALUES ('" + equipo2CatgJuv.getNombre() + "','" + equipo2CatgJuv.getRutaDeImagen() + "','" + equipo2CatgJuv.getNumeroAficionados() + "','" + equipo2CatgJuv.getVictorias() + "','" + equipo2CatgJuv.getDerrotas() + "');");
        
            //st.executeUpdate("INSERT INTO categoriaJuvenilEquipos (categoriaJuvenilId, equipoId) VALUES (1, 1);");
            //st.executeUpdate("INSERT INTO categoriaJuvenilEquipos (categoriaJuvenilId, equipoId) VALUES (1, 2);");
            
            //st.executeUpdate("INSERT INTO equipos (nombre, rutaImg, numeroAficionados, victorias, derrotas) VALUES ('" + equipo1CatgMay.getNombre() + "','" + equipo1CatgMay.getRutaDeImagen() + "','" + equipo1CatgMay.getNumeroAficionados() + "','" + equipo1CatgMay.getVictorias() + "','" + equipo1CatgMay.getDerrotas() + "');");
            //st.executeUpdate("INSERT INTO equipos (nombre, rutaImg, numeroAficionados, victorias, derrotas) VALUES ('" + equipo2CatgMay.getNombre() + "','" + equipo2CatgMay.getRutaDeImagen() + "','" + equipo2CatgMay.getNumeroAficionados() + "','" + equipo2CatgMay.getVictorias() + "','" + equipo2CatgMay.getDerrotas() + "');");
        
            //st.executeUpdate("INSERT INTO categoriaMayoresEquipos (categoriaMayoresId, equipoId) VALUES (1, 3);");
            //st.executeUpdate("INSERT INTO categoriaMayoresEquipos (categoriaMayoresId, equipoId) VALUES (1, 4);");
            
            //st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador1Equipo1CatgJuv.getNombre() + "','" + jugador1Equipo1CatgJuv.getEdad() + "');");
            //st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador2Equipo1CatgJuv.getNombre() + "','" + jugador2Equipo1CatgJuv.getEdad() + "');");
            //st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador3Equipo1CatgJuv.getNombre() + "','" + jugador3Equipo1CatgJuv.getEdad() + "');");
            //st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador4Equipo1CatgJuv.getNombre() + "','" + jugador4Equipo1CatgJuv.getEdad() + "');");
            //st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador5Equipo1CatgJuv.getNombre() + "','" + jugador5Equipo1CatgJuv.getEdad() + "');");
            //st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador6Equipo1CatgJuv.getNombre() + "','" + jugador6Equipo1CatgJuv.getEdad() + "');");
            //st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador7Equipo1CatgJuv.getNombre() + "','" + jugador7Equipo1CatgJuv.getEdad() + "');");
            //st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador8Equipo1CatgJuv.getNombre() + "','" + jugador8Equipo1CatgJuv.getEdad() + "');");
            
            //st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (1, 1);");
            //st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (1, 2);");
            //st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (1, 3);");
            //st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (1, 4);");
            //st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (1, 5);");
            //st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (1, 6);");
            //st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (1, 7);");
            //st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (1, 8);");
            
            
            //st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador1Equipo2CatgJuv.getNombre() + "','" + jugador1Equipo2CatgJuv.getEdad() + "');");
            //st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador2Equipo2CatgJuv.getNombre() + "','" + jugador2Equipo2CatgJuv.getEdad() + "');");
            //st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador3Equipo2CatgJuv.getNombre() + "','" + jugador3Equipo2CatgJuv.getEdad() + "');");
            //st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador4Equipo2CatgJuv.getNombre() + "','" + jugador4Equipo2CatgJuv.getEdad() + "');");
            //st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador5Equipo2CatgJuv.getNombre() + "','" + jugador5Equipo2CatgJuv.getEdad() + "');");
            //st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador6Equipo2CatgJuv.getNombre() + "','" + jugador6Equipo2CatgJuv.getEdad() + "');");
            //st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador7Equipo2CatgJuv.getNombre() + "','" + jugador7Equipo2CatgJuv.getEdad() + "');");
            //st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador8Equipo2CatgJuv.getNombre() + "','" + jugador8Equipo2CatgJuv.getEdad() + "');");
            
//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (2, 9);");
//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (2, 10);");
//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (2, 11);");
//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (2, 12);");
//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (2, 13);");
//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (2, 14);");
//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (2, 15);");
//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (2, 16);");



//            st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador1Equipo1CatgMay.getNombre() + "','" + jugador1Equipo1CatgMay.getEdad() + "');");
//            st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador2Equipo1CatgMay.getNombre() + "','" + jugador2Equipo1CatgMay.getEdad() + "');");
//            st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador3Equipo1CatgMay.getNombre() + "','" + jugador3Equipo1CatgMay.getEdad() + "');");
//            st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador4Equipo1CatgMay.getNombre() + "','" + jugador4Equipo1CatgMay.getEdad() + "');");
//            st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador5Equipo1CatgMay.getNombre() + "','" + jugador5Equipo1CatgMay.getEdad() + "');");
//            st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador6Equipo1CatgMay.getNombre() + "','" + jugador6Equipo1CatgMay.getEdad() + "');");
//            st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador7Equipo1CatgMay.getNombre() + "','" + jugador7Equipo1CatgMay.getEdad() + "');");
//            st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador8Equipo1CatgMay.getNombre() + "','" + jugador8Equipo1CatgMay.getEdad() + "');");


//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (3, 17);");
//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (3, 18);");
//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (3, 19);");
//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (3, 20);");
//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (3, 21);");
//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (3, 22);");
//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (3, 23);");
//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (3, 24);");


//            st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador1Equipo2CatgMay.getNombre() + "','" + jugador1Equipo2CatgMay.getEdad() + "');");
//            st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador2Equipo2CatgMay.getNombre() + "','" + jugador2Equipo2CatgMay.getEdad() + "');");
//            st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador3Equipo2CatgMay.getNombre() + "','" + jugador3Equipo2CatgMay.getEdad() + "');");
//            st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador4Equipo2CatgMay.getNombre() + "','" + jugador4Equipo2CatgMay.getEdad() + "');");
//            st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador5Equipo2CatgMay.getNombre() + "','" + jugador5Equipo2CatgMay.getEdad() + "');");
//            st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador6Equipo2CatgMay.getNombre() + "','" + jugador6Equipo2CatgMay.getEdad() + "');");
//            st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador7Equipo2CatgMay.getNombre() + "','" + jugador7Equipo2CatgMay.getEdad() + "');");
//            st.executeUpdate("INSERT INTO jugadores (nombre, edad) VALUES ('" + jugador8Equipo2CatgMay.getNombre() + "','" + jugador8Equipo2CatgMay.getEdad() + "');");


//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (4, 25);");
//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (4, 26);");
//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (4, 27);");
//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (4, 28);");
//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (4, 29);");
//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (4, 30);");
//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (4, 31);");
//            st.executeUpdate("INSERT INTO equiposJugadores (equipoId, jugadorId) VALUES (4, 32);");
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
}
