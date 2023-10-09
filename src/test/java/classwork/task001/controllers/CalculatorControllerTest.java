package classwork.task001.controllers;


import classwork.task001.models.CalculatorModel;
import classwork.task001.views.CalculatorView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorControllerTest {

//    private CalculatorController controller;
//    @Mock
//    private CalculatorModel model;
//    @Mock
//    private CalculatorView view;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        controller = new CalculatorController(model, view);
//    }
//
//    @Test
//    public void testPerformOperationWithArithmeticException() {
//        when(view.getInput()).thenReturn(5, 0); // Ввод пользователя: первое число = 5, второе число = 0
//        when(model::divide).thenThrow(new ArithmeticException("Деление на ноль"));
//
//        controller.run();
//
//        // Проверяем, что было вызвано сообщение об ошибке с правильным сообщением
//        verify(view).printErrorMessage("Ошибка: Деление на ноль");
//    }

    @Test
    public void getNumberInput(){
        CalculatorController controller = new CalculatorController(new CalculatorModel(), new CalculatorView()); // Создаем заглушку контроллера
        Class <CalculatorController> controllerClass = CalculatorController.class; // Используя рефлексию получаем класс контроллера, как объект
        Method [] methods = controllerClass.getDeclaredMethods(); // Получаем все методы класса, в том числе и private
        for (Method method : methods){ // Перебираем полученные методы
            if (method.getName().equals("getNumberInput")){ // Когда находим нужный нам метод
                try {
                    method.setAccessible(true); // Снимаем с него проверку на модификатор доступа
                    ByteArrayInputStream in = new ByteArrayInputStream("5\n".getBytes()); // В поток ввода передаем 5
                    System.setIn(in);
                    assertEquals(5, method.invoke(controller, "message"), "Метод зафейлился"); // Проверяем что вернул private метод
                    System.setIn(System.in); // Возвращаем поток ввода в исходное состояние
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }












//    private CalculatorController controller;
//    private CalculatorModel model;
//    private CalculatorView view;

//    @BeforeEach
//    public void setUp() {
//        model = new CalculatorModel(); // Простой стаб для CalculatorModel
//        view = new CalculatorView(); // Простой стаб для CalculatorView
//        controller = new CalculatorController(model, view);
//    }
//
//    @Test
//    public void testPerformOperationWithArithmeticException() {
//        // Устанавливаем ввод пользователя: первое число = 5, второе число = 0
//        System.setIn(new ByteArrayInputStream("5\n0\n".getBytes()));
//
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//
//        controller.run();
//
//        // Проверяем, что было вызвано сообщение об ошибке с правильным сообщением
//        assertTrue(outContent.toString().contains("Ошибка: Деление на ноль"));
//
//        // Восстанавливаем стандартный поток вывода и ввода
//        System.setIn(System.in);
//        System.setOut(System.out);
//    }


}
