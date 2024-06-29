package ual.hmis.sesion06.ejercicio4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MezclaLineal {
	
	public <T extends Comparable<T>> List<T> merge(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>();

        // Caso 1: Ambas listas están vacías
        if (list1.isEmpty() && list2.isEmpty()) {
            return result; // Lista vacía
        }

        // Caso 2: Lista A está vacía
        if (list1.isEmpty()) {
            return new ArrayList<>(list2); // Devolver copia de Lista B
        }

        // Caso 3: Lista B está vacía
        if (list2.isEmpty()) {
            return new ArrayList<>(list1); // Devolver copia de Lista A
        }

        // Caso 4: Fusionar las listas ordenadas
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            T elem1 = list1.get(i);
            T elem2 = list2.get(j);
            if (elem1.compareTo(elem2) <= 0) {
                result.add(elem1);
                i++;
            } else {
                result.add(elem2);
                j++;
            }
        }

        // Agregar los elementos restantes de Lista A, si los hay
        while (i < list1.size()) {
            result.add(list1.get(i));
            i++;
        }

        // Agregar los elementos restantes de Lista B, si los hay
        while (j < list2.size()) {
            result.add(list2.get(j));
            j++;
        }

        // Eliminar duplicados si los hay
        Set<T> resultSet = new HashSet<>(result);
        result.clear();
        result.addAll(resultSet);

        return result;
    }
}
