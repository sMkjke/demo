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
    public static final String XSLT_FILENAME = "xml_json/src/main/resources/style.xslt";

    private Document document;
    private SimpleValidator simpleValidator;

    public XPathExample() {
        this.document = setDocument();
        this.simpleValidator = new SimpleValidator();
    }


    //    private Document setDocument() {
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//
//        try (InputStream is = readXmlFileIntoInputStream(XML_MESSAGE)) {
//
//            // parse XML file
//            DocumentBuilder db = dbf.newDocumentBuilder();
//
//            // read from a project's resources folder
////            Document doc = db.parse(is);
//            System.out.println("parsed!");
//            return db.parse(is);
//
//        } catch (ParserConfigurationException | SAXException | IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("null!");
//        return null;
//    }
    private Document setDocument() {
        // Загружаем файл из ресурсов как InputStream
        ClassLoader classloader = XPathExample.class.getClassLoader();
        var file = classloader.getResourceAsStream(XML_MESSAGE);

        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            return document = documentBuilder.parse(file);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("null");
        return null;
    }


    public void changeNode(String xPath, String value) {
        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xpath = pathFactory.newXPath();

        XPathExpression exp = null;
        try {
            exp = xpath.compile(xPath);
            NodeList nodes = (NodeList) exp.evaluate(document, XPathConstants.NODESET);
            nodes.item(0).setTextContent(value);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }

    //    public void writeXml(String path) {
//        TransformerFactory transformerFactory = TransformerFactory.newInstance();
//        try {
////            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//
//            // The default add many empty new line, not sure why?
//            // https://mkyong.com/java/pretty-print-xml-with-java-dom-and-xslt/
//            // Transformer transformer = transformerFactory.newTransformer();
//
//            // add a xslt to remove the extra newlines
////            File file = new File(XSLT_FILENAME);
////            Transformer transformer = transformerFactory.newTransformer(
////                    new StreamSource(file));
//                Transformer transformer = TransformerFactory.newInstance().newTransformer();
//            // pretty print
//            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//            transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
//
//            DOMSource source = new DOMSource(document);
//            StreamResult result = new StreamResult(new File(path));
//
//            transformer.transform(source, result);
//        } catch (TransformerException e) {
//            e.printStackTrace();
//        }
//    }
    public void saveXml(String path) {
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(new DOMSource(document), new StreamResult(new File(CHANGED_MESSAGE)));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private InputStream readXmlFileIntoInputStream(final String fileName) {
//        return XPath.class.getClassLoader().getResourceAsStream(fileName);
        //working only if file in the same package
        return this.getClass().getResourceAsStream(fileName);
    }

    public Document getDocument() {
        return document;
    }

    public SimpleValidator getSimpleValidator() {
        return simpleValidator;
    }
}
