// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
class Solution {
    // tc -> n, sc-> k(atmost k+1 space used by hashmap)
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        
        int start = 0, end = 0, count = 0;
        int maxLength = 0;
        
        while(end < s.length()){
            char cEnd = s.charAt(end);
            
            freqMap.put(cEnd, freqMap.getOrDefault(cEnd, 0)+1);
            if(freqMap.get(cEnd)==1) count++;
            
            end++;
            
            while(count > k){
                char cStart = s.charAt(start);
                
                if(freqMap.get(cStart)==1) count--;
                freqMap.put(cStart, freqMap.get(cStart)-1);
                
                start++;
            }
            
            maxLength = Math.max(maxLength, end-start);
        }
        
        return maxLength;
    }
}
