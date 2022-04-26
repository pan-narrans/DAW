function helloWorld() {
  window.alert("Hola mundo!");
}

function mayorQueDiez() {
  // Crear y rellenar el Array
  const numArray = [];
  for (let i = 0; i < 3; i++) {
    numArray.push(prompt());
  }

  // Comprobar los contenidos y avisar
  for (let i = 0; i < numArray.length; i++) {
    if (numArray[i] > 10) {
      window.alert("ALGUNO MAYOR QUE 10");
      return;
    }
  }
  window.alert("NINGUNO MAYOR QUE 10");
}

function esNavidad() {
  const dia = prompt("Introduce el día");
  const mes = prompt("Introduce el mes");

  if (dia == 25 && mes == 12) {
    window.alert("Es navidad");
  } else {
    window.alert("No es navidad");
  }
}

function aumentoDeSuelto() {
  let sueldo = prompt("Introduce tu sueldo");
  const antigüedad = prompt("Introduce tu antigüedad");

  if (sueldo < 500 && antigüedad >= 10) 
    sueldo *= 3;
  else if (sueldo < 500 && antigüedad < 10) 
    sueldo *= 2;
  
  window.alert(sueldo);
}

function calificación() {
  const nota = prompt("Introduce tu nota");
  if (nota < 3) 
    window.alert("Muy Deficiente");
  else if (nota < 5) 
    window.alert("Insuficiente");
  else if (nota < 6) 
    window.alert("Bien");
  else if (nota < 9) 
    window.alert("Notable");
  else 
    window.alert("Sobresaliente");
  }

function salarioNetoSemanal() {
  const horasTrabajadas = prompt("Introduce las horas trabajadas");
  const precioHora = prompt("Introduce el precio de la hora");
  let bruto;
  let neto;

  // Cálculo del bruto
  if (horasTrabajadas > 35) {
    bruto = (horasTrabajadas - 35) * precioHora * 1.5 + 35 * precioHora;
  } else {
    bruto = horasTrabajadas * precioHora;
  }

  // Cálculo del neto
  if (bruto <= 500) {
    neto = bruto;
  } else if (bruto <= 900) {
    neto = 500 + (bruto - 500) * 0.75;
  } else {
    neto = 500 + 400 * 0.75 + (bruto - 900) * 0.55;
  }

  window.alert("El sueldo neto final es de: " + neto + "€");
}

/* Realiza un programa que lea un numero N y muestre por la salida estándar todos los pares desde 2 hasta N (inclusive).
Cada número se mostrará en una línea distinta. N siempre será mayor o igual a 2. */
function pares() {
  const num = prompt("Introduce un número");
  let i = 2;

  do {
    console.log(i);
    i += 2;
  } while (i <= num);
}

function impares() {
  const num = prompt("Introduce un número");
  let i = 1;

  do {
    console.log(i);
    i += 2;
  } while (i <= num);
}

/* Programa que muestre la tabla de multiplicar del numero X, hasta el valor Y.
Ambos los leerá de la entrada estándar y estarán en una sola línea separados por un espacio
La tabla la mostrará con una entrada por línea.
Entre cada elemento habrá un único espacio de separación */
function tablaDeMultiplicar() {
  const numbers = prompt("Introduce el número a multiplicar y el número de veces que lo quieres multiplicar").split(" ");
  let i = 1;

  do {
    console.log(numbers[0] + " x " + i + " = " + numbers[0] * i);
    i++;
  } while (i <= numbers[1]);
}

/*
Realiza un programa que lea una secuencia de notas (con valores que van de 0 a 10, sin decimales).
Se leerá una nota por línea. La entrada acabará con el valor -1. El programa debe mostrar por salida estándar "SI" si hay algún 10, "NO" en caso contrario.
 */
function notas() {
  const notas = [];
  let nota = prompt("Introduce nota");

  while (nota != -1) {
    notas.push(nota);
    nota = prompt("Introduce nota");
  }

  notas.includes("10")
    ? console.log("SI")
    : console.log("NO");
}

/* Realiza un programa que lea una cantidad de dinero (múltiplo de 5) y tras ello desglose el cambio en billetes de 500,200,100,50,20,10,5 intentado dar el mínimo número de billetes.
El programa mostrará por la salida estándar el número mínimo de billetes. */
function cambio() {
  let cambio = prompt("Introduce la cantidad de dinero");
  let billetes = [
    500,
    200,
    100,
    50,
    20,
    10,
    5
  ];
  let i = 0;
  let numBilletes = 0;

  if (cambio % 5 != 0) {
    window.alert("No es múltiplo de 5");
    return;
  }

  while (cambio > 0) {
    if (cambio >= billetes[i]) {
      numBilletes += Math.floor(cambio / billetes[i]);
      cambio = cambio % billetes[i];
    }
    i++;
  }

  console.log(numBilletes);
}

/* Escribe una función que reciba dos enteros y devuelva su suma. La función no debe leer nada de la entrada estándar ni mandar ningún dato por la salida estándar. La función debe definirse con este estilo: function suma(a, b) */
function suma(a, b) {
  return a + b;
}

/* Realiza una función que me devuelva si un número es o no bisiesto. */
function bisiesto(a) {
  return (a % 4 == 0 && a % 100 != 0) || a % 400 == 0;
}

/* Escribe una función que reciba dos decimales con la base y altura de un rectángulo y devuelva su  perímetro. */
function perimetroRectangulo(base, altura) {
  return (2 * (base + altura)).toFixed(2);
}