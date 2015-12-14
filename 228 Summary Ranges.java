
/*
Given a sorted integer array without duplicates, return the summary of its ranges.
For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < nums.length; i++){
            int min = nums[i];
            while(i + 1 < nums.length && nums[i + 1] == nums[i] + 1){
                i++;
            }
            int max = nums[i];
            if(max > min){
                list.add(min +"->" + max);
            }else{
                list.add(min + "");
            }
        }
        return list;
    }
}

注意临界case，一次过！