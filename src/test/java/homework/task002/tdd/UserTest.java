package homework.task002.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    public static User userActual;
    public static User userFail;

    /**
     * ������� ���� �������������:
     * userActual - ������������ ��������������� �������� �����
     * userFail - ������������ �� ��������������� �������� �����
     */
    @BeforeAll
    public static void createUsers() {
        userActual = new User("someName", "somePassword", Role.ADMIN);
        userFail = new User("someName", "somePassword", Role.USER);
    }

    /**
     * ������������ �������� �������������� ������������
     * ������� �������� �� ������ authenticate � ��������� ���� isAuthenticate - true
     */
    @Test
    void checkAuthenticatePositive() {
        userActual.authenticate("someName", "somePassword");
        assertTrue(userActual.isAuthenticate);
    }

    /**
     * ������������ ������������� �������������� ������������
     * ������� �������� �� ������ authenticate - false
     * ���� isAuthenticate �� ������������ ���������
     */
    @Test
    void checkAuthenticateNegative() {
        userFail.authenticate("wrongName", "wrongPassword");
        assertFalse(userFail.isAuthenticate);
    }

    /**
     * ������������ ������������� ���� ��������������
     * ��� ������������ ���������������� �������� �����
     * ������� �������� �� ������ isRoleAdmin() - true
     */
    @Test
    void checkIsRoleAdminPositive() {
        assertTrue(userActual.isRoleAdmin());
    }

    /**
     * ������������ ���������� ���� ��������������
     * ��� ������������ �� ���������������� �������� �����
     * ������� �������� �� ������ isRoleAdmin() - false
     */
    @Test
    void checkIsRoleAdminNegative() {
        assertFalse(userFail.isRoleAdmin());
    }
}
