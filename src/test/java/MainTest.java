import com.company.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void tryParseInt1() {
        assertTrue(Main.isInteger('0'));
    }

    @Test
    void tryParseInt2() {
        assertFalse(Main.isInteger('a'));
    }

    @Test
    void validateStringValid1() {
        String str = "3[xyz]4[xy]z";
        assertTrue(Main.validateString(str));
    }

    @Test
    void validateStringValid2() {
        String str = "2[3[x]y]2[x]";
        assertTrue(Main.validateString(str));
    }

    @Test
    void validateStringValid3() {
        String str = "4[2[10[]y]]zzzz";
        assertTrue(Main.validateString(str));
    }

    @Test
    void validateStringValid4() {
        String str = "testtesttest";
        assertTrue(Main.validateString(str));
    }

    @Test
    void validateStringWrongAmountOfBrackets1() {
        String str = "3[xyz]4[xy]z[";
        assertFalse(Main.validateString(str));
    }

    @Test
    void validateStringWrongAmountOfBrackets2() {
        String str = "3[xyz]4[xy]z]";
        assertFalse(Main.validateString(str));
    }

    @Test
    void validateStringNoNumberBeforeBrackets() {
        String str = "3[xyz]4[xy]z[]";
        assertFalse(Main.validateString(str));
    }

    @Test
    void validateStringNumberWithoutBrackets() {
        String str = "3[xyz]4[xy]z3fff";
        assertFalse(Main.validateString(str));
    }

    @Test
    void validateStringWrongSymbols1() {
        String str = "`!@#$%^&*()";
        assertFalse(Main.validateString(str));
    }

    @Test
    void validateStringWrongSymbols2() {
        String str = "те ст";
        assertFalse(Main.validateString(str));
    }

    @Test
    void unboxString1() {
        String str = "3[xyz]4[xy]z";
        String unboxedStringExpected = "xyzxyzxyzxyxyxyxyz";

        String unboxedStringActual = Main.unboxString(str);

        assertEquals(unboxedStringExpected, unboxedStringActual);
    }

    @Test
    void unboxString2() {
        String str = "2[3[x]y]2[x]";
        String unboxedStringExpected = "xxxyxxxyxx";

        String unboxedStringActual = Main.unboxString(str);

        assertEquals(unboxedStringExpected, unboxedStringActual);
    }

    @Test
    void unboxString3() {
        String str = "4[2[10[]y]]zzzz";
        String unboxedStringExpected = "yyyyyyyyzzzz";

        String unboxedStringActual = Main.unboxString(str);

        assertEquals(unboxedStringExpected, unboxedStringActual);
    }
}