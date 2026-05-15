class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int[] s1arr = new int[26];
        int[] s2arr = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1arr[s1.charAt(i) - 'a']++;
            s2arr[s2.charAt(i) - 'a']++;
        }
        int l = 0, r = s1.length() - 1;
        while (r < s2.length() - 1) {
            if (Arrays.equals(s1arr, s2arr)) {
                return true;
            }
            s2arr[s2.charAt(l) - 'a']--;
            l++;
            r++;
            s2arr[s2.charAt(r) - 'a']++;
        }
        return Arrays.equals(s1arr, s2arr);
    }
}
