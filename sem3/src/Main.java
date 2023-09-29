import controller.Controller;
import view.View;

public class Main {
    public static void main(String[] args) {
        Controller<View> dataWritter = new Controller<View>(new View());
        dataWritter.start();
    }
}