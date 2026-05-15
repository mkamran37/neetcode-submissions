class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        return findCount(s).equals(findCount(t));
        
    }

    private String findCount(String s) {
        int[] sc = new int[26];
        for (char c: s.toCharArray()) {
            sc[c - 'a']++;
        }
        return Arrays.toString(sc);
    }
}
