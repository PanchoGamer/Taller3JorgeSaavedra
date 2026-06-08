# Taller 3 POO 2026

## Integrantes
- Jorge Andrés Saavedra Sánchez | Rut: 22.347.590-6 | Usuario GitHub: PanchoGamer

## Descripcion del Proyecto
Se nos pide realizar un juego de magia para un proyecto de programacion avanzada.

1. Menu Administrador
   - Añadir Mago
   - Modificar Mago
   - Eliminar Mago
   - Añadir Hechizo
   - Modificar Hechizo
   - Eliminar Hechizo

2. Menu Analisis
   - Top 10 mejores hechizos
   - Top 3 mejores magos
   - Mostrar todos los hechizos
   - Mostrar todos los magos
   - Mostrar todos los hechizos junto a su puntuacion
   - Mostrar todos los magos junto a su puntuacion

## Indicaciones
### Para esto se nos indican unas cosas, por ejemplo:

-Para cada tipo de hechizo existe un metodo diferente para calcular su puntuacion.

> Para Fuego --> Puntaje = Daño*DuracionQuemadura
>
> Para Tierra --> Puntaje = (Daño*MejoraDefensa)/2
> 
> Para Planta --> Puntaje = Daño + (DuracionStun * CantPlanta)
> 
> Para Agua --> Puntaje = (Daño+CantidadHeal+PresionDeAgua)*2

- Calcular Mejor Mago
>La puntuacion de cada mago se calcula sumando las puntuaciones de cada hechizo que domina.

- Menu de Administrador
> Se deben ver reflejados los cambios efectuados, en sus respectivos txt.

Se nos permite el uso de ciertas librerias tales como:

```
Scanner
BufferedWriter
ArrayList
LinkedList 
```

## Estructura del Proyecto

### Paquetes
Posee 2 paquetes, "Logica" y "Dominio"

### Clases
1. Logica
  - App: Clase la la cual inicia el programa y envia las ordenes al sistema
  - SistemaImpl: Clase que contiene toda creacion o manejo de objetos (Hechizos y Magos) del proyecto
2. Dominio:
  - Hechizos: Clase que permite la creacion de los objetos y la herencia de estos mismos.
  - Agua: Clase que contiene todo lo que necesita los hechizos de agua.
  - Fuego: Clase que contiene todo lo que necesita los hechizos de fuego.
  - Planta: Clase que contiene todo lo que necesita los hechizos de planta.
  - Tierra: Clase que contiene todo lo que necesita los hechizos de tierra.
  - Magos: Clase que contiene lo necesario para que un mago sea unico y pueda crearse.

### Interfases
1. Logica
  - Sistema: Le da a la clase SistemaImpl las funciones que si o si tiene que implementar para que la app pueda llamarlas.
2. Dominio
  - Hechizos: Le da a la clase hechizo la capacidad de tener ciertas funciones que debe implementar si o si.

## Instrucciones de Ejecucion
Para poder usarlo puede elegir el menu que prefiera de primera mano y empezar a armar o verificar lo que guste.

