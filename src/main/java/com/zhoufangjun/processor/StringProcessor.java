package com.zhoufangjun.processor;


public class StringProcessor {
    public static String process(String input, CharProcessor processor) {
        return processor.process(input);
    }

    public static void main(String[] args) {
        String input = "aabcccbbad";
        System.out.println("=== Removal Processor ===");
        System.out.println("Input: " + input);
        System.out.println("Output: " + process(input, new RemovalProcessor()));

        System.out.println("\n=== Replacement Processor ===");
        input = "abcccbad";
        System.out.println("Input: " + input);
        System.out.println("Output: " + process(input, new ReplacementProcessor()));
    }
}
