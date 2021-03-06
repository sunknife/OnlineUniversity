import java.io.EOFException;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        //Error ref = new Error(); // создаем экземпляр
        //throw ref;               // "бросаем" его
        //f(null);
        //System.out.println("sout");
        //throw new Error();
        //double d = sqr3(10.);
        //System.out.println(d);
        //int area = area(-3, 4);
//        try {
//            System.err.print(" 0");
//            if (true) {throw new RuntimeException();}
//            System.err.print(" 1");
//        } catch (Exception e) { // catch по Exception ПЕРЕХВАТЫВАЕТ RuntimeException
//            System.err.print(" 2");
//        }
//        System.err.println(" 3");
//        try {
//            System.err.print(" 0");
//            if (true) {throw new Exception();}
//            System.err.print(" 1");
//        } catch (RuntimeException e) {
//            System.err.print(" 2");
//        }
//        System.err.print(" 3");
//        try {
//            Throwable t = new Exception(); // ссылка типа Throwable указывает на объект типа Exception
//            throw t;
//        } catch (RuntimeException e) {
//            System.err.println("catch RuntimeException");
//        } catch (Exception e) {
//            System.err.println("catch Exception");
//        } catch (Throwable e) {
//            System.err.println("catch Throwable");
//        }
//        System.err.println("next statement");
//        try {
//            throw new RuntimeException();
//        } finally {
//            System.err.println("finally");
//        }
//        try {
//            System.err.println("try");
//            throw new RuntimeException();
//        } finally {
//            System.err.println("finally");
//        }
//        System.err.println("more");
//        f0();
//        f1();
//        try {
//            throw new Throwable();
//        } catch (Exception e) {
//            // ...
//        }
//        try {
//            throw new Exception();
//        } catch (Error e) {
//            // ...
//        }
//        Throwable t = new Exception(); // и лететь будет Exception
//        throw t; // но тут ошибка компиляции
//        try {
//            Throwable t = new Exception(); // а лететь будет Exception
//            throw t;
//        } catch (Exception e) { // и мы перехватим Exception
//            System.out.println("Перехвачено!");
//        }

    }


//    public static void f2(Throwable t) throws Exception {
//        throw t;
//    }
//    public static void f3(Object ref){
//        char c = ref.charAt(0);
//    }
    public static void f0() throws EOFException {}
    public static void f1() throws FileNotFoundException {}

    public static int area(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Negative sizes: w = " + width + ", h = " + height);
        }
        return width * height;
    }


    public static double sqr3(double arg) {
        throw new RuntimeException();
    }

    public static double sqr2(double arg) {
        if (System.currentTimeMillis() % 2 == 0) {
            return arg * arg; // ну ладно, вот твой double
        } else {
            while (true);     // а тут "виснем" навсегда
        }
    }

    public static double sqr(double arg) { // надо double
        int k = 1;                  // есть int
        return k;                   // можно неявно преобразовать int в double
    }

    public static void f(NullPointerException e) {
        try {
            throw e;
        } catch (NullPointerException npe) {
            f(npe);
        }
    }



}

