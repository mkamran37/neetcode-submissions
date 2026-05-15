class Solution {
    public boolean isAnagram(String s, String t) {
        String s1 = convert(s);
        String t1 = convert(t);
        return s1.equals(t1);
    }

    private String convert(String s) {
        int[] charsS = new int[26];
        for(char c: s.toCharArray()) {
            charsS[c - 'a']++;
        }
        return Arrays.toString(charsS);
    }
}
