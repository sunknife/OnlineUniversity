package Controller;

import View.View;

import java.util.Scanner;

public class UtilityController {
    private Scanner scanner;
    View view;

    public UtilityController(View view, Scanner scanner){
        this.view = view;
        this.scanner = scanner;
    }

    public String inputStringValueWithScanner(String message, String regEx){
        String result;
        view.printStringInput(message);
        while ( !(scanner.hasNext() && (result = scanner.next()).matches(regEx)) ){
            view.printWrongStringInput(message);
        }
        return result;
    }
}
