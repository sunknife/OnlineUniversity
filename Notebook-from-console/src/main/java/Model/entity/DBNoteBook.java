package Model.entity;

public enum DBNoteBook {
    NOTE_ONE("Ihor", "theCity1"), NOTE_TWO("Ilya", "sunknife2");
    private final String firstName;
    private final String login;

    DBNoteBook(String firstName, String login) {
        this.firstName = firstName;
        this.login = login;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLogin() {
        return login;
    }

    public static boolean loginExist(String login) {
        for (DBNoteBook value : DBNoteBook.values()) {
            if (value.getLogin().equals(login)) return true;
        }
        return false;
    }
}
