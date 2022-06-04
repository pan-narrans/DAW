/* Ejercicios propuestos
Escribir programas JavaScript que realicen las siguientes acciones utilizando
exclusivamente las palabras reservadas y los tipos de datos del lenguaje. */

// ============
// Booleanos
// ============
/* 1. Solicite un dato, analice si se trata de un valor booleano, numérico o cadena de
caracteres muestre su valor de verdad */
function tipoDato() {
  const dato = prompt("Introduce un dato");
  let resultado;

  if (dato === "true" || dato === "false") {
    resultado = "El dato es un valor booleano";
  } else if (isNaN(dato)) {
    resultado = "El dato es una cadena de caracteres";
  } else {
    resultado = "El dato es un número";
  }

  console.log(resultado);
}

/* 2. Muestre las tablas de verdad de los conectores lógicos: negación, conjunción,
disyunción, implicación, bicondicional, disyunción exclusiva y negación de la
disyunción exclusiva */

// ============
// Números
// ============

// 1. Solicite dos números y muestre su suma
function suma() {
  const num1 = parseInt(prompt("Introduce el primer número"));
  const num2 = parseInt(prompt("Introduce el segundo número"));
  let resultado = num1 + num2;
  console.log(resultado);
}

// 2. Solicite dos números y muestre el mayor de ellos
function mayor() {
  const num1 = parseInt(prompt("Introduce el primer número"));
  const num2 = parseInt(prompt("Introduce el segundo número"));
  let resultado;

  console.log(
    num1 > num2
    ? num1
    : num2);
}

// 3. Solicite un número y lo divida por 2, por 4 y por 8
function division() {
  const num = parseInt(prompt("Introduce un número"));
  let resultado;

  resultado = num / 2;
  console.log(num + " / 2 = " + resultado);

  resultado = num / 4;
  console.log(num + " / 4 = " + resultado);

  resultado = num / 8;
  console.log(num + " / 8 = " + resultado);
}

// 4. Solicite un número e indique si es par o impar
function par() {
  const num = parseInt(prompt("Introduce un número"));
  console.log(
    num % 2 === 0
    ? "El número es par"
    : "El número es impar");
}

// 5. Solicite un número y muestre una cuenta atrás
function cuentaAtras() {
  let num = parseInt(prompt("Introduce un número"));
  do {
    console.log(num);
    num--;
  } while (num >= 0);
}

// 6. Solicite tres números y muestre el menor de ellos. Realizar el mismo ejercicio para números y mostrar el mayor
function menor() {
  const num1 = parseInt(prompt("Introduce el primer número"));
  const num2 = parseInt(prompt("Introduce el segundo número"));
  const num3 = parseInt(prompt("Introduce el tercer número"));
  let min = num1;

  min = num2 < min
    ? num2
    : min;

  min = num3 < min
    ? num3
    : min;

  console.log(min);
}

// 7. Solicite tres números y muestre el central, si no hay uno central, debe advertirlo.
function central() {
  prompt("Introduce el primer número");
  const num2 = parseInt(prompt("Introduce el segundo número"));
  prompt("Introduce el tercer número");
  console.log(num2);
}

// 8. Solicite cuatro números y los muestre en orden
function fourNumbers() {
  const numbers = [];
  numbers.push(parseInt(prompt("Introduce el primer número")));
  numbers.push(parseInt(prompt("Introduce el segundo número")));
  numbers.push(parseInt(prompt("Introduce el tercer número")));
  numbers.push(parseInt(prompt("Introduce el cuarto número")));

  numbers.sort((a, b) => a - b);

  console.log(numbers);
}

// 9. Solicite números al usuario y calcule la media aritmética de todos ellos. Para terminar de introducir números, el usuario introducirá un número negativo. Realizar el mismo ejercicio para las medias armónica, cuadrática y geométrica
function media() {
  let num = parseInt(prompt("Introduce un número"));
  let sum = 0;
  let count = 0;

  while (num >= 0) {
    sum += num;
    count++;
    num = parseInt(prompt("Introduce un número"));
  }

  console.log("La media aritmética es " + sum / count);
}

// 10. Solicite números enteros al usuario. Para terminar de introducir números, el usuario introducirá el cero. A continuación se mostrará un sencillo histograma: El número de positivos y el número de negativos usando asteriscos (uno para cada ocurrencia)
function histograma() {
  let num = parseInt(prompt("Introduce un número"));
  let countPos = "";
  let countNeg = "";

  while (num !== 0) {
    if (num > 0) {
      countPos += "*";
    } else {
      countNeg += "*";
    }
    num = parseInt(prompt("Introduce un número"));
  }

  console.log("Positivos: " + countPos);
  console.log("Negativos: " + countNeg);
}

