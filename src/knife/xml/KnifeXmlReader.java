package knife.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import knife.domain.BladeMaterial;
import knife.domain.HandleMaterial;
import knife.domain.Handy;
import knife.domain.Knife;

public class KnifeXmlReader {
    private String filePath;

    public KnifeXmlReader() { }

    public KnifeXmlReader(final String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(final String filePath) {
        this.filePath = filePath;
    }

    public List<Knife> read() throws FileNotFoundException, XMLStreamException {
        List<Knife> knives = new ArrayList<Knife>();
        Knife knife = null;
        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader reader = factory.createXMLStreamReader(
                new FileInputStream(filePath));
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
            case XMLStreamConstants.START_ELEMENT:
                String tag = reader.getLocalName();
                if ("knife".equals(tag)) {
                    knife = new Knife();
                    knife.setId(Integer.parseInt(reader.getAttributeValue(null,
                            "id")));
                } else if ("type".equals(tag)) {
                    knife.setType(reader.getElementText());
                } else if ("handy".equals(tag)) {
                    knife.setHandy(Handy.valueOf(reader.getElementText()));
                } else if ("origin".equals(tag)) {
                    knife.setOrigin(reader.getElementText());
                } else if ("length".equals(tag)) {
                    knife.getVisual().getBlade().setLength(
                            Integer.parseInt(reader.getElementText()));
                } else if ("width".equals(tag)) {
                    knife.getVisual().getBlade().setWidht(
                            Integer.parseInt(reader.getElementText()));
                } else if ("blade_material".equals(tag)) {
                    knife.getVisual().getBlade().setMaterial(
                            BladeMaterial.valueOf(reader.getElementText()));
                } else if ("fuller".equals(tag)) {
                    knife.getVisual().getBlade().setFuller(
                            Boolean.parseBoolean(reader.getElementText()));
                } else if ("handle_material".equals(tag)) {
                    knife.getVisual().getHandle().setMaterial(
                            HandleMaterial.valueOf(reader.getElementText()));
                } else if ("material_type".equals(tag)) {
                    knife.getVisual().getHandle().setType(
                            reader.getElementText());
                } else if ("value".equals(tag)) {
                    knife.setValue(Boolean.parseBoolean(
                            reader.getElementText()));
                }
                break;
            case XMLStreamConstants.END_ELEMENT:
                String tagName = reader.getLocalName();
                if ("knife".equals(tagName)) {
                    knives.add(knife);
                }
                break;
            default:
                break;
            }
        }
        reader.close();
        return knives;
    }
}
