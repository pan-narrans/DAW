Algoritmo FactorialDeNumero
	Escribir '�De qu� n�mero quieres saber el factorial?'
	Leer n
	resuldado <- 1
	Si n<0 Entonces
		Escribir 'Has introducido un n� negativo.'
		Escribir 'El factorial calculado ser� el de su opuesto.'
		Escribir ''
	FinSi
	Para c<-1 Hasta abs(n) Hacer
		resuldado <- resuldado*c
	FinPara
	Escribir 'El factorial de ',n,' es: ',resuldado
FinAlgoritmo
