Algoritmo PintarEstrellas
	estrella <- ' *'
	estrellas <- ''
	Escribir '�C�mo de grande quieres que sea el triangulo de estrellas?'
	Leer n
	Para c<-1 Hasta abs(n) Hacer
		estrellas <- Concatenar(estrellas,estrella)
		Escribir estrellas
	FinPara
FinAlgoritmo
