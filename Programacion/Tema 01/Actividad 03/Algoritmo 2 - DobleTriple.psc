Algoritmo DobleTriple
	operacion <- 0
	Escribir 'Introduce un n�mero:'
	Leer n
	Repetir
		Borrar Pantalla
		Escribir 'El n�mero introducido es ',n
		Escribir '   1. Calcular el doble'
		Escribir '   2. Calcular el triple'
		Escribir '   3. Introducir otro n�mero'
		Escribir '   4. Salir'
		Leer operacion
		Segun operacion  Hacer
			1:
				Escribir 'El doble de ',n,' es ',n*2
			2:
				Escribir 'El triple de ',n,' es ',n*3
			3:
				Escribir 'Introduce un n�mero:'
				Leer n
			4:
				Escribir 'Hemos acabado aqu�.'
			De Otro Modo:
				Escribir 'Opci�n no v�lida'
		FinSegun
		Escribir 'Presione enter para continuar'
		Esperar Tecla
	Hasta Que operacion=4
FinAlgoritmo
