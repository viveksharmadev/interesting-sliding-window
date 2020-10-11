// https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
   // tc -> n, sc-> n
   public int lengthOfLongestSubstring(String s) {
       Map<Character, Integer> freqMap = new HashMap<>();
       int start = 0, end = 0, count = 0, maxLength = 0;
       while(end < s.length()){
           char cEnd = s.charAt(end);
           freqMap.put(cEnd, freqMap.getOrDefault(cEnd,0)+1);
           if(freqMap.get(cEnd)>1)
               count++;
           end++;
           while(count==1){
               char cStart = s.charAt(start);
               if(freqMap.get(cStart)>1) count--;
               freqMap.put(cStart, freqMap.getOrDefault(cStart,0)-1);
               start++;
           }
           if(maxLength<end-start){
               maxLength = end-start;
           }
       }
       return maxLength;
   }
}

class Solution {
   public int lengthOfLongestSubstring(String s) {
       // tc -> n, sc-> n
       int maxLength = 0;int i=0, j=0;
       Set<Character> set = new HashSet<>();
       while(i<s.length()){
           if(set.contains(s.charAt(i))){
               set.remove(s.charAt(j++));               
           }else{
                set.add(s.charAt(i++));
                maxLength = Math.max(maxLength, i-j);
           }
       }
       return maxLength;
   }
}
// Using set.size() to calculate maxLength
class Solution {
    // tc -> n, sc-> n
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        
        int maxLength = 0;
        int j = 0;
        int i = 0;
        
        while(i < s.length()){            
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i++));
                maxLength = Math.max(maxLength, set.size());
            }else{
                set.remove(s.charAt(j++));  
            }            
        }
        
        return maxLength;
    }
}

Optimized Code:
class Solution {
   // tc -> n, sc-> n
   public int lengthOfLongestSubstring(String s) {
       Map<Character, Integer> indxMap = new HashMap<>();
       int i=0, j=0, maxLength = 0;
       while(i<s.length()){
           if(indxMap.containsKey(s.charAt(i))){
               j = Math.max(j, indxMap.get(s.charAt(i))+1);
           }
           indxMap.put(s.charAt(i), i++);
           maxLength = Math.max(maxLength, i-j);
       }
       return maxLength;
   }
}
