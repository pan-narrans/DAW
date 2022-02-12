
    Programación Orientada a Objetos:
    @author: Alejandro Pérez

- [Conceptos Básicos](#conceptos-básicos)
  - [Herencia](#herencia)
  - [Polimorfismo](#polimorfismo)
  - [Interfaz](#interfaz)
- [Otros Conceptos](#otros-conceptos)
  - [Visibilidad](#visibilidad)
  - [`static` wip](#static-wip)
  - [Sobrecarga](#sobrecarga)
  - [`super` WIP](#super-wip)
  - [`this` WIP](#this-wip)
  - [Ejemplo con todo:](#ejemplo-con-todo)
- [Resumen](#resumen)

# Conceptos Básicos

Clase de inicio:
```java
public class Animal(){
  private int nLegs;
  public void talk(){ ; }
}
```

## Herencia
La clase hijo hereda atributos y métodos públicos o protegidos de la clase padre.

> ⚠ Los métodos o atributos privados **NO** se heredan.

Aparte puede añadir atributos y métodos propios.

```java
public class Caballo extends Animal (){
  String breed;
}
```

La clase `Caballo()` hereda de `Animal()` por lo que tiene acceso tanto a `nLegs` como a `talk()` y aparte añade la variable `breed` que es propia a la clase hija.

## Polimorfismo

Permite sobrescribir la funcionalidad de un método de la clase padre.

```java
public class Caballo extends Animal (){
  @Overrides
  public void talk(){ System.out.println("neigh"); }
}
```
```java
public class Vaca extends Animal (){
  @Overrides
  public void talk(){ System.out.println("moo"); }
}
```
> Detalle importante:
> 
> El tipo de la variable es el que nos marca las funcionalidades del objeto.

```java
Animal caballo = new Caballo();
Animal vaca = new Vaca();

caballo.talk(); // --> "neigh"
vaca.talk();    // --> "moo"
```


El objeto `Animal caballo = new Caballo()` no tiene acceso a los métodos de la clase Caballo pero al declararlo cómo `new Caballo()` se aplica el polimorfismo.

```java
Animal caballo = new Caballo();

caballo.getBreed(); //  --> error, Animal() no tiene breed
```

## Interfaz
Blueprint de un objeto. Únicamente contiene un listado de métodos y no los implementa.

```java
public interface Jedi(){
  public void forcePush();
  public void meditate();
}
```
Al implementar una interfaz tenemos que implementar **todos** los métodos de dicha interfaz.

```java
public class humanoJedi implements Jedi(){
  public void forcePush(){    
    System.out.println("fshhhhhh");
  }
  public void meditate(){    
    System.out.println("ommmm...");
  }
}
```


# Otros Conceptos
## Visibilidad 

```java
public class NuevaClase(){
  public int publico;       // --> todo el mundo tiene acceso
  protected int protegido;  // --> únicamente la clase y sus hijos
  private int privado;      // --> únicamente la clase
}
```

Los keywords `public`, `protected` y `private` pueden aplicarse a clases, métodos y atributos. Límitan el acceso a los atributos de una clase y los protegen de cambios inesperados.

## `static` wip

NO ES LO MISMO QUE FINAL

## Sobrecarga
Permite declarar un mismo método varias veces con el mismo nombre, pero cabiando sus entrañas. Para hacer esto es necesario que el tipo o número de los parámetros de entrada sea distinto.

> Esto es lo que hacemos al crear varios constructiores par una clase (hay ejemplos más abajo).

En vez de declarar dos métodos distintos que hacen básicamente lo mismo:
```java
int plusMethodInt(int x, int y) { return x + y; }
double plusMethodDouble(double x, double y) { return x + y; }
```

Creamos sólo un método y lo sobrecargamos con distintos parámentros:

```java
int plusMethod(int x, int y) { return x + y; }
double plusMethod(double x, double y) { return x + y; }
```

## `super` WIP

Permite acceder a los atributos y métodos de la superclase y de distingirlos de los del objeto.

--> hablar de overrides

## `this` WIP

Permite diferenciar los atributos de un objeto de las variables locales de sus métodos.



## Ejemplo con todo:

```java
public class Animal(){
  protected int nLegs;
  protected boolean alive;

  Animal(){ this(0); }   // ->  Constructor por defecto llama al otro constructor
  Animal(int nLegs){     // ->  Constructor con atributos
    this.alive = true; 
    this.nLegs = nLegs; 
  }

  public void revive(){ this.alive = true; }
  public void die(){ this.alive = false; }
}
```

```java
public class Caballo extends Animal{
  protected String name, breed;

  Caballo(){            // ->  Constructor por defecto llama al otro constructor
    this("", "");
  }

  Caballo(String name, String breed){ 
    super(4);           // -> Llama al constructor de Animal()
    this.name = name;   // -> Asigna valor al atributo `name`
    this.breed = breed; // -> Asigna valor al atributo `breed`
  }

  public void loseALeg(){
    super.nLegs--;      // -> Cambia el valor de la variable heredada `nLegs`
}
```

# Resumen

|                      |                                                                                                                                |
| -------------------- | ------------------------------------------------------------------------------------------------------------------------------ |
| **`Herencia`** :     | Heredas las cosas publicas y protegidas de la madre. No las privadas                                                           |
| **`Interfaz`** :     | Plantilla de métodos (no atributos) para asegurar coherencia entre clases.                                                     |
| **`Polimorfismo`** : | Sobreescribes funcionalidades de la madre para adaptarlas a la hija.                                                           |
| **`Sobrecarga`** :   | Métodos con mismo nombre pero distinta implementación dentro de una clase.                                                     |
| **`Visibilidad`** :  | `public` : todo el mundo tiene acceso <br> `protected` : únicamente la clase y sus hijos <br> `private` : únicamente la clase |
| **`super`** :        | Hace referencia a elementos de la parte heredada de la instancia.                                                              |
| **`this`** :         | Hace referencia a elementos de la instancia del objeto.                                                                        |
| **`static`** :       | Se comparte entre todas las instancias y se puede usar sin declarar objetos.                                                   |
