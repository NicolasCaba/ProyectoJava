package entidades;

import java.io.Serializable;

/**
 * @author Nicolás
 */
public class Torneo implements Serializable {
    private String nombre;
    private int numeroDeEquipos;
    private int numeroTotalJugadores;
    private CategoriaJuvenil categoriaJuvenil;
    private CategoriaMayores categoriaMayores;

    public Torneo(String nombre, int numeroDeEquipos, int numeroTotalJugadores, CategoriaJuvenil categoriaJuvenil, CategoriaMayores categoriaMayores) {
        this.nombre = nombre;
        this.numeroDeEquipos = numeroDeEquipos;
        this.numeroTotalJugadores = numeroTotalJugadores;
        this.categoriaJuvenil = categoriaJuvenil;
        this.categoriaMayores = categoriaMayores;
    }

    @Override
    public String toString() {
        return nombre + "%" + numeroDeEquipos + "%" + numeroTotalJugadores + "%" + categoriaJuvenil.getNombre() + "%" + categoriaMayores.getNombre();
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

    public CategoriaJuvenil getCategoriaJuvenil() {
        return categoriaJuvenil;
    }

    public void setCategoriaJuvenil(CategoriaJuvenil categoriaJuvenil) {
        this.categoriaJuvenil = categoriaJuvenil;
    }

    public CategoriaMayores getCategoriaMayores() {
        return categoriaMayores;
    }

    public void setCategoriaMayores(CategoriaMayores categoriaMayores) {
        this.categoriaMayores = categoriaMayores;
    }
}
