Funcion return <- ComprobarValidez (input)
	// Lista de las tallas admitidas
	Dimension PosiblesTallas[6]
	PosiblesTallas[1] <- 'XXL'
	PosiblesTallas[2] <- 'XL'
	PosiblesTallas[3] <- 'L'
	PosiblesTallas[4] <- 'M'
	PosiblesTallas[5] <- 'S'
	PosiblesTallas[6] <- 'XS'
	return <- Falso
	// Si el imput está dentro de la lista, devolvemos true
	Para c<-1 Hasta 6 Hacer
		Si input=PosiblesTallas[c] Entonces
			return <- Verdadero
		FinSi
	FinPara
FinFuncion

Funcion return <- AveriguarTamaño (string)
	return <- ''
	// Recorre la talla para saber si contiene una L, M o S
	Para c<-0 Hasta Longitud(string) Hacer
		trozo <- Subcadena(string,c,c)
		Si trozo='L' Entonces
			return <- 'grande'
		FinSi
		Si trozo='M' Entonces
			return <- 'mediana'
		FinSi
		Si trozo='S' Entonces
			return <- 'pequeña'
		FinSi
	FinPara
FinFuncion

Algoritmo Tallas
	tallaValida <- Falso
	Mientras !tallaValida Hacer
		Borrar Pantalla
		Escribir 'Introduce una talla:'
		Escribir '   (Valores aceptados XXL a XS)'
		Leer talla
		talla <- Mayusculas(talla)
		tallaValida <- ComprobarValidez(talla)
		Si !tallaValida Entonces
			Escribir 'Talla no aceptada, lo sentimos.'
			Escribir 'Pulse cualquier tecla para continuar'
			Esperar Tecla
		FinSi
	FinMientras
	tamaño <- AveriguarTamaño(talla)
	Escribir 'La talla ',talla,' es una talla ',tamaño,'.'
FinAlgoritmo
