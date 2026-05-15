class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, max = 0;
        while (r < s.length()) {
            Set<Character> set = new HashSet<>();
            while (r < s.length() && !set.contains(s.charAt(r))) set.add(s.charAt(r++));
            max = Math.max(max, set.size());
            l = l + 1;
            r = l;
        }
        return max;
    }
}
