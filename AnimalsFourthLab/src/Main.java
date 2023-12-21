public class Main {
    public static void main(String[] args) {
        Bird woodpecker = new Bird(
                "Woodpecker",
                6.0,
                "Male",
                66.0,
                "Chisel-like Beaks"
        );

        Fish pike = new Fish(
                "Pike",
                35.5,
                "Female",
                "Irregular rows of yellow or gold bean-shaped spots",
                4.75
        );

        Reptile varanusSalvator = new Reptile(
                "Varanus Salvator",
                11,
                "Male",
                "A black temporal band edged with yellow that extends back from each eye",
                114
        );

        Zoo zoo1 = new Zoo.ZooBuilder("Kyiv Zoo", "+380684539340")
                .addAnimals(woodpecker)
                .addAnimals(varanusSalvator)
                .build();

        Zoo zoo2 = new Zoo.ZooBuilder("", "testBadPhoneNumber")
                .addAnimals(woodpecker)
                .addAnimals(varanusSalvator)
                .addAnimals(pike)
                .addAnimals(woodpecker)
                .addAnimals(woodpecker)
                .build();

        Zoo zoo3 = new Zoo.ZooBuilder("Kyiv Zoo", "+380684539340")
                .build();

        System.out.println(zoo1);
        System.out.println(zoo2);
        System.out.println(zoo3);


    }
}