class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for(char c: s.toCharArray()) {
            arr[c-'a']++;
        }
        int[] arr2 = new int[26];
        for(char c: t.toCharArray()) {
            arr2[c-'a']++;
        }
        return Arrays.toString(arr).equals(Arrays.toString(arr2));
    }
}
