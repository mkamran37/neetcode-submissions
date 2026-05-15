class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charray = new int[26];
        for(Character c: s.toCharArray()) {
            charray[c-'a']++;
        }
        for(Character c: t.toCharArray()) {
            charray[c-'a']--;
        }
        for(int i: charray) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
