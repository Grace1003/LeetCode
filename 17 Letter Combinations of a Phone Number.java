Given a digit string, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below. (略)

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

排列组合问题，回溯法。

public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};  // 简单的数据结构搞定数字与字母的对应关系
        ArrayList<String> list = new ArrayList<String>();
        
        if(digits.length() == 0){
            return list;
        }
        
        StringBuffer solution = new StringBuffer();   // 防止stack overflow exception
        findCombinations(letters, digits, 0, solution, list);
        
        return list;
    }
    
    public void findCombinations(String[] letters, String digits, int k, StringBuffer solution, ArrayList<String> list){
        if(k == digits.length()){
            list.add(solution.toString());
            return;
        }
            
        // 要用k去固定每次调用函数时，可选的letter是对应的那几个字母
        // 这里不能用两个for循环，否则会出现“23”->"aa"的情况。递归到第几层需要与第几个数字对应。
        int digit = digits.charAt(k) - '0';
        String letter = letters[digit];
        for(int j = 0; j <letter.length(); j++){
            solution.append(letter.charAt(j));
            findCombinations(letters, digits, k+1, solution, list);
            solution.deleteCharAt(solution.length() - 1);
        }
    }
}