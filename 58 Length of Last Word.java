Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.



public class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = 0; i < s.length(); i++){
            if(Character.isLetter(s.charAt(i))){
                len++;
            }else if(Character.isWhitespace(s.charAt(i)) && i != s.length() - 1 && Character.isLetter(s.charAt(i + 1))){
                len = 0;   // 当前字符为空格，并且下一个字符存在且不为空格的时候，才重置len变量
            }
        }
        
        return len;
    }
}


考虑特殊情况：空格开头，或空格结尾。