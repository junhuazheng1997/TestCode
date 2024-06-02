package com.junhuazheng1997.codetest.solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReplaceString {

    public static String solution(String s) {

        // Use a deque to keep track of characters and their counts
        Deque<CharCount> deque = new ArrayDeque<>();

        s.chars().mapToObj(c -> (char) c).forEach(currentChar -> {
            if (!deque.isEmpty() && deque.peekLast().ch == currentChar) {
                // Increment the count of the last character in the deque
                if (++deque.peekLast().count >= 3) {
                    // If the count reaches 3 or more, remove the last character from the deque
                    deque.removeLast();
                    boolean isReplace = true;

                    // Continue removing characters from the deque if their count is 2 or more
                    while (isReplace && !deque.isEmpty()) {
                        if (deque.peekLast().count >= 2) {
                            deque.removeLast();
                        } else {
                            // If the count of the last character is less than 2, increment its count and stop replacing
                            deque.peekLast().count++;
                            isReplace = false;
                        }
                    }
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
