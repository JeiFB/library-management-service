package library.service;

import library.capacity.Descargable;
import library.capacity.Prestable;
import library.model.MaterialBibliografico;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<MaterialBibliografico> materiales = new ArrayList<>();

    public Biblioteca() {
    }

    public boolean registrarMaterial(MaterialBibliografico material) {
        if (buscarPorCodigo(material.getCodigo()) != null) {
            return false;
        }
        materiales.add(material);
        return true;
    }

    public MaterialBibliografico buscarPorCodigo(String codigo) {
        for (MaterialBibliografico material : materiales) {
            if (material.getCodigo().equals(codigo)) {
                return material;
            }
        }
        return null;
    }

    public List<String> listarMateriales() {
        List<String> informacion = new ArrayList<>();
        for (MaterialBibliografico material : materiales) {
            informacion.add(material.mostrarInformacion());
        }
        return informacion;
    }

    public boolean prestarMaterial(String codigo) {
        MaterialBibliografico material = buscarPorCodigo(codigo);
        if (material instanceof Prestable) {
            return ((Prestable) material).prestar();
        }
        return false;
    }

    public boolean devolverMaterial(String codigo) {
        MaterialBibliografico material = buscarPorCodigo(codigo);
        if (material instanceof Prestable) {
            return ((Prestable) material).devolver();
        }
        return false;
    }

    public boolean descargarMaterial(String codigo) {
        MaterialBibliografico material = buscarPorCodigo(codigo);
        if (material instanceof Descargable) {
            return ((Descargable) material).descargar();
        }
        return false;
    }

    public int obtenerTotalMaterialesCreados() {
        return MaterialBibliografico.getTotalCreados();
    }
}
