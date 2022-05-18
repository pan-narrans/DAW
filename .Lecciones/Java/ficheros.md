# Ficheros

- [Ficheros](#ficheros)
  - [Manejo de ficheros](#manejo-de-ficheros)
    - [Crear un ficheros](#crear-un-ficheros)
    - [Comprobar que un fichero existe](#comprobar-que-un-fichero-existe)
    - [Comprobar el tamaño de un fichero](#comprobar-el-tamaño-de-un-fichero)
  - [Lectura y escritura en Binario](#lectura-y-escritura-en-binario)
    - [Escribir en Binario](#escribir-en-binario)
      - [Meter un objeto a capón](#meter-un-objeto-a-capón)
      - [Guardar varios datos](#guardar-varios-datos)
    - [Leer en Binario](#leer-en-binario)
      - [Leer el objeto a capón](#leer-el-objeto-a-capón)
      - [Leer poco a poco](#leer-poco-a-poco)
  - [Lectura y escritura en Texto](#lectura-y-escritura-en-texto)
    - [Escribir en texto](#escribir-en-texto)
    - [Leer en texto](#leer-en-texto)

💬 Todos los ejemplos de código que vienen a continuación tienen que estar rodeados por un `try/catch` para el control de [excepciones](/Java/excepciones.md).

## Manejo de ficheros

Para trabajar con ficheros usamos las clases `Files` y `Path`.

### Crear un ficheros

```java
Files.createFile(Path.of("C:\\Users\\user\\Desktop\\ficheros.md"));
```

### Comprobar que un fichero existe

```java
boolean exists = Files.exists(Path.of("C:\\Users\\user\\Desktop\\ficheros.md"));
```

### Comprobar el tamaño de un fichero

```java
int size = Files.size(Path.of("C:\\Users\\user\\Desktop\\ficheros.md"));
```

## Lectura y escritura en Binario

💀 Los objetos que queramos guardar en un fichero binario tienen que heredar de la clase `Serializable`
> Por defecto las clases que vienen con java ya son serializables.

Al trabajar con binario tenemos dos opciones:

- Meter y leer **un único objeto** a capón:
  - elegante
  - sencillo
  - sin complicaciones
- Meter y leer **varios datos** uno detrás de otro:
  - complicado
  - el orden importa en lectura y escritura

### Escribir en Binario

#### Meter un objeto a capón

- `ObjectOutputStream()`
- `FileOutputStream()`

```java
ObjectOutputStream out = null;

out = new ObjectOutputStream(new FileOutputStream(path));
out.writeObject(o);
```

> ObjectOutputStream únicamente puede usarse **una vez por llamada** para guardar **un objecto**. Si queremos guardar dos objetos tendríamos que meterlos dentro de una colección y guardar la colección.

#### Guardar varios datos

- `BufferedOutputStream()`
- `FileOutputStream()`

```java
BufferedOutputStream writer = null;

writer = new BufferedOutputStream(new FileOutputStream(path));
writer.write("Hey, there!\n".getBytes());
writer.write("How are you doing?".getBytes());

writer.close();
```

### Leer en Binario

#### Leer el objeto a capón

- `ObjectInputStream()`
- `FileInputStream()`

```java
Object result = null;
ObjectInputStream in = null;

in = new ObjectInputStream(new FileInputStream(path));
result = in.readObject();
```

#### Leer poco a poco

- `BufferedInputStream()`
- `FileInputStream()`

```java
int ch;
BufferedInputStream reader = null;

reader = new BufferedInputStream(new FileInputStream(path));
while ((ch = reader.read()) != -1) {
    System.out.print((char) ch);
}

reader.close();
```

## Lectura y escritura en Texto

Al trabajar con ficheros de texto tenemos que tener mucho cuidado con cómo guardamos los datos para luego poder reconstruirlos mientras los leemos.

### Escribir en texto

- `BufferedWriter()`
- `FileWriter()`

```java
Person p1 = new Person(10, 100);
BufferedWriter writer = null;

writer = new BufferedWriter(new FileWriter("text.txt"));
writer.write(p1.getAge() + "," + p1.getHeight());
```

### Leer en texto

- `BufferedReader()`
- `FileReader()`

```java
BufferedReader reader = null;
String line = null;
Person readPerson = null;

reader = new BufferedReader(new FileReader("text.txt"));
line = reader.readLine();
readPerson = new Person(Integer.parseInt(string.split(",")[0]),
                        Integer.parseInt(string.split(",")[1]));
```

Como yo sé (🐵 <- yo) que he guardado una única persona, que la persona tiene dos campos y que los campos los he separado con ',' pues puedo reconstruir el objeto leyendo la línea y separando la string en la ','.

Cuanto más complejo sea lo que hemos guardado dentro más se enmierda esto. Proceder con cuidado.
