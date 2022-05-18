# Comparator & comparable

- [Comparator & comparable](#comparator--comparable)
  - [Comparable](#comparable)
  - [Comparator](#comparator)
    - [Clase Externa](#clase-externa)
    - [Clase Anónima](#clase-anónima)
    - [Lambda](#lambda)

> 💬 Una clase es **comparable** si se compara ella misma con otra, un **comparator** compara dos objetos entre sí.

## Comparable

Una clase que implementa la interfaz `Comparable` del tipo deseado tiene que hacer un override del método `compareTo(Object other)`.

Esto permite comparar *el objeto con otro* en base al criterio implementado. En este ejemplo comparamos por edad en orden ascendente (de menor a mayor).

Clase `Persona` que implementa `Comparable`:

```java
public class Person implements Comparable<Person> {

  int age;
  int height;

  public Person(int age, int height) {
    this.age = age;
    this.height = height;
  }

  @Override
  public int compareTo(Person o) {
    return this.age - o.age;  // Compares by age
  }

  @Override
  public String toString() {
    return "Person [age=" + age + ", height=" + height + "]";
  }

}
```

Main:

```java
 public static void main(String[] args) throws Exception { 
  List<Person> list = new ArrayList<Person>();

  // Populate the list
  for (int i = 0; i < 5; i++) {
    int age = (int) (Math.random() * 100);
    int height = (int) (Math.random() * 1000) + 1000;
    Person person = new Person(age, height);

    list.add(person);
  }

  Collections.sort(list);
  list.forEach(System.out::println);
}
```

Output:

```cmd
Person [age=6, height=1250]
Person [age=12, height=1039]
Person [age=50, height=1638]
Person [age=82, height=1869]
Person [age=97, height=1716]
```

## Comparator

> Vamos a seguir usando la clase `Persona` del ejemplo anterior.

Una clase que implementa la interfaz `Comparable` del tipo deseado tiene que hacer un override del método `compare(Object o1, Object o2)`.

Tenemos principalmente tres opciones de implementación:

- **Clase Externa**:
  - La implementación se realiza en una clase externa a la cual pide la ordenación.
  - Tiene la ventaja de que se puede llamar desde varias clases a lo largo del código. Es muy reutilizable.
- **Clase Anónima**:
  - Se implementa dentro de una variable.
  - Permite su reutilización dentro de la clase que contiene la variable.
  - Se comporta como una variable normal (se le aplican las normas de scope).
- **Lambda**:
  - Se declara el comparator bajo forma de lambda.
  - Ocupa nada y menos.
  - No se puede reutilizar.

Podemos usar dos `Comparator`s a la vez así:

```java
Collections.sort(list, byAge.thenComparing(byHeight));
```

De esta forma, si el primer comparador encuentra dos items iguales, estos se ordenarán en base al segundo.

### Clase Externa

```java
public class PersonComparator implements Comparator<Person> {
  @Override
    public int compare(Person o1, Person o2) {
      return o1.getAge() - o2.getAge();
  }
}
```

```java
Collections.sort(list, new PersonComparator());
```

### Clase Anónima

Se codifican igual que si estuviéramos haciendo una clase externa.

```java
// Comparator n1
Comparator<Person> byAge = new Comparator<Person>() {
  @Override
  public int compare(Person p1, Person p2) {
    return p1.getAge() - p2.getAge();
  }
};

// Comparator n2
Comparator<Person> byHeight = new Comparator<Person>() {
  @Override
  public int compare(Person p1, Person p2) {
    return p1.getHeight() - p2.getHeight();
  }
};

// Using both comparators
Collections.sort(list, byAge.thenComparing(byHeight));
```

### Lambda

Se declaran en el momento y no podemos reutilizarlos.

```java
// Sort by Age
Collections.sort(list, (p1, p2) -> {
  return p1.getAge() - p2.getAge();
});
```

```java
// Sort by Height
Collections.sort(list, (p1, p2) -> {
  return p1.getHeight() - p2.getHeight();
});
```
