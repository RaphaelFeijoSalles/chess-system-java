package utils.console.errors;

public class ErrorHandler {

    public static void handle(Exception e){
        System.out.println("Ocorreu um erro: " + e.getMessage());
    }
}
