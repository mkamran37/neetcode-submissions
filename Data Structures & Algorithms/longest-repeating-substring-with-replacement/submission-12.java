class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxf = 0, l = 0, result = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxf = Math.max(maxf, map.get(c));

            // If the window is invalid, shrink it from the left
            while (r - l + 1 - maxf > k) {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);
                l++;
            }

            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}
