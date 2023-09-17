package v2;

import java.util.Stack;

public class JSONDeserializer {
    private String json;

    public JSONDeserializer(String json) {
        this.json = json;
    }

    public JSONObject mapStringToJSONObject() {
        //logic of deserialization of a string
        if (!allBracketsValid()) {
            throw new IllegalStateException("Invalid json: Invalid brackets or braces.");
        }

    }

    private boolean allBracketsValid() {
        boolean curlyBracesValid = bracketsValid(json, '{', '}');
        boolean bracketsValid = bracketsValid(json, '[', ']');
        return curlyBracesValid && bracketsValid;
    }

    private boolean bracketsValid(String json, char open, char close) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < json.length(); i++) {
            if (json.charAt(i) == open) {
                stack.push(open);
                count++;
            } else if (json.charAt(i) == close && !stack.isEmpty()) {
                stack.pop();
                count++;
            }
        }
        return stack.isEmpty() && count > 0;
    }
}
