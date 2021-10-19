Algoritmo DecimalBinario
	Definir n Como Entero
	
	Escribir 'Introduce un número entero en base decimal para transformarlo en binario'
	Escribir 'No funciona con decimales.'
	Leer n
	
	resto <- 0
	textoBinario <- ''
	Mientras n<>0 Hacer
		resto <- n MOD 2
		n <- trunc(n/2)
		textoBinario <- Concatenar(ConvertirATexto(resto),textoBinario)
	FinMientras
	
	binario <- ConvertirANumero(textoBinario)
	Escribir binario
FinAlgoritmo
