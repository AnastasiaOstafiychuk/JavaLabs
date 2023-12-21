import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnimalServiceWithoutStream implements AnimalService {
    private final List<Animal> animals;

    AnimalServiceWithoutStream(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public List<Animal> searchAnimalsByName(String animalName) {
        List<Animal> result = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getName().equals(animalName)) {
                result.add(animal);
            }
        }
        return result;
    }

    @Override
    public List<Animal> sortAnimalsByAnimalName() {
        List<Animal> result = animals;
        Collections.sort(result);
        return result;
    }


    @Override
    public List<Animal> searchAnimalsAfterAge(double age) {
        List<Animal> result = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getAge() > age) {
                result.add(animal);
            }
        }
        return result;
    }


}
