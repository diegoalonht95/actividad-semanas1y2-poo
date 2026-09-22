# Sistema de Pedidos - Semanas 5 y 6

## Descripción

Este proyecto corresponde a las actividades de las semanas 5 y 6 de Programación Orientada a Objetos.

Durante estas semanas se implementó un catálogo de productos utilizando colecciones y genéricos en Java, además de una interfaz gráfica desarrollada con JavaFX.

## Tecnologías utilizadas

- Java 21
- JavaFX
- Maven
- Visual Studio Code

## Colecciones utilizadas

El catálogo utiliza las siguientes colecciones:

- `ArrayList<Producto>`: almacena los productos registrados.
- `HashMap<String, Producto>`: permite buscar productos mediante su código.
- `HashSet<String>`: evita que se registren códigos duplicados.

## Funcionalidades

La aplicación permite:

- Agregar productos.
- Buscar productos por código.
- Listar productos.
- Actualizar productos.
- Eliminar productos.
- Evitar registros duplicados.
- Validar los datos ingresados.

## Interfaz gráfica

La interfaz fue desarrollada utilizando JavaFX.

Incluye:

- Campo de código.
- Campo de nombre.
- Campo de precio.
- Tabla de productos.
- Botón Agregar.
- Botón Buscar.
- Botón Actualizar.
- Botón Eliminar.
- Botón Limpiar.

Los botones utilizan manejo de eventos para ejecutar las operaciones del catálogo.

## Cómo ejecutar el proyecto

Se necesita:

- Java JDK 21.
- Apache Maven.

Desde la carpeta donde se encuentra el archivo `pom.xml`, ejecutar:

```bash
mvn clean javafx:run