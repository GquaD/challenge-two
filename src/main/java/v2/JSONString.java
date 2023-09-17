package v2;

public class JSONString implements JSONable {
    private String string;

    public JSONString(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    @Override
    public int hashCode() {
        return string.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return string.equals(((JSONString) obj).getString());
    }
}
