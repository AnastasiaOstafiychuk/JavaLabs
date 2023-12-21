import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Zoo {
    private final String name;

    private final int countAnimals;

    private final List<Animal> animals;

    private Zoo(ZooBuilder builder) {
        this.name = builder.name;
        this.countAnimals = builder.countAnimals++;
        this.animals = new ArrayList<>(builder.animals);
    }

    public String getName() {
        return name;
    }

    public int getCountAnimals() {
        return countAnimals;
    }

    public List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Zoo {\n");
        builder.append("   name='").append(name).append("',\n");
        builder.append("   countAnimals=").append(countAnimals).append(",\n");

        builder.append("   animals=[");
        if (!animals.isEmpty()) {
            builder.append('\n');
            for (Animal animal : animals) {
                builder.append("      '").append(animal.getName()).append("',\n");
            }
            builder.deleteCharAt(builder.length() - 2);
        }
        builder.append("   ]\n");

        builder.append('}');
        return builder.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Zoo person = (Zoo) object;
        return countAnimals == person.countAnimals &&
                Objects.equals(name, person.name) &&
                Objects.equals(animals, person.animals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, countAnimals, animals);
    }

    public static class ZooBuilder {
        private final String name;
        private final List<Animal> animals = new ArrayList<>();
        private int countAnimals;

        public ZooBuilder(String name) {
            this.name = name;
        }

        public ZooBuilder addAnimals(Animal animal) {
            animals.add(animal);
            this.countAnimals++;
            return this;
        }

        public Zoo build() {
            return new Zoo(this);
        }
    }
}



