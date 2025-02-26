import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        boolean ans = isValid("()[]{");
        System.out.println(ans);
    }

    public static boolean isValid(String s) {

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stk.isEmpty())
                stk.push(s.charAt(i));

            else if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stk.push(s.charAt(i));
            }

            else if (s.charAt(i) == ')') {
                Character ch = stk.peek();
                if (ch == '(') {
                    stk.pop();
                } else {
                    return false;
                }
            }

            if (s.charAt(i) == '}') {
                Character ch = stk.peek();
                if (ch == '{') {
                    stk.pop();
                } else {
                    return false;
                }
            }

            if (s.charAt(i) == ']') {
                Character ch = stk.peek();
                if (ch == '[') {
                    stk.pop();
                } else {
                    return false;
                }
            }
        }

        return stk.isEmpty();

    }
}
