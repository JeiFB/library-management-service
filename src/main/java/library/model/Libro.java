package library.model;

import library.capacity.Prestable;

public class Libro extends MaterialBibliografico implements Prestable {

    private String autor;
    private boolean prestado;

    public Libro(String codigo, String titulo, int anioPublicacion, String autor) {
        super(codigo, titulo, anioPublicacion);
        this.autor = autor;
        this.prestado = false;
    }

    public Libro(String codigo, String titulo, String autor) {
        this(codigo, titulo, 0, autor);
    }

    public String getAutor() {
        return autor;
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
        return "Tipo: Libro\n" +
                "Código: " + getCodigo() + "\n" +
                "Título: " + getTitulo() + "\n" +
                "Año: " + getAnioPublicacion() + "\n" +
                "Autor: " + autor + "\n" +
                "Estado: " + (prestado ? "Prestado" : "Disponible");
    }
}
