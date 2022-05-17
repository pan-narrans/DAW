# Creación y manejo de excepciones

- [Creación y manejo de excepciones](#creación-y-manejo-de-excepciones)
  - [Try / Catch / Finally: Manejo de excepciones](#try--catch--finally-manejo-de-excepciones)
  - [Crear una nueva excepción](#crear-una-nueva-excepción)
    - [Con una clase externa](#con-una-clase-externa)
    - [Sobre la marcha](#sobre-la-marcha)

El control de excepciones nos permite controlar que hace nuestro programa cuando sucede un problema que imposibilita su ejecución normal.

En vez de romperse y parar la ejecución, podemos decirle que no todo es tan horrible en esta vida y que siempre se puede salir adelante.

![metáfora](/Java/img/a-bugs-life-leaf-scene.PNG)

## Try / Catch / Finally: Manejo de excepciones

- Dentro del `try` metemos el código susceptible de romperse.
- En el `catch` es donde caemos si se rompen las cosas y donde vamos a intentar limpiar y que parezca que no ha pasado nada.
- El `finally` se ejecuta siempre. Si o si.

```java
try {
  int x = 1 / 0;
} catch (Exception e) {
  System.out.println(e);
} finally{
  System.out.println("Esto se ejecuta siempre");
}
```

Output:

```cmd
java.lang.ArithmeticException: / by zero
Esto se ejecuta siempre
```

## Crear una nueva excepción

### Con una clase externa

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

### Sobre la marcha

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