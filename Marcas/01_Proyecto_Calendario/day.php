<section class="day">
  <header>
    <h2>
      <?php //$dayName = 'LUNES';
      echo $days[$dayNumber]; ?>
    </h2>
  </header>
  <div class="hours">
    <?php
    $hours = 24;
    for ($hour = 0; $hour <= $hours; $hour++) {
      echo '  <div class="hour">
    <div>';
      echo $hour;
      echo '</div>
    <div> --- </div>
    </div>';
    }
    ?>
  </div>

</section>