import java.time.LocalDate;

public class Driver {
    private String name;
    private LocalDate age;
    private CarDriver car;

    public Driver(String name, LocalDate age, CarDriver car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public void setCar(CarDriver car) {
        this.car = car;
    }

    public void setAge(LocalDate age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public CarDriver getCar() {
        return car;
    }

    public LocalDate getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
