class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int matches = 0;
        int[] arr1 = new int[26], arr2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr1[i] == arr2[i]) {
                matches++;
            }
        }
        int l = 0;
        for (int i = s1.length(); i < s2.length(); i++) {
            if (matches == 26) {
                break;
            }
            arr2[s2.charAt(i) - 'a']++;
            int rc = arr2[s2.charAt(i) - 'a'];
            if (rc == arr1[s2.charAt(i) - 'a']) {
                matches++; 
            } else if (rc - 1 == arr1[s2.charAt(i) - 'a']) {
                matches--;
            }
            arr2[s2.charAt(l) - 'a']--;
            int lc = arr2[s2.charAt(l) - 'a'];
            if (lc == arr1[s2.charAt(l) - 'a']) {
                matches++; 
            } else if (lc + 1 == arr1[s2.charAt(l) - 'a']) {
                matches--;
            }
            l++;
        }
        return matches == 26;
        
    }
}
