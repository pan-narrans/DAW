    Montar un form y conectarlo a una BBDD:    
    @author: Alejandro Pérez


- [PHP y SQL:](#php-y-sql)
  - [Crear la base de datos](#crear-la-base-de-datos)
  - [Conectar a la base de datos](#conectar-a-la-base-de-datos)
- [HTML:](#html)
  - [fieldset y legend](#fieldset-y-legend)
  - [input](#input)
  - [enviar formulario](#enviar-formulario)
  - [diferencias entre name y id](#diferencias-entre-name-y-id)
  - [the fuk is label](#the-fuk-is-label)


# PHP y SQL:

> 🐵🐵 **MONKE CONSEJO** 🐵🐵 <BR>
> Recordar sustituir en la url hasta el /httdocs por `localhost`.

~~(ya han sido un par las veces que se me ha olvidado)~~

## Crear la base de datos

```sql
DROP DATABASE IF EXISTS db_name;
CREATE DATABASE db_name CHARACTER SET utf8mb4;
USE db_name;

CREATE TABLE table_name(
  id INT AUTO_INCREMENT PRIMARY KEY,
  var_name_1 VARCHAR(200) NOT NULL,
  var_name_2 VARCHAR(200) NOT NULL,
  var_name_3 VARCHAR(200) NOT NULL,
  var_name_4 VARCHAR(200) NOT NULL,
  var_name_5 VARCHAR(200) NOT NULL,
);
```

## Conectar a la base de datos

```php
// Variables conexión
$server = "localhost";
$user = "root";
$password = "";
$database = "db_name";
$table = "table_name";

// Conectar con el servidor
$link = mysqli_connect($server, $user, $password) or die('No se pudo conectar: ' . mysqli_error($link));
// Conectar con la base de datos
$db = mysqli_select_db($link, $database) or die('No se pudo seleccionar la base de datos');

// Volcamos en variables los campos de nuestro formulario
$var_name_1 = $_POST['var_name_1'];
$var_name_2 = $_POST['var_name_2'];
$var_name_3 = $_POST['var_name_3'];
$var_name_4 = $_POST['var_name_4'];

// Comprobar si un campo del formulario tiene valor o no
$var_name_5 = (isset($_POST['var_name_5'])) ? $_POST['var_name_5'] : "OTHER VALUE";

// Creamos una variable consulta con el comando SQL insert
// Insertando las variables en los campos de la tabla
$consulta = "INSERT INTO $table (var_name_1, var_name_2, var_name_3, var_name_4, var_name_5) 
VALUES ('$var_name_1', '$var_name_2', '$var_name_3', '$var_name_4', '$var_name_5')";

// Visualizar la consulta que se envía al servidor 
echo "----------------------" . $consulta . "--";

// Insertar los datos
mysqli_query($link, $consulta) or die("<h3> Error al insertar en la tabla </h3>");
```

# HTML:
## fieldset y legend
## input
## enviar formulario
## diferencias entre name y id
## the fuk is label