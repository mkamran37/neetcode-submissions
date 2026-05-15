class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int max = 1;
        int l = 0, r = 1;
        while (l < r && r < s.length()) {
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(l));
            while (r < s.length() && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }
            max = Math.max(max, set.size());
            l++;
            r = l + 1;
        }
        return max;
    }
}
