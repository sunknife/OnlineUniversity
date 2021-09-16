import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Car honda = new Car("Honda Civic",LocalDate.of(2010, 1,20), Car.EngineType.OIL,30,15,20);
        Driver driver = new Driver("Oleg", LocalDate.of(1980,5,20),honda);
        Refueller refueller = new Refueller("Vasyl", honda);
        Accumulator accumulator = new Accumulator("XV310", "Honda", honda);
        System.out.println(driver);
        System.out.println(refueller);
        System.out.println(honda);
    }
}
