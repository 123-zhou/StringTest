package com.zhoufangjun.processor;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Character replacement Test class
 *
 * @author zhoufangjun
 */
public class ReplacementProcessorTest {
    private final CharProcessor processor = new ReplacementProcessor();

    @Test
    public void testBasicReplacement() {
        assertEquals("d", processor.process("abcccbad"));
    }

    @Test
    public void testCharacterReplacement() {
        assertEquals("b", processor.process("ccc"));
        assertEquals("a", processor.process("bbb"));
        assertEquals("", processor.process("aaa"));
    }

    @Test
    public void testMultiStepProcessing() {
        assertEquals("ceb", processor.process("dddeccc"));
        assertEquals("ad", processor.process("bbcccd"));
    }

    @Test
    public void testMixedCases() {
        assertEquals("ac", processor.process("bbbc"));
        assertEquals("ce", processor.process("dddde"));
    }

    @Test
    public void testNoChanges() {
        assertEquals("abc", processor.process("abc"));
        assertEquals("aabbcc", processor.process("aabbcc"));
    }
}
