class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, maxCount = 0, result= 0;
        while (r < s.length()) {
            int count = map.getOrDefault(s.charAt(r), 0);
            count++;
            map.put(s.charAt(r), count);
            maxCount = Math.max(count, maxCount);
            
            while ((r - l + 1) - maxCount > k) {
                count = map.get(s.charAt(l));
                count--;
                map.put(s.charAt(l), count);
                l++;
            }
            result = Math.max(result, (r - l + 1));
            r++;
        }
        return result;
    }
}
