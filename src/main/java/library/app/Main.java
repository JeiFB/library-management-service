package library.app;

import library.model.Libro;
import library.model.LibroDigital;
import library.model.Revista;
import library.service.Biblioteca;

import java.util.List;
import java.util.Scanner;

public class Main {

    private Biblioteca biblioteca;
    private Scanner scanner;

    public Main() {
        this.biblioteca = new Biblioteca();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Main app = new Main();
        boolean salir = false;
        while (!salir) {
            app.mostrarMenu();
            int opcion = app.leerOpcion();
            switch (opcion) {
                case 1:
                    app.registrarLibro();
                    break;
                case 2:
                    app.registrarRevista();
                    break;
                case 3:
                    app.registrarLibroDigital();
                    break;
                case 4:
                    app.mostrarMateriales();
                    break;
                case 5:
                    app.prestarMaterial();
                    break;
                case 6:
                    app.devolverMaterial();
                    break;
                case 7:
                    app.descargarMaterial();
                    break;
                case 8:
                    app.mostrarEstadisticas();
                    break;
                case 0:
                    salir = true;
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println();
        System.out.println("BIBLIOTECA UNIVERSITARIA");
        System.out.println("1. Registrar libro");
        System.out.println("2. Registrar revista");
        System.out.println("3. Registrar libro digital");
        System.out.println("4. Mostrar materiales");
        System.out.println("5. Prestar material");
        System.out.println("6. Devolver material");
        System.out.println("7. Descargar material digital");
        System.out.println("8. Mostrar estadísticas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private int leerOpcion() {
        String entrada = scanner.nextLine().trim();
        try {
            return Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void registrarLibro() {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Año de publicación: ");
        int anio = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        Libro libro = new Libro(codigo, titulo, anio, autor);
        if (biblioteca.registrarMaterial(libro)) {
            System.out.println("Libro registrado correctamente.");
        } else {
            System.out.println("Ya existe un material con ese código.");
        }
    }

    private void registrarRevista() {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Año de publicación: ");
        int anio = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Número de edición: ");
        int numeroEdicion = Integer.parseInt(scanner.nextLine().trim());

        Revista revista = new Revista(codigo, titulo, anio, numeroEdicion);
        if (biblioteca.registrarMaterial(revista)) {
            System.out.println("Revista registrada correctamente.");
        } else {
            System.out.println("Ya existe un material con ese código.");
        }
    }

    private void registrarLibroDigital() {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Año de publicación: ");
        int anio = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Tamaño del archivo (MB): ");
        double tamano = Double.parseDouble(scanner.nextLine().trim());

        LibroDigital libroDigital = new LibroDigital(codigo, titulo, anio, autor, tamano);
        if (biblioteca.registrarMaterial(libroDigital)) {
            System.out.println("Libro digital registrado correctamente.");
        } else {
            System.out.println("Ya existe un material con ese código.");
        }
    }

    private void mostrarMateriales() {
        List<String> materiales = biblioteca.listarMateriales();
        if (materiales.isEmpty()) {
            System.out.println("No hay materiales registrados.");
            return;
        }
        for (String informacion : materiales) {
            System.out.println("--------------------------------");
            System.out.println(informacion);
        }
        System.out.println("--------------------------------");
    }

    private void prestarMaterial() {
        System.out.print("Código del material a prestar: ");
        String codigo = scanner.nextLine();
        if (biblioteca.prestarMaterial(codigo)) {
            System.out.println("Material prestado correctamente.");
        } else {
            System.out.println("No se pudo prestar el material.");
        }
    }

    private void devolverMaterial() {
        System.out.print("Código del material a devolver: ");
        String codigo = scanner.nextLine();
        if (biblioteca.devolverMaterial(codigo)) {
            System.out.println("Material devuelto correctamente.");
        } else {
            System.out.println("No se pudo devolver el material.");
        }
    }

    private void descargarMaterial() {
        System.out.print("Código del material a descargar: ");
        String codigo = scanner.nextLine();
        if (biblioteca.descargarMaterial(codigo)) {
            System.out.println("Material descargado correctamente.");
        } else {
            System.out.println("No se pudo descargar el material.");
        }
    }

    private void mostrarEstadisticas() {
        System.out.println("Total de materiales creados: " + biblioteca.obtenerTotalMaterialesCreados());
    }
}
