package dev.simonverhoeven.java26demo.preview.language;

import java.security.SecureRandom;

/// JEP 530 - Primitive Types in Patterns, instanceof, and switch (Fourth Preview)

public class PrimitiveTypes {
    record ExamResults(int score){}

    // primitives are now supported pattern matching,
    // boolean, float, double and long are now also supported in switches
    public String determineGrade(ExamResults examResults) {
        return switch (examResults.score) {
            case int i when i >= 90 -> "A";
            case int i when i >= 80 -> "B";
            case int i when i >= 70 -> "C";
            case int i when i >= 60 -> "D";
            case int i when i >= 50 -> "E";
            case int i -> "Failed with a score of " + examResults.score;
        };
    }

    // We can now pattern match using primitive types, which makes switching to type patterns easier as well
    public void patterns() {
        int number = new SecureRandom().nextInt();

        if (number instanceof int num) {
            System.out.println(num);
        }
    }

//    public void unconditionalPattern(int number) {
//        switch (number) {
//            case int _      -> {}  // unconditional pattern
//            case float _    -> {}  // error: dominated
//        }
//    }
}
