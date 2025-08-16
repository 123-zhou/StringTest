package com.zhoufangjun.processor;

/**
 * Character replacement implementation class
 *
 * @author zhoufangjun
 */
public class ReplacementProcessor implements CharProcessor {
    @Override
    public String process(String input) {
        // Return directly if input is null or too short to have 3 consecutive characters
        if (input == null || input.length() < 3) {
            return input;
        }

        StringBuilder sb = new StringBuilder(input);
        // Current scanning position index (starts from beginning of string)
        int i = 0;

        // Main loop: traverse the entire string
        while (i < sb.length()) {
            // Set start position of consecutive characters
            int j = i;
            // Get current character at position i
            char currentChar = sb.charAt(i);

            // Find end position of consecutive identical characters
            while (j < sb.length() && sb.charAt(j) == currentChar) {
                j++;
            }

            // Calculate length of consecutive identical characters
            int consecutiveLength = j - i;

            // Process segments with length ≥ 3
            if (consecutiveLength >= 3) {
                // Calculate previous character (ASCII value - 1)
                char prevChar = (char) (currentChar - 1);

                // Check if previous character is valid (within 'a'-'z' range)
                if (prevChar >= 'a') {
                    // replace segment with single previous char
                    sb.replace(i, j, String.valueOf(prevChar));
                } else {
                    // 'a' has no valid previous character,Delete
                    sb.delete(i, j);
                }
                // Backtrack 2 positions to cover potential new sequences，Avoid scanning from the beginning
                i = Math.max(0, i - 2);
            } else {
                // No consecutive segment found: jump to end of current segment
                i = j;
            }
        }

        // Return final processed string
        return sb.toString();
    }
}


