<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>PHP FORM</title>
</head>

<body>
  <?php
  // Conectar con el servidor
  $link = mysqli_connect("localhost", "root", "") or die('No se pudo conectar: ' . mysqli_error($link));
  // Conectar con la base de datos
  $db = mysqli_select_db($link, "db_name") or die('No se pudo seleccionar la base de datos');

  // Volcamos en variables cada uno de los campos de nuestro formulario
  // $var_name = $_httpmethod['form_var_name']
  $var1 = $_POST['var1'];
  $var2 = $_POST['var2'];
  $var3 = $_POST['var3'];
  $var4 = $_POST['var4'];
  $var5 = $_POST['var5'];
  $var6 = $_POST['var6'];

  // Ejemplo para valor por defecto
  if (isset($_POST['condiciones'])) {
    $condiciones = $_POST['condiciones'];
  } else {
    $condiciones = "NO ACEPTADAS";
  }

  // Creamos una variable con el comando SQL insert
  $consulta = "INSERT INTO formulario (var1, var2, var3, var4, var5, var6) 
    VALUES ('$var1','$var2','$var3','$var4','$var5','$var6')";

  // Si queremos visualizar la consulta que se envía al servidor pondremos: 
  echo "----------------------" . $consulta . "--";

  // Insertar los datos
  mysqli_query($link, $consulta) or die("<h3> Error al insertar en la tabla </h3>");
  ?>
</body>

</html>