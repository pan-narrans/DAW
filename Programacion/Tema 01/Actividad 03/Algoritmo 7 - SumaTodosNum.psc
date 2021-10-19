Algoritmo SumaTodosNum
	Escribir 'Introduce un número'
	Leer a
	suma <- 0
	aux <- 0
	Mientras aux<=a Hacer
		suma <- suma+aux
		aux <- aux+1
	FinMientras
	Escribir 'La suma de todos los números desde el 0 hasta ',a,' es: ',suma,'.'
FinAlgoritmo
