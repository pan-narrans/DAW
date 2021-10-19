Algoritmo FactorialDeNumero
	Escribir '¿De qué número quieres saber el factorial?'
	Leer n
	resuldado <- 1
	Si n<0 Entonces
		Escribir 'Has introducido un nº negativo.'
		Escribir 'El factorial calculado será el de su opuesto.'
		Escribir ''
	FinSi
	Para c<-1 Hasta abs(n) Hacer
		resuldado <- resuldado*c
	FinPara
	Escribir 'El factorial de ',n,' es: ',resuldado
FinAlgoritmo
