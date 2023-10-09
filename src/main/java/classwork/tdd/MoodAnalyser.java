package classwork.tdd;

// HW_3
// Задание №5
// Примените подход TDD для создания нового класса MoodAnalyser, который оценивает настроение выраженное во фразах.
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
