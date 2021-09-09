import java.util.Date;

public class ImmutableObjects {
    public static void main(String[] args) {
        Flower camomile = new Flower("camomile", "white", new Date());
        Flower secondCamomile = camomile.newSeed(new Date());
        Flower tulip = new Flower("tulip", "red", new Date());
        System.out.println(camomile);
        System.out.println(secondCamomile);
        System.out.println(tulip);
        System.out.println("Tulip seed date = " + tulip.getSeedDate());
    }
}

final class Flower {
    private final String name;
    private final String color;
    private final Date seedDate;

    public Flower(String name, String color, Date seedDate) {
        this.name = name;
        this.color = color;
        this.seedDate = new Date(seedDate.getTime());

    }

    public Flower newSeed(Date seedDate) {
        Flower newSeed = new Flower(this.name, this.color, seedDate);
        return newSeed;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Date getSeedDate() {
        Date cloneSeedDate = new Date(seedDate.getTime());
        return cloneSeedDate;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + getName() + '\'' +
                ", color='" + getColor() + '\'' +
                ", seedDate=" + getSeedDate() +
                '}';
    }
}


