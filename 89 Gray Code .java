The gray code is a binary numeral system where two successive values differ in only one bit.
Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2

格雷码，利用递归的规则来构造：
1. 1位格雷码有两个码字(0,1)
2. (n+1)位格雷码中的前一半码字等于n位格雷码的码字，按顺序书写，加前缀0
3. (n+1)位格雷码中的后一半码字等于n位格雷码的码字，按逆序书写，加前缀1


public class Solution {
    public List<Integer> grayCode(int n) {
        if(n <= 1){    // 包含了n=0和n=1的情况，比分开判断要简洁
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i <= n; i++){
                list.add(i);
            }
            return list;
        }
        
        List<Integer> list = grayCode(n - 1);
        List<Integer> reverseList = reverse(list);
        int size = list.size();
        for(int i = 0; i < size; i++){
            int num = reverseList.get(i);
            list.add((1 << (n - 1)) + num);  // 用位运算加前缀1
        }
        
        return list;
    }
    
    public List<Integer> reverse(List<Integer> list){
        List<Integer> reverseList = new ArrayList<Integer>();
        for(int i = list.size() - 1; i >=0; i--){
            reverseList.add(list.get(i));
        }
        return reverseList;
    }
}