Algoritmo A�oBisiesto
	Escribir 'Introduce un a�o: '
	Leer year
	Si year MOD 4=0 Y year MOD 100<>0 O year MOD 400=0 Entonces
		Escribir 'El a�o ',year,' es bisiesto.'
	SiNo
		Escribir 'El a�o ',year,' no es bisiesto.'
	FinSi
FinAlgoritmo
