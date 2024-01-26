package dsa.stack;

public class PostfixConverter {
    public static boolean isOperand(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
    }

    public static int precedence(char c) {
        if (c == '^')
            return 3;
        else if (c == '*' || c == '/')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return 0;
    }

    public static String postfix(String infix) {
        StackLL<Character> stack = new StackLL<>();
        StringBuilder string = new StringBuilder();
        int i = 0;
        while (i < infix.length()) {
            char token = infix.charAt(i);
            if (isOperand(token))
                string.append(token);
            else if (token == '(')
                stack.push(token);
            else if (token == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    string.append(stack.pop());
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(token) <= precedence(stack.peek()))
                    string.append(stack.pop());
                stack.push(token);
            }
            i++;
        }
        while (!stack.isEmpty())
            string.append(stack.pop());
        return string.toString();
    }
}
