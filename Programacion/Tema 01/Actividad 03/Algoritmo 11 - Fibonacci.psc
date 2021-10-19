Algoritmo Fibonacci
	n <- 0
	aux <- 0
	num1 <- 1
	num2 <- 0
	Escribir 'Cuantos elementos de la sucesión de Fibonacci quieres ver?'
	Leer n
	Para c<-1 Hasta abs(n) Hacer
		aux <- num1
		num1 <- num2
		num2 <- num2+aux
		Escribir num2
	FinPara
FinAlgoritmo
