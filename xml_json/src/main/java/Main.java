import json.GsonParser;
import json.Users;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        XPathExample xPathExample = new XPathExample();
        HashMap<String, String> map = new HashMap<>();
        map.put("//messagedate", "2022-06-16T22:00:00");
        map.put("//surname", "Yeltcin");
        map.put("//name", "Boris");
        map.put("//patronymic", "Nikolayevich");
        map.put("//email", "freedomrussia@ru.ru");
        map.put("//department/name", "dit");
        map.put("//population", "5");
        xPathExample.changeNodes(map);

        xPathExample.writeXml(XPathExample.CHANGED_MESSAGE);

        System.out.printf("XML Validation: %b", xPathExample.getSimpleValidator().
                validate(XPathExample.XSD_MESSAGE, XPathExample.CHANGED_MESSAGE));

        System.out.println();
        GsonParser gsonParser = new GsonParser();
        Users users = gsonParser.parse(GsonParser.JSON_TEST);
        System.out.println(users.toString());
    }
}

