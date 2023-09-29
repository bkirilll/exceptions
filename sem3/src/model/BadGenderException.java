package model;

public class BadGenderException extends Exception {

    String string;

    public BadGenderException(String string) {
        this.string = string;
    }

    @Override
    public String getMessage() {
        return "Ошибка с форматом вооды гендера " + string + " Поле должно быть f или m" + "\n";
    }
}
