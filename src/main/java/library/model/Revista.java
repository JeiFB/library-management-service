package library.model;

import library.capacity.Prestable;

public class Revista extends MaterialBibliografico implements Prestable {

    private int numeroEdicion;
    private boolean prestado;

    public Revista(String codigo, String titulo, int anioPublicacion, int numeroEdicion) {
        super(codigo, titulo, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
        this.prestado = false;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    @Override
    public boolean prestar() {
        if (prestado) {
            return false;
        }
        prestado = true;
        return true;
    }

    @Override
    public boolean devolver() {
        if (!prestado) {
            return false;
        }
        prestado = false;
        return true;
    }

    @Override
    public boolean estaPrestado() {
        return prestado;
    }

    @Override
    public String mostrarInformacion() {
        return "Tipo: Revista\n" +
                "Código: " + getCodigo() + "\n" +
                "Título: " + getTitulo() + "\n" +
                "Año: " + getAnioPublicacion() + "\n" +
                "Número de edición: " + numeroEdicion + "\n" +
                "Estado: " + (prestado ? "Prestada" : "Disponible");
    }
}
