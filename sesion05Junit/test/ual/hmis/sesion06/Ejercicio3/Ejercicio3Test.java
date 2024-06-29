package ual.hmis.sesion06.Ejercicio3;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ual.hmis.sesion06.ejercicio3.Ejercicio3;

public class Ejercicio3Test {

    @ParameterizedTest(name = "{index} => Con entrada ({0}) sale {1}")
    @CsvSource({"123,password demasiado corto",
            "12345,********",
            "123456789012,************",
            "12345678901234567890123456789012345678901,password demasiado largo"})
    public void testMaskPassword(String password, String expected) {
        Ejercicio3 ejercicio = new Ejercicio3();
        String result = ejercicio.maskPassword(password);
        assertEquals(expected, result);
    }
}
