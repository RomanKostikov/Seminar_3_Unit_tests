package homework.task002.tdd;

public class User {
    String name;
    String password;

    Role userRole;

    boolean isAuthenticate = false;

    public User(String name, String password, Role userRole) {
        this.name = name;
        this.password = password;
        this.userRole = userRole;
    }

    /**
     * Авторизация пользователя
     *
     * @param name     имя пользователя
     * @param password пароль пользователя
     * @return успешная авторизация - true иначе false
     */
    public boolean authenticate(String name, String password) {
        this.isAuthenticate = (this.name.equals(name) && this.password.equals(password));
        return this.isAuthenticate;
    }

    /**
     * Является ли пользователь администратором
     *
     * @return true если является, иначе false
     */
    public boolean isRoleAdmin() {
        return this.userRole.equals(Role.ADMIN);
    }

}