package source;

public class View {

    public static final String WELCOME_MESSAGE = "Hello, you should guess a number in range from " + Model.MIN_VALUE + " to " + Model.MAX_VALUE;
    public static final String TRY = "Your try: ";
    public static final String WRONG_INPUT = "This is not a number";
    public static final String WIN = "You guessed the number! Congratulation! \nYour tries were:";

    public void print(String message){
        System.out.println(message);
    }
}
