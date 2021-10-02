package entidades;

/**
 * @author Nicolás
 */
public class Jugador {
    private String nombre;
    private int edad;
    private String equipoAlQuePertenece;
    private String categoria;

    public Jugador(String nombre, int edad, String equipoAlQuePertenece, String categoria) {
        this.nombre = nombre;
        this.edad = edad;
        this.equipoAlQuePertenece = equipoAlQuePertenece;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", edad=" + edad + ", equipoAlQuePertenece=" + equipoAlQuePertenece + ", categoria=" + categoria + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEquipoAlQuePertenece() {
        return equipoAlQuePertenece;
    }

    public void setEquipoAlQuePertenece(String equipoAlQuePertenece) {
        this.equipoAlQuePertenece = equipoAlQuePertenece;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
