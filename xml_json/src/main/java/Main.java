import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {

        XPathExample xPathExample = new XPathExample();

        xPathExample.changeNode("//messagedate", "2022-06-16T22:00:00");
        xPathExample.changeNode("//surname", "Yeltcin");
        xPathExample.changeNode("//name", "Boris");
        xPathExample.changeNode("//patronymic", "Nikolayevich");
        xPathExample.changeNode("//email", "freedomrussia@ru.ru");
        xPathExample.changeNode("//department/name", "dit");
        xPathExample.changeNode("//population", "5");
        xPathExample.writeXml(XPathExample.CHANGED_MESSAGE);

        System.out.printf("Validation: %b", xPathExample.getSimpleValidator().
                validate(XPathExample.XSD_MESSAGE, XPathExample.CHANGED_MESSAGE));

    }

}

