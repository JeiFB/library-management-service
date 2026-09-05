package main.java.library.service;

import main.java.library.model.LibroDigital;
import main.java.library.model.MaterialBibliografico;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Biblioteca {
    private Map<String, MaterialBibliografico> dataBaseMaterialBibliografico  = new HashMap<>();
    private Map<String, Supplier<MaterialBibliografico>> typeMaterial = Map.of("1", LibroDigital::new); //Supplier me permite crear objetos nuevos y que el programa no utilice el ya creado en memoria
    public  Biblioteca(){}

    public void registrarMaterialBibliografico(List<String> dataMaterial){
        MaterialBibliografico materialBibliografico = registrarDataMaterial(dataMaterial.get(0),dataMaterial.get(1),dataMaterial.get(2), dataMaterial.get(3));
        setDataBaseMaterialBibliografico(dataMaterial.get(1), materialBibliografico);

    }
    public void listarMaterialBibliografico(){
        for(MaterialBibliografico material : getDataBaseMaterialBibliografico().values()){
            IO.println("Codigo: " + material.getCodigo());
            IO.println("Titulo: " + material.getTitulo());
            IO.println("Año de programacion: " + material.getAnioPublicacion());
            IO.println("--------------------------------");
        }
    }

    private MaterialBibliografico registrarDataMaterial(String typeMaterial, String codigo, String titulo, String anioPublicacion){
        Supplier<MaterialBibliografico> constructor = getTypeMaterial().get(typeMaterial);
        MaterialBibliografico material = constructor.get();
        material.setCodigo(codigo);
        material.setTitulo(titulo);
        material.setAnioPublicacion(Integer.parseInt(anioPublicacion));
        return material;
    }


    public Map<String, Supplier<MaterialBibliografico>> getTypeMaterial(){
        return this.typeMaterial;
    }

    public Map<String, MaterialBibliografico> getDataBaseMaterialBibliografico(){
        return this.dataBaseMaterialBibliografico;
    }

    public void setDataBaseMaterialBibliografico(String cogido, MaterialBibliografico material){
        this.dataBaseMaterialBibliografico.put(cogido,material);
    }

}
