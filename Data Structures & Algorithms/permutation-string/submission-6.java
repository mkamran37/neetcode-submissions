class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1 == null || s2 == null || s2.length() < s1.length()) {
            return false;
        }
        int window = s1.length();
        s1 = convert(s1);
        int l = 0, r = window;
        while (r <= s2.length()) {
            String tmp = convert(s2.substring(l, r));
            if (tmp.equals(s1)) {
                return true;
            }
            l++;
            r++;
        }
        return false;
    }

    private String convert(String s) {
        int[] result = new int[26];
        for (char c: s.toCharArray()) {
            result[c - 'a']++;
        }
        return Arrays.toString(result);
    }
}
