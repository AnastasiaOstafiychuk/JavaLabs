package model;

import java.util.Objects;

public class Bird extends Animal {
    private int wingspan = 0;

    private String beakType = "";

    public Bird() {
        super();
    }
    public Bird(String name, int age, String sex, int wingspan, String beakType) {
        super(name, age, sex);
        this.wingspan = wingspan;
        this.beakType = beakType;
    }

    public int getWingspan() {return wingspan;}

    public String getBeakType() {return beakType;}

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
