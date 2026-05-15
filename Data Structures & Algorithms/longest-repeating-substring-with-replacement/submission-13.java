class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxf = 0, l = 0, r = 0, result = 0;
        while (r < s.length()) {
            Character c = s.charAt(r);
            int f = map.getOrDefault(c, 0) + 1;
            map.put(c, f);
            maxf = Math.max(maxf, f);
            if (r - l + 1 - maxf > k) {
                map.put(s.charAt(l), map.get(s.charAt(l++)) - 1);
            }
            result = Math.max(result, r - l + 1);
            r++;
        }
        return result;
    }
}
