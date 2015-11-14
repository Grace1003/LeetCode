Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
注意：[1,2]只能出现一次，不管这个2是集合中的哪个2；[1,2,2]是合理的答案。

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> subset = new ArrayList<Integer>();
        helper(0, nums, subset, list);
        return list;
    }
    
    public void helper(int start, int[] nums, List<Integer> subset, List<List<Integer>> list){
        list.add(new ArrayList<Integer>(subset));
        for(int i = start; i < nums.length; i++){
        	// 除了start点外，重复出现的点只考虑一次，否则就出现重复答案。
        	// 注意start点，因为[1,2,2]也是合理的答案，能且只能出现一次。
            if(i != start && nums[i] == nums[i - 1]){  
                continue;
            }
            subset.add(nums[i]);
            helper(i + 1, nums, subset, list);
            subset.remove(subset.size() - 1);
        }
    }
}