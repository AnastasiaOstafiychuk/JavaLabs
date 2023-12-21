import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalServiceWithStream implements AnimalService {

    private final List<Animal> animals;

    AnimalServiceWithStream(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public List<Animal> searchAnimalsByName(String animalName) {
        return animals.stream()
                .filter(animal -> animal.getName().equals(animalName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Animal> sortAnimalsByAnimalName() {
        return animals.stream()
                .sorted(Comparator.comparing(Animal::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Animal> searchAnimalsAfterAge(double age) {
        return animals.stream()
                .filter(animal -> animal.getAge() > age)
                .collect(Collectors.toList());
    }

}
