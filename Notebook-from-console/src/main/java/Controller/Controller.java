package Controller;

import Model.Model;
import Model.entity.NotUniqueLoginException;
import Model.entity.NoteBook;
import View.View;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void  processUser(){
        Scanner scanner = new Scanner(System.in);
        InputNoteBook inputNoteBook = new InputNoteBook(view, scanner);
        inputNoteBook.inputNote();

        NoteBook noteBook = getNoteBook(inputNoteBook);
        System.out.println(noteBook);
    }

    private NoteBook getNoteBook(InputNoteBook inputNoteBook) {
        NoteBook noteBook = null;
        while (true) {
            try {
                noteBook = new NoteBook(inputNoteBook.getFirstName(), inputNoteBook.getNickname());
                break;
            } catch (NotUniqueLoginException e) {
                e.printStackTrace();
                System.out.println("Login " + e.getLoginData() + " is already created") ;
                inputNoteBook.inputNickname();
            }
        }
        return  noteBook;
    }
}
