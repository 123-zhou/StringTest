package com.zhoufangjun.processor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Character replacement implementation class
 *
 * @author zhoufangjun
 */
public class ReplacementProcessor implements CharProcessor {
    @Override
    public String process(String input) {
        /**
         * Implementation logic:
         *   Use regular expressions to match 3+ consecutive identical characters
         *   Replace them in a loop until no matches are found
         */
        String regex = "([a-z])\\1{2,}";
        String temp = input;
        while (true) {
            Matcher matcher = Pattern.compile(regex).matcher(temp);
            if (!matcher.find()) break;

            char original = matcher.group().charAt(0);
            // If the character is 'a', replace with null character (ASCII 0),
            // otherwise replace with previous letter (ASCII code minus 1)
            char replacement = (original == 'a') ? '\0' : (char) (original - 1);
            // Convert null character to empty string, other characters to string form.
            temp = matcher.replaceFirst(replacement == '\0' ? "" : String.valueOf(replacement));
        }
        return temp;
    }
}
