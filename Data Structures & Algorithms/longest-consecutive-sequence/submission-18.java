class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // O(n)
        for (int num: nums) {
            set.add(num);
        }
        int maxCount = 0;
        // O(n)
        for (int num: nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int count = 0;
            while(set.contains(num++)) count++;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
