class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        int l = 0, r = 0, result = Integer.MIN_VALUE;
        while (r < s.length()) {
            int count = map.getOrDefault(s.charAt(r), 0);
            count+=1;
            maxFreq = Math.max(maxFreq, count);
            map.put(s.charAt(r), count);
            while((r - l + 1) - maxFreq > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            result = Math.max((r - l + 1), result);
            r++;
        }
        return result;
    }
}
