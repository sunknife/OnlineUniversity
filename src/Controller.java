import java.util.Scanner;

public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        view.print(View.WELCOME_MESSAGE);
        int input = -1;
        model.generateChosenNumber();
        while (input != model.getChosenNumber()) {
            view.print("Your tries: " + model.getTries().toString() + "\nEnter number in range from " + model.getLowerMargin() + " to " + model.getUpperMargin());
            input = getTryFromUser(scanner);
            model.addTry(input);
            if (input == model.getChosenNumber()) {
                view.print(View.WIN);
                view.print(model.getTries().toString());
            } else if (input > model.getChosenNumber() && input < model.getUpperMargin()) {
                model.setUpperMargin(input);
            } else if (input < model.getChosenNumber() && input > model.getLowerMargin()) {
                model.setLowerMargin(input);
            }
        }

    }

    private int getTryFromUser(Scanner scanner){
        while (!scanner.hasNextInt()){
            view.print(View.WRONG_INPUT);
            scanner.next();
        }
        return scanner.nextInt();
    }
}
