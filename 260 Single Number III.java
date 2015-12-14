/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:
Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

*/

public class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) +1);
            }else{
                map.put(nums[i], 1);
            }
        }
        
        int[] res = new int[2];  //从题中可分析出，返回array的长度为2
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){ //注意遍历HashMap写法
            int value = entry.getValue();
            if(value == 1 && i < 2){
                res[i] = entry.getKey();
                i++;  // 不要忘记i++
            }
        }
        
        return res;
    }
}