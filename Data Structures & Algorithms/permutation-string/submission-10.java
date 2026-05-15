class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int[] s1count = new int[26];
        int[] s2count = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            s1count[s1.charAt(i) - 'a']++;
            s2count[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for(int i = 0; i < s1count.length; i++) {
            if (s1count[i] == s2count[i]) {
                matches++;
            }
        }
        int l = 0;
        for(int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) {
                return true;
            }
            s2count[s2.charAt(r) - 'a']++;
            if (s1count[s2.charAt(r) - 'a'] == s2count[s2.charAt(r) - 'a']) {
                matches++;
            } else if (s1count[s2.charAt(r) - 'a'] + 1 == s2count[s2.charAt(r) - 'a']) {
                matches--;
            }
            s2count[s2.charAt(l) - 'a']--;
            if (s1count[s2.charAt(l) - 'a'] == s2count[s2.charAt(l) - 'a']) {
                matches++;
            } else if (s1count[s2.charAt(l) - 'a'] - 1 == s2count[s2.charAt(l) - 'a']) {
                matches--;
            }
            l++;
        }
        return matches == 26;
    }
}
