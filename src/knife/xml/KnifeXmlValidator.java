package knife.xml;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class KnifeXmlValidator extends DefaultHandler {
    private String xmlPath;
    private String shemaPath;
    private StringBuilder error = new StringBuilder();
    
    public KnifeXmlValidator(String xmlPath, String shemaPath) {
        this.xmlPath = xmlPath;
        this.shemaPath = shemaPath;
    }

    public StringBuilder getError() {
        return error;
    }

    private void appendErrorInfo(SAXParseException e) {
        error.append(" at line ");
        error.append(e.getLineNumber());
        error.append(": ");
        error.append(e.getMessage());
        error.append('\n');
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        error.append("ERROR");
        appendErrorInfo(e);
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        error.append("FATAL ERROR");
        appendErrorInfo(e);
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        error.append("WARNING");
        appendErrorInfo(e);
    }
    
    public boolean idXmlValid() throws SAXException, IOException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new File(shemaPath));
        Validator validator = schema.newValidator();
        validator.setErrorHandler(this);
        validator.validate(new StreamSource(xmlPath));
        return error.length() == 0;
    }
}
