package model;

public class BadBirthDateException extends Exception {
    String string;

    public BadBirthDateException(String string) {
        this.string = string;
    }

    @Override
    public String getMessage() {
        return "Ошибка с форматом вводы даты " + string + "Дата должна быть форматом: дд.мм.гггг" + "\n";
    }
}
