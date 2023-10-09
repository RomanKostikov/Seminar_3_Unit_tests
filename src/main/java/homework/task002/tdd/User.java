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
     * ����������� ������������
     *
     * @param name     ��� ������������
     * @param password ������ ������������
     * @return �������� ����������� - true ����� false
     */
    public boolean authenticate(String name, String password) {
        this.isAuthenticate = (this.name.equals(name) && this.password.equals(password));
        return this.isAuthenticate;
    }

    /**
     * �������� �� ������������ ���������������
     *
     * @return true ���� ��������, ����� false
     */
    public boolean isRoleAdmin() {
        return this.userRole.equals(Role.ADMIN);
    }

}