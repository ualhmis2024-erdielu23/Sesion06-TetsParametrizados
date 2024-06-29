package ual.hmis.sesion06.ejercicio5;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ual.hmis.sesion06.ejercicio5.ContadorDePalabras;

public class ContadorDePalabrasTest {

	@ParameterizedTest
	@CsvSource({ "'input.txt', 'a, c, b', 'a, b, c'", 
		"'input.txt', 'hola, java, mundo', 'hola, mundo, java'",
		"'input.txt', '', ''" })
	
	void testObtenerPalabrasEnOrdenAlfabetico(String nombreArchivo, String input, String expectedOutput)
			throws IOException {
		
		String rutaArchivo = System.getProperty("user.dir") + File.separator + "test" + File.separator + "ual"
				+ File.separator + "hmis" + File.separator + "sesion06" + File.separator + nombreArchivo
				+ File.separator;
		
		ContadorDePalabras contador = new ContadorDePalabras(rutaArchivo);
		List<String> palabras = Arrays.asList(input.split(", "));
		ContadorDePalabras.escribirArchivo(rutaArchivo, palabras);
		List<String> resultado = contador.obtenerPalabrasEnOrdenAlfabetico();

		// Ordenar ambas listas antes de compararlas
		Collections.sort(resultado);
		List<String> expectedList = Arrays.asList(expectedOutput.split(", "));
		Collections.sort(expectedList);

		assertEquals(expectedList, resultado);
	}

	@ParameterizedTest
	@CsvSource({ "'input.txt', 'a, a, b, b, c', 'a, b, c'",
		"'input.txt', 'hola, hola, mundo, mundo, java', 'hola, mundo, java'" })
	
	void testObtenerPalabrasPorNumeroDeOcurrencias(String nombreArchivo, String input, String expectedOutput)
			throws IOException {
		
		String rutaArchivo = System.getProperty("user.dir") + File.separator + "test" + File.separator + "ual"
				+ File.separator + "hmis" + File.separator + "sesion06" + File.separator + nombreArchivo
				+ File.separator;
		
		ContadorDePalabras contador = new ContadorDePalabras(rutaArchivo);
		List<String> palabras = Arrays.asList(input.split(", "));
		ContadorDePalabras.escribirArchivo(rutaArchivo, palabras);
		List<String> resultado = contador.obtenerPalabrasPorNumeroDeOcurrencias();
		assertEquals(Arrays.asList(expectedOutput.split(", ")), resultado);
	}
}
