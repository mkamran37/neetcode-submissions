class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int l = 0, r = s1.length() - 1;
        s1 = converter(createArr(s1));
        while (r < s2.length()) {
            String s = converter(createArr(s2.substring(l, r+1)));
            if (s1.equals(s)) {
                return true;
            }
            l++;
            r++;
        }
        return false;
    }

    private int[] createArr(String s) {
        int[] s1a = new int[26];
        for (char c: s.toCharArray()) {
            s1a[c-'a']++;
        }
        return s1a;
    }

    private String converter(int[] arr) {
        return Arrays.toString(arr);
    }
}
