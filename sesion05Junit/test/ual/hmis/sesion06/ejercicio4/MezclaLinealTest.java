package ual.hmis.sesion06.ejercicio4;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MezclaLinealTest {

    @ParameterizedTest(name = "{index} => ListaA={0}, ListaB={1}, Resultado={2}")
    @CsvSource({
            "'', '', ''",
            "'', '2,4,6', '2,4,6'",
            "'1,3,5', '', '1,3,5'",
            "'1,3,5', '2,4,6', '1,2,3,4,5,6'",
            "'1,2,3', '2,3,4', '1,2,3,4'",
            "'1,1,1', '2,2,2', '1,2'",
            "'1,1,1', '1,1,1', '1'",
            "'1,3,5', '4,6,8', '1,3,4,5,6,8'",
            "'1,3,5,7', '2,4,6', '1,2,3,4,5,6,7'",
            "'1,3,5,7', '2,4,6,8', '1,2,3,4,5,6,7,8'"
    })
    public void testMerge(String list1, String list2, String expected) {
    	MezclaLineal mix = new MezclaLineal();
        List<Integer> listA = parseList(list1);
        List<Integer> listB = parseList(list2);
        List<Integer> expectedResult = parseList(expected);

        List<Integer> result = mix.merge(listA, listB);

        assertEquals(expectedResult, result);
    }

    private List<Integer> parseList(String input) {
        List<Integer> list = new ArrayList<>();
        if (!input.isEmpty()) {
            Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .forEach(list::add);
        }
        return list;
    }
}
