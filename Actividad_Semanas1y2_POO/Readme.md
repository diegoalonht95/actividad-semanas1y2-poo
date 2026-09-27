# Sistema de Pedidos - Semana 7

Proyecto desarrollado en Java para aplicar los conceptos de tipos de datos abstractos lineales, patrón Repository y pruebas unitarias.

## Descripción

El sistema administra pedidos utilizando una cola implementada manualmente.

La cola permite procesar los pedidos siguiendo el principio FIFO:

First In, First Out.

Esto significa que el primer pedido que ingresa es el primero en ser procesado.

## Estructura de datos utilizada

Se implementó una cola propia sin utilizar directamente Queue, LinkedList o ArrayDeque de Java.

La cola incluye las siguientes operaciones:

- Encolar un elemento.
- Desencolar un elemento.
- Consultar el primer elemento.
- Verificar si la cola está vacía.
- Consultar la cantidad de elementos.

## Patrón Repository

Se implementó el patrón Repository para separar el manejo de los datos de la lógica principal del sistema.

Las principales clases utilizadas son:

- PedidoRepository
- PedidoRepositoryImpl
- ColaPedidos
- Nodo
- Pedido

PedidoRepository define las operaciones disponibles.

PedidoRepositoryImpl implementa estas operaciones y utiliza internamente ColaPedidos para administrar los pedidos.

## Pruebas unitarias

Las pruebas fueron desarrolladas utilizando JUnit 5.

Se implementaron 6 pruebas unitarias para verificar:

- Cola vacía.
- Agregar elementos.
- Consultar el primer elemento.
- Orden FIFO.
- Actualización de la cantidad.
- Estado vacío después de eliminar todos los elementos.

Resultado obtenido:

Tests run: 6, Failures: 0, Errors: 0, Skipped: 0

## Ejecutar el proyecto

Para compilar el proyecto:

```bash
mvn clean compile