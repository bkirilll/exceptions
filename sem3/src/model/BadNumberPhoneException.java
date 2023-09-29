package model;

public class BadNumberPhoneException extends Exception {

    String string;

    public BadNumberPhoneException(String string) {
        this.string = string;
    }

    @Override
    public String getMessage() {
        return "Ошибка с форматом ввода телефона " + string + "\n";
    }
}
