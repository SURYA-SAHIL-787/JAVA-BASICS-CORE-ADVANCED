import java.util.*;

public class InfixConversion {

    // RETURNS PRECEDENCE OF OPERATORS
    public static int precedence(String op) {
        if (op.equals("!")) {
            return 6;
        } else if (op.equals("^")) {
            return 5;
        } else if (op.equals("*") || op.equals("/") || op.equals("%")) {
            return 4;
        } else if (op.equals("+") || op.equals("-")) {
            return 3;
        } else if (op.equals("<") || op.equals(">") || op.equals("<=") ||
                   op.equals(">=") || op.equals("==") || op.equals("!=")) {
            return 2;
        } else if (op.equals("&&")) {
            return 1;
        } else if (op.equals("||")) {
            return 0;
        }
        return -1;
    }

    // CHECKS WHETHER TOKEN IS OPERAND
    public static boolean isOperand(String token) {
        for (int i = 0; i < token.length(); i++) {
            if (!Character.isLetterOrDigit(token.charAt(i))) {
                return false;
            }
        }
        return token.length() > 0;
    }

    // SPLITS EXPRESSION INTO TOKENS
    public static List<String> tokenize(String expression) {
        List<String> tokens = new ArrayList<>();
        int i = 0;

        while (i < expression.length()) {
            char ch = expression.charAt(i);

            if (ch == ' ') {
                i++;
                continue;
            }

            if (i + 1 < expression.length()) {
                String twoChar = expression.substring(i, i + 2);
                if (twoChar.equals("<=") || twoChar.equals(">=") ||
                    twoChar.equals("==") || twoChar.equals("!=") ||
                    twoChar.equals("&&") || twoChar.equals("||")) {
                    tokens.add(twoChar);
                    i += 2;
                    continue;
                }
            }

            if ("+-*/%^()<>!".indexOf(ch) != -1) {
                tokens.add(String.valueOf(ch));
                i++;
            } else if (Character.isLetterOrDigit(ch)) {
                StringBuilder operand = new StringBuilder();
                while (i < expression.length() &&
                       Character.isLetterOrDigit(expression.charAt(i))) {
                    operand.append(expression.charAt(i));
                    i++;
                }
                tokens.add(operand.toString());
            } else {
                System.out.println("INVALID CHARACTER: " + ch);
                return new ArrayList<>();
            }
        }

        return tokens;
    }

    // CONVERTS INFIX TO POSTFIX
    public static String infixToPostfix(String expression) {
        List<String> tokens = tokenize(expression);
        Stack<String> stack = new Stack<>();
        List<String> output = new ArrayList<>();

        for (String token : tokens) {
            if (isOperand(token)) {
                output.add(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    output.add(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() &&
                       !stack.peek().equals("(") &&
                       precedence(stack.peek()) >= precedence(token)) {
                    output.add(stack.pop());
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }

        return String.join(" ", output);
    }

    // CONVERTS INFIX TO PREFIX
    public static String infixToPrefix(String expression) {
        List<String> tokens = tokenize(expression);
        Collections.reverse(tokens);

        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).equals("(")) {
                tokens.set(i, ")");
            } else if (tokens.get(i).equals(")")) {
                tokens.set(i, "(");
            }
        }

        String reversedExpression = String.join(" ", tokens);
        String postfix = infixToPostfix(reversedExpression);

        String[] postfixTokens = postfix.split(" ");
        List<String> prefixList = Arrays.asList(postfixTokens);
        Collections.reverse(prefixList);

        return String.join(" ", prefixList);
    }

    // MAIN PROGRAM
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("ENTER INFIX EXPRESSION: ");
        String expression = sc.nextLine();

        System.out.println("INFIX EXPRESSION  : " + expression);
        System.out.println("POSTFIX EXPRESSION: " + infixToPostfix(expression));
        System.out.println("PREFIX EXPRESSION : " + infixToPrefix(expression));

        sc.close();
    }
}
