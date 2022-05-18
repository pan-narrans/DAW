# Creación y manejo de excepciones

- [Creación y manejo de excepciones](#creación-y-manejo-de-excepciones)
  - [Try / Catch / Finally: Manejo de excepciones](#try--catch--finally-manejo-de-excepciones)
  - [Lanzar excepciones](#lanzar-excepciones)
  - [Crear una nueva excepción](#crear-una-nueva-excepción)

El control de excepciones nos permite decidir qué hace nuestro programa cuando sucede un problema que imposibilita su ejecución normal.

Es decir, en vez de romperse y parar la ejecución, le podemos decirle que no todo es tan horrible en esta vida y que siempre se puede salir adelante.

![metáfora](/Java/img/a-bugs-life-leaf-scene.PNG)

## Try / Catch / Finally: Manejo de excepciones

- **`try {}`**
  - Es donde metemos el código susceptible de romperse.
  - Entre los más comunes están: las operaciones con ficheros, conexión a una base de datos, acceso `out of bounds` a un array, etc...
- **`catch {}`**
  - Es donde caemos si se rompen las cosas.
  - Se suele usar para mostrar el mensaje de error y redirigir a otra parte del código.
  - Podemos tener varios bloques `catch`, uno para cada tipo de excepción que nos interese controlar.
- **`finally {}`**
  - Se ejecuta siempre. Si o si.
  - Se suele utilizar para clean-up, cerrar la conexión a la base de datos, etc...

```java
try {
  int x = 1 / 0;
} catch (ArithmeticException e) {
  System.out.println(e); // Excepción concreta
} catch (Exception e) {
  System.out.println(e); // Excepción genérica
} finally{
  System.out.println("Esto se ejecuta siempre");
}
```

Output:

```cmd
java.lang.ArithmeticException: / by zero
Esto se ejecuta siempre
```

Si tenemos varios `catch` tenemos que ordenarlos de más concreto a más genérico. Cuando una excepción es atrapada por un catch ya no puede serlo por otro.

## Lanzar excepciones

Lanzar una excepción genérica:

```java
try {
  throw new Exception("This is an exception");
} catch (Exception e) {
  System.out.println("Exception caught: " + e.getMessage());
}
```

Result:

```cmd
Exception caught: This is an exception
```

## Crear una nueva excepción

Podemos crear nuevas excepciones como clases externas que hereden de la clase madre `Exception`.
El objetivo principal de crear excepciones personalizadas es dar mensajes de error más certeros y afinar el control de errores con el try/catch.

```java
public class IAmBeingUseful extends Exception {
  public IAmBeingUseful() {
    super();
  }

  public IAmBeingUseful(String message) {
    super(message);
  }
}
```

Tras crear la excepción ya podemos lanzarla desde otra parte del código:

```java
try {
  throw new IAmBeingUseful("I'm being useful");
} catch (IAmBeingUseful e) {
  System.out.println(e);
}
```

Result:

```cmd
excepciones.IAmBeingUseful: I'm being useful
```
