package model;

import java.util.Objects;

public class Reptile extends Animal {
    private String scaleType = "";

    private int tailLength = 0;

    public Reptile() {
        super();
    }

    public Reptile(String name, int age, String sex, String scaleType, int tailLength) {
        super(name, age, sex);
        this.scaleType = scaleType;
        this.tailLength = tailLength;
    }

    public String getScaleType() {return scaleType;}

    public int getTailLength() {return tailLength;}


    @Override
    public String toString() {
        return "Reptile {" + '\n' +
                super.toString() +
                "   scaleType = " + scaleType + ",\n" +
                "   tailLength = " + tailLength + ",\n}";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Reptile reptile = (Reptile) object;
        return tailLength == reptile.tailLength &&
                Objects.equals(scaleType, reptile.scaleType) &&
                super.equals(object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), scaleType, tailLength);
    }
}
