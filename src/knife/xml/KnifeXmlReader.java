package knife.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import knife.domain.Blade;
import knife.domain.BladeMaterial;
import knife.domain.Handle;
import knife.domain.HandleMaterial;
import knife.domain.Handy;
import knife.domain.Knife;
import knife.domain.Visual;

public class KnifeXmlReader {
    private String filePath;

    public KnifeXmlReader() { }

    public KnifeXmlReader(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    public List<Knife> read() throws FileNotFoundException, XMLStreamException {
        List<Knife> knives = new ArrayList<Knife>();
        Knife knife = null;
        Visual visual = null;
        Blade blade = null;
        Handle handle = null;
        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(filePath));
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
            case XMLStreamConstants.START_ELEMENT:
                String tag = reader.getLocalName();
                if ("knife".equals(tag)) {
                    knife = new Knife();
                    knife.setId(Integer.parseInt(reader.getAttributeValue(null, "id")));
                } else if("type".equals(tag)) {
                    knife.setType(reader.getElementText());
                } else if("handy".equals(tag)) {
                    knife.setHandy(Handy.valueOf(reader.getElementText()));
                } else if("origin".equals(tag)) {
                    knife.setOrigin(reader.getElementText());
                } else if("visual".equals(tag)) {
                    visual = new Visual();
                } else if("length".equals(tag)) {
                    blade = new Blade();
                    blade.setLength(Integer.parseInt(reader.getElementText()));
                } else if("width".equals(tag)) {
                    blade.setWidht(Integer.parseInt(reader.getElementText()));
                } else if("blade_material".equals(tag)) {
                    blade.setMaterial(BladeMaterial.valueOf(reader.getElementText()));
                } else if("fuller".equals(tag)) {
                    blade.setFuller(Boolean.parseBoolean(reader.getElementText()));
                    visual.setBlade(blade);
                } else if("handle_material".equals(tag)) {
                    handle = new Handle();
                    handle.setMaterial(HandleMaterial.valueOf(reader.getElementText()));
                    /* типа рукоятки может не быть */
                    visual.setHandle(handle);
                    knife.setVisual(visual);
                } else if("material_type".equals(tag)) {
                    handle.setType(reader.getElementText());
                    visual.setHandle(handle);
                    knife.setVisual(visual);
                } else if("value".equals(tag)) {
                    knife.setValue(Boolean.parseBoolean(reader.getElementText()));
                }
                break;
            case XMLStreamConstants.END_ELEMENT:
                String tagName = reader.getLocalName();
                if("knife".equals(tagName)) {
                    knives.add(knife);
                }
                break;
            }
        }
        reader.close();
        return knives;
    }
}
