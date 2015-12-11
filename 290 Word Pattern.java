/*

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

*/

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null && str == null){
            return true;
        }else if(pattern == null || str == null){
            return false;
        }
        
        String[] words = str.split(" ");
        if(pattern.length() != words.length){
            return false;
        }
        
        HashMap<Character, String> map = new HashMap<Character, String>();
        for(int i = 0; i < pattern.length(); i++){
            char letter = pattern.charAt(i);
            if(!map.containsKey(letter)){
                if(map.containsValue(words[i])){   // 不要漏掉处理pattern = "abba", str = "dog dog dog dog"的情况
                    return false;
                }
                map.put(letter, words[i]);
            }else if(!words[i].equals(map.get(letter))){
                return false;
            }
        }
        
        return true;
        
    }
}