Algoritmo AñoBisiesto
	Escribir 'Introduce un año: '
	Leer year
	Si year MOD 4=0 Y year MOD 100<>0 O year MOD 400=0 Entonces
		Escribir 'El año ',year,' es bisiesto.'
	SiNo
		Escribir 'El año ',year,' no es bisiesto.'
	FinSi
FinAlgoritmo
