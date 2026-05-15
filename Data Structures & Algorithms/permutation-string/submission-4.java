class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Set<String> set = new HashSet<>();
        String arr = arrayfied(s1);
        System.out.println(arr);
        set.add(arr);
        int window = s1.length();
        int start = 0;
        while (start + window <= s2.length()) {
            String tmp = arrayfied(s2.substring(start, start+window));
            System.out.println(tmp);
            if (set.contains(tmp)) {
                return true;
            }
            start += 1;
        }
        return false;
    }

    private String arrayfied(String s) {
        int[] source = new int[26];
        for(char c: s.toCharArray()) {
            source[c - 'a']++;
        }
        return Arrays.toString(source);
    }
}
