/* Calcula la suma de los dígitos de un número. */
function sumaDigitos() {
  const num = parseInt(prompt("Introduce un número"));
  let aux = num;
  let suma = 0;

  while (aux > 0) {
    suma += aux % 10;
    aux = parseInt(aux / 10);
  }

  console.log("La suma de los dígitos de " + num + " es: " + suma);
}

/* Solicitar nombres por teclado, transformarlos a mayúsculas y meterlos dentro de un array.
Ordenar el array en orden alfabético.
¿Cuantas palabras empiezan por vocal?
Introduce '0' para salir. */
function nombres() {
  let nombre = "";
  let nombres = [];
  let vocales = 0;

  while (nombre != "0") {
    nombre = prompt("Introduce un nombre:\n(Introduce 0 para salir)");
    nombres.push(nombre.toUpperCase());
  }

  // Ordenar el array
  nombres.sort();
  nombres.forEach(element => console.log(element));

  // ¿Cuantos empiezan por vocal?
  nombres.forEach(element => {
    if (element.charAt(0).match(/[aeiouAEIOU]/)) 
      vocales++;
    }
  );
  console.log("El número de palabras que empiezan por vocal es: " + vocales);
}

/* Lee una cantidad de dinero múltiplo de 5 y desglosa el cambio en billetes 500 a 5, intentando dar el menor número de billetes posible. */
function calcularCambio() {
  const valorBilletes = [ 500, 200, 100, 50, 20, 10, 5 ];
  const billetes = [];
  let cantidadInicial = parseInt(prompt("Introduce una cantidad de dinero, múltiplo de 5"));
  let cantidad;
  //const billetesMap = Map(cantidad, valor)

  // Check múltiplo de 5
  if (cantidadInicial % 5 !== 0) {
    console.log("¡La cantidad introducida: " + cantidadInicial + " no es múltiplo de 5!");
    cantidadInicial += 5 - (cantidadInicial % 5);
    console.log("Para el ejercicio vamos a usar la siguiente cantidad: " + cantidadInicial);
  }

  // Calcular número de billetes
  cantidad = cantidadInicial;
  for (let i = 0; i < valorBilletes.length; i++) {
    let aux = 0;
    while (cantidad >= valorBilletes[i]) {
      cantidad -= valorBilletes[i];
      aux++;
    }
    billetes.push(aux);
  }

  // Imprimir billetes
  for (let i = 0; i < valorBilletes.length; i++) {
    if (billetes[i] !== 0) 
      console.log(billetes[i] + " billetes de " + valorBilletes[i] + "€");
    }
  }

/* Cambiar todas las letras de una cadena por la posición que ocupan en el alfabeto.
A -> 01
B -> 02
ect... */
function codificarCadena() {
  const cadena = prompt("Introduce una cadena");
  const letras = [ " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" ];
  let codificada = "";

  // Codificar cadena
  cadena.toUpperCase().replace(/\s+\g/).split("").forEach(element => {
    let valor = parseInt(letras.indexOf(element));
    if (valor < 1) 
      codificada += element;
    else if (valor < 10) 
      codificada += "0" + valor;
    else 
      codificada += valor;
    }
  );

  // Imprimir las cadenas
  console.log("La cadena original es:\n " + cadena);
  console.log("La cadena codificada es:\n " + codificada);
}

/*
La clave tiene que:
  - tener entre 8 y 10 caracteres.
  - contener al menos un número.
*/
function clave() {
  const clave = prompt("Introduce una clave:");
  let valida = true;

  // Comprobar tamaño
  if (clave.length < 7 || clave.length > 10) {
    valida = false;
    console.log("La clave no tiene el tamaño adecuado.")
  }
  
  // Comprobar números
  if (clave.search(/[0-9]/).length === 0) {
    valida = false;
    console.log("La clave no contiene el número mínimo de dígitos.")
  }
  
  // Imprimir
  console.log(clave);
  if (valida) 
    console.log("Ha introducido usted la clave.");
  else 
    console.log("La clave introducida no es correcta.\nRecuerde que debe de tener entre 8 y 10 caracteres y contener por lo menos un número.");
  }
