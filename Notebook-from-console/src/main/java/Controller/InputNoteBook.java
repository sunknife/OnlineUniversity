package Controller;

import View.View;

import java.util.Scanner;

import static Controller.RegexContainer.REGEX_NAME_LAT;
import static Controller.RegexContainer.REGEX_NAME_UKR;
import static View.TextConstants.FIRST_NAME;

public class InputNoteBook {

    private View view;
    private Scanner scanner;

    private String firstName;

    public InputNoteBook(View view, Scanner scanner){
        this.view = view;
        this.scanner = scanner;
    }

    public void inputNote() {
        UtilityController utilityController = new UtilityController(view, scanner);
        String string = (String.valueOf(View.bundle.getLocale()).equals("ua")) ? REGEX_NAME_UKR: REGEX_NAME_LAT;

        this.firstName = utilityController.inputStringValueWithScanner(FIRST_NAME, string);

    }
}
