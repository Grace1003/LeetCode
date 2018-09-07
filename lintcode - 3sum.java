/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
*/

3sum, 4sum, 3sum close等题的模版

public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.length == 0){
            return list;
        }
        
        int len = numbers.length;
        Arrays.sort(numbers);
        for (int i = 0; i < len - 2; i++){
        	// 跳过重复数
            if (i != 0 && numbers[i] == numbers[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right){
                int sum = numbers[i] + numbers[left] + numbers[right];
                if (sum == 0){
                    ArrayList<Integer> sublist = new ArrayList<Integer>();
                    sublist.add(numbers[i]);
                    sublist.add(numbers[left]);
                    sublist.add(numbers[right]);
                    list.add(sublist);
                    left++;
                    right--;
                } else if (sum < 0){
                    left++;
                } else {
                    right--;
                }
                // 跳过重复数字，注意条件
                while (left != i + 1 && left < right && numbers[left] == numbers[left - 1]){
                    left++;
                }
                while (right != len - 1 && left < right && numbers[right] == numbers[right + 1]){
                    right--;
                }
            }
        }
        return list;
    }
}