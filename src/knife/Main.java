package knife;

import java.io.IOException;
import java.util.List;
import javax.xml.stream.XMLStreamException;
import org.xml.sax.SAXException;
import knife.comparator.OriginComparator;
import knife.domain.Knife;
import knife.xml.KnifeXmlReader;
import knife.xml.KnifeXmlValidator;

public class Main {
    private static final String XML_PATH = "knives.xml";
    private static final String SCHEMA_PATH = "knives.xsd";

    public static void main(String[] args) {
        KnifeXmlValidator validator = new KnifeXmlValidator(XML_PATH, SCHEMA_PATH);
        try {
            if (validator.idXmlValid()) {
                KnifeXmlReader reader = new KnifeXmlReader(XML_PATH);
                    List<Knife> knives = reader.read();
                    knives.sort(new OriginComparator());
                    System.out.println("The knives (order by origin country):");
                    for (Knife knife : knives) {
                        System.out.println(knife);
                    }               
            } else {
                System.out.println(validator.getError());                
            }
        } catch (SAXException | IOException | XMLStreamException e1) {
            System.out.println(e1.getLocalizedMessage());
        }
    }
}
