package fr.epita.assistants.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Json {
    public static Map<String,String> map = new HashMap<>();
    public static void addToJson(String key, String value, String js){
        final ObjectMapper mapper = new ObjectMapper();
        ObjectNode jsonObject = mapper.createObjectNode();
        map.put(key, value);

        for (Map.Entry<String, String> entry : map.entrySet()) {
            jsonObject.put(entry.getKey(), entry.getValue());
        }
        try {
            mapper.writeValue(new File(js), jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
