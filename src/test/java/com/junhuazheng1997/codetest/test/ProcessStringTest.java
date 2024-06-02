package com.junhuazheng1997.codetest.test;

import com.junhuazheng1997.codetest.solution.ProcessString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProcessStringTest {

    @Test
    public void testProcessString_RegularInput() {
        Assertions.assertEquals("aade", ProcessString.solution("aabbbaaacccdddde"));
        Assertions.assertEquals("cd", ProcessString.solution("abbbaacd"));
    }

    @Test
    public void testProcessString_EmptyInput() {
        Assertions.assertEquals("", ProcessString.solution(""));
    }

    @Test
    public void testProcessString_NoRemovalNeeded() {
        Assertions.assertEquals("abcde", ProcessString.solution("abcde"));
    }

    @Test
    public void testProcessString_ComplexCases() {
        Assertions.assertEquals("", ProcessString.solution("aaabbbddd"));
        Assertions.assertEquals("", ProcessString.solution("aaabbbaaa"));
        Assertions.assertEquals("", ProcessString.solution("aaa"));
    }


}
