Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.

public class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < len; i++){
            if(map.containsKey(nums[i])){
                int freq = map.get(nums[i]);
                if(freq >= len / 2){
                    return nums[i];
                }
                map.put(nums[i], freq + 1);
            }else{
                map.put(nums[i], 1);
            }
        }
        
        return 0;
    }
}

有更优解，不用HashMap