import v2.JSONDeserializer;

import java.io.File;
import java.util.List;

public class MainTwo {
    public static void main(String[] args) {
        File file = new File("invalid.json");
        MyReader reader = new MyReader(file);
        StringBuilder sb = new StringBuilder();
        List<String> list = reader.getReader().lines().toList();
        for (String s : list) sb.append(s);
        String json = sb.toString();
        JSONDeserializer deserializer = new JSONDeserializer(json);
        deserializer.mapStringToJSONObject();
    }
}
