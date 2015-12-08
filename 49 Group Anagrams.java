Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list elements must follow the lexicographic order.
All inputs will be in lower-case.

找出每一组同字母异构的单词，按照字母顺序排列。



public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null){
            return null;
        }
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Arrays.sort(strs);  //为了inner list elements也能按照字母顺序排列

        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);   //把异构的单词统一化
            String newStr = String.valueOf(chars);   //记住这个方法！！把char数组合并成String
            if(map.containsKey(newStr)){
                map.get(newStr).add(str);
            }else{
                List<String> anagramlist = new ArrayList<String>();
                anagramlist.add(str);
                map.put(newStr, anagramlist);
            }
        }
        
        // 把map的value集合转化为list
        List<List<String>> list = new ArrayList<List<String>>(map.values());  
        return list;
    }
}