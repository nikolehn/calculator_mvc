package edu.uned.web.nikole.models;

public class Calculator {

    protected static double memory = 0.0d;

    /*
     ******************
     * BASIC OPS
     ******************
     */
    public static Double add(Double op1, Double op2) {
        return op1 + op2;
    }

    public static Double subtract(Double op1, Double op2) {
        return op1 - op2;
    }

    public static Double multiply(Double op1, Double op2) {
        return op1 * op2;
    }

    public static Double divide(Double op1, Double op2) {
        return op1 / op2;
    }

    /*
     ******************
     * ADVANCED OPS
     ******************
     */
    public static Double sqrt(Double op1) {
        return Math.sqrt(op1);
    }

    public static Double pow(Double op1, Double op2) {
        return Math.pow(op1, op2);
    }

    /*
     ******************
     * TRIGONOMETRY
     ******************
     */
    public static Double sin(Double op1) {
        return Math.sin(op1);
    }

    public static Double cos(Double op1) {
        return Math.cos(op1);
    }

    public static Double tan(Double op1) {
        return Math.tan(op1);
    }

    /*
     ******************
     * EXPONENTIATION
     ******************
     */
    public static Double log(Double op1) {
        return Math.log(op1);
    }

    public static Double exp(Double op1) {
        return Math.exp(op1);
    }

    /*
     ******************
     * MEMORY
     ******************
     */
    public static Double mread() {
        return Calculator.memory;
    }

    public static Double madd(Double op1) {
        Calculator.memory += op1;
        return Calculator.memory;
    }

    public static Double msubtract(Double op1) {
        Calculator.memory -= op1;
        return Calculator.memory;
    }

    public static Double mclear() {
        Calculator.memory = 0.0d;
        return Calculator.memory;
    }
}
