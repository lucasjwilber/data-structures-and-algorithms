package utilities;

import java.util.Stack;

public class MultiBracketValidation {
    public static boolean multiBracketValidation(String input) {
        Stack<Character> stack = new Stack<>();
        char[] brackets = input.toCharArray();

        for (char ch: brackets) {
            switch (ch) {
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                case '[':
                    stack.push(ch);
                    break;
            }
        }
        return stack.isEmpty();
    }
}
