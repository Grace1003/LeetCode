Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
Ensure that numbers within the set are sorted in ascending order.


Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]

Example 2:
Input: k = 3, n = 9
Output:[[1,2,6], [1,3,5], [2,3,4]]

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        helper(k, n, 1, 0, solution, list);
        return list;
    }
    
    // 用start控制solution里添加不重复的数字，用sum控制solution里数字之和
    public void helper(int k, int n, int start, int sum, List<Integer> solution, List<List<Integer>> list){
        if(solution.size() > k || sum > n){
            return;
        }
        
        if(solution.size() == k && sum == n){
            list.add(new ArrayList<Integer>(solution));
            return;
        }
        
        for(int i = start; i <= 9; i++){
            solution.add(i);
            helper(k, n, i + 1, sum + i, solution, list);
            solution.remove(solution.size() - 1);
        }
    }
}