import java.io.File;
import java.util.List;
import java.util.Stack;

public class Main {
    //in this program we are going to parse json objects
    //and check whether given string is valid or invalid json object

    static final String BOOLEAN_TRUE = "true";
    static final String BOOLEAN_FALSE = "false";
    static final String NULL = "null";

    public static void main(String[] args) {
        //File file = new File("test.json");
        File file = new File("invalid.json");
        MyReader reader = new MyReader(file);
        StringBuilder sb = new StringBuilder();
        List<String> list = reader.getReader().lines().toList();
        for (String s : list) sb.append(s);
        String json = sb.toString();

        checkIfJSONValid(json);
    }

    private static void checkIfJSONValid(String json) {
        if (!bracketsValid(json)) {
            System.out.println("Invalid json");
            System.exit(1);
        }

        if (!valuesAreCorrect(json)) {
            System.out.println("Invalid json");
            System.exit(1);
        } else {
            System.out.println("Valid json");
        }
    }

    public static boolean valuesAreCorrect(String json) {
        String[] split = json.split(",");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String[] arr = s.split(":");
            if (arr.length < 2) return false;
            boolean keyCorrect = isKeyCorrect(arr[0]);
            boolean valCorrect = isValueCorrect(arr[1]);
            if (!keyCorrect || !valCorrect) return false;
        }
        return true;
    }

    private static boolean isValueCorrect(String s) {
        int countQuotes = 0;
        s = s.trim();
        if (s.startsWith("{")) checkIfJSONValid(s);
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == '"') countQuotes++;
        if (!(countQuotes == 2 || countQuotes == 0)) return false;
        if (countQuotes == 2) {
            int countQuotes2 = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '"') {
                    countQuotes2++;
                    continue;
                }
                if (countQuotes2 == 2 && s.charAt(i) != '}') {
                    return false;
                }
            }
        }
        if (countQuotes == 0) {
            int countLetters = 0, countDigits = 0;
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isLetterOrDigit(s.charAt(i))
                        && s.charAt(i) != '}' && s.charAt(i) != '{') return false;
                if (Character.isLetter(s.charAt(i))) countLetters++;
                if (Character.isDigit(s.charAt(i))) countDigits++;
            }

            if (countLetters > 0 && countDigits > 0) return false;
            if (countDigits == 0 && countLetters != 4 && countLetters != 5) return false;

            if (countLetters > 0 && !s.equals(BOOLEAN_TRUE)
                    && !s.equals(BOOLEAN_FALSE) && !s.equals(NULL)) return false;
        }
        return true;
    }

    private static boolean isKeyCorrect(String s) {
        int countQuotes = 0;
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == '"') countQuotes++;
        if (countQuotes != 2) return false;
        countQuotes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '"') {
                countQuotes++;
                continue;
            }
            if (countQuotes == 2 && s.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean bracketsValid(String json) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < json.length(); i++) {
            if (json.charAt(i) == '{') {
                stack.push('{');
                count++;
            } else if (json.charAt(i) == '}' && !stack.isEmpty()) {
                stack.pop();
                count++;
            }
        }
        return stack.isEmpty() && count > 0;
    }
}
