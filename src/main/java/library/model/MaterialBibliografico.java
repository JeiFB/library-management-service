package library.model;

public abstract class MaterialBibliografico {

    private String codigo;
    private String titulo;
    private int anioPublicacion;

    private static int totalCreados = 0;

    protected MaterialBibliografico(String codigo, String titulo, int anioPublicacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        totalCreados++;
    }

    protected MaterialBibliografico(String codigo, String titulo) {
        this(codigo, titulo, 0);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public static int getTotalCreados() {
        return totalCreados;
    }

    public abstract String mostrarInformacion();
}
