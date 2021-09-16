public class Refueller {
    private String name;
    private CarRefueller car;

    public Refueller(String name, CarRefueller car) {
        this.name = name;
        this.car = car;
    }

    public void setCar(CarRefueller car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarRefueller getCar() {
        return car;
    }

    @Override
    public String toString() {
        return "Refueller{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}
