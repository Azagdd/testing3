package funciones;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UtildadesTest {

private static Utilidades utils;
	
	@BeforeAll
	static void inicializar() {
		utils = new Utilidades();
	}

	@Test
	void testDevuelveNota() {
		assertThrows(ArithmeticException.class,
				()->utils.devuelveNota(-2));
		assertThrows(ArithmeticException.class,
				()->utils.devuelveNota(12));
		//límite
		assertEquals("Suspenso",
				utils.devuelveNota(0));
		assertEquals("Suspenso",
				utils.devuelveNota(4));
		//límite
		assertEquals("Bien",
				utils.devuelveNota(5));
		assertEquals("Bien",
				utils.devuelveNota(6));
		// límite
		assertEquals("Notable",
				utils.devuelveNota(6.5));
		assertEquals("Notable",
				utils.devuelveNota(8.4));
		//límite
		assertEquals("Sobresaliente",
				utils.devuelveNota(8.5));
		assertEquals("Sobresaliente",
				utils.devuelveNota(9.9));
		assertEquals("Matrícula",
				utils.devuelveNota(10));
	}

	@Test
	void testCalculaSalario() {
		
		assertThrows(ArithmeticException.class, ()->utils.calculaSalario(0, 40, 12));
		assertThrows(ArithmeticException.class, ()->utils.calculaSalario(30, 0, 12));
		assertThrows(ArithmeticException.class, ()->utils.calculaSalario(38, 40, 0));
		
		assertThrows(ArithmeticException.class, ()->utils.calculaSalario(-8, 40, 12));
		assertThrows(ArithmeticException.class, ()->utils.calculaSalario(30, -30, 12));
		assertThrows(ArithmeticException.class, ()->utils.calculaSalario(38, 40, -20));
		
		assertEquals((Utilidades.HORASJORNADA-10)*12, 
				utils.calculaSalario(Utilidades.HORASJORNADA-10, 12, 15));
		assertEquals(Utilidades.HORASJORNADA*12+2*15, 
				utils.calculaSalario(Utilidades.HORASJORNADA+2, 12, 15));
		assertEquals(Utilidades.HORASJORNADA*12, 
				utils.calculaSalario(Utilidades.HORASJORNADA, 12, 15));
		
	}

	@Test
	void testCuentaDivisores() {
		assertAll(
				()->assertEquals(2, utils.cuentaDivisores(7)),
				()->assertEquals(1, utils.cuentaDivisores(1)),
				()->assertEquals(4, utils.cuentaDivisores(8)),
				()->assertEquals(0, utils.cuentaDivisores(0)),
				()->assertEquals(0, utils.cuentaDivisores(-8))
				);
	}

	@Test
	void testDevuelveMenor() {
		int v[] = { 2,3,8,1,7 };
		assertEquals(1, utils.devuelveMenor(v));
		
		int v2[] = { 2,3,-8,1,7 };
		assertEquals(-8, utils.devuelveMenor(v2));
		
	}

	@Test
	void testBurbuja() {
		int v[] = {2,7,4,9,1};
		int o[] = {1,2,4,7,9};
		
		assertArrayEquals(o, utils.burbuja(v));
		
		int v2[] = { 1,3,7,9,15};
		assertArrayEquals(v2, utils.burbuja(v2));
		
		int v3[] = { 9, 3, 9, 1, 3, 5};
		int o3[] = {1,3,3,5,9,9};
		assertArrayEquals(o3, utils.burbuja(v3));
		
		int v4[] = {9,7,5,3,1};
		int o4[] = {1,3,5,7,9};
		assertArrayEquals(o4, utils.burbuja(v4));
		
	}

}
