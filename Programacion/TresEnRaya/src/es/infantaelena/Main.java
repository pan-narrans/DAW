package es.infantaelena;

public class Main {

	public static void main(String[] args) {
		TresEnRaya t = new TresEnRaya();
		// t.menuJuego();

		 probarRecords(t);
		// probarTablero(t);

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

}

/*
 * TODO: quitar los comentarios al .classpath y a TestTresEnRaja.java
 * quitando los java unit tests
 */

// TODO: guardar records entre partidas
