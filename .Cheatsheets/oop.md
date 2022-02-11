
    Programación Orientada a Objetos:

- [Conceptos](#conceptos)
  - [Herencia](#herencia)
  - [Polimorfismo](#polimorfismo)
  - [Interfaz](#interfaz)
- [Otros](#otros)
  - [Sobrecarga](#sobrecarga)

# Conceptos 

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

# Otros
## Sobrecarga