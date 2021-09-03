package Controller;

public interface RegexContainer {
    String REGEX_NAME_LAT = "[A-Z][a-z]{1,20}";

    String REGEX_NAME_UKR = "[А-ЩЬЮЯІЇЄ][а-щьюяіїє']{1,19}[а-щьюяіїє]";

    String REGEX_SURNAME_LAT = "[A-Za-z]+ ?([A-Z][a-z]+)?";

    String REGEX_SURNAME_UKR = "[А-ЩЬЮЯІЇЄа-щьюяіїє][а-щьюяіїє']+[ -]?([А-ЩЬЮЯІЇЄ][а-щьюяіїє']+[а-щьюяіїє])?";

    String REGEX_NICKNAME = "[A-Za-z0-9_-]{8,20}";

    String REGEX_COMMENT = "[\\w\\s]+";

    String REGEX_PHONE = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";

    String REGEX_EMAIL = "[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+";

    String REGEX_POSTAL_CODE ="\\d{5}";

    String REGEX_STREET_NAME_UKR = "[а-щьюяіїє]{3,8}.?\\s[А-ЩЬЮЯІЇЄ][а-щьюяіїє']{2,15}-?\\s?[А-ЩЬЮЯІЇЄ]?[а-щьюяіїє]{2,15}?";

    String REGEX_STREET_NAME_LAT = "[A-Z][a-z]+(\\s[A-Za-z][a-z]+){1,}";

    String REGEX_HOUSE_NUMBER_UKR = "\\d{1,4}/?-?\\d{1,3}[абвгдєж]?";

    String REGEX_HOUSE_NUMBER_LAT = "\\d{1,}[/-]?(\\d+)?[a-z]?";

    String REGEX_APARTMENT_NUMBER = "\\d{1,4}";



}
