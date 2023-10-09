package classwork.tdd;

import java.util.ArrayList;
import java.util.List;

// HW_3
// Задание №7
// Добавьте класс UserRepository для управления пользователями. В этот класс должен быть включен метод
// addUser, который добавляет пользователя в систему, если он прошел аутентификацию.
// Покройте тестами новую функциональность
public class UserRepository {
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        if (user != null && !findByName(user.getName())) {
            data.add(user);
        }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.getName().equals(username)) {
                return true;
            }
        }
        return false;
    }
    // public void logoutAllUsers(User[] users) {
    //     if (users != null) {
    //         for (User user : users) {
    //             if (user != null && !user.isAdmin()) {
    //                 user.setAuthenticate(false);
    //             }
    //         }
    //     }
    // }
}