package utilities;

import java.util.Stack;

public class MultiBracketValidation {
    public static boolean multiBracketValidation(String input) {
        int paren = 0;
        int curly = 0;
        int square = 0;
        Stack<Character> stack = new Stack<>();
        char[] brackets = input.toCharArray();

        for (char ch: brackets) {
            switch (ch) {
                case '}':
                    if (curly == 0) return false;
                    curly--;
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else { return false; }
                    break;
                case '{':
                    stack.push(ch);
                    curly++;
                    break;
                case ')':
                    if (paren == 0) return false;
                    paren--;
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else { return false; }
                    break;
                case '(':
                    stack.push(ch);
                    paren++;
                    break;
                case ']':
                    if (square == 0) return false;
                    square--;
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else { return false; }
                    break;
                case '[':
                    stack.push(ch);
                    square++;
                    break;
            }
        }
        return true;
    }
}
