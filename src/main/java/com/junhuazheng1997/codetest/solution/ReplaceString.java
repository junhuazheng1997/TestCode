package com.junhuazheng1997.codetest.solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReplaceString {

    // abcccbad -> abbbad -> aaad -> d
    public static String solution(String s) {
        Deque<CharCount> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (!deque.isEmpty() && deque.peekLast().ch == currentChar) {
                if (++deque.peekLast().count >= 3) {
                    deque.removeLast();
                    boolean isReplace = true;
                    while (isReplace && !deque.isEmpty()) {
                        if (deque.peekLast().count >= 2) {
                            deque.removeLast();
                        } else {
                            deque.peekLast().count++;
                            isReplace = false;
                        }
                    }
                }
            } else {
                deque.offerLast(new CharCount(currentChar, 1));
            }
        }

        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty()) {
            CharCount cc = deque.pollFirst();
            for (int i = 0; i < cc.count; i++) {
                result.append(cc.ch);
            }
        }

        return result.toString();
    }


    static class CharCount {
        char ch;
        int count;

        private CharCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

}
