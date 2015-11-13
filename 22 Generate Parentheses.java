Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:
"((()))", "(()())", "(())()", "()(())", "()()()"

回溯法，当模版背熟

public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<String>();
        helper(n, n, "", list);
        return list;
    }
    
    public void helper(int left, int right, String solution, List<String> list){   //不需要带入总量n，可以让要控制的变量初识设为n，减到0即停止
        
    	// 回溯法本质还是递归，要构建一棵树，从根节点的空集到叶子节点的不同答案集。
    	// 叶子节点是所有排列组合的答案，而不只有符合要求的答案。

        if(left < 0 || right < 0 || left > right){   // 忽略并停止不符合要求的答案
            return;
        }
        
        if(left == 0 && right == 0){   // 及时处理和记录符合要求的答案
            list.add(solution);
            return;
        }
        
        helper(left - 1, right, solution + "(", list);  // 向左下递归
        helper(left, right - 1, solution + ")", list);  // 向右下递归

        // 这里不需要remove左右括号，因为这里不是用的list，而是String！！
        // 在每一层的时候，只有深度h个字符在solution中。
        // 从左子树返回到父节点，再遍历到右子树时，左子树的solution对右子树没有影响。
        
    }
}