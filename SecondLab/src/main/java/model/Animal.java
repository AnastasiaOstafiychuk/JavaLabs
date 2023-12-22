package model;

import java.util.Objects;

public class Animal {
    protected String name;

    protected int age;

    protected String sex;

    public Animal() {}
    public Animal(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {return name;}

    public int getAge() {return age;}

    public String getSex() {return sex;}


    public void setName(String name) {this.name = name;}

    public void setAge(int age) {this.age = age;}

    public void setSex(String sex) {this.sex = sex;}


    @Override
    public String toString() {
        return  "   name = " + name + ",\n" +
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
