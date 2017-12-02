package knife;

import java.io.FileNotFoundException;
import java.util.List;
import javax.xml.stream.XMLStreamException;
import knife.domain.Knife;
import knife.xml.KnifeXmlReader;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        KnifeXmlReader reader = new KnifeXmlReader("knives.xml");
        try {
            List<Knife> knives = reader.read();
            for (Knife knife : knives) {
                System.out.println(knife);
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.getMessage();
        }
    }
}
