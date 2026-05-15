class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (r < s.length()) {
            while(set.contains(s.charAt(r))) set.remove(s.charAt(l++));
            set.add(s.charAt(r));
            max = Math.max(set.size(), max);
            r++;
        }
        return max;
    }
}
