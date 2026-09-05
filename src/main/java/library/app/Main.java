import main.java.library.service.Biblioteca;

void main() {
    Scanner scanner = new Scanner(System.in);
    Biblioteca biblioteca = new Biblioteca();

    mostrarMenu();
    int opc = scanner.nextInt();
    while (opc != 0){
        switcher(scanner,biblioteca,opc);
        mostrarMenu();
        opc = scanner.nextInt();
    }
}

private void opciones(){
    IO.println("Seleccione una opcion");
    IO.println("1. Mostrar Menu");
    IO.println("0. Salir del programa");
}
private void mostrarMenu(){
    IO.println("Seleccione una opción");
    IO.println("1. Listar Materiales Bibliograficos");
    IO.println("2. Prestar Material Bilbligrafico");
    IO.println("3. Registrar Material Bibliografico");
    IO.println("4. Devolver Material Bibliografico");
    IO.println("5. Buscar por Codigo");
    IO.println("6. Total de Material Bibliograficos Creados");
    IO.println("0. Salir");
}
private List<String> menuMaterial(Scanner scanner){
    List<String> dataMaterial = new ArrayList<>();
    IO.println("Seleccione una opcion del tipo de material a registrar:");
    IO.println("Digite 1 para regitrar un libro digital");
    IO.println("Digite 2 para regitrar una revista");
    IO.println("Digite 3 para regitrar un libro");

    dataMaterial.add(scanner.nextLine());

    IO.println("------------------------------------------");
    IO.println("Digite el codigo: ");
    dataMaterial.add(scanner.nextLine());
    IO.println("Digite el titulo: ");
    dataMaterial.add(scanner.nextLine());
    IO.println("Digite el año de publicación: ");
    dataMaterial.add(scanner.nextLine());
    return dataMaterial;
}


private void switcher(Scanner scanner, Biblioteca biblioteca,int opcion){
    scanner.nextLine();
    switch (opcion){
        case 1:
            biblioteca.listarMaterialBibliografico();
            break;
        case 2:

            break;
        case 3:
            biblioteca.registrarMaterialBibliografico(menuMaterial(scanner));
            break;
        case 4:
            break;
        case 5:
            break;
        case 6:
            break;
        default:
            System.exit(0);
    }
}

