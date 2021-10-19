Algoritmo AleatorioJuego
	// Algoritmo para un juego para adivinar un n�mero aleatorio, indicando si es menor, mayor o acert�. 
	eleccion <- 0
	nAleatorio <- 0
	nEscogido <- 0
	ganadas <- 0
	Repetir
		// Men� principal
		Borrar Pantalla
		Si ganadas=1 Entonces
			Escribir '\(^-^)/ Has ganado ',ganadas,' vez! \(^-^)/'
			Escribir ''
		FinSi
		Si ganadas>1 Entonces
			Escribir '\(^-^)/ Has ganado ',ganadas,' veces! \(^-^)/'
			Escribir ''
		FinSi
		Escribir 'La m�quina va a escoger un n�mero entre el 0 y el n�mero que tu elijas.'
		Escribir ''
		Escribir 'Tienes que intentar adivinarlo pero no te preocupes,'
		Escribir '�la m�quina te ir� dando pistas!'
		Escribir ''
		Escribir 'Opciones:'
		Escribir '   1. Jugar una partida'
		Escribir '   2. Salir'
		Leer eleccion
		// Juego
		Si eleccion=1 Entonces
			Escribir 'Escoge el n�mero l�mite:'
			Leer n
			nAleatorio <- azar(n+1)
			Borrar Pantalla
			Escribir '�A jugar!'
			Escribir '�Adivina el n�mero del 0 al ',n,'!'
			// Bucle principal de juego
			Mientras nEscogido<>nAleatorio Hacer
				Leer nEscogido
				Si nEscogido>nAleatorio Entonces
					Escribir 'El n�mero buscado es m�s peque�o.'
				SiNo
					Si nEscogido<nAleatorio Entonces
						Escribir 'El n�mero buscado es m�s grande.'
					SiNo
						ganadas <- ganadas+1
						Escribir '�Has acertado!'
						Esperar Tecla
					FinSi
				FinSi
			FinMientras
		FinSi
	Hasta Que eleccion=2
FinAlgoritmo
