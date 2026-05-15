class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int result = 0;
        for(int num: nums) {
            int start = num;
            int count = 0;
            while(set.contains(start)) {
                start++;
                count++;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
