import com.company.Main;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void validateStringValid1() {
        String str = "3[xyz]4[xy]z";
        Assert.assertTrue(Main.validateString(str));
    }

    @Test
    void validateStringValid2() {
        String str = "2[3[x]y]2[x]";
        Assert.assertTrue(Main.validateString(str));
    }

    @Test
    void validateStringValid3() {
        String str = "4[2[10[]y]]zzzz";
        Assert.assertTrue(Main.validateString(str));
    }

    @Test
    void validateStringValid4() {
        String str = "testtesttest";
        Assert.assertTrue(Main.validateString(str));
    }

    @Test
    void validateStringWrongAmountOfBrackets1() {
        String str = "3[xyz]4[xy]z[";
        Assert.assertFalse(Main.validateString(str));
    }

    @Test
    void validateStringWrongAmountOfBrackets2() {
        String str = "3[xyz]4[xy]z]";
        Assert.assertFalse(Main.validateString(str));
    }

    @Test
    void validateStringNoNumberBeforeBrackets() {
        String str = "3[xyz]4[xy]z[]";
        Assert.assertFalse(Main.validateString(str));
    }

    @Test
    void validateStringNumberWithoutBrackets() {
        String str = "3[xyz]4[xy]z3fff";
        Assert.assertFalse(Main.validateString(str));
    }

    @Test
    void validateStringWrongSymbols1() {
        String str = "`!@#$%^&*()";
        Assert.assertFalse(Main.validateString(str));
    }

    @Test
    void validateStringWrongSymbols2() {
        String str = "те ст";
        Assert.assertFalse(Main.validateString(str));
    }

    @Test
    void unboxString1() {
        String str = "3[xyz]4[xy]z";
        String unboxedStringExpected = "xyzxyzxyzxyxyxyxyz";

        String unboxedStringActual = Main.unboxString(str);

        Assert.assertEquals(unboxedStringExpected, unboxedStringActual);
    }

    @Test
    void unboxString2() {
        String str = "2[3[x]y]2[x]";
        String unboxedStringExpected = "xxxyxxxyxx";

        String unboxedStringActual = Main.unboxString(str);

        Assert.assertEquals(unboxedStringExpected, unboxedStringActual);
    }

    @Test
    void unboxString3() {
        String str = "4[2[10[]y]]zzzz";
        String unboxedStringExpected = "yyyyyyyyzzzz";

        String unboxedStringActual = Main.unboxString(str);

        Assert.assertEquals(unboxedStringExpected, unboxedStringActual);
    }
}