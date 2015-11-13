Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

全排列问题

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        findPermutation(nums, solution, list);
        return list;
    }
    
    // 给定的permute()返回一个list的list，说明辅助递归函数中是用list装任意一个solution的 =》在add()之后需要remove()
    public void findPermutation(int[] nums, List<Integer> solution, List<List<Integer>> list){
        if(solution.size() == nums.length){
            //list.add(solution);  => 跑程序只能得到一堆空集。。
            list.add(new ArrayList<Integer>(solution));    // 必须要new一个arraylist单独存solution
            // 只add一个solution是不可以的，因为list不是原始数据类型，这里只add是对于地址的处理。
            // 后续的remove也会更新这个arraylist的内容

            return;
        }
        
        for(int num : nums){
            if(!solution.contains(num)){
                solution.add(num);
                findPermutation(nums, solution, list);
                solution.remove(solution.size() - 1);  
                // 用list记录每个可能的答案，而不是String等，则需要remove。
                // 如果是用String等记录，则不需要删除在左子结点add的内容。
            }
        }
    }
    
}