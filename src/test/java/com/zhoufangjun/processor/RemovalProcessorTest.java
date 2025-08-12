package com.zhoufangjun.processor;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Character removal Test class
 *
 * @author zhoufangjun
 */
public class RemovalProcessorTest {
    private final CharProcessor processor = new RemovalProcessor();

    @Test
    public void testBasicRemoval() {
        assertEquals("d", processor.process("aabcccbbad"));
    }

    @Test
    public void testMultipleRounds() {
        assertEquals("d", processor.process("aabcccbbad"));
        assertEquals("", processor.process("aaabbb"));
    }

    @Test
    public void testEdgeCases() {
        assertEquals("", processor.process("aaa"));
        assertEquals("b", processor.process("aaab"));
        assertEquals("b", processor.process("baaa"));
    }

    @Test
    public void testNoChanges() {
        assertEquals("abc", processor.process("abc"));
        assertEquals("aabbcc", processor.process("aabbcc"));
    }

    @Test
    public void testLongSequence() {
        assertEquals("", processor.process("aaaaaaaaaa"));
        assertEquals("x", processor.process("bbbaaax"));
    }

}
