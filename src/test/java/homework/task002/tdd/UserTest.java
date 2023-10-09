package homework.task002.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    public static User userActual;
    public static User userFail;

    /**
     * —оздаем двух пользователей:
     * userActual - пользователь удовлетвор€ющий услови€м теста
     * userFail - пользователь Ќ≈ удовлетвор€ющий услови€м теста
     */
    @BeforeAll
    public static void createUsers() {
        userActual = new User("someName", "somePassword", Role.ADMIN);
        userFail = new User("someName", "somePassword", Role.USER);
    }

    /**
     * “естирование успешной аутентификации пользовател€
     * ожидаем получить от метода authenticate и изменение пол€ isAuthenticate - true
     */
    @Test
    void checkAuthenticatePositive() {
        userActual.authenticate("someName", "somePassword");
        assertTrue(userActual.isAuthenticate);
    }

    /**
     * “естирование отрицательной аутентификации пользовател€
     * ожидаем получить от метода authenticate - false
     * поле isAuthenticate не подвергаетс€ изменению
     */
    @Test
    void checkAuthenticateNegative() {
        userFail.authenticate("wrongName", "wrongPassword");
        assertFalse(userFail.isAuthenticate);
    }

    /**
     * “естирование подтверждени€ роли администратора
     * дл€ пользовател€ удовлетвор€ющего услови€м теста
     * ожидаем получить от метода isRoleAdmin() - true
     */
    @Test
    void checkIsRoleAdminPositive() {
        assertTrue(userActual.isRoleAdmin());
    }

    /**
     * “естирование отсутстви€ роли администратора
     * дл€ пользовател€ Ќ≈ удовлетвор€ющего услови€м теста
     * ожидаем получить от метода isRoleAdmin() - false
     */
    @Test
    void checkIsRoleAdminNegative() {
        assertFalse(userFail.isRoleAdmin());
    }
}
