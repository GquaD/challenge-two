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
        return null;
    }

    private boolean allBracketsValid() {
        boolean curlyBracesValid = bracketsValid(json, '{', '}');
        boolean squareBracketsValid = squareBracketsValid(json, '[', ']');
        return curlyBracesValid && squareBracketsValid;
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
            } else if (json.charAt(i) == close && stack.isEmpty()) {
                return false;
            }
        }
        return stack.isEmpty() && count > 0;
    }

    private boolean squareBracketsValid(String json, char open, char close) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < json.length(); i++) {
            if (json.charAt(i) == open) {
                stack.push(open);
            } else if (json.charAt(i) == close && !stack.isEmpty()) {
                stack.pop();
            } else if (json.charAt(i) == close && stack.isEmpty()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
