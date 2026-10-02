# Sistema de Pedidos

Proyecto desarrollado en **Java** para la asignatura de Programación Orientada a Objetos.

El sistema permite administrar un catálogo de productos mediante una interfaz gráfica, aplicando conceptos estudiados durante las Semanas 5, 6 y 7, como colecciones, estructuras de datos, patrón Repository, pruebas unitarias, interfaz gráfica y persistencia de datos.

## Descripción

**Sistema de Pedidos** es una aplicación desarrollada en Java que permite registrar y administrar productos de manera sencilla.

El sistema cuenta con una interfaz gráfica desde la cual el usuario puede agregar, buscar, actualizar y eliminar productos.

Además, implementa persistencia de datos mediante un archivo de texto, permitiendo que los productos registrados permanezcan almacenados incluso después de cerrar la aplicación.

También se implementó una estructura de datos tipo cola para administrar pedidos siguiendo el principio **FIFO (First In, First Out)**.

## Objetivo

Desarrollar una aplicación en Java que permita aplicar de manera práctica los conceptos de Programación Orientada a Objetos y los temas estudiados durante la asignatura.

Entre los principales conceptos utilizados se encuentran:

- Clases y objetos.
- Encapsulamiento.
- Herencia y polimorfismo.
- Colecciones de Java.
- Genéricos.
- Estructuras de datos.
- Cola FIFO.
- Patrón Repository.
- Pruebas unitarias.
- Interfaz gráfica.
- Persistencia de datos.

## Funcionalidades

El sistema permite realizar las siguientes operaciones:

- Agregar productos.
- Buscar productos mediante su código.
- Actualizar el nombre y precio de un producto.
- Eliminar productos.
- Listar los productos registrados.
- Evitar el registro de productos con códigos duplicados.
- Validar los datos ingresados por el usuario.
- Mostrar los productos mediante una interfaz gráfica.
- Guardar los productos de forma persistente.
- Recuperar automáticamente los productos almacenados al iniciar nuevamente la aplicación.
- Administrar pedidos mediante una estructura de datos tipo cola.
- Procesar pedidos siguiendo el principio FIFO.
- Realizar pruebas unitarias sobre las operaciones principales de la cola.

## Colecciones utilizadas

Para la administración de productos se utilizan diferentes colecciones de Java:

### ArrayList

Se utiliza para mantener la lista de productos registrados.

### HashMap

Permite buscar rápidamente un producto utilizando su código.

### HashSet

Se utiliza para controlar los códigos registrados y evitar productos duplicados.

Estas estructuras permiten administrar los datos de manera organizada y eficiente.

## Cola de pedidos

Durante la Semana 7 se implementó una estructura de datos tipo **cola** de forma manual.

La cola trabaja siguiendo el principio:

**FIFO - First In, First Out**

Esto significa que el primer pedido que entra en la cola es el primero en ser procesado.

Entre las principales operaciones implementadas se encuentran:

- Agregar un pedido a la cola.
- Eliminar el primer pedido.
- Consultar el siguiente pedido.
- Verificar si la cola está vacía.
- Consultar la cantidad de pedidos almacenados.

## Patrón Repository

El proyecto utiliza el patrón **Repository** para separar la lógica relacionada con el manejo de los pedidos del resto de la aplicación.

Se utilizan componentes como:

- `PedidoRepository`
- `PedidoRepositoryImpl`

Esta organización permite mantener el código más ordenado y separar las responsabilidades de cada clase.

## Persistencia de datos

El proyecto implementa persistencia mediante un archivo de texto llamado:

```text
productos.txt
```

Cada vez que se agrega, actualiza o elimina un producto, la información del catálogo se guarda en este archivo.

Cuando la aplicación se inicia nuevamente, el sistema lee automáticamente el archivo y recupera los productos almacenados anteriormente.

De esta forma, la información no se pierde al cerrar el programa.

Ejemplo del contenido almacenado:

```text
P001;ARROZ;2.5
P002;LECHE;1.75
```

La persistencia es administrada desde la clase:

```text
CatalogoProductos
```

Esta clase contiene los métodos encargados de guardar y cargar los productos.

## Interfaz gráfica

La aplicación incluye una interfaz gráfica desarrollada utilizando **JavaFX**.

La interfaz permite ingresar:

- Código del producto.
- Nombre del producto.
- Precio.

Además, dispone de los siguientes botones:

- **Agregar**
- **Buscar**
- **Actualizar**
- **Eliminar**
- **Limpiar**

Los productos registrados se muestran en una tabla dentro de la misma aplicación.

La clase principal de la interfaz gráfica es:

```text
CatalogoApp
```

## Organización general del proyecto

Entre las principales clases desarrolladas se encuentran:

```text
CatalogoApp
CatalogoProductos
Cliente
ClienteMayorista
ClienteMinorista
ClienteVIP
ColaPedidos
Main
Nodo
Pedido
PedidoRepository
PedidoRepositoryImpl
Producto
ProductoPerecible
```

También se incluyen pruebas unitarias para comprobar el funcionamiento de la estructura de cola.

```text
ColaPedidosTest
```

## Pruebas unitarias

El proyecto utiliza **JUnit** para realizar pruebas unitarias.

Las pruebas permiten comprobar el funcionamiento correcto de las operaciones implementadas en `ColaPedidos`, verificando el comportamiento de la estructura de datos antes de utilizarla dentro del sistema.

## Tecnologías utilizadas

- Java 21
- JavaFX 21
- Maven
- JUnit 5
- IntelliJ IDEA
- Git
- GitHub

## Lenguaje utilizado

El proyecto fue desarrollado utilizando:

**Java**

## Requisitos

Para ejecutar el proyecto se recomienda tener instalado:

- JDK 21.
- Maven.
- IntelliJ IDEA o un IDE compatible con Java.
- Conexión a Internet durante la primera ejecución para que Maven pueda descargar las dependencias necesarias.

## Ejecución del proyecto

### Desde IntelliJ IDEA

1. Abrir el proyecto en IntelliJ IDEA.
2. Esperar a que Maven cargue las dependencias.
3. Abrir la ventana de **Maven**.
4. Buscar el proyecto `sistema-pedidos`.
5. Abrir:

```text
Plugins
```

6. Buscar:

```text
javafx
```

7. Ejecutar:

```text
javafx:run
```

La aplicación abrirá la ventana del catálogo de productos.

### Desde Maven

También puede ejecutarse desde una terminal ubicada en la carpeta principal del proyecto mediante:

```bash
mvn javafx:run
```

## Demostración de persistencia

Para comprobar el funcionamiento de la persistencia:

1. Ejecutar la aplicación.
2. Registrar un producto.
3. Verificar que aparezca en la tabla.
4. Cerrar completamente la aplicación.
5. Ejecutar nuevamente el proyecto.
6. Comprobar que el producto registrado anteriormente continúa apareciendo.

Esto demuestra que los datos son almacenados y recuperados correctamente.

## Autor

**Diego Herrera**

Proyecto académico desarrollado para la Universidad de Especialidades Espíritu Santo (UEES).

## Estado del proyecto

Versión correspondiente al desarrollo realizado hasta las **Semanas 5, 6 y 7** de la asignatura.   