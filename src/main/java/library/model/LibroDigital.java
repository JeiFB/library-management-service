package main.java.library.model;

import main.java.library.capacity.Descargar;

public class LibroDigital extends MaterialBibliografico implements Descargar {

    public LibroDigital(){}

    public LibroDigital(String codigo, String titulo) {
        super(codigo, titulo);
    }

    public LibroDigital(String codigo, String titulo, int anioPublicacion){
        super(codigo, titulo, anioPublicacion);
    }

    @Override
    public String mostrarInformacion() {
        return "";
    }

    @Override
    public boolean descargar() {
        return false;
    }
}
