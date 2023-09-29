package view;

import java.util.Scanner;

public class View {

    Scanner scanner = new Scanner(System.in);

    public void print(String data) {
        System.out.printf("%s", data);
    }

    public String getInput(String data) {
        System.out.printf("%s", data);
        return scanner.nextLine();
    }
}
