package es.infantaelena;

public class Main {

	public static void main(String[] args) {
		TresEnRaya t = new TresEnRaya();
		t.menuJuego();

		// probarRecords(t);
		// probarTablero(t);
		// probarDiagonales(t);
	}

	static void probarDiagonales(TresEnRaya t) {

		int tamaño = 2;
		int rayas = (tamaño / 2) + 1;
		int ajuste = rayas - 1;

		// Check diagonals
		for (int i = 0; i < tamaño; i++) {
			for (int j = 0; j < tamaño; j++) {
				System.out.print("[" + i + "," + j + "]");
			}
			System.out.println("");
		}

		System.out.println("");
		System.out.println("Tamaño: " + tamaño);
		System.out.println("Rayas:  " + rayas);
		System.out.println("Ajuste: " + ajuste);
		System.out.println("");

		// --0
		// -0-
		// 0--

		// Check diagonals
		for (int i = ajuste; i < tamaño; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("[" + (i - j) + "," + j + "]");
			}
			System.out.println("");
		}
		// Check diagonals
		for (int i = tamaño - 2; i > ajuste - 1; i--) {
			for (int j = 0; j <= i; j++) {
				System.out.print("[" + (tamaño - 1 - j) + "," + (tamaño - 1 - i + j) + "]");
			}
			System.out.println("");
		}

		// 0--
		// -0-
		// --0

		// Check diagonals
		for (int i = ajuste; i < tamaño; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("[" + (i - j) + "," + (tamaño - 1 - j) + "]");
			}
			System.out.println("");
		}
		// Check diagonals
		for (int i = tamaño - 2; i > ajuste - 1; i--) {
			for (int j = 0; j <= i; j++) {
				System.out.print("[" + (tamaño - 1 - j) + "," + (i - j) + "]");
			}
			System.out.println("");
		}

		System.out.println("");
	}

	static void probarRecords(TresEnRaya t) {
		System.out.println("\nPROBAR MÉTODOS RECORDS");

		t.nuevoRecord(t.records, "alex 01", 9);
		t.nuevoRecord(t.records, "alex 02", 6);
		t.nuevoRecord(t.records, "alex 03", 3);
		t.nuevoRecord(t.records, "alex 04", 5);
		t.nuevoRecord(t.records, "alex 05", 5);

		t.imprimirRecords(t.records);

		System.out.println("4 " + ((t.esNuevoRecord(t.records, 4)) ? "" : "no ") + "es nuevo record.");
		System.out.println("6 " + ((t.esNuevoRecord(t.records, 6)) ? "" : "no ") + "es nuevo record.");
		System.out.println("7 " + ((t.esNuevoRecord(t.records, 7)) ? "" : "no ") + "es nuevo record.");
	}

	static void probarTablero(TresEnRaya t) {
		System.out.println("\nPROBAR MÉTODOS TABLERO");

		t.tablero[1][0] = 'X';

		t.imprimirTablero(t.tablero);

		System.out.println("[1,0] " + ((t.esPosicionVacia(t.tablero, 1, 0)) ? "" : "no ") + "está vacía.");
		System.out.println("[2,1] " + ((t.esPosicionVacia(t.tablero, 2, 1)) ? "" : "no ") + "está vacía.");
	}

	static void probarJugada(TresEnRaya t) {
		System.out.println("\nPROBAR MÉTODOS TABLERO");

		t.tablero[1][0] = 'X';

		t.imprimirTablero(t.tablero);

		System.out.println("[1,0] " + ((t.esPosicionVacia(t.tablero, 1, 0)) ? "" : "no ") + "está vacía.");
		System.out.println("[2,1] " + ((t.esPosicionVacia(t.tablero, 2, 1)) ? "" : "no ") + "está vacía.");
	}

}

/*
 * TODO: quitar los comentarios al .classpath y a TestTresEnRaja.java
 * quitando los java unit tests
 */

// TODO: guardar records entre partidas

// TODO: estandarizan los separadores gráficos
