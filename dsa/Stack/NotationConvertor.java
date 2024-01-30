package dsa.stack;

public class NotationConvertor {
    public enum NotationType {
        postfix, prefix, infix
    }
    /**
     * The function gives whether the given character token is a operand of the expresssion.
     * @param c the to be checked character
     * @return the answer to the question.
     */
    public static boolean isOperand(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
    }

    /**
     * The function returns the value of the precdence of the operator
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
     * The function checks the whether the given character token is a operaotr or not.
     * @param c the character token to be checked.
     * @return the result of the chekcing
     */
    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /**
     * This function converts the given expression either in the form of prefix/postfix to postfix or vice versa.
     * @param expression this the given expression of type prefix or postfix.j
     * @param to to the notation to be converted.
     * @return the converted string.
     */
    private static String convert(String expression, NotationType to) {
        StringBuilder string = new StringBuilder();
        StackLL<String> stack = new StackLL<>();

        if (to == NotationType.prefix)
            expression = new StringBuilder(expression).reverse().toString();

        for (int i = 0; i < expression.length(); i++) {
            char token = expression.charAt(i);
            if (isOperand(token))
                stack.push(String.valueOf(token));
            else if (isOperator(token)) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String result = to == NotationType.prefix ? token + operand2 + operand1 : operand1 + operand2 + token;

                stack.push(result);
            }
        }
        string.append(stack.pop());
        return to == NotationType.prefix ? string.reverse().toString() : string.toString();
    }
   
    /**
     * The function convertes any type of expression to postfix.
     * @param expression this is the expression to be converted to postfix.
     * @param notation gives whether it is a prefix or infix exprssion type.
     * @return the converted postfix exprssion.
     */
    public static String postfix(String expression, NotationType notation) {
        if (notation == NotationType.prefix)
            return convert(expression, notation);
        // else is the infix case.
        StackLL<Character> stack = new StackLL<>();
        StringBuilder string = new StringBuilder();
        int i = 0;
        while (i < expression.length()) {
            char token = expression.charAt(i);
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
     * This function converts given infix or postfix notation to prefix notatio.
     * @param infix string is passed as the first parameter.
     * @param notation gives whether the given expression if of postfix or infix type 
     * @return prefix converted string is returned upon conversion.
     */
    public static String prefix(String expression, NotationType notation) {
        if (notation == NotationType.postfix)
            return convert(expression, notation);
        StringBuilder string = new StringBuilder();
        StackLL<Character> stack = new StackLL<>();
        char[] revInfix = new char[expression.length()];
        for (int i = expression.length() - 1, k = 0; i >= 0; i--, k++)
            revInfix[k] = expression.charAt(i);
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
     * The function converts given prefix or postfic expresssion back to infnix expression.
     * @param expression the expression which has to be converted.
     * @param notation whether prefix or postfix.
     * @return the new converted infix string.
     */
    public static String infix(String expression, NotationType notation) {
        StringBuilder string = new StringBuilder();
        Stack<String> stack = new Stack<>();

        if (notation == NotationType.prefix)
            expression = new StringBuilder(expression).reverse().toString();

        for (int i = 0; i < expression.length(); i++) {
            char token = expression.charAt(i);
            if (isOperand(token))
                stack.push(String.valueOf(token));
            else if (isOperator(token)) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String result = notation == NotationType.postfix ? operand2 + token + operand1
                        : operand1 + token + operand2;
                stack.push(result);
            }
        }
        string.append(stack.pop());
        return string.toString();
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
     * This function performs evaultion on the postfix and prefix exprsssion
     * specifiecd and the
     * number belong to 0 and 9 only since character wise evalutaion is done.
     * 
     * @param expression it is the expression which is either prefix or postifx.
     * @param notation   it is a enum which specifies whether it is prefix or
     *                   postifx.
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
                    else if (isOperator(token)) {
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
                    else if (isOperator(token)) {
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
