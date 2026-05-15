class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, maxl = 0;
        Set<Character> set = new HashSet<>();
        while ( r < s.length() ) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l++));
            }
            set.add(s.charAt(r));
            maxl = Math.max(maxl, set.size());
            r++;
        }
        return maxl;
    }
}
