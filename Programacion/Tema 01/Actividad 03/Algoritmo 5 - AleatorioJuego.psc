Algoritmo AleatorioJuego
	// Algoritmo para un juego para adivinar un número aleatorio, indicando si es menor, mayor o acertó. 
	eleccion <- 0
	nAleatorio <- 0
	nEscogido <- 0
	ganadas <- 0
	Repetir
		// Menú principal
		Borrar Pantalla
		Si ganadas=1 Entonces
			Escribir '\(^-^)/ Has ganado ',ganadas,' vez! \(^-^)/'
			Escribir ''
		FinSi
		Si ganadas>1 Entonces
			Escribir '\(^-^)/ Has ganado ',ganadas,' veces! \(^-^)/'
			Escribir ''
		FinSi
		Escribir 'La máquina va a escoger un número entre el 0 y el número que tu elijas.'
		Escribir ''
		Escribir 'Tienes que intentar adivinarlo pero no te preocupes,'
		Escribir '¡la máquina te irá dando pistas!'
		Escribir ''
		Escribir 'Opciones:'
		Escribir '   1. Jugar una partida'
		Escribir '   2. Salir'
		Leer eleccion
		// Juego
		Si eleccion=1 Entonces
			Escribir 'Escoge el número límite:'
			Leer n
			nAleatorio <- azar(n+1)
			Borrar Pantalla
			Escribir '¡A jugar!'
			Escribir '¡Adivina el número del 0 al ',n,'!'
			// Bucle principal de juego
			Mientras nEscogido<>nAleatorio Hacer
				Leer nEscogido
				Si nEscogido>nAleatorio Entonces
					Escribir 'El número buscado es más pequeño.'
				SiNo
					Si nEscogido<nAleatorio Entonces
						Escribir 'El número buscado es más grande.'
					SiNo
						ganadas <- ganadas+1
						Escribir '¡Has acertado!'
						Esperar Tecla
					FinSi
				FinSi
			FinMientras
		FinSi
	Hasta Que eleccion=2
FinAlgoritmo
