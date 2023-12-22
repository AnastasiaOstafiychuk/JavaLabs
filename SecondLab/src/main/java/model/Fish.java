package model;

import java.util.Objects;

public class Fish extends Animal {
    private String scaleType = "";
    private int swimmingSpeed = 0;

    public Fish() {
        super();
    }
    public Fish(String name, int age, String sex, String scaleType, int swimmingSpeed) {
        super(name, age, sex);
        this.scaleType = scaleType;
        this.swimmingSpeed = swimmingSpeed;
    }

    public String getScaleType() {return scaleType;}

    public int getSwimmingSpeed() {return swimmingSpeed;}

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
