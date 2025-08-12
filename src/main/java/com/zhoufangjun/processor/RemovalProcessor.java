package com.zhoufangjun.processor;

/**
 * Character removal implementation class
 *
 * @author zhoufangjun
 */
public class RemovalProcessor implements CharProcessor {
    @Override
    public String process(String input) {
        /**
         * Implementation logic:
         *   Use regular expressions to match 3+ consecutive identical characters
         *   Remove them in a loop until no matches are found
         */
            String regex = "([a-z])\\1{2,}";
            String temp = input;
            while (true) {
                String reduced = temp.replaceAll(regex, "");
                if (reduced.equals(temp)) break;
                temp = reduced;
            }
            return temp;
    }
}
