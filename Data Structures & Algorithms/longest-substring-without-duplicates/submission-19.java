class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0;
        while (r < s.length()) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                result = Math.max(result, r - l + 1);
                r++;
            }
            while (r< s.length() && l < r && set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
        }
        return result;
    }
}
