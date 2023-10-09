package homework.task002.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {
    public UserRepository userRepository; // временно можно открыть данный класс
    public User userActual;
    public User userFail;

    /**
     * Создаем объект репозитория,
     * Пользователя удовлетворяющего условиям теста,
     * Пользователя не удовлетворяющего условиям теста.
     */
    @BeforeEach
    public void setUp() {
        userRepository = new UserRepository();
        userActual = new User("someName", "somePassword", Role.ADMIN);
        userFail = new User("someName", "somePassword", Role.USER);
    }

    /**
     * Тестирование добавления пользователя в лист аутентифицированных пользователей.
     * Аутентифицируем пользователя,
     * добавляем пользователя в лист,
     * проверяем размер листа,
     * тест удовлетворяет условиям если размер листа равен 1
     */
    @Test
    void checkAddUserPositive() {
        userActual.authenticate("someName", "somePassword");
        userRepository.addUser(userActual);
        int expectListSize = 1;
        assertEquals(expectListSize, userRepository.data.size());
    }

    /**
     * Тестирование получения исключения при попытке добавления не аутентифицированного пользователя
     * в лист аутентифицированных пользователей.
     * Пытаемся аутентифицировать пользователя заведомо ложными данными,
     * Ловим исключение при попытке добавить в лист,
     * Проверяем сообщение полученного исключения.
     */
    @Test
    void checkExceptionWithAddUser() {
        userFail.authenticate("wrongName", "wrongPassword");
        Exception exception = assertThrows(RuntimeException.class, () -> userRepository.addUser(userActual));
        String message = "wrong login or password!";
        assertEquals(message, exception.getMessage());
    }

    /**
     * Тестирование успешного поиска пользователя в листе аутентифицированных пользователей по его имени.
     * Аутентифицируем пользователя,
     * добавляем в лист,
     * Ожидаем успешное завершение теста при проверке наличия добавленного пользователя в листе.
     */
    @Test
    void checkFindByNamePositive() {
        userActual.authenticate("someName", "somePassword");
        userRepository.addUser(userActual);
        assertTrue(userRepository.findByName("someName"));
    }

    /**
     * Тестирование неудачного поиска пользователя в листе аутентифицированных пользователей по его имени.
     * Аутентифицируем пользователя,
     * добавляем в лист,
     * Ожидаем успешное завершение теста при проверке наличия заведомо несуществующего пользователя в листе.
     */
    @Test
    void checkFindByNameNegative() {
        userActual.authenticate("someName", "somePassword");
        userRepository.addUser(userActual);
        assertFalse(userRepository.findByName("wrongName"));
    }

    /**
     * Тестирование удаления пользователей из списка аутентифицированных пользователей
     * при отсутствии роли администратора.
     * Аутентифицируем пользователей:
     * userActual - имеет роль администратора;
     * userFail - имеет роль пользователя;
     * Удаляем пользователей ил листа без роли администратора.
     * Тест успешен если размер листа равен 1.
     */
    @Test
    void checkLogOutExceptAdministrator() {
        userActual.authenticate("someName", "somePassword");
        userFail.authenticate("someName", "somePassword");
        userRepository.addUser(userActual);
        userRepository.addUser(userFail);
        userRepository.logOutExceptAdministrator();
        int expectListSize = 1;
        assertEquals(expectListSize, userRepository.data.size());
    }

}
