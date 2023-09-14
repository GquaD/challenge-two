import java.io.File;
import java.util.List;
import java.util.Stack;

public class Main {
    //in this program we are going to parse json objects
    //and check whether given string is valid or invalid json object
    public static void main(String[] args) {
        //File file = new File("test.json");
        File file = new File("invalid.json");
        MyReader reader = new MyReader(file);
        StringBuilder sb = new StringBuilder();
        List<String> list = reader.getReader().lines().toList();
        for (String s : list) sb.append(s);
        String json = sb.toString();

        if (!bracketsValid(json)) {
            System.out.println("Invalid json");
        } else {
            System.out.println("Valid json");
        }
    }

    private static boolean bracketsValid(String json) {
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
