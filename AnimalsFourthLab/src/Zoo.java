import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        private final String phoneNumber;
        private final List<Animal> animals = new ArrayList<>();
        private int countAnimals;

        public ZooBuilder(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public ZooBuilder addAnimals(Animal animal) {
            validateAnimal(animal);
            animals.add(animal);
            this.countAnimals++;
            return this;
        }

        private void validateAnimal(Animal animal) {
            if (animal == null) {
                throw new IllegalArgumentException("Animal cannot be null!");
            }
        }

        public Zoo build() {
            List<String> validationErrors = new ArrayList<>();

            try {
                validateName(this.name);
            } catch (IllegalArgumentException e) {
                validationErrors.add(e.getMessage());
            }

            try {
                validateCountAnimals(this.countAnimals);
            } catch (IllegalArgumentException e) {
                validationErrors.add(e.getMessage());
            }

            try {
                validatePhoneNumber(this.phoneNumber);
            } catch (IllegalArgumentException e) {
                validationErrors.add(e.getMessage());
            }


            if (!validationErrors.isEmpty()) {
                throw new IllegalArgumentException(String.join("\n", validationErrors));
            }

            return new Zoo(this);
        }

        private void validatePhoneNumber(String phoneNumber) {
            String regex = "\\+380\\d{9}";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(phoneNumber);

            if (!matcher.matches()) {
                System.out.println(matcher);
                throw new IllegalArgumentException("Invalid phone number!");
            }
        }

        private void validateCountAnimals(int countAnimals) {
            if (countAnimals == 0) {
                throw new IllegalArgumentException("The count of animals cannot be 0!");
            }

            if (countAnimals > 4) {
                throw new IllegalArgumentException("The count of animals cannot be more 4!");
            }
        }

        private void validateName(String name) {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Invalid name!");
            }
        }
    }
}



