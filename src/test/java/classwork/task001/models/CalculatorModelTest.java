package classwork.task001.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorModelTest {
    private static CalculatorModel calculator;

    @BeforeAll
    public static void createCalculator(){
        calculator = new CalculatorModel();
    }

    @Test
    void getFirstNumber() {
        int expectedNum = 3;
        calculator.setFirstNumber(expectedNum);
        int actualNumber = calculator.getFirstNumber();
        assertEquals(expectedNum, actualNumber, "метод getFirstNumber некорректен");
    }

    @Test
    void setFirstNumber() {
        int expectedNum = 3;
        calculator.setFirstNumber(expectedNum);
        int actualNumber = calculator.getFirstNumber();
        assertEquals(expectedNum, actualNumber, "метод setFirstNumber некорректен");
    }

    @Test
    void getSecondNumber() {
        int expectedNum = 3;
        calculator.setSecondNumber(expectedNum);
        int actualNumber = calculator.getSecondNumber();
        assertEquals(expectedNum, actualNumber, "метод getSecondNumber некорректен");
    }

    @Test
    void setSecondNumber() {
        int expectedNum = 3;
        calculator.setSecondNumber(expectedNum);
        int actualNumber = calculator.getSecondNumber();
        assertEquals(expectedNum, actualNumber, "метод setSecondNumber некорректен");
    }

    @Test
    void add() {
        int expectedNum = 14;
        calculator.setFirstNumber(6);
        calculator.setSecondNumber(8);
        int actualNumber = calculator.add();
        assertEquals(expectedNum, actualNumber, "Метод add некорректен");
    }

    @Test
    void subtract() {
        int expectedNum = 4;
        calculator.setFirstNumber(6);
        calculator.setSecondNumber(2);
        int actualNumber = calculator.subtract();
        assertEquals(expectedNum, actualNumber, "Метод subtract некорректен");
    }

    @Test
    void multiply() {
        int expectedNum = 12;
        calculator.setFirstNumber(3);
        calculator.setSecondNumber(4);
        int actualNumber = calculator.multiply();
        assertEquals(expectedNum, actualNumber, "Метод multiply некорректен");
    }

    @Test
    void divide() {
        int expectedNum = 4;
        calculator.setFirstNumber(12);
        calculator.setSecondNumber(3);
        int actualNumber = calculator.divide();
        assertEquals(expectedNum, actualNumber, "Метод divide некорректен");
    }

    @Test
    void divideByZero(){
        String message = "Деление на ноль запрещено!";
        calculator.setFirstNumber(12);
        calculator.setSecondNumber(0);
        Exception actualException = assertThrows(ArithmeticException.class, () -> calculator.divide());
        assertEquals(message, actualException.getMessage(),
                "Метод divide со вторым аргументом равным 0 некорректен");
    }
}