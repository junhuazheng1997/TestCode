package com.junhuazheng1997.codetest.solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class ProcessString {

    public static String solution(String s) {

        // Use a deque to keep track of characters and their counts
        Deque<CharCount> deque = new ArrayDeque<>();

        s.chars().forEachOrdered(c -> {
            char currentChar = (char) c;
            if (!deque.isEmpty() && deque.peekLast().ch == currentChar) {
                // Increment the count of the last character in the deque
                if (++deque.peekLast().count >= 3) {
                    // If the count reaches 3 or more, remove the last character from the deque
                    deque.removeLast();
                }
            } else {
                // If the deque is empty or the last character is different, add the current character to the deque
                deque.offerLast(new CharCount(currentChar, 1));
            }
        });

        // Build the result string from the characters and their counts in the deque
        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty()) {
            CharCount cc = deque.pollFirst();
            for (int i = 0; i < cc.count; i++) {
                result.append(cc.ch);
            }
        }

        return result.toString();
    }

    // Class to keep track of characters and their counts
    static class CharCount {
        char ch;
        int count;

        private CharCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }


}
