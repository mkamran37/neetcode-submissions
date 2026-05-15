class Solution {
    public boolean isAnagram(String s, String t) {
        String s1 = convertToArray(s);
        String t1 = convertToArray(t);

        return s1.equals(t1);
    }

    private String convertToArray(String s) {
        int[] tmp = new int[26];
        for(char c: s.toCharArray()) {
            tmp[c - 'a']++;
        }
        return Arrays.toString(tmp);
    }
}
