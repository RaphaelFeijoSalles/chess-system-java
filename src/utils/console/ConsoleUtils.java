package utils.console;


import utils.console.errors.ErrorHandler;

public class ConsoleUtils {

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        }
        catch (Exception e) {
            ErrorHandler.handle(e);
        }
    }
}
