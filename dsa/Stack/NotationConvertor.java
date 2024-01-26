package dsa.stack;

public class NotationConvertor {
    public enum NotationType {
        postfix, prefix
    }

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

    /**
     * This function converts given infix notation to postfix notation.
     * 
     * @param infix string is passed as the first parameter.
     * @return prefix converted string is returned upon conversion.
     */
    public static String prefix(String infix) {
        StringBuilder string = new StringBuilder();
        StackLL<Character> stack = new StackLL<>();
        char[] revInfix = new char[infix.length()];
        for (int i = infix.length() - 1, k = 0; i >= 0; i--, k++)
            revInfix[k] = infix.charAt(i);
        int i = 0;
        while (i < revInfix.length) {
            char token = revInfix[i];
            if (isOperand(token))
                string.append(token);
            else if (token == ')')
                stack.push(token);
            else if (token == '(') {
                while (!stack.isEmpty() && stack.peek() != ')')
                    string.append(stack.pop());
                if (!stack.isEmpty() && stack.peek() == ')')
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
        return string.reverse().toString();
    }

    /**
     * This is used for calcualting the value of the operation,
     * 
     * @param operator corresoponds to the operator of the operation.
     * @param operand1 corresopnds to the operand to which operation is to be
     *                 performed.
     * @param operand2 corresponds to the operand to which operation is to be
     *                 performed.
     * @return the value of operation.
     */
    private static int calculate(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            case '^':
                return (int) Math.pow(operand2, operand1);
            default:
                return 0;
        }
    }
    
    /**
     * This function performs evaultion on the postfix and prefix exprsssion specifiecd and the 
     * number belong to 0 and 9 only since character wise evalutaion is done.
     * @param expression it is the expression which is either prefix or postifx.
     * @param notation it is a enum which specifies whether it is prefix or postifx.
     * @return the value of evaulted post or prefix expresssions value.
     */
    public static int evaulate(String expression, NotationType notation) {
        StackLL<Integer> stack = new StackLL<>();
        switch (notation) {
            case prefix:
                for (int i = expression.length() - 1; i >= 0; i--) {
                    char token = expression.charAt(i);
                    if (isOperand(token))
                        stack.push(token - '0');
                    else {
                        int operand1 = stack.pop();
                        int operand2 = stack.pop();

                        stack.push(calculate(token, operand1, operand2));
                    }
                }
                return stack.peek();
            case postfix:
                for (int i = 0; i < expression.length(); i++) {
                    char token = expression.charAt(i);
                    if (isOperand(token))
                        stack.push(token - '0');
                    else {
                        int operand2 = stack.pop();
                        int operand1 = stack.pop();

                        stack.push(calculate(token, operand1, operand2));
                    }
                }
                return stack.peek();
            default:
                throw new IllegalArgumentException("Illegal notation type please specify.");
        }

    }
}
