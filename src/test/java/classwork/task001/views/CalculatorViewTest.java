package classwork.task001.views;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorViewTest {
    private static CalculatorView view;

    @BeforeAll
    public static void createView(){
        view = new CalculatorView();
    }

    @Test
    void printMenu() {
        // Проверяем, что метод printMenu() выводит текст меню
        // Создаем объект ByteArrayOutputStream, чтобы перехватить вывод
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        view.printMenu();

        // Проверяем, что вывод соответствует ожидаемому тексту меню
        assertEquals("Выберите операцию:\n1. Сложение\n2. Вычитание\n3. Умножение\n4. Деление\n5. Выход\n",
                outContent.toString());

        // Восстанавливаем стандартный поток вывода
        System.setOut(System.out);
    }


    @Test
    void printResult() {
        String expectedMessage = "Результат: 10\r\n";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        view.printResult(10);

        // Проверяем, что вывод соответствует ожидаемому тексту меню
        assertEquals(expectedMessage, outContent.toString());

        // Восстанавливаем стандартный поток вывода
        System.setOut(System.out);

    }

    @Test
    void getInput() {
//        int expectedValue = 9;
//        String testedValue = "9"; // Значение для тестов
        ByteArrayInputStream in = new ByteArrayInputStream("42\n".getBytes());
//        InputStream inputStream = System.in; // Сохраняем ссылку на ввод с клавиатуры
//        System.setIn(in); // Подменяем ввод
//        int actualNumber = view.getInput(); // Вызываем метод
        System.setIn(in); // Подменяем обратно

        assertEquals(42, view.getInput(), "метод getInput некорректен");
        System.setIn(System.in);
    }

    @Test
    void printErrorMessage() {
        String expectedMessage = "Деление на ноль запрещено!\r\n";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        view.printErrorMessage("Деление на ноль запрещено!");

        // Проверяем, что вывод соответствует ожидаемому тексту меню
        assertEquals(expectedMessage, outContent.toString());

        // Восстанавливаем стандартный поток вывода
        System.setOut(System.out);
    }
}