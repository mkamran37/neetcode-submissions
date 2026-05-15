class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, max = Integer.MIN_VALUE, maxFreq = 0;
        while (r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));
            while ((r - l + 1) - maxFreq > k) {
                //do something
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            } 
                max = Math.max(max, (r - l + 1));
            
            r++;
        }
        return max;
    }
}
