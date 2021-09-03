package View;

import java.util.Locale;
import java.util.ResourceBundle;

import static View.TextConstants.INPUT_STRING_DATA;
import static View.TextConstants.INPUT_WRONG_DATA;

public class View {

    static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME,new Locale("ua"));

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printStringInput(String message) {
        printMessage(bundle.getString(INPUT_STRING_DATA)+bundle.getString(message));
    }

    public void printWrongStringInput(String message) {
        printMessage(bundle.getString(INPUT_WRONG_DATA) + bundle.getString(INPUT_STRING_DATA) + bundle.getString(message));
    }
}
