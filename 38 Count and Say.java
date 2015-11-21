The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.


public class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        
        StringBuffer res = new StringBuffer();
        String str = countAndSay(n - 1);
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            int count = 1;
            while(i + 1 < str.length() && str.charAt(i + 1) == c){  
                count++;
                i++;  // 注意这边最后一次i++后，i指向最后一个重复的数，所以最外层的for循环再次i++后，i正好指向第一个不同的数。
            }
            res.append(count);
            res.append(c);
        }
        
        return res.toString();
    }
}


这是递归的方法。
九章的思路：从第1个数开始迭代到第n个数，与递归的方向相反。