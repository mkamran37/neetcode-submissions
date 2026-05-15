class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0, maxLength = 0;
        while (r < s.length()) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l++));
            }
            set.add(s.charAt(r));
            maxLength = Math.max(maxLength, set.size());
            r++;
        }
        return maxLength;
    }
}
