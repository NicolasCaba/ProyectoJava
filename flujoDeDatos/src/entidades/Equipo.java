package entidades;

/**
 * @author Nicolás
 */
public class Equipo {
    private String nombre;
    private int numeroTotalJugadores;
    private String categoria;
    private Jugador jugadores[];
    private String rutaDeImagen;
    private int numeroAficionados;
    private double victorias;
    private double derrotas;

    public Equipo(String nombre, int numeroTotalJugadores, String categoria, Jugador[] jugadores, String rutaDeImagen, int numeroAficionados, double victorias, double derrotas) {
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
        String sJugadores = "$";
        for(Jugador j: jugadores){
            if(j != null){
                sJugadores += j.toString() + "/";
            }
        }
        sJugadores += "$";
        
        return nombre + "%" + numeroTotalJugadores + "%" + categoria + "%"  + sJugadores + "%" + rutaDeImagen + "%" + numeroAficionados + "%" + victorias + "%" + derrotas;
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

    public void setVictorias(double victorias) {
        this.victorias = victorias;
    }

    public double getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(double derrotas) {
        this.derrotas = derrotas;
    }
}
