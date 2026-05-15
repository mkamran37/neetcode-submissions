class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, max = 0, maxf = 0;
        while (r < s.length()) {
            int f = map.getOrDefault(s.charAt(r), 0) + 1;
            map.put(s.charAt(r), f);
            maxf = Math.max(maxf, f);
            if (r - l + 1 - maxf <= k) {
                max = Math.max(max, r - l + 1);
            }
            while (r - l + 1 - maxf > k) {
                map.put(s.charAt(l), map.get(s.charAt(l++)) - 1);
            }
            r++;
        }
        return max;

    }
}
