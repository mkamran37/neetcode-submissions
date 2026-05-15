class Solution {
    public boolean isAnagram(String s, String t) {
        int[] chars = new int[27];
        for (char c: s.toCharArray()) {
            chars[c-'a'] += 1;
        }
        for (char c: t.toCharArray()) {
            if (chars[c - 'a'] == 0) {
                return false;
            }
            chars[c-'a'] -= 1;
        }

        for(int i: chars) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
