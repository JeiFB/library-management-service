# Sistema de Gestión de Biblioteca Universitaria

Aplicación de consola en Java que permite registrar y gestionar distintos tipos
de materiales bibliográficos: libros, revistas y libros digitales.

## Estructura del proyecto

```
src/main/java/
  library/
    model/
      MaterialBibliografico.java   (clase abstracta)
      Libro.java
      Revista.java
      LibroDigital.java
    capacity/
      Prestable.java               (interfaz)
      Descargable.java             (interfaz)
    service/
      Biblioteca.java
    app/
      Main.java                    (menú de consola)
```

## Requisitos

- Java 17 o superior (el proyecto se probó con Java 25).

## Compilar

Desde la carpeta `src/main/java`:

```
javac -d out library/model/*.java library/capacity/*.java library/service/*.java library/app/*.java
```

## Ejecutar

Desde la carpeta `src/main/java`:

```
java -cp out library.app.Main
```

## Funcionalidades del menú

1. Registrar libro
2. Registrar revista
3. Registrar libro digital
4. Mostrar materiales
5. Prestar material
6. Devolver material
7. Descargar material digital
8. Mostrar estadísticas
0. Salir

## Conceptos de POO aplicados

- **Clase abstracta:** `MaterialBibliografico` reúne los datos y comportamientos
  comunes y no se puede instanciar directamente.
- **Herencia:** `Libro`, `Revista` y `LibroDigital` extienden a
  `MaterialBibliografico`.
- **Interfaces:** `Prestable` (prestar/devolver) y `Descargable` (descargar)
  representan capacidades y se aplican solo a los tipos que corresponde.
- **Encapsulamiento:** los atributos son privados y se acceden mediante métodos.
- **Sobrecarga:** `Libro` y `MaterialBibliografico` tienen constructores con
  distinto número de parámetros.
- **static:** el contador `totalCreados` pertenece a la clase, no a cada objeto.
- **Polimorfismo:** `Biblioteca` guarda los materiales en una lista de
  `MaterialBibliografico` y llama a `mostrarInformacion()` sin preguntar el tipo
  concreto de cada objeto.
