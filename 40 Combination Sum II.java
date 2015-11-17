Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 


public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
        ArrayList<Integer> solution = new ArrayList<Integer>();
        
        Arrays.sort(candidates);
        helper(candidates, 0, target, solution, list);
        
        return list;
    }
    
    public void helper(int[] candidates, int start, int target, List<Integer> solution, List<List<Integer>> list){
        if(target < 0){
            return;
        }else if(target == 0){
            list.add(new ArrayList<Integer>(solution));
            return;
        }
        
        for(int i = start; i < candidates.length; i++){
            if(i != start && candidates[i] == candidates[i - 1]){
                continue;
            }
            
            solution.add(candidates[i]);
            helper(candidates, i + 1, target - candidates[i], solution, list);   // 易错！不是start+1，而是i+1
            solution.remove(solution.size() - 1);
        }
        
    }
}


Tips:
candidate numbers里有重复数字 => if(i != start && candidates[i] == candidates[i - 1]) continue;