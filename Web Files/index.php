<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="styles.css">
  <link rel="stylesheet" href="fonts/icomoon/style.css">
  <title>Title</title>
</head>

<body>

  <header>
    <img src="" alt="logo">
    <span class="icon-home"></span>
    <h2>Name</h2>
  </header>

  <nav>
    <ul>
      <li><a href="#">item 1</a></li>
      <li><a href="#">item 2</a></li>
      <li><a href="#">item 3</a></li>
      <li><a href="#">item 4</a></li>
    </ul>
  </nav>

  <main>
    <section>
      <?php include_once('calendar.php') ?>
    </section>
    <aside>
      <?php //include_once('controlBar.php') ?>
      <p>Próximos eventos >_< </p>
    </aside>
  </main>

  <footer>
    <p>Footer</p>
  </footer>
</body>

</html>