// 11. Solicite la estatura y el peso del usuario y, basándose en el cálculo de su IMC le informe de su estado nutricional
function imc() {
  const estatura = parseFloat(prompt("Introduce tu estatura"));
  const peso = parseFloat(prompt("Introduce tu peso"));
  const imc = peso / (estatura * estatura);

  let mensaje = "";

  if (imc < 18.5) {
    mensaje = "Peso bajo";
  } else if (imc >= 18.5 && imc < 25) {
    mensaje = "Peso normal";
  } else if (imc >= 25 && imc < 30) {
    mensaje = "Sobrepeso";
  } else if (imc >= 30 && imc < 35) {
    mensaje = "Obesidad grado 1";
  } else if (imc >= 35 && imc < 40) {
    mensaje = "Obesidad grado 2";
  } else if (imc >= 40) {
    mensaje = "Obesidad grado 3";
  }

  console.log("Tu IMC es " + imc + " y tu estado es " + mensaje);
}

// 12. Solicite un número al usuario y muestre la suma de todos los números naturales desde el 1 hasta el número introducido
function sumaNaturales() {
  const num = parseInt(prompt("Introduce un número"));
  let sum = 0;

  for (let i = 1; i <= num; i++) {
    sum += i;
  }

  console.log("La suma de los números naturales desde 1 hasta " + num + " es " + sum);
}

// 13. Solicite dos números al usuario y muestre la suma de todos los números naturales entre ellos incluyendo ambos.
function sumaNaturales2() {
  const num1 = parseInt(prompt("Introduce el primer número"));
  const num2 = parseInt(prompt("Introduce el segundo número"));
  let sum = 0;

  for (let i = num1; i <= num2; i++) {
    sum += i;
  }

  console.log("La suma de los números naturales entre " + num1 + " y " + num2 + " es " + sum);
}

// 14. Solicite una hora del día al usuario entre las 0 y las 11 y un número de horas. Se mostrará que hora indicará el reloj pasadas ese número de horas
function reloj() {
  const hora = parseInt(prompt("Introduce una hora del día"));
  const horas = parseInt(prompt("Introduce el número de horas"));
  let horaFinal = hora + horas;

  console.log("Dentro de " + horas + " horas serán las  " + (
  horaFinal % 12));
}

// 15. Solicite un número al usuario y muestre todos sus múltiplos del 0 al 100
function multiples() {
  const num = parseInt(prompt("Introduce un número"));
  let array = [];

  for (let i = 0; i <= 100; i++) {
    if (i % num === 0) {
      array.push(i);
    }
  }

  array.forEach(element => console.log(element));
}

// 16. Solicite un número y muestre el número de dígitos que lo forman
function mostrarDigitos() {
  const num = parseInt(prompt("Introduce un número"));
  let aux = num;
  let digits = [];

  while (aux !== 0) {
    digits.push(aux % 10);
    aux = Math.floor(aux / 10);
  }

  console.log("El número " + num + " está compuesto por: " + digits.length + " dígitos");
  digits.reverse().forEach(element => console.log(element));
}

