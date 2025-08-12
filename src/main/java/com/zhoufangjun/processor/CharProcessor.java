package com.zhoufangjun.processor;
/**
 * Strategy Pattern Interface
 *
 * @author zhoufangjun
 */
@FunctionalInterface
public interface CharProcessor {
    String process(String input);
}
