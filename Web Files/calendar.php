<article id="calendar">
  <?php
  // Variable Declaration
  $days = [
    'LUN',
    'MAR',
    'MIÉ',
    'JUE',
    'VIE',
    'SÁB',
    'DOM'
  ];
  ?>


  <header id="calendar-header">

    <?php for ($dayNumber = 0; $dayNumber < count($days); $dayNumber++) { ?>
      <div>
        <p> <?php echo $days[$dayNumber]; ?> </p>
        <p> <?php echo $dayNumber+1; ?> </p>
      </div>
    <?php } ?>

  </header>
  <div id="calendar-hours">
    <?php
    for ($dayNumber = 0; $dayNumber < count($days); $dayNumber++) {
      include('day.php');
    }
    ?>

  </div>

</article>