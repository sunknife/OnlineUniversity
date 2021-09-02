package Controller;

public interface RegexContainer {
    String REGEX_NAME_LAT = "[A-Z][a-z]{1,20}";

    String REGEX_NAME_UKR = "[А-ЩЬЮЯІЇЄ][а-щьюяіїє']{1,19}[а-щьюяіїє]";

    String REGEX_NICKNAME = "[A-Za-z0-9_-]{8,20}";

    String REGEX_COMMENT = "[\\w\\s]+";

    String REGEX_PHONE = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";

    String REGEX_EMAIL = "[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+";





}
