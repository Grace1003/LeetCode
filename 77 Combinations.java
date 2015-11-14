Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

在1到n的数字里面找出k个数的所有不重复的组合

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        helper(n, k, solution, resList);
        return resList;
    }
    
    public void helper(int n, int k, List<Integer> solution, List<List<Integer>> list){
        if(solution.size() == k){
            list.add(new ArrayList<Integer>(solution));
            return;
        }
        
        for(int i = 1; i <= n; i++){
            if(!solution.contains(i)){  // 可用九章的解法优化
                if(solution.size() == 0 || i > solution.get(solution.size() - 1)){
                    solution.add(i);
                    helper(n, k, solution, list);
                    solution.remove(solution.size() - 1);
                }
            }
        }
    }
}

九章答案：大致相同，用start标记了solution中可选的新增的数
http://www.jiuzhang.com/solutions/combinations/

