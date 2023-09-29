package controller;

import model.BadParsingException;
import model.Data;
import view.View;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Controller<V extends View> {
    private Data dataCheck;
    private V view;

    public Controller(V view) {
        this.view = view;
    }

    public void start() {
        boolean temp = true;
        do {
            String string = view.getInput("Введите данные через пробел: Фамилия Имя Отчество ДатаРождения Номер Пол, или q для выхода" + "\n");
            if (string.equals("q")) {
                temp = false;
                break;
            } else {
                String[] data = string.replaceAll("\\s+", " ").split(" ");
                int size = checkSizeData(data.length);
                if (size == -1) {
                    view.print("Мало данных" + "\n");
                } else if (size == 1) {
                    view.print("Много данных" + "\n");

                } else {
                    try {
                        dataCheck = new Data();
                        dataCheck.checkData(data);
                        writterFile(dataCheck);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (BadParsingException e) {
                        view.print(e.getMessage());
                    }
                }
            }
        } while (temp);
    }

    private int checkSizeData(int size) {
        if (size < Data.dataSize) {
            return -1;
        } else if (size > Data.dataSize) {
            return 1;
        } else {
            return size;
        }
    }

    private void writterFile(Data data) throws IOException {
        File file = new File(data.getLastName());
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.append(data.toString() + "\n");
        } catch (IOException e) {
            throw e;
        }
    }
}
