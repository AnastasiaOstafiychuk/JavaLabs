import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bird woodpecker1 = new Bird(
                "Woodpecker",
                6.0,
                "Male",
                66.0,
                "Chisel-like Beaks"
        );

        Bird woodpecker2 = new Bird(
                "Woodpecker",
                25.5,
                "Female",
                220.0,
                "Chisel-like Beaks"
        );

        Fish carp2 = new Fish(
                "Carp",
                10,
                "Female",
                "Carp have an even, regular scale pattern",
                1.09
        );

        Fish carp1 = new Fish(
                "Carp",
                15,
                "Male",
                "Carp have an even, regular scale pattern",
                1.09
        );

        Reptile crocodile1 = new Reptile(
                "Crocodile",
                40,
                "Female",
                "Covered with keratinized scales",
                175
        );

        Reptile crocodile2 = new Reptile(
                "Crocodile",
                50,
                "Male",
                "Covered with keratinized scales",
                180
        );

        List<Animal> animals = new ArrayList<>();
        animals.add(woodpecker1);
        animals.add(woodpecker2);
        animals.add(carp1);
        animals.add(carp2);
        animals.add(crocodile1);
        animals.add(crocodile2);

        Zoo zoo1 = new Zoo.ZooBuilder("Zoo1")
                .addAnimals(woodpecker1)
                .addAnimals(crocodile2)
                .addAnimals(crocodile1)
                .build();

        Zoo zoo2 = new Zoo.ZooBuilder("Zoo2")
                .addAnimals(woodpecker2)
                .addAnimals(crocodile1)
                .addAnimals(crocodile2)
                .addAnimals(carp1)
                .addAnimals(carp2)
                .build();

        Zoo zoo3 = new Zoo.ZooBuilder("Zoo3")
                .addAnimals(carp1)
                .addAnimals(crocodile1)
                .addAnimals(carp2)
                .addAnimals(woodpecker2)
                .build();

        AnimalService serviceWithStream = new AnimalServiceWithStream(animals);
        AnimalService serviceWithoutStream = new AnimalServiceWithoutStream(animals);


        // Пошук подій за назвою
        System.out.println("Search animals by name:");
        List<Animal> searchResultWithStream = serviceWithStream.searchAnimalsByName("Woodpecker");
        List<Animal> searchResultWithoutStream = serviceWithoutStream.searchAnimalsByName("Woodpecker");
        System.out.println("With Stream API: " + searchResultWithStream);
        System.out.println("Without Stream API: " + searchResultWithoutStream);

        // Сортування подій за назвою
        System.out.println("\nSort animals by name:");
        List<Animal> sortedNameWithStream = serviceWithStream.sortAnimalsByAnimalName();
        List<Animal> sortedNameWithoutStream = serviceWithoutStream.sortAnimalsByAnimalName();
        System.out.println("With Stream API: " + sortedNameWithStream);
        System.out.println("Without Stream API: " + sortedNameWithoutStream);


        System.out.println("\nSearch animals after a age:");
        List<Animal> animalsAfterAgeWithStream = serviceWithStream.searchAnimalsAfterAge(30);
        List<Animal> animalsAfterAgeWithoutStream = serviceWithoutStream.searchAnimalsAfterAge(30);
        System.out.println("With Stream API: " + animalsAfterAgeWithStream);
        System.out.println("Without Stream API: " + animalsAfterAgeWithoutStream);
    }

}