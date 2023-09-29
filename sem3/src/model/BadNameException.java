package model;

public class BadNameException extends Exception {

    String string;

    public BadNameException(String string) {
        this.string = string;
    }

    @Override
    public String getMessage() {
        return "Ошибка с форматом вводы фио " + string + "\n";
    }
}
