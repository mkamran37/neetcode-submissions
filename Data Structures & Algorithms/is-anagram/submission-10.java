class Solution {
    public boolean isAnagram(String s, String t) {
        int[] s1 = new int[26];
        int[] s2 = new int[26];
        for (char c: s.toCharArray()) {
            s1[c - 'a']++;
        }
        for (char c: t.toCharArray()) {
            s2[c - 'a']++;
        }
        String t1 = Arrays.toString(s1);
        String t2 = Arrays.toString(s2);
        return t1.equals(t2);
    }
}
