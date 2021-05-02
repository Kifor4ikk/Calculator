package BackEnd;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculate {

    private static StringBuilder formula = new StringBuilder(" ");
    private static StringBuilder solution = new StringBuilder();
    private static String [] results = new String[5];
    private static int resultCounter = 0;

    public static void addSymbols(String symbols){
        formula.append(symbols);
    }

    public static void deleteLastSymbol(){
        if(formula.length() >= 1) {
            formula.deleteCharAt(formula.length()-1);
        }
    }

    public static void clearFormula(){
        formula.delete(0 , formula.length());
    }
    public static String getFormula(){
        return formula.toString();
    }

    public static String getSolution() {
        solution.delete(0 , solution.length()-1);
        //solution.append(eval(formula.toString()));
        System.out.println(solution.toString());
        /*
        if(resultCounter == 4){
            resultCounter = 0;
            results[1] = results[0];
            results[2] = results[1];
            results[2] = results[3];
            results[3] = results[4];
        }
        //results[resultCounter] = solution.toString();
        resultCounter++;
        */
        return solution.toString();
    }
/*
    public static String getResultByPos(int pos){
        if(pos <= 4 && pos >= 0){
            return results[pos];
        }
        else{
            return " ";
        }
    }
*/

    /*
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
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
    */
}
