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
        String t1 = Arrays.toString(s1arr);
        String t2 = Arrays.toString(s2arr);
        int l = 0, r = s1.length() - 1;
        while (r < s2.length() - 1) {
            if (t1.equals(t2)) {
                return true;
            }
            s2arr[s2.charAt(l) - 'a']--;
            l++;
            r++;
            s2arr[s2.charAt(r) - 'a']++;
            t2 = Arrays.toString(s2arr);
        }
        return t1.equals(t2);
    }
}
