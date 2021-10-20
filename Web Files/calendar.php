<article id="calendar">
  <?php
  // Variable Declaration
  $days = [
    'LUNES',
    'MARTES',
    'MIERCOLES',
    'JUEVES',
    'VIERNES',
    'SABADO',
    'DOMINGO'
  ];

  ?>
  <?php
  for ($dayNumber = 0; $dayNumber < count($days); $dayNumber++) {
    include('day.php');
  }
  ?>

</article>