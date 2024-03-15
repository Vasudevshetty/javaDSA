package dsa.stack;

public class Convertor {
    public enum Notation {
        infix, postfix, prefix;
    }

    /**
     * The function gives whether the given character token is a operand of the
     * expresssion.
     * 
     * @param c the to be checked character
     * @return the answer to the question.
     */
    public static boolean isOperand(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
    }

    /**
     * The function returns the value of the precdence of the operator
     * 
     * @param c the character tokent o be checked.
     * @return the precdence of the corresponding character
     */
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

    /**
     * The function checks the whether the given character token is a operaotr or
     * not.
     * 
     * @param c the character token to be checked.
     * @return the result of the chekcing
     */
    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static String interConvert(String expression, Notation from, Notation to) {
        StringBuilder string = new StringBuilder();
        StackLL<String> stack = new StackLL<>();

        if (from == Notation.prefix)
            expression = new StringBuilder(expression).reverse().toString();

        for (int i = 0; i < expression.length(); i++) {
            char token = expression.charAt(i);
            if (isOperand(token))
                stack.push(String.valueOf(token));
            else if (isOperator(token)) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();

                String result = "";

                if (to == Notation.infix)
                    result = operand2 + token + operand1;
                else if (to == Notation.postfix)
                    result = operand2 + operand1 + token;
                else if (to == Notation.prefix)
                    result = token + operand1 + operand2;

                stack.push(result);
            }
        }
        string.append(stack.pop());
        return to == Notation.prefix || from == Notation.prefix ? string.reverse().toString() : string.toString();
    }

    public static String convert(String expression, Notation from, Notation to) {
        StringBuilder string = new StringBuilder();

        if (from != Notation.infix)
            return interConvert(expression, from, to);

        StackLL<Character> stack = new StackLL<>();

        for (int i = 0; i < expression.length(); i++) {
            char token = to == Notation.prefix ? expression.charAt(expression.length() - i - 1) : expression.charAt(i);
            if (isOperand(token))
                string.append(token);
            else if (token == (to == Notation.prefix ? ')' : '('))
                stack.push(token);
            else if (token == (to == Notation.prefix ? '(' : ')')) {
                while (!stack.isEmpty() && stack.peek() != (to == Notation.prefix ? ')' : '('))
                    string.append(stack.pop());
                if (!stack.isEmpty() && stack.peek() == (to == Notation.prefix ? ')' : '('))
                    stack.pop();
            } else {
                while (!stack.isEmpty() && (to == Notation.prefix ? precedence(token) < precedence(stack.peek())
                        : precedence(token) <= precedence(stack.peek())))
                    string.append(stack.pop());
                stack.push(token);
            }
        }

        while (!stack.isEmpty())
            string.append(stack.pop());

        return to == Notation.prefix ? string.reverse().toString() : string.toString();
    }

    public static void main(String[] args) {
        String string = "a+b*c/d-(e-f)";

        System.out.println(convert(string, Notation.infix, Notation.postfix));
        System.out.println(convert(string, Notation.infix, Notation.prefix));
        System.out.println(convert(convert(string,Notation.infix, Notation.postfix), Notation.postfix, Notation.infix));
        System.out.println(convert(convert(string,Notation.infix, Notation.postfix), Notation.postfix, Notation.prefix));
        System.out.println(convert(convert(string,Notation.infix, Notation.prefix), Notation.prefix, Notation.infix));
        System.out.println(convert(convert(string,Notation.infix, Notation.prefix), Notation.prefix, Notation.postfix));
    }
}
