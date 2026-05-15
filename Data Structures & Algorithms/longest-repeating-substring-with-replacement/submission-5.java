class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxFreq = Integer.MIN_VALUE, result = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        while(r < s.length()) {
            int count = map.getOrDefault(s.charAt(r), 0) + 1;
            map.put(s.charAt(r), count);
            maxFreq = Math.max(maxFreq, count);
            while ((r - l + 1) - maxFreq > k) {
                map.put(s.charAt(l), map.get(s.charAt(l++)) - 1);
            }
            result = Math.max(result, (r - l + 1));
            r++;
        }
        return result;
    }
}
