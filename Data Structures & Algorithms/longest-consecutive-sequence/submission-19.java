class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int num: nums) {
            set.add(num);
        }
        for (int num: nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int count = 0, start = num;
            while (set.contains(start++)) {
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
