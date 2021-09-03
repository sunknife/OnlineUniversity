package Controller;

import View.View;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.Scanner;

import static Controller.RegexContainer.*;
import static View.TextConstants.*;

public class InputNoteBook {

    private View view;
    private Scanner scanner;

    private String firstName;
    private String surname;
    private String fatherName;
    private String nickname;
    private String comment;
    private String homePhoneNumber;
    private String mobilePhoneNumber;
    private String email;
    private String skypeLogin;
    private String postalCode;
    private String streetAddress;
    private String houseNumber;
    private String apartmentNumber;
    private Date noteCreationDate;


    public InputNoteBook(View view, Scanner scanner){
        this.view = view;
        this.scanner = scanner;
    }

    public void inputNote() {
        UtilityController utilityController = new UtilityController(view, scanner);
        String localeName = (String.valueOf(View.bundle.getLocale()).equals("ua")) ? REGEX_NAME_UKR: REGEX_NAME_LAT;
        String houseNumberLocale = (String.valueOf(View.bundle.getLocale()).equals("ua")) ? REGEX_HOUSE_NUMBER_UKR : REGEX_HOUSE_NUMBER_LAT;
        String streetAddressLocale = (String.valueOf(View.bundle.getLocale()).equals("ua")) ? REGEX_STREET_NAME_UKR : REGEX_STREET_NAME_LAT;
        String surnameLocale = (String.valueOf(View.bundle.getLocale()).equals("ua"))  ? REGEX_SURNAME_UKR : REGEX_SURNAME_LAT;
        this.firstName = utilityController.inputStringValueWithScanner(FIRST_NAME, localeName);
        this.surname = utilityController.inputStringValueWithScanner(SURNAME, surnameLocale);
        this.fatherName = utilityController.inputStringValueWithScanner(FATHER_NAME, localeName);
        this.nickname = utilityController.inputStringValueWithScanner(NICKNAME,REGEX_NICKNAME);
        this.comment = utilityController.inputStringValueWithScanner(COMMENT, REGEX_COMMENT);
        this.homePhoneNumber = utilityController.inputStringValueWithScanner(HOME_PHONE,REGEX_PHONE);
        this.mobilePhoneNumber = utilityController.inputStringValueWithScanner(MOBILE_PHONE, REGEX_PHONE);
        this.email = utilityController.inputStringValueWithScanner(EMAIL, REGEX_EMAIL);
        this.skypeLogin = utilityController.inputStringValueWithScanner(SKYPE_LOGIN, REGEX_NICKNAME);
        this.postalCode = utilityController.inputStringValueWithScanner(POSTAL_CODE, REGEX_POSTAL_CODE);
        this.streetAddress = utilityController.inputStringValueWithScanner(STREET_ADDRESS, streetAddressLocale);
        this.houseNumber = utilityController.inputStringValueWithScanner(HOUSE_NUMBER, houseNumberLocale);
        this.apartmentNumber = utilityController.inputStringValueWithScanner(APARTMENT_NUMBER, REGEX_APARTMENT_NUMBER);
        this.noteCreationDate = new Date();

    }
}
