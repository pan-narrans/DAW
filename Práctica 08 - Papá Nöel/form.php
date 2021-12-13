<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>

<body>
  <?php
  $link = mysqli_connect("localhost", "root", "") or die('No se pudo conectar: ' . mysqli_error($link));
  $db = mysqli_select_db($link, "papanoel") or die('No se pudo seleccionar la base de datos');

  // volcamos en variables cada uno de los campos que queremos almacenar en la base de datos 
  // en nuestro caso POST(‘name de cada uno de los imput del formulario ) 
  $optn1 = $_POST['optn1'];
  $optn2 = $_POST['optn2'];
  $optn3 = $_POST['optn3'];
  $dinero = $_POST['dinero'];
  $color = $_POST['color'];
  $email = $_POST['email'];
  $condiciones = $_POST['condiciones'];
  $consulta = "INSERT INTO formulario (optn1, optn2, optn3, dinero, color, email, condiciones)
  VALUES ('$optn1','$optn2','$optn3','$dinero','$color','$email','$condiciones')";
  // Si queremos visualizar la consulta que se envía al servidor pondremos: 

  echo "----------------------" . $consulta . "--";
  mysqli_query($link, $consulta) or die("<h3> Error al insertar en la tabla </h3>");
  // echo "¡Graciassss! Hemos recibido sus datos.\n";
  ?>
</body>

</html>