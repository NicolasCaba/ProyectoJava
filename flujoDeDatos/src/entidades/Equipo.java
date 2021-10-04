package entidades;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author Nicolás
 */
public class Equipo implements Serializable {
    private String nombre;
    private int numeroTotalJugadores;
    private String categoria;
    private Jugador jugadores[];
    private String rutaDeImagen;
    private int numeroAficionados;
    private float victorias;
    private float derrotas;
    
    public Equipo(){
        
    }

    public Equipo(String nombre, int numeroTotalJugadores, String categoria, Jugador[] jugadores, String rutaDeImagen, int numeroAficionados, float victorias, float derrotas) {
        this.nombre = nombre;
        this.numeroTotalJugadores = numeroTotalJugadores;
        this.categoria = categoria;
        this.jugadores = jugadores;
        this.rutaDeImagen = rutaDeImagen;
        this.numeroAficionados = numeroAficionados;
        this.victorias = victorias;
        this.derrotas = derrotas;
    }

    @Override
    public String toString() {
        return "Equipo{" + "nombre=" + nombre + ", numeroTotalJugadores=" + numeroTotalJugadores + ", categoria=" + categoria + ", jugadores=" + Arrays.toString(jugadores) + ", rutaDeImagen=" + rutaDeImagen + ", numeroAficionados=" + numeroAficionados + ", victorias=" + victorias + ", derrotas=" + derrotas + '}';
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroTotalJugadores() {
        return numeroTotalJugadores;
    }

    public void setNumeroTotalJugadores(int numeroTotalJugadores) {
        this.numeroTotalJugadores = numeroTotalJugadores;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

    public String getRutaDeImagen() {
        return rutaDeImagen;
    }

    public void setRutaDeImagen(String rutaDeImagen) {
        this.rutaDeImagen = rutaDeImagen;
    }

    public int getNumeroAficionados() {
        return numeroAficionados;
    }

    public void setNumeroAficionados(int numeroAficionados) {
        this.numeroAficionados = numeroAficionados;
    }

    public double getVictorias() {
        return victorias;
    }

    public void setVictorias(float victorias) {
        this.victorias = victorias;
    }

    public double getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(float derrotas) {
        this.derrotas = derrotas;
    }
}
