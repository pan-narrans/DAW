# Ficheros

- [Ficheros](#ficheros)
  - [Creación de ficheros](#creación-de-ficheros)
  - [Lectura y escritura en Binario](#lectura-y-escritura-en-binario)
    - [Write binary file - code example](#write-binary-file---code-example)
    - [Read binary File - code example](#read-binary-file---code-example)
  - [Texto](#texto)

## Creación de ficheros

Para trabajar con ficheros usaremos las clases `Files` y `Path`.

```java
Files.createFile(Path.of("C:\\Users\\user\\Desktop\\ficheros.md"));
```

```java
public void createFile(String path) {
  try {

    Files.createFile(Path.of(path));
    System.out.println("File created.");

  } catch (FileAlreadyExistsException e) {

    System.out.println("File already exists.");

  } catch (Exception e) {

    System.out.println("An error occurred.");
  }
}
```

## Lectura y escritura en Binario

For writing:

- `ObjectOutputStream()`
- `FileOutputStream()`

```java
ObjectOutputStream out = null;

out = new ObjectOutputStream(new FileOutputStream(path));
out.writeObject(o);
```

For reading:

- `ObjectInputStream()`
- `FileInputStream()`

```java
Object result = null;
ObjectInputStream in = null;

in = new ObjectInputStream(new FileInputStream(path));
result = in.readObject();
```

We need to surround everything in a try/catch to prevent fatal errors.

### Write binary file - code example

A la hora de escribir en un archivo binario le pasamos a lo bruto el objeto que queremos escribir y listo.

> ❔ Me queda ver si se sobre-escribe o no

```java
public void writeFile(String path, Object o) {
  ObjectOutputStream out = null;

  try {

    out = new ObjectOutputStream(new FileOutputStream(path));
    out.writeObject(o);

  } catch (Exception e) {

    System.out.println("An error occurred.");

  } finally {

    try {
      out.close();
    } catch (IOException e) {
      System.out.println("An error occurred whilst closing the output stream.");
    }

  }
}
```

### Read binary File - code example

Le pedimos que nos devuelva lo guardado dentro del archivo y ya nos preocupamos fuera de castearlo al tipo de dato correcto.

```java
public Object readFile(String path) {
  Object result = null;
  ObjectInputStream in = null;

  try {

    in = new ObjectInputStream(new FileInputStream(path));
    result = in.readObject();

  } catch (Exception e) {

    System.out.println("An error occurred whilst reading the file.");

  } finally {

    try {
      in.close();
    } catch (IOException e) {
      System.out.println("An error occurred whilst closing the input stream.");
    }

  }

  return result;
}
```

## Texto
