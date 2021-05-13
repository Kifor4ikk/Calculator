package BackEnd;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import static java.lang.Math.pow;

public class Calculate {

    private static StringBuilder formula = new StringBuilder(" ");
    private static StringBuilder solution = new StringBuilder();
    private static String [] results = {" ", " " , " " , " " , " " , " "};

    /**
     *
     * @param symbols symbol which should be added to end of formula line
     */
    public static void addSymbols(String symbols){
        if(formula.length() < 75) {
            if (symbols == "+" || symbols == "-" || symbols == "/" || symbols == "*" || symbols == "%") {
                if (formula.charAt(formula.length() - 1) == '+' ||
                        formula.charAt(formula.length() - 1) == '-' ||
                        formula.charAt(formula.length() - 1) == '/' ||
                        formula.charAt(formula.length() - 1) == '*' ||
                        formula.charAt(formula.length() - 1) == '^' ||
                        formula.charAt(formula.length() - 1) == '%') {

                    formula.deleteCharAt(formula.length() - 1);
                    formula.append(symbols);
                } else {
                    formula.append(symbols);
                }
            } else {
                formula.append(symbols);
            }
        }
    }

    /**
     * Delete Last symbol of formula
     */
    public static void deleteLastSymbol(){
        if(formula.length() >= 1) {
            formula.deleteCharAt(formula.length()-1);
        }
    }

    /**
     * Clear formula
     */
    public static void clearFormula(){
        System.out.println("Deleted " + formula.length() + " symbols");
        formula.delete(0 , formula.length());
    }

    /**
     *
     * @return formula in string formate
     */
    public static String getFormula(){
        return formula.toString();
    }

    /**
     *
     * @return string Solution of math formula
     */
    public static String getSolution() {
        solution.delete(0 , solution.length());
        boolean isFindSolution = false;
        for (int i = 6; i < 400; i++) {
            if (eval(formula.toString()) >= pow(10, i) && eval(formula.toString()) < pow(10, i + 1)) {
                solution.append(String.format("%.2f",(eval(formula.toString()))/pow(10,i)));
                solution.append(("*10^" + i));
                isFindSolution = true;
                System.out.println(i + " - " +  pow(10,i) + " - HERE - " + solution);
                break;
            }
        }
        if(!isFindSolution){
            solution.append(String.format("%.2f", eval(formula.toString())));
            System.out.println(solution);
        }

        results[5] = results[4];
        results[4] = results[3];
        results[3] = results[2];
        results[2] = results[1];
        results[1] = results[0];
        results[0] = solution.toString();

        return solution.toString();
    }

    /**
     *
     * @param pos
     * @return result by pos
     */
    public static String getResultByPos(int pos){
        if(pos <= 4 && pos >= 0){
            return results[pos];
        } else{
            return " ";
        }
    }

    /**
     *
     * @param x input double
     * @return factorial x
     */
    public static long factorial(double x){
        long fact = 1;
        for (int i = 2; i <= x; i++) {
            fact = fact * i;
        }
        return fact;
    }

    /**
     *
     * @param str input string with formula
     * @return answer
     */
    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z' || ch == '!') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    solution.append("ERROR");
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = pow(x, parseFactor()); // exponentiation
                return x;
            }
        }.parse();
    }
}
