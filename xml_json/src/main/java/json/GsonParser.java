package json;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.Reader;


public class GsonParser {

    public static final String JSON_TEST = "xml_json/src/main/resources/test.json";

    public Users parse(final String json) {
        // create Gson instance
        Gson gson = new Gson();
        // create a reader
        try (Reader reader = new FileReader(json)) {

            // convert JSON to Users object
            Users users = gson.fromJson(reader, Users.class);

            return users;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
