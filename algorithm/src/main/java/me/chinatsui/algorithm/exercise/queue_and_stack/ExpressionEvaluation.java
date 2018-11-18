package me.chinatsui.algorithm.exercise.queue_and_stack;

import me.chinatsui.algorithm.review.stack.ArrayStack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionEvaluation {

    /*
     Test Cases:
     "10 + 2 * 6"            ---> 22
     "100 * 2 + 12"          ---> 212
     "100 * ( 2 + 12 )"      ---> 1400
     "100 * ( 2 + 12 + 14) / 14" ---> 200
     "100 * ( 1 + 2 * 3 ) / 2" ---> 300
     */

    private static ArrayStack<Double> operandStack = new ArrayStack(); // 1, 2, 13, 5
    private static ArrayStack<Character> operatorStack = new ArrayStack(); // (+((++)

    public static void main(String[] args) {
        String expression = "( 10 * ( 1.5 + 1 * 5 * 6) )";
        System.out.println(evaluate(expression));
    }

    private static Double evaluate(String expression) {
        expression = normalize(expression);
        System.out.println(expression);
        char[] tokens = expression.toCharArray();

        for (int i = 0; i < tokens.length; i++) {
            if (isSpace(tokens[i])) {
                continue;
            }

            if (isNumericChar(tokens[i]) || isDot(tokens[i])) {
                StringBuffer buffer = new StringBuffer();
                buffer.append(tokens[i]);

                while (i++ < tokens.length && (isNumericChar(tokens[i]) || isDot(tokens[i]))) {
                    buffer.append(tokens[i]);
                }
                i--;
                operandStack.push(Double.valueOf(buffer.toString()));
            } else if (isRightParenthesis(tokens[i])) {
                ArrayStack<Double> tempOperands = new ArrayStack();
                ArrayStack<Character> tempOperators = new ArrayStack();

                Double operand = operandStack.pop();
                char operator = operatorStack.pop();

                while (!operatorStack.isEmpty() && !isLeftParenthesis(operator)) {
                    tempOperands.push(operand);
                    tempOperators.push(operator);
                    operand = operandStack.pop();
                    operator = operatorStack.pop();
                }

                tempOperands.push(operand);

                Double o1 = tempOperands.pop();
                Double o2 = tempOperands.pop();
                char op = tempOperators.pop();

                if ('+' == op) {
                    operandStack.push(o1 + o2);
                } else if ('-' == op) {
                    operandStack.push(o1 - o2);
                } else if ('*' == op) {
                    operandStack.push(o1 * o2);
                } else if ('/' == op) {
                    operandStack.push(o1 / o2);
                }
            } else {
                if (isSpace(tokens[i])) {
                    continue;
                }
                operatorStack.push(tokens[i]);
            }

        }

        return operandStack.pop();
    }

    /*
     * Normalize input expression to make sure any precedence is enclosed by "()"
     */
    private static String normalize(String expression) {
        Pattern p = Pattern.compile("[0-9]+\\s*[*/]\\s*[0-9]+");
        Matcher m = p.matcher(expression);
        while (m.find()) {
            String group = m.group();
            expression = expression.replace(group, "(" + group + ")");
        }

//        Pattern p1 = Pattern.compile("[0-9]+\\s*[+\\-*/]\\s*\\(.*\\)");
//        Matcher m1 = p1.matcher(expression);
//        while (m1.find()) {
//            String group = m1.group();
//            expression = expression.replace(group, "(" + group + ")");
//        }
//
//        Pattern p2 = Pattern.compile("\\(.*\\)\\s*[+\\-*/]\\s*[0-9]+");
//        Matcher m2 = p2.matcher(expression);
//        while (m2.find()) {
//            String group = m2.group();
//            expression = expression.replace(group, "(" + group + ")");
//        }

        return expression;
    }

    private static boolean isSpace(char token) {
        return ' ' == token;
    }

    private static boolean isNumericChar(char token) {
        return '0' <= token && token <= '9';
    }

    private static boolean isDot(char token) {
        return '.' == token;
    }

    private static boolean isRightParenthesis(char token) {
        return ')' == token;
    }

    private static boolean isLeftParenthesis(char token) {
        return '(' == token;
    }

}
