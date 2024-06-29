package ual.hmis.sesion06.ejercicio5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContadorDePalabras {
	private final String rutaArchivo;

	public ContadorDePalabras(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	public List<String> obtenerPalabrasEnOrdenAlfabetico() throws IOException {
		List<String> palabras = leerPalabras();
		Collections.sort(palabras);
		return palabras;
	}

	public List<String> obtenerPalabrasPorNumeroDeOcurrencias() throws IOException {
		List<String> palabras = leerPalabras();
		Map<String, Integer> conteoPalabras = new HashMap<>();

		// Contar ocurrencias de palabras
		for (String palabra : palabras) {
			conteoPalabras.put(palabra, conteoPalabras.getOrDefault(palabra, 0) + 1);
		}

		// Ordenar por número de ocurrencias y luego por orden alfabético
		List<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(conteoPalabras.entrySet());
		listaOrdenada.sort((a, b) -> {
			int comparacion = b.getValue().compareTo(a.getValue());
			if (comparacion == 0) {
				return a.getKey().compareTo(b.getKey());
			}
			return comparacion;
		});

		// Extraer las palabras ordenadas
		List<String> palabrasOrdenadas = new ArrayList<>();
		for (Map.Entry<String, Integer> entrada : listaOrdenada) {
			palabrasOrdenadas.add(entrada.getKey());
		}

		return palabrasOrdenadas;
	}

	private List<String> leerPalabras() throws IOException {
		List<String> palabras = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] palabrasLinea = linea.split("\\s+");
				palabras.addAll(Arrays.asList(palabrasLinea));
			}
		}
		return palabras;
	}

	public static void escribirArchivo(String rutaArchivo, List<String> palabras) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
			for (String palabra : palabras) {
				writer.write(palabra);
				writer.newLine();
			}
		}
	}

}
