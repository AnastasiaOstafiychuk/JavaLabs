import java.util.Objects;

public class Animal implements Comparable<Animal> {
    protected String name;

    protected double age;

    protected String sex;

    public Animal(String name, double age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public int compareTo(Animal other) {
        return this.name.compareTo(other.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "   name = " + name + ",\n" +
                "   age = " + age + ",\n" +
                "   sex = " + sex + "\n";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Animal animal = (Animal) object;
        return Objects.equals(name, animal.name) &&
                Objects.equals(age, animal.age) &&
                Objects.equals(sex, animal.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

}
