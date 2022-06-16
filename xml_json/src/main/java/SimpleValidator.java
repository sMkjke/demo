import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.FileInputStream;
import java.io.IOException;

public class SimpleValidator {

    public boolean validate(String xsdPath, String xmlPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); //создаем фабрику для схемы

            // Загружаем схему из ресурсов как InputStream
            var file = this.getClass().getResourceAsStream(xsdPath);

            // Загрузить схему из XSD
            Schema schema = factory.newSchema(new StreamSource(file));

            // Создать валидатор (проверяльщик)
            Validator validator = schema.newValidator();

            // Загружаем xml из ресурсов как InputStream
            file = new FileInputStream(xmlPath);

        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        } catch (SAXException e1) {
            System.out.println("SAX Exception: " + e1.getMessage());
            return false;
        }
        return true;
    }
}