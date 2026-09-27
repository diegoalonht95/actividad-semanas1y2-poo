# Sistema de Pedidos - Semana 7

Proyecto desarrollado en Java para aplicar los conceptos de tipos de datos abstractos lineales, patrón Repository y pruebas unitarias.

## Descripción

El sistema administra pedidos utilizando una cola implementada manualmente.

La cola sigue el principio FIFO:

**First In, First Out**

Esto significa que el primer pedido que ingresa es el primero en ser procesado.

## Estructura de datos utilizada

Se implementó manualmente una cola utilizando las clases:

- `Nodo`
- `ColaPedidos`

La cola permite:

- Agregar elementos.
- Eliminar elementos.
- Consultar el siguiente elemento.
- Verificar si está vacía.
- Consultar la cantidad de elementos.

No se utilizaron directamente `Queue`, `LinkedList` ni `ArrayDeque`.

## Patrón Repository

Se implementó el patrón Repository mediante:

- `PedidoRepository`
- `PedidoRepositoryImpl`

El Repository separa el manejo de los datos de la lógica principal de la aplicación.

`PedidoRepositoryImpl` utiliza internamente `ColaPedidos` para administrar los pedidos.

## Pruebas unitarias

Las pruebas fueron desarrolladas con JUnit 5.

Se realizaron 6 pruebas para comprobar:

- Cola inicialmente vacía.
- Agregar elementos.
- Consultar el primer elemento.
- Orden FIFO.
- Actualización de la cantidad.
- Cola vacía después de eliminar todos los elementos.

Resultado:

```text
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0