import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.*;
import java.io.*;


public class XPathExample {

    public static final String XML_MESSAGE = "Message.xml";
    public static final String XSD_MESSAGE = "Message.xsd";
    public static final String CHANGED_MESSAGE = "xml_json/src/main/resources/ChangedMessage.xml";
    public static final String XSLT_FILENAME = "xml_json/src/main/resources/xslt/style.xslt";

    private Document document;
    private SimpleValidator simpleValidator;

    public XPathExample() {
        this.document = setDocument();
        this.simpleValidator = new SimpleValidator();
    }


    public void changeNode(final String xPath, final String value) {
        XPathFactory pf = XPathFactory.newInstance();
        XPath xpath = pf.newXPath();

        try {
            XPathExpression exp = xpath.compile(xPath);
            NodeList nodes = (NodeList) exp.evaluate(document, XPathConstants.NODESET);
            nodes.item(0).setTextContent(value);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }

    public void writeXml(final String path) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            // add a xslt to remove the extra newlines
            Transformer transformer = transformerFactory.newTransformer(
                    new StreamSource(new File(XSLT_FILENAME)));

            // pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "no");

            transformer.transform(new DOMSource(document), new StreamResult(new File(path)));

        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private Document setDocument() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try (InputStream is = readXmlFileIntoInputStream(XML_MESSAGE)) {

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();

            // read from a project's resources folder
            return db.parse(is);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("null!");
        return null;
    }

    private InputStream readXmlFileIntoInputStream(final String fileName) {
        //working only if file in the same package
        return this.getClass().getResourceAsStream(fileName);
    }

    public SimpleValidator getSimpleValidator() {
        return simpleValidator;
    }
}