import java.util.*;

class expANDeval{
    private static final char ADD = '+', SUBTRACT = '-';
    private static final char MULTIPLY = '*', DIVIDE = '/';
    private static final char POWER ='^';


// Private methods:

    private boolean isOperator(char c) { // Tell whether c is an operator.

        return c == '+'  ||  c == '-'  ||  c == '*'  ||  c == '/'  ||  c == '^'
                || c=='(' || c==')';

    }//end isOperator



    private boolean isSpace(char c) {  // Tell whether c is a space.

        return (c == ' ');

    }//end isSpace


    private boolean lowerPrecedence(char op1, char op2) {
        // Tell whether op1 has lower precedence than op2, where op1 is an
        // operator on the left and op2 is an operator on the right.
        // op1 and op2 are assumed to be operator characters (+,-,*,/,^).

        switch (op1) {

            case '+':
            case '-':
                return !(op2=='+' || op2=='-') ;

            case '*':
            case '/':
                return op2=='^' || op2=='(';

            case '^':
                return op2=='(';

            case '(': return true;

            default:  // (shouldn't happen)
                return false;
        }

    } // end lowerPrecedence


// Method to convert infix to postfix:

    public String convertToPostfix(String infix) {
        Stack operatorStack = new Stack();
        char c;
        StringTokenizer parser = new StringTokenizer(infix,"+-*/^() ",true);
        StringBuffer postfix = new StringBuffer(infix.length());
        while (parser.hasMoreTokens()) {
            String token = parser.nextToken();
            c = token.charAt(0);
            if ( (token.length() == 1) && isOperator(c) ) {
                while (!operatorStack.empty() &&
                        !lowerPrecedence(((String)operatorStack.peek()).charAt(0), c))

                    postfix.append(" ").append((String)operatorStack.pop());
                if (c==')') {
                    String operator = (String)operatorStack.pop();
                    while (operator.charAt(0)!='(') {
                        postfix.append(" ").append(operator);
                        operator = (String)operatorStack.pop();
                    }
                }
                else
                    operatorStack.push(token);
            }
            else if ( (token.length() == 1) && isSpace(c) ) {
            }
            else {
                postfix.append(" ").append(token);
            }
        }
        while (!operatorStack.empty())
            postfix.append(" ").append((String)operatorStack.pop());

        return postfix.toString();
    }

    public double evaluate(String expr) {
        //   assert (isValid(expr));

        Stack stack = new Stack();
        double op1, op2, result = 0;
        String token;
        StringTokenizer tokenizer = new StringTokenizer(expr);

        while (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();
            char c = token.charAt(0);
            if (isOperator(c)) {
                op2 = ((Double) stack.pop()).doubleValue();
                op1 = ((Double) stack.pop()).doubleValue();
                result = evalSingleOp(token.charAt(0), op1, op2);
                stack.push(new Double(result));
            }
            else
                stack.push(new Double(Double.parseDouble(token)));
        }

        result = ((Double) stack.pop()).doubleValue();
        return result;
    }

    private double evalSingleOp(char operation, double op1, double op2) {
        double result = 0;

        switch (operation) {
            case ADD :
                result = op1 + op2;
                break;
            case SUBTRACT :
                result = op1 - op2;
                break;
            case MULTIPLY :
                result = op1 * op2;
                break;
            case DIVIDE :
                result = op1 / op2;
                break;
            case POWER :
                result = (double) Math.pow(op1,op2);
        }

        return result;
    }



}