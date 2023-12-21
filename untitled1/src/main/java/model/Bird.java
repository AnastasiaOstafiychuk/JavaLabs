package model;

import java.util.Objects;

public class Bird extends Animal {
    private final double wingspan;
    private final String beakType;

    public Bird(String name, double age, String sex,
                double wingspan, String beakType) {
        super(name, age, sex);
        this.wingspan = wingspan;
        this.beakType = beakType;
    }

    @Override
    public String toString() {
        return "Bird {" + '\n' +
                super.toString() +
                "   wingspan = " + wingspan + ",\n" +
                "   beakType = " + beakType + "\n}";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Bird bird = (Bird) object;
        return wingspan == bird.wingspan &&
                Objects.equals(beakType, bird.beakType) &&
                super.equals(object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wingspan, beakType);
    }
}
