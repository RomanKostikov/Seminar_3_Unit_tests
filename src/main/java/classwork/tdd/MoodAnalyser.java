package classwork.tdd;

// HW_3
// ������� �5
// ��������� ������ TDD ��� �������� ������ ������ MoodAnalyser, ������� ��������� ���������� ���������� �� ������.
public class MoodAnalyser {
    public String analyseMood(String message) {
        if (message.contains("refactor")) {
            return "Refactor";
        } else if (message.contains("falling")) {
            return "Write a falling test";
        } else {
            return "Make the test pass";
        }
    }
}
