package classwork.tdd;

// HW_3
// ������� �6
// ������������ ����� User � ������� �������������� �� ������ � ������.
// ����� ������ ���������� true, ���� ��������� ����� � ������ ���������, ����� false.
// ������������� ��� ������

public class User {
    private String name;
    private String password;
    private boolean isAuthenticate = true;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
    }

    public boolean authenticate(String inputUsername, String inputPassword) {
        return name.equals(inputUsername) && password.equals(inputPassword);
    }

    public boolean isAuthenticate() {
        return isAuthenticate;
    }

    public void setAuthenticate(boolean isAuthenticated) {
        this.isAuthenticate = isAuthenticated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}