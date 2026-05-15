class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1 == null || s2 == null || s2.length() < s1.length()) {
            return false;
        }
        int matches = 0, l = 0;
        int[] s1Char = new int[26];
        int[] s2Char = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            s1Char[s1.charAt(i) - 'a']++;
            s2Char[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (s1Char[i] == s2Char[i]) matches++;
        }
        for(int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) {
                return true;
            }
            int index = s2.charAt(r) - 'a';
            s2Char[index]++;
            if (s1Char[index] == s2Char[index]) {
                matches++;
            } else if (s1Char[index] + 1 == s2Char[index]) {
                matches--;
            }
            index = s2.charAt(l) - 'a';
            s2Char[index]--;
            if (s1Char[index] == s2Char[index]) {
                matches++;
            } else if (s1Char[index] - 1 == s2Char[index]) {
                matches--;
            }
            l++;
        }
        return matches == 26;
    }
}
