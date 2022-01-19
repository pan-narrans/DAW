/* package es.infantaelena;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static es.infantaelena.TresEnRaya.*;
import static es.infantaelena.TestTableros.*;

class TestTresEnRaya {

	@Tag("creaRecords")
	@Test
	void testCreaRecords() {
		TresEnRaya t = new TresEnRaya();
		String [][] records;
		records = t.creaRecords();
		System.out.println("======TEST creaRecords=======");
		Assertions.assertEquals( 2 , records[0].length);
		Assertions.assertEquals( t.NUM_RECORDS , records.length);

	}
	
	@Tag("nuevoRecord")
	@Test
	void testNuevoRecord() {
		TresEnRaya t = new TresEnRaya();
		String [][] records;
		records = t.creaRecords();
		System.out.println("======TEST nuevoRecord=======");
		records = t.nuevoRecord(records,"TIC",4);
		records = t.nuevoRecord(records,".",9);
		records = t.nuevoRecord(records,"TAC",7);
		records = t.nuevoRecord(records,"TOE",8);
		
		t.imprimirRecords(records);
		System.out.println(records[0][0]);
		
		Assertions.assertEquals( "TIC" , records[0][0]);
		Assertions.assertEquals( "TAC" , records[1][0]);
		Assertions.assertEquals( "TOE" , records[2][0]);
		Assertions.assertEquals( "4" , records[0][1]);
		Assertions.assertEquals( "7" , records[1][1]);
		Assertions.assertEquals( "8" , records[2][1]);
		
		
		records = t.nuevoRecord(records,"EN",2);
		records = t.nuevoRecord(records,"TRES",1);
		records = t.nuevoRecord(records,"RAYA",3);
		Assertions.assertEquals( "1" , records[0][1]);
		Assertions.assertEquals( "2" , records[1][1]);
		Assertions.assertEquals( "3" , records[2][1]);
		
		Assertions.assertEquals( "TRES" , records[0][0]);
		Assertions.assertEquals( "EN" , records[1][0]);
		Assertions.assertEquals( "RAYA" , records[2][0]);
		Assertions.assertEquals( 2 , records[0].length);
		Assertions.assertEquals( t.NUM_RECORDS , records.length);
	

	}
	
	@Tag("creaTablero")
	@Test
	void testCreaTablero() {
		TresEnRaya t = new TresEnRaya();
		char tablero [][];
		tablero = t.creaTablero(t.TAM_TABLERO);
		System.out.println("======TEST creaTablero=======");
		Assertions.assertEquals( t.TAM_TABLERO , tablero[0].length);
		Assertions.assertEquals( t.TAM_TABLERO , tablero.length);
	}
	
	@Tag("jugadaValida")
	@Test
	void testJugadaValida() {
		TresEnRaya t = new TresEnRaya();
		char [][] tableroVacio = t.creaTablero(3);
				
		char [][] tablero = {{JUG_2,VACIA,VACIA},
							{JUG_1,JUG_1,JUG_2},
							{VACIA,VACIA,VACIA}
				};
		
		System.out.println("======TEST JugadaValida======");
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				Assertions.assertEquals( true , t.esJugadaValida(i,j,tableroVacio));

			}
		}
		
		Assertions.assertEquals( false , t.esJugadaValida(0,0,tablero));
		Assertions.assertEquals( false , t.esJugadaValida(2,3,tablero));
		Assertions.assertEquals( false , t.esJugadaValida(1,1,tablero));
		Assertions.assertEquals( false , t.esJugadaValida(3,1,tablero));
	}
	
	@Tag("posicionVacia")
	@Test
	void testPosicionVacia() {
		TresEnRaya t = new TresEnRaya();
		char [][] tableroVacio = t.creaTablero(3);
				
		char [][] tablero = {{JUG_2,JUG_2,JUG_1},
							{JUG_1,JUG_1,JUG_2},
							{JUG_1,JUG_1,JUG_2}
				};
		
		System.out.println("======TEST posicionVacia======");
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				Assertions.assertEquals( true , t.esPosicionVacia(tableroVacio,i,j));

			}
		}
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				Assertions.assertEquals( false , t.esPosicionVacia(tablero,i,j));

			}
		}
	}
	
	
	
		@Tag("comprobarVictoriaHorizontal")
		@Test
		void testComprobarVictoriaHorizontal() {
			TresEnRaya t = new TresEnRaya();
			System.out.println("======TEST comprobarVictoria Horizontal======");
			for(int k=0; k< TABLEROS_HORIZONTAL_JUG1.length; k++) {
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						//t.imprimirTablero(TABLEROS_HORIZONTAL_JUG1[k]);
						Assertions.assertEquals( 0 , t.comprobarVictoria(TABLEROS_HORIZONTAL_JUG1[k]));

					}
				}
			}
			
			for(int k=0; k< TABLEROS_HORIZONTAL_JUG2.length; k++) {
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						//t.imprimirTablero(TABLEROS_HORIZONTAL_JUG1[k]);
						Assertions.assertEquals( 1 , t.comprobarVictoria(TABLEROS_HORIZONTAL_JUG2[k]));

					}
				}
			}
			
			
			
		
			
	}
		
		@Tag("comprobarVictoriaVertical")
		@Test
		void testComprobarVictoriaVertical() {
			TresEnRaya t = new TresEnRaya();
			System.out.println("======TEST comprobarVictoria Horizontal======");
			for(int k=0; k< TABLEROS_VERTICAL_JUG1.length; k++) {
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						//t.imprimirTablero(TABLEROS_HORIZONTAL_JUG1[k]);
						Assertions.assertEquals( 0 , t.comprobarVictoria(TABLEROS_VERTICAL_JUG1[k]));

					}
				}
			}
			
			for(int k=0; k< TABLEROS_VERTICAL_JUG2.length; k++) {
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						//t.imprimirTablero(TABLEROS_HORIZONTAL_JUG1[k]);
						Assertions.assertEquals( 1 , t.comprobarVictoria(TABLEROS_VERTICAL_JUG2[k]));

					}
				}
			}
		}
		
		@Tag("comprobarVictoriaDiagonal")
		@Test
		void testComprobarVictoriaDiagonal() {
			TresEnRaya t = new TresEnRaya();
			System.out.println("======TEST comprobarVictoria Diagonal======");
			for(int k=0; k< TABLEROS_DIAGONAL_JUG1.length; k++) {
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {					
						Assertions.assertEquals( 0 , t.comprobarVictoria(TABLEROS_DIAGONAL_JUG1[k]));

					}
				}
			}
			
			for(int k=0; k< TABLEROS_DIAGONAL_JUG2.length; k++) {
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						//t.imprimirTablero(TABLEROS_HORIZONTAL_JUG1[k]);
						Assertions.assertEquals( 1 , t.comprobarVictoria(TABLEROS_DIAGONAL_JUG2[k]));

					}
				}
			}
		}
		
		@Tag("comprobarVictoriaEmpate")
		@Test
		void testComprobarVictoriaEmpate() {
			TresEnRaya t = new TresEnRaya();
			System.out.println("======TEST comprobarVictoria Empate======");
			for(int k=0; k< TABLEROS_EMPATE.length; k++) {
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						//t.imprimirTablero(TABLEROS_EMPATE[k]);
						Assertions.assertEquals( 2 , t.comprobarVictoria(TABLEROS_EMPATE[k]));

					}
				}
			}
			
			
		}
		
		@Tag("comprobarVictoriaNoterminada")
		@Test
		void testComprobarVictoriaNoTerminada() {
			TresEnRaya t = new TresEnRaya();
			System.out.println("======TEST comprobarVictoria No terminada======");
			for(int k=0; k< TABLEROS_SIN_TERMINAR.length; k++) {
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						Assertions.assertEquals( -1 , t.comprobarVictoria(TABLEROS_SIN_TERMINAR[k]));

					}
				}
			}
			
			
		}
	
}
 */