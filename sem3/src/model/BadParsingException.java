package model;

public class BadParsingException  extends  Exception{
    String message;

    public BadParsingException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
