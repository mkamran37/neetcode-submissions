class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxl = 0, maxf = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            Character c = s.charAt(r);
            int f = map.getOrDefault(c, 0) + 1;
            map.put(c, f);
            maxf = Math.max(maxf, f);
            if ((r - l + 1) - maxf <= k) {
                maxl = Math.max(maxl, (r - l + 1));
            } else {
                while (r - l + 1 - maxf > k) {
                    map.put(s.charAt(l), map.get(s.charAt(l++)) - 1);
                }
            }
            r++;
        }
        return maxl;
    }
}
