import java.util.List;

public interface AnimalService {

    List<Animal> searchAnimalsByName(String animalName);

    List<Animal> sortAnimalsByAnimalName();

    List<Animal> searchAnimalsAfterAge(double animalAge);
}
