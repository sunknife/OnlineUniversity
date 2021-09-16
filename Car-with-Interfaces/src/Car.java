import java.time.LocalDate;

public class Car implements  CarAccumulator, CarDriver, CarRefueller {


    public enum EngineType {DIESEL, ELECTRIC, OIL}
    private EngineType engineType;
    private int tankVolume;
    private String carName;
    private LocalDate carAge;
    private double accumulatorBoxHeight;
    private double accumulatorBoxWidth;

    public Car(String carName, LocalDate carAge, EngineType engineType, int tankVolume, double accumulatorBoxHeight, double accumulatorBoxWidth){
        this.carName = carName;
        this.carAge = carAge;
        this.engineType = engineType;
        this.tankVolume = tankVolume;
        this.accumulatorBoxHeight = accumulatorBoxHeight;
        this.accumulatorBoxWidth = accumulatorBoxWidth;
    }

    @Override
    public double accumulatorHeight() {
        return accumulatorBoxHeight;
    }

    @Override
    public double accumulatorWidth() {
        return accumulatorBoxWidth;
    }

    @Override
    public String carName() {
        return carName;
    }

    @Override
    public LocalDate carAge() {
        return carAge;
    }

    @Override
    public EngineType engineType() {
        return engineType;
    }

    @Override
    public int tankVolume() {
        return tankVolume;
    }

    public double getAccumulatorBoxHeight() {
        return accumulatorBoxHeight;
    }

    public double getAccumulatorBoxWidth() {
        return accumulatorBoxWidth;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public int getTankVolume() {
        return tankVolume;
    }

    public LocalDate getCarAge() {
        return carAge;
    }

    public String getCarName() {
        return carName;
    }

    public void setAccumulatorBoxHeight(double accumulatorBoxHeight) {
        this.accumulatorBoxHeight = accumulatorBoxHeight;
    }

    public void setAccumulatorBoxWidth(double accumulatorBoxWidth) {
        this.accumulatorBoxWidth = accumulatorBoxWidth;
    }

    public void setCarAge(LocalDate carAge) {
        this.carAge = carAge;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public void setTankVolume(int tankVolume) {
        this.tankVolume = tankVolume;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engineType=" + engineType +
                ", tankVolume=" + tankVolume +
                ", carName='" + carName + '\'' +
                ", carAge=" + carAge +
                ", accumulatorBoxHeight=" + accumulatorBoxHeight +
                ", accumulatorBoxWidth=" + accumulatorBoxWidth +
                '}';
    }
}




