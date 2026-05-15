class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,r=0,maxf=Integer.MIN_VALUE,result=Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        while(r < s.length()) {
            int count = map.getOrDefault(s.charAt(r), 0) + 1;
            maxf = Math.max(count, maxf);
            map.put(s.charAt(r), count);
            while((r-l+1) - maxf > k) {
                map.put(s.charAt(l), map.get(s.charAt(l++)) - 1);
            }
            result = Math.max((r-l+1), result);
            r++;
        }
        return result;
    }
}
