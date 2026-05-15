class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || (s.length() != t.length())) {
            return false;
        }
        int[] charray = new int[128];
        for(char c: s.toCharArray()) {
            charray[c] += 1;
        }
        for(char c: t.toCharArray()) {
            charray[c] -= 1;
        }
        for(int i: charray) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
