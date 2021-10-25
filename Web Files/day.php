<section class="day">
  <header class="visuallyhidden">
    <h2>
      <?php echo $days[$dayNumber]; ?>
    </h2>
  </header>

  <div class="hours">
    <?php
    $hours = 24;
    for ($hour = 0; $hour <= $hours; $hour++) {
    ?>
      <section class="hour">
        <div>
          <?php echo $hour . " - "; ?>
        </div>
        <div> day event </div>
      </section>
    <?php } ?>
  </div>

</section>