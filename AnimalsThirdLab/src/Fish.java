import java.util.Objects;

public class Fish extends Animal {
    private final String scaleType;
    private final double swimmingSpeed;

    public Fish(String name, double age, String sex,
                String scaleType, double swimmingSpeed) {
        super(name, age, sex);
        this.scaleType = scaleType;
        this.swimmingSpeed = swimmingSpeed;
    }

    @Override
    public String toString() {
        return "Fish {" + '\n' +
                super.toString() +
                "   scaleType = " + scaleType + ",\n" +
                "   swimmingSpeed = " + swimmingSpeed + "\n}";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Fish fish = (Fish) object;
        return swimmingSpeed == fish.swimmingSpeed &&
                Objects.equals(scaleType, fish.scaleType) &&
                super.equals(object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), scaleType, swimmingSpeed);
    }
}
