package com.leetcode;

public class WordReverse {
    public static void main(String[] args) {
        WordReverse wordReverse = new WordReverse();

        System.out.println(wordReverse.reverseSentence("Returns a string that is a substring of this string. The substring begins at the specified beginIndex and extends to the character at index endIndex - 1. Thus the length of the substring is endIndex-beginIndex."));
    }

    private String reverseSentence(String str) {
        StringBuffer reverseStr = new StringBuffer();
        int startIndex  = str.length()-1;
        int endIndex    = -1;

        for(int i = str.length()-1; i >=0; i-- ) {
            if(str.charAt(i) == ' ') {
                endIndex = i;
                reverseStr.append(str.substring(endIndex, startIndex+1).trim());
                reverseStr.append(" ");
                startIndex = i;
            }

            if(i == 0) {
                reverseStr.append(str.substring(i, startIndex+1).trim());
            }
        }

        return reverseStr.toString();
    }
}