// 17. Solicite un número y muestre sus dígitos invertidos
// 18. Solicite un importe e indique el importe con IVA
// 19. Solicite un importe con IVA y lo indique sin IVA
// 20. Solicite un año e indique si es bisiesto o no
// 21. Solicite duraciones de tramos de viaje en minutos (hasta que se introduzca un cero o un valor negativo) y muestre la duración del viaje en horas y minutos
// 22. Solicite un número y muestre su parte decimal
// 23. Solicite un número y muestre su parte entera
// 24. Solicite dos números y calcule su división indicando si ésta es exacta o no
// 25. Solicite una base y un exponente y calcule la potencia
// 26. Solicite un número al usuario y muestre todas las potencias de dos desde la 0-ésima hasta la ingresada por el usuario
// 27. Solicite un número y muestre su factorial
// 28. Solicite dos números y muestre su coeficiente binomial
// 29. Calcule el número de puntos que suman las fichas del juego del dominó
// 30. Muestre las distintas combinaciones al lanzar dos dados
// 31. Solicite un número y muestre el numero de combinaciones que existen para obtener ese número lanzando dos dados y sumando sus puntuaciones
// 32. Solicite un número en base decimal y lo muestre en binario, octal y hexadecimal
// 33. Solicite un número y muestre la parte entera de su raíz cuadrada
// 34. Solicite un número y muestre todos sus divisores
// 35. Solicite dos números e indique sus divisores comunes
// 36. Juegue al Fizz buzz
// 37. Solicite un número e indique si es primo o no
// 38. Solicite dos números y muestre su máximo común divisor
// 39. Solicite un número y lo descomponga en factores primos
// 40. Solicite un número y calcule la suma de sus dígitos
// 41. Muestre la tabla de multiplicar
// 42. Implemente una sencilla calculadora, en la que se solicite el primer operando, un operador aritmético y el segundo operando para mostrar a continuación el resultado
// 43. Solicite números entre 0 y 998 hasta que el usuario introduzca el 999, en ese momento muestra la suma de todos ellos (menos el 999)
// 44. Solicite un número de segundos y muestre este dato en horas, minutos y segundos
// 45. Solicite tres números al usuario e indique si forman los lados de un triángulo y en caso afirmativo qué tipo de triángulo
// 46. Solicite números al usuario y muestre cuantos números mayores que cero se han introducido y la suma de todos ellos. Para terminar, el usuario introducirá el cero
// 47. Calcule el número de años que deben transcurrir para que la suma de las edades de tres hijos de 14, 12 y 9 años sea igual a la edad de su padre que ahora tiene 43 años
// 48. Solicite las dimensiones de una matriz, y muestre únicamente aquéllas posiciones cuyas coordenadas sean, ambas, impares
// 49. Solicite al usuario un PIN (número de cuatro dígitos) y le ofrezca tres oportunidades para introducir el mismo que uno elegido por el desarrollador
// 50. Solicite el número de horas que se ha trabajado y el número de horas extra y calcule la nómina semanal bruta. La hora normal se paga a 10€ y la extra a 15€
// 51. Solicite la edad de un padre y la de su hijo y muestre el número de años que deben transcurrir hasta que la edad del padre doble a la del hijo
// 52. Solicite un número y muestre el triángulo de Pascal de altura igual al número introducido
// 53. Solicite los coeficientes de una ecuación de primer grado y muestre su solución
// 54. Solicite los coeficientes de una ecuación de segundo grado y muestre su solución
// 55. Solicite al usuario las coordenadas del centro y el radio de dos circunferencias e indique si se cortan o no y en cuantos puntos
// 56. Solicite números al usuario entre el 1 y el 100 hasta que se averigüe el que ha elegido el desarrollador. Para ayudar al usuario, cada vez que éste introduzca un número, se le indicará si el número a averiguar es mayor o menor que el número introducido. Intercambiar los papeles y que sea ahora el usuario el que elije un número y el programa tratará de adivinarlo
// 57. Solicite un número y muestre los dígitos de todos los números desde el 0 hasta el solicitado en columnas, por ejemplo, para el número 26:
// 000000000011111111112222222
// 012345678901234567890123456

// ============
// Cadenas
// ============
// 1. Solicite el nombre del usuario y le dé las buenas tardes.
function saludar() {
  let nombre = prompt("Introduce tu nombre");
  alert("Buenas tardes " + nombre);
}

// 2. Muestre los días de la semana (uno por línea)
function diasSemana() {
  let days = [
    "Lunes",
    "Martes",
    "Miércoles",
    "Jueves",
    "Viernes",
    "Sábado",
    "Domingo"
  ];

  days.forEach(element => console.log(element + "\n"));
}

// 3. Solicite un carácter e indique si se trata de una letra, de un número o de otro tipo de carácter
function tipoCaracter() {
  let char = prompt("Introduce un carácter");
  if (char.match(/[a-z]/i)) {
    alert("Es una letra");
  } else if (char.match(/[0-9]/i)) {
    alert("Es un número");
  } else {
    alert("Es otro tipo de carácter");
  }
}

// 4. Solicite dos palabras e indique cuál de las dos es más larga y por cuantos caracteres lo es.
function palabraMasLarga() {
  let palabra1 = prompt("Introduce la primera palabra");
  let palabra2 = prompt("Introduce la segunda palabra");
  let diferencia = palabra1.length - palabra2.length;

  if (diferencia > 0) {
    alert("La primera palabra es más larga que la segunda por " + Math.abs(diferencia));
  } else if (diferencia < 0) {
    alert("La segunda palabra es más larga que la primera por " + Math.abs(diferencia));
  } else {
    alert("Las palabras son de igual longitud");
  }
}

// 5. Solicite un número de palabras. A continuación se pedirá al usuario que las introduzca. Para terminar se mostrará la palabra más corta y la más larga
function palabras() {
  let numeroPalabras = prompt("Introduce el número de palabras");
  let palabras = [];

  for (let i = 0; i < numeroPalabras; i++) {
    palabras.push(prompt("Introduce la palabra " + (
    i + 1)));
  }

  palabras.sort((a, b) => a.length - b.length);

  console.log("La palabra más corta es: " + palabras[0] + ".");
  console.log("La palabra más larga es: " + palabras[palabras.length - 1] + ".");
}

