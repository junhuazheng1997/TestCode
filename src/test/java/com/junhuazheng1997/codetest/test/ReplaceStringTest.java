package com.junhuazheng1997.codetest.test;

import com.junhuazheng1997.codetest.solution.ReplaceString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReplaceStringTest {

    @Test
    public void testReplaceString_RegularInput() {
        Assertions.assertEquals("d", ReplaceString.solution("abcccbad"));
        Assertions.assertEquals("de", ReplaceString.solution("aabbbaaacccdddde"));
        Assertions.assertEquals("acd", ReplaceString.solution("abbbaacd"));
    }

    @Test
    public void testReplaceString_EmptyInput() {
        Assertions.assertEquals("", ReplaceString.solution(""));
    }

    @Test
    public void testReplaceString_NoRemovalNeeded() {
        Assertions.assertEquals("abcde", ReplaceString.solution("abcde"));
    }

    @Test
    public void testReplaceString_ComplexCases() {
        Assertions.assertEquals("", ReplaceString.solution("aaabbbddd"));
        Assertions.assertEquals("", ReplaceString.solution("aaabbbaaa"));
        Assertions.assertEquals("", ReplaceString.solution("aaa"));
    }

}
