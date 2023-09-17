package v2;

public class JSONNumber implements JSONable{
    private Long number;

    public JSONNumber(Long number) {
        this.number = number;
    }

    public Long getNumber() {
        return number;
    }
}
