class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int matches = 0;
        int[] s1c = new int[26], s2c = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1c[s1.charAt(i) - 'a']++;
            s2c[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (s1c[i] == s2c[i]) {
                matches++;
            }
        }
        int l = 0;
        for(int i = s1.length(); i < s2.length(); i++) {
            if (matches == 26) {
                return true;
            }
            s2c[s2.charAt(i) - 'a']++;
            int rc = s2.charAt(i) - 'a';
            if (s1c[rc] == s2c[rc]) {
                matches++;
            } else if (s1c[rc] == s2c[rc] - 1) {
                matches--;
            }
            s2c[s2.charAt(l) - 'a']--;
            int lc = s2.charAt(l) - 'a';
            if (s1c[lc] == s2c[lc]) {
                matches++;
            } else if (s1c[lc] == s2c[lc] + 1) {
                matches--;
            }
            l++;
        }
        return matches == 26;
    }
}
