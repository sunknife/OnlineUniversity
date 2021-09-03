package Controller;

import View.View;

import java.util.Scanner;

import static Controller.RegexContainer.*;
import static View.TextConstants.*;

public class InputNoteBook {

    private View view;
    private Scanner scanner;

    private String firstName;
    private String nickname;
    private String comment;
    private String home_phone_number;
    private String email;
    private String streetAddress;
    private String houseNumber;

    public InputNoteBook(View view, Scanner scanner){
        this.view = view;
        this.scanner = scanner;
    }

    public void inputNote() {
        UtilityController utilityController = new UtilityController(view, scanner);
        String localeName = (String.valueOf(View.bundle.getLocale()).equals("ua")) ? REGEX_NAME_UKR: REGEX_NAME_LAT;
        String houseNumberLocale = (String.valueOf(View.bundle.getLocale()).equals("ua")) ? REGEX_HOUSE_NUMBER_UKR : REGEX_HOUSE_NUMBER_LAT;
        String streetAddressLocale = (String.valueOf(View.bundle.getLocale()).equals("ua")) ? REGEX_STREET_NAME_UKR : REGEX_STREET_NAME_LAT;
        this.firstName = utilityController.inputStringValueWithScanner(FIRST_NAME, localeName);
        this.nickname = utilityController.inputStringValueWithScanner(NICKNAME,REGEX_NICKNAME);
        this.comment = utilityController.inputStringValueWithScanner(COMMENT, REGEX_COMMENT);
        this.home_phone_number = utilityController.inputStringValueWithScanner(HOME_PHONE,REGEX_PHONE);
        this.email = utilityController.inputStringValueWithScanner(EMAIL, REGEX_EMAIL);
        this.streetAddress = utilityController.inputStringValueWithScanner(STREET_ADDRESS, streetAddressLocale);
        this.houseNumber = utilityController.inputStringValueWithScanner(HOUSE_NUMBER, houseNumberLocale);
    }
}
