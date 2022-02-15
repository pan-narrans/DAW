
    Programación Orientada a Objetos:
    @author: Alejandro Pérez

- [Semántica:](#semántica)
  - [Herencia](#herencia)
  - [Polimorfismo](#polimorfismo)
  - [Interfaz](#interfaz)
  - [Sobrecarga](#sobrecarga)
- [Modificadores](#modificadores)
  - [Visibilidad](#visibilidad)
  - [`static`](#static)
  - [`super`](#super)
  - [`this`](#this)
- [Resumen](#resumen)

# Semántica: 

Clase de inicio:
```java
public class Animal {
  protected int nLegs;
  public void talk(){ ; }
}
```

## Herencia
La clase hijo hereda atributos y métodos públicos o protegidos de la clase padre.

> ⚠ Los métodos o atributos privados **NO** se heredan.

Aparte puede añadir atributos y métodos propios.

```java
public class Caballo extends Animal {
  protected String breed; // --> Atributo propio a Caballo() independiente de Animal()
}
```

La clase `Caballo()` hereda de `Animal()` por lo que tiene acceso tanto a `nLegs` como a `talk()` y aparte añade la variable `breed` que es propia a la clase hija.


## Polimorfismo

Permite sobrescribir la funcionalidad de un método de la clase padre.

```java
public class Caballo extends Animal {
  @Overrides
  public void talk(){ System.out.println("neigh"); }
}
```
```java
public class Vaca extends Animal {
  @Overrides
  public void talk(){ System.out.println("moo"); }
}
```

```java
Animal caballo = new Caballo();
Animal vaca = new Vaca();

caballo.talk(); // --> "neigh"
vaca.talk();    // --> "moo"
```


El objeto `Animal caballo = new Caballo()` no tiene acceso a los métodos de la clase Caballo pero al declararlo cómo `new Caballo()` se aplica el polimorfismo.

```java
Animal caballo = new Caballo();

caballo.talk();     // --> "neigh"
caballo.getBreed(); //  --> error, Animal() no tiene breed
```
> El tipo de la variable es el que nos marca las funcionalidades del objeto. Si el tipo es Animal únicamente tendremos acceso a los atributos y métodos de Animal, por mucho que declaremos como Caballo o Vaca.


## Interfaz
Blueprint de un objeto. Únicamente contiene un listado de métodos y no los implementa. **No** contiene atributos.

```java
public interface Jedi {
  public void forcePush();
  public void meditate();
}
```
Al implementar una interfaz tenemos que implementar **todos** los métodos de dicha interfaz.

```java
public class humanoJedi implements Jedi {
  public void forcePush(){    
    System.out.println("fshhhhhh");
  }
  public void meditate(){    
    System.out.println("ommmm...");
  }
}
```

> 💬 Una interfaz es una plantilla de métodos para clases.

## Sobrecarga
Permite declarar un mismo método varias veces con el mismo nombre, pero cambiando sus entrañas. Para hacer esto es necesario que el tipo o número de los parámetros de entrada sea distinto.

> Esto es lo que hacemos al crear varios constructores par una clase (hay ejemplos más abajo).

En vez de declarar dos métodos distintos que hacen básicamente lo mismo:
```java
int plusMethodInt(int x, int y) { return x + y; }
double plusMethodDouble(double x, double y) { return x + y; }
```

Creamos sólo un método y lo sobrecargamos con distintos parámetros:

```java
int plusMethod(int x, int y) { return x + y; }
double plusMethod(double x, double y) { return x + y; }
```

# Modificadores
## Visibilidad 

```java
public class NuevaClase {
  public int publico;       // --> todo el mundo tiene acceso
  protected int protegido;  // --> únicamente la clase y sus hijos
  private int privado;      // --> únicamente la clase
}
```

Los keywords `public`, `protected` y `private` pueden aplicarse a clases, métodos y atributos. Limitan el acceso a los atributos de una clase y los protegen de cambios inesperados.

## `static`

Depende de la clase y no de la instancia, es común a todas las instancias de un objeto. Permite acceder (si la visibilidad lo permite) al atributo o método sin necesidad de instanciar el objeto.

Si modificamos desde un objeto un atributo `static` este se modificará también para todas las otras instancias del objeto. 

> ⚠ **NO ES LO MISMO QUE FINAL** ⚠
> 
> Un atributo estático sigue pudiendo ser modificado.

```java
public class NuevaClase {
  public static String nombre = "Alex";
}
```

```java
public class App {
  public static void main(String[] args){
    System.out.println(NuevaClase.nombre); // --> imprime "Alex"
  }
}
```


## `super`

Permite acceder a los atributos y métodos de la superclase y de distinguirlos de los del objeto.

Es lo mismo que un `this` pero para referenciar a la clase padre/madre.


```java
public class Animal {
  protected int nLegs;
  protected boolean alive;

  Animal(int nLegs){
    this.alive = true; 
    this.nLegs = nLegs; 
  }
}
```
```java
public class Caballo extends Animal {
  protected String name, breed;

  Caballo(String name, String breed){ 
    super(4);            // -> Llama al constructor de Animal()
    this.name = name;
    this.breed = breed;
  }
}
```

En el caso de tener una `override` y sobrescribir métodos de la clase superior, podemos hacer referencia al método original gracias al keyword `super`.

```java
public class Animal {
  public void die() { this.alive = false; }
}
```

```java
public class Caballo extends Animal {
  @Override
  public void die() {
    System.out.println("Has matado al caballo :(");
    this.alive = false;
  }
}
```

```java
public class Caballo {
  public void prueba() { 
    super.die();  // no muestra el mensaje
    this.die();   // te inculpa por la muerte del caballo
  }
}
```

## `this`

Permite diferenciar los atributos de un objeto de las variables locales de sus métodos.

```java
public class Animal {
  protected int nLegs;
  Animal(int nLegs){ this.nLegs = nLegs; }
}
```

> `super` y `this` no son siempre necesarios. 
 
Únicamente los usamos cuando:
- Necesitemos diferenciar de forma explícita los atributos del objeto de otras variables locales.
- Queramos diferenciar entre los métodos o atributos heredados y los sobrescritos en el objeto.

# Resumen

|           Concepto | TLDR                                                                                                                                |
| -----------------: | ----------------------------------------------------------------------------------------------------------------------------------- |
|     **Herencia :** | Heredas las cosas publicas y protegidas de la madre. No las privadas                                                                |
|     **Interfaz :** | Plantilla de métodos (no atributos) para asegurar coherencia entre clases.                                                          |
| **Polimorfismo :** | Sobrescribes funcionalidades de la madre para adaptarlas a la hija.                                                                 |
|   **Sobrecarga :** | Métodos con mismo nombre pero distinta implementación dentro de una clase.                                                          |
|  **Visibilidad :** | - `public` : todo el mundo tiene acceso <br> - `protected` : únicamente la clase y sus hijos <br> - `private` : únicamente la clase |
|      **`super` :** | Hace referencia a elementos de la parte heredada de la instancia.                                                                   |
|       **`this` :** | Hace referencia a elementos de la instancia del objeto.                                                                             |
|     **`static` :** | Se comparte entre todas las instancias y se puede usar sin declarar objetos.                                                        |
