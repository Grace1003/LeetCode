Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.

Note:
1. All numbers (including target) will be positive integers.
2. Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
3. The solution set must not contain duplicate combinations.

For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: [7] [2, 2, 3] 

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        helper(list, solution, candidates, 0, target, 0);
        return list;
    }
    
    // 用sum标记solution里面数字之和
    public void helper(List<List<Integer>> list, List<Integer> solution, int[] candidates, int sum, int target, int start){
        if(sum > target){
            return;
        }
        if(sum == target){
            list.add(new ArrayList<Integer>(solution));
            return;
        }
        
        for(int i = start; i < candidates.length; i++){
            solution.add(candidates[i]);
            helper(list, solution, candidates, sum + candidates[i], target, i);
            solution.remove(solution.size() - 1);
        }
        
    }
}