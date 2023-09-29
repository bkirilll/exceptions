package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Data {

    public enum Gender {
        m, f
    }

    public static int dataSize = 6;
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate birthDate;
    private Long numberPhone;
    private Gender gender;

    public String getLastName() {
        return lastName;
    }

    public Data() {

    }

    public void checkData(String[] info) throws BadParsingException{
        if (info == null) {
            System.out.println("Пустая строка");
        }
        StringBuilder fullErrorsMessages = new StringBuilder();
        for (String string : info) {
            if (Character.isLetter(string.charAt(0))) {
                if (string.length() == 1) {
                    if (this.gender == null) {
                        try {
                            this.gender = checkGender(string);
                        } catch (BadGenderException e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else {
                        fullErrorsMessages.append("Гендер указан больше 1 раза\n");
                    }
                } else {
                    if (this.lastName == null) {
                        try {
                            this.lastName = checkName(string);
                        } catch (BadNameException e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else if (this.firstName == null) {
                        try {
                            this.firstName = checkName(string);
                        } catch (BadNameException e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else if (this.patronymic == null) {
                        try {
                            this.patronymic = checkName(string);
                        } catch (BadNameException e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else {
                        fullErrorsMessages.append("Слишком много элементов распознаны как ФИО.\n");
                    }
                }
            } else {

                if (string.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}")) {
                    if (this.birthDate == null) {
                        try {
                            this.birthDate = checkBirthDate(string);
                        } catch (BadBirthDateException e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else {
                        fullErrorsMessages.append("Дата рождения должна быть только одна, а обнаружены две: '"
                                + this.birthDate + "','" + string + "'\n");
                    }
                } else {
                    if (this.numberPhone == null) {
                        try {
                            this.numberPhone = checkNumberPhone(string);
                        } catch (BadNumberPhoneException e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else {
                        fullErrorsMessages.append("Должен быть только один телефонный номер, а не несколько: '"
                                + this.numberPhone + "','" + string + "'\n");
                    }
                }
            }
        }
        if (!fullErrorsMessages.isEmpty()) {
            throw new BadParsingException(fullErrorsMessages.toString());
        }
    }

    private String checkName(String string) throws BadNameException {
        if (string.toLowerCase().matches("^[a-za-яё]*$")) {
            return string;
        } else throw new BadNameException(string);
    }

    private long checkNumberPhone(String numberPhone) throws BadNumberPhoneException {
        if (numberPhone.length() == 10) {
            try {
                return Long.parseLong(numberPhone);
            } catch (NumberFormatException e) {
                throw new BadNumberPhoneException(numberPhone);
            }
        } else {
            throw new BadNumberPhoneException(numberPhone);
        }
    }

    private Gender checkGender(String string) throws BadGenderException {
        try {
            return Gender.valueOf(string);
        } catch (IllegalArgumentException e) {
            throw new BadGenderException(string);
        }
    }

    private LocalDate checkBirthDate(String string) throws BadBirthDateException {
        try {
            return LocalDate.parse(string, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            throw new BadBirthDateException(string);
        }
    }

    @Override
    public String toString() {
        return "<" + firstName + "><" + lastName + "><" + patronymic + "><" + birthDate + "><" + numberPhone + "><" + gender + ">";
    }
}
