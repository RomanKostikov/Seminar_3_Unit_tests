package classwork.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
// HW_3
// Задание №7
// Добавьте класс UserRepository для управления пользователями. В этот класс должен быть включен метод
// addUser, который добавляет пользователя в систему, если он прошел аутентификацию.
// Покройте тестами новую функциональность

public class UserRepositoryTest {
    private UserRepository userRepository;
    private List<User> data;

    @BeforeEach
    public void setUp() {
        userRepository = new UserRepository();
        data = new ArrayList<>();
    }

    @Test
    public void testAddUser() {
        User user = new User("username", "password", false);
        userRepository.addUser(user);

        data = userRepository.data;
        Assertions.assertEquals(1, data.size());
        Assertions.assertTrue(data.contains(user));
    }

    @Test
    public void testFindByName_True_WhenUserExists() {
        User user = new User("username", "password", false);
        userRepository.addUser(user);

        boolean result = userRepository.findByName("username");
        Assertions.assertTrue(result);
    }

    @Test
    public void testFindByName_False_UserNotExists() {
        User user = new User("username", "password", false);
        userRepository.addUser(user);

        boolean result = userRepository.findByName("username2");
        Assertions.assertFalse(result);
    }

    @Test
    public void testFindByName_False_WhenUserDoesNotExist() {
        boolean result = userRepository.findByName("username");
        Assertions.assertFalse(result);
    }

}
