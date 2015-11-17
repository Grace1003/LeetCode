Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].


public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
        ArrayList<Integer> solution = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        helper(nums, visited, solution, list);
        return list;
    }
    
    public void helper(int[] nums, boolean[] visited, ArrayList<Integer> solution, ArrayList<List<Integer>> list){
        if(solution.size() == nums.length){
            list.add(new ArrayList<Integer>(solution));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited[i] || (i != 0 && !visited[i - 1] && nums[i] == nums[i - 1])){  // 难点！！
                continue;
            }
            visited[i] = true;
            solution.add(nums[i]);
            helper(nums, visited, solution, list);
            solution.remove(solution.size() - 1);
            visited[i] = false;
        }
    }
}

有重复数的排列问题，已经不是模版答案就能轻易解决的。
start适用于不重复的数。
这里要用一个数组visited[]来记录是否已经取过了。