class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1count = new int[26];
        int[] s2count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1count[s1.charAt(i) - 'a']++;
            s2count[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1count[i] == s2count[i]) matches++;
        }
        int l = 0;
        for(int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) return true;
            int rc = s2.charAt(r) - 'a'; 
            s2count[rc]++;
            if (s1count[rc] == s2count[rc]) {
                matches++;
            } else if (s1count[rc] == s2count[rc] - 1) {
                matches--;
            }
            int lc = s2.charAt(l) - 'a';
            s2count[lc]--;
            if (s1count[lc] == s2count[lc]) {
                matches++;
            } else if (s1count[lc] == s2count[lc] + 1) {
                matches--;
            }
            l++;
        }
        return matches == 26;
    }
}
