package library.model;

import library.capacity.Descargable;

public class LibroDigital extends MaterialBibliografico implements Descargable {

    private String autor;
    private double tamanoArchivoMB;

    public LibroDigital(String codigo, String titulo, int anioPublicacion, String autor, double tamanoArchivoMB) {
        super(codigo, titulo, anioPublicacion);
        this.autor = autor;
        this.tamanoArchivoMB = tamanoArchivoMB;
    }

    public String getAutor() {
        return autor;
    }

    public double getTamanoArchivoMB() {
        return tamanoArchivoMB;
    }

    @Override
    public boolean descargar() {
        return true;
    }

    @Override
    public String mostrarInformacion() {
        return "Tipo: Libro digital\n" +
                "Código: " + getCodigo() + "\n" +
                "Título: " + getTitulo() + "\n" +
                "Año: " + getAnioPublicacion() + "\n" +
                "Autor: " + autor + "\n" +
                "Tamaño del archivo: " + tamanoArchivoMB + " MB";
    }
}
