class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = generateArray(s);
        int[] arr2 = generateArray(t);
        return Arrays.toString(arr).equals(Arrays.toString(arr2));
    }

    private int[] generateArray(String s) {
        int[] arr = new int[26];
        for(char c: s.toCharArray()) {
            arr[c-'a']++;
        }
        return arr;
    }
}
