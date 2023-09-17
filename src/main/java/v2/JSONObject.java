package v2;

import java.util.HashMap;
import java.util.Map;

public class JSONObject implements JSONable{
    private Map<JSONString, JSONable> map;

    public JSONObject() {
        map = new HashMap<>();
    }

    public JSONable put(JSONString key, JSONable val) {
        return map.put(key, val);
    }
}
