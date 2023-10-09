package homework.task001;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainHWTest {
    /**
     * “естируем корректность четного числа
     * ожидаем получить от метода evenOddNumber - true
     */
    @Test
    void checkEvenNumber() {
        assertTrue(MainHW.evenOddNumber(4));
    }

    /**
     * “естируем корректность четного числа
     * ожидаем получить от метода evenOddNumber - false
     */
    @Test
    void checkOddNumber() {
        assertFalse(MainHW.evenOddNumber(3));
    }

    /**
     * “естируем корректность нахождени€ числа в интервале (25;100)
     * ожидаем получить от метода numberInInterval - true
     */
    @Test
    void checkNumberInInterval() {
        assertTrue(MainHW.numberInInterval(25));
        assertTrue(MainHW.numberInInterval(100));
    }

    /**
     * “естируем корректность нахождени€ числа в интервале (25;100)
     * ожидаем получить от метода numberInInterval - false
     */
    @Test
    void checkNumberNotInInterval() {
        assertFalse(MainHW.numberInInterval(24));
        assertFalse(MainHW.numberInInterval(101));
    }

}
