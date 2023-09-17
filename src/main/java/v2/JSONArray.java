package v2;

import java.util.ArrayList;
import java.util.List;

public class JSONArray implements JSONable {
    private List<JSONable> list;

    public JSONArray() {
        list = new ArrayList<>();
    }

    public List<JSONable> getList() {
        return list;
    }

    public void add(JSONable val) {
        list.add(val);
    }
}
