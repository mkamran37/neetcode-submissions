class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charsS = new int[26];
        int[] charsT = new int[26];
        for(char c: s.toCharArray()) {
            charsS[c - 'a']++;
        }
        for (char c: t.toCharArray()) {
            charsT[c - 'a']++;
        }
        String s1 = Arrays.toString(charsS);
        String t1 = Arrays.toString(charsT);
        return s1.equals(t1);
    }
}
