package com.java8.defaultmethod;

public class FormulaTest {

    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        System.out.println(formula.sqrt(2));
        System.out.println(formula.calculate(2));
    }

}
