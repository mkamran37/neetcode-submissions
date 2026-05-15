class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0, result = 0;
        while (r < s.length()) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            result = Math.max(result, r - l + 1);
            r++;
        }
        return result;
    }
}
