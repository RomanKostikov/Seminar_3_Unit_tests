package homework.task001;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainHWTest {
    /**
     * ��������� ������������ ������� �����
     * ������� �������� �� ������ evenOddNumber - true
     */
    @Test
    void checkEvenNumber() {
        assertTrue(MainHW.evenOddNumber(4));
    }

    /**
     * ��������� ������������ ������� �����
     * ������� �������� �� ������ evenOddNumber - false
     */
    @Test
    void checkOddNumber() {
        assertFalse(MainHW.evenOddNumber(3));
    }

    /**
     * ��������� ������������ ���������� ����� � ��������� (25;100)
     * ������� �������� �� ������ numberInInterval - true
     */
    @Test
    void checkNumberInInterval() {
        assertTrue(MainHW.numberInInterval(25));
        assertTrue(MainHW.numberInInterval(100));
    }

    /**
     * ��������� ������������ ���������� ����� � ��������� (25;100)
     * ������� �������� �� ������ numberInInterval - false
     */
    @Test
    void checkNumberNotInInterval() {
        assertFalse(MainHW.numberInInterval(24));
        assertFalse(MainHW.numberInInterval(101));
    }

}
