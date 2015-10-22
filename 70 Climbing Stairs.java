// You are climbing a stair case. It takes n steps to reach to the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

public class Solution {
    public int climbStairs(int n) {
        if(n <= 1){
            return n;
        }
        
        int[] solution = new int[n];
        solution[0] = 1;
        solution[1] = 1;   // 初始状态是两个值，都要赋值
        for(int i = 1; i < n; i++){   
            if(i - 1 >= 0){
                solution[i] += solution[i - 1];
            }
            if(i - 2 >= 0){
                solution[i] += solution[i - 2];
            }
        }
        return solution[n - 1];
    }
}

// 下一步的走法数量是上一步和上上步走法数量的和。
// 只返回了数组的一个值，因此可以优化，空间复杂度可以优化到O(1)。用两个变量标记上一步和上上步的走法数量，类似斐波拉契数列的优化。

public class Solution {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        
        int current = 0;
        int last = 2;
        int lastlast = 1;
        for(int i = 2; i < n; i++){  // 从第三步开始（代码更简洁）
            current = last + lastlast;
            lastlast = last;
            last = current;
        }
        return current;
    }
}

// 起始值为1、1或者1、2均可，分别对应for循环从第二、三步开始