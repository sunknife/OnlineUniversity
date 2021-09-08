package Model.entity;

public class NoteBook {
    String firstName;
    String loginData;

    public NoteBook (String firstName, String loginData) throws NotUniqueLoginException {
            if (DBNoteBook.loginExist(loginData)) throw new NotUniqueLoginException("This login already exist.",loginData);
            this.firstName = firstName;
            this.loginData = loginData;
    }
}
