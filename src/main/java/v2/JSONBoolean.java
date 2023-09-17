package v2;

public class JSONBoolean implements JSONable{

    private Boolean value;

    public JSONBoolean(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return value;
    }
}
