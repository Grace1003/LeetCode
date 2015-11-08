Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null){
            return false;
        }
        
        int len = nums.length;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < len; i++){
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}

简单题。
注意用HashSet。

HashSet：继承于Set接口，不允许有重复的元素。
主要方法：add(Object)，addAll(Collection)，remove(object)，removeAll(Collection)，size()，iterator()，
        toArray()，clear()，isEmpty()，contain(object)，containAll(Collection)
Set集合在用Add()方法添加一个新项时，首先会调用equals(Object o)来比较新项和已有的某项是否相等。
