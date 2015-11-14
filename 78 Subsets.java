Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:
[ [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]


public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> subset = new ArrayList<Integer>();
        helper(0, nums, subset, list);
        return list;
    }
    
    public void helper(int start, int[] nums, List<Integer> subset, List<List<Integer>> list){
        list.add(new ArrayList<Integer>(subset));
        // if(subset.size() == nums.length) return;   
        // 下面的for循环已经可以控制solution里数字个数不超过nums[]长度了，所以if判断可以省略
        
        for(int i = start; i < nums.length; i++){
            subset.add(nums[i]);
            helper(i + 1, nums, subset, list);
            subset.remove(subset.size() - 1);
        }
    }
}