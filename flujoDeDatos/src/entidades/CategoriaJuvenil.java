package entidades;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Nicolás
 */
public class CategoriaJuvenil implements Serializable {
    private String nombre;
    private int numeroDeEquipos;
    private int numeroTotalJugadores;
    private String rangoEdad;
    private ArrayList<Equipo> equipos;

    public CategoriaJuvenil(String nombre, int numeroDeEquipos, int numeroTotalJugadores, String rangoEdad, ArrayList<Equipo> equipos) {
        this.nombre = nombre;
        this.numeroDeEquipos = numeroDeEquipos;
        this.numeroTotalJugadores = numeroTotalJugadores;
        this.rangoEdad = rangoEdad;
        this.equipos = equipos;
    }

    @Override
    public String toString() {
        return "CategoriaJuvenil{" + "nombre=" + nombre + ", numeroDeEquipos=" + numeroDeEquipos + ", numeroTotalJugadores=" + numeroTotalJugadores + ", rangoEdad=" + rangoEdad + ", equipos=" + equipos + '}';
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroDeEquipos() {
        return numeroDeEquipos;
    }

    public void setNumeroDeEquipos(int numeroDeEquipos) {
        this.numeroDeEquipos = numeroDeEquipos;
    }

    public int getNumeroTotalJugadores() {
        return numeroTotalJugadores;
    }

    public void setNumeroTotalJugadores(int numeroTotalJugadores) {
        this.numeroTotalJugadores = numeroTotalJugadores;
    }

    public String getRangoEdad() {
        return rangoEdad;
    }

    public void setRangoEdad(String rangoEdad) {
        this.rangoEdad = rangoEdad;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }
    
}
