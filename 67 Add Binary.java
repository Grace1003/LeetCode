Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".


public class Solution {
    public String addBinary(String a, String b) {
        String str = "";
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        for(; i >= 0 && j >= 0; i--, j--){
            int sum = (a.charAt(i) - '0') +(b.charAt(j) - '0') + carry;
            carry = sum / 2;   
            str = sum % 2 + str;
        }
        
        if(i < 0 && j >= 0){
            for(; j >= 0; j--){
                int sum = (b.charAt(j) - '0') + carry;
                carry = sum / 2;
                str = sum % 2 + str;
            }
        }else if(j < 0 && i >= 0){
            for(; i >= 0; i--){
                int sum = (a.charAt(i) - '0') + carry;
                carry = sum / 2;
                str = sum % 2 + str;
            }
        }
        
        return (carry == 0) ? str : carry + str;
    }
}

我的思路：先merge至一个字符串结束，再merge另一个字符串剩下部分。
九章思路：先用length()判断哪个字符串短，对短的这部分merge两个字符串，再处理长的字符串。