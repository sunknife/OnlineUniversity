public class Accumulator {
    private String model;
    private String manufacturer;
    private CarAccumulator car;

    public Accumulator(String model, String manufacturer, CarAccumulator car){
        this.model = model;
        this.manufacturer = manufacturer;
        this.car = car;
    }

    public CarAccumulator getCar() {
        return car;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setCar(CarAccumulator car) {
        this.car = car;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Accumulator{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", car=" + car +
                '}';
    }
}
