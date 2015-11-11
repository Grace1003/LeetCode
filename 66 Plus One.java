Given a non-negative number represented as an array of digits, plus one to the number.
The digits are stored such that the most significant digit is at the head of the list.

public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;   // 此题重点，carry不是0，也不能在for循环里面加一
        int len = digits.length;
        for(int i = len - 1; i >= 0 ; i--){
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        
        if(carry == 0){
            return digits;
        }
        
        int[] res = new int[len + 1];
        res[0] = carry;
        for(int i = 0; i < len; i++){
            res[i + 1] = digits[i];
        }
        return res;
    }
}