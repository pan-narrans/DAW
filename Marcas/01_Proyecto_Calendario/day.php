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
    ?>
      <section class="hour">
        <div>
          <?php echo $hour + " -"; ?>
        </div>
        <div> day event of smt </div>
      </section>
    <?php } ?>
  </div>

</section>