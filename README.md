# Actividad Semanas 1, 2 y 3 - POO

Proyecto realizado en Java para aplicar los temas vistos en las primeras tres semanas de Programación Orientada a Objetos.

## Semana 1

Se trabajó con clases, objetos y encapsulación utilizando las clases `Cliente` y `Producto`.

## Semana 2

Se aplicó herencia mediante las clases `ClienteVIP` y `ProductoPerecible`. También se utilizó la clase `Pedido` para relacionar un cliente con varios productos.

## Semana 3

Se incorporaron los conceptos de polimorfismo, clases abstractas y sobrescritura de métodos.

La clase `Cliente` fue definida como clase abstracta y contiene el método `calcularDescuento(double subtotal)`.

Las clases `ClienteMayorista`, `ClienteMinorista` y `ClienteVIP` heredan de `Cliente` y sobrescriben este método con un comportamiento diferente.

- `ClienteMayorista`: aplica un descuento del 15%.
- `ClienteMinorista`: aplica un descuento del 5%.
- `ClienteVIP`: aplica el porcentaje de descuento definido para el cliente.

La clase `Pedido` trabaja con una referencia de tipo `Cliente` y utiliza el método `calcularDescuento()` sin condicionales para determinar el tipo de cliente. De esta manera se aplica polimorfismo.

## Archivos principales

- `Cliente.java`
- `ClienteVIP.java`
- `ClienteMayorista.java`
- `ClienteMinorista.java`
- `Producto.java`
- `ProductoPerecible.java`
- `Pedido.java`
- `Main.java`

## Diagramas

- `semana1.png`
- `semana2.png`

Para probar el programa se debe ejecutar `Main.java`.