// 6. Solicite una cadena de caracteres e indique si es un palíndromo o no.
// Do geese see God?
function palindromo() {
  let cadena = prompt("Introduce una cadena de caracteres");

  cadena = cadena.replace(/\s+/g, "").toLowerCase();

  console.log(
    cadena == cadena.split("").reverse().join("")
    ? "Es un palíndromo."
    : "No es un palíndromo.");
}

// 7. Solicite una cadena de caracteres y elimine los espacios innecesarios,es decir, elimine todos los espacios al comienzo y al final de la cadena y mantenga un único espacio entre dos palabras
function trimSpaces() {
  let cadena = prompt("Introduce una cadena de caracteres");
  cadena.trim();
  // cadena = cadena.replace(/[" "]+/g, " ");
  cadena = cadena.replace(/\s+/g, " ");
  console.log(cadena);
}

// 8. Solicite al usuario un número y muestre una pirámide de asteriscos cuya base contenga un número de asteriscos igual al número introducido por el usuario

function piramide(num) {
  let asteriscos = "";
  let pirámide = [""];

  for (let i = 0; i < num; i++) {
    asteriscos += "*";
    pirámide.push(asteriscos);
  }

  return pirámide;
}

function piramideN1() {
  const num = parseInt(prompt("Introduce el tamaño de la base de la pirámide."));
  let pirámide = piramide(num);

  pirámide.forEach(element => console.log(element));
}

/* 9. Solicite un número al usuario y muestre una plantilla similar a la siguiente (para el
número 7)
*
**
***
****
*****
******
******* */
function piramideN2() {
  const num = parseInt(prompt("Introduce el tamaño de la base de la pirámide."));
  let pirámide = piramide(num);

  pirámide.reverse().forEach(element => console.log(element));
}

/* 10. Solicite un número al usuario y muestre una plantilla similar a la siguiente (para el
número 7). Tener en cuenta los espacios de la izquierda
1******
12*****
123****
1234***
12345**
123456*
1234567 */
function piramideN3() {
  const num = parseInt(prompt("Introduce el tamaño de la base de la pirámide."));
  let pirámide = piramide(num - 1);
  let cifra = "1";
  let i = 2;

  pirámide.reverse().forEach(element => {
    console.log(cifra + element);
    cifra += i++;
  });
}

/* 11. Solicite un número impar usuario y muestre una plantilla similar a la siguiente (para
el número 9)
*
***
*****
*******
*********
*********
*******
*****
***
* */
function piramideN4() {
  const num = parseInt(prompt("Introduce el tamaño de la base de la pirámide."));
  let pirámide = piramide(num);

  pirámide.forEach(element => console.log(element));
  pirámide.reverse().forEach(element => console.log(element));
}

/*
12. Solicite un número al usuario y dibuje un hexágono del lado indicado, por ejemplo
para el número 4:
****
******
********
**********
********
******
****

      ********
    ************
  ****************
********************
  ****************
    ************
      ********
*/
function hexagon() {
  const lado = parseInt(prompt("Introduce el tamaño del lado del hexágono."));
  const niveles = lado * 2 - 1;
  let hexagon = "";
}

/* 13. Solicite una cadena de caracteres e indique si contiene únicamente mayúsculas,
únicamente minúsculas, únicamente números o únicamente otros caracteres
distintos a los mencionados
14. Solicite al usuario una cadena de caracteres. Si el último carácter de ésta es una
letra, lo considerará un NIF y le indicará al usuario que tipo de NIF es o si éste es
inválido. En caso contrario, si es posible, calculará la letra de control y lo mostrará al
usuario
15. Solicite al usuario una cadena de caracteres e indique si se trata de un pangrama
16. Solicite al usuario dos números y una letra: "i” ó "p” (en mayúsculas o minúsculas).
La página mostrará los números pares (si se pulsó la "p”) ó impares (si se pulsó la
"i”) que hay desde un número al otro de los que introdujo el usuario
17. Solicite una cadena y la codifique letra a letra siguiendo el orden alfabético: A->01,
B->02, C->03, etc.
18. Permita que dos personas jueguen a piedra, papel, tijera. Se solicitará el número de
rondas que un jugador debe ganar para ganar el juego. En cada ronda se mostrará
la puntuación actual
19. Solicite una dirección MAC-48, la valide y si es correcta la convierta en una dirección
IPv6 de enlace local
20. Solicite una cadena y la cifre utilizando el método ROT13
21. Solicite una cadena y la codifique utilizando el método Base64
22. Solicite una cadena y la codifique utilizando el método RLE
23. Solicite una talla de ropa e indique su tamaño según la siguiente tabla
XXL, XL, L Grande
M Mediana
XS, S Pequeña
https://www.codewars.com/collections/ut02-sintaxis-del-lenguaje-javascript */
