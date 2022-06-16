import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        XPathExample xPathExample = new XPathExample();

        xPathExample.changeNode("//messagedate", "2022-06-16T22:00:00");
        xPathExample.changeNode("//population", "5");
        xPathExample.changeNode("//surname", "Yeltcin");
        xPathExample.changeNode("//name", "Boris");
        xPathExample.changeNode("//patronymic", "Nikolayevich");
        xPathExample.changeNode("//email", "freedomrussia@ru.ru");
//        xPathExample.writeXml(XPathExample.CHANGED_MESSAGE);
        xPathExample.saveXml(XPathExample.CHANGED_MESSAGE);
//        xPathVal.changeNodeText("//messagedate", "2021-07-21T08:00:00");
//        xPathVal.changeNodeText("//population", "111");
//        xPathVal.changeNodeText("//surname", "Ivanov");
//        xPathVal.changeNodeText("//name", "Ivan");
//        xPathVal.changeNodeText("//patronymic", "Ivanovich");
//        xPathVal.changeNodeText("//email", "ivanivanovich123@mail.ru");

//        xPathVal.saveXml(PathVariables.MESSAGE_AFTER_CHANGE_XML_FULL_PATH);

        System.out.println(xPathExample.getSimpleValidator().validate(XPathExample.XSD_MESSAGE,XPathExample.CHANGED_MESSAGE));
//        boolean answer = XsdValidator.validateXMLSchema(PathVariables.MESSAGE_XSD, PathVariables.MESSAGE_AFTER_CHANGE_XML_FULL_PATH);
//        System.out.println("Результат валидации: " + answer);
    }

}

