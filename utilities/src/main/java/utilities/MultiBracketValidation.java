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
                    curly--;
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '{':
                    stack.push(ch);
                    curly++;
                    break;
                case ')':
                    paren--;
                    if (stack.peek() != '(') {
                        return false;
                    } else if (stack.peek() == '(') {
                        stack.pop();
                    }
                    break;
                case '(':
                    stack.push(ch);
                    paren++;
                    break;
                case ']':
                    square--;
                    if (stack.peek() != '[') {
                        return false;
                    } else if (stack.peek() == '[') {
                        stack.pop();
                    }
                    break;
                case '[':
                    stack.push(ch);
                    square++;
                    break;
                default:
                    continue;
            }
        }
        return (paren == 0 && curly == 0 && square == 0);
    }
    public static void main(String[] args) {
        System.out.println(multiBracketValidation("{}{()"));
        System.out.println(multiBracketValidation("{}{()}"));
        System.out.println(multiBracketValidation("{}(})}"));
        System.out.println(multiBracketValidation("()"));
    }
}
