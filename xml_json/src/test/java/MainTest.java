import json.GsonParser;
import json.Users;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xmlunit.builder.Input;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.xmlunit.matchers.CompareMatcher.isSimilarTo;

public class MainTest {

    private XPathExample converter;
    private HashMap<String, String> map = new HashMap<>();
    private ClassLoader classLoader;
    private GsonParser gsonParser;

    @BeforeEach
    public void setup() {
        classLoader = getClass().getClassLoader();
        converter = new XPathExample();
        map.put("//messagedate", "2022-06-16T22:00:00");
        map.put("//surname", "Yeltcin");
        map.put("//name", "Boris");
        map.put("//patronymic", "Nikolayevich");
        map.put("//email", "freedomrussia@ru.ru");
        map.put("//department/name", "dit");
        map.put("//population", "5");
        converter.changeNodes(map);
    }

    @BeforeEach
    public void setupJson() {
        gsonParser = new GsonParser();
    }

    @Test
    public void testParse() {
        Map<String, String> changedMap = converter.getChangedMap();
        Assert.assertEquals(changedMap.size(), map.size());
        for (int i = 0; i < changedMap.size(); i++) {
            Assert.assertEquals(changedMap.get(i), map.get(i));
        }
    }


    /**
     * XMLUnit test library;
     */
    @Test
    public void outputFileIsCorrect() {
        String testPath = classLoader.getResource("ChangedMessage.xml").getPath();
        String controlPath = classLoader.getResource("testfile.xml").getPath();

        assertThat(Input.fromFile(testPath), isSimilarTo(Input.fromFile(controlPath)));
    }

    @Test
    public void incomeFileNotCorrect() {
        String testPath = classLoader.getResource("ChangedMessage.xml").getPath();
        String controlPath = classLoader.getResource("message.xml").getPath();
        Assertions.assertNotEquals(Input.fromFile(testPath), isSimilarTo(Input.fromFile(controlPath)));
    }

    @Test
    public void validateTest() {
        converter.writeXml("src/main/resources/ChangedMessage.xml");
        Assertions.assertTrue(converter.getSimpleValidator().
                validate(XPathExample.XSD_MESSAGE, "src/main/resources/ChangedMessage.xml"));
    }

    @Test
    public void jsonUsersSizeTest() {
        Users users = gsonParser.parse("src/main/resources/test.json");
        Assertions.assertEquals(users.getUsers().size(), 5);
    }

    @Test
    public void jsonUserTest() {
        Users users = gsonParser.parse("src/main/resources/test.json");
        Assertions.assertEquals(users.getUsers().get(0).getFirstName(), "Aleksey");
    }
}
