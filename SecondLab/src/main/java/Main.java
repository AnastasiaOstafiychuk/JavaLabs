
import model.Bird;
import model.Fish;
import model.Reptile;

import org.example.services.JsonSerializer;
import org.example.services.XmlSerializer;
import org.example.services.TxtSerializer;



import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Bird woodpecker = new Bird (
                "Woodpecker",
                6,
                "Male",
                66,
                "Chisel-like Beaks"
        );
        Fish pike = new Fish (
                "Pike",
                35,
                "Female",
                "Irregular rows of yellow or gold bean-shaped spots",
                4
        );

        Reptile varanusSalvator = new Reptile(
                "Varanus Salvator",
                11,
                "Male",
                "A black temporal band edged with yellow that extends back from each eye",
                114
        );


        try {
            JsonSerializer<Bird> jsonSerializerBird = new JsonSerializer<>();
            jsonSerializerBird.serialize(woodpecker, "files/bird.json");
            Bird deserializedBird = jsonSerializerBird.deserialize("files/bird.json", Bird.class);
            System.out.println("Deserialized Bird: " + deserializedBird);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            XmlSerializer<Fish> xmlSerializerFish = new XmlSerializer<>();
            xmlSerializerFish.serialize(pike, "files/fish.xml");
            Fish xmlDeserializedFish = xmlSerializerFish.deserialize("files/fish.xml", Fish.class);
            System.out.println("XML Deserialized Fish: " + xmlDeserializedFish);

        } catch (IOException e) {
            e.printStackTrace();
        }


        try {

            TxtSerializer<Reptile> txtSerializerReptile = new TxtSerializer<>();
            txtSerializerReptile.serialize(varanusSalvator, "files/reptile.txt");

            Reptile txtDeserializedReptile = txtSerializerReptile.deserialize("files/reptile.txt", Reptile.class);
            System.out.println("TXT Deserialized Reptile: " + txtDeserializedReptile);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
    }
}