# Sistema de Pedidos - Programación Orientada a Objetos

## Descripción

Este proyecto fue desarrollado en Java con el objetivo de aplicar los principales conceptos de Programación Orientada a Objetos estudiados durante las primeras semanas de la asignatura.

El sistema permite representar productos, clientes y pedidos, utilizando diferentes tipos de clientes y comportamientos específicos para cada uno.

## Objetivo del proyecto

Desarrollar un sistema sencillo de pedidos que permita aplicar conceptos como:

- Clases y objetos.
- Encapsulamiento.
- Herencia.
- Abstracción.
- Polimorfismo.
- Sobrescritura de métodos.
- Relaciones entre objetos.

## Principales funcionalidades

El sistema permite:

- Crear productos con código, nombre y precio.
- Crear diferentes tipos de clientes.
- Registrar clientes mayoristas.
- Registrar clientes minoristas.
- Registrar clientes VIP.
- Crear pedidos asociados a un cliente.
- Agregar productos a un pedido.
- Calcular descuentos dependiendo del tipo de cliente.
- Mostrar información de los pedidos y sus valores.
- Aplicar polimorfismo mediante diferentes implementaciones del método de descuento.

## Estructura principal del proyecto

El proyecto contiene las siguientes clases:

### Cliente

Representa la clase general para los clientes del sistema.

Contiene la información común de los clientes, como:

- Cédula.
- Nombre.
- Correo.

También define el comportamiento relacionado con el cálculo de descuentos.

### ClienteMayorista

Hereda de la clase `Cliente`.

Representa a un cliente que realiza compras como mayorista y puede aplicar una implementación específica del cálculo de descuento.

### ClienteMinorista

Hereda de la clase `Cliente`.

Representa a un cliente minorista y permite aplicar un comportamiento diferente al momento de calcular descuentos.

### ClienteVIP

Hereda de la clase `Cliente`.

Representa un cliente con un porcentaje de descuento especial.

Esta clase también permite demostrar el uso de herencia y polimorfismo.

### Producto

Representa los productos disponibles dentro del sistema.

Cada producto posee información como:

- Código.
- Nombre.
- Precio.

### ProductoPerecible

Representa un tipo específico de producto.

Permite extender las características de un producto normal utilizando herencia.

### Pedido

Representa una compra realizada por un cliente.

Un pedido puede contener uno o varios productos y se encuentra asociado a un cliente determinado.

### Main

Contiene el método `main`, que funciona como punto de inicio del programa.

En esta clase se crean los objetos principales, los clientes, los productos y los pedidos.

También se ejecutan los métodos necesarios para demostrar el funcionamiento del sistema.

## Conceptos de Programación Orientada a Objetos utilizados

### Encapsulamiento

Los atributos de las clases se protegen para evitar que sean modificados directamente desde cualquier parte del programa.

El acceso a estos datos se realiza mediante métodos y constructores.

### Herencia

Las clases `ClienteMayorista`, `ClienteMinorista` y `ClienteVIP` heredan características de la clase `Cliente`.

También se utiliza herencia en las clases relacionadas con productos.

Esto permite reutilizar código y evitar duplicación.

### Abstracción

La clase `Cliente` representa las características comunes que comparten los distintos tipos de clientes.

De esta manera, cada clase específica puede implementar su propio comportamiento.

### Polimorfismo

El sistema utiliza referencias del tipo `Cliente` para trabajar con objetos de diferentes clases.

Por ejemplo:

```java
Cliente clienteMayorista = new ClienteMayorista(...);
Cliente clienteMinorista = new ClienteMinorista(...);
Cliente clienteVIP = new ClienteVIP(...);