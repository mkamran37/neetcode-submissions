class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, maxf = 0, result = 0;
        while (r < s.length()) {
            int freq = map.getOrDefault(s.charAt(r), 0) + 1;
            map.put(s.charAt(r), freq);
            maxf = Math.max(maxf, freq);
            while ((r - l + 1) - maxf > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            result = Math.max(result, r-l+1);
            r++;
        }
        return result;
    }
}
