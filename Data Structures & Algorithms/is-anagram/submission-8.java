class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] anagram = new int[26];
        for(char c: s.toCharArray()) {
            anagram[c - 'a']++;
        }
        for(char c: t.toCharArray()) {
            anagram[c-'a']--;
        }
        for(int num: anagram) {
            if(num != 0) {
                return false;
            }
        }
        return true;
    }
}
