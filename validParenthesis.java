import java.util.Stack;

public class validParenthesis {

     public static void validParenthesis(){
        Stack<Character> s = new Stack<>();
        String expression = "({[]})";
        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
            s.push(ch);
            } else {
            if (s.isEmpty()) {
                System.out.println("Invalid Parenthesis");
                return;
            }
            char top = (char) s.pop();
            if ((ch == ')' && top != '(') || 
                (ch == '}' && top != '{') || 
                (ch == ']' && top != '[')) {
                System.out.println("Invalid Parenthesis");
                return;
            }
            }
        }
        if (s.isEmpty()) {
            System.out.println("Valid Parenthesis");
        } else {
            System.out.println("Invalid Parenthesis");
        }
    }

    public static void main(String[] args) {
        validParenthesis();
        
    }
    
}
