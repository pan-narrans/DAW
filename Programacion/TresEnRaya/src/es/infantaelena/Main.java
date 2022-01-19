package es.infantaelena;

public class Main {

	public static void main(String[] args) {
		TresEnRaya t = new TresEnRaya();
		//t.menuJuego();

		t.imprimirRecords(t.records);
		t.nuevoRecord(t.records, "alex 01", 5);
		t.imprimirRecords(t.records);
		t.nuevoRecord(t.records, "alex 02", 6);
		t.imprimirRecords(t.records);
		t.nuevoRecord(t.records, "alex 03", 5);
		t.imprimirRecords(t.records);
		t.nuevoRecord(t.records, "alex 04", 5);
		t.imprimirRecords(t.records);
	}

}

/*
 * TODO:
 * - quitar los comentarios al .classpath y a TestTresEnRaja.java quitando los
 * java unit tests
 * 
 */