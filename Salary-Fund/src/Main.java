import controller.Controler;
import model.Model;
import view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controler controler = new Controler(view, model);
        controler.processUser();
    }
}
