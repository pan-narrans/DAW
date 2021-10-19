Funcion CuentaAtras
	Borrar Pantalla
	Escribir '1..'
	Esperar 1 Segundos
	Borrar Pantalla
	Escribir '1, 2...'
	Esperar 1 Segundos
	Borrar Pantalla
	Escribir '1, 2, 3...'
	Esperar 1 Segundos
	Borrar Pantalla
	Escribir '!Piedra, Papel, Tijera, Lagarto, Spock!'
	Esperar 1 Segundos
FinFuncion

Funcion figura <- AsignarFigura (num)
	// Para poder mostrar por pantalla el nombre de la figura
	Segun num  Hacer
		1:
			figura <- 'Piedra'
		2:
			figura <- 'Papel'
		3:
			figura <- 'Tijera'
		4:
			figura <- 'Lagarto'
		5:
			figura <- 'Spock'
	FinSegun
FinFuncion

Funcion NuevaPartida (num)
	Borrar Pantalla
	// Display de nº de partidas ganadas
	Si num=1 Entonces
		Escribir '\(^-^)/ Has ganado ',num,' vez! \(^-^)/'
		Escribir ''
	FinSi
	Si num>1 Entonces
		Escribir '\(^-^)/ Has ganado ',num,' veces! \(^-^)/'
		Escribir ''
	FinSi
	// Display de opciones
	Escribir '!Piedra, Papel, Tijera, Lagarto, Spock!'
	Escribir ''
	Escribir 'Escoge tu mano:'
	Escribir '   1. Piedra'
	Escribir '   2. Papel'
	Escribir '   3. Tijera'
	Escribir '   4. Lagarto'
	Escribir '   5. Spock'
FinFuncion

Funcion eleccion <- EscogerManoJugador
	Repetir
		Leer eleccion
		Si eleccion<1 O eleccion>5 Entonces
			Escribir '¡El valor introducido no es válido!'
			Escribir 'Presiona cualquier tecla para continuar.'
			Esperar Tecla
		FinSi
	Mientras Que eleccion<1 O eleccion>5
FinFuncion

Funcion return <- QuienHaGanado(ManoJugador,ManoPC)
	Segun ManoJugador  Hacer
		1:
			Si ManoPC=2 O ManoPC=5 Entonces
				return <- 'Máquina'
			SiNo
				return <- 'Jugador'
			FinSi
		2:
			Si ManoPC=3 O ManoPC=4 Entonces
				return <- 'Máquina'
			SiNo
				return <- 'Jugador'
			FinSi
		3:
			Si ManoPC=1 O ManoPC=5 Entonces
				return <- 'Máquina'
			SiNo
				return <- 'Jugador'
			FinSi
		4:
			Si ManoPC=1 O ManoPC=3 Entonces
				return <- 'Máquina'
			SiNo
				return <- 'Jugador'
			FinSi
		5:
			Si ManoPC=2 O ManoPC=4 Entonces
				return <- 'Máquina'
			SiNo
				return <- 'Jugador'
			FinSi
	FinSegun
FinFuncion

Funcion return <- SumarPartidaGanada (string)
	Si string='Máquina' Entonces
		return <- 0
	SiNo
		Si string='Jugador' Entonces
			return <- 1
		FinSi
	FinSi
FinFuncion

Algoritmo LagartoSpock
	// Declarar variables
	ManoPC <- 0
	ManoJugador <- 0
	FiguraPC <- ''
	FiguraJugador <- ''
	PlayAgain <- 1
	PartidasGanadas <- 0
	// Bucle de juego
	Mientras PlayAgain=1 Hacer
		// Nueva Partida
		NuevaPartida(PartidasGanadas)
		// Asignar valor a las variables
		ManoJugador <- EscogerManoJugador
		ManoPC <- azar(5)+1
		FiguraJugador <- AsignarFigura(ManoJugador)
		FiguraPC <- AsignarFigura(ManoPC)
		// Puramente estético
		CuentaAtras
		// Presentar las elecciones
		Escribir 'Jugador: ',FiguraJugador
		Escribir 'Máquina: ',FiguraPC
		Escribir ''
		Esperar 1 Segundos
		// Decidir el ganador
		Si ManoJugador=ManoPC Entonces
			Escribir '¡Empate!'
		SiNo
			ElGanador <- QuienHaGanado(ManoJugador,ManoPC)
			PartidasGanadas <- PartidasGanadas+SumarPartidaGanada(ElGanador)
			Escribir 'Ganador: ',ElGanador
		FinSi
		// Jugar otra vez
		Esperar 1 Segundos
		Escribir ''
		Escribir 'Jugar otra vez?'
		Escribir '   1. Sí'
		Escribir '   2. No'
		Leer PlayAgain
	FinMientras
FinAlgoritmo
